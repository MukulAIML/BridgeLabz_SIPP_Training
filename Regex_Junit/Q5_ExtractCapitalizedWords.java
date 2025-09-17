
import java.util.regex.*;
import java.util.*;

public class Q5_ExtractCapitalizedWords {
    public static void main(String[] args) {
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";
        String regex = "\\b[A-Z][a-zA-Z]*\\b";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);
        while (m.find()) {
            System.out.println(m.group());
        }
    }
}
