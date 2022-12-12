/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.VolunteerRole;

/**
 *
 * @author krishna
 */
import Model.EcoSystem;
import Model.Enterprise.Enterprise;
import Model.Network.Network;
import Model.Organization.StorageOrg;
import Model.Organization.Organisation;
import Model.Organization.VolunteerOrg;
import Model.Role.VolunteerRole;
import Model.UserAccount.UserAccount;
import Model.WorkQueue.TutorVolunteerWorkReq;
import Model.WorkQueue.VolunteerStorageWorkRequest;
import Model.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;
import UI.HealthRole.DocReqJPanel;
import UI.SystemAdminRole.EnterpriseAdminPanel;

public class VolunteerWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form VolunteerWorkAreaJPanel
     */
    private JPanel userProcessCont;
    private EcoSystem system;
    private UserAccount ua;
    private Enterprise ent;
    private VolunteerOrg volunteerOrg;
    private VolunteerRole vR;
    private Network nwk;
    private ArrayList<String> catlist;
    private ArrayList<Integer> quantlist;
    private ArrayList<String> desclist;
    
    public VolunteerWorkAreaJPanel(JPanel userProcessContainer, UserAccount acc, Organisation org,  EcoSystem system, Enterprise ent, Network net) {
        initComponents();
        this.userProcessCont = userProcessContainer;
        this.ua = acc;
        this.system = system;
        this.ent = ent;
        this.vR = vR;
        this.volunteerOrg = (VolunteerOrg)org;
        this.nwk=net;
        catlist= new ArrayList();
        quantlist=new ArrayList();
        desclist = new ArrayList();

        autoPopAssigned();
        autoPopTbl(); 
        autoPopUserDetails();
    }
    
    public void autoPopAssigned(){
        DefaultTableModel mdl = (DefaultTableModel)tblTaskAssigned.getModel();
        mdl.setRowCount(0);
        SimpleDateFormat fmt = new SimpleDateFormat("dd MMM, yyyy");
        for (Iterator<WorkRequest> it = ua.getWorkQueue().getWrList().iterator(); it.hasNext();) {
            WorkRequest workRequest = it.next();
            if(workRequest instanceof TutorVolunteerWorkReq)
            {
            TutorVolunteerWorkReq request = (TutorVolunteerWorkReq) workRequest;
            
            for (Iterator<WorkRequest> cmp = volunteerOrg.getWorkQueue().getWrList().iterator(); cmp.hasNext();) {
                TutorVolunteerWorkReq compare = (TutorVolunteerWorkReq) cmp.next();
                
                if(request == compare){
                    
                    Object[] row = new Object[5];
                    row[0] = request;
                    Date date = request.getDate();
                    String volDate = fmt.format(date);
                    row[1] = volDate;
                    row[2] = request.getTime();
                    row[3] = request.getArea();
                    row[4] = request.getNumOfVolunteers();
                    mdl.addRow(row);
                }
            }
            }
        }
    }
    
    public void autoPopTbl(){
        DefaultTableModel mdl = (DefaultTableModel)tblNewVolList.getModel();
        
        mdl.setRowCount(0);
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM, yyyy");
        
        for (Iterator<WorkRequest> it = volunteerOrg.getWorkQueue().getWrList().iterator(); it.hasNext();) {
            WorkRequest workRequest = it.next();
            if(workRequest instanceof TutorVolunteerWorkReq)
            {
                TutorVolunteerWorkReq request = (TutorVolunteerWorkReq) workRequest;
                if(request.getVacancy()> 0){
                    Object[] row = new Object[5];
                    row[0] = request;
                    Date date = request.getDate();
                    String volDate = formatter.format(date);
                    row[1] = volDate;
                    row[2] = request.getTime();
                    row[3] = request.getArea();
                    row[4] = request.getVacancy();
                    mdl.addRow(row);
            }
                
            }
        }
    }
    
    public void autoPopUserDetails(){
        txtname.setText(ua.getEmp().getName());
        txtSex.setText(ua.getEmp().getSex());
        LocalDate nowDate = LocalDate.now();
        LocalDate birthdate = ua.getEmp().getDob();
        int age = ua.getEmp().ageCalculator(birthdate, nowDate);
        txtAge.setText(String.valueOf(age));

        txtAge.setText(String.valueOf(age));
        txtEmail.setText(ua.getEmp().getEmail());
        txtPhNo.setText(ua.getEmp().getPhNo());
    }
    
    private void autoPopDonate() {
        DefaultTableModel model = (DefaultTableModel)tblDonateReq.getModel();
        
        model.setRowCount(0);
        
        int s=catlist.size();
        for (int i=0;i<s;i++) {
                Object[] row = new Object[3];
                row[0] = catlist.get(i);
                row[1] = quantlist.get(i);
                row[2] = desclist.get(i);
                model.addRow(row);    
        }
    }
    
    private boolean checkPhone(String phNo) {
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

        JM_VolunteerJTabbedPane = new javax.swing.JTabbedPane();
        JM_HomePageJPanel = new javax.swing.JPanel();
        JM_jSplitPane1 = new javax.swing.JSplitPane();
        JM_leftJPanel = new javax.swing.JPanel();
        txtAge = new javax.swing.JTextField();
        btnUpdateDetail = new javax.swing.JButton();
        txtname = new javax.swing.JTextField();
        txtSex = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPhNo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblent = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        btnHistory = new javax.swing.JButton();
        JM_rightJPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTaskAssigned = new javax.swing.JTable();
        btnRefresh = new javax.swing.JButton();
        txtTitle = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtPlace = new javax.swing.JTextField();
        numberOfStudentsJTextField1 = new javax.swing.JTextField();
        numberOfHoursJTextField1 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        numberOfVolunteersJTextField1 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        dtChoser = new com.toedter.calendar.JDateChooser();
        Date date = new Date();
        SpinnerDateModel sm1 = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        tsTime = new javax.swing.JSpinner(sm1);
        btnCancelReq = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        requirementsJTextArea = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        areaJTextField1 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        JM_TasksJPanel = new javax.swing.JPanel();
        JM_numberOfVolunteersJTextField = new javax.swing.JTextField();
        JM_jLabel16 = new javax.swing.JLabel();
        JM_numberOfHoursJTextField = new javax.swing.JTextField();
        JM_dtVolChoser = new com.toedter.calendar.JDateChooser();
        JM_jLabel14 = new javax.swing.JLabel();
        JM_jLabel13 = new javax.swing.JLabel();
        SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        JM_tsVolTime = new javax.swing.JSpinner(sm);
        JM_jLabel17 = new javax.swing.JLabel();
        JM_jLabel12 = new javax.swing.JLabel();
        JM_txtVolTitle = new javax.swing.JTextField();
        JM_jScrollPane1 = new javax.swing.JScrollPane();
        tblNewVolList = new javax.swing.JTable();
        JM_jLabel15 = new javax.swing.JLabel();
        JM_jSeparator1 = new javax.swing.JSeparator();
        JM_txtVolPlace = new javax.swing.JTextField();
        JM_jLabel7 = new javax.swing.JLabel();
        JM_jLabel8 = new javax.swing.JLabel();
        JM_numberOfStudentsJTextField = new javax.swing.JTextField();
        JM_btnNewRefresh = new javax.swing.JButton();
        JM_jScrollPane4 = new javax.swing.JScrollPane();
        requirementsJTextArea1 = new javax.swing.JTextArea();
        JM_btnAssignToMe = new javax.swing.JButton();
        JM_jLabel25 = new javax.swing.JLabel();
        JM_jLabel26 = new javax.swing.JLabel();
        JM_areaJTextField = new javax.swing.JTextField();
        JM_DonateJPanel = new javax.swing.JPanel();
        JM_txtQuantity = new javax.swing.JTextField();
        JM_jScrollPane5 = new javax.swing.JScrollPane();
        tblDonateReq = new javax.swing.JTable();
        JM_btnAdd = new javax.swing.JButton();
        JM_btnDelete = new javax.swing.JButton();
        JM_btnModify = new javax.swing.JButton();
        JM_jLabel29 = new javax.swing.JLabel();
        JM_jLabel30 = new javax.swing.JLabel();
        JM_jLabel31 = new javax.swing.JLabel();
        JM_jScrollPane6 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        JM_btnDonate = new javax.swing.JButton();
        JM_selCat = new javax.swing.JComboBox();
        JM_jLabel32 = new javax.swing.JLabel();
        JM_jScrollPane7 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        JM_btnUpdate = new javax.swing.JButton();
        JM_txtNumber = new javax.swing.JTextField();
        JM_jLabel33 = new javax.swing.JLabel();
        JM_jLabel34 = new javax.swing.JLabel();

        JM_VolunteerJTabbedPane.setBackground(new java.awt.Color(0, 153, 153));
        JM_VolunteerJTabbedPane.setForeground(new java.awt.Color(255, 255, 255));
        JM_VolunteerJTabbedPane.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        JM_VolunteerJTabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                JM_VolunteerJTabbedPaneStateChanged(evt);
            }
        });

        JM_HomePageJPanel.setLayout(new java.awt.BorderLayout());

        JM_leftJPanel.setBackground(new java.awt.Color(0, 153, 153));
        JM_leftJPanel.setForeground(new java.awt.Color(102, 0, 102));
        JM_leftJPanel.setToolTipText("");

        txtAge.setEditable(false);
        txtAge.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        txtAge.setForeground(new java.awt.Color(102, 0, 102));

        btnUpdateDetail.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 14)); // NOI18N
        btnUpdateDetail.setForeground(new java.awt.Color(0, 153, 153));
        btnUpdateDetail.setText("Update Details");
        btnUpdateDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateDetailActionPerformed(evt);
            }
        });

        txtname.setEditable(false);
        txtname.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        txtname.setForeground(new java.awt.Color(102, 0, 102));

        txtSex.setEditable(false);
        txtSex.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        txtSex.setForeground(new java.awt.Color(102, 0, 102));
        txtSex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSexActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Sex: ");

        jLabel5.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Email Id:");

        txtEmail.setEditable(false);
        txtEmail.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(102, 0, 102));
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Contact Number:");

        txtPhNo.setEditable(false);
        txtPhNo.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        txtPhNo.setForeground(new java.awt.Color(102, 0, 102));
        txtPhNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhNoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Name: ");

        jLabel3.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Age:");

        lblent.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 16)); // NOI18N

        jLabel24.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 20)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Volunteer Details");

        btnHistory.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 14)); // NOI18N
        btnHistory.setForeground(new java.awt.Color(0, 153, 153));
        btnHistory.setText("Donation History");
        btnHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JM_leftJPanelLayout = new javax.swing.GroupLayout(JM_leftJPanel);
        JM_leftJPanel.setLayout(JM_leftJPanelLayout);
        JM_leftJPanelLayout.setHorizontalGroup(
            JM_leftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JM_leftJPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(JM_leftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnUpdateDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHistory, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
                .addGap(84, 84, 84))
            .addGroup(JM_leftJPanelLayout.createSequentialGroup()
                .addGroup(JM_leftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JM_leftJPanelLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(lblent)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(JM_leftJPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(JM_leftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JM_leftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(JM_leftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPhNo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSex, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JM_leftJPanelLayout.setVerticalGroup(
            JM_leftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JM_leftJPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblent)
                .addGap(51, 51, 51)
                .addComponent(jLabel24)
                .addGap(30, 30, 30)
                .addGroup(JM_leftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JM_leftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JM_leftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(JM_leftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JM_leftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPhNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(84, 84, 84)
                .addComponent(btnUpdateDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(452, Short.MAX_VALUE))
        );

        JM_jSplitPane1.setLeftComponent(JM_leftJPanel);

        JM_rightJPanel.setBackground(new java.awt.Color(0, 153, 153));

        tblTaskAssigned.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 13)); // NOI18N
        tblTaskAssigned.setForeground(new java.awt.Color(102, 0, 102));
        tblTaskAssigned.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Job Title", "Date", "Time", "Area", "Total Volunteers"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTaskAssigned.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTaskAssignedMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblTaskAssigned);

        btnRefresh.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 14)); // NOI18N
        btnRefresh.setForeground(new java.awt.Color(0, 153, 153));
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        txtTitle.setEditable(false);
        txtTitle.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        txtTitle.setForeground(new java.awt.Color(102, 0, 102));

        jLabel18.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Job Title:");

        jLabel19.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Date:");

        jLabel20.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Time: ");

        jLabel9.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Place:");

        txtPlace.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        txtPlace.setForeground(new java.awt.Color(102, 0, 102));

        numberOfStudentsJTextField1.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        numberOfStudentsJTextField1.setForeground(new java.awt.Color(102, 0, 102));

        numberOfHoursJTextField1.setEditable(false);
        numberOfHoursJTextField1.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        numberOfHoursJTextField1.setForeground(new java.awt.Color(102, 0, 102));
        numberOfHoursJTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberOfHoursJTextField1ActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Number of Hours:");

        jLabel10.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Number of Students:");

        jLabel22.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Number of Volunteers:");

        numberOfVolunteersJTextField1.setEditable(false);
        numberOfVolunteersJTextField1.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        numberOfVolunteersJTextField1.setForeground(new java.awt.Color(102, 0, 102));

        jLabel23.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("Requirements:");

        dtChoser.setEnabled(false);
        dtChoser.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N

        btnCancelReq.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 14)); // NOI18N
        btnCancelReq.setForeground(new java.awt.Color(0, 153, 153));
        btnCancelReq.setText("Cancel Request");
        btnCancelReq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelReqActionPerformed(evt);
            }
        });

        requirementsJTextArea.setColumns(20);
        requirementsJTextArea.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        requirementsJTextArea.setForeground(new java.awt.Color(102, 0, 102));
        requirementsJTextArea.setRows(5);
        jScrollPane3.setViewportView(requirementsJTextArea);

        jLabel11.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 22)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Volunteer Work Area");

        jLabel27.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("Area:");

        areaJTextField1.setEditable(false);
        areaJTextField1.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        areaJTextField1.setForeground(new java.awt.Color(102, 0, 102));

        jLabel28.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 15)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("My Tasks");

        javax.swing.GroupLayout JM_rightJPanelLayout = new javax.swing.GroupLayout(JM_rightJPanel);
        JM_rightJPanel.setLayout(JM_rightJPanelLayout);
        JM_rightJPanelLayout.setHorizontalGroup(
            JM_rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(JM_rightJPanelLayout.createSequentialGroup()
                .addContainerGap(425, Short.MAX_VALUE)
                .addGroup(JM_rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JM_rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(JM_rightJPanelLayout.createSequentialGroup()
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRefresh))
                        .addGroup(JM_rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCancelReq)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(JM_rightJPanelLayout.createSequentialGroup()
                        .addGroup(JM_rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JM_rightJPanelLayout.createSequentialGroup()
                                .addGroup(JM_rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JM_rightJPanelLayout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addGap(31, 31, 31)))
                        .addGroup(JM_rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(JM_rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(numberOfVolunteersJTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(numberOfHoursJTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(numberOfStudentsJTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtPlace, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tsTime, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(dtChoser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTitle, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(areaJTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(425, Short.MAX_VALUE))
        );
        JM_rightJPanelLayout.setVerticalGroup(
            JM_rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JM_rightJPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel11)
                .addGap(15, 15, 15)
                .addGroup(JM_rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelReq, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JM_rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JM_rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JM_rightJPanelLayout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(22, 22, 22)
                        .addGroup(JM_rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(tsTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(JM_rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtPlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(dtChoser, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JM_rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(areaJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addGap(17, 17, 17)
                .addGroup(JM_rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numberOfStudentsJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JM_rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numberOfHoursJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JM_rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(numberOfVolunteersJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JM_rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        JSpinner.DateEditor de1 = new JSpinner.DateEditor(tsTime, "HH:mm");
        tsTime.setEditor(de1);
        tsTime.setEnabled(false);

        JM_jSplitPane1.setRightComponent(JM_rightJPanel);

        JM_HomePageJPanel.add(JM_jSplitPane1, java.awt.BorderLayout.CENTER);

        JM_VolunteerJTabbedPane.addTab("Home Page", JM_HomePageJPanel);

        JM_TasksJPanel.setBackground(new java.awt.Color(0, 153, 153));

        JM_numberOfVolunteersJTextField.setEditable(false);
        JM_numberOfVolunteersJTextField.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        JM_numberOfVolunteersJTextField.setForeground(new java.awt.Color(102, 0, 102));

        JM_jLabel16.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        JM_jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        JM_jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        JM_jLabel16.setText("Number of Volunteers:");

        JM_numberOfHoursJTextField.setEditable(false);
        JM_numberOfHoursJTextField.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        JM_numberOfHoursJTextField.setForeground(new java.awt.Color(102, 0, 102));
        JM_numberOfHoursJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JM_numberOfHoursJTextFieldActionPerformed(evt);
            }
        });

        JM_dtVolChoser.setEnabled(false);
        JM_dtVolChoser.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N

        JM_jLabel14.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        JM_jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        JM_jLabel14.setText("Time: ");

        JM_jLabel13.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        JM_jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        JM_jLabel13.setText("Date:");

        JSpinner.DateEditor de = new JSpinner.DateEditor(JM_tsVolTime, "HH:mm");
        JM_tsVolTime.setEditor(de);
        JM_tsVolTime.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        JM_tsVolTime.setEnabled(false);

        JM_jLabel17.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        JM_jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        JM_jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        JM_jLabel17.setText("Requirements:");

        JM_jLabel12.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        JM_jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        JM_jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        JM_jLabel12.setText("Job Title:");

        JM_txtVolTitle.setEditable(false);
        JM_txtVolTitle.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        JM_txtVolTitle.setForeground(new java.awt.Color(102, 0, 102));

        tblNewVolList.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 13)); // NOI18N
        tblNewVolList.setForeground(new java.awt.Color(102, 0, 102));
        tblNewVolList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Job Title", "Date", "Time", "Area", "Current Vacancy"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNewVolList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNewVolListMouseClicked(evt);
            }
        });
        JM_jScrollPane1.setViewportView(tblNewVolList);

        JM_jLabel15.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        JM_jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        JM_jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        JM_jLabel15.setText("Number of Hours:");

        JM_txtVolPlace.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        JM_txtVolPlace.setForeground(new java.awt.Color(102, 0, 102));

        JM_jLabel7.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        JM_jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        JM_jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        JM_jLabel7.setText("Place:");

        JM_jLabel8.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        JM_jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        JM_jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        JM_jLabel8.setText("Number of Students:");

        JM_numberOfStudentsJTextField.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        JM_numberOfStudentsJTextField.setForeground(new java.awt.Color(102, 0, 102));

        JM_btnNewRefresh.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 14)); // NOI18N
        JM_btnNewRefresh.setForeground(new java.awt.Color(0, 153, 153));
        JM_btnNewRefresh.setText("Refresh");
        JM_btnNewRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JM_btnNewRefreshActionPerformed(evt);
            }
        });

        requirementsJTextArea1.setColumns(20);
        requirementsJTextArea1.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        requirementsJTextArea1.setForeground(new java.awt.Color(102, 0, 102));
        requirementsJTextArea1.setRows(5);
        JM_jScrollPane4.setViewportView(requirementsJTextArea1);

        JM_btnAssignToMe.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 14)); // NOI18N
        JM_btnAssignToMe.setForeground(new java.awt.Color(0, 153, 153));
        JM_btnAssignToMe.setText("Assign to me");
        JM_btnAssignToMe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JM_btnAssignToMeActionPerformed(evt);
            }
        });

        JM_jLabel25.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 22)); // NOI18N
        JM_jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        JM_jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JM_jLabel25.setText("New Volunteer Requests");

        JM_jLabel26.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        JM_jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        JM_jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        JM_jLabel26.setText("Area:");

        JM_areaJTextField.setEditable(false);
        JM_areaJTextField.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        JM_areaJTextField.setForeground(new java.awt.Color(102, 0, 102));

        javax.swing.GroupLayout JM_TasksJPanelLayout = new javax.swing.GroupLayout(JM_TasksJPanel);
        JM_TasksJPanel.setLayout(JM_TasksJPanelLayout);
        JM_TasksJPanelLayout.setHorizontalGroup(
            JM_TasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JM_jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JM_TasksJPanelLayout.createSequentialGroup()
                .addContainerGap(234, Short.MAX_VALUE)
                .addGroup(JM_TasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JM_jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JM_jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JM_jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JM_jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JM_jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JM_jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JM_jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JM_jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JM_jLabel26, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(JM_TasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JM_jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JM_TasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(JM_numberOfVolunteersJTextField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(JM_numberOfHoursJTextField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(JM_areaJTextField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(JM_tsVolTime, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(JM_dtVolChoser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                        .addComponent(JM_txtVolTitle, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(JM_txtVolPlace, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(JM_numberOfStudentsJTextField, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(439, 439, 439))
            .addComponent(JM_jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(JM_TasksJPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(JM_TasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JM_btnAssignToMe)
                    .addGroup(JM_TasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(JM_btnNewRefresh)
                        .addComponent(JM_jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        JM_TasksJPanelLayout.setVerticalGroup(
            JM_TasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JM_TasksJPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(JM_jLabel25)
                .addGap(10, 10, 10)
                .addComponent(JM_btnNewRefresh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JM_jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JM_btnAssignToMe, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JM_jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JM_TasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JM_jLabel12)
                    .addComponent(JM_txtVolTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JM_TasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JM_jLabel13)
                    .addComponent(JM_dtVolChoser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JM_TasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JM_jLabel14)
                    .addComponent(JM_tsVolTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JM_TasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JM_jLabel7)
                    .addComponent(JM_txtVolPlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JM_TasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JM_areaJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JM_jLabel26))
                .addGap(11, 11, 11)
                .addGroup(JM_TasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JM_numberOfStudentsJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JM_jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JM_TasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JM_numberOfHoursJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JM_jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JM_TasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JM_jLabel16)
                    .addComponent(JM_numberOfVolunteersJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JM_TasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JM_jLabel17)
                    .addComponent(JM_jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(256, Short.MAX_VALUE))
        );

        JM_VolunteerJTabbedPane.addTab("New Tasks", JM_TasksJPanel);

        JM_DonateJPanel.setBackground(new java.awt.Color(0, 153, 153));
        JM_DonateJPanel.setForeground(new java.awt.Color(255, 255, 255));
        JM_DonateJPanel.setPreferredSize(new java.awt.Dimension(3043, 1021));

        JM_txtQuantity.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        JM_txtQuantity.setForeground(new java.awt.Color(102, 0, 102));

        tblDonateReq.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 13)); // NOI18N
        tblDonateReq.setForeground(new java.awt.Color(102, 0, 102));
        tblDonateReq.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Category", "Quantity", "Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JM_jScrollPane5.setViewportView(tblDonateReq);

        JM_btnAdd.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 14)); // NOI18N
        JM_btnAdd.setForeground(new java.awt.Color(0, 153, 153));
        JM_btnAdd.setText("Add");
        JM_btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JM_btnAddActionPerformed(evt);
            }
        });

        JM_btnDelete.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 14)); // NOI18N
        JM_btnDelete.setForeground(new java.awt.Color(0, 153, 153));
        JM_btnDelete.setText("Delete");
        JM_btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JM_btnDeleteActionPerformed(evt);
            }
        });

        JM_btnModify.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 14)); // NOI18N
        JM_btnModify.setForeground(new java.awt.Color(0, 153, 153));
        JM_btnModify.setText("Modify");
        JM_btnModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JM_btnModifyActionPerformed(evt);
            }
        });

        JM_jLabel29.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        JM_jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        JM_jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        JM_jLabel29.setText("Pickup Address:");

        JM_jLabel30.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        JM_jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        JM_jLabel30.setText("Category:");

        JM_jLabel31.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        JM_jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        JM_jLabel31.setText("Quantity:");

        txtAddress.setColumns(20);
        txtAddress.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        txtAddress.setForeground(new java.awt.Color(102, 0, 102));
        txtAddress.setRows(5);
        JM_jScrollPane6.setViewportView(txtAddress);

        JM_btnDonate.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 14)); // NOI18N
        JM_btnDonate.setForeground(new java.awt.Color(0, 153, 153));
        JM_btnDonate.setText("DONATE");
        JM_btnDonate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JM_btnDonateActionPerformed(evt);
            }
        });

        JM_selCat.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        JM_selCat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Books", "Toys", "Clothes", "Other" }));

        JM_jLabel32.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        JM_jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        JM_jLabel32.setText("Description:");

        txtDescription.setColumns(20);
        txtDescription.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        txtDescription.setForeground(new java.awt.Color(102, 0, 102));
        txtDescription.setRows(5);
        JM_jScrollPane7.setViewportView(txtDescription);

        JM_btnUpdate.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 14)); // NOI18N
        JM_btnUpdate.setForeground(new java.awt.Color(0, 153, 153));
        JM_btnUpdate.setText("Update");
        JM_btnUpdate.setEnabled(false);
        JM_btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JM_btnUpdateActionPerformed(evt);
            }
        });

        JM_txtNumber.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        JM_txtNumber.setForeground(new java.awt.Color(102, 0, 102));

        JM_jLabel33.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        JM_jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        JM_jLabel33.setText("Mobile Number:");

        JM_jLabel34.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 22)); // NOI18N
        JM_jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        JM_jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JM_jLabel34.setText("Donate Work Requests");

        javax.swing.GroupLayout JM_DonateJPanelLayout = new javax.swing.GroupLayout(JM_DonateJPanel);
        JM_DonateJPanel.setLayout(JM_DonateJPanelLayout);
        JM_DonateJPanelLayout.setHorizontalGroup(
            JM_DonateJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JM_DonateJPanelLayout.createSequentialGroup()
                .addGap(328, 328, 328)
                .addGroup(JM_DonateJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JM_DonateJPanelLayout.createSequentialGroup()
                        .addGroup(JM_DonateJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JM_jLabel33)
                            .addComponent(JM_jLabel29))
                        .addGap(18, 18, 18)
                        .addGroup(JM_DonateJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JM_btnDonate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JM_txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JM_jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(JM_DonateJPanelLayout.createSequentialGroup()
                        .addComponent(JM_jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(JM_DonateJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JM_DonateJPanelLayout.createSequentialGroup()
                                .addGroup(JM_DonateJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(JM_jLabel32)
                                    .addComponent(JM_jLabel31, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JM_jLabel30, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addGroup(JM_DonateJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(JM_selCat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JM_txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(JM_DonateJPanelLayout.createSequentialGroup()
                                        .addComponent(JM_btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JM_btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(JM_jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(JM_btnModify, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JM_btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(JM_DonateJPanelLayout.createSequentialGroup()
                .addComponent(JM_jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        JM_DonateJPanelLayout.setVerticalGroup(
            JM_DonateJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JM_DonateJPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(JM_jLabel34)
                .addGap(50, 50, 50)
                .addGroup(JM_DonateJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JM_jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JM_DonateJPanelLayout.createSequentialGroup()
                        .addGroup(JM_DonateJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JM_jLabel30)
                            .addComponent(JM_selCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(JM_DonateJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JM_txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JM_jLabel31))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(JM_DonateJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JM_jLabel32)
                            .addComponent(JM_jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(JM_DonateJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JM_btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JM_btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addComponent(JM_btnModify, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JM_btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addGroup(JM_DonateJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JM_jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JM_jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JM_DonateJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JM_jLabel33)
                    .addComponent(JM_txtNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JM_btnDonate, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(224, 224, 224))
        );

        JM_VolunteerJTabbedPane.addTab("Donate", JM_DonateJPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JM_VolunteerJTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1113, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JM_VolunteerJTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1005, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblTaskAssignedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTaskAssignedMouseClicked

        int selectedRow = tblTaskAssigned.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showConfirmDialog(null, "Make row selection from table.","Warning", JOptionPane.WARNING_MESSAGE);
        }
        else{
            TutorVolunteerWorkReq wr = (TutorVolunteerWorkReq) tblTaskAssigned.getValueAt(selectedRow, 0);
            txtTitle.setText(wr.getTitle());
            dtChoser.setDate(wr.getDate());

            Date time = null;
            String volTime = wr.getTime();
            SimpleDateFormat defaultFmt = new SimpleDateFormat("HH:mm");

            try {
                time = defaultFmt.parse(volTime);
            } catch (ParseException ex) {

            }

            tsTime.setValue(time);

            numberOfHoursJTextField1.setText(wr.getNumOfhours());
            numberOfVolunteersJTextField1.setText(String.valueOf(wr.getNumOfVolunteers()));
            requirementsJTextArea.setText(wr.getMessage());
            txtPlace.setText(wr.getAddress());
            areaJTextField1.setText(wr.getArea());
            numberOfStudentsJTextField1.setText(String.valueOf(wr.getNumOfStudents()));

        }
    }//GEN-LAST:event_tblTaskAssignedMouseClicked

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed

        autoPopAssigned();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void numberOfHoursJTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberOfHoursJTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numberOfHoursJTextField1ActionPerformed

    private void btnCancelReqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelReqActionPerformed

        int selectedRow = tblTaskAssigned.getSelectedRow();
        if(selectedRow>=0){
            int selectionButton = JOptionPane.YES_NO_OPTION;
            int selectionResult = JOptionPane.showConfirmDialog(null, "Sure about request cancellation?","Warning",selectionButton);
            if(selectionResult == JOptionPane.YES_OPTION){
                TutorVolunteerWorkReq request = (TutorVolunteerWorkReq) tblTaskAssigned.getValueAt(selectedRow, 0);

                ua.getWorkQueue().getWrList().remove(request);
                request.getUsersList().remove(ua);
                int currentVac = request.getVacancy();
                request.setVacancy(currentVac + 1);

                autoPopTbl();
                autoPopAssigned();

            }
        }else{
            JOptionPane.showMessageDialog(null, "MAke row selection");
        }

    }//GEN-LAST:event_btnCancelReqActionPerformed

    private void JM_numberOfHoursJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JM_numberOfHoursJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JM_numberOfHoursJTextFieldActionPerformed

    private void tblNewVolListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNewVolListMouseClicked
        int selectedRow = tblNewVolList.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showConfirmDialog(null, "Make a row selection to view desired details.","Warning", JOptionPane.WARNING_MESSAGE);
        }
        else{
            TutorVolunteerWorkReq wr = (TutorVolunteerWorkReq) tblNewVolList.getValueAt(selectedRow, 0);
            JM_txtVolTitle.setText(wr.getTitle());
            JM_dtVolChoser.setDate(wr.getDate());

            Date time = null;
            String volTime = wr.getTime();
            SimpleDateFormat formatterDefault = new SimpleDateFormat("HH:mm");

            try {
                time = formatterDefault.parse(volTime);
            } catch (ParseException ex) {

            }

            JM_tsVolTime.setValue(time);

            JM_numberOfHoursJTextField.setText(wr.getNumOfhours());
            JM_numberOfVolunteersJTextField.setText(String.valueOf(wr.getNumOfVolunteers()));
            requirementsJTextArea1.setText(wr.getMessage());
            JM_txtVolPlace.setText(wr.getAddress());
            JM_areaJTextField.setText(wr.getArea());
            JM_numberOfStudentsJTextField.setText(String.valueOf(wr.getNumOfStudents()));

        }
    }//GEN-LAST:event_tblNewVolListMouseClicked

    private void JM_btnNewRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JM_btnNewRefreshActionPerformed
        autoPopTbl();
    }//GEN-LAST:event_JM_btnNewRefreshActionPerformed

    private void JM_btnAssignToMeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JM_btnAssignToMeActionPerformed

        int selectedRow = tblNewVolList.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showConfirmDialog(null, "Select a row for request assignment.","Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        else{

            TutorVolunteerWorkReq request = (TutorVolunteerWorkReq)tblNewVolList.getValueAt(selectedRow, 0);

            boolean isAlreadyAssigned = ua.checkUniqueRequest(request);

            if(isAlreadyAssigned == true){
                JOptionPane.showMessageDialog(null, "Volunteer Request Assigned.");
                return;
            }

            List<WorkRequest> requestList = new ArrayList<WorkRequest>();
            requestList = ua.getWorkQueue().getWrList();

            for(WorkRequest r: requestList){
                if(r instanceof TutorVolunteerWorkReq){

                    TutorVolunteerWorkReq request1 = (TutorVolunteerWorkReq)r;
                    SimpleDateFormat formatter = new SimpleDateFormat("dd MMM, yyyy");
                    String request1Date = formatter.format(request1.getDate());
                    String requestDate = formatter.format(request.getDate());
                    if(request1Date.equals(requestDate)){
                        JOptionPane.showMessageDialog(null, "Alloted task for the date.Select a different day.");
                        return;
                    }

                }

            }

            if(isAlreadyAssigned == false){
                request.setReceiver(ua);
                int vacancy = request.getVacancy();
                request.setVacancy(vacancy-1);
                if(request.getVacancy()== 0){
                    request.setStatus("Completed");
                }
                else{
                    request.setStatus("Pending");
                }
                ua.getWorkQueue().getWrList().add(request);
                request.getUsersList().add(ua);
                JOptionPane.showMessageDialog(null, "Volunteer Request Assignment Successful");

            }

        }

        autoPopTbl();
        autoPopAssigned();

    }//GEN-LAST:event_JM_btnAssignToMeActionPerformed

    private void JM_btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JM_btnAddActionPerformed
        // TODO add your handling code here:

        String description="";

        String quantityText = JM_txtQuantity.getText();
        if(quantityText==null || quantityText.equals("")){
            JOptionPane.showMessageDialog(null,"Enter desired quantity");
            return;
        }

        try{
            Integer.parseInt(JM_txtQuantity.getText());
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Enter number for quantity");
            return;
        }
        int quantity = Integer.parseInt(quantityText);
        if(quantity<=0)
        {
            JOptionPane.showMessageDialog(null, "Quantity should not be less than or equal to zero.");
            return;
        }
        description = txtDescription.getText();

        String category= (String) JM_selCat.getSelectedItem();
        catlist.add(category);
        desclist.add(description);
        quantlist.add(quantity);
        autoPopDonate();

        JM_txtQuantity.setText("");
        txtDescription.setText("");
        JM_selCat.setSelectedIndex(0);

    }//GEN-LAST:event_JM_btnAddActionPerformed

    private void JM_btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JM_btnDeleteActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblDonateReq.getSelectedRow();
        if(selectedRow>=0){

            catlist.remove(selectedRow);
            quantlist.remove(selectedRow);
            desclist.remove(selectedRow);
            autoPopDonate();
        }
        else{
            JOptionPane.showMessageDialog(null, "Make row selection", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_JM_btnDeleteActionPerformed

    private void JM_btnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JM_btnModifyActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblDonateReq.getSelectedRow();
        if(selectedRow>=0){

            String c=catlist.get(selectedRow);
            int q=quantlist.get(selectedRow);
            String d=desclist.get(selectedRow);
            JM_selCat.setSelectedItem(c);
            JM_txtQuantity.setText(String.valueOf(q));
            txtDescription.setText(d);
            JM_btnAdd.setEnabled(false);
            JM_btnModify.setEnabled(false);
            JM_btnUpdate.setEnabled(true);
            tblDonateReq.setEnabled(false);
            JM_btnDelete.setEnabled(false);
            JM_btnDonate.setEnabled(false);
        }
        else{
            JOptionPane.showMessageDialog(null, "Make row selection", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_JM_btnModifyActionPerformed

    private void JM_btnDonateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JM_btnDonateActionPerformed

        if(catlist.isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Enter donation items");
            return;
        }

        String address=txtAddress.getText();
        if(address==null || address.equals("")){
            JOptionPane.showMessageDialog(null,"Enter Address");
            return;
        }

        String contactNumber = JM_txtNumber.getText();
        if(contactNumber == null || contactNumber.equals("")){
            JOptionPane.showMessageDialog(null, "Contact Number mandatory");
            return;
        }
        if(!checkPhone(contactNumber)){
            JOptionPane.showMessageDialog(null, "Invalid Contact Number", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if(catlist.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Enter a valid phone number.");
            return;
        }

        VolunteerStorageWorkRequest request = new VolunteerStorageWorkRequest();

        for(String s: catlist)
        {

            request.getCategory().add(s);
        }
        for(String s: desclist)
        {

            request.getDescription().add(s);
        }
        for(Integer s: quantlist)
        {

            request.getQuantity().add(s);
        }

        request.setSenderAddress(address);
        request.setSenderNumber(contactNumber);
        request.setSender(ua);
        request.setStatus("Sent");

        Organisation org=null;

        for(Enterprise e: nwk.getEntDir().getEntList())
        {
            if(e.getEntType().equals(e.getEntType().NGO))
            {
                for (Organisation organization : e.getOrgDir().getOrgList())
                {
                    if (organization instanceof StorageOrg){
                        org = organization;
                        org.getWorkQueue().getWrList().add(request);
                    }
                }
            }
        }
        if (org!=null){
            System.out.println("zzzzzz");
            ua.getWorkQueue().getWrList().add(request);
        }

        catlist.clear();
        quantlist.clear();
        desclist.clear();

        JOptionPane.showMessageDialog(null, "Donation Request Successful. Your OrderId for this order is : " +request.getOrdID());
        autoPopDonate();
        JM_txtQuantity.setText("");
        txtDescription.setText("");
        JM_selCat.setSelectedIndex(0);
    }//GEN-LAST:event_JM_btnDonateActionPerformed

    private void JM_btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JM_btnUpdateActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblDonateReq.getSelectedRow();

        String description="";

        String quantityText = JM_txtQuantity.getText();
        if(quantityText==null || quantityText.equals("")){
            JOptionPane.showMessageDialog(null,"Enter quantity.");
            return;
        }

        try{
            Integer.parseInt(JM_txtQuantity.getText());
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Enter number for Quantity");
            return;
        }
        int quantity = Integer.parseInt(quantityText);
        if(quantity<=0)
        {
            JOptionPane.showMessageDialog(null, "Quantity should not be less than or equal to zero.");
            return;
        }
        description = txtDescription.getText();

        String category= (String) JM_selCat.getSelectedItem();

        catlist.set(selectedRow, category);
        quantlist.set(selectedRow, quantity);
        desclist.set(selectedRow, description);
        JM_btnAdd.setEnabled(true);
        JM_btnModify.setEnabled(true);
        JM_btnUpdate.setEnabled(false);
        tblDonateReq.setEnabled(true);
        JM_btnDelete.setEnabled(true);
        JM_btnDonate.setEnabled(true);
        autoPopDonate();

    }//GEN-LAST:event_JM_btnUpdateActionPerformed

    private void JM_VolunteerJTabbedPaneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_JM_VolunteerJTabbedPaneStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_JM_VolunteerJTabbedPaneStateChanged

    private void btnHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistoryActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) userProcessCont.getLayout();
        userProcessCont.add("OrderHistoryJPanel", new OrderHistJPanel(userProcessCont, ua, ent));
        layout.next(userProcessCont);
    }//GEN-LAST:event_btnHistoryActionPerformed

    private void txtPhNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhNoActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void btnUpdateDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateDetailActionPerformed
        UpdateVolJPanel updateVolJPanel=new UpdateVolJPanel(userProcessCont,ua);
        userProcessCont.add("updateVolJPanel",updateVolJPanel);
        CardLayout layout=(CardLayout)userProcessCont.getLayout();
        layout.next(userProcessCont);
    }//GEN-LAST:event_btnUpdateDetailActionPerformed

    private void txtSexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSexActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JM_DonateJPanel;
    private javax.swing.JPanel JM_HomePageJPanel;
    private javax.swing.JPanel JM_TasksJPanel;
    private javax.swing.JTabbedPane JM_VolunteerJTabbedPane;
    private javax.swing.JTextField JM_areaJTextField;
    private javax.swing.JButton JM_btnAdd;
    private javax.swing.JButton JM_btnAssignToMe;
    private javax.swing.JButton JM_btnDelete;
    private javax.swing.JButton JM_btnDonate;
    private javax.swing.JButton JM_btnModify;
    private javax.swing.JButton JM_btnNewRefresh;
    private javax.swing.JButton JM_btnUpdate;
    private com.toedter.calendar.JDateChooser JM_dtVolChoser;
    private javax.swing.JLabel JM_jLabel12;
    private javax.swing.JLabel JM_jLabel13;
    private javax.swing.JLabel JM_jLabel14;
    private javax.swing.JLabel JM_jLabel15;
    private javax.swing.JLabel JM_jLabel16;
    private javax.swing.JLabel JM_jLabel17;
    private javax.swing.JLabel JM_jLabel25;
    private javax.swing.JLabel JM_jLabel26;
    private javax.swing.JLabel JM_jLabel29;
    private javax.swing.JLabel JM_jLabel30;
    private javax.swing.JLabel JM_jLabel31;
    private javax.swing.JLabel JM_jLabel32;
    private javax.swing.JLabel JM_jLabel33;
    private javax.swing.JLabel JM_jLabel34;
    private javax.swing.JLabel JM_jLabel7;
    private javax.swing.JLabel JM_jLabel8;
    private javax.swing.JScrollPane JM_jScrollPane1;
    private javax.swing.JScrollPane JM_jScrollPane4;
    private javax.swing.JScrollPane JM_jScrollPane5;
    private javax.swing.JScrollPane JM_jScrollPane6;
    private javax.swing.JScrollPane JM_jScrollPane7;
    private javax.swing.JSeparator JM_jSeparator1;
    private javax.swing.JSplitPane JM_jSplitPane1;
    private javax.swing.JPanel JM_leftJPanel;
    private javax.swing.JTextField JM_numberOfHoursJTextField;
    private javax.swing.JTextField JM_numberOfStudentsJTextField;
    private javax.swing.JTextField JM_numberOfVolunteersJTextField;
    private javax.swing.JPanel JM_rightJPanel;
    private javax.swing.JComboBox JM_selCat;
    private javax.swing.JSpinner JM_tsVolTime;
    private javax.swing.JTextField JM_txtNumber;
    private javax.swing.JTextField JM_txtQuantity;
    private javax.swing.JTextField JM_txtVolPlace;
    private javax.swing.JTextField JM_txtVolTitle;
    private javax.swing.JTextField areaJTextField1;
    private javax.swing.JButton btnCancelReq;
    private javax.swing.JButton btnHistory;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnUpdateDetail;
    private com.toedter.calendar.JDateChooser dtChoser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblent;
    private javax.swing.JTextField numberOfHoursJTextField1;
    private javax.swing.JTextField numberOfStudentsJTextField1;
    private javax.swing.JTextField numberOfVolunteersJTextField1;
    private javax.swing.JTextArea requirementsJTextArea;
    private javax.swing.JTextArea requirementsJTextArea1;
    private javax.swing.JTable tblDonateReq;
    private javax.swing.JTable tblNewVolList;
    private javax.swing.JTable tblTaskAssigned;
    private javax.swing.JSpinner tsTime;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtPhNo;
    private javax.swing.JTextField txtPlace;
    private javax.swing.JTextField txtSex;
    private javax.swing.JTextField txtTitle;
    private javax.swing.JTextField txtname;
    // End of variables declaration//GEN-END:variables
}
