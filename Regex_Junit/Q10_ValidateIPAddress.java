
public class Q10_ValidateIPAddress {
    public static void main(String[] args) {
        String[] ips = {"192.168.1.1", "256.100.50.0"};
        String regex = "^(25[0-5]|2[0-4]\\d|1?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|1?\\d?\\d)){3}$";

        for (String ip : ips) {
            if (ip.matches(regex)) {
                System.out.println(ip + " → Valid");
            } else {
                System.out.println(ip + " → Invalid");
            }
        }
    }
}
