package InheritanceBank;

public class BankAccount {
    private String accountNumber;
    private String ownerName;
    private double balance;

    public BankAccount(String accountNumber, String ownerName, double balance){
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public String getAccountNumber(){ return this.accountNumber; }
    public void setAccountNumber(String accountNumber){ this.accountNumber = accountNumber; }
    public String getOwnerName(){ return this.ownerName; }
    public void setOwnerName(String ownerName){ this.ownerName = ownerName; }
    public double getBalance(){ return this.balance; }

    public void deposit(double amount){
        this.balance += amount;
    }

    public void withdraw(double amount){
        if(amount > this.balance){
            System.out.println("Not enough funds!");
        } else {
            this.balance -= amount;
            System.out.println("Withdrew: " + amount + " Current Balance: " + this.balance);
        }
    }

    public String toString(){
        return "Account Number: " + this.accountNumber + " Owner Name: " + this.ownerName + " Balance: " + this.balance;
    }
}
