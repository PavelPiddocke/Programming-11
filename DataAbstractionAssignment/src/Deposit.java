import java.util.Date;

public class Deposit {
    private double amount;
    private Date date;
    private String account;

    //constructor - just assign the values
    Deposit(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    public String toString(){
        //override toString to show deposit
        return "Deposit of: $" + amount + " Date: " + date + " into account: " + account;
    }
}
