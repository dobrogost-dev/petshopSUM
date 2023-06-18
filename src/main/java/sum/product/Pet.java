package sum.product;

import java.math.BigDecimal;

public class Pet extends Product {
    public String gender;
    public boolean isForChildren;
    public Pet(int id, int amount, BigDecimal price, String name, String country, Species species, String gender, boolean isForChildren) {
        super(id, amount, price, name, country, species);
        this.gender = gender;
        this.isForChildren = isForChildren;
    }
    public Product copy(){
        return new Pet(
                this.id,
                this.amount,
                this.price,
                this.name,
                this.country,
                this.species,
                this.gender,
                this.isForChildren
        );
    }
}
