/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quickfixfitters.garits.GUI;

import com.quickfixfitters.garits.actors.Franchisee;
import com.quickfixfitters.garits.actors.Receptionist;
import com.quickfixfitters.garits.database.DBConnectivity;
import com.quickfixfitters.garits.entities.MOTReminder;
import com.quickfixfitters.garits.entities.Part;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author ccram
 */
public class Alerts extends javax.swing.JFrame {

    /**
     * Creates new form Alerts
     */
    
    // Field of type Garits so we can access its methods.
    Garits garits;
    
    public Alerts(Garits garits) {
        initComponents();
        this.garits = garits;
        populateTable();
        populateStock();
    }

    // Popultes this screen's table with the appropriate data.
    public void populateTable(){    
        SessionFactory sessionFactory = DBConnectivity.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        
        // Gets an object of type Franchisee so we can use it's methods
        Franchisee franchisee = Franchisee.getFranchisee();
        session.beginTransaction();
        
        // Retrieves all MOT reminders
        List<MOTReminder> motReminders = franchisee.getMOTReminders(session);
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        // Puts required data from all MOT reminders onto the table
        for (MOTReminder motReminder : motReminders){
            if (motReminder.getPrinted() == 0){
                model.insertRow(
                        model.getRowCount(), new Object[] {
                            "MOT",
                            motReminder.getMotVehicle().getCustomer().getForename(),
                            motReminder.getMotVehicle().getCustomer().getSurname(),
                            motReminder.getMotVehicle().getRegNo(),
                            motReminder.getMotReminderId()
                        });
            }
        }
        session.getTransaction().commit();

        session.close();

    }
    
    public void populateStock(){
//        SessionFactory sessionFactory = DBConnectivity.getSessionFactory();
//        Session session = sessionFactory.getCurrentSession();
        
        // Gets an object of type Franchisee so we can use it's methods
        Franchisee franchisee = Franchisee.getFranchisee();
        //session.beginTransaction();
        
        DefaultTableModel model2 = (DefaultTableModel) jTable2.getModel();
        
        List<Part> parts = franchisee.getStock();
        
        
        for (Part part : parts) {
            model2.insertRow(
                    model2.getRowCount(), new Object[]{
                part.getId(),
                part.getPartName(),
                part.getStockLevel(),
                part.getLowLevelThreshold(),
                checkStock(part.getStockLevel(),part.getLowLevelThreshold())
            }
            );
        }
        
//        
//        session.getTransaction().commit();
//        session.close();
        
    }
    
    public String checkStock(int stockLevel, int threshold){
        if(stockLevel<threshold){
            return "Stock under threshold";
            
        }else{
            return "Stock level above threshold";
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Type", "CustomerForename", "CustomerSurname", "VehicleRegNo", "ReminderId"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton2.setBackground(new java.awt.Color(183, 183, 183));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton2.setText("GENERATE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(183, 183, 183));
        jButton3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton3.setText("OPEN FILES");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/QFFLOGO.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back1.png"))); // NOI18N
        jLabel2.setToolTipText("");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Part ID", "Part name", "Stock Level", "Threshold", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addComponent(jLabel1))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 858, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(692, 692, 692)
                .addComponent(jButton3)
                .addGap(50, 50, 50)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE))
                .addGap(175, 175, 175)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jMenu1.setText("My Profile");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Help");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Logout");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu3);

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

    // Opens the my profile screen
    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        garits.openNewScreen(this, new MyProfile(garits));
    }//GEN-LAST:event_jMenu1MouseClicked

    // Opens the help file or displays an error message if the help file
    // doesn't exist
    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        try{
            garits.openHelp(this);
        } catch (IOException e){
            JOptionPane.showMessageDialog(this, "Help file not availiable");
        }
    }//GEN-LAST:event_jMenu2MouseClicked

    // Logs the user out of the system.
    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        garits.logout(this);
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed

    }//GEN-LAST:event_jMenu3ActionPerformed

    // Generates an mot reminder for the selected alert as a .txt file
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // All in a try/catch statement so that we can show the user a 
        // JOptionPane if they fail to specify an alert.
        try{
            SessionFactory sessionFactory = DBConnectivity.getSessionFactory();
            Session session = sessionFactory.getCurrentSession();
            
            // Gets an object of type Receptionist so we can access its methods
            Receptionist receptionist = Receptionist.getReceptionist();
            
            // Get the type of alert and its Id.
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            int row = jTable1.getSelectedRow();
            String type = (String) jTable1.getValueAt(row, 0);
            int id = (Integer) jTable1.getValueAt(row, 4);
            
            session.beginTransaction();
            
            // Checks if the alert is for an MoT and if so calls the methods to
            // generate it.
            if (type.equals("MOT")){
                MOTReminder reminder = session.get(MOTReminder.class, id);
                reminder.setPrinted(1);
                receptionist.generateMOTReminder(reminder, session);
                session.update(reminder);
            }
            
            session.getTransaction().commit();
            session.close();
            model.setRowCount(0);
            populateTable();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No alert selected");
        }
        jTable1.clearSelection();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        garits.backButton(this);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
