package com.quickfixfitters.garits.actors;

import com.quickfixfitters.garits.database.DBConnectivity;
import com.quickfixfitters.garits.entities.Customer;
import com.quickfixfitters.garits.entities.CustomerAccount;
import com.quickfixfitters.garits.entities.DiscountPlan;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class Franchisee extends User {
    
    public static Franchisee franchisee = null;
    private String username;
    private String password;
    
    public static Franchisee getFranchisee(){
        return franchisee;
    }
    
    public void JobSheet (String jobNo) {
            // TODO - implement Franchisee.getJob
            throw new UnsupportedOperationException();
    }

    public void createJob() {
            // TODO - implement Franchisee.createJob
            throw new UnsupportedOperationException();
    }

    public void setJob() {
            // TODO - implement Franchisee.setJob
            throw new UnsupportedOperationException();
    }

    public void getJobStatus() {
            // TODO - implement Franchisee.getJobStatus
            throw new UnsupportedOperationException();
    }

    public void setDiscount() {
            // TODO - implement Franchisee.setDiscount
            throw new UnsupportedOperationException();
    }

    // Method that creates a new customer and adds it to the database.
    public void createCustomerAccount(String forename, String surname, String address,
            String postcode, int telephone, String email, String payment) {
        
        // Connecting to the database.
        SessionFactory sessionFactory = DBConnectivity.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        
        // Attempt to create a new customer account and then add it to the database.
        // Always closes the session when finished, regardless of whether it succeeded
        // or not.
        try{
            session.beginTransaction();
            
            // Creates a new customer
            Customer customer = new Customer(forename, surname, address, postcode, telephone, email);
            // Creates a new customer account
            CustomerAccount customerAccount = new CustomerAccount(payment);
            // Creates a default discount plan
            DiscountPlan discountPlan = new DiscountPlan();
            
            // Gives all objects access to primary key of the other.
            customer.setCustomerAccount(customerAccount);
            customerAccount.setCustomer(customer);
            customerAccount.setDiscountPlan(discountPlan);
            discountPlan.setCustomerAccount(customerAccount);
            
            session.save(customer);
            session.save(customerAccount);
            session.save(discountPlan);
            
            // Tells the user that they suceeded.
            JOptionPane.showMessageDialog(null, "Customer added");
        }finally{
            session.getTransaction().commit();
            session.close();
        }
    }

    public void setCustormerAccount() {
            // TODO - implement Franchisee.setCustormerAccount
            throw new UnsupportedOperationException();
    }

    public void getCustomerAccount() {
            // TODO - implement Franchisee.getCustomerAccount
            throw new UnsupportedOperationException();
    }

    public Franchisee(String username, String password) {
        this.username = username;
        this.password = password;
    }

}