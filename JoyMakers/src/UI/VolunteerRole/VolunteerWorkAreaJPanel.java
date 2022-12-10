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
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.StorageOrg;
import Business.Organization.Organisation;
import Business.Organization.VolunteerOrg;
import Business.Role.VolunteerRole;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.TutorVolunteerWorkReq;
import Business.WorkQueue.VolunteerStorageWorkRequest;
import Business.WorkQueue.WorkRequest;
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

        VolunteerJTabbedPane = new javax.swing.JTabbedPane();
        HomePageJPanel = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        leftJPanel = new javax.swing.JPanel();
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
        rightJPanel = new javax.swing.JPanel();
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
        TasksJPanel = new javax.swing.JPanel();
        numberOfVolunteersJTextField = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        numberOfHoursJTextField = new javax.swing.JTextField();
        dtVolChoser = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        tsVolTime = new javax.swing.JSpinner(sm);
        jLabel17 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtVolTitle = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNewVolList = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtVolPlace = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        numberOfStudentsJTextField = new javax.swing.JTextField();
        btnNewRefresh = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        requirementsJTextArea1 = new javax.swing.JTextArea();
        btnAssignToMe = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        areaJTextField = new javax.swing.JTextField();
        DonateJPanel = new javax.swing.JPanel();
        txtQuantity = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblDonateReq = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnModify = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        btnDonate = new javax.swing.JButton();
        selCat = new javax.swing.JComboBox();
        jLabel32 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        btnUpdate = new javax.swing.JButton();
        txtNumber = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();

        VolunteerJTabbedPane.setBackground(new java.awt.Color(180, 195, 195));
        VolunteerJTabbedPane.setForeground(new java.awt.Color(102, 0, 102));
        VolunteerJTabbedPane.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        VolunteerJTabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                VolunteerJTabbedPaneStateChanged(evt);
            }
        });

        HomePageJPanel.setLayout(new java.awt.BorderLayout());

        leftJPanel.setBackground(new java.awt.Color(255, 255, 255));
        leftJPanel.setForeground(new java.awt.Color(102, 0, 102));
        leftJPanel.setToolTipText("");

        txtAge.setEditable(false);
        txtAge.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        txtAge.setForeground(new java.awt.Color(102, 0, 102));

        btnUpdateDetail.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        btnUpdateDetail.setForeground(new java.awt.Color(102, 0, 102));
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
        jLabel2.setForeground(new java.awt.Color(102, 0, 102));
        jLabel2.setText("Sex: ");

        jLabel5.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 0, 102));
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
        jLabel6.setForeground(new java.awt.Color(102, 0, 102));
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
        jLabel1.setForeground(new java.awt.Color(102, 0, 102));
        jLabel1.setText("Name: ");

        jLabel3.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 102));
        jLabel3.setText("Age:");

        lblent.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 16)); // NOI18N

        jLabel24.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 20)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(102, 0, 102));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Volunteer Details");

        btnHistory.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        btnHistory.setForeground(new java.awt.Color(102, 0, 102));
        btnHistory.setText("Donation History");
        btnHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout leftJPanelLayout = new javax.swing.GroupLayout(leftJPanel);
        leftJPanel.setLayout(leftJPanelLayout);
        leftJPanelLayout.setHorizontalGroup(
            leftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leftJPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(leftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnUpdateDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHistory, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
                .addGap(84, 84, 84))
            .addGroup(leftJPanelLayout.createSequentialGroup()
                .addGroup(leftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(leftJPanelLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(lblent)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(leftJPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(leftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(leftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(leftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPhNo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSex, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        leftJPanelLayout.setVerticalGroup(
            leftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftJPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblent)
                .addGap(51, 51, 51)
                .addComponent(jLabel24)
                .addGap(30, 30, 30)
                .addGroup(leftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(leftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(leftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(leftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(leftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPhNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(84, 84, 84)
                .addComponent(btnUpdateDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(452, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(leftJPanel);

        rightJPanel.setBackground(new java.awt.Color(255, 255, 255));

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

        btnRefresh.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        btnRefresh.setForeground(new java.awt.Color(102, 0, 102));
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
        jLabel18.setForeground(new java.awt.Color(102, 0, 102));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Job Title:");

        jLabel19.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 0, 102));
        jLabel19.setText("Date:");

        jLabel20.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 0, 102));
        jLabel20.setText("Time: ");

        jLabel9.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 0, 102));
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
        jLabel21.setForeground(new java.awt.Color(102, 0, 102));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Number of Hours:");

        jLabel10.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 0, 102));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Number of Students:");

        jLabel22.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(102, 0, 102));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Number of Volunteers:");

        numberOfVolunteersJTextField1.setEditable(false);
        numberOfVolunteersJTextField1.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        numberOfVolunteersJTextField1.setForeground(new java.awt.Color(102, 0, 102));

        jLabel23.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 0, 102));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("Requirements:");

        dtChoser.setEnabled(false);
        dtChoser.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N

        btnCancelReq.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        btnCancelReq.setForeground(new java.awt.Color(102, 0, 102));
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
        jLabel11.setForeground(new java.awt.Color(102, 0, 102));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Volunteer Work Area");

        jLabel27.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(102, 0, 102));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("Area:");

        areaJTextField1.setEditable(false);
        areaJTextField1.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        areaJTextField1.setForeground(new java.awt.Color(102, 0, 102));

        jLabel28.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 15)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(102, 0, 102));
        jLabel28.setText("My Tasks");

        javax.swing.GroupLayout rightJPanelLayout = new javax.swing.GroupLayout(rightJPanel);
        rightJPanel.setLayout(rightJPanelLayout);
        rightJPanelLayout.setHorizontalGroup(
            rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(rightJPanelLayout.createSequentialGroup()
                .addContainerGap(123, Short.MAX_VALUE)
                .addGroup(rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(rightJPanelLayout.createSequentialGroup()
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRefresh))
                        .addGroup(rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCancelReq)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(rightJPanelLayout.createSequentialGroup()
                        .addGroup(rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(rightJPanelLayout.createSequentialGroup()
                                .addGroup(rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightJPanelLayout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addGap(31, 31, 31)))
                        .addGroup(rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(numberOfVolunteersJTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(numberOfHoursJTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(numberOfStudentsJTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtPlace, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tsTime, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(dtChoser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTitle, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(areaJTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        rightJPanelLayout.setVerticalGroup(
            rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightJPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel11)
                .addGap(15, 15, 15)
                .addGroup(rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelReq, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rightJPanelLayout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(22, 22, 22)
                        .addGroup(rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(tsTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtPlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(dtChoser, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(areaJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addGap(17, 17, 17)
                .addGroup(rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numberOfStudentsJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numberOfHoursJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(numberOfVolunteersJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(248, Short.MAX_VALUE))
        );

        JSpinner.DateEditor de1 = new JSpinner.DateEditor(tsTime, "HH:mm");
        tsTime.setEditor(de1);
        tsTime.setEnabled(false);

        jSplitPane1.setRightComponent(rightJPanel);

        HomePageJPanel.add(jSplitPane1, java.awt.BorderLayout.CENTER);

        VolunteerJTabbedPane.addTab("Home Page", HomePageJPanel);

        TasksJPanel.setBackground(new java.awt.Color(180, 195, 195));

        numberOfVolunteersJTextField.setEditable(false);
        numberOfVolunteersJTextField.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        numberOfVolunteersJTextField.setForeground(new java.awt.Color(102, 0, 102));

        jLabel16.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 0, 102));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Number of Volunteers:");

        numberOfHoursJTextField.setEditable(false);
        numberOfHoursJTextField.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        numberOfHoursJTextField.setForeground(new java.awt.Color(102, 0, 102));
        numberOfHoursJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberOfHoursJTextFieldActionPerformed(evt);
            }
        });

        dtVolChoser.setEnabled(false);
        dtVolChoser.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N

        jLabel14.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 0, 102));
        jLabel14.setText("Time: ");

        jLabel13.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 0, 102));
        jLabel13.setText("Date:");

        JSpinner.DateEditor de = new JSpinner.DateEditor(tsVolTime, "HH:mm");
        tsVolTime.setEditor(de);
        tsVolTime.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        tsVolTime.setEnabled(false);

        jLabel17.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 0, 102));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Requirements:");

        jLabel12.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 0, 102));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Job Title:");

        txtVolTitle.setEditable(false);
        txtVolTitle.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        txtVolTitle.setForeground(new java.awt.Color(102, 0, 102));

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
        jScrollPane1.setViewportView(tblNewVolList);

        jLabel15.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 0, 102));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Number of Hours:");

        txtVolPlace.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        txtVolPlace.setForeground(new java.awt.Color(102, 0, 102));

        jLabel7.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 0, 102));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Place:");

        jLabel8.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 0, 102));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Number of Students:");

        numberOfStudentsJTextField.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        numberOfStudentsJTextField.setForeground(new java.awt.Color(102, 0, 102));

        btnNewRefresh.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        btnNewRefresh.setForeground(new java.awt.Color(102, 0, 102));
        btnNewRefresh.setText("Refresh");
        btnNewRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewRefreshActionPerformed(evt);
            }
        });

        requirementsJTextArea1.setColumns(20);
        requirementsJTextArea1.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        requirementsJTextArea1.setForeground(new java.awt.Color(102, 0, 102));
        requirementsJTextArea1.setRows(5);
        jScrollPane4.setViewportView(requirementsJTextArea1);

        btnAssignToMe.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        btnAssignToMe.setForeground(new java.awt.Color(102, 0, 102));
        btnAssignToMe.setText("Assign to me");
        btnAssignToMe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignToMeActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 22)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(102, 0, 102));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("New Volunteer Requests");

        jLabel26.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(102, 0, 102));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel26.setText("Area:");

        areaJTextField.setEditable(false);
        areaJTextField.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        areaJTextField.setForeground(new java.awt.Color(102, 0, 102));

        javax.swing.GroupLayout TasksJPanelLayout = new javax.swing.GroupLayout(TasksJPanel);
        TasksJPanel.setLayout(TasksJPanelLayout);
        TasksJPanelLayout.setHorizontalGroup(
            TasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TasksJPanelLayout.createSequentialGroup()
                .addContainerGap(234, Short.MAX_VALUE)
                .addGroup(TasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(TasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(TasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(numberOfVolunteersJTextField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(numberOfHoursJTextField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(areaJTextField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tsVolTime, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(dtVolChoser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                        .addComponent(txtVolTitle, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtVolPlace, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(numberOfStudentsJTextField, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(439, 439, 439))
            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(TasksJPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(TasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAssignToMe)
                    .addGroup(TasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnNewRefresh)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        TasksJPanelLayout.setVerticalGroup(
            TasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TasksJPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel25)
                .addGap(10, 10, 10)
                .addComponent(btnNewRefresh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAssignToMe, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtVolTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(dtVolChoser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(tsVolTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtVolPlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(areaJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addGap(11, 11, 11)
                .addGroup(TasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numberOfStudentsJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numberOfHoursJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(numberOfVolunteersJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(256, Short.MAX_VALUE))
        );

        VolunteerJTabbedPane.addTab("New Tasks", TasksJPanel);

        DonateJPanel.setBackground(new java.awt.Color(255, 255, 255));
        DonateJPanel.setForeground(new java.awt.Color(102, 0, 102));
        DonateJPanel.setPreferredSize(new java.awt.Dimension(3043, 1021));

        txtQuantity.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        txtQuantity.setForeground(new java.awt.Color(102, 0, 102));

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
        jScrollPane5.setViewportView(tblDonateReq);

        btnAdd.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(102, 0, 102));
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(102, 0, 102));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnModify.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        btnModify.setForeground(new java.awt.Color(102, 0, 102));
        btnModify.setText("Modify");
        btnModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(102, 0, 102));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel29.setText("Pickup Address:");

        jLabel30.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(102, 0, 102));
        jLabel30.setText("Category:");

        jLabel31.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(102, 0, 102));
        jLabel31.setText("Quantity:");

        txtAddress.setColumns(20);
        txtAddress.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        txtAddress.setForeground(new java.awt.Color(102, 0, 102));
        txtAddress.setRows(5);
        jScrollPane6.setViewportView(txtAddress);

        btnDonate.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        btnDonate.setForeground(new java.awt.Color(102, 0, 102));
        btnDonate.setText("DONATE");
        btnDonate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDonateActionPerformed(evt);
            }
        });

        selCat.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        selCat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Books", "Toys", "Clothes", "Other" }));

        jLabel32.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(102, 0, 102));
        jLabel32.setText("Description:");

        txtDescription.setColumns(20);
        txtDescription.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        txtDescription.setForeground(new java.awt.Color(102, 0, 102));
        txtDescription.setRows(5);
        jScrollPane7.setViewportView(txtDescription);

        btnUpdate.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(102, 0, 102));
        btnUpdate.setText("Update");
        btnUpdate.setEnabled(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        txtNumber.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        txtNumber.setForeground(new java.awt.Color(102, 0, 102));

        jLabel33.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(102, 0, 102));
        jLabel33.setText("Mobile Number:");

        jLabel34.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 22)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(102, 0, 102));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Donate Work Requests");

        javax.swing.GroupLayout DonateJPanelLayout = new javax.swing.GroupLayout(DonateJPanel);
        DonateJPanel.setLayout(DonateJPanelLayout);
        DonateJPanelLayout.setHorizontalGroup(
            DonateJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DonateJPanelLayout.createSequentialGroup()
                .addGap(328, 328, 328)
                .addGroup(DonateJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DonateJPanelLayout.createSequentialGroup()
                        .addGroup(DonateJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel33)
                            .addComponent(jLabel29))
                        .addGap(18, 18, 18)
                        .addGroup(DonateJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDonate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(DonateJPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(DonateJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DonateJPanelLayout.createSequentialGroup()
                                .addGroup(DonateJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel32)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addGroup(DonateJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(selCat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(DonateJPanelLayout.createSequentialGroup()
                                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(btnModify, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(DonateJPanelLayout.createSequentialGroup()
                .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        DonateJPanelLayout.setVerticalGroup(
            DonateJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DonateJPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel34)
                .addGap(50, 50, 50)
                .addGroup(DonateJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(DonateJPanelLayout.createSequentialGroup()
                        .addGroup(DonateJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(selCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(DonateJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(DonateJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(DonateJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addComponent(btnModify, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addGroup(DonateJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(DonateJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(txtNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDonate, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(224, 224, 224))
        );

        VolunteerJTabbedPane.addTab("Donate", DonateJPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(VolunteerJTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1113, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(VolunteerJTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1005, Short.MAX_VALUE)
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

    private void numberOfHoursJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberOfHoursJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numberOfHoursJTextFieldActionPerformed

    private void tblNewVolListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNewVolListMouseClicked
        int selectedRow = tblNewVolList.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showConfirmDialog(null, "Make a row selection to view desired details.","Warning", JOptionPane.WARNING_MESSAGE);
        }
        else{
            TutorVolunteerWorkReq wr = (TutorVolunteerWorkReq) tblNewVolList.getValueAt(selectedRow, 0);
            txtVolTitle.setText(wr.getTitle());
            dtVolChoser.setDate(wr.getDate());

            Date time = null;
            String volTime = wr.getTime();
            SimpleDateFormat formatterDefault = new SimpleDateFormat("HH:mm");

            try {
                time = formatterDefault.parse(volTime);
            } catch (ParseException ex) {

            }

            tsVolTime.setValue(time);

            numberOfHoursJTextField.setText(wr.getNumOfhours());
            numberOfVolunteersJTextField.setText(String.valueOf(wr.getNumOfVolunteers()));
            requirementsJTextArea1.setText(wr.getMessage());
            txtVolPlace.setText(wr.getAddress());
            areaJTextField.setText(wr.getArea());
            numberOfStudentsJTextField.setText(String.valueOf(wr.getNumOfStudents()));

        }
    }//GEN-LAST:event_tblNewVolListMouseClicked

    private void btnNewRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewRefreshActionPerformed
        autoPopTbl();
    }//GEN-LAST:event_btnNewRefreshActionPerformed

    private void btnAssignToMeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignToMeActionPerformed

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

    }//GEN-LAST:event_btnAssignToMeActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:

        String description="";

        String quantityText = txtQuantity.getText();
        if(quantityText==null || quantityText.equals("")){
            JOptionPane.showMessageDialog(null,"Enter desired quantity");
            return;
        }

        try{
            Integer.parseInt(txtQuantity.getText());
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

        String category= (String) selCat.getSelectedItem();
        catlist.add(category);
        desclist.add(description);
        quantlist.add(quantity);
        autoPopDonate();

        txtQuantity.setText("");
        txtDescription.setText("");
        selCat.setSelectedIndex(0);

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
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
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblDonateReq.getSelectedRow();
        if(selectedRow>=0){

            String c=catlist.get(selectedRow);
            int q=quantlist.get(selectedRow);
            String d=desclist.get(selectedRow);
            selCat.setSelectedItem(c);
            txtQuantity.setText(String.valueOf(q));
            txtDescription.setText(d);
            btnAdd.setEnabled(false);
            btnModify.setEnabled(false);
            btnUpdate.setEnabled(true);
            tblDonateReq.setEnabled(false);
            btnDelete.setEnabled(false);
            btnDonate.setEnabled(false);
        }
        else{
            JOptionPane.showMessageDialog(null, "Make row selection", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnModifyActionPerformed

    private void btnDonateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDonateActionPerformed

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

        String contactNumber = txtNumber.getText();
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
        txtQuantity.setText("");
        txtDescription.setText("");
        selCat.setSelectedIndex(0);
    }//GEN-LAST:event_btnDonateActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblDonateReq.getSelectedRow();

        String description="";

        String quantityText = txtQuantity.getText();
        if(quantityText==null || quantityText.equals("")){
            JOptionPane.showMessageDialog(null,"Enter quantity.");
            return;
        }

        try{
            Integer.parseInt(txtQuantity.getText());
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

        String category= (String) selCat.getSelectedItem();

        catlist.set(selectedRow, category);
        quantlist.set(selectedRow, quantity);
        desclist.set(selectedRow, description);
        btnAdd.setEnabled(true);
        btnModify.setEnabled(true);
        btnUpdate.setEnabled(false);
        tblDonateReq.setEnabled(true);
        btnDelete.setEnabled(true);
        btnDonate.setEnabled(true);
        autoPopDonate();

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void VolunteerJTabbedPaneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_VolunteerJTabbedPaneStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_VolunteerJTabbedPaneStateChanged

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
    private javax.swing.JPanel DonateJPanel;
    private javax.swing.JPanel HomePageJPanel;
    private javax.swing.JPanel TasksJPanel;
    private javax.swing.JTabbedPane VolunteerJTabbedPane;
    private javax.swing.JTextField areaJTextField;
    private javax.swing.JTextField areaJTextField1;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAssignToMe;
    private javax.swing.JButton btnCancelReq;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDonate;
    private javax.swing.JButton btnHistory;
    private javax.swing.JButton btnModify;
    private javax.swing.JButton btnNewRefresh;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpdateDetail;
    private com.toedter.calendar.JDateChooser dtChoser;
    private com.toedter.calendar.JDateChooser dtVolChoser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel lblent;
    private javax.swing.JPanel leftJPanel;
    private javax.swing.JTextField numberOfHoursJTextField;
    private javax.swing.JTextField numberOfHoursJTextField1;
    private javax.swing.JTextField numberOfStudentsJTextField;
    private javax.swing.JTextField numberOfStudentsJTextField1;
    private javax.swing.JTextField numberOfVolunteersJTextField;
    private javax.swing.JTextField numberOfVolunteersJTextField1;
    private javax.swing.JTextArea requirementsJTextArea;
    private javax.swing.JTextArea requirementsJTextArea1;
    private javax.swing.JPanel rightJPanel;
    private javax.swing.JComboBox selCat;
    private javax.swing.JTable tblDonateReq;
    private javax.swing.JTable tblNewVolList;
    private javax.swing.JTable tblTaskAssigned;
    private javax.swing.JSpinner tsTime;
    private javax.swing.JSpinner tsVolTime;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNumber;
    private javax.swing.JTextField txtPhNo;
    private javax.swing.JTextField txtPlace;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtSex;
    private javax.swing.JTextField txtTitle;
    private javax.swing.JTextField txtVolPlace;
    private javax.swing.JTextField txtVolTitle;
    private javax.swing.JTextField txtname;
    // End of variables declaration//GEN-END:variables
}
