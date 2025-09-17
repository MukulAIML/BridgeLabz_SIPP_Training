import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class TaxiService implements TransportService {
    public String getServiceName() { return "CityTaxi"; }
    public List<Trip> availableTrips() {
        return Arrays.asList(
            new Trip("T1", LocalDateTime.now().plusMinutes(2), 5.0, 1),
            new Trip("T2", LocalDateTime.now().plusMinutes(20), 6.0, 1)
        );
    }
}
