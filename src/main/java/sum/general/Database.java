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
        products.add(new FoodProduct(1, 10, new BigDecimal("899.99"), "Karma dla psa", "Niemcy",
                new Species("Pies", "Owczarek Niemiecki"), "Wolowina"));
        products.add(new FoodProduct(2, 5, new BigDecimal("1900.99"), "Karma dla kota", "Persja",
                new Species("Kot", "Perski"), "Losos"));
        return products;
    }
}
