
// 2. String Length Checker
import java.util.function.Function;

public class FunctionalInterfaces2 {
    public static void main(String[] args) {
        Function<String, Integer> lengthChecker = String::length;
        String msg = "Hello, Functional Interfaces!";
        System.out.println("Length: " + lengthChecker.apply(msg));
    }
}
