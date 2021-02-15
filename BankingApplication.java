// package BankingApplication;

//import scanner
import java.util.Scanner;

//Full App Class
public class BankingApplication {

    // My main method
    public static void main(String[] args) {

        //Create a menu for options and input like you did in the C# app
        System.out.println("What is your name?");
        //scanner asks for account name
        Scanner initScan = new Scanner(System.in);
        //account name is set to the next user-input string
        String acctName = initScan.next();
        //random id number needs to generate
        // Creates starter account
        BankAccount starterAccount = new BankAccount(acctName, "42069");
        //Asks user for opening deposit
        // Starts up the banking menu for the user
        starterAccount.showMenu();
    }
}

// Class used for creating bank account objects
class BankAccount {
    // variables for account
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    // Bank Account Constructor

    BankAccount(String custName, String custId) {
        customerName = custName;
        customerId = custId;
    }

    // Method for making deposits
    void deposit(int amount) {
        if (amount != 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    // Method for making withdrawls
    void withdraw(int amount) {
        if (amount != 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    // Method for finding previous transaction
    void getPreviousTransaction() {
        // If transaction was a positive number
        if (previousTransaction > 0) {
            System.out.println("You Deposited: " + previousTransaction);
        }
        // If transaction was a negative number
        else if (previousTransaction < 0) {
            System.out.println("You Withdrew: " + Math.abs(previousTransaction));
        } // If transaction was zero
        else {
            System.out.println("No transaction made!");
        }
    }

    // Method for showing the menu
    void showMenu() {

        // initializes the choice character
        char option = '\0';
        // Creates new scanner
        Scanner scanner = new Scanner(System.in);

        // User info prints when first brought to menu
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("Welcome: " + customerName);
        System.out.println("Your ID is: " + customerId);

        // do while loop for taking user choices
        do {
            // Menu printing
            System.out.println("\nWhat would you like to do?");
            System.out.println("A. Check Balance");
            System.out.println("B. Deposit");
            System.out.println("C. Withdraw");
            System.out.println("D. Previous Transaction");
            System.out.println("E. Exit");
            option = scanner.next().charAt(0);
            option = Character.toUpperCase(option);
            System.out.println("\n");

            switch (option) {

                // Line to print balance
                case 'A':
                    System.out.println("---------------------------------------------------------------------------");
                    System.out.println("Your current balance: " + balance);
                    System.out.println("---------------------------------------------------------------------------");
                    System.out.println("\n");
                    break;

                // After user selects deposit option
                case 'B':
                    System.out.println("---------------------------------------------------------------------------");
                    System.out.println("How much would you like to deposit?");
                    System.out.println("---------------------------------------------------------------------------");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println("\n");
                    break;

                // After user selects withdraw option
                case 'C':
                    System.out.println("---------------------------------------------------------------------------");
                    System.out.println("How much would you like to withdraw?");
                    System.out.println("---------------------------------------------------------------------------");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println("\n");
                    break;

                // Line to print previous transaction
                case 'D':
                    System.out.println("---------------------------------------------------------------------------");
                    getPreviousTransaction();
                    System.out.println("---------------------------------------------------------------------------");
                    System.out.println("\n");
                    break;

                // Upon choosing the exit option...
                case 'E':
                    System.out.println("***************************************************************************");
                    break;

                // If the input is anything other than a given option
                default:
                    System.out.println("Please select either A, B, C, D, or E!");
                    break;

            }
        }

        // As long as the user doesn't choose to exit
        while (option != 'E');

        // Ending thank you message
        System.out.println("Thank you for banking with Jordan's Java!");

    }
}