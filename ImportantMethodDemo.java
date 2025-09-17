import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface ImportantMethod {
    String level() default "HIGH";
}

class Service {
    @ImportantMethod(level = "HIGH")
    public void criticalTask() {}

    @ImportantMethod(level = "LOW")
    public void minorTask() {}

    public void normalTask() {}
}

public class ImportantMethodDemo {
    public static void main(String[] args) throws Exception {
        for (Method m : Service.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod im = m.getAnnotation(ImportantMethod.class);
                System.out.println("Method: " + m.getName() + ", Level: " + im.level());
            }
        }
    }
}