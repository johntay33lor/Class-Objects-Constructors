import java.util.ArrayList;
import java.util.Scanner;

public class BankAccount2 {

    private String accountHolderName;
    private double accountBalance;
    private int accountNumber;
    private static int nextAccountNumber = 1;


    public BankAccount2() {
        this.accountNumber = nextAccountNumber;
        this.accountHolderName = " ";
        this.accountBalance = 0;
        nextAccountNumber++;
    }


    public BankAccount2(String name, double balance, int accountNumber) {
        this.accountHolderName = name;
        this.accountBalance = balance;
        this.accountNumber = accountNumber;
    }

    public BankAccount2(Scanner input, ArrayList<BankAccount2> accountList) {

        System.out.println("Welcome to the Bank of CTAC ");
        System.out.println("Do you have an account here? (-1 to exit) \n" +
                "1. yes \n" +
                "2. no");
        int choice = input.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Awesome. Thanks for your business!");
                input.nextLine();
                break;
            case 2:
                System.out.println("What name do you want on the account?");
                input.nextLine();
                this.accountHolderName = input.nextLine();
                System.out.println("What is your beginning balance for the account?");
                this.accountBalance = input.nextDouble();
                this.accountNumber = nextAccountNumber;
                nextAccountNumber++;
                break;
            case -1:
                System.out.println("Thanks for stopping by!");
                break;
            default:
                System.out.println("Please enter a valid choice.");
                break;
        }
    }


    public void deposit(double amount) {
        this.accountBalance += amount;
    }


    public void withdraw(double amount) {
        if (this.accountBalance >= amount) {
            this.accountBalance -= amount;
        } else {
            System.out.println("Error: Insufficient funds.");
        }
    }


    public void printAccountDetails() {
        System.out.println("Account Number: " + this.accountNumber + "\n" +
                "" + this.accountHolderName + " has a balance of: " + this.accountBalance);
    }


    public void transfer(BankAccount2 otherAcct, double amountToTransfer) {
        if (otherAcct == null) {
            System.out.println("Error: Insufficient funds.");
            return;
        }

        if (accountBalance < amountToTransfer) {
            System.out.println("Error: Insufficient funds.");
            return;
        }


        withdraw(amountToTransfer);


        otherAcct.deposit(amountToTransfer);


        printAccountDetails();
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
}
