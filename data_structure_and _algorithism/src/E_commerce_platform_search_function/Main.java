package E_commerce_platform_search_function;

public class Main {

    public static void main(String[] args) {

        Product[] products = {
                new Product(101, "Laptop", 65000),
                new Product(102, "Mouse", 800),
                new Product(103, "Keyboard", 1500),
                new Product(104, "Monitor", 12000),
                new Product(105, "Phone", 25000)
        };

        searching search = new searching();

        String key = "Monitor";

        System.out.println("----- Linear Search -----");

        Product p = search.linearSearch(products, key);

        if (p != null) {
            p.display();
        } else {
            System.out.println("Product not found.");
        }

        System.out.println();

        System.out.println("----- Binary Search -----");

        p = search.binarySearch(products, key);

        if (p != null) {
            p.display();
        } else {
            System.out.println("Product not found.");
        }
    }
}