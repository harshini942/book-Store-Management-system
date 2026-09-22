package model;

public class Product {

    // Encapsulation: private variables
    private String title, category;
    private double price;
    private int stock;

    // Abstraction: constructor hides how object is created
    public Product(String title, String category, double price, int stock) {
        this.title = title;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    // Encapsulation: getters to access private data
    public String getTitle() { 
        return title; 
    }

    public String getCategory() { 
        return category; 
    }

    public double getPrice() { 
        return price; 
    }

    public int getStock() { 
        return stock; 
    }
}
