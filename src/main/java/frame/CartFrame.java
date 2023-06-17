package frame;

import sum.*;
import sum.general.Application;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

public class CartFrame extends MainFrame {
    public CartFrame(Application app, int x, int y) {
        super(app, x, y);
        this.view = View.CART;
        JLabel label = new JLabel("Cart view");
        logoPanel.add(label, BorderLayout.WEST);
    }
}
