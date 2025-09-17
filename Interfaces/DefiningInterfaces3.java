
// 3. Digital Payment Interface
interface Payment {
    void pay(double amount);
}

class UPI implements Payment {
    public void pay(double amount) { System.out.println("Paid " + amount + " using UPI"); }
}

class CreditCard implements Payment {
    public void pay(double amount) { System.out.println("Paid " + amount + " using Credit Card"); }
}

class Wallet implements Payment {
    public void pay(double amount) { System.out.println("Paid " + amount + " using Wallet"); }
}

public class DefiningInterfaces3 {
    public static void main(String[] args) {
        Payment p = new CreditCard();
        p.pay(500.0);
    }
}
