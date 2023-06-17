package frame;

import sum.general.Application;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends MainFrame{
    public LoginFrame(Application app, int x, int y) {
        super(app, x, y);
        this.view = View.LOGIN;
        JLabel label = new JLabel("Login view");
        logoPanel.add(label, BorderLayout.WEST);
    }
}
