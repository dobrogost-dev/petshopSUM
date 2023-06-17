package frame;

import sum.general.Application;

import java.awt.*;

public class LoginFrame extends MainFrame{
    public LoginFrame(Application app, int x, int y, Dimension size) {
        super(app, x, y, size);
        this.view = View.LOGIN;

        this.initialize();
    }
}
