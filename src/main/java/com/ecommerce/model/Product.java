package com.ecommerce.model;

// import required packages
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
    // Product Entity:
    // o id (Primary Key, auto-generated)
    // o name (Not Null)
    // o price (Decimal, Not Null)
    // o stockQuantity (Integer)
    // o Relationship: Many-to-One with Category
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId")
    private int productId;
    
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    
    @Column(name = "price", nullable = false)
    private double price;
    
    @Column(name = "stockQuantity")
    private Integer stockQuantity;
    
    // Many-to-One relationship with Category
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;
    
    // Default constructor
    public Product() {
        this.productId = 0;
        this.name = null;
        this.price = 0;
        this.stockQuantity = 0;
        this.category = null;
    }
    
    // Parameterized constructor
    public Product(String name, double price, Integer stockQuantity, Category category) {
        super();
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.category = category;
    }
    
    // Getter and Setter methods
    public int getProductId() {
        return productId;
    }
    
    public void setProductId(int productId) {
        this.productId = productId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public Integer getStockQuantity() {
        return stockQuantity;
    }
    
    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
    
    public Category getCategory() {
        return category;
    }
    
    public void setCategory(Category category) {
        this.category = category;
    }
    
    // toString method
    @Override
    public String toString() {
        return "Product [productId=" + productId + ", name=" + name + ", price=" + price + 
               ", stockQuantity=" + stockQuantity + ", category=" + category.getName() + "]";
    }
}