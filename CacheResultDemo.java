import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@interface CacheResult {}

class ExpensiveCalculator {
    private Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    public int computeSquare(int x) {
        if (cache.containsKey(x)) {
            System.out.println("Returning cached value");
            return cache.get(x);
        }
        try { Thread.sleep(500); } catch (InterruptedException e) {}
        int result = x * x;
        cache.put(x, result);
        return result;
    }
}

public class CacheResultDemo {
    public static void main(String[] args) throws Exception {
        ExpensiveCalculator calc = new ExpensiveCalculator();
        Method method = ExpensiveCalculator.class.getMethod("computeSquare", int.class);
        for (int i = 0; i < 2; i++) {
            long start = System.currentTimeMillis();
            Object result = method.invoke(calc, 5);
            long end = System.currentTimeMillis();
            System.out.println("Result: " + result + ", Time: " + (end - start) + " ms");
        }
    }
}