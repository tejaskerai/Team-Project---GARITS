package com.quickfixfitters.garits.actors;

import com.quickfixfitters.garits.entities.MOTReminder;
import com.quickfixfitters.garits.entities.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import org.hibernate.Session;


public class Receptionist extends User {
    
    public static Receptionist receptionist = null;
    private String username = "";
    private String password = "";
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
    // Singleton for receptionist
    public static Receptionist getReceptionist(){
        if (receptionist == null) {
            receptionist = new Receptionist();
            System.out.println("New Receptionist object created");
            return receptionist;
        }
        System.out.println("Franshisee object already exists");
        return receptionist;
    }

    public static void setReceptionist(Receptionist receptionist) {
        Receptionist.receptionist = receptionist;
    }
    
    // Creates the file for an MOT reminder.
    public void generateMOTReminder(MOTReminder reminder, Session session){
        try{
            // Ensures that the MOT reminder file name is unique.
            String fileName = "files/motReminders/" + reminder.getMotVehicle().getRegNo() + 
                    "---" + dateFormat.format(new Date()) + "---MOT" + ".txt";
            
            File newReminder = new File(fileName);
            newReminder.createNewFile();
            
            PrintWriter writer = new PrintWriter(fileName, "UTF-8");
            
            printOurAddress(writer);
            printTheirAddress(writer, reminder, session);
            
            // Writing to file in specific format
            writer.println(dateFormat.format(new Date()));
            writer.println("");
            writer.println("Dear " + reminder.getMotVehicle().getCustomer().getForename() + " " +
                    reminder.getMotVehicle().getCustomer().getSurname() + ",");
            writer.println("");
            
            writer.println("REMINDER - MoT TEST DUE");
            writer.println("Vehicle Registration No: " + reminder.getMotVehicle().getRegNo() + 
                    "       Renewal Test Date: " + dateFormat.format(reminder.getMotVehicle().getRenewalTestDate()));
            writer.println("");
            
            writer.println("The above vehicle is due to have its MoT certificate renewed on the date shown.");
            writer.println("");
            writer.println("We hope you will use our services to carry out the necessary test.");
            writer.println("");
            
            writer.println("Yours sincerely,");
            writer.println("G. Lancaster");
            
            writer.close();
            
            reminder.getMotVehicle().getRenewalTestDate().setYear(reminder.getMotVehicle().getRenewalTestDate().getYear() + 1);
            reminder.getMotVehicle().getRenewalReminderDate().setYear(reminder.getMotVehicle().getRenewalReminderDate().getYear() + 1);
            
            JOptionPane.showMessageDialog(null, "File created");
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Printing failed");
            reminder.setPrinted(0);
        }
    }
    
    //Code that generates a replenishment order
    public void generateReplenishmentOrder(Part p){
        try{
            String filename = "files/replenishmentOrder/"+ p.getPartCode() + 
                    "---" + dateFormat.format(new Date())+".txt";
            File newOrder = new File(filename);
            newOrder.createNewFile();
            
            PrintWriter writer = new PrintWriter(filename, "UTF-8");
            
            printOurAddress(writer);
            writer.println(dateFormat.format(new Date()));
            writer.println();
            writer.println("Part: "+p.getPartCode());
            writer.println("Quantity: 10");
            
            writer.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Printing failed");
        }
    }
    
    // Prints the address of the customer
    public void printTheirAddress(PrintWriter writer, MOTReminder reminder, Session session){
        writer.println(reminder.getMotVehicle().getCustomer().getForename().charAt(0) + 
                ". " + reminder.getMotVehicle().getCustomer().getSurname() + ",");
        writer.println(reminder.getMotVehicle().getCustomer().getCustomerAddress() + ",");
        writer.println(reminder.getMotVehicle().getCustomer().getPostcode());
        writer.println("");
    }
    
    // Prints the address of the garage.
    public void printOurAddress(PrintWriter writer){
        writer.println("Quick Fix Fitters.,");
        writer.println("19 High St.,");
        writer.println("Ashford,");
        writer.println("Kent CT16 8YY");
        writer.println("");
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
    
    public void createJob() {
            // TODO - implement Receptionist.createJob
            throw new UnsupportedOperationException();
    }

    public void getJobStatus() {
            // TODO - implement Receptionist.getJobStatus
            throw new UnsupportedOperationException();
    }

    public void createInvoice() {
            // TODO - implement Receptionist.createInvoice
            throw new UnsupportedOperationException();
    }

    public void orderPart() {
            // TODO - implement Receptionist.orderPart
            throw new UnsupportedOperationException();
    }

    public void checkPart() {
            // TODO - implement Receptionist.checkPart
            throw new UnsupportedOperationException();
    }

    public void addNoteToPart() {
            // TODO - implement Receptionist.addNoteToPart
            throw new UnsupportedOperationException();
    }

    public static Receptionist Receptionist(String username, String password) {
            // TODO - implement Receptionist.Receptionist
            throw new UnsupportedOperationException();
    }

}