
import java.util.regex.*;
import java.util.*;

public class Q14_RepeatingWords {
    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";
        String regex = "\\b(\\w+) \\1\\b";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);
        while (m.find()) {
            System.out.println(m.group(1));
        }
    }
}
