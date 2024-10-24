import com.example.PaymentService;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PaymentServiceTest {

    @Test
    public void testProcessPaymentWithMockedLogger() {

        Logger mockLogger = mock(Logger.class);

        PaymentService paymentService = new PaymentService();

        boolean result = paymentService.processPayment(1050, "1234567890123456", mockLogger);
        assertTrue(result);

        boolean invalidAmountResult = paymentService.processPayment(0.0, "1234567890123456", mockLogger);
        assertFalse(invalidAmountResult);

    }
}