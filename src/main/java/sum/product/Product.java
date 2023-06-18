package sum.product;

import java.io.Serializable;
import java.math.BigDecimal;

public abstract class Product implements Serializable {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public int id;
    public int amount;
    public BigDecimal price;
    public String name;
    public String country;
    public Species species;

    public Product(int id, int amount, BigDecimal price, String name, String country, Species species) {
        this.id = id;
        this.amount = amount;
        this.price = price;
        this.name = name;
        this.country = country;
        this.species = species;
    }
    @Override
    public String toString() {
        return "id: " + this.id + " " + this.name + " " + this.species + " ilosc: " + this.amount;
    }
    public void addAmount(int amount) {
        this.amount += amount;
    }
    public abstract Product copy();
}
