
import java.util.Scanner;
import java.util.ArrayList;

public class Main_BankAccount2 {
    public static void main(String[] args) {
        ArrayList<BankAccount2> accountList = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        BankAccount2 account1 = new BankAccount2(input, accountList);


        BankAccount2 john = new BankAccount2("John Taylor ", 500, 0);
        BankAccount2 tempestt = new BankAccount2("Tempestt Taylor ", 5000, 1);


        accountList.add(john);
        accountList.add(tempestt);
        accountList.add(john);


        BankAccount2 currentAccount = new BankAccount2();
        currentAccount.setAccountNumber(2);
        accountList.add(currentAccount);


        mainMenu(account1, accountList);
        mainMenu(john, accountList);


    }
    public static BankAccount2 findAcct(int acctNumber, ArrayList<BankAccount2> accountList) {
        for ( BankAccount2 account: accountList) {
            if(account.getAccountNumber() == acctNumber) {
                return account;
            }
        }
        return null;
    }

    public static void mainMenu(BankAccount2 currentAccount, ArrayList<BankAccount2> accountList) {
        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.println("Hello " + currentAccount.getAccountHolderName() + "!");
            System.out.println("Welcome to the Main Menu, what do you need today? \n" +
                    "1. Check Account Balance \n" +
                    "2. Make A Withdrawal \n" +
                    "3. Make A Deposit \n" +
                    "4. Make A Transfer To Another Account \n" +
                    "0. Exit Main Menu");

            int choice = input.nextInt();

            switch(choice) {
                case 1:
                    currentAccount.printAccountDetails();
                    break;
                case 2:
                    System.out.println("How much would you like to withdrawal?");
                    double withdrawalAmt = input.nextDouble();
                    currentAccount.withdraw(withdrawalAmt);
                    currentAccount.printAccountDetails();
                    break;
                case 3:
                    System.out.println("How much would you like to deposit?");
                    double depositAmt = input.nextDouble();
                    currentAccount.deposit(depositAmt);
                    currentAccount.printAccountDetails();
                    break;
                case 4:
                    System.out.println("Enter the account number you are transferring to: (0, 1 or 2)");
                    int transferAcctNumber = input.nextInt();

                    BankAccount2 transferAccount = findAcct(transferAcctNumber, accountList);

                    if(transferAccount == null) {
                        System.out.println("Account doesn't exist");
                        break;
                    }
                    System.out.println("Enter an amount to transfer: ");
                    double transferAmt = input.nextDouble();

                    currentAccount.transfer(transferAccount, transferAmt);
                    break;

                case 0:
                    System.out.println("Thanks for your business. Goodbye!");
                    return;
                default:
                    System.out.println("Enter a valid option (1-4; or 0 to exit)");
                    break;
            }
        }
    }
}
