package InheritanceBank;

public class CheckingAccount extends BankAccount {
    private double overdraftLimit;

    public CheckingAccount(String accountNumber, String ownerName, double balance, double overdraftLimit){
        super(accountNumber, ownerName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount){
        if((getBalance() - amount) < -overdraftLimit){
            System.out.println("Over the limit!");
        } else {
            deposit(-amount);
        }
    }

    @Override
    public String toString(){
        return super.toString() + " OverdraftLimit: " + this.overdraftLimit;
    }
}
