package frame;

import sum.general.Application;
import sum.product.Product;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class StoreFrame extends MainFrame{
    private JTable productTable;
    public StoreFrame(Application app, int x, int y, Dimension size) {
        super(app, x, y, size);
        this.view = View.STORE;
        List<Product> products = app.database.getProducts();
        ProductTableModel model = new ProductTableModel(products);

        // Ustawianie JTable z modelem
        productTable = new JTable(model);
        // Dodanie przycisku "Dodaj" na górze tabeli
        JButton addButton = new JButton("Dodaj");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Tutaj można dodać kod obsługi kliknięcia przycisku "Dodaj"
            }
        });

        // Ustawianie JScrollPane jako widoku dla JTable
        JScrollPane scrollPane = new JScrollPane(productTable);

        // Ustawianie układu i dodawanie komponentów do panelu głównego
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        setLocationRelativeTo(null);

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
            switch (column) {
                case 0:
                    return product.getId();
                case 1:
                    return product.getAmount();
                case 2:
                    return product.getPrice();
                case 3:
                    return product.getName();
                case 4:
                    return product.getCountry();
                case 5:
                    return product.getSpecies().getName() + " - " + product.getSpecies().getRace();
                default:
                    return null;
            }
        }

        @Override
        public String getColumnName(int column) {
            return columnNames[column];
        }
    }
}
