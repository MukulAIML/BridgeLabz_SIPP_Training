import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface LogExecutionTime {}

class Work {
    @LogExecutionTime
    public void task1() throws InterruptedException { Thread.sleep(200); }

    @LogExecutionTime
    public void task2() throws InterruptedException { Thread.sleep(100); }
}

public class LogExecutionTimeDemo {
    public static void main(String[] args) throws Exception {
        Work w = new Work();
        for (Method m : Work.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(LogExecutionTime.class)) {
                long start = System.nanoTime();
                m.invoke(w);
                long end = System.nanoTime();
                System.out.println(m.getName() + " executed in " + (end - start) / 1_000_000 + " ms");
            }
        }
    }
}