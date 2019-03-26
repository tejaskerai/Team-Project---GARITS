package com.quickfixfitters.garits.actors;

import com.quickfixfitters.garits.database.DBConnectivity;
import com.quickfixfitters.garits.entities.Customer;
import com.quickfixfitters.garits.entities.CustomerAccount;
import com.quickfixfitters.garits.entities.DiscountPlan;
import com.quickfixfitters.garits.entities.Employee;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class Franchisee extends User {
    
    public static Franchisee franchisee = null;
    private String username = "";
    private String password = "";
    
    
    // Singleton for franchisee
    public static Franchisee getFranchisee(){
        if (franchisee == null) {
            franchisee = new Franchisee();
            System.out.println("New Franchisee object created");
            return franchisee;
        }
        System.out.println("Franshisee object already exists");
        return franchisee;
    }

    public static void setFranchisee(Franchisee franchisee) {
        Franchisee.franchisee = franchisee;
    }
    
    public List<Customer> getCustomers() {
        SessionFactory sessionFactory = DBConnectivity.getSessionFactory();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Customer.class);
            return (List<Customer>) criteria.list();
        }
    }
    
    public void updateCustomer(int id, String forename, String surname, 
                               String address, String postcode, int telephone, 
                               String email){
        
        SessionFactory sessionFactory = DBConnectivity.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            Customer customer = session.get(Customer.class, id);
            
            customer.setForename(forename);
            customer.setSurname(surname);
            customer.setCustomerAddress(address);
            customer.setPostcode(postcode);
            customer.setTelNo(telephone);
            customer.setEmail(email);
            
            session.update(customer);
            session.getTransaction().commit();     
            
        }
        catch (Exception e) {
            session.getTransaction().rollback();
        }
        finally {
            session.close();
        }
    }
    
    public boolean removeCustomer(int id) {
        SessionFactory sessionFactory = DBConnectivity.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            Customer customer = session.get(Customer.class, id);
            session.delete(customer);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
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
    public void createCustomer(String forename, String surname, String address,
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
            CustomerAccount customerAccount;
            if (payment == null){
                customerAccount = new CustomerAccount(payment, 0);
            }else{
                customerAccount = new CustomerAccount(payment, 1);
            }
            // Creates a default discount plan
            DiscountPlan discountPlan = new DiscountPlan();
                
            customer.setCustomerAccount(customerAccount);
            customerAccount.setCustomer(customer);
            customerAccount.setDiscountPlan(discountPlan);
            discountPlan.setCustomerAccount(customerAccount);

            session.save(customer);
            session.save(customerAccount);
            session.save(discountPlan);

            JOptionPane.showMessageDialog(null, "Customer added");
        }finally{
            session.getTransaction().commit();
            session.close();
        }
    }

    public void setCustormer() {
            // TODO - implement Franchisee.setCustormer
            throw new UnsupportedOperationException();
    }

    public void getCustomer() {
            // TODO - implement Franchisee.getCustomer
            throw new UnsupportedOperationException();
    }

    public Franchisee(String username, String password) {
        this.username = username;
        this.password = password;
        setFranchisee(new Franchisee());
    }

    public Franchisee() {
    }
}