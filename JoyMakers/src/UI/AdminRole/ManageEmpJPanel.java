/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.AdminRole;

import Model.Employee.Employee;
import Model.Organization.Organisation;
import Model.Organization.OrganisationDirectory;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author monalikapradhan
 */
public class ManageEmpJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageEmpJPanel
     */
    private OrganisationDirectory orgDir;
    private JPanel userProcessContainer;
    
    public ManageEmpJPanel(JPanel userProcessContainer,OrganisationDirectory orgDir) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.orgDir = orgDir;
        
        autoPopOrgCB();
        autoPopOrgEmpCB();
    }
    public void autoPopOrgCB(){
        JM_orgcombo.removeAllItems();
        for (Organisation org : orgDir.getOrgList()){
            JM_orgcombo.addItem(org);
        }
    }
    public void autoPopOrgEmpCB(){
        JM_CbOrg.removeAllItems();
        for (Organisation org : orgDir.getOrgList()){
            JM_CbOrg.addItem(org);
        }
    }
    private void autoPoptbl(Organisation org){
        DefaultTableModel mdl = (DefaultTableModel) JM_OrgTbl.getModel();
        mdl.setRowCount(0);
        for (Employee emp : org.getEmpDir().getEmpList()){
            Object[] row = new Object[2];
            row[0] = emp.getId();
            row[1] = emp.getName();
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

        JM_jPanel1 = new javax.swing.JPanel();
        JM_jScrollPane1 = new javax.swing.JScrollPane();
        JM_OrgTbl = new javax.swing.JTable();
        JM_btncreate = new javax.swing.JButton();
        JM_orgcombo = new javax.swing.JComboBox();
        JM_lblOrganisation = new javax.swing.JLabel();
        JM_btnback = new javax.swing.JButton();
        JM_LblName = new javax.swing.JLabel();
        JM_txtName = new javax.swing.JTextField();
        JM_CbOrg = new javax.swing.JComboBox();
        JM_LblOrg = new javax.swing.JLabel();
        JM_lbltitle = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(51, 0, 51));

        JM_jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        JM_jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        JM_OrgTbl.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 13)); // NOI18N
        JM_OrgTbl.setForeground(new java.awt.Color(102, 0, 102));
        JM_OrgTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JM_jScrollPane1.setViewportView(JM_OrgTbl);

        JM_btncreate.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 14)); // NOI18N
        JM_btncreate.setForeground(new java.awt.Color(0, 153, 153));
        JM_btncreate.setText("Create Employee");
        JM_btncreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JM_btncreateActionPerformed(evt);
            }
        });

        JM_orgcombo.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        JM_orgcombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        JM_orgcombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JM_orgcomboActionPerformed(evt);
            }
        });

        JM_lblOrganisation.setBackground(new java.awt.Color(255, 255, 255));
        JM_lblOrganisation.setFont(new java.awt.Font(".SF NS Mono", 1, 14)); // NOI18N
        JM_lblOrganisation.setForeground(new java.awt.Color(255, 255, 255));
        JM_lblOrganisation.setText("Organization");

        JM_btnback.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 14)); // NOI18N
        JM_btnback.setForeground(new java.awt.Color(0, 153, 153));
        JM_btnback.setText("<< Back");
        JM_btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JM_btnbackActionPerformed(evt);
            }
        });

        JM_LblName.setBackground(new java.awt.Color(255, 255, 255));
        JM_LblName.setFont(new java.awt.Font(".SF NS Mono", 1, 14)); // NOI18N
        JM_LblName.setForeground(new java.awt.Color(255, 255, 255));
        JM_LblName.setText("Name:");

        JM_txtName.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        JM_txtName.setForeground(new java.awt.Color(102, 0, 102));

        JM_CbOrg.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        JM_CbOrg.setForeground(new java.awt.Color(0, 153, 153));
        JM_CbOrg.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        JM_LblOrg.setBackground(new java.awt.Color(255, 255, 255));
        JM_LblOrg.setFont(new java.awt.Font(".SF NS Mono", 1, 14)); // NOI18N
        JM_LblOrg.setForeground(new java.awt.Color(255, 255, 255));
        JM_LblOrg.setText("Organization:");

        JM_lbltitle.setBackground(new java.awt.Color(180, 195, 195));
        JM_lbltitle.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 24)); // NOI18N
        JM_lbltitle.setForeground(new java.awt.Color(255, 255, 255));
        JM_lbltitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JM_lbltitle.setText("MANAGE EMPLOYEE WORKAREA");

        javax.swing.GroupLayout JM_jPanel1Layout = new javax.swing.GroupLayout(JM_jPanel1);
        JM_jPanel1.setLayout(JM_jPanel1Layout);
        JM_jPanel1Layout.setHorizontalGroup(
            JM_jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JM_jPanel1Layout.createSequentialGroup()
                .addGroup(JM_jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JM_jPanel1Layout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addComponent(JM_lbltitle, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JM_jPanel1Layout.createSequentialGroup()
                        .addGap(514, 514, 514)
                        .addComponent(JM_lblOrganisation)
                        .addGap(18, 18, 18)
                        .addComponent(JM_orgcombo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JM_jPanel1Layout.createSequentialGroup()
                        .addGroup(JM_jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JM_jPanel1Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(JM_jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(JM_LblOrg)
                                    .addComponent(JM_LblName))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(JM_jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JM_txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JM_CbOrg, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JM_jPanel1Layout.createSequentialGroup()
                                .addComponent(JM_btncreate, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)))
                        .addComponent(JM_jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JM_jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(JM_btnback, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(252, 512, Short.MAX_VALUE))
        );
        JM_jPanel1Layout.setVerticalGroup(
            JM_jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JM_jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JM_lbltitle, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(JM_jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JM_orgcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JM_lblOrganisation, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(JM_jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JM_jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(JM_jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JM_LblOrg)
                            .addComponent(JM_CbOrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(JM_jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JM_txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JM_LblName))
                        .addGap(47, 47, 47)
                        .addComponent(JM_btncreate, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JM_jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(JM_jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                .addComponent(JM_btnback, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(JM_jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(JM_jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(94, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JM_btncreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JM_btncreateActionPerformed

        Organisation org = (Organisation) JM_CbOrg.getSelectedItem();
        String name = JM_txtName.getText();
        if(org.getName().equals("Volunteer Organization")){
            org.getEmpDir().createVolunteer(name);
            autoPoptbl(org);
            return;
        }
        org.getEmpDir().createEmp(name);
        autoPoptbl(org);

    }//GEN-LAST:event_JM_btncreateActionPerformed

    private void JM_orgcomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JM_orgcomboActionPerformed
        Organisation org= (Organisation) JM_orgcombo.getSelectedItem();
        if (org != null){
            autoPoptbl(org);
        }
    }//GEN-LAST:event_JM_orgcomboActionPerformed

    private void JM_btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JM_btnbackActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_JM_btnbackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox JM_CbOrg;
    private javax.swing.JLabel JM_LblName;
    private javax.swing.JLabel JM_LblOrg;
    private javax.swing.JTable JM_OrgTbl;
    private javax.swing.JButton JM_btnback;
    private javax.swing.JButton JM_btncreate;
    private javax.swing.JPanel JM_jPanel1;
    private javax.swing.JScrollPane JM_jScrollPane1;
    private javax.swing.JLabel JM_lblOrganisation;
    private javax.swing.JLabel JM_lbltitle;
    private javax.swing.JComboBox JM_orgcombo;
    private javax.swing.JTextField JM_txtName;
    // End of variables declaration//GEN-END:variables
}
