package InheritanceBank;

public class SavingsAccount extends BankAccount{
    private double interestRate;

    public SavingsAccount(String accountNumber, String ownerName, double balance, double interestRate){
        super(accountNumber, ownerName, balance);
        this.interestRate = interestRate;
    }

    public void applyInterest(){
        double interest = getBalance() * interestRate;
        deposit(interest);
    }

    @Override
    public String toString(){
        return super.toString() + " Interest Rate: " + this.interestRate;
    }
}
