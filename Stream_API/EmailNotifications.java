
import java.util.*;

public class EmailNotifications {
    public static void main(String[] args) {
        List<String> emails = Arrays.asList("a@test.com", "b@test.com", "c@test.com");
        emails.forEach(email -> sendEmailNotification(email));
    }

    public static void sendEmailNotification(String email) {
        System.out.println("Sending email to: " + email);
    }
}
