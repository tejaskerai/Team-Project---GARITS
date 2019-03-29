/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quickfixfitters.garits.GUI;

import com.quickfixfitters.garits.actors.User;
import com.quickfixfitters.garits.database.DBConnectivity;
import com.quickfixfitters.garits.entities.Employee;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    // A variable of type Garits is passed to the screen since we need
    // access to its methods.
    Garits garits;

    public Home(Garits garits) {
        initComponents();
        
        this.garits = garits;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        login = new javax.swing.JButton();
        password = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("Password:");

        username.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });

        login.setBackground(new java.awt.Color(34, 167, 240));
        login.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        login.setForeground(new java.awt.Color(255, 255, 255));
        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        password.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Username:");

        jLabel4.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(279, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(password)
                    .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))
                .addContainerGap(277, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(552, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(username, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(32, 32, 32)
                .addComponent(login)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        jMenu1.setText("Help");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Code for the button 'login'. Since the login screen can't be got
    // to using a back button, There is no need to add it to the stack.
    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed


        loginAction();
    }//GEN-LAST:event_loginActionPerformed

    private void loginAction() {

        String employeeUsername = username.getText();
        String userPassword = password.getText();

        User user = new User();
        boolean success = user.loginCheck(employeeUsername, userPassword);
        if (success) {

            // Creates connection to DB
            SessionFactory sessionFactory = DBConnectivity.getSessionFactory();
            Session session = sessionFactory.getCurrentSession();

            try {
                // Begin transaction to DB
                session.beginTransaction();

                // Query to get all employees with username and password given
                Query query = session.createQuery("from Employee where username=:username and password=:password");
                query.setString("username", employeeUsername);
                query.setString("password", userPassword);

                // Create a list of all records
                List employees = query.list();

                Iterator it = employees.iterator();
                Object o = (Object) it.next();
                Employee e = (Employee) o;

                // Role from login stored here
                String role = e.getRole();

                // Will show different screens depending on what user role is
                switch (role) {
                    case "admin":
                        JFrame admin = new Admin(garits);
                        garits.setUsername(employeeUsername);
                        garits.setPassword(userPassword);
                        garits.putOnScreen(admin);
                        dispose();
                        break;
                    case "mechanic":
                        JFrame mechanic = new Mechanic(garits);
                        garits.setUsername(employeeUsername);
                        garits.setPassword(userPassword);
                        garits.putOnScreen(mechanic);
                        dispose();
                        // When login button clicked, login page closes and another one opens

                        break;
                    case "receptionist":
                        JFrame receptionist = new Receptionist(garits);
                        garits.setUsername(employeeUsername);
                        garits.setPassword(userPassword);
                        garits.putOnScreen(receptionist);
                        dispose();
                        break;
                    case "franchisee":
                        JFrame franchisee = new FranchiseeMain(garits);
                        garits.setUsername(employeeUsername);
                        garits.setPassword(userPassword);
                        garits.putOnScreen(franchisee);
                        dispose();
                        break;
                }
            } finally {
                session.getTransaction().commit();
                session.close();
            }
        } else {
            // Clear text fields when wrong credentials are entered
            JOptionPane.showMessageDialog(null, "Inncorrect Credentials");
            this.username.setText("");
            this.password.setText("");
        }

    }


    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    // Code that runs when the user clicks on the help button.
    // The system opens the help file and displays it to the user.
    // If help file isn't available, display error message.
    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        try {
            garits.openHelp(this);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Help file not availiable");
        }
    }//GEN-LAST:event_jMenu1MouseClicked

    private void passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            loginAction();
        }
    }//GEN-LAST:event_passwordKeyPressed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton login;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
