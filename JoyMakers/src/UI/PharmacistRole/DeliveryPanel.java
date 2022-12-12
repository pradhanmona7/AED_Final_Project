/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.PharmacistRole;

import UI.DoctorRole.*;
import Model.EcoSystem;
import Model.Enterprise.Enterprise;
import Model.Network.Network;
import Model.Organization.DoctorOrg;
import Model.Organization.HealthOrg;
import Model.Organization.Organisation;
import Model.Organization.PharmacyOrg;
import Model.Organization.TransportOrg;
import Model.UserAccount.UserAccount;
import Model.WorkQueue.TutorVolunteerWorkReq;
import Model.WorkQueue.HospitalDoctorWorkReq;
import Model.WorkQueue.HospitalPharmacyWorkReq;
import Model.WorkQueue.LaboratoryTestWorkReq;
import Model.WorkQueue.WorkRequest;
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
 * @author DELL
 */
public class DeliveryPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private PharmacyOrg org;
    private Enterprise ent;
    private UserAccount ua;
    private Network net;
    /**
     * Creates new form DeliveryPanel
     */
    public DeliveryPanel(JPanel userProcessContainer, UserAccount acc, PharmacyOrg org,Network net, Enterprise ent) {
                initComponents();
        this.userProcessContainer = userProcessContainer;
        this.org = (PharmacyOrg)org;
        this.ent = ent;
        this.ua = acc;
        this.net=net;
        autoPopDelivery();
    }
    
    public void autoPopDelivery() {
        DefaultTableModel mdl = (DefaultTableModel)JM_tblMedDelivery.getModel();
        mdl.setRowCount(0);    
        for (Iterator<WorkRequest> wr = org.getWorkQueue().getWrList().iterator(); wr.hasNext();) {
            WorkRequest workRequest = wr.next();
           if(workRequest instanceof HospitalPharmacyWorkReq){
               HospitalPharmacyWorkReq req = (HospitalPharmacyWorkReq) workRequest;
                if(req.getStatus().equalsIgnoreCase("Delivery Requested") || req.getStatus().equalsIgnoreCase("Accepted") || req.getStatus().equalsIgnoreCase("Delivered") || req.getStatus().equalsIgnoreCase("Delivery Assigned") )
                {
                    Object[] row = new Object[5];
                    row[0] = req;
                    row[1]=req.getNgo();
                    row[3]=req.getMedList();
                    row[2]=req.getSender();
                    row[4] = req.getStatus();
                    mdl.addRow(row);
                }
               
           }
            
            
        }
    }

    public void autoPopReq() {
        DefaultTableModel mdl = (DefaultTableModel)JM_tblMedDelivery.getModel();
        mdl.setRowCount(0);            
        for (Iterator<WorkRequest> wr = org.getWorkQueue().getWrList().iterator(); wr.hasNext();) {
            WorkRequest workRequest = wr.next();
           if(workRequest instanceof HospitalPharmacyWorkReq){
               HospitalPharmacyWorkReq req = (HospitalPharmacyWorkReq) workRequest;
                if(req.getStatus().equalsIgnoreCase("Delivery Requested") )
                {
                    Object[] row = new Object[5];
                    row[0] = req;
                    row[1]=req.getNgo();
                    row[3]=req.getMedList();
                    row[2]=req.getSender();
                    row[4] = req.getStatus();
                    mdl.addRow(row);
                }
           }
            
            
        }
    }
    
    public void autoPopUnReq() {
        DefaultTableModel mdl = (DefaultTableModel)JM_tblMedDelivery.getModel();
        mdl.setRowCount(0);    
        
        
        for (Iterator<WorkRequest> wr = org.getWorkQueue().getWrList().iterator(); wr.hasNext();) {
            WorkRequest workRequest = wr.next();
           if(workRequest instanceof HospitalPharmacyWorkReq){
               HospitalPharmacyWorkReq req = (HospitalPharmacyWorkReq) workRequest;
                if(req.getStatus().equalsIgnoreCase("Accepted") )
                {
                    Object[] row = new Object[5];
                    row[0] = req;
                    row[1]=req.getNgo();
                    row[3]=req.getMedList();
                    row[2]=req.getSender();
                    row[4] = req.getStatus();
                    mdl.addRow(row);
                }
               
           }
            
            
        }
    }
    
    public void autoPopDelivered() {
        DefaultTableModel mdl = (DefaultTableModel)JM_tblMedDelivery.getModel();
        mdl.setRowCount(0);    
        for (Iterator<WorkRequest> wr = org.getWorkQueue().getWrList().iterator(); wr.hasNext();) {
            WorkRequest workRequest = wr.next();
           if(workRequest instanceof HospitalPharmacyWorkReq){
               HospitalPharmacyWorkReq req = (HospitalPharmacyWorkReq) workRequest;
                if(req.getStatus().equalsIgnoreCase("Delivered") )
                {
                    Object[] row = new Object[5];
                    row[0] = req;
                    row[1]=req.getNgo();
                    row[3]=req.getMedList();
                    row[2]=req.getSender();
                    row[4] = req.getStatus();
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

        JM_jLabel = new javax.swing.JLabel();
        JM_refreshBtn2 = new javax.swing.JButton();
        JM_jScrollPane6 = new javax.swing.JScrollPane();
        JM_tblMedDelivery = new javax.swing.JTable();
        JM_jScrollPane7 = new javax.swing.JScrollPane();
        JM_txtDeliveryAddress = new javax.swing.JTextArea();
        JM_jLabel24 = new javax.swing.JLabel();
        JM_jLabel12 = new javax.swing.JLabel();
        JM_txtContactNo = new javax.swing.JTextField();
        JM_btnReqDelivery = new javax.swing.JButton();
        JM_jLabel13 = new javax.swing.JLabel();
        JM_jLabel14 = new javax.swing.JLabel();
        JM_cbFilter = new javax.swing.JComboBox();
        JM_btnBacks = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 153));

        JM_jLabel.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 24)); // NOI18N
        JM_jLabel.setForeground(new java.awt.Color(255, 255, 255));
        JM_jLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JM_jLabel.setText("New Medicine Requests");

        JM_refreshBtn2.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 14)); // NOI18N
        JM_refreshBtn2.setForeground(new java.awt.Color(0, 153, 153));
        JM_refreshBtn2.setText("Refresh");
        JM_refreshBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JM_refreshBtn2ActionPerformed(evt);
            }
        });

        JM_tblMedDelivery.setModel(new javax.swing.table.DefaultTableModel(
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
        JM_jScrollPane6.setViewportView(JM_tblMedDelivery);

        JM_txtDeliveryAddress.setColumns(20);
        JM_txtDeliveryAddress.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        JM_txtDeliveryAddress.setRows(5);
        JM_jScrollPane7.setViewportView(JM_txtDeliveryAddress);

        JM_jLabel24.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        JM_jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        JM_jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        JM_jLabel24.setText("Delivery Address:");

        JM_jLabel12.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        JM_jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        JM_jLabel12.setText("Contact Number:");

        JM_txtContactNo.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N

        JM_btnReqDelivery.setFont(new java.awt.Font("Lucida Grande", 1, 15)); // NOI18N
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

        JM_jLabel14.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
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

        JM_btnBacks.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 14)); // NOI18N
        JM_btnBacks.setForeground(new java.awt.Color(0, 153, 153));
        JM_btnBacks.setText("<<<Back");
        JM_btnBacks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JM_btnBacksActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JM_jLabel12)
                    .addComponent(JM_jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JM_btnReqDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JM_jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(303, 303, 303)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JM_jLabel13)
                            .addComponent(JM_jLabel14)
                            .addComponent(JM_cbFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(JM_txtContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JM_jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(142, 142, 142)
                .addComponent(JM_refreshBtn2)
                .addGap(57, 57, 57))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(JM_btnBacks)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                .addComponent(JM_jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 894, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JM_jLabel)
                    .addComponent(JM_btnBacks))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JM_refreshBtn2)
                            .addComponent(JM_jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(JM_jLabel24))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(JM_jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(JM_jLabel13)
                        .addGap(30, 30, 30)
                        .addComponent(JM_jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(JM_cbFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(JM_jLabel12))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(JM_txtContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(59, 59, 59)
                .addComponent(JM_btnReqDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(110, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JM_refreshBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JM_refreshBtn2ActionPerformed
        autoPopDelivery();
        JM_txtDeliveryAddress.setText("");
        JM_txtContactNo.setText("");
    }//GEN-LAST:event_JM_refreshBtn2ActionPerformed

    private void JM_btnReqDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JM_btnReqDeliveryActionPerformed
        // TODO add your handling code here:
        int selectedRow = JM_tblMedDelivery.getSelectedRow();
        if (selectedRow < 0){
            JOptionPane.showConfirmDialog(null, "Select a row to place an order.","Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String addr=JM_txtDeliveryAddress.getText();
        if(addr==null || addr.equals("")){
            JOptionPane.showMessageDialog(null,"Enter Address");
            return;
        }
        String phNo = JM_txtContactNo.getText();
        if(phNo == null || phNo.equals("")){
            JOptionPane.showMessageDialog(null, "Contact Number field cannot be left empty");
            return;
        }
        if(!checkPhoneNumber(phNo)){
            JOptionPane.showMessageDialog(null, "Invalid Contact Number.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        HospitalPharmacyWorkReq req = (HospitalPharmacyWorkReq)JM_tblMedDelivery.getValueAt(selectedRow, 0);

        req.setRecieverAdd(addr);
        req.setRecieverNo(phNo);
        req.setStatus("Delivery Requested");
        JOptionPane.showMessageDialog(null, "Order Placed Successfully. \n Order Id for your order is "+req.getId());

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

    private void JM_btnBacksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JM_btnBacksActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_JM_btnBacksActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JM_btnBacks;
    private javax.swing.JButton JM_btnReqDelivery;
    private javax.swing.JComboBox JM_cbFilter;
    private javax.swing.JLabel JM_jLabel;
    private javax.swing.JLabel JM_jLabel12;
    private javax.swing.JLabel JM_jLabel13;
    private javax.swing.JLabel JM_jLabel14;
    private javax.swing.JLabel JM_jLabel24;
    private javax.swing.JScrollPane JM_jScrollPane6;
    private javax.swing.JScrollPane JM_jScrollPane7;
    private javax.swing.JButton JM_refreshBtn2;
    private javax.swing.JTable JM_tblMedDelivery;
    private javax.swing.JTextField JM_txtContactNo;
    private javax.swing.JTextArea JM_txtDeliveryAddress;
    // End of variables declaration//GEN-END:variables
}
