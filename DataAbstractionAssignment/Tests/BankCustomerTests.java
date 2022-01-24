import org.junit.Before;
import org.junit.Test;
import java.util.Date;
import static org.junit.Assert.assertEquals;

public class BankCustomerTests {
    Customer customerTest;
    @Before
    public void setup() {
        customerTest = new Customer("Bob", 1234, 1000, 30);
    }

    @Test
    public void testDeposit() {
        // check that Checking or Savings has a balance
        System.out.println(customerTest);

        // add amount to checking and Savings
        customerTest.deposit(200, new Date(), Customer.CHECKING);
        customerTest.deposit(100, new Date(), Customer.SAVING);
        //checks that amounts have changed
        customerTest.displayDeposits();

        System.out.println(customerTest);
    }

    @Test
    public void testWithdraw() {
        // check that Checking or Savings has a balance

        System.out.println(customerTest);

        // add amount to checking and Savings
        customerTest.withdraw(200, new Date(), Customer.CHECKING);
        customerTest.withdraw(100, new Date(), Customer.SAVING);
        //checks that amounts have changed
        customerTest.displayWithdraws();

        System.out.println(customerTest);
    }


}