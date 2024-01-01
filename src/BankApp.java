import java.util.*;

public class BankApp {
    public static ArrayList<AccountInformation> accounts = new ArrayList<AccountInformation>();

    //Set up a static method to introduce two initial acocunt with name and balance
    public static void initialAccount() {
        accounts.add(new AccountInformation("David", "Smith",5000));
        accounts.add(new AccountInformation("Lucy", "Blair", 1000));
    }

    //Display the main menu in the terminal
    public static void menu() {
        System.out.println();
        System.out.println("Bank Menu");
        System.out.println("Please choose your desired function by type the number in front");
        System.out.println("1. View all accounts");
        System.out.println("2. View individual account information");
        System.out.println("3. New transaction");
        System.out.println("4. Remove account");
        System.out.println("5. Create account");
        System.out.println("");
    }

    public static void functionChoose() {
        //Create a scanner to scan the user input
        Scanner scanner = new Scanner(System.in);
        //A variable choice which the user will input to let the scanner to scan
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                Functions.viewAllAccounts();
                break;
            case 2:
                Functions.viewAccountDetail();
                break;
            case 3:
                Functions.makeTransaction();
                break;
            case 4:
                Functions.removeAccount();
            case 5:
                Functions.createAccount();
            default:
                System.out.println("Invalid option");
                break;
        }
        menu();
        functionChoose();
    }
}
