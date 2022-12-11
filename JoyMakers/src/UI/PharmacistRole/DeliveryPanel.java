/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.PharmacistRole;

import UI.DoctorRole.*;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.DoctorOrg;
import Business.Organization.HealthOrg;
import Business.Organization.Organisation;
import Business.Organization.PharmacyOrg;
import Business.Organization.TransportOrg;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.TutorVolunteerWorkReq;
import Business.WorkQueue.HospitalDoctorWorkReq;
import Business.WorkQueue.HospitalPharmacyWorkReq;
import Business.WorkQueue.LaboratoryTestWorkReq;
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
        DefaultTableModel mdl = (DefaultTableModel)tblMedDelivery.getModel();
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
        DefaultTableModel mdl = (DefaultTableModel)tblMedDelivery.getModel();
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
        DefaultTableModel mdl = (DefaultTableModel)tblMedDelivery.getModel();
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
        DefaultTableModel mdl = (DefaultTableModel)tblMedDelivery.getModel();
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

        jLabel26 = new javax.swing.JLabel();
        refreshBtn2 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblMedDelivery = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtDeliveryAddress = new javax.swing.JTextArea();
        jLabel24 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtContactNo = new javax.swing.JTextField();
        btnReqDelivery = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cbFilter = new javax.swing.JComboBox();
        btnBacks = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 153));

        jLabel26.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("New Medicine Requests");

        refreshBtn2.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 14)); // NOI18N
        refreshBtn2.setForeground(new java.awt.Color(0, 153, 153));
        refreshBtn2.setText("Refresh");
        refreshBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtn2ActionPerformed(evt);
            }
        });

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
        jScrollPane6.setViewportView(tblMedDelivery);

        txtDeliveryAddress.setColumns(20);
        txtDeliveryAddress.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        txtDeliveryAddress.setRows(5);
        jScrollPane7.setViewportView(txtDeliveryAddress);

        jLabel24.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("Delivery Address:");

        jLabel12.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Contact Number:");

        txtContactNo.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N

        btnReqDelivery.setFont(new java.awt.Font("Lucida Grande", 1, 15)); // NOI18N
        btnReqDelivery.setForeground(new java.awt.Color(0, 153, 153));
        btnReqDelivery.setText("Request Delivery");
        btnReqDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReqDeliveryActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Filter By: ");

        jLabel14.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Status");

        cbFilter.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        cbFilter.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Requested", "UnRequested", "Delivered"}));
        cbFilter.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbFilterItemStateChanged(evt);
            }
        });
        cbFilter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbFilterMouseClicked(evt);
            }
        });
        cbFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFilterActionPerformed(evt);
            }
        });

        btnBacks.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 14)); // NOI18N
        btnBacks.setForeground(new java.awt.Color(0, 153, 153));
        btnBacks.setText("<<<Back");
        btnBacks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBacksActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnReqDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(303, 303, 303)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(cbFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(142, 142, 142)
                .addComponent(refreshBtn2)
                .addGap(57, 57, 57))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnBacks)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 894, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(btnBacks))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(refreshBtn2)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jLabel24))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(jLabel13)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(cbFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel12))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(txtContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(59, 59, 59)
                .addComponent(btnReqDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(110, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void refreshBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtn2ActionPerformed
        autoPopDelivery();
        txtDeliveryAddress.setText("");
        txtContactNo.setText("");
    }//GEN-LAST:event_refreshBtn2ActionPerformed

    private void btnReqDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReqDeliveryActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblMedDelivery.getSelectedRow();
        if (selectedRow < 0){
            JOptionPane.showConfirmDialog(null, "Select a row to place an order.","Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String addr=txtDeliveryAddress.getText();
        if(addr==null || addr.equals("")){
            JOptionPane.showMessageDialog(null,"Enter Address");
            return;
        }
        String phNo = txtContactNo.getText();
        if(phNo == null || phNo.equals("")){
            JOptionPane.showMessageDialog(null, "Contact Number field cannot be left empty");
            return;
        }
        if(!checkPhoneNumber(phNo)){
            JOptionPane.showMessageDialog(null, "Invalid Contact Number.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        HospitalPharmacyWorkReq req = (HospitalPharmacyWorkReq)tblMedDelivery.getValueAt(selectedRow, 0);

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
    }//GEN-LAST:event_btnReqDeliveryActionPerformed

    private void cbFilterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbFilterItemStateChanged
        String fil = (String) cbFilter.getSelectedItem();
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
    }//GEN-LAST:event_cbFilterItemStateChanged

    private void cbFilterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbFilterMouseClicked

    }//GEN-LAST:event_cbFilterMouseClicked

    private void cbFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFilterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbFilterActionPerformed

    private void btnBacksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBacksActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBacksActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBacks;
    private javax.swing.JButton btnReqDelivery;
    private javax.swing.JComboBox cbFilter;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JButton refreshBtn2;
    private javax.swing.JTable tblMedDelivery;
    private javax.swing.JTextField txtContactNo;
    private javax.swing.JTextArea txtDeliveryAddress;
    // End of variables declaration//GEN-END:variables
}
