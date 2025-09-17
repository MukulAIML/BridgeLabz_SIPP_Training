import java.lang.reflect.*;

class Student {
    String name;
    public Student() {
        this.name = "Default Student";
    }
}

public class DynamicStudent {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("Student");
        Object studentObj = clazz.getDeclaredConstructor().newInstance();
        System.out.println("Created object: " + studentObj.getClass().getName());
    }
}