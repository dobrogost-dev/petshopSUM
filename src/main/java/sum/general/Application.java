package sum.general;
import frame.MainFrame;
import sum.order.Order;
import sum.product.Product;

import javax.swing.*;
import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public Database database;
    public Account currentUser;
    public JFrame currentFrame;
    public List<Product> cart;
    String fileName = "database.ser";
    public Application() {
        database = new Database();
        cart = new ArrayList<>();

        try (FileInputStream fileIn = new FileInputStream(fileName);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {

            database = (Database) objectIn.readObject();

            System.out.println("Obiekt Database został wczytany z pliku " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Wystąpił błąd podczas wczytywania obiektu Database: " + e.getMessage());
        }
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
    public int generateUniqueOrderId() {
        int id = 1;
        int finalId = id;
        while (database.orders.stream().anyMatch(e -> e.id == finalId)) {
            id++;
        }
        return id;
    }
    public void createOrder(int clientId) {
        BigDecimal sum = Product.sumAllProducts(cart);
        Order order = new Order(generateUniqueOrderId(), clientId, Order.State.INCOMPLETE, sum, cart);
        database.orders.add(order);
        clearCart();
        saveDatabase();
    }
    public void saveDatabase() {
        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {

            objectOut.writeObject(database);

            System.out.println("Obiekt Database został zapisany do pliku " + fileName);
        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas zapisywania obiektu Database: " + e.getMessage());
        }
        }
}
