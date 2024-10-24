import java.util.logging.Logger;
import com.example.EmailService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class EmailServiceTest {

    @Test
    public void testSendEmail() {
        Logger logger = Logger.getLogger("EmailServiceTest");

        Logger dummyLogger = mock(Logger.class);

        EmailService emailService = new EmailService(dummyLogger);
        emailService.sendEmail("rtr@dfg.com","sere@sfaf.de", "test", "test");
    }

    @Test
    public void testSendEmailWithSpy() {
        EmailService realEmailService = new EmailService();

        EmailService spyEmailService = spy(realEmailService);

        doReturn(false).when(spyEmailService).sendEmail(eq("invalid_email"), anyString(), anyString());

        boolean result1 = spyEmailService.sendEmail("valid@example.com", "Test Subject", "Test Body");
        assertTrue(result1);  // Expecting true for valid email

        boolean result2 = spyEmailService.sendEmail("invalid_email", "Test Subject", "Test Body");
        assertFalse(result2);  // Expecting false for invalid email

        verify(spyEmailService, times(1)).sendEmail("valid@example.com", "Test Subject", "Test Body");
        verify(spyEmailService, times(1)).sendEmail("invalid_email", "Test Subject", "Test Body");
    }
}
