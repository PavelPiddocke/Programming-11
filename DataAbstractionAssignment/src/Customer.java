import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private int accountNumber;
    private ArrayList<Deposit> deposits;
    private ArrayList<Withdraw> withdraws;
    private double checkBalance;
    private double savingBalance;
    private double savingRate;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;


    Customer(){
        //create default constructor

        name = "blank";
        accountNumber = 0;
        checkBalance = 0;
        savingBalance = 0;

    }
    Customer(String name, int accountNumber, double checkDeposit, double savingDeposit){
        //constructor code here
        this.name = name;
        this.accountNumber = accountNumber;
        this.checkBalance = checkDeposit;
        this.savingBalance = savingDeposit;
        deposits = new ArrayList<>();
        withdraws = new ArrayList<>();

    }

    public double deposit(double amt, Date date, String account){

        // Requires : amount, account
        // Modifies : this.deposits
        // Effects  : adds values to the deposits array

        if (CHECKING.equals(account)) {
            Deposit d = new Deposit(amt, new Date(), account);
            deposits.add(d);
            checkBalance = checkBalance + amt;
            return amt;
        } else if (SAVING.equals(account)) {
            Deposit d = new Deposit(amt, new Date(), account);
            deposits.add(d);
            savingBalance = savingBalance + amt;
            return amt;
        }
        return 0;

    }
    public double withdraw(double amt, Date date, String account){
        // Requires : amount, account
        // Modifies : this.withdraws
        // Effects  : removes value from the withdraws array

        if (checkOverdraft(amt, account)) {
            if (CHECKING.equals(account)) {
                Withdraw d = new Withdraw(amt, new Date(), account);
                withdraws.add(d);
                checkBalance = checkBalance - amt;
                return amt;
            } else if (SAVING.equals(account)) {
                Withdraw d = new Withdraw(amt, new Date(), account);
                withdraws.add(d);
                savingBalance = savingBalance - amt;
                return amt;
            }
        }
        return 0;

    }

    private boolean checkOverdraft(double amt, String account){
        // Requires : amount, account
        // Modifies : nothing
        // Effects  : returns balances in different accounts

        double balance = 0;
        if (CHECKING.equals(account)) {
            balance = checkBalance - amt;
            return balance >= OVERDRAFT;
        } else if (SAVING.equals(account)) {
            balance = savingBalance - amt;
            return balance >= OVERDRAFT;
        }

        return false;

        }



    //do not modify
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }
    //do not modify
    public void displayWithdraws() {
        for (Withdraw w : withdraws) {
                System.out.println(w);
            }
        }

        public String toString () {
            return "Customer: " + this.name + " Account: " + accountNumber + " Savings Balance: " + savingBalance + " Checking Balance: " + checkBalance;
        }

    }
