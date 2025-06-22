import java.util.Arrays;
import java.util.Comparator;

class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String toStrings() {
        return "ProductID: " + productId + ", Name: " + productName + ", Category: " + category;
    }
}

class LinearSearch {
    public static Product linearSearch(Product[] products, String name) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }
}

class BinarySearch {
    public static Product binarySearch(Product[] products, String name) {
        int low = 0, high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(name);

            if (cmp == 0)
                return products[mid];
            else if (cmp < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return null;
    }

    public static void sortProducts(Product[] products) {
        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));
    }
}

public class Main {
    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shoes", "Footwear"),
            new Product(103, "Watch", "Accessories"),
            new Product(104, "Mobile", "Electronics"),
        };

      
        Product foundLinear = LinearSearch.linearSearch(products, "Watch");
        System.out.println("Linear Search Result: " + (foundLinear != null ? foundLinear : "Not Found"));

        
        BinarySearch.sortProducts(products);

      
        Product foundBinary = BinarySearch.binarySearch(products, "Watch");
        System.out.println("Binary Search Result: " + (foundBinary != null ? foundBinary : "Not Found"));
    }
}
