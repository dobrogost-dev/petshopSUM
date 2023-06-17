package sum.product;

import sum.product.Product;

import java.math.BigDecimal;

public class UtilityProduct extends Product {
    public String brand;

    public UtilityProduct(int id, int amount, BigDecimal price, String name, String country, Species species, String brand) {
        super(id, amount, price, name, country, species);
        this.brand = brand;
    }
}
