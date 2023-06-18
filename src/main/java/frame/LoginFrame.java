package frame;

import sum.general.Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends MainFrame implements ActionListener {
    JLabel loginText;
    JLabel passwordText;
    JTextField loginTextField;
    JTextField passwordTextField;
    JButton submitButton;
    JPanel dataPanel;
    public LoginFrame(Application app, int x, int y, Dimension dimension) {
        super(app, x, y, dimension);
        this.view = View.LOGIN;
        submitButton = new JButton();
        loginText = new JLabel("login");
        loginTextField = new JTextField();
        passwordText = new JLabel("haslo");
        passwordTextField = new JTextField();

        dataPanel = new JPanel();
        dataPanel.setLayout(new GridBagLayout());

        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        mainPanel.add(dataPanel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;

        gbc.gridx = 0;
        gbc.gridy = 0;
        dataPanel.add(loginText, gbc);

        gbc.gridy = 1;
        dataPanel.add(loginTextField, gbc);

        gbc.gridy = 2;
        dataPanel.add(passwordText, gbc);

        gbc.gridy = 3;
        dataPanel.add(passwordTextField, gbc);

        gbc.gridy = 4;
        dataPanel.add(submitButton, gbc);

        submitButton.setText("Wprowadz");
        submitButton.addActionListener(e -> {
            if (app.login(loginTextField.getText(), passwordTextField.getText())) {
                System.out.println("im in2");
                app.changeFrame(new OfferFrame(app, this.getX(), this.getY(), this.getSize()));
                this.dispose();
            }
        });
        submitButton.setPreferredSize(new Dimension(200,100));
        submitButton.setBackground(Color.LIGHT_GRAY);
        submitButton.setBorder(border);

        this.initialize();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
