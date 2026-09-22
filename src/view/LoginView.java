package view;

import javax.swing.*;

// Login window class
public class LoginView extends JFrame {

    // Input fields and button
    public JTextField txtUser;
    public JPasswordField txtPass;
    public JButton btnLogin;

    // Constructor
    public LoginView() {

        // Window title
        setTitle("Book Haven 52 - Login");

        // Window size
        setSize(300, 200);

        // Manual layout
        setLayout(null);

        // Username label
        JLabel lblU = new JLabel("Username");
        lblU.setBounds(30, 30, 80, 25);
        add(lblU);

        // Username text field
        txtUser = new JTextField();
        txtUser.setBounds(120, 30, 120, 25);
        add(txtUser);

        // Password label
        JLabel lblP = new JLabel("Password");
        lblP.setBounds(30, 70, 80, 25);
        add(lblP);

        // Password field
        txtPass = new JPasswordField();
        txtPass.setBounds(120, 70, 120, 25);
        add(txtPass);

        // Login button
        btnLogin = new JButton("Login");
        btnLogin.setBounds(90, 120, 100, 30);
        add(btnLogin);

        // Close app when window is closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Center the window
        setLocationRelativeTo(null);

        // Show the window
        setVisible(true);
    }
}
