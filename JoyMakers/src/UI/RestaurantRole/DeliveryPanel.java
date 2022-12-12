/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.RestaurantRole;

import UI.RestaurantRole.*;
import Business.EcoSystem;
import Business.FoodCare;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.RestaurantOrg;
import Business.Organization.Organisation;
import Business.Organization.TransportOrg;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.VolunteerRestaurantWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mrinalini
 */
public class DeliveryPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private RestaurantOrg org;
    private Enterprise ent;
    private UserAccount ua;
    private Network net;
    /**
     * Creates new form DeliveryPanel
     */
    public DeliveryPanel(JPanel userProcessContainer, UserAccount acc, RestaurantOrg org,Network net, Enterprise ent) {
                initComponents();
        this.userProcessContainer = userProcessContainer;
        this.org = (RestaurantOrg)org;
        this.ent = ent;
        this.ua = acc;
        this.net=net;
        autoPopDelivery();
    }
    
    public void autoPopDelivery() {
        DefaultTableModel mdl = (DefaultTableModel)tblMedDelivery.getModel();
        mdl.setRowCount(0);    
        for (Iterator<WorkRequest> wr = org.getWorkQueue().getWrList().iterator(); wr.hasNext();) {
            WorkRequest workRequest = wr.next();
           if(workRequest instanceof VolunteerRestaurantWorkRequest){
               VolunteerRestaurantWorkRequest req = (VolunteerRestaurantWorkRequest) workRequest;
                if(req.getStatus().equalsIgnoreCase("Delivery Requested") || req.getStatus().equalsIgnoreCase("Accepted") || req.getStatus().equalsIgnoreCase("Delivered") || req.getStatus().equalsIgnoreCase("Delivery Assigned") )
                {
                Object[] row = new Object[7];
                row[0] = req;
                row[1]=req.getNgoName();
                row[3]=req.getQuantity();
                row[2]=req.getSender();
                row[4] = req.getReqDate();
                row[5]=req.getStatus();
                row[6]=req.getFoodList();
                mdl.addRow(row);
                }
               
           }
            
            
        }
    }

    public void autoPopReq() {
        DefaultTableModel mdl = (DefaultTableModel)tblMedDelivery.getModel();
        mdl.setRowCount(0);            
        for (Iterator<WorkRequest> wr = org.getWorkQueue().getWrList().iterator(); wr.hasNext();) {
            WorkRequest workRequest = wr.next();
           if(workRequest instanceof VolunteerRestaurantWorkRequest){
               VolunteerRestaurantWorkRequest req = (VolunteerRestaurantWorkRequest) workRequest;
                if(req.getStatus().equalsIgnoreCase("Delivery Requested") )
                {
               Object[] row = new Object[7];
                row[0] = req;
                row[1]=req.getNgoName();
                row[3]=req.getQuantity();
                row[2]=req.getSender();
                row[4] = req.getReqDate();
                row[5]=req.getStatus();
                row[6]=req.getFoodList();
                mdl.addRow(row);
                }
           }
            
            
        }
    }
    
    public void autoPopUnReq() {
        DefaultTableModel mdl = (DefaultTableModel)tblMedDelivery.getModel();
        mdl.setRowCount(0);    
        
        
        for (Iterator<WorkRequest> wr = org.getWorkQueue().getWrList().iterator(); wr.hasNext();) {
            WorkRequest workRequest = wr.next();
           if(workRequest instanceof VolunteerRestaurantWorkRequest){
               VolunteerRestaurantWorkRequest req = (VolunteerRestaurantWorkRequest) workRequest;
                if(req.getStatus().equalsIgnoreCase("Accepted") )
                {
               Object[] row = new Object[7];
                row[0] = req;
                row[1]=req.getNgoName();
                row[3]=req.getQuantity();
                row[2]=req.getSender();
                row[4] = req.getReqDate();
                row[5]=req.getStatus();
                row[6]=req.getFoodList();
                mdl.addRow(row);
                }
               
           }
            
            
        }
    }
    
    public void autoPopDelivered() {
        DefaultTableModel mdl = (DefaultTableModel)tblMedDelivery.getModel();
        mdl.setRowCount(0);    
        for (Iterator<WorkRequest> wr = org.getWorkQueue().getWrList().iterator(); wr.hasNext();) {
            WorkRequest workRequest = wr.next();
           if(workRequest instanceof VolunteerRestaurantWorkRequest){
               VolunteerRestaurantWorkRequest req = (VolunteerRestaurantWorkRequest) workRequest;
                if(req.getStatus().equalsIgnoreCase("Delivered") )
                {
                Object[] row = new Object[7];
                row[0] = req;
                row[1]=req.getNgoName();
                row[3]=req.getQuantity();
                row[2]=req.getSender();
                row[4] = req.getReqDate();
                row[5]=req.getStatus();
                row[6]=req.getFoodList();
                mdl.addRow(row);
                }
           }
        }
    }
    
    private boolean checkPhoneNumber(String phNo) {
        Pattern pattern = Pattern.compile("^[0-9]{10}$");
        Matcher matcher = pattern.matcher(phNo);
        return matcher.matches();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JM_jLabel26 = new javax.swing.JLabel();
        JM_refreshBtn2 = new javax.swing.JButton();
        JM_jScrollPane6 = new javax.swing.JScrollPane();
        tblMedDelivery = new javax.swing.JTable();
        JM_jScrollPane7 = new javax.swing.JScrollPane();
        txtDeliveryAddress = new javax.swing.JTextArea();
        JM_jLabel24 = new javax.swing.JLabel();
        JM_jLabel12 = new javax.swing.JLabel();
        JM_txtContactNo = new javax.swing.JTextField();
        JM_btnReqDelivery = new javax.swing.JButton();
        JM_jLabel13 = new javax.swing.JLabel();
        JM_jLabel14 = new javax.swing.JLabel();
        JM_cbFilter = new javax.swing.JComboBox();

        setBackground(new java.awt.Color(0, 153, 153));

        JM_jLabel26.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 24)); // NOI18N
        JM_jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        JM_jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JM_jLabel26.setText("New Food Requests");

        JM_refreshBtn2.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 18)); // NOI18N
        JM_refreshBtn2.setForeground(new java.awt.Color(0, 153, 153));
        JM_refreshBtn2.setText("Refresh");
        JM_refreshBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JM_refreshBtn2ActionPerformed(evt);
            }
        });

        tblMedDelivery.setForeground(new java.awt.Color(102, 0, 102));
        tblMedDelivery.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "NGO", "Sender", "Medicine List", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JM_jScrollPane6.setViewportView(tblMedDelivery);

        txtDeliveryAddress.setColumns(20);
        txtDeliveryAddress.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        txtDeliveryAddress.setRows(5);
        JM_jScrollPane7.setViewportView(txtDeliveryAddress);

        JM_jLabel24.setFont(new java.awt.Font(".SF NS Mono", 1, 18)); // NOI18N
        JM_jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        JM_jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        JM_jLabel24.setText("Delivery Address:");

        JM_jLabel12.setFont(new java.awt.Font(".SF NS Mono", 1, 14)); // NOI18N
        JM_jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        JM_jLabel12.setText("Contact Number:");

        JM_txtContactNo.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N

        JM_btnReqDelivery.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        JM_btnReqDelivery.setForeground(new java.awt.Color(0, 153, 153));
        JM_btnReqDelivery.setText("Request Delivery");
        JM_btnReqDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JM_btnReqDeliveryActionPerformed(evt);
            }
        });

        JM_jLabel13.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 16)); // NOI18N
        JM_jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        JM_jLabel13.setText("Filter By: ");

        JM_jLabel14.setFont(new java.awt.Font(".SF NS Mono", 1, 14)); // NOI18N
        JM_jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        JM_jLabel14.setText("Status");

        JM_cbFilter.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        JM_cbFilter.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Requested", "UnRequested", "Delivered"}));
        JM_cbFilter.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JM_cbFilterItemStateChanged(evt);
            }
        });
        JM_cbFilter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JM_cbFilterMouseClicked(evt);
            }
        });
        JM_cbFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JM_cbFilterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JM_jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JM_refreshBtn2)
                .addGap(192, 192, 192))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JM_jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JM_jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(209, 209, 209)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JM_jLabel13)
                                    .addComponent(JM_cbFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JM_jLabel14)))
                            .addComponent(JM_jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(JM_jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(JM_txtContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(402, 402, 402)
                        .addComponent(JM_btnReqDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(342, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(JM_jLabel26)
                        .addGap(18, 18, 18)
                        .addComponent(JM_jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JM_jLabel13)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JM_jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JM_jLabel24)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JM_jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JM_cbFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(JM_refreshBtn2)))
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JM_jLabel12)
                    .addComponent(JM_txtContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addComponent(JM_btnReqDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JM_refreshBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JM_refreshBtn2ActionPerformed
        autoPopDelivery();
        txtDeliveryAddress.setText("");
        JM_txtContactNo.setText("");
    }//GEN-LAST:event_JM_refreshBtn2ActionPerformed

    private void JM_btnReqDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JM_btnReqDeliveryActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblMedDelivery.getSelectedRow();
        if (selectedRow < 0){
            JOptionPane.showConfirmDialog(null, "Please select a row to place an Order.","Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String addr=txtDeliveryAddress.getText();
        if(addr==null || addr.equals("")){
            JOptionPane.showMessageDialog(null,"Please enter Address.");
            return;
        }
        String phNo = JM_txtContactNo.getText();
        if(phNo == null || phNo.equals("")){
            JOptionPane.showMessageDialog(null, "Contact Number is mandatory.");
            return;
        }
        if(!checkPhoneNumber(phNo)){
            JOptionPane.showMessageDialog(null, "Please enter a valid Contact Number.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        VolunteerRestaurantWorkRequest req = (VolunteerRestaurantWorkRequest)tblMedDelivery.getValueAt(selectedRow, 0);

        req.setRecieverAdd(addr);
        req.setRecieverNo(phNo);
        req.setStatus("Delivery Requested");
        JOptionPane.showMessageDialog(null, "The Order is placed successfully. \n Your Order Id is "+req.getId());

        autoPopDelivery();

        Organisation organisation = null;

        for(Enterprise ent: net.getEntDir().getEntList())
        {
            if(ent.getEntType().equals(ent.getEntType().Transpotation))
            {
                for (Organisation orgs : ent.getOrgDir().getOrgList())
                {

                    if (orgs instanceof TransportOrg){
                        organisation = orgs;
                        organisation.getWorkQueue().getWrList().add(req);
                    }
                }
            }
        }
    }//GEN-LAST:event_JM_btnReqDeliveryActionPerformed

    private void JM_cbFilterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JM_cbFilterItemStateChanged
        String fil = (String) JM_cbFilter.getSelectedItem();
        if(fil.equals("All")){
            autoPopDelivery();
        }
        if(fil.equals("Requested")){
            autoPopReq();
        }
        if(fil.equals("UnRequested")){
            autoPopUnReq();
        }
        if(fil.equals("Delivered")){
            autoPopDelivered();
        }
    }//GEN-LAST:event_JM_cbFilterItemStateChanged

    private void JM_cbFilterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JM_cbFilterMouseClicked

    }//GEN-LAST:event_JM_cbFilterMouseClicked

    private void JM_cbFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JM_cbFilterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JM_cbFilterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JM_btnReqDelivery;
    private javax.swing.JComboBox JM_cbFilter;
    private javax.swing.JLabel JM_jLabel12;
    private javax.swing.JLabel JM_jLabel13;
    private javax.swing.JLabel JM_jLabel14;
    private javax.swing.JLabel JM_jLabel24;
    private javax.swing.JLabel JM_jLabel26;
    private javax.swing.JScrollPane JM_jScrollPane6;
    private javax.swing.JScrollPane JM_jScrollPane7;
    private javax.swing.JButton JM_refreshBtn2;
    private javax.swing.JTextField JM_txtContactNo;
    private javax.swing.JTable tblMedDelivery;
    private javax.swing.JTextArea txtDeliveryAddress;
    // End of variables declaration//GEN-END:variables
}
