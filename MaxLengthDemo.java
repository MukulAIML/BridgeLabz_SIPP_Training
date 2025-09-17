import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface MaxLength {
    int value();
}

class User {
    @MaxLength(10)
    String username;

    public User(String username) throws Exception {
        Field f = this.getClass().getDeclaredField("username");
        MaxLength ml = f.getAnnotation(MaxLength.class);
        if (username.length() > ml.value()) {
            throw new IllegalArgumentException("Username exceeds max length");
        }
        this.username = username;
    }
}

public class MaxLengthDemo {
    public static void main(String[] args) throws Exception {
        try {
            User u1 = new User("ShortName");
            System.out.println("Created: " + u1.username);
            User u2 = new User("ThisNameIsTooLong");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}