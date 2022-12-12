/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.TransportorRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organisation;
import Business.Organization.TransportOrg;
//import Business.Organization.VolunteerOrg;
import Business.Role.TransportorRole;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.TutorVolunteerWorkReq;
import Business.WorkQueue.HospitalPharmacyWorkReq;
import Business.WorkQueue.VolunteerStorageWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author krishna
 */
public class OrdersPanel extends javax.swing.JPanel {
    private JPanel userProcessContainer;
    private EcoSystem system;
    private UserAccount ua;
    private Enterprise ent;
    private TransportOrg org;
    /**
     * Creates new form OrdersPanel
     */
    public OrdersPanel(JPanel userProcessContainer, UserAccount acc, Organisation org,  EcoSystem system, Enterprise ent) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.ua = acc;
        this.system = system;
        this.ent = ent;
        this.org = (TransportOrg) org;

        autoPopAssignedOrd();

    }
    
    public void autoPopDelOrd(){
        
        DefaultTableModel mdl = (DefaultTableModel)tblDeliveryHistory.getModel();
        
        mdl.setRowCount(0);
        
        SimpleDateFormat fmt = new SimpleDateFormat("dd MMM, yyyy");
        
        for (Iterator<WorkRequest> workReq = ua.getWorkQueue().getWrList().iterator(); workReq.hasNext();) {
            WorkRequest wr = (WorkRequest) workReq.next();
            if(wr instanceof VolunteerStorageWorkRequest){
                VolunteerStorageWorkRequest req = (VolunteerStorageWorkRequest) wr;
                if(req.getStatus().equalsIgnoreCase("Delivered")){
                    Object[] row = new Object[6];
                    row[0] = req;
                    row[1] = req.getSender().getUname();
                    row[2] = req.getReceiver().getUname();
                    Date dt = req.getPickupDate();
                    String pickupDt = fmt.format(dt);
                    row[3] = pickupDt;
                    Date expectedDeliveryDt = req.getExpectedDelivery();
                    String delDt = fmt.format(expectedDeliveryDt);
                    row[4] = delDt;
                    row[5] = req.getStatus();
                    mdl.addRow(row);

                }
            }else{
                HospitalPharmacyWorkReq req = (HospitalPharmacyWorkReq) wr;
                if(req.getStatus().equalsIgnoreCase("Delivered")){                
                    Object[] row = new Object[6];
                    row[0] = req;
                    row[2] = req.getSender().getUname();
                    row[1] = req.getReceiver().getUname();
                    Date pickupDt = req.getPickupDate();
                    String pickDt = fmt.format(pickupDt);
                    row[3] = pickDt;
                    Date expectedDeliveryDt = req.getExpectedDelivery();
                    String deliverDt = fmt.format(expectedDeliveryDt);
                    row[4] = deliverDt;
                    row[5] = req.getStatus();
                    mdl.addRow(row);
                        
                }
            }
        }
    }
    
    public void autoPopDelAssignedOrd(){
        
        DefaultTableModel mdl = (DefaultTableModel)tblDeliveryHistory.getModel();
        
        mdl.setRowCount(0);
        
        SimpleDateFormat fmt = new SimpleDateFormat("dd MMM, yyyy");
        
        for (Iterator<WorkRequest> workReq = ua.getWorkQueue().getWrList().iterator(); workReq.hasNext();) {
            WorkRequest wr = (WorkRequest) workReq.next();
            if(wr instanceof VolunteerStorageWorkRequest){
                VolunteerStorageWorkRequest req = (VolunteerStorageWorkRequest) wr;
                if(req.getStatus().equalsIgnoreCase("Delivery Assigned")){
                    Object[] row = new Object[6];
                    row[0] = req;
                    row[1] = req.getSender().getUname();
                    row[2] = req.getReceiver().getUname();
                    Date dt = req.getPickupDate();
                    String pickupDt = fmt.format(dt);
                    row[3] = pickupDt;
                    Date expectedDeliveryDt = req.getExpectedDelivery();
                    String delDt = fmt.format(expectedDeliveryDt);
                    row[4] = delDt;
                    row[5] = req.getStatus();
                    mdl.addRow(row);

                }
            }else{
                HospitalPharmacyWorkReq req = (HospitalPharmacyWorkReq) wr;
                if(req.getStatus().equalsIgnoreCase("Delivery Assigned")){                
                    Object[] row = new Object[6];
                    row[0] = req;
                    row[2] = req.getSender().getUname();
                    row[1] = req.getReceiver().getUname();
                    Date pickupDt = req.getPickupDate();
                    String pickDt = fmt.format(pickupDt);
                    row[3] = pickDt;
                    Date expectedDeliveryDt = req.getExpectedDelivery();
                    String deliverDt = fmt.format(expectedDeliveryDt);
                    row[4] = deliverDt;
                    row[5] = req.getStatus();
                    mdl.addRow(row);
                        
                }
            }
        }
    }
    
    public void autoPopAssignedOrd(){
  DefaultTableModel mdl = (DefaultTableModel)tblDeliveryHistory.getModel();
        
        mdl.setRowCount(0);
        
        SimpleDateFormat fmt = new SimpleDateFormat("dd MMM, yyyy");
        
        for (Iterator<WorkRequest> workReq = ua.getWorkQueue().getWrList().iterator(); workReq.hasNext();) {
            WorkRequest wr = (WorkRequest) workReq.next();
            if(wr instanceof VolunteerStorageWorkRequest){
                VolunteerStorageWorkRequest req = (VolunteerStorageWorkRequest) wr;
               
                    Object[] row = new Object[6];
                    row[0] = req;
                    row[1] = req.getSender().getUname();
                    row[2] = req.getReceiver().getUname();
                    Date dt = req.getPickupDate();
                    String pickupDt = fmt.format(dt);
                    row[3] = pickupDt;
                    Date expectedDeliveryDt = req.getExpectedDelivery();
                    String delDt = fmt.format(expectedDeliveryDt);
                    row[4] = delDt;
                    row[5] = req.getStatus();
                    mdl.addRow(row);

                
            }else{
                HospitalPharmacyWorkReq req = (HospitalPharmacyWorkReq) wr;
                             
                    Object[] row = new Object[6];
                    row[0] = req;
                    row[2] = req.getSender().getUname();
                    row[1] = req.getReceiver().getUname();
                    Date pickupDt = req.getPickupDate();
                    String pickDt = fmt.format(pickupDt);
                    row[3] = pickDt;
                    Date expectedDeliveryDt = req.getExpectedDelivery();
                    String deliverDt = fmt.format(expectedDeliveryDt);
                    row[4] = deliverDt;
                    row[5] = req.getStatus();
                    mdl.addRow(row);
                        
                
            }
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

        JM_jLabel7 = new javax.swing.JLabel();
        JM_jScrollPane4 = new javax.swing.JScrollPane();
        tblDeliveryHistory = new javax.swing.JTable();
        JM_jLabel13 = new javax.swing.JLabel();
        JM_jLabel14 = new javax.swing.JLabel();
        JM_cbFilter = new javax.swing.JComboBox();
        JM_jLabel11 = new javax.swing.JLabel();
        JM_txtSenderName = new javax.swing.JTextField();
        JM_jLabel6 = new javax.swing.JLabel();
        JM_jScrollPane5 = new javax.swing.JScrollPane();
        txtSenderAdd = new javax.swing.JTextArea();
        JM_jLabel9 = new javax.swing.JLabel();
        JM_txtSenderPhNo = new javax.swing.JTextField();
        JM_jLabel12 = new javax.swing.JLabel();
        JM_txtReceiverPhNo = new javax.swing.JTextField();
        JM_jLabel8 = new javax.swing.JLabel();
        JM_txtReceiverName = new javax.swing.JTextField();
        JM_jLabel10 = new javax.swing.JLabel();
        JM_jScrollPane6 = new javax.swing.JScrollPane();
        txtReceiverAddr = new javax.swing.JTextArea();
        JM_btnBack = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 153));

        JM_jLabel7.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 24)); // NOI18N
        JM_jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        JM_jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JM_jLabel7.setText("Delivery Order History");

        tblDeliveryHistory.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 13)); // NOI18N
        tblDeliveryHistory.setForeground(new java.awt.Color(102, 0, 102));
        tblDeliveryHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Sender", "Reciever", "PickUp Date", "Delivery Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDeliveryHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDeliveryHistoryMouseClicked(evt);
            }
        });
        JM_jScrollPane4.setViewportView(tblDeliveryHistory);

        JM_jLabel13.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 16)); // NOI18N
        JM_jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        JM_jLabel13.setText("Filter By: ");

        JM_jLabel14.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        JM_jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        JM_jLabel14.setText("Status");

        JM_cbFilter.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        JM_cbFilter.setForeground(new java.awt.Color(102, 0, 102));
        JM_cbFilter.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Undelivered", "Delivered"}));
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

        JM_jLabel11.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        JM_jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        JM_jLabel11.setText("Sender");

        JM_txtSenderName.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        JM_txtSenderName.setForeground(new java.awt.Color(102, 0, 102));

        JM_jLabel6.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        JM_jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        JM_jLabel6.setText("Sender Address");

        txtSenderAdd.setColumns(20);
        txtSenderAdd.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        txtSenderAdd.setForeground(new java.awt.Color(102, 0, 102));
        txtSenderAdd.setRows(5);
        JM_jScrollPane5.setViewportView(txtSenderAdd);

        JM_jLabel9.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        JM_jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        JM_jLabel9.setText("Sender Contact");

        JM_txtSenderPhNo.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        JM_txtSenderPhNo.setForeground(new java.awt.Color(102, 0, 102));

        JM_jLabel12.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        JM_jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        JM_jLabel12.setText("Reciever ");

        JM_txtReceiverPhNo.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        JM_txtReceiverPhNo.setForeground(new java.awt.Color(102, 0, 102));

        JM_jLabel8.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        JM_jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        JM_jLabel8.setText("Reciever Address ");

        JM_txtReceiverName.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        JM_txtReceiverName.setForeground(new java.awt.Color(102, 0, 102));

        JM_jLabel10.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        JM_jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        JM_jLabel10.setText("Reciever Contact ");

        txtReceiverAddr.setColumns(20);
        txtReceiverAddr.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        txtReceiverAddr.setForeground(new java.awt.Color(102, 0, 102));
        txtReceiverAddr.setRows(5);
        JM_jScrollPane6.setViewportView(txtReceiverAddr);

        JM_btnBack.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        JM_btnBack.setForeground(new java.awt.Color(0, 153, 153));
        JM_btnBack.setText("<<<Back");
        JM_btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JM_btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(291, 291, 291)
                        .addComponent(JM_jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JM_btnBack)
                                .addGap(751, 751, 751)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JM_jLabel14)
                                    .addComponent(JM_jLabel13)
                                    .addComponent(JM_cbFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(JM_jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JM_jLabel9)
                                    .addComponent(JM_jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JM_jLabel6)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(JM_txtSenderPhNo, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(306, 306, 306)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JM_jLabel8)
                                    .addComponent(JM_jLabel10)
                                    .addComponent(JM_jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JM_txtReceiverPhNo, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JM_jLabel12)
                                    .addComponent(JM_txtReceiverName, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(JM_txtSenderName, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JM_jLabel11))))
                .addContainerGap(374, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(JM_jLabel7)
                        .addGap(88, 88, 88)
                        .addComponent(JM_jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JM_jLabel14)
                        .addGap(26, 26, 26)
                        .addComponent(JM_cbFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(198, 198, 198))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(124, Short.MAX_VALUE)
                        .addComponent(JM_btnBack)
                        .addGap(18, 18, 18)
                        .addComponent(JM_jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(124, 124, 124)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JM_jLabel11)
                    .addComponent(JM_jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JM_txtReceiverName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JM_txtSenderName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JM_jLabel6)
                            .addComponent(JM_jLabel8))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JM_jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JM_jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JM_jLabel10)
                    .addComponent(JM_jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JM_txtReceiverPhNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JM_txtSenderPhNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(117, 117, 117))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblDeliveryHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDeliveryHistoryMouseClicked
        int selectedRow = tblDeliveryHistory.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showConfirmDialog(null, "Please select a row from table to view details.!","Warning", JOptionPane.WARNING_MESSAGE);
        }
        else{

            WorkRequest workReq = (WorkRequest) tblDeliveryHistory.getValueAt(selectedRow, 0);
            if(workReq instanceof VolunteerStorageWorkRequest){
                VolunteerStorageWorkRequest wr = (VolunteerStorageWorkRequest) workReq;
                txtReceiverAddr.setText(wr.getRecieverAddress());
                JM_txtReceiverPhNo.setText(wr.getReceiver().getUname());
                JM_txtReceiverPhNo.setText(wr.getRecieverNumber());
                txtSenderAdd.setText(wr.getSenderAddress());
                JM_txtSenderName.setText(wr.getSender().getUname());
                JM_txtSenderPhNo.setText(wr.getSenderNumber());
            }else{
                HospitalPharmacyWorkReq wr = (HospitalPharmacyWorkReq) workReq;
                txtSenderAdd.setText(wr.getRecieverAdd());
                JM_txtSenderName.setText(wr.getReceiver().getUname());
                JM_txtSenderPhNo.setText(wr.getRecieverNo());
                txtReceiverAddr.setText(wr.getSenderAdd());
                JM_txtReceiverPhNo.setText(wr.getSender().getUname());
                JM_txtReceiverPhNo.setText(wr.getSenderNo());
            }

        }
    }//GEN-LAST:event_tblDeliveryHistoryMouseClicked

    private void JM_cbFilterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JM_cbFilterItemStateChanged
        String fil = (String) JM_cbFilter.getSelectedItem();

        if(fil.equals("All")){
            autoPopAssignedOrd();
        }
        if(fil.equals("Undelivered")){
            autoPopDelAssignedOrd();
        }
        if(fil.equals("Delivered")){
            autoPopDelOrd();
        }

    }//GEN-LAST:event_JM_cbFilterItemStateChanged

    private void JM_cbFilterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JM_cbFilterMouseClicked

    }//GEN-LAST:event_JM_cbFilterMouseClicked

    private void JM_cbFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JM_cbFilterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JM_cbFilterActionPerformed

    private void JM_btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JM_btnBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);        // TODO add your handling code here:
    }//GEN-LAST:event_JM_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JM_btnBack;
    private javax.swing.JComboBox JM_cbFilter;
    private javax.swing.JLabel JM_jLabel10;
    private javax.swing.JLabel JM_jLabel11;
    private javax.swing.JLabel JM_jLabel12;
    private javax.swing.JLabel JM_jLabel13;
    private javax.swing.JLabel JM_jLabel14;
    private javax.swing.JLabel JM_jLabel6;
    private javax.swing.JLabel JM_jLabel7;
    private javax.swing.JLabel JM_jLabel8;
    private javax.swing.JLabel JM_jLabel9;
    private javax.swing.JScrollPane JM_jScrollPane4;
    private javax.swing.JScrollPane JM_jScrollPane5;
    private javax.swing.JScrollPane JM_jScrollPane6;
    private javax.swing.JTextField JM_txtReceiverName;
    private javax.swing.JTextField JM_txtReceiverPhNo;
    private javax.swing.JTextField JM_txtSenderName;
    private javax.swing.JTextField JM_txtSenderPhNo;
    private javax.swing.JTable tblDeliveryHistory;
    private javax.swing.JTextArea txtReceiverAddr;
    private javax.swing.JTextArea txtSenderAdd;
    // End of variables declaration//GEN-END:variables
}
