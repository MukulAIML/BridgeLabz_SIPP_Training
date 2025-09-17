
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        String paragraph = "Java is great and Java is powerful. Java streams are powerful too.";
        String[] words = paragraph.toLowerCase().split("\\W+");

        Map<String, Long> frequency = Arrays.stream(words)
            .collect(Collectors.groupingBy(w -> w, Collectors.counting()));

        System.out.println(frequency);
    }
}
