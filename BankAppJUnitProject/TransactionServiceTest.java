import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TransactionServiceTest {
    private TransactionService service;
    private BankAccount account;

    @BeforeEach
    void setUp() {
        service = new TransactionService();
        account = new BankAccount("ACC101","John",1000);
    }

    @Test
    void testDepositToAccount() {
        assertTrue(service.depositToAccount(account,200));
        assertEquals(1200.0, account.getBalance());
    }

    @Test
    void testInvalidDeposit() {
        assertFalse(service.depositToAccount(account,-50));
    }

    @Test
    void testWithdrawFromAccount() {
        assertTrue(service.withdrawFromAccount(account,500));
        assertEquals(500.0, account.getBalance());
    }
}