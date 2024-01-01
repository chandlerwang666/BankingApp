import java.util.*;

public class Functions {

    //View accounts function - Case 1
    public static void viewAllAccounts() {
        System.out.println();
        for (AccountInformation account : BankApp.accounts) { //Declare a variable account of AccountInformation iteraties over the list accounts in BankApp
            System.out.println(account.getFname() + " " + account.getLname());
        }
        System.out.println();
        System.out.println("For a specific account details, please choose the second option");
    }

    //View individual account information - Case 2
    public static void viewAccountDetail() {
        System.out.println("Please capitalise the first letter in both first and last name");
        System.out.println("Account first name:");
        //Input read for first name and second name
        Scanner detailScanner = new Scanner(System.in);
        String fname = detailScanner.nextLine();
        System.out.println("Account last name:");
        String lname = detailScanner.nextLine();
        AccountInformation account = accountFinder(fname, lname);
        if (account == null) { //Account not found
            System.out.println("Account not found!");
            System.out.println("Please check your information again");
        } else {
            account.displayDetail();
        }
    }

    //A method to make a transaction - Case 3
    public static void makeTransaction() {
        System.out.println("Please capitalise the first letter in both first and last name");
        System.out.println("Account first name:");
        Scanner detailScanner = new Scanner(System.in);
        String fname = detailScanner.nextLine();
        System.out.println("Account last name:");
        String lname = detailScanner.nextLine();
        AccountInformation account = accountFinder(fname, lname);
        if (account == null) { //Account not found
            System.out.println("Account not found!");
            System.out.println("Please check your information again");
        } else {
            System.out.println("Transaction amount:");
            double amount = detailScanner.nextDouble(); //Input amount you want to transfer
            detailScanner.nextLine();
            if (amount > 0) { //Reconise if this transaction is withdraw or deposit
                account.addTransactions(amount);
                System.out.println("Deposit Successfully");
                account.displayBalance();
            } else if (amount < 0 && account.getBalance() < 0) { //Unable to withdraw when the balance is already negative
                System.out.println("YOU ARE UNABLE TO WITHDRAW UNTIL YOU HAVE POSITIVE BALANCE");
            } else if (amount == 0) { //No transaction (calculation) is made if the input amount is 0
                System.out.println("No transaction is made!");
            } else {
                account.addTransactions(amount);
                if (account.getBalance() + amount > 0) { //Let the user know if they are in debt or not if they want to withdraw money
                    System.out.println("Withdraw Successfully");
                } else {
                    System.out.println("Your account is in debt! Please payback as soon as possible");
                }
                account.displayBalance();
            }
        }
    }

    //A method which can remove account - Case 4
    public static void removeAccount() {
        System.out.println("Please capitalise the first letter in both first and last name");
        System.out.println("Account first name:");
        Scanner detailScanner = new Scanner(System.in);
        String fname = detailScanner.nextLine();
        System.out.println("Account last name:");
        String lname = detailScanner.nextLine();
        AccountInformation account = accountFinder(fname, lname);
        if (account == null) { //Account not found
            System.out.println("Account not found!");
            System.out.println("Please check your information again");
        } else {
            BankApp.accounts.remove(account); //Remove the account
            System.out.println("Operation Success");
        }
    }

    //A method to create a new account - Case 5
    public static void createAccount() {
        System.out.println("Please enter your first name:");
        Scanner detailScanner = new Scanner(System.in);
        String fname = detailScanner.nextLine();
        System.out.println("Please enter your last name:");
        String lname = detailScanner.nextLine();
        System.out.println("Please put your initial balance");
        double balance = detailScanner.nextDouble();
        detailScanner.nextLine();
        if (balance > 0) { //Reconise if the balance user entered is valid or not
            AccountInformation account = new AccountInformation(fname, lname, balance); //Add the user information in to the arraylist AccountInformation
            BankApp.accounts.add(account);
            System.out.println("Account creation success");
        } else {
            System.out.println("Insufficient initial balance, please try agian!"); //If not valid, no calculation will be carried on
        }
    }

    //A method to find the account in the list accounts matches the first name and last name
    public static AccountInformation accountFinder(String fname, String lname) {
        for (AccountInformation account: BankApp.accounts) {
            //compare the input STRING value so sure .equals
            if (account.getFname().equals(fname) && account.getLname().equals(lname)){
                return account;
            }
        }
        return null;
    }

}
