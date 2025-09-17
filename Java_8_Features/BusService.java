import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class BusService implements TransportService {
    public String getServiceName() { return "CityBus"; }

    // Provide some sample trips
    public List<Trip> availableTrips() {
        return Arrays.asList(
            new Trip("B1", LocalDateTime.now().plusMinutes(10), 1.5, 30),
            new Trip("B2", LocalDateTime.now().plusMinutes(40), 1.2, 10),
            new Trip("B3", LocalDateTime.now().plusMinutes(5), 2.0, 20)
        );
    }
}
