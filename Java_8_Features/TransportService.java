import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

public interface TransportService {
    String getServiceName();
    List<Trip> availableTrips();

    // Default method used by all transport services
    default void printServiceDetails() {
        System.out.println("Service: " + getServiceName());
        System.out.println("Available Trips:");
        availableTrips().forEach(System.out::println);
    }

    // Static utility inside interface
    static double parseFare(Object o) {
        try {
            return Double.parseDouble(o.toString());
        } catch (Exception e) {
            return 0.0;
        }
    }
}
