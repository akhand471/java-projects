import java.util.Scanner;

public class ATMSimulator {
    private static double balance = 0.0;
    private static final int PIN = 1234;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== Welcome to the Java ATM  =====");
        System.out.print("Enter your 4-digit PIN: ");
        int enteredPin = sc.nextInt();

        if (!checkPin(enteredPin)) {
            System.out.println("Invalid PIN. Access Denied.");
            sc.close();
            return;
        }

        boolean exit = false;

        while (!exit) {
            System.out.println("\n====== ATM MENU ======");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmount = sc.nextDouble();
                    deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = sc.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using our ATM. Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        sc.close();
    }

    // Check PIN
    public static boolean checkPin(int inputPin) {
        return inputPin == PIN;
    }

    // Check Balance
    public static void checkBalance() {
        System.out.println("Your current balance is: ₹" + balance);
    }

    // Deposit
    public static void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Please enter a valid amount to deposit.");
        } else {
            balance += amount;
            System.out.println("₹" + amount + " deposited successfully.");
        }
    }

    // Withdraw
    public static void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Please enter a valid amount to withdraw.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
        }
    }
}
