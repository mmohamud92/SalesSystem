package sales;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RefundTest {

	@ParameterizedTest
    @ValueSource(ints = { 0, 50, 99 })
    void getRefundValueAndReason_ReturnsNegativeAbsoluteValueAndOriginalReason(int amount) {
        // Arrange
		String reason = "Item returned";
        Refund refund = new Refund(amount, reason);
        
        // Act
        int refundValue = refund.getValue();
        String refundReason = refund.getReason();
        
        // Always negative absolute value
        int expectedValue = -Math.abs(amount);
        
        // Assert
        assertEquals(expectedValue, refundValue, "Refund value should always be negative.");
        assertEquals(reason, refundReason, "Refund reason should be correctly set.");
    }
}