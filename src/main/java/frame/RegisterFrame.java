package frame;

import sum.general.Application;

import java.awt.*;

public class RegisterFrame extends MainFrame{
    public RegisterFrame(Application app, int x, int y, Dimension size) {
        super(app, x, y, size);
        this.view = View.REGISTER;
        this.initialize();
    }
}
