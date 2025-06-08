package sales;

/**
 * The Service class represents a service that can be purchased.
 * It implements the Saleable interface.
 */
public class Service implements Saleable {
	
	/** The price of this service in pennies. */
	private int price;
	
	/**
     * Constructs a Service with the specified price.
     * @param price the price in pennies
     */
	public Service(int price)
	{
		this.price = price;
	}

	/**
     * Returns the price of the service (in pennies).
     * @return the price in pennies
     */
	@Override
	public int getPrice() {
		return price;
	}
}
