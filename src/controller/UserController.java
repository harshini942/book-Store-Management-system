package controller;

import view.UserView;
import config.DBConnection;
import java.sql.*;
import javax.swing.JOptionPane;

public class UserController {

    // Constructor receives the View object
    public UserController(UserView view) {

        // Add action when Add button is clicked
        view.btnAdd.addActionListener(e -> {
            try {
                // Get database connection
                Connection con = DBConnection.getConnection();

                // SQL query to insert user data
                String sql = "INSERT INTO users(username,password,role) VALUES (?,?,?)";

                // Prepare SQL statement
                PreparedStatement ps = con.prepareStatement(sql);

                // Set values from the form
                ps.setString(1, view.txtUser.getText());
                ps.setString(2, view.txtPass.getText());
                ps.setString(3, view.cmbRole.getSelectedItem().toString());

                // Execute insert query
                ps.executeUpdate();

                // Show success message
                JOptionPane.showMessageDialog(null, "User Created");

            } catch (Exception ex) {
                // Show error if something goes wrong
                ex.printStackTrace();
            }
        });
    }
}
