package sum.general;

import sum.order.Order;
import sum.product.Product;

import java.io.Serializable;
import java.util.List;

public class Database implements Serializable {
    public List<Account> accounts;
    public List<Product> products;
    public List<Order> orders;
}
