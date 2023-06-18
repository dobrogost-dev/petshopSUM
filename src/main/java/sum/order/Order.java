package sum.order;

import sum.product.Product;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class Order implements Serializable {
    public Order(int id, int clientId, State state, BigDecimal sum, List<Product> products) {
        this.id = id;
        this.clientId = clientId;
        this.state = state;
        this.sum = sum;
        this.products = products;
    }

    public enum State {
        PENDING, INCOMPLETE, COMPLETE, CANCELLED
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int id;
    public int clientId;
    public State state;
    public BigDecimal sum;
    List<Product> products;
}
