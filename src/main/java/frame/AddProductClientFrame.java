package frame;

import sum.general.Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddProductClientFrame extends MainFrame implements ActionListener {
    JTextField idTextField;
    JTextField amountTextField;
    JButton submitButton;
    JPanel dataPanel;
    public AddProductClientFrame(Application app, int x, int y, Dimension dimension) {
        super(app, x, y, dimension);
        this.view = View.ADD_PRODUCT_CLIENT;
        submitButton = new JButton();
        idTextField = new JTextField();
        amountTextField = new JTextField();

        dataPanel = new JPanel();

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(dataPanel, BorderLayout.CENTER);
        dataPanel.setLayout(new BoxLayout(dataPanel, BoxLayout.Y_AXIS));

        idTextField.setPreferredSize(new Dimension(100, 40));
        idTextField.setMaximumSize(new Dimension(100, 40));
        idTextField.setText("id produktu");
        amountTextField.setPreferredSize(new Dimension(100, 40));
        amountTextField.setMaximumSize(new Dimension(100, 40));
        amountTextField.setText("ilosc");

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

        dataPanel.add(idTextField);
        dataPanel.add(amountTextField);
        dataPanel.add(submitButton);
        this.initialize();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
