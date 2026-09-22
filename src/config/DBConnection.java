package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    // This method creates and returns a database connection
    public static Connection getConnection() {
        try {
            // Load MySQL database driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database and return connection
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/book_haven_52",
                "root",
                ""
            );

        } catch (Exception e) {
            // Print error if connection fails
            e.printStackTrace();
            return null;
        }
    }
}
