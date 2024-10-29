package case_study.Product;

import java.time.LocalDate;

public class Product {
    private String id;
    private String name;
    private String category;
    private LocalDate expiryDate;
    private int quantity;
    private double price;

    public Product(String id, String name, String category, LocalDate expiryDate, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.expiryDate = expiryDate;
        this.quantity = quantity;
        this.price = price;
    }


    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public LocalDate getExpiryDate() { return expiryDate; }
    public void setExpiryDate(LocalDate expiryDate) { this.expiryDate = expiryDate; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }


    @Override
    public String toString() {
        return id + ", " + name + ", " + category + ", " + expiryDate + ", " + quantity + ", " + price;
    }

    public String toFileString() {
        return id + "," + name + "," + category + "," + expiryDate + "," + quantity + "," + price;
    }
}
