package sales;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

	@ParameterizedTest
    @ValueSource(ints = { 0, 50, 99 })
    public void calculateDelivery_WeightUnder100g_ReturnsZero(int weight) {
        // Arrange
        Product product = new Product(500, weight);
        
        // Act
        int deliveryCost = product.calculateDelivery();
        
        // Assert
        assertEquals(0, deliveryCost, "Delivery cost should be 0 for weight below 100 grams.");
    }

	@ParameterizedTest
    @ValueSource(ints = { 100, 575, 1000 })
    public void calculateDelivery_Weight100To1000_Returns20PercentOfWeight(int weight) {
        // Arrange
        Product product = new Product(500, weight);
        int expected = (int) (weight * 0.20);
        
        // Act
        int deliveryCost = product.calculateDelivery();
        
        // Assert: Delivery cost should be 20% of the weight.
        assertEquals(expected, deliveryCost, "Delivery cost should be 20% of the weight.");
    }

	@ParameterizedTest
    @ValueSource(ints = { 1001, 3000, 99999 })
    public void calculateDelivery_WeightAbove1000_ReturnsBase200Plus10PercentOfExcess(int weight) {
        // Arrange
        Product product = new Product(500, weight);
        int extraWeight = weight - 1000;
        int expected = 200 + (int) (extraWeight * 0.10);
        
        // Act
        int deliveryCost = product.calculateDelivery();
        
        // Assert
        assertEquals(expected, deliveryCost, "Delivery cost should be 200 for the first 1000 + 10% of remaining weight for weight at least 1000 grams.");
    }
}
