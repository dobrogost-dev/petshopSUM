package sum.order;

import java.io.Serializable;
import java.math.BigDecimal;
public class Order implements Serializable {
    public enum State {
        PENDING, INCOMPLETE, COMPLETE, CANCELLED
    }
    public int id;
    public int clientId;
    public State state;
    public BigDecimal sum;
}
