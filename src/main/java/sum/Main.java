package sum;
import frame.OfferFrame;
import frame.StoreFrame;
import sum.general.Account;
import sum.general.Application;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Application app = new Application();
        Account guest = new Account(null, null,null);
        guest.addRole(Account.Role.NONE);
        app.setCurrentUser(guest);
        app.changeFrame(new StoreFrame(app, 300, 100, new Dimension(800,600)));
    }
}