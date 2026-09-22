package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import controller.LowStockRenderer;

// This class inherits from JFrame
public class ProductView extends JFrame {

    // Input fields
    public JTextField txtTitle, txtPrice, txtStock, txtSearch;

    // Drop-down for category
    public JComboBox<String> cmbCategory;

    // Buttons
    public JButton btnAdd, btnSearch, btnUpdate, btnDelete;

    // Table and table model
    public JTable table;
    public DefaultTableModel model;

    // Constructor: setup GUI
    public ProductView() {
        setTitle("Product Management");   // Window title
        setSize(700,420);                 // Window size
        setLayout(null);                  // Absolute layout

        // Title label and text field
        JLabel l1 = new JLabel("Title");
        l1.setBounds(20,20,100,25);
        add(l1);

        txtTitle = new JTextField();
        txtTitle.setBounds(120,20,150,25);
        add(txtTitle);

        // Category label and combo box
        JLabel l2 = new JLabel("Category");
        l2.setBounds(20,60,100,25);
        add(l2);

        cmbCategory = new JComboBox<>(new String[]{
            "Fiction","Non-fiction","Magazines","Academic","Children's Books"
        });
        cmbCategory.setBounds(120,60,150,25);
        add(cmbCategory);

        // Price label and text field
        JLabel l3 = new JLabel("Price");
        l3.setBounds(20,100,100,25);
        add(l3);

        txtPrice = new JTextField();
        txtPrice.setBounds(120,100,150,25);
        add(txtPrice);

        // Stock label and text field
        JLabel l4 = new JLabel("Stock");
        l4.setBounds(20,140,100,25);
        add(l4);

        txtStock = new JTextField();
        txtStock.setBounds(120,140,150,25);
        add(txtStock);

        // Add, Update, Delete buttons
        btnAdd = new JButton("Add");
        btnAdd.setBounds(20,180,80,30);
        add(btnAdd);

        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(110,180,80,30);
        add(btnUpdate);

        btnDelete = new JButton("Delete");
        btnDelete.setBounds(200,180,80,30);
        add(btnDelete);

        // Search label, text field, and button
        JLabel l5 = new JLabel("Search");
        l5.setBounds(320,20,80,25);
        add(l5);

        txtSearch = new JTextField();
        txtSearch.setBounds(380,20,150,25);
        add(txtSearch);

        btnSearch = new JButton("Search");
        btnSearch.setBounds(540,20,100,25);
        add(btnSearch);

        // Table setup
        model = new DefaultTableModel(
            new String[]{"ID","Title","Category","Price","Stock"},0
        );
        table = new JTable(model);

        //  Highlight low-stock rows
        table.setDefaultRenderer(Object.class, new LowStockRenderer());

        // Scroll pane for table
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(300,60,360,300);
        add(sp);

        // Center window and show
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
