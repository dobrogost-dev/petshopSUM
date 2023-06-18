package sum.product;

import java.math.BigDecimal;

public class FoodProduct extends Product {
    public String composition;

    public FoodProduct(int id, int amount, BigDecimal price, String name, String country, Species species, String composition) {
        super(id, amount, price, name, country, species);
        this.composition = composition;
    }
    public Product copy(){
        return new FoodProduct(
                this.id,
                this.amount,
                this.price,
                this.name,
                this.country,
                this.species,
                this.composition
        );
    }
}
