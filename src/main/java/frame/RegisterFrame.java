package frame;

import sum.general.Application;

import javax.swing.*;
import java.awt.*;

public class RegisterFrame extends MainFrame{
    public RegisterFrame(Application app, int x, int y) {
        super(app, x, y);
        this.view = View.REGISTER;

    }
}
