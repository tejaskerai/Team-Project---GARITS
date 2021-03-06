package com.quickfixfitters.garits.actors;

import com.quickfixfitters.garits.GUI.Garits;
import com.quickfixfitters.garits.GUI.ViewCustomerAccount;
import com.quickfixfitters.garits.database.DBConnectivity;
import com.quickfixfitters.garits.entities.Customer;
import com.quickfixfitters.garits.entities.CustomerAccount;
import com.quickfixfitters.garits.entities.DiscountPlan;
import com.quickfixfitters.garits.entities.FlexibleBands;
import com.quickfixfitters.garits.entities.JobSheet;
import com.quickfixfitters.garits.entities.MOTReminder;
import com.quickfixfitters.garits.entities.Part;
import com.quickfixfitters.garits.entities.Vehicle;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.swing.JFrame;
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
    
    // Removes the part with part code id, from the database.
    public boolean removePart(int id){
        SessionFactory sessionFactory = DBConnectivity.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        // Tries to remove the specified part, rolls back the transaction if it
        // fails for any reason.
        try {
            session.beginTransaction();
            Part part = session.get(Part.class, id);
            session.delete(part);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }
    
    // Updates a part.
    public void updateStock(int id, String partName, String code, String manufacturer, String vehicleType, String price, String threshold, String stockLevel){
        
        float unitPrice = Float.parseFloat(price);
        int thresh = Integer.parseInt(threshold);
        int level = Integer.parseInt(stockLevel);
        
        SessionFactory sessionFactory = DBConnectivity.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            Part part = session.get(Part.class, id);
            part.setPartName(partName);
            part.setPartCode(code);
            part.setManufacturer(manufacturer);
            part.setVehicleType(vehicleType);
            part.setUnitPrice(unitPrice);
            part.setLowLevelThreshold(thresh);
            part.setStockLevel(level);
            
            session.update(part);
            session.getTransaction().commit();     
            
        }
        catch (Exception e) {
            session.getTransaction().rollback();
        }
        finally {
            session.close();
        }
    }
    
    // Checks if a customer account is usable and if it is, opens the
    // view customer account screen.
    public void showCustomerAccount(int id, Garits garits, JFrame frame){
        SessionFactory sessionFactory = DBConnectivity.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        
        try{
            session.beginTransaction();
            CustomerAccount ca = session.get(CustomerAccount.class, id);
            if (ca.getUsable() == 0){
                JOptionPane.showMessageDialog(null, "Customer account does not exist");
            }else{
                garits.openNewScreen(frame, new ViewCustomerAccount(garits,
                                                    ca.getCustomer().getForename(),
                                                    ca.getCustomer().getSurname(),
                                                    id, session));
            }
            session.getTransaction().commit();
        }catch(Exception e){
            
        }finally{
            session.close();
        }
    }
    
    // Returns a list of all customers in the database.
    public List<Customer> getCustomers() {
        SessionFactory sessionFactory = DBConnectivity.getSessionFactory();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Customer.class);
            return (List<Customer>) criteria.list();
        }
    }
    
    // Returns a list of all MOTReminders in the database.
    public List<MOTReminder> getMOTReminders(Session session){
        Criteria criteria = session.createCriteria(MOTReminder.class);
        return (List<MOTReminder>) criteria.list();
    }
    
    // Tries to update the customer specified by id using the other parameters
    public void updateCustomer(int id, String forename, String surname, 
                               String address, String postcode, String telephone, 
                               String email){
        
        SessionFactory sessionFactory = DBConnectivity.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        // Tries to update the customer, rolls back the transaction if it fails
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
    
    // Updates the customer account specified by id using other parameters
    public void updateCustomerAccount(int id, float fi, float v, Set<FlexibleBands> fl){
        SessionFactory sessionFactory = DBConnectivity.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        
        // Tries to update the account, rolls back changes if any error occur
        try{
            session.beginTransaction();
            CustomerAccount ca = session.get(CustomerAccount.class, id);
            DiscountPlan d = ca.getDiscountPlan();
            d.setFixedDiscount(fi);
            d.setVariableDiscount(v);
            d.setFlexibleDiscount(fl);
            
            session.update(d);
            session.update(ca);
            session.getTransaction().commit();
        }catch(Exception e){
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
    }
    
    // Updates the vehicle specified by the regNo using other parameters
    public void updateVehicle(String regNo, String chassisNo, String colour, 
                              String engSerial, String make, String model){
        SessionFactory sessionFactory = DBConnectivity.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        
        // Tries to update the vehicle, rolls back changes if any error occur
        try{
            session.beginTransaction();
            Vehicle vehicle = session.get(Vehicle.class, regNo);
            
            vehicle.setRegNo(regNo);
            vehicle.setChassisNo(chassisNo);
            vehicle.setColor(colour);
            vehicle.setEngSerial(engSerial);
            vehicle.setMake(make);
            vehicle.setModel(model);
            
            session.update(vehicle);
            session.getTransaction().commit();
        }catch(Exception e){
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
    }
    
    // Adds a new part to the database
    public void addPart(String partName, String code, String manufacturer, String vehicleType, String price, String stockLevel, String threshold){
        
        float unitPrice = Float.parseFloat(price);
        int thresh = Integer.parseInt(threshold);
        int level = Integer.parseInt(stockLevel);	
        //Starting connection with Database
        SessionFactory sessionFactory = DBConnectivity.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        
        try {
            session.beginTransaction();
            
            Part part = new Part(code, partName, manufacturer, vehicleType, unitPrice, thresh, level);

            session.save(part);
            System.out.println("Row added");
            JOptionPane.showMessageDialog(null, "Part added");

        } finally {
            session.getTransaction().commit();
            session.close();
        }   
    }
    
    // Returns the list of all parts in the database
    public List<Part> getStock() {
        SessionFactory sessionFactory = DBConnectivity.getSessionFactory();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Part.class);
            return (List<Part>) criteria.list();
        }
    }
    
    // Removes the customer specified by id
    public boolean removeCustomer(int id) {
        SessionFactory sessionFactory = DBConnectivity.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        // Tries to remove the specified customer. Rolls back any changes if
        // an error occurs
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
    
    // Tries to remove the vehicle specified by the parameter regNo.
    public boolean removeVehicle(int id, String regNo){
        SessionFactory sessionFactory = DBConnectivity.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        
        // Tries to remove the vehicle from the database and from the customer's
        // list of vehicles. Rolls back changes if error occurs.
        try{
            session.beginTransaction();
            Customer customer = session.get(Customer.class, id);
            Vehicle vehicle = session.get(Vehicle.class, regNo);
            customer.getVehicles().remove(vehicle);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return false;
    }
    
    // Adds a job to a vehicle.
    public void addJob(Date dateBookedIn, String descriptionOfWork, String estimatedTime, String regNo){
        
        SessionFactory sessionFactory = DBConnectivity.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        
        try{
            session.beginTransaction();
            JobSheet jobSheet = new JobSheet(dateBookedIn, descriptionOfWork, estimatedTime, regNo);
            session.save(jobSheet);
        }finally{
            session.getTransaction().commit();
            session.close();
        }
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
            String postcode, String telephone, String email, String acc) {
        
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
            System.out.println(acc);
            if (acc.compareTo("Yes") == 0){
                customerAccount = new CustomerAccount(1);
            }else{
                customerAccount = new CustomerAccount(0);
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

    // Creates a new MOTReminder in the database for a vehicle.
    public void createMOTReminder(String vehicleId){
        SessionFactory sessionFactory = DBConnectivity.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        
        try{
            session.beginTransaction();
            
            Vehicle vehicle = session.get(Vehicle.class, vehicleId);
            MOTReminder reminder = new MOTReminder();
            vehicle.getMotReminders().add(reminder);
            reminder.setMotVehicle(vehicle);
            session.update(vehicle);
            session.save(reminder);
            
            session.getTransaction().commit();
        }finally{
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