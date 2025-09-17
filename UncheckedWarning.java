import java.util.*;

public class UncheckedWarning {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("Hello");
        list.add(123);
        System.out.println(list);
    }
}