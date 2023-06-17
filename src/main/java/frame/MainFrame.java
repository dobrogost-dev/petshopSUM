package frame;

import sum.*;
import sum.general.Application;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    public enum View {
        MAIN, OFFER, CART, LOGIN, REGISTER, STORE
    }
    public Application app;
    public View view;
    public JButton logo;
    public JButton cartButton;
    public JButton loginButton;
    public JButton registerButton;
    public JPanel logoPanel;
    public JPanel buttonsPanel;
    public JPanel mainPanel;
    public MainFrame(Application app, int x, int y) {
        this.app = app;
        this.setLocation(x,y);
        logo = new JButton();
        cartButton = new JButton();
        loginButton = new JButton();
        registerButton = new JButton();
        logoPanel = new JPanel();
        buttonsPanel = new JPanel();
        mainPanel = new JPanel();

        //Border
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        //Logo Button
        logo.setText("Zwierzetex");
        logo.setBackground(Color.CYAN);
        logo.setBounds(250,50,240,60);
        logo.setOpaque(true);
        logo.setBorder(border);
        logo.setFont(new Font("Arial", Font.PLAIN, 44));
        //Buttons
        cartButton.setPreferredSize(new Dimension(100,50));
        cartButton.setText("Koszyk");
        cartButton.addActionListener(e -> {
            app.changeFrame(new CartFrame(app, this.getX(), this.getY()));
            this.dispose();
        });
        cartButton.setBackground(Color.LIGHT_GRAY);
        cartButton.setBorder(border);
        loginButton.setText("Zaloguj");
        loginButton.addActionListener(e -> {
            app.changeFrame(new LoginFrame(app, this.getX(), this.getY()));
            this.dispose();
        });
        loginButton.setPreferredSize(new Dimension(100,50));
        loginButton.setBackground(Color.LIGHT_GRAY);
        loginButton.setBorder(border);
        registerButton.setText("Zarejestruj");
        registerButton.addActionListener(e -> {
            app.changeFrame(new RegisterFrame(app, this.getX(), this.getY()));
            this.dispose();
        });
        registerButton.setPreferredSize(new Dimension(100,50));
        registerButton.setBackground(Color.LIGHT_GRAY);
        registerButton.setBorder(border);

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

        this.add(logoPanel, BorderLayout.NORTH);
        this.add(buttonsPanel, BorderLayout.EAST);
        this.add(mainPanel);
        logoPanel.add(logo, BorderLayout.CENTER);
        buttonsPanel.add(cartButton);
        buttonsPanel.add(loginButton);
        buttonsPanel.add(registerButton);

        JLabel roles = new JLabel("Roles: " + app.currentUser.getRoles());
        logoPanel.add(roles, BorderLayout.WEST);
        JLabel view = new JLabel("View: ");
        logoPanel.add(view, BorderLayout.WEST);

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
