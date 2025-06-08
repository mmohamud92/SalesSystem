package sales;

/**
 * The Transaction class is an abstract representation of a transaction.
 * It contains a value (positive for purchases, negative for refunds).
 */
public abstract class Transaction {
	
	/** The value of this transaction in pennies. Positive for purchases, negative for refunds. */
	protected int value;
	
	/**
     * Constructs a Transaction with the specified value.
     * @param value the value of the transaction in pennies
     */
	public Transaction(int value) {
		this.value = value;
	}
	
	/**
     * Returns the value of the transaction in pennies.
     * @return the value in pennies
     */
	public int getValue() {
		return value;
	}
}
