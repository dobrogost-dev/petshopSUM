package frame;

import sum.general.Application;
import sum.order.Order;
import sum.product.Product;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

public class OrderFrame extends MainFrame {
    private JTable orderTable;
    private JButton clearButton;
    private JButton submitButton;

    public OrderFrame(Application app, int x, int y, Dimension size) {
        super(app, x, y, size);
        this.view = View.CART;
        List<Order> orders = app.getDatabase().getOrders();
        OrderTableModel model = new OrderTableModel(orders);
        // Ustawianie JTable z modelem
        orderTable = new JTable(model);

        // Ustawianie JScrollPane jako widoku dla JTable
        JScrollPane scrollPane = new JScrollPane(orderTable);

        // Ustawianie układu i dodawanie komponentów do panelu głównego
        mainPanel.setLayout(new BorderLayout());

        // Dodawanie przycisków "Dodaj" i "Usuń" obok siebie
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        mainPanel.add(buttonPanel, BorderLayout.EAST);
        mainPanel.add(scrollPane, BorderLayout.SOUTH);

        this.initialize();
    }

    class OrderTableModel extends AbstractTableModel {
        private List<Order> orders;
        private String[] columnNames = {"ID", "ClientId", "State", "Sum", "Products"};

        public OrderTableModel(List<Order> orders) {
            this.orders = orders;
        }

        @Override
        public int getRowCount() {
            return orders.size();
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public Object getValueAt(int row, int column) {
            Order order = orders.get(row);
            return switch (column) {
                case 0 -> order.getId();
                case 1 -> order.getClientId();
                case 2 -> order.getState().toString();
                case 3 -> order.getSum();
                case 4 -> order.getProducts().stream()
                        .map(Product::toString)
                        .collect(Collectors.joining(", "));
                default -> null;
            };
        }

        @Override
        public String getColumnName(int column) {
            return columnNames[column];
        }
    }
}
