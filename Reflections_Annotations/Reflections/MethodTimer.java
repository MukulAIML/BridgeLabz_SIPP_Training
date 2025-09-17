import java.lang.reflect.*;

class Task {
    public void longTask() throws InterruptedException {
        Thread.sleep(500);
        System.out.println("Task completed.");
    }
}

public class MethodTimer {
    public static void main(String[] args) throws Exception {
        Task task = new Task();
        Method method = Task.class.getMethod("longTask");
        long start = System.currentTimeMillis();
        method.invoke(task);
        long end = System.currentTimeMillis();
        System.out.println("Execution time: " + (end - start) + "ms");
    }
}