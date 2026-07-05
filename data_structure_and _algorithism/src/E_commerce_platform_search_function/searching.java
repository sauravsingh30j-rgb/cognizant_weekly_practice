package E_commerce_platform_search_function;

import java.util.Arrays;
import java.util.Comparator;

public class searching {

    public Product linearSearch(Product[] products, String key) {

        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(key)) {
                return p;
            }
        }
        return null;
    }

    public Product binarySearch(Product[] products, String key) {

        Arrays.sort(products, Comparator.comparing(p -> p.productName));

        int low = 0;
        int high = products.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int result = products[mid].productName.compareToIgnoreCase(key);

            if (result == 0)
                return products[mid];
            else if (result < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return null;
    }
}