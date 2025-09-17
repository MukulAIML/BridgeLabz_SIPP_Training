import java.lang.reflect.*;

class Person {
    private int age;
}

public class PersonReflection {
    public static void main(String[] args) throws Exception {
        Person p = new Person();
        Field ageField = Person.class.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.setInt(p, 25);
        System.out.println("Modified Age: " + ageField.getInt(p));
    }
}