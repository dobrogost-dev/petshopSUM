package sum.product;

import java.io.Serializable;

public class Species implements Serializable {
    public String name;
    public String race;
    public Species(String name, String race) {
        this.name = name;
        this.race = race;
    }

    public String getName() {
        return name;
    }

    public String getRace() {
        return race;
    }
}
