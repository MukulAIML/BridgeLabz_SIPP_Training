
import java.util.*;
import java.util.stream.Collectors;

public class InsuranceClaimAnalysis {
    public static void main(String[] args) {
        List<Claim> claims = Arrays.asList(
            new Claim("Health", 2000),
            new Claim("Auto", 1500),
            new Claim("Health", 3000),
            new Claim("Auto", 1000),
            new Claim("Home", 4000)
        );

        Map<String, Double> avgClaim = claims.stream()
            .collect(Collectors.groupingBy(Claim::getType, Collectors.averagingDouble(Claim::getAmount)));

        System.out.println(avgClaim);
    }
}

class Claim {
    private String type;
    private double amount;

    public Claim(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public String getType() { return type; }
    public double getAmount() { return amount; }
}
