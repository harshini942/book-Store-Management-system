package controller;

import view.StockReportView;
import config.DBConnection;
import java.sql.*;

public class StockReportController {

    // Constructor of StockReportController
    public StockReportController(StockReportView view) {
        try {
            // Get database connection
            Connection con = DBConnection.getConnection();

            // Get total number of products
            ResultSet total = con.createStatement()
                    .executeQuery("SELECT COUNT(*) FROM products");
            total.next();

            // Get products with low stock
            ResultSet low = con.createStatement()
                    .executeQuery("SELECT title, stock FROM products WHERE stock < 5");

            // Create a string to build the report
            StringBuilder report = new StringBuilder();

            // Add report title
            report.append("BOOK HAVEN 52 - STOCK REPORT\n\n");

            // Add total products count
            report.append("Total Products: ")
                  .append(total.getInt(1))
                  .append("\n\n");

            // Add low stock section
            report.append("Low Stock Items:\n");

            // Add each low stock item to the report
            while (low.next()) {
                report.append("- ")
                      .append(low.getString("title"))
                      .append(" (")
                      .append(low.getInt("stock"))
                      .append(")\n");
            }

            // Show report in the text area
            view.txtReport.setText(report.toString());

        } catch (Exception e) {
            // Print error if any problem happens
            e.printStackTrace();
        }
    }
}
