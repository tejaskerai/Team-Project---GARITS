package com.quickfixfitters.garits.actors;

import com.quickfixfitters.garits.database.DBConnectivity;
import com.quickfixfitters.garits.entities.Employee;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.Query;
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

//                // Getting id of newely created record
//                Criteria criteria = session.createCriteria(Employee.class);
//                criteria.add(Restrictions.eq("firstname", forename)).uniqueResult();
//
//                // Gets the id of newly created record
//                List<Employee> details = (List<Employee>) criteria.list();
//                int id = details.get(0).getEmployeeNo();
//                String stringId = Integer.toString(details.get(0).getEmployeeNo());
//
//                // Updates username to have the id added on
//                employee = session.get(Employee.class, id);
//                employee.setUsername(forename + stringId);

            } else {
                JOptionPane.showMessageDialog(null, "Passwords do not match");
                session.getTransaction().commit();
            }
        } finally {
            session.getTransaction().commit();
            session.close();
        }
    }

    public boolean removeUser(int id) {

        SessionFactory sessionFactory = DBConnectivity.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

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
    
    public List<Employee> getEmployees() {
        SessionFactory sessionFactory = DBConnectivity.getSessionFactory();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Employee.class);
            return (List<Employee>) criteria.list();
        }
    }
    
    

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
    
    public void updateUser(int employeeNo, String firstname, String lastname, String role){
        
        SessionFactory sessionFactory = DBConnectivity.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

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
        // TODO - implement Admin.backupDB
        throw new UnsupportedOperationException();
    }

    public void restoreDB() {
        // TODO - implement Admin.restoreDB
        throw new UnsupportedOperationException();
    }
}
