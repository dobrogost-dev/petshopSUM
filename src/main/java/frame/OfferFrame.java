package frame;

import sum.general.Application;

import java.awt.*;

public class OfferFrame extends MainFrame{

    public OfferFrame(Application app, int x, int y, Dimension size) {
        super(app, x, y, size);
        this.view = View.OFFER;
        this.initialize();
    }
}
