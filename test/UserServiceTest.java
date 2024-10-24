import com.example.UserService;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class UserServiceTest {
    @Test
    public void testDeleteUser() {

        UserService userServiceSpy = spy(new UserService());

        doNothing().when(userServiceSpy).sendDeletionNotification(anyString()); // suppress method

        userServiceSpy.deleteUser("10405");

        verify(userServiceSpy, times(1)).deleteUser("10405");
        verify(userServiceSpy, times(1)).sendDeletionNotification("10405"); //called by did nothing
    }

}
