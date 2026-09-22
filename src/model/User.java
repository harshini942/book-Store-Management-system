package model;

public class User {

    // Private variables (Encapsulation)
    private String username;
    private String role;

    // Constructor to create a User object (Abstraction: hides internal details)
    public User(String username, String role) {
        this.username = username;
        this.role = role;
    }

    // Get username (Encapsulation: controlled access)
    public String getUsername() { 
        return username; 
    }

    // Get user role (Encapsulation: controlled access)
    public String getRole() { 
        return role; 
    }
}
