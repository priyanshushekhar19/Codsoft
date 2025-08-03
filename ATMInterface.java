import java.util.Scanner;

public class ATMInterface {

    // Represents a basic bank account
    static class BankAccount {
        private String name;
        private double balance;

        // Constructor to initialize account holder and starting balance
        public BankAccount(String name, double openingBalance) {
            this.name = name;
            this.balance = openingBalance;
        }

        // Get current account balance
        public double checkBalance() {
            return balance;
        }

        // Add money to the account
        public boolean addMoney(double amount) {
            if (amount > 0) {
                balance += amount;
                return true;
            }
            return false;
        }

        // Take out money from the account
        public boolean takeMoney(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                return true;
            }
            return false;
        }

        // Get the name of the account holder
        public String getName() {
            return name;
        }
    }

    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BankAccount userAccount = new BankAccount("vidushi jain", 5000); 

        System.out.println("👋 Welcome to the ATM, " + userAccount.getName() + "!");

        while (true) {
            // Display options to user
            System.out.println("\n📋 Menu:");
            System.out.println("1️⃣ Check Balance");
            System.out.println("2️⃣ Deposit Money");
            System.out.println("3️⃣ Withdraw Money");
            System.out.println("4️⃣ Exit");
            System.out.print("👉 Choose an option: ");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.printf("💰 Your current balance is: ₹%.2f%n", userAccount.checkBalance());
                    break;

                case 2:
                    System.out.print("💵 Enter amount to deposit: ₹");
                    double depositAmount = input.nextDouble();
                    if (userAccount.addMoney(depositAmount)) {
                        System.out.printf("✅ ₹%.2f deposited successfully!%n", depositAmount);
                    } else {
                        System.out.println("⚠️ Invalid deposit amount.");
                    }
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = input.nextDouble();
                    if (userAccount.takeMoney(withdrawAmount)) {
                        System.out.printf("✅₹%.2f withdrawn successfully!%n", withdrawAmount);
                    } else {
                        System.out.println("Insufficient balance or invalid amount.");
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM. Have a great day!");
                    input.close();
                    return;

                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}