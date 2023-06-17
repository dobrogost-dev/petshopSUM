package sum;
import frame.MainFrame;

import javax.swing.*;
import java.awt.*;
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}