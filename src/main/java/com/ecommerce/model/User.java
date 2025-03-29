package com.ecommerce.model;

// import required packages
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    // Users Entity:
    // o id (Primary Key, auto-generated)
    // o username (Unique, Not Null)
    // o password (Hashed, Not Null)
    // o email (Unique, Not Null)
    // o role (ADMIN, CUSTOMER)
    // o Relationship: One-to-Many with Orders
    
    public enum Role {
        ADMIN, CUSTOMER
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private int userId;
    
    @Column(name = "username", unique = true, nullable = false, length = 50)
    private String username;
    
    @Column(name = "password", nullable = false, length = 100)
    private String password;
    
    @Column(name = "email", unique = true, nullable = false, length = 100)
    private String email;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;
    
    // One-to-Many relationship with Orders
    @OneToMany(mappedBy = "user")
    private List<Order> orders;
    
    // Default constructor
    public User() {
        this.userId = 0;
        this.username = null;
        this.password = null;
        this.email = null;
        this.role = null;
    }
    
    // Parameterized constructor
    public User(String username, String password, String email, Role role) {
        super();
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }
    
    // Getter and Setter methods
    public int getUserId() {
        return userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public Role getRole() {
        return role;
    }
    
    public void setRole(Role role) {
        this.role = role;
    }
    
    public List<Order> getOrders() {
        return orders;
    }
    
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    
    // toString method
    @Override
    public String toString() {
        return "Users [userId=" + userId + ", username=" + username + ", email=" + email + ", role=" + role + "]";
    }
}