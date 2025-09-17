import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface RoleAllowed {
    String value();
}

class SecureService {
    @RoleAllowed("ADMIN")
    public void adminTask() {
        System.out.println("Admin task executed");
    }
}

public class RoleAllowedDemo {
    public static void main(String[] args) throws Exception {
        SecureService service = new SecureService();
        String currentUserRole = "USER"; // Change to ADMIN to allow access
        for (Method m : SecureService.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed ra = m.getAnnotation(RoleAllowed.class);
                if (ra.value().equals(currentUserRole)) {
                    m.invoke(service);
                } else {
                    System.out.println("Access Denied!");
                }
            }
        }
    }
}