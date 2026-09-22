package controller;

import view.*;              // View classes (MVC)
import model.User;          // Model class (Encapsulation)
import config.DBConnection; // Abstraction for DB connection
import java.sql.*;
import javax.swing.JOptionPane;

public class LoginController {

    // Constructor connects LoginView with logic
    public LoginController(LoginView view) {

        // Run code when Login button is clicked
        view.btnLogin.addActionListener(e -> {
            try {
                // Get database connection (Abstraction)
                Connection con = DBConnection.getConnection();

                // SQL query to check user
                String sql = "SELECT * FROM users WHERE username=? AND password=?";

                // Prepare SQL statement
                PreparedStatement ps = con.prepareStatement(sql);

                // Get username from view
                ps.setString(1, view.txtUser.getText());

                // Get password from view
                ps.setString(2, new String(view.txtPass.getPassword()));

                // Execute query
                ResultSet rs = ps.executeQuery();

                // If login is correct
                if (rs.next()) {

                    // Create Model object (Encapsulation)
                    User user = new User(
                            rs.getString("username"),
                            rs.getString("role")
                    );

                    // Open dashboard (Polymorphism via controller use)
                    new DashboardController(
                        new DashboardView(rs.getString("role")),
                        user
                    );

                    // Close login window
                    view.dispose();

                } else {
                    // Show error message
                    JOptionPane.showMessageDialog(null, "Invalid Login");
                }

            } catch (Exception ex) {
                // Handle errors
                ex.printStackTrace();
            }
        });
    }
}
