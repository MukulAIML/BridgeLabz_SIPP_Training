
public class Q4_MultipleCatch {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30};
        Integer[] arr2 = null;
        int index = 5;
        try {
            System.out.println("Value at index " + index + ": " + arr[index]);
            System.out.println(arr2[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        }
    }
}
