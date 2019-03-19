package com.quickfixfitters.garits.actors;

import com.quickfixfitters.garits.database.DBConnectivity;
import com.quickfixfitters.garits.entities.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class User {

    // Variables for username and password
    private String username;
    private String password;

    private static User user = null;

    // Singlton design pattern to make sure, user is only created once
    public static User getUser() {

        if (user == null) {
            user = new User();
            System.out.println("New User object created");
            return user;
        }
        System.out.println("User object already exists");
        return user;
    }

    // Constructor for User
    public User(String username, String password) {
        this.username = username;
        this.password = password;

    }

    public User() {

    }

    public boolean loginCheck(String username, String password) {
        //Starting connection with Database
        SessionFactory sessionFactory = DBConnectivity.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            // Checking whether user exists
            Criteria criteria = session.createCriteria(Employee.class);
            Criterion name = Restrictions.eq("username", username);
            Criterion forename = Restrictions.eq("password", password);
            criteria.add(Restrictions.and(name, forename));

            // A list of employees
            List<Employee> details = (List<Employee>) criteria.list();

            // If list of size 1 (means 1 record is found) a user is matched
            if (details.size() <= 0) {
                return false;
            } else {
                return true;
            }
        } finally {
            session.getTransaction().commit();
            session.close();
        }

    }

    public void updatePass(String username, String password, String newPass, String CNewPass) {

        SessionFactory sessionFactory = DBConnectivity.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            // Checking whether user exists
            boolean success = loginCheck(username, password);
            if (success){
                
            }
            Criteria criteria = session.createCriteria(Employee.class);
            Criterion name = Restrictions.eq("username", username);
            Criterion forename = Restrictions.eq("password", password);
            criteria.add(Restrictions.and(name, forename));

            // A list of employees
            List<Employee> details = (List<Employee>) criteria.list();

            // If list of size 1 (means 1 record is found) a user is matched
//            if (details.size() <= 0) {
//                return false;
//            } else {
//                return true;
//            }
        } finally {
            session.getTransaction().commit();
            session.close();
        }
        
        
    }
}
