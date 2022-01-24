import java.util.Date;
public class Bank {
    public static void main(String[] args) {

        Customer PP = new Customer("Pavel Piddocke", 0001, 224, 50);
        Customer JV = new Customer("Jake Valino", 0002, 94, 33);

        PP.deposit(5, new Date(), Customer.SAVING);
        JV.deposit(23,new Date(), Customer.CHECKING);

        PP.withdraw(1, new Date(), Customer.SAVING);
        JV.withdraw(2,new Date(), Customer.CHECKING);

        System.out.println(PP);
        PP.displayDeposits();
        PP.displayWithdraws();

        System.out.println(JV);
        JV.displayDeposits();
        JV.displayWithdraws();


    }
}

