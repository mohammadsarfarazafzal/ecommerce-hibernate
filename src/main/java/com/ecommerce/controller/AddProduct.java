package com.ecommerce.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ecommerce.model.Category;
import com.ecommerce.model.Product;

public class AddProduct {

    private SessionFactory sessionFactory;

    // Constructor with SessionFactory object
    public AddProduct(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

        // Create the session object
        Session session = sessionFactory.getCurrentSession();

        // Start the transaction
        Transaction transaction = session.beginTransaction();

        try {
            // Create categories
            Category category1 = new Category();
            category1.setName("Electronics");
            category1.setDescription("Electronic gadgets and devices");
            session.save(category1);

            Category category2 = new Category();
            category2.setName("Fashion");
            category2.setDescription("Clothing and accessories");
            session.save(category2);

            // Create products
            Product product1 = new Product("Smartphone", 499.99, 50, category1);
            session.persist(product1);

            Product product2 = new Product("Laptop", 899.99, 30, category1);
            session.persist(product2);

            Product product3 = new Product("T-shirt", 19.99, 100, category2);
            session.persist(product3);

            // Commit transaction
            transaction.commit();

            // Close the session
            session.close();
            System.out.println("Products added successfully!");

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback(); // Rollback in case of errors
            }
            session.close(); // Ensure the session is closed even if an error occurs
        }
    }
}
