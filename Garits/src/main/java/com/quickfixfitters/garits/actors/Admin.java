package com.quickfixfitters.garits.actors;

import com.quickfixfitters.garits.database.DBConnectivity;
import com.quickfixfitters.garits.entities.Employee;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class Admin extends User {

    private static Admin admin = null;

    // Singlton design pattern to make sure, admin is only created once
    public static Admin getAdmin() {

        if (admin == null) {
            admin = new Admin();
            System.out.println("New admin object created");
            return admin;
        }
        System.out.println("Admin object already exists");
        return admin;
    }

    // Adds an employee into the database
    public void addEmployee(String role, String forename, String lastname, String password, String Cpassword) {

        System.out.println("In Admin class");

        //Starting connection with Database
        SessionFactory sessionFactory = DBConnectivity.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {

            // Check if passwords match
            if (password.compareTo(Cpassword) == 0) {
                String newPassword = password;

                // 
                session.beginTransaction();

                //Instering data
                Employee employee = new Employee(forename, lastname, role, forename, newPassword);

                session.save(employee);
                System.out.println("Row added");
                JOptionPane.showMessageDialog(null, "User added");

            } else {
                JOptionPane.showMessageDialog(null, "Passwords do not match");
                session.getTransaction().commit();
            }
        } finally {
            session.getTransaction().commit();
            session.close();
        }
    }

    // Removes the employee specified by the parameter id from the database.
    public boolean removeUser(int id) {

        SessionFactory sessionFactory = DBConnectivity.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        // Tries to delete the employee specified by the id. If it fails, the
        // current session is rolled back.
        try {
            session.beginTransaction();
            Employee employee = session.get(Employee.class, id);
            session.delete(employee);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;

    }
    
    // Returns a list of all employees in the database.
    public List<Employee> getEmployees() {
        SessionFactory sessionFactory = DBConnectivity.getSessionFactory();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Employee.class);
            return (List<Employee>) criteria.list();
        }
    }
    
    
    // Returns true if the user specified by the paramters firstname and
    // lastname exists in the database, returns false otherwise.
    public boolean doesUserExist(String firstname, String lastname) {

        //Starting connection with Database
        SessionFactory sessionFactory = DBConnectivity.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            // Checking whether user exists
            Criteria criteria = session.createCriteria(Employee.class);
            Criterion name = Restrictions.eq("firstname", firstname);
            Criterion forename = Restrictions.eq("lastname", lastname);
            criteria.add(Restrictions.and(name, forename));

            // A list of employees
            List<Employee> details = (List<Employee>) criteria.list();

            if (details.size() <= 0) {
                JOptionPane.showMessageDialog(null, "User not found");
                return false;
            } else {
                System.out.println("exists");
                return true;
            }

        } finally {
            session.getTransaction().commit();
            session.close();
        }
    }
    
    // Attempts to update the user specified by the parameters.
    public void updateUser(int employeeNo, String firstname, String lastname, String role){
        
        SessionFactory sessionFactory = DBConnectivity.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        // Tries to update the specified employee with the data in the 
        // parameters, if it fails for any reason, the current transaction
        // is rolled back.
        try {
            session.beginTransaction();
            Employee employee = session.get(Employee.class, employeeNo);
            employee.setFirstname(firstname);
            employee.setLastname(lastname);
            employee.setRole(role);
            session.update(employee);
            session.getTransaction().commit();     
            
        }
        catch (Exception e) {
            session.getTransaction().rollback();
        }
        finally {
            session.close();
        }
        
    }

//    public User getUser(String username) {
//        // TODO - implement Admin.getUser
//        throw new UnsupportedOperationException();
//    }
    public void backupDB() {
        try{
            File backup = new File("files/backup.txt");
            backup.createNewFile();
            
            PrintWriter writer = new PrintWriter(backup, "UTF-8");
            
            List<Employee> employees = getEmployees();
            
            writer.println(employees.size());
            for (Employee employee : employees){
                writer.println(employee.getEmployeeNo()+"#"+ employee.getFirstname()+
                        "#"+employee.getLastname()+"#"+employee.getRole()+"#"+
                        employee.getUsername()+"#"+employee.getPassword());
            }
            
            writer.close();
            JOptionPane.showMessageDialog(null, "Database back up succeeded");
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Database back up failed");
        }
    }

    public void restoreDB() {
        File backup = new File("files/backup.txt");
        Admin admin = Admin.getAdmin();
        
        try{
            backup.createNewFile();
            BufferedReader reader = new BufferedReader(new FileReader(backup));
            int numberOfEmployees = Integer.parseInt(reader.readLine());
            String[] parts;
            String line;
            
            for (int i = 0; i < numberOfEmployees; i++){
                line = reader.readLine();
                parts = line.split("#");
                admin.addEmployee(parts[3], parts[1], parts[2], parts[5], parts[5]);
            }
            reader.close();
            JOptionPane.showMessageDialog(null, "Database restore succeeded");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Database restore failed");
        }
    }
}
