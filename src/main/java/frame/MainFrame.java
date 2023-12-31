package frame;

import sum.*;
import sum.general.Account;
import sum.general.Application;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    public enum View {
        MAIN, OFFER, CART, LOGIN, REGISTER, STORE, ADD_PRODUCT_CLIENT, ADD_PRODUCT_STORE, SUMMARY, DISCOUNT
    }
    public Application app;
    public View view;
    public JButton logo;
    public JButton cartButton;
    public JButton loginButton;
    public JButton registerButton;
    public JButton storeButton;
    public JButton logoutButton;
    public JButton orderButton;
    public JPanel logoPanel;
    public JPanel buttonsPanel;
    public JPanel mainPanel;
    public Border border;
    public MainFrame(Application app, int x, int y, Dimension dimension) {
        this.app = app;
        this.setLocation(x,y);
        logo = new JButton();
        cartButton = new JButton();
        loginButton = new JButton();
        logoutButton = new JButton();
        registerButton = new JButton();
        storeButton = new JButton();
        orderButton = new JButton();
        logoPanel = new JPanel();
        buttonsPanel = new JPanel();
        mainPanel = new JPanel();
        this.setSize(dimension);
        //Border
        border = BorderFactory.createLineBorder(Color.BLACK);
        //Logo Button
        logo.setText("Zwierzetex");
        logo.setBackground(Color.CYAN);
        logo.setBounds(250,50,240,60);
        logo.setOpaque(true);
        logo.setBorder(border);
        logo.setFont(new Font("Arial", Font.PLAIN, 44));
        logo.addActionListener(e -> {
            app.changeFrame(new OfferFrame(app, this.getX(), this.getY(), this.getSize()));
            this.dispose();
        });
        //Buttons
        cartButton.setPreferredSize(new Dimension(100,50));
        cartButton.setText("Koszyk");
        cartButton.addActionListener(e -> {
            app.changeFrame(new CartFrame(app, this.getX(), this.getY(), this.getSize()));
            this.dispose();
        });
        cartButton.setBackground(Color.LIGHT_GRAY);
        cartButton.setBorder(border);

        loginButton.setText("Zaloguj");
        loginButton.addActionListener(e -> {
            app.changeFrame(new LoginFrame(app, this.getX(), this.getY(), this.getSize()));
            this.dispose();
        });
        loginButton.setPreferredSize(new Dimension(100,50));
        loginButton.setBackground(Color.LIGHT_GRAY);
        loginButton.setBorder(border);

        logoutButton.setText("Wyloguj");
        logoutButton.addActionListener(e -> {
            app.logout();
            app.changeFrame(new OfferFrame(app, this.getX(), this.getY(), this.getSize()));
            this.dispose();
        });
        logoutButton.setPreferredSize(new Dimension(100,50));
        logoutButton.setBackground(Color.LIGHT_GRAY);
        logoutButton.setBorder(border);
        registerButton.setText("Zarejestruj");
        registerButton.addActionListener(e -> {
            app.changeFrame(new RegisterFrame(app, this.getX(), this.getY(), this.getSize()));
            this.dispose();
        });
        registerButton.setPreferredSize(new Dimension(100,50));
        registerButton.setBackground(Color.LIGHT_GRAY);
        registerButton.setBorder(border);

        storeButton.setText("Magazyn");
        storeButton.addActionListener(e -> {
            app.changeFrame(new StoreFrame(app, this.getX(), this.getY(), this.getSize()));
            this.dispose();
        });
        storeButton.setPreferredSize(new Dimension(100,50));
        storeButton.setBackground(Color.LIGHT_GRAY);
        storeButton.setBorder(border);

        orderButton.setText("Zamowienia");
        orderButton.addActionListener(e -> {
            app.changeFrame(new OrderFrame(app, this.getX(), this.getY(), this.getSize()));
            this.dispose();
        });
        orderButton.setPreferredSize(new Dimension(100,50));
        orderButton.setBackground(Color.LIGHT_GRAY);
        orderButton.setBorder(border);
        //Panele
        logoPanel.setBackground(Color.BLUE);
        logoPanel.setPreferredSize(new Dimension(800,100));
        logoPanel.setBorder(border);
        buttonsPanel.setBackground(Color.RED);
        buttonsPanel.setBorder(border);
        buttonsPanel.setPreferredSize(new Dimension(200,500));
        mainPanel.setBackground(Color.GREEN);
        mainPanel.setBorder(border);
        mainPanel.setPreferredSize(new Dimension(600,500));
    }
    public void initialize() {
        this.add(logoPanel, BorderLayout.NORTH);
        this.add(buttonsPanel, BorderLayout.EAST);
        this.add(mainPanel);
        logoPanel.add(logo, BorderLayout.CENTER);
        buttonsPanel.add(cartButton);
        if (app.currentUser.getRoles().contains(Account.Role.NONE)) {
            buttonsPanel.add(loginButton);
            buttonsPanel.add(registerButton);
        } else {
            buttonsPanel.add(logoutButton);
        }
        if(app.currentUser.getRoles().contains(Account.Role.STOREKEEPER)) {
        buttonsPanel.add(storeButton);
        }
        if(app.currentUser.getRoles().contains(Account.Role.SERVICE)) {
            buttonsPanel.add(orderButton);
        }


        JLabel roles = new JLabel("Roles: " + app.currentUser.getRoles());
        logoPanel.add(roles, BorderLayout.WEST);
        JLabel view = new JLabel("View: " + this.view.toString());
        logoPanel.add(view, BorderLayout.WEST);

        this.setTitle("Zwierzetex");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setVisible(true);
        ImageIcon icon = new ImageIcon("paw.png");
        this.setIconImage(icon.getImage());
        this.getContentPane().setBackground(new Color(70, 120, 179));
    }
}
