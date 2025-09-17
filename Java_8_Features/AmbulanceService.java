import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

// Implements marker EmergencyService
public class AmbulanceService implements TransportService, EmergencyService {
    public String getServiceName() { return "Ambulance"; }
    public List<Trip> availableTrips() {
        return Arrays.asList(
            new Trip("EM1", LocalDateTime.now().plusMinutes(1), 0.0, 0)
        );
    }

    // Override default to emphasize emergency
    @Override
    public void printServiceDetails() {
        System.out.println("*** EMERGENCY SERVICE: " + getServiceName() + " ***");
        availableTrips().forEach(System.out::println);
    }
}
