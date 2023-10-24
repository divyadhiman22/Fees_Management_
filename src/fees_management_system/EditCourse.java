/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fees_management_system;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
/**
 *
 * @author Divya
 */
public class EditCourse extends javax.swing.JFrame {

    /**
     * Creates new form EditCourse
     */
      DefaultTableModel model;
    public EditCourse() {
        initComponents();
        setRecordsToTable();
    }

    //method to showing the values in the table from the database
     public void setRecordsToTable(){
               try{
             Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
           Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/signupdata", "divya", "divya");
             String sql="select * from course";
           PreparedStatement pst=con.prepareStatement(sql);
          ResultSet rs=pst.executeQuery();
          while(rs.next()){
              String courseId=rs.getString("id");
              String courseName=rs.getString("cname");
              String cost=rs.getString("cost");
              
              Object[] obj={ courseId,courseName,cost};//this is a shortcut way to create array object
      model= (DefaultTableModel)tbl_CourseData.getModel();
      model.addRow(obj);
          }
         }
         catch(Exception e){
            e.printStackTrace();
         }
     }
     
     //METHOD OF ADDING A COURSE INTO A TABLE
     public void addCourse(int id, String cname,double cost){
          try{
             Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
           Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/signupdata", "divya", "divya");
             String sql="insert into course values (?,?,?)";
           PreparedStatement pst=con.prepareStatement(sql);
          pst.setInt(1, id);
          pst.setString(2,cname);
          pst.setDouble(3,cost);
          int rowCount=pst.executeUpdate();
          if(rowCount==1){
               JOptionPane.showMessageDialog(this, "Course Added Successfully.....");
               clearTable();
               setRecordsToTable();
          
          }
          else{
               JOptionPane.showMessageDialog(this, "Course Insertion Failed.....");
         }
          }
         catch(Exception e){
            e.printStackTrace();
         }
     }
     
//     Method for clearing the same double rows that are inserted into the table both when it is added to the database and when it is added by the add button
     public void clearTable(){
         DefaultTableModel model=(DefaultTableModel)tbl_CourseData.getModel();
         model.setRowCount(0);   
     }
     
     //method for updating the values on the table
     public void update(int id,String cname,double cost){
         try{
             Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
           Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/signupdata", "divya", "divya");
             String sql="update course set cname=? , cost=? where id=?";
           PreparedStatement pst=con.prepareStatement(sql);
          pst.setString(1,cname);
          pst.setDouble(2,cost);
          pst.setInt(3, id);
          int rowCount=pst.executeUpdate();
          if(rowCount==1){
               JOptionPane.showMessageDialog(this, "Course updated Successfully.....");
               clearTable();
               setRecordsToTable(); 
          }
          else{
               JOptionPane.showMessageDialog(this, "Course updation Failed.....");
         }
          }
         catch(Exception e){
            e.printStackTrace();
         }  
     }
     
     //method for deleting the selected row from the table
      public void delete(int id){
         try{
             Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
           Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/signupdata", "divya", "divya");
             String sql="delete from course  where id=?";
           PreparedStatement pst=con.prepareStatement(sql);
          
          pst.setInt(1, id);
          int rowCount=pst.executeUpdate();
          if(rowCount==1){
               JOptionPane.showMessageDialog(this, "Course deleted Successfully.....");
               clearTable();
               setRecordsToTable(); 
          }
          else{
               JOptionPane.showMessageDialog(this, "Course deletion Failed.....");
         }
          }
         catch(Exception e){
            e.printStackTrace();
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

        panelsideBar = new javax.swing.JPanel();
        panelHome = new javax.swing.JPanel();
        btnHome = new javax.swing.JLabel();
        panelSearch = new javax.swing.JPanel();
        btnSearch = new javax.swing.JLabel();
        panelEdit = new javax.swing.JPanel();
        btnEdit = new javax.swing.JLabel();
        panelRecord = new javax.swing.JPanel();
        btnRecord = new javax.swing.JLabel();
        panelBack = new javax.swing.JPanel();
        btnBack = new javax.swing.JLabel();
        panelLogout = new javax.swing.JPanel();
        btnLogout = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_CourseData = new javax.swing.JTable();
        txt_CourseId = new javax.swing.JTextField();
        txt_CoursePrice = new javax.swing.JTextField();
        txt_CourseName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelsideBar.setBackground(new java.awt.Color(51, 51, 51));
        panelsideBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelHome.setBackground(new java.awt.Color(153, 204, 255));
        panelHome.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

        btnHome.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnHome.setForeground(new java.awt.Color(255, 255, 255));
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/home.png"))); // NOI18N
        btnHome.setText("            HOME");
        btnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHomeMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelHomeLayout = new javax.swing.GroupLayout(panelHome);
        panelHome.setLayout(panelHomeLayout);
        panelHomeLayout.setHorizontalGroup(
            panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHomeLayout.createSequentialGroup()
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 28, Short.MAX_VALUE))
        );
        panelHomeLayout.setVerticalGroup(
            panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHomeLayout.createSequentialGroup()
                .addComponent(btnHome)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelsideBar.add(panelHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 280, 70));

