package sum.product;

import java.io.Serializable;
import java.math.BigDecimal;

public abstract class Product implements Serializable {
    public int id;
    public int amount;
    public BigDecimal price;
    public String name;
    public String country;
    public Species species;
}
