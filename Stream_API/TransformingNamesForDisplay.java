
import java.util.*;

public class TransformingNamesForDisplay {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("alice", "bob", "charlie", "david");

        names.stream()
            .map(String::toUpperCase)
            .sorted()
            .forEach(System.out::println);
    }
}
