
// 1. Data Serialization for Backup
import java.io.Serializable;

class UserData implements Serializable {
    String name;
    UserData(String name) { this.name = name; }
}

public class MarkerInterfaces1 {
    public static void main(String[] args) {
        UserData data = new UserData("Alice");
        System.out.println("User data is serializable.");
    }
}
