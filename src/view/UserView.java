package view;

import javax.swing.*;


// This class inherits from JFrame
public class UserView extends JFrame {

    // Input fields and button (View components)
    public JTextField txtUser, txtPass;          // Username and Password
    public JComboBox<String> cmbRole;           // Role selection
    public JButton btnAdd;                       // Add user button

    // Constructor sets up the GUI
    public UserView() {
        setTitle("User Management");             // Window title
        setSize(300,250);                        // Window size
        setLayout(null);                         // Absolute layout

        // Username label and text field
        JLabel l1 = new JLabel("Username");
        l1.setBounds(30,30,100,25);
        add(l1);

        txtUser = new JTextField();
        txtUser.setBounds(120,30,130,25);
        add(txtUser);

        // Password label and text field
        JLabel l2 = new JLabel("Password");
        l2.setBounds(30,70,100,25);
        add(l2);

        txtPass = new JTextField();
        txtPass.setBounds(120,70,130,25);
        add(txtPass);

        // Role label and combo box
        JLabel l3 = new JLabel("Role");
        l3.setBounds(30,110,100,25);
        add(l3);

        cmbRole = new JComboBox<>(new String[]{"Cashier","Manager"});
        cmbRole.setBounds(120,110,130,25);
        add(cmbRole);

        // Add user button
        btnAdd = new JButton("Create User");
        btnAdd.setBounds(80,160,140,30);
        add(btnAdd);

        // Center window on screen
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
