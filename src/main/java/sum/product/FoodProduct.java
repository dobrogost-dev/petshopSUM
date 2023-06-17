package sum.product;

import java.math.BigDecimal;

public class FoodProduct extends Product {
    public String composition;

    public FoodProduct(int id, int amount, BigDecimal price, String name, String country, Species species, String composition) {
        super(id, amount, price, name, country, species);
        this.composition = composition;
    }
}
