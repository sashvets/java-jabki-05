import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void testAccount() {
        Account account = new Account();
        assertEquals(0.0, account.getBalance());

        account.deposit(100.0);
        assertEquals(100.0, account.getBalance());

        account.deposit(80.0);
        assertEquals(180.0, account.getBalance());

        account.withdraw(-100.0);
        assertEquals(180.0, account.getBalance());
    }


}