package com.quickfixfitters.garits.GUI;

import com.quickfixfitters.garits.actors.Franchisee;
import com.quickfixfitters.garits.database.DBConnectivity;
import com.quickfixfitters.garits.entities.Customer;
import com.quickfixfitters.garits.entities.MOTReminder;
import com.quickfixfitters.garits.entities.Part;
import com.quickfixfitters.garits.entities.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import javax.swing.JFrame;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import com.quickfixfitters.garits.seeder.EmployeeSeeder;
import com.quickfixfitters.garits.seeder.SeederInterface;
import java.util.Date;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Garits {
    
    private Stack<JFrame> openScreens;
    
    // Two strings that are initialised to the current user.
    // Only initialised once the user logs in.
    private String username;
    private String password;
    private String role;
    
    // Whether or not there are notifications to display once a receptionist
    // logs in.
    private boolean primedNotification;
    
    // Represents the standard rate for both mechanics and the foreperson in
    // pounds per hour.
    private int mechanicRate = 105;
    private int forepersonRate = 125;

    private ArrayList<Part> replenishment;
    public Garits() {
        
        
        //Starting connection with Database
        SessionFactory sessionFactory = DBConnectivity.getSessionFactory();
        SeedData();
        
        // Checks if any new alerts need to be dislayed to a receptionist.
        checkForAlerts();
        
        openScreens = new Stack<>();
        
        // Opens the login screen
        JFrame home = new Home(this);
        this.putOnScreen(home);
    }
    
    // Tries to find all reminders that need creating. Provided that it finds
    // one, it will set primedNotification to true
    public void checkForAlerts(){
        SessionFactory sessionFactory = DBConnectivity.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        
        Franchisee franchisee = Franchisee.getFranchisee();
        
        try{
            session.beginTransaction();
            
            // Gets all vehicles
            Criteria criteria = session.createCriteria(Vehicle.class);
            List<Vehicle> vehicles = (List<Vehicle>) criteria.list();
            List<Part> parts = franchisee.getStock();
            // Checks each vehicle to see if the day when an MOT reminder
            // should be sent has passed. If yes, create the reminder.
            for (Vehicle vehicle : vehicles){
                if (vehicle.getRenewalReminderDate().equals(new Date()) || 
                        vehicle.getRenewalReminderDate().before(new Date())){
                    MOTReminder reminder = new MOTReminder();
                    
                    reminder.setMotVehicle(vehicle);
                    session.save(reminder);
                    
                    vehicle.getMotReminders().add(reminder);
                    session.update(vehicle);
                    
                    this.setPrimedNotification(true);
                }
            }
            
            replenishment.clear();
            for (Part p : parts){
                if (p.getStockLevel() < p.getLowLevelThreshold()){
                    replenishment.add(p);
                    this.setPrimedNotification(true);
                }
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Checking for new alerts failed");
        }finally{
            session.getTransaction().commit();
            session.close();
        }
    }
    
    // Puts the parameter 'frame' on the screen maximised.
    public void putOnScreen(JFrame frame){
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }
    
    // Opens the help file. Method is activated by clicking
    // on the help button at the top of the screen.
    // If the help file is unavailable, a message box opens.
    public void openHelp(JFrame frame) throws IOException{
        File file = new File("help.txt");
        Desktop desktop = Desktop.getDesktop();
        
        if (file.exists()){
            desktop.open(file);
        } else{
            JOptionPane.showMessageDialog(frame, "Help file not available");
        }
    }
    
    // Opens a new screen and closes the old one.
    public void openNewScreen(JFrame frame, JFrame newFrame){
        this.getOpenScreens().push(frame);
        this.putOnScreen(newFrame);
        frame.dispose();
    }
    
    // Pops the most last screen from the stack, puts it on
    // screen then closes the current one.
    public void backButton(JFrame frame){
        this.putOnScreen(this.getOpenScreens().pop());
        frame.dispose();
    }
    
    // Logs the user out of the system.
    // It does this by clearing the stack of screens,
    // then creating a new Home page.
    public void logout(JFrame frame){
        frame.dispose();
        this.getOpenScreens().clear();
        JFrame home = new Home(this);
        this.putOnScreen(home);
    }

    public void SeedData() {
        List<SeederInterface> seeders = new ArrayList<SeederInterface>();
        seeders.add(new EmployeeSeeder());

        for (SeederInterface seeder: seeders) {
            seeder.seed();
        }
    }
    
    // Adds an mot reminder to a vehicle.
    public void generateAlert(String type, Vehicle vehicle, Customer customer){
        SessionFactory sessionFactory = DBConnectivity.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        
        try{
            session.beginTransaction();
            
            if (type.equals("MOT")){
                vehicle.getMotReminders().add(new MOTReminder());
                session.update(vehicle);
            }
            
            session.getTransaction().commit();
        }finally{
            session.close();
        }
    }

    // Getter for the stack of sceens that the user could go back to.
    public Stack<JFrame> getOpenScreens(){
        return openScreens;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    
    
    public boolean isPrimedNotification() {
        return primedNotification;
    }

    public void setPrimedNotification(boolean primedNotification) {
        this.primedNotification = primedNotification;
    }

    public int getMechanicRate() {
        return mechanicRate;
    }

    public void setMechanicRate(int mechanicRate) {
        this.mechanicRate = mechanicRate;
    }

    public int getForepersonRate() {
        return forepersonRate;
    }

    public void setForepersonRate(int forepersonRate) {
        this.forepersonRate = forepersonRate;
    }

    public ArrayList<Part> getReplenishment() {
        return replenishment;
    }

    public void setReplenishment(ArrayList<Part> replenishment) {
        this.replenishment = replenishment;
    }
    
    
    
    public static void main(String[] args){
        new Garits();
    }
    
}
