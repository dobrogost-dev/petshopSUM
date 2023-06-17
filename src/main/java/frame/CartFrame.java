package frame;

import sum.general.Application;

import java.awt.*;

public class CartFrame extends MainFrame {
    public CartFrame(Application app, int x, int y, Dimension size) {
        super(app, x, y, size);
        this.view = View.CART;
        this.initialize();
    }
}
