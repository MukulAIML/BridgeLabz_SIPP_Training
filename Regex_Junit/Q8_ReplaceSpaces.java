
public class Q8_ReplaceSpaces {
    public static void main(String[] args) {
        String text = "This   is  an   example   with   multiple   spaces.";
        String replaced = text.replaceAll(" +", " ");
        System.out.println(replaced);
    }
}
