import java.lang.reflect.*;
import java.util.*;

public class CustomObjectMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) throws Exception {
        T obj = clazz.getDeclaredConstructor().newInstance();
        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            try {
                Field field = clazz.getDeclaredField(entry.getKey());
                field.setAccessible(true);
                field.set(obj, entry.getValue());
            } catch (NoSuchFieldException e) {
                // ignore
            }
        }
        return obj;
    }

    static class User {
        String name;
        int age;
    }

    public static void main(String[] args) throws Exception {
        Map<String, Object> props = new HashMap<>();
        props.put("name", "Alice");
        props.put("age", 30);

        User user = toObject(User.class, props);
        System.out.println("User: " + user.name + ", Age: " + user.age);
    }
}