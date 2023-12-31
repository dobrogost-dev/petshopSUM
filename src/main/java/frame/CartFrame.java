package frame;

import sum.general.Application;
import sum.product.Product;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CartFrame extends MainFrame {
    private JTable productTable;
    private JButton clearButton;
    private JButton submitButton;

    public CartFrame(Application app, int x, int y, Dimension size) {
        super(app, x, y, size);
        this.view = View.CART;
        List<Product> products = app.getCart();
        ProductTableModel model = new ProductTableModel(products);
        // Ustawianie JTable z modelem
        productTable = new JTable(model);

        // Dodanie przycisku "Dodaj" i "Usuń" na górze tabeli
        clearButton = new JButton("Oproznij");
        clearButton.addActionListener(e -> {
            app.clearCart();
            app.changeFrame(new CartFrame(app, this.getX(), this.getY(), this.getSize()));
            this.dispose();
        });
        submitButton = new JButton("Zloz zamowienie");
        submitButton.addActionListener(e -> {
            app.createOrder(app.currentUser.person.id);
            app.changeFrame(new OfferFrame(app, this.getX(), this.getY(), this.getSize()));
            this.dispose();
        });
        // Ustawianie JScrollPane jako widoku dla JTable
        JScrollPane scrollPane = new JScrollPane(productTable);

        // Ustawianie układu i dodawanie komponentów do panelu głównego
        mainPanel.setLayout(new BorderLayout());

        // Dodawanie przycisków "Dodaj" i "Usuń" obok siebie
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(clearButton);
        buttonPanel.add(submitButton);
        mainPanel.add(buttonPanel, BorderLayout.EAST);
        mainPanel.add(scrollPane, BorderLayout.SOUTH);

        this.initialize();
    }

    class ProductTableModel extends AbstractTableModel {
        private List<Product> products;
        private String[] columnNames = {"ID", "Amount", "Price", "Name", "Country", "Species"};

        public ProductTableModel(List<Product> products) {
            this.products = products;
        }

        @Override
        public int getRowCount() {
            return products.size();
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public Object getValueAt(int row, int column) {
            Product product = products.get(row);
            return switch (column) {
                case 0 -> product.getId();
                case 1 -> product.getAmount();
                case 2 -> product.getPrice();
                case 3 -> product.getName();
                case 4 -> product.getCountry();
                case 5 -> product.getSpecies().getName() + " - " + product.getSpecies().getRace();
                default -> null;
            };
        }

        @Override
        public String getColumnName(int column) {
            return columnNames[column];
        }
    }
}
