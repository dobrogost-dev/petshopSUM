package frame;

import sum.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    public JList<String> productList;
    public MainFrame() {
        //Border
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        //Logo Button
        JButton logo = new JButton();
        logo.setText("Zwierzetex");
        logo.setBackground(Color.CYAN);
        logo.setBounds(250,50,240,60);
        logo.setOpaque(true);
        logo.setBorder(border);
        logo.setFont(new Font("Arial", Font.PLAIN, 44));
        //Buttons
        JButton cartButton = new JButton();
        cartButton.setPreferredSize(new Dimension(100,50));
        cartButton.setText("Koszyk");
        cartButton.addActionListener(e -> System.out.println("Cart button was pressed"));
        cartButton.setBackground(Color.LIGHT_GRAY);
        cartButton.setBorder(border);
        JButton loginButton = new JButton();
        loginButton.setText("Zaloguj");
        loginButton.addActionListener(e -> System.out.println("Login button was pressed"));
        loginButton.setPreferredSize(new Dimension(100,50));
        loginButton.setBackground(Color.LIGHT_GRAY);
        loginButton.setBorder(border);
        JButton registerButton = new JButton();
        registerButton.setText("Zarejestruj");
        registerButton.addActionListener(e -> System.out.println("Register button was pressed"));
        registerButton.setPreferredSize(new Dimension(100,50));
        registerButton.setBackground(Color.LIGHT_GRAY);
        registerButton.setBorder(border);

        ArrayList<String> products = new ArrayList<>();
        products.add("Karma dla psa");
        products.add("Karma dla kota");
        products.add("Zabawka dla gryzonia");

        //Panele
        JPanel logoPanel = new JPanel();
        logoPanel.setBackground(Color.BLUE);
        logoPanel.setPreferredSize(new Dimension(800,100));
        logoPanel.setBorder(border);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(Color.RED);
        buttonsPanel.setBorder(border);
        buttonsPanel.setPreferredSize(new Dimension(200,500));
        JPanel productsPanel = new JPanel();
        productsPanel.setBackground(Color.GREEN);
        productsPanel.setBorder(border);
        productsPanel.setPreferredSize(new Dimension(600,500));

        //Adding
        this.add(logoPanel, BorderLayout.NORTH);
        this.add(buttonsPanel, BorderLayout.EAST);
        this.add(productsPanel);

        JLabel label = new JLabel("Client view");
        logoPanel.add(label, BorderLayout.WEST);
        logoPanel.add(logo, BorderLayout.CENTER);
        buttonsPanel.add(cartButton);
        buttonsPanel.add(loginButton);
        buttonsPanel.add(registerButton);
        //Frame settings
        this.setTitle("Zwierzetex");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setSize(800,600);
        this.setVisible(true);
        ImageIcon icon = new ImageIcon("paw.png");
        this.setIconImage(icon.getImage());
        this.getContentPane().setBackground(new Color(70, 120, 179));
    }
}
