import java.util.HashMap;

public class Inventory {
    private HashMap<Integer, Product> products = new HashMap<>();

    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
        System.out.println("Product added: " + product);
    }

    public void updateProduct(int productId, String name, int quantity, double price) {
        Product product = products.get(productId);
        if (product != null) {
            product.setProductName(name);
            product.setQuantity(quantity);
            product.setPrice(price);
            System.out.println("Product updated: " + product);
        } else {
            System.out.println("Product not found.");
        }
    }

    public void deleteProduct(int productId) {
        Product removed = products.remove(productId);
        if (removed != null) {
            System.out.println("Product removed: " + removed);
        } else {
            System.out.println("Product not found.");
        }
    }

    public void listProducts() {
        for (Product p : products.values()) {
            System.out.println(p);
        }
    }
}
