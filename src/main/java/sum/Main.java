package sum;
import frame.MainFrame;
import frame.OfferFrame;
import sum.general.Account;
import sum.general.Application;

import javax.swing.*;
import java.awt.*;
public class Main {
    public static void main(String[] args) {
        Application app = new Application();
        Account guest = new Account(null, null,null);
        guest.addRole(Account.Role.NONE);
        app.setCurrentUser(guest);
        app.changeFrame(new OfferFrame(app, 300, 100));
    }
}