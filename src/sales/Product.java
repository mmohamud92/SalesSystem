package sales;

/**
 * The Product class represents a tangible product that can be purchased.
 * It implements the Saleable interface, so it must provide a getPrice() method.
 */
public class Product implements Saleable {
	
	/** The price of this product in pennies. */
	private int price;
	/** The weight of this product in grams. */
	private int weight;
	
	/**
     * Constructs a Product with the specified price and weight.
     * @param price the price in pennies
     * @param weight the weight in grams
     */
	public Product(int price, int weight)
	{
		this.price = price;
		this.weight = weight;
	}
	
	/**
     * Returns the price of the product (in pennies).
     * @return the price in pennies
     */
	@Override
	public int getPrice() {
		return price;
	}
	
	/**
     * Calculates delivery cost based on weight:
     * <100g: 0; 100–999g: 20% of weight; >=1000g: 20% of first 1000g + 10% of remainder.
     * @return delivery cost in pennies
     */
    public int calculateDelivery() {
        if (weight < 100) return 0;
        if (weight < 1000) return (int)(0.2 * weight);
        int base = (int)(0.2 * 1000);
        int extra = (int)(0.1 * (weight - 1000));
        return base + extra;
    }
}
