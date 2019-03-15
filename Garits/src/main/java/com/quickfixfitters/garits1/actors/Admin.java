package com.quickfixfitters.garits1.actors;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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

    public void addEmployee(String role, String forename, String lastname, String password, String Cpassword) throws SQLException {

//        System.out.println("In Admin class");
//        Connection conn = DBConnectivity.getConnection();
//        
//        // Check if passwords match
//        if (password.compareTo(Cpassword) == 0) {
//            String newPassword = password;
//
//            // Adding details to DB from the filled out form
//            String sql = "insert into employee (firstname, lastname, username, password, role) values (?, ?, ?, ?, ?)";
//            PreparedStatement pst = conn.prepareStatement(sql);
//            pst.setString(1, forename.toLowerCase());
//            pst.setString(2, lastname.toLowerCase());
//            pst.setString(3, forename.toLowerCase());
//            pst.setString(4, newPassword);
//            pst.setString(5, role.toLowerCase());
//            int i = pst.executeUpdate();
//            
//            
//            // Get next EmployeeNo
//            String getId = "select EmployeeNo from employee where firstname = ? AND lastname = ?";
//            PreparedStatement pstGetId = conn.prepareStatement(getId);
//            pstGetId.setString(1, forename.toLowerCase());
//            pstGetId.setString(2, lastname.toLowerCase());
//            ResultSet rs = pstGetId.executeQuery();
//            // Return the line after the heading of the table
//            rs.next();
//          
//            // ID stored here
//            String id = rs.getString("EmployeeNo");
// 
//            
//            // Update username so its firstname + id
//            String username = forename+id;
//            String update = "UPDATE employee SET username = ? WHERE firstname = ? AND lastname = ?";
//            PreparedStatement pstUpdate = conn.prepareStatement(update);
//            pstUpdate.setString(1, username.toLowerCase());
//            pstUpdate.setString(2, forename.toLowerCase());
//            pstUpdate.setString(3, lastname.toLowerCase());
//            int j = pstUpdate.executeUpdate();
//            
//            // Check if update happened
//            if ((i > 0) && (j>0)) {
//                System.out.println("Added");
//            } else {
//                System.out.println("Not added");
//            }
//
//        } else {
//            JOptionPane.showMessageDialog(null, "Passwords do not match");
//        }
//    }
//
//    public void removeUser(String forename, String surname) {
//
//        try {
//            Connection conn = DBConnectivity.getConnection();
//            String sql = "DELETE FROM employee WHERE firstname=? and lastname=?";
//            PreparedStatement pst = conn.prepareStatement(sql);
//            pst.setString(1, forename);
//            pst.setString(2, surname);
//            int i = pst.executeUpdate();
//            if (i > 0) {
//                System.out.println("Deleted");
//            } else {
//                System.out.println("Not deleted");
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    public boolean doesUserExist(String firstname, String lastname) {
//        try {
//            Connection conn = DBConnectivity.getConnection();
//
//            String sql = "select * from employee where firstname=? and lastname=?";
//            PreparedStatement pst = conn.prepareStatement(sql);
//
//            pst.setString(1, firstname);
//            pst.setString(2, lastname);
//
//            ResultSet rs = pst.executeQuery();
//
//            if (rs.next()) {
//                return true;
//            } else {
//                return false;
//            }
//
//        } catch (Exception e) {
//            System.out.println("Error in user service");
//        }
//        return false;
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
