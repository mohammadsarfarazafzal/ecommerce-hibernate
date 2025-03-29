package com.ecommerce.model;

// import required packages
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    // Orders Entity:
    // o id (Primary Key, auto-generated)
    // o orderDate (Timestamp, Not Null)
    // o totalAmount (Decimal, Not Null)
    // o Relationship: Many-to-One with Users, One-to-Many with OrderDetails
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderId")
    private int orderId;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "orderDate", nullable = false)
    private Date orderDate;
    
    @Column(name = "totalAmount", nullable = false)
    private double totalAmount;
    
    // Many-to-One relationship with Users
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;
    
    // One-to-Many relationship with OrderDetails
    @OneToMany(mappedBy = "order")
    private List<OrderDetails> orderDetails;
    
    // Default constructor
    public Order() {
        this.orderId = 0;
        this.orderDate = null;
        this.totalAmount = 0;
    }
    
    // Parameterized constructor
    public Order(Date orderDate, double totalAmount, User user) {
        super();
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.user = user;
    }
    
    // Getter and Setter methods
    public int getOrderId() {
        return orderId;
    }
    
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    
    public Date getOrderDate() {
        return orderDate;
    }
    
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    
    public double getTotalAmount() {
        return totalAmount;
    }
    
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }
    
    public void setOrderDetails(List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }
    
    // toString method
    @Override
    public String toString() {
        return "Orders [orderId=" + orderId + ", orderDate=" + orderDate + ", totalAmount=" + totalAmount + 
               ", user=" + (user != null ? user.getUsername() : "null") + "]";
    }
}