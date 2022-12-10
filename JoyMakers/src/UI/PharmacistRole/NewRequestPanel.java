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
 * @author Mrinalini
 */
public class NewRequestPanel extends javax.swing.JPanel {
    private JPanel userProcessContainer;
    private PharmacyOrg org;
    private Enterprise ent;
    private UserAccount ua;
    private Network net;
    /**
     * Creates new form NewRequestPanel
     */
    public NewRequestPanel(JPanel userProcessContainer, UserAccount acc, PharmacyOrg org,Network net, Enterprise ent) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.org = (PharmacyOrg)org;
        this.ent = ent;
        this.ua = acc;
        this.net=net;
        autoPopMedList();
    }
    
    public void autoPopMedList() {
        DefaultTableModel mdl = (DefaultTableModel)tblMedList.getModel();
        mdl.setRowCount(0);    
        SimpleDateFormat fmt = new SimpleDateFormat("dd MMM, yyyy");
        
        for (Iterator<WorkRequest> wr = org.getWorkQueue().getWrList().iterator(); wr.hasNext();) {
            WorkRequest workRequest = wr.next();
           if(workRequest instanceof HospitalPharmacyWorkReq){
               HospitalPharmacyWorkReq req = (HospitalPharmacyWorkReq) workRequest;
                if(req.getStatus().equalsIgnoreCase("sent"))
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel25 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblMedList = new javax.swing.JTable();
        btnAssignToMe = new javax.swing.JButton();
        btnViewMedList = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtMessage = new javax.swing.JTextArea();
        btnRefresh = new javax.swing.JButton();

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(102, 0, 102));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("New Medicine Requests");

        btnBack.setBackground(new java.awt.Color(255, 255, 255));
        btnBack.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        btnBack.setForeground(new java.awt.Color(102, 0, 102));
        btnBack.setText("<<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jScrollPane5.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane5.setForeground(new java.awt.Color(102, 0, 102));

        tblMedList.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(tblMedList);

        btnAssignToMe.setBackground(new java.awt.Color(255, 255, 255));
        btnAssignToMe.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        btnAssignToMe.setForeground(new java.awt.Color(102, 0, 102));
        btnAssignToMe.setText("Assign to me");
        btnAssignToMe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignToMeActionPerformed(evt);
            }
        });

        btnViewMedList.setBackground(new java.awt.Color(255, 255, 255));
        btnViewMedList.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        btnViewMedList.setForeground(new java.awt.Color(102, 0, 102));
        btnViewMedList.setText("View Medicine List");
        btnViewMedList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewMedListActionPerformed(evt);
            }
        });

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane4.setForeground(new java.awt.Color(102, 0, 102));

        txtMessage.setColumns(20);
        txtMessage.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        txtMessage.setRows(5);
        jScrollPane4.setViewportView(txtMessage);

        btnRefresh.setBackground(new java.awt.Color(255, 255, 255));
        btnRefresh.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        btnRefresh.setForeground(new java.awt.Color(102, 0, 102));
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnAssignToMe)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnViewMedList))
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(239, 239, 239))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 1091, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(930, Short.MAX_VALUE)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(95, 95, 95)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBack)
                .addGap(16, 16, 16)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAssignToMe, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewMedList, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(139, 139, 139)
                    .addComponent(btnRefresh)
                    .addContainerGap(573, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnAssignToMeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignToMeActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblMedList.getSelectedRow();
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Make row selection");
            return;
        }
        HospitalPharmacyWorkReq req = (HospitalPharmacyWorkReq)tblMedList.getValueAt(selectedRow, 0);
        req.setReceiver(ua);
        req.setStatus("Assigned");
        ua.getWorkQueue().getWrList().add(req);
        JOptionPane.showMessageDialog(null, "Successful assignment of medical request ");
        autoPopMedList();
    }//GEN-LAST:event_btnAssignToMeActionPerformed

    private void btnViewMedListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewMedListActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblMedList.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Make row selection");
            return;
        }
        HospitalPharmacyWorkReq req = (HospitalPharmacyWorkReq)tblMedList.getValueAt(selectedRow, 0);
        txtMessage.setText(req.getMedList()+"");
        txtMessage.setEditable(false);

    }//GEN-LAST:event_btnViewMedListActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        autoPopMedList(); 
        txtMessage.setText("");
    }//GEN-LAST:event_btnRefreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssignToMe;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnViewMedList;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tblMedList;
    private javax.swing.JTextArea txtMessage;
    // End of variables declaration//GEN-END:variables
}