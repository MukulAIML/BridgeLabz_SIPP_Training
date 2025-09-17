import java.lang.reflect.*;

class PersonJson {
    String name = "Bob";
    int age = 40;
}

public class JsonGenerator {
    public static String toJson(Object obj) throws Exception {
        StringBuilder sb = new StringBuilder("{");
        Field[] fields = obj.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            sb.append("\"").append(fields[i].getName()).append("\":\"").append(fields[i].get(obj)).append("\"");
            if (i < fields.length - 1) sb.append(", ");
        }
        sb.append("}");
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        PersonJson p = new PersonJson();
        System.out.println(toJson(p));
    }
}