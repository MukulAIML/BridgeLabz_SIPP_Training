import java.time.LocalDateTime;

public class Trip {
    private final String route;
    private final LocalDateTime departure;
    private final double fare;
    private final int passengers;

    public Trip(String route, LocalDateTime departure, double fare, int passengers) {
        this.route = route; this.departure = departure; this.fare = fare; this.passengers = passengers;
    }

    public String getRoute() { return route; }
    public LocalDateTime getDeparture() { return departure; }
    public double getFare() { return fare; }
    public int getPassengers() { return passengers; }

    public String toString() {
        return route + " @" + departure + " fare:" + fare + " pax:" + passengers;
    }
}
