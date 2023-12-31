package sum;
import frame.StoreFrame;
import sum.general.Account;
import sum.general.Application;
import sum.order.Order;
import sum.person.ManagerEmployee;
import sum.person.Person;
import sum.product.FoodProduct;
import sum.product.Species;

import java.awt.*;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Application app = new Application();
        Account guest = new Account(null, null,null);
        ManagerEmployee managerEmployee = new ManagerEmployee(1, "Adrian", "Dobrogost",
                23, "104921842", new BigDecimal(10000), true);
        Account manager = new Account(managerEmployee, "admin","123");
        Account service = new Account(null, "service","123");
        Account store = new Account(null, "store","123");
        Account client = new Account(null, "client","123");
        guest.addRole(Account.Role.NONE);
        manager.addRole(Account.Role.SERVICE);
        manager.addRole(Account.Role.MANAGER);
        service.addRole(Account.Role.SERVICE);
        store.addRole(Account.Role.STOREKEEPER);
        client.addRole(Account.Role.CLIENT);

        app.database.addAccount(manager);
        app.database.addAccount(service);
        app.database.addAccount(store);
        app.database.addAccount(client);
        app.setCurrentUser(manager);

        app.changeFrame(new StoreFrame(app, 300, 100, new Dimension(800,600)));
    }
}