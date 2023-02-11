package sem_01_cw;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private List<Product> products = new ArrayList<>();

    private double money;

    public double getMoney() {
        return money;
    }

    public List<Product> getProducts() {
        return products;
    }

    public VendingMachine addProduct(Product product) {
        products.add(product);
        return this;
    }

    public Product findProduct(String name) {
        for (Product product: getProducts()) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    public Product buy(String name, double price) {
        Product productFound = findProduct(name);
        if (productFound == null) {
            return null;
        }
        if (productFound.getCost() == price) {
            products.remove(productFound);
            money += productFound.getCost();
            return productFound;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (Product product: getProducts()) {
            output.append(product).append("\n");
        }
        output.append(money);
        return output.toString();
    }
}
