
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class FilteringExpiringMemberships {
    public static void main(String[] args) {
        List<Member> members = Arrays.asList(
            new Member("Alice", LocalDate.now().plusDays(10)),
            new Member("Bob", LocalDate.now().plusDays(40)),
            new Member("Charlie", LocalDate.now().plusDays(20))
        );

        LocalDate today = LocalDate.now();
        List<Member> expiring = members.stream()
            .filter(m -> m.getExpiryDate().isBefore(today.plusDays(30)))
            .collect(Collectors.toList());

        expiring.forEach(System.out::println);
    }
}

class Member {
    private String name;
    private LocalDate expiryDate;

    public Member(String name, LocalDate expiryDate) {
        this.name = name;
        this.expiryDate = expiryDate;
    }

    public LocalDate getExpiryDate() { return expiryDate; }
    public String toString() { return name + " - Expires: " + expiryDate; }
}
