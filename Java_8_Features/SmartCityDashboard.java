import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SmartCityDashboard {
    public static void main(String[] args) {
        // Init services
        List<TransportService> services = Arrays.asList(
            new BusService(),
            new MetroService(),
            new TaxiService(),
            new AmbulanceService()
        );

        // Example 1: Lambda for filtering & sorting (earliest departures and low fare)
        System.out.println("--- Filtered & Sorted Trips (earliest, fare <= 2.0) ---");
        services.stream()
            .flatMap(s -> s.availableTrips().stream())
            .filter(t -> t.getFare() <= 2.0)
            .sorted(Comparator.comparing(Trip::getDeparture))
            .limit(10)
            .forEach(System.out::println); // method reference could be used too

        // Example 2: Method references to print service details
        System.out.println("\n--- Service Details ---");
        services.forEach(TransportService::printServiceDetails); // method reference

        // Example 3: Functional interface for fare calculation (lambda)
        FareCalculator calc = trip -> {
            double base = trip.getFare();
            // small dynamic surcharge depending on hours
            int hour = trip.getDeparture().getHour();
            return base + (hour >= 7 && hour <= 9 ? 0.5 : 0.0);
        };
        System.out.println("\nSample fare calc for first Bus trip: " + calc.calculateFare(services.get(0).availableTrips().get(0)));

        // Example 4: Streams + collectors to group passengers by route and summarize fares
        List<Trip> allTrips = services.stream().flatMap(s -> s.availableTrips().stream()).collect(Collectors.toList());
        Map<String, Long> passengersByRoute = allTrips.stream()
            .collect(Collectors.groupingBy(Trip::getRoute, Collectors.summingLong(Trip::getPassengers)));
        System.out.println("\nPassengers by Route: " + passengersByRoute);

        Map<Boolean, List<Trip>> peakPartition = allTrips.stream()
            .collect(Collectors.partitioningBy(t -> isPeak(t.getDeparture())));
        System.out.println("\nPeak trips count: " + peakPartition.get(true).size());

        Map<String, Double> fareSummary = allTrips.stream()
            .collect(Collectors.groupingBy(Trip::getRoute, Collectors.summarizingDouble(Trip::getFare)))
            .entrySet().stream()
            .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().getSum()));
        System.out.println("\nTotal fares by route: " + fareSummary);

        // Example 5: Marker Interface detection for priority routing
        System.out.println("\n--- Emergency Services ---");
        services.stream()
            .filter(s -> s instanceof EmergencyService)
            .forEach(s -> System.out.println(s.getServiceName() + " is emergency-enabled"));

        // Example 6: GeoUtils static method usage
        double d = GeoUtils.calculateDistance(12.97, 77.59, 12.95, 77.58);
        System.out.println("\nDistance sample (approx): " + d);

        // Dashboard live update simulation: ForEach display
        System.out.println("\n--- Live Dashboard Schedules ---");
        services.forEach(s -> {
            System.out.println("[" + LocalDateTime.now() + "] " + s.getServiceName());
            s.availableTrips().forEach(System.out::println);
        });

        // Extensibility: adding a ferry would only require implementing TransportService
        System.out.println("\nSystem ready for extension: implement TransportService to add more services.");    
    }

    private static boolean isPeak(LocalDateTime dt) {
        int h = dt.getHour();
        return (h >= 7 && h <= 10) || (h >= 17 && h <= 19);
    }
}
