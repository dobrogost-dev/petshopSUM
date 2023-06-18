package sum.general;
import frame.MainFrame;
import sum.product.Product;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public Database database;
    public Account currentUser;
    public JFrame currentFrame;
    public List<Product> cart;

    public Application() {
        database = new Database();
        cart = new ArrayList<>();
    }
    public Database getDatabase() {
        return database;
    }

    public List<Product> getCart() {
        return cart;
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

    public boolean addProductToCart(String idString, String amountString) {
        int id = 0;
        int amount = 0;
        try {
            id = Integer.parseInt(idString);
            amount = Integer.parseInt(amountString);
        } catch (NumberFormatException e) {
            System.out.println("Podana wartosc nie jest intem");
            return false;
        }
        int finalId = id;
        int finalAmount = amount;

        Product databaseProduct = database.getProductById(finalId);
        Product newProduct = databaseProduct.copy();
        System.out.println("DB: " + databaseProduct);
        newProduct.setAmount(finalAmount);
        if (finalAmount <= 0) {
            System.out.println("Zla ilosc");
            return false;
        }
        if (cart.stream().anyMatch(c -> c.getId() == databaseProduct.getId())) {
            if (getCartProductById(finalId).getAmount() + finalAmount <= databaseProduct.getAmount()) {
                getCartProductById(finalId).addAmount(finalAmount);
                System.out.println("Dodano " + amount + " do poprzedniego zamowienia");
                return true;
            } else {
                System.out.println("Zla ilosc");
                return false;
            }
        }
        if (database.products.stream().noneMatch(p -> p.id == finalId)) {
            System.out.println("Zle id");
            return false;
        }

        cart.add(newProduct);
        System.out.println(Arrays.toString(cart.toArray()));
        return true;
    }
    public Product getCartProductById(int id) {
        for (Product product : cart) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void clearCart() {
        cart = new ArrayList<>();
    }

    public boolean login(String login, String password) {
        for(Account account : database.accounts) {
            if (account.login.equals(login)
             && account.password.equals(password)) {
                currentUser = account;
                return true;
            }
        }
        return false;
    }
    public void logout() {
        Account guest = new Account(null, null,null);
        guest.addRole(Account.Role.NONE);
        currentUser = guest;
    }
}
