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

public class StoreFrame extends MainFrame {
    private JTable productTable;
    private JButton addButton;
    private JButton deleteButton;

    public StoreFrame(Application app, int x, int y, Dimension size) {
        super(app, x, y, size);
        this.view = View.STORE;
        List<Product> products = app.database.getProducts();
        ProductTableModel model = new ProductTableModel(products);
        // Ustawianie JTable z modelem
        productTable = new JTable(model);

        // Dodanie przycisku "Dodaj" i "Usuń" na górze tabeli
        addButton = new JButton("Dodaj");
        deleteButton = new JButton("Usuń");

        // Ustawianie JScrollPane jako widoku dla JTable
        JScrollPane scrollPane = new JScrollPane(productTable);

        // Ustawianie układu i dodawanie komponentów do panelu głównego
        mainPanel.setLayout(new BorderLayout());

        // Dodawanie przycisków "Dodaj" i "Usuń" obok siebie
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        mainPanel.add(buttonPanel, BorderLayout.NORTH);

        mainPanel.add(scrollPane, BorderLayout.CENTER);

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
