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
@Table(name = "order_details")
public class OrderDetails {
    // OrderDetails Entity:
    // o id (Primary Key, auto-generated)
    // o quantity (Integer, Not Null)
    // o unitPrice (Decimal, Not Null)
    // o Relationship: Many-to-One with Orders, Many-to-One with Product
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderDetailId")
    private int orderDetailId;
    
    @Column(name = "quantity", nullable = false)
    private Integer quantity;
    
    @Column(name = "unitPrice", nullable = false)
    private double unitPrice;
    
    // Many-to-One relationship with Orders
    @ManyToOne
    @JoinColumn(name = "orderId", nullable = false)
    private Order order;
    
    // Many-to-One relationship with Product
    @ManyToOne
    @JoinColumn(name = "productId", nullable = false)
    private Product product;
    
    // Default constructor
    public OrderDetails() {
        this.orderDetailId = 0;
        this.quantity = 0;
        this.unitPrice = 0;
    }
    
    // Parameterized constructor
    public OrderDetails(Integer quantity, double unitPrice, Order order, Product product) {
        super();
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.order = order;
        this.product = product;
    }
    
    // Getter and Setter methods
    public int getOrderDetailId() {
        return orderDetailId;
    }
    
    public void setOrderDetailId(int orderDetailId) {
        this.orderDetailId = orderDetailId;
    }
    
    public Integer getQuantity() {
        return quantity;
    }
    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
    public double getUnitPrice() {
        return unitPrice;
    }
    
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
    
    public Order getOrder() {
        return order;
    }
    
    public void setOrder(Order order) {
        this.order = order;
    }
    
    public Product getProduct() {
        return product;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }
    
    // method to calculate subtotal
    public double getSubtotal() {
        return unitPrice * quantity;
    }
    
    // toString method
    @Override
    public String toString() {
        return "OrderDetails [orderDetailId=" + orderDetailId + ", quantity=" + quantity + ", unitPrice=" + unitPrice + 
               ", order=" + (order != null ? order.getOrderId() : "null") + 
               ", product=" + (product != null ? product.getName() : "null") + "]";
    }
}