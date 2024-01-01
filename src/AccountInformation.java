import java.util.*;

public class AccountInformation {
    private String fname;
    private String lname;
    //In case a non-integer number is put
    private double balance;
    //Choose ArrayList for future transactions history adding
    private ArrayList<String> transactions = new ArrayList<>();

    public AccountInformation(String fname, String lname, double balance) {
        this.fname = fname;
        this.lname = lname;
        this.balance = balance;
        this.transactions = new ArrayList<>();
        //The initial balance is also the first transaction history in this account
        this.transactions.add("First Deposit: " + balance);
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {return lname;}

    public double getBalance() {
        return balance;
    }

    public ArrayList<String> getTransactions() {
        return transactions;
    }

    public void addTransactions(double amount) {
        //balance = balance + amount
        balance += amount;

        //Distinguish if deposit or withdraw should be shown in the ArrayList 'transactions' while a transaction is made
        if (amount > 0) {
            transactions.add("Deposit: " + amount);
        } else {
            transactions.add("Withdraw: " + amount);
        }
    }

    public void displayDetail() {
        System.out.println("First Name:" + this.fname);
        System.out.println("Last Name: " + this.lname);
        System.out.println("Balance: " + this.balance);
        System.out.println("Transactions");
        for (String transaction : this.transactions) {
            System.out.println(transaction);
        }
    }

    public void displayBalance() {
        System.out.println("New balance: " + this.balance);
    }
}