        panelSearch.setBackground(new java.awt.Color(74, 124, 174));
        panelSearch.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

        btnSearch.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/search2.png"))); // NOI18N
        btnSearch.setText("   SEARCH RECORD");
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSearchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSearchMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelSearchLayout = new javax.swing.GroupLayout(panelSearch);
        panelSearch.setLayout(panelSearchLayout);
        panelSearchLayout.setHorizontalGroup(
            panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSearchLayout.createSequentialGroup()
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        panelSearchLayout.setVerticalGroup(
            panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSearchLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSearch))
        );

        panelsideBar.add(panelSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 280, 70));

        panelEdit.setBackground(new java.awt.Color(246, 167, 114));
        panelEdit.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

        btnEdit.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/edit2.png"))); // NOI18N
        btnEdit.setText("     EDIT COURSES");
        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelEditLayout = new javax.swing.GroupLayout(panelEdit);
        panelEdit.setLayout(panelEditLayout);
        panelEditLayout.setHorizontalGroup(
            panelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditLayout.createSequentialGroup()
                .addComponent(btnEdit)
                .addGap(0, 41, Short.MAX_VALUE))
        );
        panelEditLayout.setVerticalGroup(
            panelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditLayout.createSequentialGroup()
                .addComponent(btnEdit)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelsideBar.add(panelEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 280, 70));

        panelRecord.setBackground(new java.awt.Color(238, 73, 114));
        panelRecord.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

        btnRecord.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnRecord.setForeground(new java.awt.Color(255, 255, 255));
        btnRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/view all record.png"))); // NOI18N
        btnRecord.setText(" VIEW ALL RECORD");
        btnRecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRecordMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRecordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRecordMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelRecordLayout = new javax.swing.GroupLayout(panelRecord);
        panelRecord.setLayout(panelRecordLayout);
        panelRecordLayout.setHorizontalGroup(
            panelRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRecordLayout.createSequentialGroup()
                .addComponent(btnRecord)
                .addGap(0, 38, Short.MAX_VALUE))
        );
        panelRecordLayout.setVerticalGroup(
            panelRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRecordLayout.createSequentialGroup()
                .addComponent(btnRecord)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelsideBar.add(panelRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 280, 70));

        panelBack.setBackground(new java.awt.Color(153, 204, 0));
        panelBack.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

        btnBack.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/left-arrow.png"))); // NOI18N
        btnBack.setText("       BACK");
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBackMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelBackLayout = new javax.swing.GroupLayout(panelBack);
        panelBack.setLayout(panelBackLayout);
        panelBackLayout.setHorizontalGroup(
            panelBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackLayout.createSequentialGroup()
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 30, Short.MAX_VALUE))
        );
        panelBackLayout.setVerticalGroup(
            panelBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackLayout.createSequentialGroup()
                .addComponent(btnBack)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelsideBar.add(panelBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, -1, 70));

        panelLogout.setBackground(new java.awt.Color(153, 67, 153));
        panelLogout.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

        btnLogout.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/logout.png"))); // NOI18N
        btnLogout.setText("       LOGOUT");
        btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogoutMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelLogoutLayout = new javax.swing.GroupLayout(panelLogout);
        panelLogout.setLayout(panelLogoutLayout);
        panelLogoutLayout.setHorizontalGroup(
            panelLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLogoutLayout.createSequentialGroup()
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 30, Short.MAX_VALUE))
        );
        panelLogoutLayout.setVerticalGroup(
            panelLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLogoutLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnLogout))
        );

        panelsideBar.add(panelLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 540, 280, 70));

        getContentPane().add(panelsideBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, 370, 650));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_CourseData.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        tbl_CourseData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course Id", "Course Name", "Course Price"
            }
        ));
        tbl_CourseData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_CourseDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_CourseData);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(442, 50, 460, 560));

        txt_CourseId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_CourseId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CourseIdActionPerformed(evt);
            }
        });
        jPanel1.add(txt_CourseId, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 240, 30));

        txt_CoursePrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_CoursePrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CoursePriceActionPerformed(evt);
            }
        });
        jPanel1.add(txt_CoursePrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 240, 30));

        txt_CourseName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_CourseName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CourseNameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_CourseName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 240, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Course Price :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Course Name :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jButton1.setBackground(new java.awt.Color(74, 124, 174));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("DELETE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 380, 110, 40));

        jButton2.setBackground(new java.awt.Color(238, 73, 114));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("ADD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 110, 40));

        jButton3.setBackground(new java.awt.Color(153, 204, 0));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("UPDATE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, 110, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Course Id :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 290, 20));

        jLabel24.setFont(new java.awt.Font("Broadway", 1, 36)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 51));
        jLabel24.setText("EDIT COURSE ");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 290, 44));

        jLabel25.setFont(new java.awt.Font("Broadway", 1, 36)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 51));
        jLabel25.setText("DETAILS");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 210, 44));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 650));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseExited
        // TODO add your handling code here:
        Color clr=new Color(153,67,153);
        panelLogout.setBackground(clr);
    }//GEN-LAST:event_btnLogoutMouseExited

    private void btnLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseEntered
        // TODO add your handling code here:
        Color clr=new Color(102,0,102);
        panelLogout.setBackground(clr);
    }//GEN-LAST:event_btnLogoutMouseEntered

    private void btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseClicked

        // TODO add your handling code here:
        Signup_Page sign=new Signup_Page();
        sign.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogoutMouseClicked

    private void btnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseExited
        // TODO add your handling code here:
        Color clr=new Color(153,204,0);
        panelBack.setBackground(clr);
    }//GEN-LAST:event_btnBackMouseExited

    private void btnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseEntered
        // TODO add your handling code here:
        Color clr=new Color(120,159,5);
        panelBack.setBackground(clr);
    }//GEN-LAST:event_btnBackMouseEntered

    private void btnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseClicked
        // TODO add your handling code here:
        SearchRecord search=new SearchRecord();
        search.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackMouseClicked

    private void btnRecordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRecordMouseExited
        // TODO add your handling code here:
        Color clr=new Color(238,73,114);
        panelRecord.setBackground(clr);
    }//GEN-LAST:event_btnRecordMouseExited

    private void btnRecordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRecordMouseEntered
        // TODO add your handling code here:
        Color clr=new Color(204,0,102);
        panelRecord.setBackground(clr);
    }//GEN-LAST:event_btnRecordMouseEntered

    private void btnEditMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseExited
        // TODO add your handling code here:
        Color clr=new Color(246,167,114);
        panelEdit.setBackground(clr);
    }//GEN-LAST:event_btnEditMouseExited

    private void btnEditMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseEntered
        // TODO add your handling code here:
        Color clr=new Color(255,102,51);
        panelEdit.setBackground(clr);
    }//GEN-LAST:event_btnEditMouseEntered

    private void btnSearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseExited
        // TODO add your handling code here:
        Color clr=new Color(74,124,174);
        panelSearch.setBackground(clr);
    }//GEN-LAST:event_btnSearchMouseExited

    private void btnSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseEntered
        // TODO add your handling code here:
        Color clr=new Color(8,82,119);
        panelSearch.setBackground(clr);
    }//GEN-LAST:event_btnSearchMouseEntered

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        // TODO add your handling code here:
        SearchRecord search=new SearchRecord();
        search.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSearchMouseClicked

    private void btnHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseExited
        // TODO add your handling code here:
        Color clr=new Color(153,204,255);
        panelHome.setBackground(clr);
    }//GEN-LAST:event_btnHomeMouseExited

    private void btnHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseEntered
        // TODO add your handling code here:
        Color clr=new Color(51,153,255);
        panelHome.setBackground(clr);
    }//GEN-LAST:event_btnHomeMouseEntered

    private void btnHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseClicked
        // TODO add your handling code here:
        home h=new home();
        h.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHomeMouseClicked

    private void txt_CourseIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CourseIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CourseIdActionPerformed

    private void txt_CoursePriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CoursePriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CoursePriceActionPerformed

    private void txt_CourseNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CourseNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CourseNameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         int id=Integer.parseInt(txt_CourseId.getText());
         delete(id);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int id=Integer.parseInt(txt_CourseId.getText());
        String cname=txt_CourseName.getText();
        double cost=Double.parseDouble(txt_CoursePrice.getText());
        addCourse( id,  cname, cost);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int id=Integer.parseInt(txt_CourseId.getText());
        String cname=txt_CourseName.getText();
        double cost=Double.parseDouble(txt_CoursePrice.getText());
        update( id, cname, cost);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tbl_CourseDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_CourseDataMouseClicked
        // TODO add your handling code here:
        int row=tbl_CourseData.getSelectedRow();
        TableModel model=tbl_CourseData.getModel();
        txt_CourseId.setText(model.getValueAt(row,0).toString());
         txt_CourseName.setText(model.getValueAt(row,1).toString());
          txt_CoursePrice.setText(model.getValueAt(row,2).toString());
    }//GEN-LAST:event_tbl_CourseDataMouseClicked

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
        // TODO add your handling code here:
        EditCourse edit=new EditCourse();
        edit.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnEditMouseClicked

    private void btnRecordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRecordMouseClicked
        // TODO add your handling code here:
         ViewAllRecord view=new ViewAllRecord();
        view.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRecordMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditCourse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBack;
    private javax.swing.JLabel btnEdit;
    private javax.swing.JLabel btnHome;
    private javax.swing.JLabel btnLogout;
    private javax.swing.JLabel btnRecord;
    private javax.swing.JLabel btnSearch;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panelBack;
    private javax.swing.JPanel panelEdit;
    private javax.swing.JPanel panelHome;
    private javax.swing.JPanel panelLogout;
    private javax.swing.JPanel panelRecord;
    private javax.swing.JPanel panelSearch;
    private javax.swing.JPanel panelsideBar;
    private javax.swing.JTable tbl_CourseData;
    private javax.swing.JTextField txt_CourseId;
    private javax.swing.JTextField txt_CourseName;
    private javax.swing.JTextField txt_CoursePrice;
    // End of variables declaration//GEN-END:variables
}
