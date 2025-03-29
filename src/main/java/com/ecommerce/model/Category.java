package com.ecommerce.model;

// import required packages
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "category")

public class Category {
//     Category Entity:
//      o id (Primary Key, auto-generated)
//      o name (Unique, Not Null)
//      o description
//      o Relationship: One-to-Many with Product
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryId")
    private int categoryId;
    @Column(name = "name", unique = true, nullable = false, length = 20)
    private String name;
    @Column(name = "description", length = 20)
    private String description;
    
    // required relationship with product, i.e. OneToMany
    @OneToMany
    @JoinColumn(name = "productId")
    private List<Product> products;
    
    // default constructor
    
    public Category(){
        this.categoryId = 0;
        this.name = null;
        this.description = null;
    }
    
    // parameterized constructor
    
    public Category(String name, String description){
        super();
        this.name = name;
        this.description = description;
    }
    
    // getter and setter methods
    
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    
    // toString method
    @Override
    public String toString() {
        return "Category [categoryId=" + categoryId + ", name=" + name + ", description=" + description + "]";
    }
}