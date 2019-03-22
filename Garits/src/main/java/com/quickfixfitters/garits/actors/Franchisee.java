package com.quickfixfitters.garits.actors;

import com.quickfixfitters.garits.database.DBConnectivity;
import com.quickfixfitters.garits.entities.Customer;
import com.quickfixfitters.garits.entities.CustomerAccount;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;


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
            
            // Puts the newly created customer into the database.
            Customer customer = new Customer(forename, surname, address, postcode, telephone, email);
            // Puts a newly created customer account into the database
            CustomerAccount customerAccount = new CustomerAccount(payment);
            
            // Gives both objects access to primary key of the other.
            customer.setCustomerAccount(customerAccount);
            customerAccount.setCustomer(customer);
            
            session.save(customer);
            session.save(customerAccount);
            
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