import java.util.*;

class Product {
    String name;
    double price;
    double rating;
    double discount;

    Product(String name, double price, double rating, double discount) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return name + " - $" + price + " - Rating: " + rating + " - Discount: " + discount + "%";
    }
}

public class ECommerceSorting {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", 1200, 4.5, 10),
            new Product("Phone", 800, 4.7, 15),
            new Product("Headphones", 200, 4.2, 20)
        );

        System.out.println("Sort by Price:");
        products.stream().sorted((p1, p2) -> Double.compare(p1.price, p2.price)).forEach(System.out::println);

        System.out.println("\nSort by Rating:");
        products.stream().sorted((p1, p2) -> Double.compare(p2.rating, p1.rating)).forEach(System.out::println);

        System.out.println("\nSort by Discount:");
        products.stream().sorted((p1, p2) -> Double.compare(p2.discount, p1.discount)).forEach(System.out::println);
    }
}