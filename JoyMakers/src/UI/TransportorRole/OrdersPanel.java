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

        jLabel7 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDeliveryHistory = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cbFilter = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        txtSenderName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtSenderAdd = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        txtSenderPhNo = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtReceiverPhNo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtReceiverName = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtReceiverAddr = new javax.swing.JTextArea();
        btnBack = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 153));

        jLabel7.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Delivery Order History");

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
        jScrollPane4.setViewportView(tblDeliveryHistory);

        jLabel13.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Filter By: ");

        jLabel14.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Status");

        cbFilter.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        cbFilter.setForeground(new java.awt.Color(102, 0, 102));
        cbFilter.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Undelivered", "Delivered"}));
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

        jLabel11.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Sender");

        txtSenderName.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        txtSenderName.setForeground(new java.awt.Color(102, 0, 102));

        jLabel6.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Sender Address");

        txtSenderAdd.setColumns(20);
        txtSenderAdd.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        txtSenderAdd.setForeground(new java.awt.Color(102, 0, 102));
        txtSenderAdd.setRows(5);
        jScrollPane5.setViewportView(txtSenderAdd);

        jLabel9.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Sender Contact");

        txtSenderPhNo.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        txtSenderPhNo.setForeground(new java.awt.Color(102, 0, 102));

        jLabel12.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Reciever ");

        txtReceiverPhNo.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        txtReceiverPhNo.setForeground(new java.awt.Color(102, 0, 102));

        jLabel8.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Reciever Address ");

        txtReceiverName.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        txtReceiverName.setForeground(new java.awt.Color(102, 0, 102));

        jLabel10.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Reciever Contact ");

        txtReceiverAddr.setColumns(20);
        txtReceiverAddr.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        txtReceiverAddr.setForeground(new java.awt.Color(102, 0, 102));
        txtReceiverAddr.setRows(5);
        jScrollPane6.setViewportView(txtReceiverAddr);

        btnBack.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        btnBack.setForeground(new java.awt.Color(0, 153, 153));
        btnBack.setText("<<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
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
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBack)
                                .addGap(751, 751, 751)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel13)
                                    .addComponent(cbFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(txtSenderPhNo, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(306, 306, 306)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtReceiverPhNo, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12)
                                    .addComponent(txtReceiverName, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtSenderName, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))))
                .addContainerGap(374, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel7)
                        .addGap(88, 88, 88)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addGap(26, 26, 26)
                        .addComponent(cbFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(198, 198, 198))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(124, Short.MAX_VALUE)
                        .addComponent(btnBack)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(124, 124, 124)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtReceiverName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSenderName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtReceiverPhNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSenderPhNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                txtReceiverPhNo.setText(wr.getReceiver().getUname());
                txtReceiverPhNo.setText(wr.getRecieverNumber());
                txtSenderAdd.setText(wr.getSenderAddress());
                txtSenderName.setText(wr.getSender().getUname());
                txtSenderPhNo.setText(wr.getSenderNumber());
            }else{
                HospitalPharmacyWorkReq wr = (HospitalPharmacyWorkReq) workReq;
                txtSenderAdd.setText(wr.getRecieverAdd());
                txtSenderName.setText(wr.getReceiver().getUname());
                txtSenderPhNo.setText(wr.getRecieverNo());
                txtReceiverAddr.setText(wr.getSenderAdd());
                txtReceiverPhNo.setText(wr.getSender().getUname());
                txtReceiverPhNo.setText(wr.getSenderNo());
            }

        }
    }//GEN-LAST:event_tblDeliveryHistoryMouseClicked

    private void cbFilterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbFilterItemStateChanged
        String fil = (String) cbFilter.getSelectedItem();

        if(fil.equals("All")){
            autoPopAssignedOrd();
        }
        if(fil.equals("Undelivered")){
            autoPopDelAssignedOrd();
        }
        if(fil.equals("Delivered")){
            autoPopDelOrd();
        }

    }//GEN-LAST:event_cbFilterItemStateChanged

    private void cbFilterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbFilterMouseClicked

    }//GEN-LAST:event_cbFilterMouseClicked

    private void cbFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFilterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbFilterActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);        // TODO add your handling code here:
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JComboBox cbFilter;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable tblDeliveryHistory;
    private javax.swing.JTextArea txtReceiverAddr;
    private javax.swing.JTextField txtReceiverName;
    private javax.swing.JTextField txtReceiverPhNo;
    private javax.swing.JTextArea txtSenderAdd;
    private javax.swing.JTextField txtSenderName;
    private javax.swing.JTextField txtSenderPhNo;
    // End of variables declaration//GEN-END:variables
}
