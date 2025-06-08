package sales;

public class Refund extends Transaction {
	
	/** The reason for the refund. */
    private String reason;
	
	/**
     * Constructs a Refund object with a given value and reason.
     * If a positive value is passed in, it is negated automatically.
     * @param value the refund value in pennies (should be negative), but if positive is passed, it is converted to negative
     * @param reason the reason for the refund
     */
	public Refund(int value, String reason) {
		super(value < 0 ? value : -value);
		this.reason = reason;
	}
	
	/**
     * Returns the reason for this refund.
     * @return the refund reason
     */
    public String getReason() {
        return reason;
    }
}
