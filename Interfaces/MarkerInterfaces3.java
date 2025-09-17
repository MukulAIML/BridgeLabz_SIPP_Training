
// 3. Sensitive Data Tagging
interface SensitiveData {}

class CustomerInfo implements SensitiveData {
    String ssn;
    CustomerInfo(String ssn) { this.ssn = ssn; }
}

public class MarkerInterfaces3 {
    public static void main(String[] args) {
        CustomerInfo c = new CustomerInfo("123-45-6789");
        if (c instanceof SensitiveData) {
            System.out.println("Sensitive data detected, apply encryption.");
        }
    }
}
