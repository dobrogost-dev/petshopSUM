package frame;

import sum.general.Application;

import javax.swing.*;
import java.awt.*;

public class OfferFrame extends MainFrame{

    public OfferFrame(Application app, int x, int y) {
        super(app, x, y);
        this.view = View.OFFER;
        JLabel label = new JLabel("Offer view");
        logoPanel.add(label, BorderLayout.WEST);
    }
}
