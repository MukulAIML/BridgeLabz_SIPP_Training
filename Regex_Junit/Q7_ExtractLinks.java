
import java.util.regex.*;

public class Q7_ExtractLinks {
    public static void main(String[] args) {
        String text = "Visit https://www.google.com and http://example.org for more info.";
        String regex = "https?://[\\w.-]+";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);
        while (m.find()) {
            System.out.println(m.group());
        }
    }
}
