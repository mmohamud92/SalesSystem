package sales;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PurchaseTest {

    @Test
    public void getValue_ProductWithPriceAndQuantity_ReturnsPriceTimesQuantity() {
        // Arrange
        Product product = new Product(200, 300);
        Purchase purchase = new Purchase(product, 3);
        
        // Act
        int purchaseValue = purchase.getValue();
        
        // Assert: value should be 200 + 200 + 200 + 60 + 60 + 60 = 780p
        assertEquals(780, purchaseValue, "Purchase value should be product price multiplied by quantity.");
    }
}
