
// 1. Temperature Alert System
import java.util.function.Predicate;

public class FunctionalInterfaces1 {
    public static void main(String[] args) {
        Predicate<Double> alert = temp -> temp > 40.0;
        double currentTemp = 42.5;
        if (alert.test(currentTemp)) {
            System.out.println("Alert! High temperature: " + currentTemp);
        }
    }
}
