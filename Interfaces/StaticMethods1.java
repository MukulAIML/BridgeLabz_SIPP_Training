
// 1. Password Strength Validator
interface SecurityUtils {
    static boolean isStrongPassword(String password) {
        return password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*[0-9].*");
    }
}

public class StaticMethods1 {
    public static void main(String[] args) {
        System.out.println(SecurityUtils.isStrongPassword("Pass1234"));
    }
}
