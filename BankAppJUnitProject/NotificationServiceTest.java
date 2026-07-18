import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NotificationServiceTest {

    @Test
    void testNotifyDeposit() {
        NotificationService service = new NotificationService();
        assertEquals("Deposit of 500.0 made successfully for John",
                service.notifyDeposit("John",500));
    }

    @Test
    void testNotifyWithdrawal() {
        NotificationService service = new NotificationService();
        assertEquals("Withdrawal of 200.0 made successfully for John",
                service.notifyWithdrawal("John",200));
    }

    @Test
    void testNotifyInsufficientFunds() {
        NotificationService service = new NotificationService();
        assertEquals("Withdrawal failed due to insufficient funds for John",
                service.notifyInsufficientFunds("John"));
    }
}