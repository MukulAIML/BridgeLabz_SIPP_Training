import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class Project {
    @Todo(task = "Implement login", assignedTo = "Bob", priority = "HIGH")
    public void login() {}

    @Todo(task = "Add search feature", assignedTo = "Alice")
    public void search() {}
}

public class TodoDemo {
    public static void main(String[] args) throws Exception {
        for (Method m : Project.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Todo.class)) {
                Todo t = m.getAnnotation(Todo.class);
                System.out.println("Task: " + t.task() + ", Assigned to: " + t.assignedTo() + ", Priority: " + t.priority());
            }
        }
    }
}