/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quickfixfitters.garits.GUI;

import com.quickfixfitters.garits.actors.Franchisee;
import com.quickfixfitters.garits.database.DBConnectivity;
import com.quickfixfitters.garits.entities.Customer;
import com.quickfixfitters.garits.entities.JobSheet;
import com.quickfixfitters.garits.entities.Vehicle;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ExistingCustomerFranchisee extends javax.swing.JFrame {

    /**
     * Creates new form existingCustomer
     */
    // Field of type Garits so we can access its methods.
    Garits garits;

    String accDesc = "";

    public ExistingCustomerFranchisee(Garits garits) {
        initComponents();
        // Setting default visibility of labels and buttons
        standardJob.setSelected(true);
        newJob.setSelected(false);
        jLabel3.setVisible(false);
        desc.setVisible(false);
        addDesc.setVisible(false);
        jLabel4.setVisible(false);
        eta.setVisible(false);
        populateCustomers();
        this.garits = garits;
    }

    // Method to populate customers
    private void populateCustomers() {
        // Creates a connection to database
        SessionFactory sessionFactory = DBConnectivity.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        // Using an already created object of franchisee instead of creating one for every function
        Franchisee franchisee = Franchisee.getFranchisee();
        List<Customer> customers = franchisee.getCustomers();

        // Inserting data into table
        for (Customer customer : customers) {
            model.insertRow(
                    model.getRowCount(), new Object[]{
                customer.getCustomerID(),
                customer.getForename(),
                customer.getSurname()
            }
            );
        }
    }

    // Method to populate vehicles tables
    public void populateVehicles() {
        SessionFactory sessionFactory = DBConnectivity.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {

            session.beginTransaction();
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            int selectedRow = jTable1.getSelectedRow();
            int customerId = (Integer) jTable1.getValueAt(selectedRow, 0);

            Customer c = session.get(Customer.class, customerId);
            List<Vehicle> vehicles = c.getVehicles();
            
            // Inserting data into table
            for (Vehicle vehicle : vehicles) {
                model.insertRow(
                        model.getRowCount(), new Object[]{
                    vehicle.getRegNo(),
                    vehicle.getChassisNo(),
                    vehicle.getColor(),
                    vehicle.getEngSerial(),
                    vehicle.getMake(),
                    vehicle.getModel()}
                );
            }

        } finally {
            session.getTransaction().commit();
            session.close();
        }
    }

    // Populate jobs method
    public void populateJobs() {
        SessionFactory sessionFactory = DBConnectivity.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();

        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        int selectedRow = jTable2.getSelectedRow();
        String vehicleId = jTable2.getValueAt(selectedRow, 0).toString();

        Vehicle v = session.get(Vehicle.class, vehicleId);

        List<JobSheet> jobSheets = v.getJobSheet();

        // Inserting data into table
        for (JobSheet jobSheet : jobSheets) {
            model.insertRow(
                    model.getRowCount(), new Object[]{
                jobSheet.getJobNo(),
                jobSheet.getEstimatedTime()+ " minutes"}
            );
        }

        session.getTransaction().commit();
        session.close();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel15 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        sJob = new javax.swing.JComboBox<>();
        standardJob = new javax.swing.JRadioButton();
        newJob = new javax.swing.JRadioButton();
        refresh = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        desc = new javax.swing.JTextField();
        eta = new javax.swing.JTextField();
        addDesc = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        addJob = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        jLabel15.setText("VEHICLE DETAILS");

        jLabel10.setText("jLabel10");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel9.setText("ADD JOB");

        jTable1.setBackground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "First name", "Last name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RegNo", "ChassisNo", "Color", "EngSerial", "Make", "Model"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "JobNo", "Estimated Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable3);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Standard jobs: ");

        sJob.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        sJob.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MOT", "Annual service", "Standard service" }));

        standardJob.setBackground(new java.awt.Color(255, 255, 255));
        standardJob.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        standardJob.setText("Standard job");
        standardJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                standardJobActionPerformed(evt);
            }
        });

        newJob.setBackground(new java.awt.Color(255, 255, 255));
        newJob.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        newJob.setText("New job");
        newJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newJobActionPerformed(evt);
            }
        });

        refresh.setBackground(new java.awt.Color(183, 183, 183));
        refresh.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        refresh.setText("Refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Description of work: ");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Estimated Time: ");

        desc.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        eta.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        addDesc.setBackground(new java.awt.Color(183, 183, 183));
        addDesc.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        addDesc.setText("Add description");
        addDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDescActionPerformed(evt);
            }
        });

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable4);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back1.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/QFFLOGO.png"))); // NOI18N

        addJob.setBackground(new java.awt.Color(183, 183, 183));
        addJob.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        addJob.setText("Add Job");
        addJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJobActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(standardJob)
                                .addGap(18, 18, 18)
                                .addComponent(newJob))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(69, 69, 69)
                                .addComponent(sJob, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(eta, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(desc, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addComponent(addJob, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(addDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(standardJob)
                            .addComponent(newJob))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(sJob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(desc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addDesc))
                                .addGap(19, 19, 19)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(eta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(56, 56, 56)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(refresh)
                                    .addComponent(addJob))
                                .addContainerGap(170, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addGap(22, 22, 22))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
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

    // Opens the my profile screen.
    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        garits.openNewScreen(this, new MyProfile(garits));
    }//GEN-LAST:event_jMenu1MouseClicked

    // Opens help file.
    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        try {
            garits.openHelp(this);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Help file not availiable");
        }
    }//GEN-LAST:event_jMenu2MouseClicked

    // Logs out the user.
    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        garits.logout(this);
    }//GEN-LAST:event_jMenu3MouseClicked


    // Table mouse clicked method
    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked

        DefaultTableModel model3 = (DefaultTableModel) jTable3.getModel();
        DefaultTableModel model4 = (DefaultTableModel) jTable4.getModel();
        model3.setRowCount(0);
        model4.setRowCount(0);

        populateJobs();


    }//GEN-LAST:event_jTable2MouseClicked

    // Table mouse clicked method
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel model2 = (DefaultTableModel) jTable2.getModel();
        DefaultTableModel model3 = (DefaultTableModel) jTable3.getModel();
        DefaultTableModel model4 = (DefaultTableModel) jTable4.getModel();

        model2.setRowCount(0);
        model3.setRowCount(0);
        model4.setRowCount(0);
        populateVehicles();


    }//GEN-LAST:event_jTable1MouseClicked

    private void standardJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_standardJobActionPerformed
        // Setting visibility according to what job type is selected
        if (standardJob.isSelected()) {
            newJob.setSelected(false);
            jLabel3.setVisible(false);
            desc.setVisible(false);
            addDesc.setVisible(false);
            jLabel4.setVisible(false);
            eta.setVisible(false);
            
            
            standardJob.setSelected(true);
            jLabel2.setVisible(true);
            sJob.setVisible(true);
        }
    }//GEN-LAST:event_standardJobActionPerformed

    private void newJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newJobActionPerformed
        // Setting visibility according to what job type is selected
        if (newJob.isSelected()) {
            standardJob.setSelected(false);
            jLabel2.setVisible(false);
            sJob.setVisible(false);
            
            newJob.setSelected(true);
            jLabel3.setVisible(true);
            desc.setVisible(true);
            addDesc.setVisible(true);
            jLabel4.setVisible(true);
            eta.setVisible(true);
        }
    }//GEN-LAST:event_newJobActionPerformed


    // Refresh button method, repopulates tables
    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        DefaultTableModel model2 = (DefaultTableModel) jTable2.getModel();
        DefaultTableModel model3 = (DefaultTableModel) jTable3.getModel();
        DefaultTableModel model4 = (DefaultTableModel) jTable4.getModel();

        model.setRowCount(0);
        model2.setRowCount(0);
        model3.setRowCount(0);
        model4.setRowCount(0);
        
        populateCustomers();


    }//GEN-LAST:event_refreshActionPerformed

    // Add MOT method
    private void addMot() {
        SessionFactory sessionFactory = DBConnectivity.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        java.util.Date uDate = new java.util.Date();
        java.sql.Date sDate = convertUtilToSql(uDate);
        int selectedRow = jTable2.getSelectedRow();
        String vehicleId = jTable2.getValueAt(selectedRow, 0).toString();

        try {
            session.beginTransaction();
            // Preset description of MOT
            String motDesc = "Check lamps. Reflectors and electrical equipment,Check steering and suspension,Check brakes,Check tyres and road wheels,Check seat belts and restraint systems,Check body structure and general items,Check drivers view of the road";
            String estimatedTime = "60";
            JobSheet jobSheet = new JobSheet(sDate, motDesc, estimatedTime, vehicleId);

            Vehicle v = session.get(Vehicle.class, vehicleId);
            // Adds and updates job to the vehicle
            v.getJobSheet().add(jobSheet);
            session.update(v);
            DefaultTableModel model3 = (DefaultTableModel) jTable3.getModel();

            int jobNo;
            if (jTable3.getRowCount() == 0) {
                jobNo = 1;
            } else {
                int row = jTable3.getRowCount() - 1;
                jobNo = ((int) jTable3.getValueAt(row, 0)) + 1;
            }
            
            
            model3.insertRow(model3.getRowCount(), new Object[]{jobNo, estimatedTime});
            JOptionPane.showMessageDialog(this, "Job added");

        } finally {
            session.getTransaction().commit();
            session.close();
        }
    }

    private void addAnnual() {
        SessionFactory sessionFactory = DBConnectivity.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        System.out.println("annual service function goes here");
        java.util.Date uDate = new java.util.Date();
        java.sql.Date sDate = convertUtilToSql(uDate);
        int selectedRow = jTable2.getSelectedRow();
        String vehicleId = jTable2.getValueAt(selectedRow, 0).toString();

        try {
            session.beginTransaction();
            // Preset description of annual service
            String annualDesc = "An engine oil change,An engine oil filter replacement,The checking of lights and tyres exhaust and operation of brakes and steering,Checking hydraulic fluid and coolant levels,Suspensions checks,Testing battery condition";
            // Prest estimated time
            String estimatedTime = "180";
            JobSheet jobSheet = new JobSheet(sDate, annualDesc, estimatedTime, vehicleId);
            Vehicle v = session.get(Vehicle.class, vehicleId);
            // Adds job to the vehicle
            v.getJobSheet().add(jobSheet);
            session.update(v);
            DefaultTableModel model3 = (DefaultTableModel) jTable3.getModel();

           
            int jobNo;
            if (jTable3.getRowCount() == 0) {
                jobNo = 1;
            } else {
                int row = jTable3.getRowCount() - 1;
                jobNo = ((int) jTable3.getValueAt(row, 0)) + 1;
            }
            
            model3.insertRow(model3.getRowCount(), new Object[]{jobNo, estimatedTime});
            JOptionPane.showMessageDialog(this, "Job added");
        } finally {
            session.getTransaction().commit();
            session.close();
        }
    }
    
    private void addStandard() {
        SessionFactory sessionFactory = DBConnectivity.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        System.out.println("standard job func goes here");
        java.util.Date uDate = new java.util.Date();
        java.sql.Date sDate = convertUtilToSql(uDate);
        int selectedRow = jTable2.getSelectedRow();
        String vehicleId = jTable2.getValueAt(selectedRow, 0).toString();

        try {
            session.beginTransaction();
            // Preset description for standart job
            String standardDesc = "Fuel filter change,Air filter change,Four standard spark plugs,Wheel balancing & alignment check";
            // Preset time for the job
            String estimatedTime = "180";
            JobSheet jobSheet = new JobSheet(sDate, standardDesc, estimatedTime, vehicleId);
            Vehicle v = session.get(Vehicle.class, vehicleId);
            // Adds job the the vehicle
            v.getJobSheet().add(jobSheet);
            session.update(v);
            DefaultTableModel model3 = (DefaultTableModel) jTable3.getModel();

           
            int jobNo;
            if (jTable3.getRowCount() == 0) {
                jobNo = 1;
            } else {
                int row = jTable3.getRowCount() - 1;
                jobNo = ((int) jTable3.getValueAt(row, 0)) + 1;
            }
            
            model3.insertRow(model3.getRowCount(), new Object[]{jobNo, estimatedTime});
            JOptionPane.showMessageDialog(this, "Job added");
        } finally {
            session.getTransaction().commit();
            session.close();
        }
    }

    private void addDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDescActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model4 = (DefaultTableModel) jTable4.getModel();

        String toWrite = desc.getText();

        if (desc.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Description is empty");
        } else {
            // Check if there is existing description
            if (model4.getRowCount() == 0) {
                accDesc = accDesc + toWrite;
            } else {
                accDesc = accDesc + "," + toWrite;
            }
            // Adds to the table
            model4.insertRow(model4.getRowCount(), new Object[]{desc.getText()});
            desc.setText("");
        }

    }//GEN-LAST:event_addDescActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:

        DefaultTableModel model4 = (DefaultTableModel) jTable4.getModel();
        model4.setRowCount(0);
        int selectedRow = jTable3.getSelectedRow();
        int jobNo = (int) jTable3.getValueAt(selectedRow, 0);

        SessionFactory sessionFactory = DBConnectivity.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            JobSheet jobSheet = session.get(JobSheet.class, jobNo);

            String descOfWork = jobSheet.getDescriptionOfWork();

            // Converts the string from DB to a list for jobsheet table
            List<String> list = Stream.of(descOfWork.split(",")).collect(Collectors.toList());

            populateDesc(list, model4);
            //model4.insertRow(model4.getRowCount(), new Object[]{descOfWork});

        } finally {

            session.close();
        }

    }//GEN-LAST:event_jTable3MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        garits.backButton(this);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void addJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJobActionPerformed
        
        // TODO add your handling code here:
        SessionFactory sessionFactory = DBConnectivity.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            if (newJob.isSelected()) {

                if (accDesc.isEmpty() || eta.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Job has no description or estimated time");
                } else {
                    int selectedRow = jTable2.getSelectedRow();
                    String vehicleId = jTable2.getValueAt(selectedRow, 0).toString();
                    try {

                        session.beginTransaction();
                        java.util.Date uDate = new java.util.Date();
                        java.sql.Date sDate = convertUtilToSql(uDate);

                        String description = accDesc;
                        String estimatedTime = eta.getText();

                        // Creates new job sheet for particular vehicle
                        JobSheet jobSheet = new JobSheet(sDate, description, estimatedTime, vehicleId);

                        Vehicle v = session.get(Vehicle.class, vehicleId);
                        // Adds job
                        v.getJobSheet().add(jobSheet);
                        session.update(v);
                        JOptionPane.showMessageDialog(null, "Job added");

                        DefaultTableModel model3 = (DefaultTableModel) jTable3.getModel();

                        int jobNo;
                        if (jTable3.getRowCount() == 0) {
                            jobNo = 1;
                        } else {
                            int row = jTable3.getRowCount() - 1;
                            jobNo = ((int) jTable3.getValueAt(row, 0)) + 1;
                        }

                        System.out.println(jobNo);
                        // Adds to the table
                        model3.insertRow(model3.getRowCount(), new Object[]{jobNo, estimatedTime});

                    } finally {
                        session.getTransaction().commit();
                        session.close();
                    }
                }

            } else if (standardJob.isSelected()) {
                System.out.println("Standard job is selected");

                // getting item of drop down
                String job = sJob.getSelectedItem().toString().toLowerCase();
                System.out.println(job);

                // Check to see what is in the combo list
                if (job.compareTo("annual service") == 0) {
                    addAnnual();
                } else if (job.compareTo("mot") == 0) {
                    addMot();
                }else if(job.compareTo("standard service") == 0){
                    addStandard();
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Vehicle not selected");
        }
    }//GEN-LAST:event_addJobActionPerformed

    private void populateDesc(List<String> list, DefaultTableModel model4) {

        for (String str : list) {
            System.out.println(str);
            model4.insertRow(
                    model4.getRowCount(), new Object[]{
                str}
            );
        }
    }

    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addDesc;
    private javax.swing.JButton addJob;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField desc;
    private javax.swing.JTextField eta;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JRadioButton newJob;
    private javax.swing.JButton refresh;
    private javax.swing.JComboBox<String> sJob;
    private javax.swing.JRadioButton standardJob;
    // End of variables declaration//GEN-END:variables
}
