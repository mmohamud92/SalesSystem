package sales;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;

public class CustomerTest {
	private Customer customer;
    private Product product;
    private Service service;
    
    @BeforeEach
    public void setup() {
        // Arrange: create a fresh customer and sample items
        customer = new Customer();
        product = new Product(100, 200); // price=100p
        service = new Service(250);      // price=250p
    }

    @Test
    public void getTotal_NoTransactions_ReturnsZero() {
    	// Act & Arrange: No transactions added
        int total = customer.getTotal();
        
        // Assert
        assertEquals(0, total, "Total should be 0 when there are no transactions.");
    }

    @Test
    public void getTotal_WithPurchasesAndRefunds_ReturnsNetTotal() {
        // Arrange
        customer.transact(new Purchase(product, 2));  // 2 x 100p + 80p (delivery) = 280;
        customer.transact(new Purchase(service, 1));  // 1 x 250p = 250p
        customer.transact(new Refund(150, "Reason")); // -150p
        
        // Act
        int total = customer.getTotal();
        
        // Assert: 280 + 250 - 150 = 380p
        assertEquals(380, total, "Net total should be 380 pennies.");
    }
    
    @Test
    public void removeTransaction_DeletesEntry_AffectsTotal() {
        // Arrange
        Purchase p1 = new Purchase(product, 1); // 100p + 40p (delivery) = 140p
        Purchase p2 = new Purchase(service, 2); // 500p
        customer.transact(p1);
        customer.transact(p2);
        assertEquals(640, customer.getTotal());
        
        // Act
        customer.removeTransaction(0); // remove first transaction
        int total = customer.getTotal();
        
        // Assert
        assertEquals(500, total, "After removal, only remaining transaction's value should be counted.");
    }
    
    @Test
    public void clearTransactions_ResetsAllTransactionsAndTotal() {
        // Arrange
        customer.transact(new Purchase(product, 3)); // 3 x 100p = 300p
        assertTrue(customer.getTotal() > 0);
        // Act
        customer.clearTransactions();
        // Assert
        assertEquals(0, customer.getTransactions().size(), "Transaction list should be empty after clear.");
        assertEquals(0, customer.getTotal(), "Total should be zero after clearing transactions.");
    }
}
