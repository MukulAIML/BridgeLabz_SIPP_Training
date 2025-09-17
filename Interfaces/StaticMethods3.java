
// 3. Date Format Utility
import java.text.SimpleDateFormat;
import java.util.Date;

interface DateFormatter {
    static String formatDate(Date date, String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }
}

public class StaticMethods3 {
    public static void main(String[] args) {
        System.out.println(DateFormatter.formatDate(new Date(), "dd/MM/yyyy"));
    }
}
