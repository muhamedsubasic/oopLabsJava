package DesignPatterns;

//Strategy
public interface PaymentStrategy {
    void pay(int amount);
}

class CreditCardPayment implements PaymentStrategy{
    private String cardNumber;
    private String name;

    public CreditCardPayment(String cardNumber, String name){
        this.cardNumber = cardNumber;
        this.name = name;
    }

    @Override
    public void pay(int amount){
        System.out.println("Paid " + amount + " using Credit Card: " + cardNumber);
    }
}

class PayPalPayment implements PaymentStrategy{
    private String email;

    public PayPalPayment(String email){
        this.email = email;
    }

    @Override
    public void pay(int amount){
        System.out.println("Paid " + amount + " using PayPal by email: " + email);
    }
}

class ShoppingCart{
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy strategy){
        this.paymentStrategy = strategy;
    }

    public void checkout(int amount){
        if (paymentStrategy == null) {
            System.out.println("Select payment method");
        }
        paymentStrategy.pay(amount);
    }
}

class StrategyDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Use credit card
        cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456", "Alice"));
        cart.checkout(150);

        // Switch to PayPal
        cart.setPaymentStrategy(new PayPalPayment("alice@example.com"));
        cart.checkout(200);
    }
}
