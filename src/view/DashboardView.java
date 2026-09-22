package view;

import javax.swing.*;

// Dashboard window class
public class DashboardView extends JFrame {

    // Buttons
    public JButton btnProducts, btnUsers, btnReport;

    // Constructor – get user role
    public DashboardView(String role) {

        // Set window title with role
        setTitle("Dashboard - " + role);

        // Set window size
        setSize(300, 250);

        // No layout (manual positioning)
        setLayout(null);

        // Products button
        btnProducts = new JButton("Manage Products");
        btnProducts.setBounds(50, 30, 180, 30);
        add(btnProducts);

        // Users button
        btnUsers = new JButton("Manage Users");
        btnUsers.setBounds(50, 80, 180, 30);
        add(btnUsers);

        // Report button
        btnReport = new JButton("Stock Report");
        btnReport.setBounds(50, 130, 180, 30);
        add(btnReport);

        // If user is not Manager, disable buttons
        if (!role.equals("Manager")) {
            btnUsers.setEnabled(false);
            btnReport.setEnabled(false);
        }

        // Center the window
        setLocationRelativeTo(null);

        // Show the window
        setVisible(true);
    }
}
