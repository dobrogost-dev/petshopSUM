package sum.general;

import sum.order.Order;
import sum.product.FoodProduct;
import sum.product.Product;
import sum.product.Species;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Database implements Serializable {
    public List<Account> accounts;
    public List<Product> products;
    public List<Order> orders;

    public Database() {
        accounts = new ArrayList<>();
        products = new ArrayList<>();
        orders = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Order> getOrders() {
        return orders;
    }
    public Product getProductById(int id) {
        return products.stream()
                .filter(p -> p.id == id)
                .findFirst().get();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }
}
