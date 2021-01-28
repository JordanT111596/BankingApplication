package BankingApplication;

//import scanner
import java.util.Scanner;

//Full App Class
public class BankingApplication {
    
    //My main method
    public static void main(String[] args) {
        
    }
}

//Class used for creating bank account objects
class BankAccount {
    //variables for account
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    //Bank Account Constructor

    BankAccount(String custName, String custId) {
        customerName = custName;
        customerId = custId;
    }

    //Method for making deposits
    void deposit (int amount) {
        if (amount !=0) {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    //Method for making withdrawls
    void withdraw (int amount) {
        if (amount !=0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    //Method for finding previous transaction
    void getPreviousTransaction () {
        //If transaction was a positive number
        if (previousTransaction > 0) {
        System.out.println("Deposited: " + previousTransaction);
        }
        //If transaction was a negative number
        else if (previousTransaction < 0) {
            System.out.println("Withdrew: " + Math.abs(previousTransaction));
        } //If transaction was zero
        else {
            System.out.println("No transaction made!");
        }
    }

    //Method for showing the menu
    void showMenu() {

        //initializes the choice character
        char option ='\0';
        //Creates new scanner
        Scanner scanner = new Scanner(System.in);

        //Menu printing
        System.out.println("Welcome: " + customerName);
        System.out.println("Your ID is: " + customerId);
        System.out.println("\n");
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous Transaction");
        System.out.println("E. Exit");


    }
}