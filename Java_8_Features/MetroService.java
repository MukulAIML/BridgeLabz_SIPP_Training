import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class MetroService implements TransportService {
    public String getServiceName() { return "CityMetro"; }
    public List<Trip> availableTrips() {
        return Arrays.asList(
            new Trip("M1", LocalDateTime.now().plusMinutes(3), 2.5, 100),
            new Trip("M2", LocalDateTime.now().plusMinutes(15), 2.0, 80)
        );
    }
}
