import java.util.Date;
public class Bank {
    public static void main(String[] args) {

        //main class should probably have a dialogue to add customers but for this assignment we will just show it working by
        //adding a couple of customers, add a couple of deposits and withdrawls.
        //Add some customer object
        Customer PP = new Customer("Pavel Piddocke", 0001, 224, 50);
        Customer JV = new Customer("Jake Valino", 0002, 94, 33);

        //add deposits to customers in both savings and checking accounts
        PP.deposit(5, new Date(), Customer.SAVING);
        JV.deposit(23,new Date(), Customer.CHECKING);

        PP.withdraw(1, new Date(), Customer.SAVING);
        JV.withdraw(2,new Date(), Customer.CHECKING);

        //print results
        System.out.println(PP);
        PP.displayDeposits();
        PP.displayWithdraws();

        System.out.println(JV);
        JV.displayDeposits();
        JV.displayWithdraws();


    }
}

