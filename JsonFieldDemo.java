import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface JsonField {
    String name();
}

class UserJson {
    @JsonField(name = "user_name")
    String username = "Alice";
    @JsonField(name = "user_age")
    int age = 25;
}

public class JsonFieldDemo {
    public static String toJson(Object obj) throws Exception {
        StringBuilder sb = new StringBuilder("{");
        Field[] fields = obj.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            JsonField jf = fields[i].getAnnotation(JsonField.class);
            if (jf != null) {
                sb.append("\"").append(jf.name()).append("\":\"").append(fields[i].get(obj)).append("\"");
                if (i < fields.length - 1) sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        UserJson user = new UserJson();
        System.out.println(toJson(user));
    }
}