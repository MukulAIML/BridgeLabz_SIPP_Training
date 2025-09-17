import java.util.*;
import java.util.function.Predicate;

class Alert {
    String type;
    String message;

    Alert(String type, String message) {
        this.type = type;
        this.message = message;
    }

    @Override
    public String toString() {
        return "[" + type + "] " + message;
    }
}

public class NotificationFiltering {
    public static void main(String[] args) {
        List<Alert> alerts = Arrays.asList(
            new Alert("Critical", "Patient heart rate abnormal"),
            new Alert("Info", "Room cleaned"),
            new Alert("Warning", "Low oxygen level")
        );

        Predicate<Alert> criticalOnly = alert -> "Critical".equals(alert.type);

        alerts.stream().filter(criticalOnly).forEach(System.out::println);
    }
}