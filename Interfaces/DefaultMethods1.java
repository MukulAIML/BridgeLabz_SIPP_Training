
// 1. Payment Gateway Integration
interface PaymentProcessor {
    void processPayment(double amount);
    default void refund(double amount) {
        System.out.println("Refund of " + amount + " processed");
    }
}

class PayPal implements PaymentProcessor {
    public void processPayment(double amount) { System.out.println("Paid " + amount + " via PayPal"); }
}

public class DefaultMethods1 {
    public static void main(String[] args) {
        PaymentProcessor pp = new PayPal();
        pp.processPayment(300);
        pp.refund(100);
    }
}
