/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.DoctorRole;

import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.DoctorOrg;
import Business.Organization.HealthOrg;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.TutorVolunteerWorkReq;
import Business.WorkQueue.HospitalDoctorWorkReq;
import Business.WorkQueue.LaboratoryTestWorkReq;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author monalikapradhan
 */
public class NewCasePanel extends javax.swing.JPanel {

    /**
     * Creates new form NewCasePanel
     */
    private JPanel userProcessContainer;
    private DoctorOrg docOrg;
    private Enterprise ent;
    private UserAccount ua;
    private Network net;
    

    public NewCasePanel(JPanel userProcessContainer, UserAccount acc, DoctorOrg org,Network net, Enterprise ent) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.docOrg = (DoctorOrg)org;
        this.ent = ent;
        this.ua = acc;
        this.net = net;
        
        autoPopNewReqtbl(); 

    }
    
    public void autoPopNewReqtbl() {
        DefaultTableModel mdl = (DefaultTableModel)tblNewReq.getModel();
        mdl.setRowCount(0);    
        
        for (Iterator<WorkRequest> wr = docOrg.getWorkQueue().getWrList().iterator(); wr.hasNext();) {
            HospitalDoctorWorkReq req = (HospitalDoctorWorkReq) wr.next();
            if(req.getStatus().equalsIgnoreCase("sent"))
            {
                Object[] row = new Object[5];
                row[0] = req;
                row[1]=req.getNoOfPatients();
                row[2]=req.getCaseType();
                row[3]=req.getPatientType();
                row[4]=req.getSender();
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

        jScrollPane2 = new javax.swing.JScrollPane();
        tblNewReq = new javax.swing.JTable();
        btnRefresh = new javax.swing.JButton();
        lbltitle = new javax.swing.JLabel();
        btnMessage = new javax.swing.JButton();
        btnAssignToMe = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtMessage = new javax.swing.JTextArea();
        btnBack = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(102, 0, 102));

        tblNewReq.setBackground(new java.awt.Color(204, 204, 204));
        tblNewReq.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 13)); // NOI18N
        tblNewReq.setForeground(new java.awt.Color(102, 0, 102));
        tblNewReq.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Doctor Type", "Total Patients", "Case", "Patient Type", "Sender"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane2.setViewportView(tblNewReq);

        btnRefresh.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        btnRefresh.setForeground(new java.awt.Color(102, 0, 102));
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        lbltitle.setBackground(new java.awt.Color(255, 255, 255));
        lbltitle.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 24)); // NOI18N
        lbltitle.setForeground(new java.awt.Color(102, 0, 102));
        lbltitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbltitle.setText("New Doctor Cases");

        btnMessage.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        btnMessage.setForeground(new java.awt.Color(102, 0, 102));
        btnMessage.setText("View Message");
        btnMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMessageActionPerformed(evt);
            }
        });

        btnAssignToMe.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        btnAssignToMe.setForeground(new java.awt.Color(102, 0, 102));
        btnAssignToMe.setText("Assign to me");
        btnAssignToMe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignToMeActionPerformed(evt);
            }
        });

        txtMessage.setBackground(new java.awt.Color(204, 204, 204));
        txtMessage.setColumns(20);
        txtMessage.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        txtMessage.setForeground(new java.awt.Color(102, 0, 102));
        txtMessage.setRows(5);
        jScrollPane4.setViewportView(txtMessage);

        btnBack.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        btnBack.setForeground(new java.awt.Color(102, 0, 102));
        btnBack.setText("<< Back");
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
                .addContainerGap()
                .addComponent(btnBack)
                .addGap(246, 246, 246)
                .addComponent(lbltitle, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                .addComponent(btnRefresh)
                .addGap(32, 32, 32))
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMessage, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(83, 83, 83))
            .addGroup(layout.createSequentialGroup()
                .addGap(239, 239, 239)
                .addComponent(btnAssignToMe)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBack)
                            .addComponent(lbltitle)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(btnRefresh)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(btnAssignToMe, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(169, 169, 169))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        autoPopNewReqtbl();
        txtMessage.setText("");
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMessageActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblNewReq.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Make row selection");
            return;
        }
        HospitalDoctorWorkReq req = (HospitalDoctorWorkReq)tblNewReq.getValueAt(selectedRow, 0);
        txtMessage.setText(req.getMessage());
        txtMessage.setEditable(false);

    }//GEN-LAST:event_btnMessageActionPerformed

    private void btnAssignToMeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignToMeActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblNewReq.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Make row selection");
            return;
        }

        HospitalDoctorWorkReq req = (HospitalDoctorWorkReq)tblNewReq.getValueAt(selectedRow, 0);
        req.setReceiver(ua);
        req.setStatus("Accepted");

        ua.getWorkQueue().getWrList().add(req);
        
        JOptionPane.showMessageDialog(null, "Successfully assigned doctor request.");
        
        autoPopNewReqtbl();
    }//GEN-LAST:event_btnAssignToMeActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssignToMe;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnMessage;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbltitle;
    private javax.swing.JTable tblNewReq;
    private javax.swing.JTextArea txtMessage;
    // End of variables declaration//GEN-END:variables
}
