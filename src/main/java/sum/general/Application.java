package sum.general;
import frame.MainFrame;
import sum.product.Product;

import javax.swing.*;
import java.util.List;

public class Application {
    public Database database;
    public Account currentUser;
    public JFrame currentFrame;
    public List<Product> cart;

    public Application() {
        database = new Database();
    }

    public void changeFrame(JFrame newFrame) {
        currentFrame = newFrame;
    }
    public Account getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(Account currentUser) {
        this.currentUser = currentUser;
    }
}
