package frame;

import sum.general.Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddProductClientFrame extends MainFrame implements ActionListener {
    JLabel idText;
    JLabel amountText;
    JTextField idTextField;
    JTextField amountTextField;
    JButton submitButton;
    JPanel dataPanel;
    public AddProductClientFrame(Application app, int x, int y, Dimension dimension) {
        super(app, x, y, dimension);
        this.view = View.ADD_PRODUCT_CLIENT;
        submitButton = new JButton();
        idText = new JLabel("id");
        idTextField = new JTextField();
        amountText = new JLabel("Ilosc");
        amountTextField = new JTextField();

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
        dataPanel.add(idText, gbc);

        gbc.gridy = 1;
        dataPanel.add(idTextField, gbc);

        gbc.gridy = 2;
        dataPanel.add(amountText, gbc);

        gbc.gridy = 3;
        dataPanel.add(amountTextField, gbc);

        gbc.gridy = 4;
        dataPanel.add(submitButton, gbc);

        submitButton.setText("Wprowadz");
        submitButton.addActionListener(e -> {
            if (app.addProductToCart(idTextField.getText(), amountTextField.getText())) {
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
