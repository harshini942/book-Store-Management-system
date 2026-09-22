package controller;

import view.ProductView;
import config.DBConnection;
import javax.swing.*;
import java.sql.*;

public class ProductController {

    // This constructor connects the view with the database
    public ProductController(ProductView view) {

        // Load all products when page opens
        loadAllProducts(view);

        // Check low stock when page opens
        checkRestock(view);

        // ADD PRODUCT
        view.btnAdd.addActionListener(e -> {
            try {
                // Get database connection
                Connection con = DBConnection.getConnection();

                // SQL to add product
                PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO products(title,category,price,stock) VALUES (?,?,?,?)"
                );

                // Get values from form
                ps.setString(1, view.txtTitle.getText());
                ps.setString(2, view.cmbCategory.getSelectedItem().toString());
                ps.setDouble(3, Double.parseDouble(view.txtPrice.getText()));
                ps.setInt(4, Integer.parseInt(view.txtStock.getText()));

                // Save data
                ps.executeUpdate();

                // Show message
                JOptionPane.showMessageDialog(null, "Product Added");

                // Refresh table
                loadAllProducts(view);
                checkRestock(view);

            } catch (Exception ex) {
                // Show error
                ex.printStackTrace();
            }
        });

        // SEARCH PRODUCT
        view.btnSearch.addActionListener(e -> searchProducts(view));

        // LOAD TABLE DATA TO FIELDS
        view.table.getSelectionModel().addListSelectionListener(e -> {
            int row = view.table.getSelectedRow();
            if (row >= 0) {
                view.txtTitle.setText(view.model.getValueAt(row,1).toString());
                view.cmbCategory.setSelectedItem(view.model.getValueAt(row,2));
                view.txtPrice.setText(view.model.getValueAt(row,3).toString());
                view.txtStock.setText(view.model.getValueAt(row,4).toString());
            }
        });

        // UPDATE PRODUCT
        view.btnUpdate.addActionListener(e -> {
            int row = view.table.getSelectedRow();
            if (row < 0) return;

            try {
                // Get selected product id
                int id = Integer.parseInt(view.model.getValueAt(row,0).toString());

                // SQL to update product
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(
                    "UPDATE products SET title=?, category=?, price=?, stock=? WHERE id=?"
                );

                // Set new values
                ps.setString(1, view.txtTitle.getText());
                ps.setString(2, view.cmbCategory.getSelectedItem().toString());
                ps.setDouble(3, Double.parseDouble(view.txtPrice.getText()));
                ps.setInt(4, Integer.parseInt(view.txtStock.getText()));
                ps.setInt(5, id);

                // Update data
                ps.executeUpdate();

                // Show message
                JOptionPane.showMessageDialog(null, "Product Updated");

                // Refresh table
                loadAllProducts(view);
                checkRestock(view);

            } catch (Exception ex) {
                // Show error
                ex.printStackTrace();
            }
        });

        // DELETE PRODUCT
        view.btnDelete.addActionListener(e -> {
            int row = view.table.getSelectedRow();
            if (row < 0) return;

            // Ask confirmation
            int confirm = JOptionPane.showConfirmDialog(
                null, "Delete product?", "Confirm",
                JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    // Get selected product id
                    int id = Integer.parseInt(view.model.getValueAt(row,0).toString());

                    // SQL to delete product
                    Connection con = DBConnection.getConnection();
                    PreparedStatement ps =
                        con.prepareStatement("DELETE FROM products WHERE id=?");
                    ps.setInt(1, id);
                    ps.executeUpdate();

                    // Show message
                    JOptionPane.showMessageDialog(null, "Product Deleted");

                    // Refresh table
                    loadAllProducts(view);

                } catch (Exception ex) {
                    // Show error
                    ex.printStackTrace();
                }
            }
        });
    }

    // LOAD ALL PRODUCTS
    private void loadAllProducts(ProductView view) {
        view.model.setRowCount(0); // Clear table

        try {
            // Get all products
            ResultSet rs = DBConnection.getConnection()
                .createStatement()
                .executeQuery("SELECT * FROM products");

            while (rs.next()) {
                // Add row to table
                view.model.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("category"),
                    rs.getDouble("price"),
                    rs.getInt("stock")
                });
            }
        } catch (Exception e) {
            // Show error
            e.printStackTrace();
        }
    }

    // SEARCH PRODUCTS
    private void searchProducts(ProductView view) {
        view.model.setRowCount(0); // Clear table

        try {
            // SQL search query
            PreparedStatement ps = DBConnection.getConnection()
                .prepareStatement("SELECT * FROM products WHERE title LIKE ?");

            ps.setString(1, "%" + view.txtSearch.getText() + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                // Add row to table
                view.model.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("category"),
                    rs.getDouble("price"),
                    rs.getInt("stock")
                });
            }
        } catch (Exception e) {
            // Show error
            e.printStackTrace();
        }
    }

    // CHECK LOW STOCK
    private void checkRestock(ProductView view) {
        try {
            // Get low stock products
            ResultSet rs = DBConnection.getConnection()
                .createStatement()
                .executeQuery("SELECT title, stock FROM products WHERE stock < 5");

            StringBuilder alert = new StringBuilder();

            while (rs.next()) {
                alert.append(rs.getString("title"))
                     .append(" (")
                     .append(rs.getInt("stock"))
                     .append(")\n");
            }

            // Show warning message
            if (alert.length() > 0) {
                JOptionPane.showMessageDialog(
                    null,
                    "Low Stock Alert\n\n" + alert,
                    "Warning",
                    JOptionPane.WARNING_MESSAGE
                );
            }
        } catch (Exception e) {
            // Show error
            e.printStackTrace();
        }
    }
}
