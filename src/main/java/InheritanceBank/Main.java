package InheritanceBank;

public class Main {
    public static void main(String[] args) {
        // Create a SavingsAccount with 5% interest rate
        SavingsAccount savings = new SavingsAccount("SAV123", "Alice Johnson", 1000.0, 0.05);

        // Create a CheckingAccount with $500 overdraft limit
        CheckingAccount checking = new CheckingAccount("CHK456", "Bob Smith", 200.0, 500.0);

        System.out.println("=== Initial Accounts ===");
        System.out.println(savings);
        System.out.println(checking);
        System.out.println();

        // --- SavingsAccount operations ---
        System.out.println("=== Savings Account Operations ===");
        savings.deposit(500.0);
        System.out.println("After depositing $500: " + savings.getBalance());

        savings.withdraw(200.0);
        System.out.println("After withdrawing $200: " + savings.getBalance());

        savings.applyInterest();  // interest on current balance (1300 * 0.05 = 65)
        System.out.println("After applying interest: " + savings);
        System.out.println();

        // --- CheckingAccount operations ---
        System.out.println("=== Checking Account Operations ===");
        checking.deposit(300.0);
        System.out.println("After depositing $300: " + checking.getBalance());

        checking.withdraw(100.0);
        System.out.println("After withdrawing $100: " + checking.getBalance());

        // Attempt to overdraw within limit
        System.out.println("\nAttempting to withdraw $700 (balance $400, overdraft limit $500):");
        checking.withdraw(700.0);  // new balance = 400 - 700 = -300 (within -500 limit)
        System.out.println("Resulting balance: " + checking.getBalance());

        // Attempt to exceed overdraft limit
        System.out.println("\nAttempting to withdraw $300 more (balance -300, overdraft limit $500):");
        checking.withdraw(300.0);  // would go to -600 → exceeds -500 limit
        System.out.println("Balance remains: " + checking.getBalance());

        System.out.println("\n=== Final Account Details ===");
        System.out.println(savings);
        System.out.println(checking);
    }
}