package sum;

import java.math.BigDecimal;
public class Order {
    public enum State {
        PENDING, INCOMPLETE, COMPLETE, CANCELLED
    }
    public int id;
    public int clientId;
    public State state;
    public BigDecimal sum;
}
