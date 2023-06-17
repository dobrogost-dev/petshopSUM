package frame;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MainFrame extends JFrame {
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
        //Adding labels
        //Buttons
        JButton cartButton = new JButton();
        cartButton.setBounds(600,150,140,60);
        cartButton.setText("Koszyk");
        cartButton.addActionListener(e -> System.out.println("Cart button was pressed"));
        cartButton.setBackground(Color.LIGHT_GRAY);
        cartButton.setBorder(border);
        JButton loginButton = new JButton();
        loginButton.setBounds(600,230,140,60);
        loginButton.setText("Zaloguj");
        loginButton.addActionListener(e -> System.out.println("Login button was pressed"));
        loginButton.setBackground(Color.LIGHT_GRAY);
        loginButton.setBorder(border);
        JButton registerButton = new JButton();
        registerButton.setBounds(600,310,140,60);
        registerButton.setText("Zarejestruj");
        registerButton.addActionListener(e -> System.out.println("Register button was pressed"));
        registerButton.setBackground(Color.LIGHT_GRAY);
        registerButton.setBorder(border);
        //Adding Buttons
        this.add(logo);
        this.add(cartButton);
        this.add(loginButton);
        this.add(registerButton);
        //Frame settings
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(800,600);
        this.setLayout(null);
        this.setVisible(true);
        ImageIcon icon = new ImageIcon("paw.png");
        this.setIconImage(icon.getImage());
        this.getContentPane().setBackground(new Color(70, 120, 179));


    }
}
