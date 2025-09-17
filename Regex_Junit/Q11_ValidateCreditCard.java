
public class Q11_ValidateCreditCard {
    public static void main(String[] args) {
        String[] cards = {"4123456789012345", "5123456789012345", "6123456789012345"};
        String visa = "^4[0-9]{15}$";
        String master = "^5[0-9]{15}$";

        for (String card : cards) {
            if (card.matches(visa)) {
                System.out.println(card + " → Visa");
            } else if (card.matches(master)) {
                System.out.println(card + " → MasterCard");
            } else {
                System.out.println(card + " → Invalid");
            }
        }
    }
}
