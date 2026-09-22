package view;

import javax.swing.*;

// This class inherits from JFrame
public class StockReportView extends JFrame {

    // Text area to show stock report
    public JTextArea txtReport;

    // Constructor to create GUI
    public StockReportView() {
        setTitle("Stock Report");        // Window title
        setSize(400,350);                // Window size

        // Create text area (read-only)
        txtReport = new JTextArea();
        txtReport.setEditable(false);

        // Add scroll pane to text area
        add(new JScrollPane(txtReport));

        // Center window on screen
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
