
import java.time.LocalDateTime;
import java.util.*;

public class LoggingTransactions {
    public static void main(String[] args) {
        List<String> transactionIds = Arrays.asList("TXN001", "TXN002", "TXN003");
        transactionIds.forEach(id -> System.out.println(LocalDateTime.now() + " - Transaction: " + id));
    }
}
