import java.util.Scanner;

// Class to represent a User's Account
class Account {
    private double currentBalance;

    public Account(double startingBalance) {
        this.currentBalance = startingBalance;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void addFunds(double amount) {
        if (amount > 0) {
            currentBalance += amount;
            System.out.println("Funds successfully added.");
        } else {
            System.out.println("Amount must be greater than zero.");
        }
    }

    public void withdrawFunds(double amount) {
        if (amount > 0 && amount <= currentBalance) {
            currentBalance -= amount;
            System.out.println("Withdrawal completed.");
        } else if (amount > currentBalance) {
            System.out.println("Insufficient balance for this transaction.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }
}

// Class to simulate the Bank Machine interface
class BankMachine {
    private Account userAccount;
    private Scanner inputScanner;

    public BankMachine(Account account) {
        this.userAccount = account;
        this.inputScanner = new Scanner(System.in);
    }

    public void initiate() {
        while (true) {
            System.out.println("\n======= Welcome to the Bank Machine =======");
            System.out.println("1. View Current Balance");
            System.out.println("2. Deposit Funds");
            System.out.println("3. Withdraw Funds");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            int choice = inputScanner.nextInt();

            switch (choice) {
                case 1:
                    displayBalance();
                    break;
                case 2:
                    depositFunds();
                    break;
                case 3:
                    withdrawFunds();
                    break;
                case 4:
                    System.out.println("Thank you for using our services. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    private void displayBalance() {
        System.out.printf("Your current balance is: %.2f\n", userAccount.getCurrentBalance());
    }

    private void depositFunds() {
        System.out.print("Enter the amount to deposit: ");
        double amount = inputScanner.nextDouble();
        userAccount.addFunds(amount);
    }

    private void withdrawFunds() {
        System.out.print("Enter the amount to withdraw: ");
        double amount = inputScanner.nextDouble();
        userAccount.withdrawFunds(amount);
    }
}

// Main class to run the Bank Machine simulation
public class BankApp {
    public static void main(String[] args) {
        // Initializing the user's bank account with a starting balance of 1000.0
        Account userAccount = new Account(1000.0);

        // Creating a BankMachine instance and starting the interface
        BankMachine bankMachine = new BankMachine(userAccount);
        bankMachine.initiate();
    }
}
