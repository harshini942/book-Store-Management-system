package controller;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class LowStockRenderer extends DefaultTableCellRenderer {

    // This method changes table cell color
    @Override
    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {

        // Get default table cell
        Component c = super.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, column);

        // Get stock value from table (column 4)
        int stock = Integer.parseInt(
                table.getValueAt(row, 4).toString()
        );

        // If stock is low
        if (stock < 5) {
            // Set background color to light red
            c.setBackground(new Color(255, 180, 180));
        } else {
            // Set normal background color
            c.setBackground(Color.WHITE);
        }

        // Return the cell
        return c;
    }
}
