package sales;

/**
 * The Purchase class represents a purchase transaction for a specific Saleable item and quantity.
 */
public class Purchase extends Transaction {

	/** The item being purchased, which implements Saleable. */
    private Saleable item;
    
    /** The quantity of the item being purchased. */
    private int quantity;
	
    /**
     * Constructs a Purchase object given a Saleable item and a quantity.
     * The value is determined by multiplying the item's price by the quantity.
     * @param item the Saleable item being purchased
     * @param quantity the quantity of the item
     */
	public Purchase(Saleable item, int quantity) {
		super(calculateTotal(item, quantity)); // this calculates the total purchase value.
		this.item = item;
		this.quantity = quantity;
	}
	
	/**
     * Returns the Saleable item that is being purchased.
     * @return the Saleable item
     */
    public Saleable getItem() {
        return item;
    }
    
    /**
     * Returns the quantity of the item being purchased.
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }
    
    private static int calculateTotal(Saleable item, int qty) {
        int cost = item.getPrice() * qty;
        if (item instanceof Product) {
            Product p = (Product)item;
            cost += p.calculateDelivery() * qty;
        }
        return cost;
    }
}
