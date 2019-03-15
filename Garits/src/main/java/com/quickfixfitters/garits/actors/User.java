package com.quickfixfitters.garits.actors;

import com.quickfixfitters.garits.database.DBConnectivity;
import com.quickfixfitters.garits.entities.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class User {

        // Variables for username and password
	private String username;
	private String password;

        private static User user = null;

    // Singlton design pattern to make sure, admin is only created once
    public static User getUser() {

        if (user == null) {
            user = new Admin();
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
        
        public boolean Login(String username, String password) {
            //Starting connection with Database
            SessionFactory sessionFactory = DBConnectivity.getSessionFactory();
            Session session = sessionFactory.getCurrentSession();

//            try {
//
//                Employee employee = new Employee();
//                session.beginTransaction();
//                employee = session.get(Employee.class, 1);
//                session.getTransaction().commit();
//                System.out.println(employee.toString());
//
//            } finally {
//                session.close();
//                sessionFactory.close();
//            }
//
//            String sql = "select * from employee where username=? and password=?";
//            PreparedStatement pst = con.prepareStatement(sql);
//
//            pst.setString(1, username);
//            // Case sensitive password
//            pst.setString(2, password);
//
//            ResultSet rs = pst.executeQuery();
//
//            if(rs.next()){
//                return true;
//            } else{
//                return false;
//            }
//
//        }
//        catch(Exception e){
//            System.out.println("Error in user service");
//        }
        return false;
    }
        
       public void updatePass(String username, String password, String newPass, String CNewPass) {
//        Connection conn = DBConnectivity.getConnection();
//
//        boolean success = Login(username, password);
//        if (success) {
//            // Check if passwords match
//            if (newPass.compareTo(CNewPass) == 0) {
//                String newPassword = newPass;
//                // Update user password
//                
//                try {
//                    String update = "UPDATE employee SET `password` = ? WHERE username = ?";
//                    PreparedStatement pstUpdate = conn.prepareStatement(update);
//                    pstUpdate.setString(1, newPassword);
//                    pstUpdate.setString(2, username.toLowerCase());
//                    int j = pstUpdate.executeUpdate();
//
//                    
//                    JOptionPane.showMessageDialog(null, "Password changed");
//                } catch (SQLException ex) {
//                    Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                
//            } else {
//                JOptionPane.showMessageDialog(null, "Passwords do not match");
//            }
//        }else{
//            JOptionPane.showMessageDialog(null, "Username and password do not match");
//        }

    }
        

}