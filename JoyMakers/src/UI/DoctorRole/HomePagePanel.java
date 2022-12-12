/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.DoctorRole;

import Model.Enterprise.Enterprise;
import Model.Network.Network;
import Model.Organization.DoctorOrg;
import Model.Organization.HealthOrg;
import Model.UserAccount.UserAccount;
import Model.WorkQueue.TutorVolunteerWorkReq;
import Model.WorkQueue.HospitalDoctorWorkReq;
import Model.WorkQueue.LaboratoryTestWorkReq;
import Model.WorkQueue.WorkRequest;
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
public class HomePagePanel extends javax.swing.JPanel {

    /**
     * Creates new form HomePagePanel
     */
    private JPanel userProcessContainer;
    private DoctorOrg docOrg;
    private Enterprise ent;
    private UserAccount ua;
    private Network net;
    
    public HomePagePanel(JPanel userProcessContainer, UserAccount acc, DoctorOrg org,Network net, Enterprise ent) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.docOrg = (DoctorOrg)org;
        this.ent = ent;
        this.ua = acc;
        this.net = net;
        
        autoPopAssignedtbl();
    }
    
    public void autoPopAssignedtbl() {
        DefaultTableModel mdl = (DefaultTableModel)JM_tblAssignTable.getModel();
        mdl.setRowCount(0);   
        
        SimpleDateFormat datefmt = new SimpleDateFormat("dd MMM, yyyy");
        
        for (Iterator<WorkRequest> wr = ua.getWorkQueue().getWrList().iterator(); wr.hasNext();) {
            HospitalDoctorWorkReq req = (HospitalDoctorWorkReq) wr.next();
            Object[] row = new Object[8];
            row[0] = req;
            row[1]=req.getNoOfPatients();
            row[2]=req.getCaseType();
            row[3]=req.getPatientType();
            row[4]=req.getSender();
            Date dt = req.getDate();
            if(dt==null)
            { 
                 row[5]=dt;
            }
            else
            {
                 row[5]=datefmt.format(dt);
            }
            row[6]=req.getTime();
            row[7]=req.getStatus();
            mdl.addRow(row);
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

        JM_lbltitle = new javax.swing.JLabel();
        JM_btnBack = new javax.swing.JButton();
        JM_jScrollPane1 = new javax.swing.JScrollPane();
        JM_tblAssignTable = new javax.swing.JTable();
        JM_btnViewMessage = new javax.swing.JButton();
        JM_btnProcess = new javax.swing.JButton();
        JM_btnRefresh = new javax.swing.JButton();
        JM_jScrollPane3 = new javax.swing.JScrollPane();
        JM_txtMessage = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(0, 153, 153));
        setForeground(new java.awt.Color(102, 0, 102));

        JM_lbltitle.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 24)); // NOI18N
        JM_lbltitle.setForeground(new java.awt.Color(0, 153, 153));
        JM_lbltitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JM_lbltitle.setText("MANAGE ENTERPRISE ADMIN WORKAREA");

        JM_btnBack.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 18)); // NOI18N
        JM_btnBack.setForeground(new java.awt.Color(0, 153, 153));
        JM_btnBack.setText("<< Back");
        JM_btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JM_btnBackActionPerformed(evt);
            }
        });

        JM_tblAssignTable.setBackground(new java.awt.Color(204, 204, 204));
        JM_tblAssignTable.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 13)); // NOI18N
        JM_tblAssignTable.setForeground(new java.awt.Color(102, 0, 102));
        JM_tblAssignTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Doctor Type", "Total Patients", "Case", "Patient Type", "Sender", "Date", "Time", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JM_jScrollPane1.setViewportView(JM_tblAssignTable);

        JM_btnViewMessage.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 18)); // NOI18N
        JM_btnViewMessage.setForeground(new java.awt.Color(0, 153, 153));
        JM_btnViewMessage.setText("View Message");
        JM_btnViewMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JM_btnViewMessageActionPerformed(evt);
            }
        });

        JM_btnProcess.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 18)); // NOI18N
        JM_btnProcess.setForeground(new java.awt.Color(0, 153, 153));
        JM_btnProcess.setText("Process");
        JM_btnProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JM_btnProcessActionPerformed(evt);
            }
        });

        JM_btnRefresh.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 18)); // NOI18N
        JM_btnRefresh.setForeground(new java.awt.Color(0, 153, 153));
        JM_btnRefresh.setText("Refresh");
        JM_btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JM_btnRefreshActionPerformed(evt);
            }
        });

        JM_txtMessage.setBackground(new java.awt.Color(204, 204, 255));
        JM_txtMessage.setColumns(20);
        JM_txtMessage.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        JM_txtMessage.setForeground(new java.awt.Color(102, 0, 102));
        JM_txtMessage.setRows(5);
        JM_jScrollPane3.setViewportView(JM_txtMessage);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addComponent(JM_btnBack)
                .addGap(18, 18, 18)
                .addComponent(JM_btnProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(253, 253, 253)
                        .addComponent(JM_btnRefresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JM_lbltitle, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(JM_jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(JM_btnViewMessage))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(JM_jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JM_lbltitle, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JM_btnRefresh)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JM_jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(JM_btnViewMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(JM_jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JM_btnProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JM_btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(423, 423, 423))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JM_btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JM_btnBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_JM_btnBackActionPerformed

    private void JM_btnViewMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JM_btnViewMessageActionPerformed
        // TODO add your handling code here:
       int selectedRow = JM_tblAssignTable.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Make row selection");
            return;
        }
        HospitalDoctorWorkReq req = (HospitalDoctorWorkReq)JM_tblAssignTable.getValueAt(selectedRow, 0);
        JM_txtMessage.setText(req.getMessage());
        JM_txtMessage.setEditable(false);
    }//GEN-LAST:event_JM_btnViewMessageActionPerformed

    private void JM_btnProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JM_btnProcessActionPerformed

        int selectedRow = JM_tblAssignTable.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Make row selection");
            return;
        }

        HospitalDoctorWorkReq req = (HospitalDoctorWorkReq)JM_tblAssignTable.getValueAt(selectedRow, 0);
        if(!req.getStatus().equalsIgnoreCase("completed"))
        {
            req.setStatus("Processing");
        }

        ProcessPanel processPanel = new ProcessPanel(userProcessContainer,ua, req);
        userProcessContainer.add("processPanel", processPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);

    }//GEN-LAST:event_JM_btnProcessActionPerformed

    private void JM_btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JM_btnRefreshActionPerformed
        autoPopAssignedtbl();
        JM_txtMessage.setText("");

    }//GEN-LAST:event_JM_btnRefreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JM_btnBack;
    private javax.swing.JButton JM_btnProcess;
    private javax.swing.JButton JM_btnRefresh;
    private javax.swing.JButton JM_btnViewMessage;
    private javax.swing.JScrollPane JM_jScrollPane1;
    private javax.swing.JScrollPane JM_jScrollPane3;
    private javax.swing.JLabel JM_lbltitle;
    private javax.swing.JTable JM_tblAssignTable;
    private javax.swing.JTextArea JM_txtMessage;
    // End of variables declaration//GEN-END:variables
}
