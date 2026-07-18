import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {
    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount("ACC101","John",1000.0);
    }

    @AfterEach
    void tearDown() {
        account = null;
    }

    @Test
    void testDeposit() {
        account.deposit(500);
        assertEquals(1500.0, account.getBalance());
    }

    @Test
    void testWithdrawSuccess() {
        assertTrue(account.withdraw(300));
        assertEquals(700.0, account.getBalance());
    }

    @Test
    void testWithdrawFailure() {
        assertFalse(account.withdraw(1500));
        assertEquals(1000.0, account.getBalance());
    }
}