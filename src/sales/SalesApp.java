package sales;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

/**
 * SalesApp provides a Swing-based GUI enabling a single-step: add a new item
 * (product or service) with details, immediately purchase with quantity,
 * and clear transactions for a new customer session.
 */

public class SalesApp {
    private Customer customer;
    private JFrame frame;
    private JTable table;
    private DefaultTableModel model;
    private JLabel lblTotal;

    private JTextField txtName, txtPrice, txtWeight, txtQuantity;
    private JRadioButton radProduct, radService;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SalesApp().initUI());
    }

    private void initUI() {
        customer = new Customer();
        frame = new JFrame("Sales System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1050, 500);
        frame.setLayout(new BorderLayout(10,10));

        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));
        top.setBorder(BorderFactory.createTitledBorder("Add & Purchase Item"));
        txtName = new JTextField(10);
        txtPrice = new JTextField(5);
        txtWeight = new JTextField(5);
        txtQuantity = new JTextField(3);
        radProduct = new JRadioButton("Product", true);
        radService = new JRadioButton("Service");
        ButtonGroup bg = new ButtonGroup();
        bg.add(radProduct); 
        bg.add(radService);
        radProduct.addActionListener(_ -> txtWeight.setEnabled(true));
        radService.addActionListener(_ -> txtWeight.setEnabled(false));
        JButton btnAddBuy = new JButton("Add & Purchase");
        btnAddBuy.addActionListener(_ -> addAndPurchase());
        top.add(new JLabel("Name:")); 
        top.add(txtName);
        top.add(radProduct); 
        top.add(radService);
        top.add(new JLabel("Price (pennies):")); 
        top.add(txtPrice);
        top.add(new JLabel("Weight (g):")); 
        top.add(txtWeight);
        top.add(new JLabel("Qty:")); 
        top.add(txtQuantity);
        top.add(btnAddBuy);

        String[] cols = {"Name","Price","Delivery","Quantity","Line Total"};
        model = new DefaultTableModel(cols, 0) {
            private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int col) { return false; }
        };
        table = new JTable(model);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBorder(BorderFactory.createTitledBorder("Transactions"));

        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnRefund = new JButton("Refund Selected");
        btnRefund.addActionListener(_ -> refundSelected());
        JButton btnNew = new JButton("New Customer");
        btnNew.addActionListener(_ -> newCustomer());
        lblTotal = new JLabel("Total: £0.00");
        bottom.add(btnRefund); bottom.add(btnNew); bottom.add(lblTotal);

        frame.add(top, BorderLayout.NORTH);
        frame.add(scroll, BorderLayout.CENTER);
        frame.add(bottom, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private void addAndPurchase() {
        try {
            String name = txtName.getText().trim();
            int price = Integer.parseInt(txtPrice.getText().trim());
            int qty = Integer.parseInt(txtQuantity.getText().trim());
            if (name.isEmpty() || qty < 1) throw new IllegalArgumentException("Invalid input");
            Saleable item;
            int delivery = 0;
            if (radProduct.isSelected()) {
                int w = Integer.parseInt(txtWeight.getText().trim());
                Product p = new Product(price, w);
                item = p;
                delivery = p.calculateDelivery() * qty;
            } else {
                item = new Service(price);
            }
            Purchase p = new Purchase(item, qty);
            customer.transact(p);
            int lineTotal = p.getValue();
            model.addRow(new Object[]{
                name,
                String.format("£%.2f", price/100.0),
                String.format("£%.2f", delivery/100.0),
                qty,
                String.format("£%.2f", lineTotal/100.0)
            });
            updateTotal();
            txtName.setText(""); txtPrice.setText(""); txtWeight.setText(""); txtQuantity.setText("");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void refundSelected() {
        int idx = table.getSelectedRow();
        if (idx < 0) {
            JOptionPane.showMessageDialog(frame, "Select a transaction to refund.", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        String val = (String) model.getValueAt(idx, 4);
        double amount = Double.parseDouble(val.replace("£", ""));
        int pennies = (int) Math.round(amount * 100);
        Refund r = new Refund(pennies, "Refund");
        customer.transact(r);
        model.addRow(new Object[]{
            "Refund",
            "",
            "",
            "",
            String.format("-£%.2f", amount)
        });
        updateTotal();
    }

    private void newCustomer() {
        customer.clearTransactions(); 
        model.setRowCount(0); 
        updateTotal();
    }

    private void updateTotal() {
        lblTotal.setText(String.format("Total: £%.2f", customer.getTotal()/100.0));
    }
}