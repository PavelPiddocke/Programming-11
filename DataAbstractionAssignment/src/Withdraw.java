import java.util.Date;

public class Withdraw {
    private double amount;
    private Date date;
    private String account;

    //Constructor for withdraw - just assign the values
    Withdraw(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    public String toString(){
        //override toString to show deposit
        return "Withdrawal of: $" + amount + " Date: " + date + " from account: " + account;
    }
}
