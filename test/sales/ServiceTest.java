package sales;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceTest {

    @Test
    public void testServicePrice() {
        // Arrange
        Service service = new Service(500);
        
        // Act
        int servicePrice = service.getPrice();
        
        // Assert
        assertEquals(500, servicePrice, "Service price should be as initialized.");
    }
}
