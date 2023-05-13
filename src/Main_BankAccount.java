public class Main_BankAccount {
    public static void main(String[] args) {

        BankAccount account1 = new BankAccount(500.00, "John Taylor");
        BankAccount account2 = new BankAccount(5000.00, "Tempestt Taylor");
        BankAccount account3 = new BankAccount(300.00, "LJ Taylor");


        account1.deposit(100.00);
        account1.accountDetails();

        account2.withdrawal(100.00);
        account2.accountDetails();
        account3.deposit(100.00);
        account3.accountDetails();

        System.out.println();

        Product car = new Product (20000.00, 2, "New Car" );

        car.printProduct();
        car.totalCost();


    }
}
