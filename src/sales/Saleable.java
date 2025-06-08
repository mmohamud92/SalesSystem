package sales;

/**
 * The 'Saleable' interface represents anything that can be sold,
 * providing a method to retrieve its price in pennies.
 */
public interface Saleable {
	/**
     * Returns the price (in pennies) of this Saleable item.
     * @return the price in pennies
     */
	int getPrice();
}
