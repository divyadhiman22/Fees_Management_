 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fees_management_system;

import java.awt.Color;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Divya
 */
public class AddFees extends javax.swing.JFrame {
 DefaultTableModel model;
    /**
     * Creates new form AddFees
     */
    public AddFees() {
        initComponents();
        displayCashFirst();
        fillComboBox();
        int recieptNo= getRecieptNo();
        txt_Reciept.setText(Integer.toString(recieptNo));
    }
    public void displayCashFirst(){
        lbl_DD.setVisible(false);
        lbl_Cheque.setVisible(false);
        lbl_Bank.setVisible(false);
            txt_DD.setVisible(false);
            txt_Cheque.setVisible(false);
            txt_Bank.setVisible(false);
    }

    
    public boolean validation(){
       if(txt_Roll.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Please enter Roll Number");
                return false;
        }
       
       //for combobox selections
       //for cheque
      if(combo_Payment.getSelectedItem().toString().equalsIgnoreCase("cheque")){
        if(txt_Cheque.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Please enter Cheque number");
                return false; 
        }  
         if(txt_Bank.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Please enter Bank name");
                return false; 
        } 
      }
      //for DD
       if(combo_Payment.getSelectedItem().toString().equalsIgnoreCase("DD")){
        if(txt_DD.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Please enter  number");
                return false; 
        }  
         if(txt_Bank.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Please enter Bank name");
                return false; 
        } 
      }
       //for card
         if(combo_Payment.getSelectedItem().toString().equalsIgnoreCase("Card")){ 
         if(txt_Bank.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Please enter Bank name");
                return false; 
        } 
      }
           //for checking username
        if(txt_Recieved.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Please enter user name");
                return false;
        }
//       for checking amount
         if(txt_Amount.getText().equals("")|| txt_Amount.getText().matches("[0-9]+")==false){
                JOptionPane.showMessageDialog(this, "Please enter Amount(in numbers)");
                return false;
        }
        return true;
    }
    
    public void fillComboBox(){
       try{
          Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
          Connection con= DriverManager.getConnection("jdbc:derby://localhost:1527/signupdata","divya","divya");
          System.out.println(con.getClass().getName());
           PreparedStatement pst=con.prepareStatement("select cname from course");
           ResultSet rs=pst.executeQuery();
           while(rs.next()){
              combo_Course.addItem(rs.getString("cname"));
           }
       } 
       catch(Exception e){
           e.printStackTrace();
       }
           
    }
    //function for making recieptno autogenerate
    public int getRecieptNo(){
        int recieptNo=0;
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
          Connection con= DriverManager.getConnection("jdbc:derby://localhost:1527/signupdata","divya","divya");
            PreparedStatement pst=con.prepareStatement("select max(reciept_no) from fees_Details");
             ResultSet rs=pst.executeQuery();
             if(rs.next()==true){
               recieptNo=  rs.getInt(1);               
             }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return recieptNo+1;
    }
    //function for inserting data into the database entered by the user
    public String insertData(){
        String status="";
        
       int recieptNo=Integer.parseInt(txt_Reciept.getText());
       String studentName=txt_Recieved.getText();
        String rollNo=txt_Roll.getText();
        String paymentMode=combo_Payment.getSelectedItem().toString();
          String chequeNo=txt_Cheque.getText();
            String bankName=txt_Bank.getText();
              String DD=txt_DD.getText();
              String courseName=txt_CourseHead.getText();
              float totalAmount=Float.parseFloat(txt_Total.getText());   
              
              float amount=Float.parseFloat(txt_Amount.getText());
              float cgst=Float.parseFloat(txt_Cgst.getText());
              float sgst=Float.parseFloat(txt_Sgst.getText());
              String totalInWords=txt_Words.getText();
              String remark=txt_Remarks.getText();
              int year1=Integer.parseInt(txt_Year1.getText());
               int year2=Integer.parseInt(txt_Year2.getText());
               try{
                   Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
          Connection con= DriverManager.getConnection("jdbc:derby://localhost:1527/signupdata","divya","divya"); 
            PreparedStatement pst=con.prepareStatement("insert into fees_details values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, recieptNo);
            pst.setString(2, studentName);
               pst.setString(3, rollNo);
                pst.setString(4, paymentMode);
                 pst.setString(5, chequeNo);
                  pst.setString(6, bankName);
                   pst.setString(7, DD);
                    pst.setString(8, courseName);
                        pst.setFloat(9, totalAmount);
            pst.setFloat(10,  amount);
            pst.setFloat(11, cgst);
            pst.setFloat(12,   sgst);
            pst.setString(13,  totalInWords);
             pst.setString(14,  remark);
             pst.setInt(15,  year1);
              pst.setInt(16, year2);
             int rowCount= pst.executeUpdate();
              if(rowCount==1){
                  status="success";
              }
              else{
                  status="failed";
              }
               }
               catch(Exception e){
                   e.printStackTrace();
               }
               return status;
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
        panelParent = new javax.swing.JPanel();
        lbl_Cheque = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_DD = new javax.swing.JLabel();
        txt_Reciept = new javax.swing.JTextField();
        txt_Cheque = new javax.swing.JTextField();
        panelChild = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_Recieved = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_Year1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        combo_Course = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txt_Amount = new javax.swing.JTextField();
        txt_Cgst = new javax.swing.JTextField();
        txt_CourseHead = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        txt_Sgst = new javax.swing.JTextField();
        txt_Total = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_Remarks = new javax.swing.JTextArea();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        btn_Print = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txt_Roll = new javax.swing.JTextField();
        txt_Year2 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txt_Words = new javax.swing.JTextField();
        lbl_Bank = new javax.swing.JLabel();
        combo_Payment = new javax.swing.JComboBox<>();
        txt_Bank = new javax.swing.JTextField();
        txt_DD = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();

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
                .addContainerGap()
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        panelHomeLayout.setVerticalGroup(
            panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHome)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelsideBar.add(panelHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 280, 80));

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
                .addContainerGap()
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        panelSearchLayout.setVerticalGroup(
            panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSearchLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSearch)
                .addGap(14, 14, 14))
        );

        panelsideBar.add(panelSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, 80));

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
                .addGap(19, 19, 19)
                .addComponent(btnEdit)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        panelEditLayout.setVerticalGroup(
            panelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEditLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEdit)
                .addGap(14, 14, 14))
        );

        panelsideBar.add(panelEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 280, 80));

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
                .addGap(15, 15, 15)
                .addComponent(btnRecord)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        panelRecordLayout.setVerticalGroup(
            panelRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRecordLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRecord)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelsideBar.add(panelRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, -1, 80));

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
                .addGap(15, 15, 15)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        panelBackLayout.setVerticalGroup(
            panelBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelsideBar.add(panelBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, -1, 80));

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
                .addGap(15, 15, 15)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        panelLogoutLayout.setVerticalGroup(
            panelLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLogoutLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogout)
                .addGap(14, 14, 14))
        );

        panelsideBar.add(panelLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 540, 280, 80));

        getContentPane().add(panelsideBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 650));

        panelParent.setBackground(new java.awt.Color(204, 204, 255));
        panelParent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_Cheque.setFont(new java.awt.Font("Sanskrit Text", 1, 14)); // NOI18N
        lbl_Cheque.setText("Cheque no :");
        panelParent.add(lbl_Cheque, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel2.setFont(new java.awt.Font("Sanskrit Text", 1, 14)); // NOI18N
        jLabel2.setText("Reciept no :");
        panelParent.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabel3.setFont(new java.awt.Font("Sanskrit Text", 1, 14)); // NOI18N
        jLabel3.setText("Mode of payment :");
        panelParent.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        lbl_DD.setFont(new java.awt.Font("Sanskrit Text", 1, 14)); // NOI18N
        lbl_DD.setText("DD no :");
        panelParent.add(lbl_DD, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        txt_Reciept.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_Reciept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_RecieptActionPerformed(evt);
            }
        });
        panelParent.add(txt_Reciept, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 240, -1));

        txt_Cheque.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_Cheque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ChequeActionPerformed(evt);
            }
        });
        panelParent.add(txt_Cheque, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 240, -1));

        panelChild.setBackground(new java.awt.Color(204, 204, 255));
        panelChild.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Sanskrit Text", 1, 14)); // NOI18N
        jLabel6.setText("Payment for the Year :");
        panelChild.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 43, -1, 30));

        jLabel11.setFont(new java.awt.Font("Sanskrit Text", 1, 14)); // NOI18N
        jLabel11.setText("Roll no :");
        panelChild.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, -1, -1));

        txt_Recieved.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_Recieved.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_RecievedActionPerformed(evt);
            }
        });
        panelChild.add(txt_Recieved, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 240, -1));

        jLabel10.setFont(new java.awt.Font("Sanskrit Text", 1, 14)); // NOI18N
        jLabel10.setText("to");
        panelChild.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, -1, 20));

        txt_Year1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_Year1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Year1ActionPerformed(evt);
            }
        });
        panelChild.add(txt_Year1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 140, -1));

        jLabel13.setFont(new java.awt.Font("Sanskrit Text", 1, 14)); // NOI18N
        jLabel13.setText("Amount:");
        panelChild.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 130, -1, -1));

        jLabel14.setFont(new java.awt.Font("Sanskrit Text", 1, 14)); // NOI18N
        jLabel14.setText("Recieved From :");
        panelChild.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        combo_Course.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        combo_Course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_CourseActionPerformed(evt);
            }
        });
        panelChild.add(combo_Course, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 240, -1));
        panelChild.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 340, 260, 10));
        panelChild.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 800, 10));

        jLabel15.setFont(new java.awt.Font("Sanskrit Text", 1, 14)); // NOI18N
        jLabel15.setText("SGST : 9%");
        panelChild.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, -1, -1));

        jLabel16.setFont(new java.awt.Font("Sanskrit Text", 1, 14)); // NOI18N
        jLabel16.setText("Reciever Signature :");
        panelChild.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 360, -1, 30));

        jLabel17.setFont(new java.awt.Font("Sanskrit Text", 1, 14)); // NOI18N
        jLabel17.setText("Head :");
        panelChild.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, -1, -1));

        txt_Amount.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_Amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_AmountActionPerformed(evt);
            }
        });
        panelChild.add(txt_Amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 160, 240, -1));

        txt_Cgst.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_Cgst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CgstActionPerformed(evt);
            }
        });
        panelChild.add(txt_Cgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 200, 240, -1));

        txt_CourseHead.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_CourseHead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CourseHeadActionPerformed(evt);
            }
        });
        panelChild.add(txt_CourseHead, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 290, -1));
        panelChild.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 800, 10));

        txt_Sgst.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_Sgst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_SgstActionPerformed(evt);
            }
        });
        panelChild.add(txt_Sgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 240, 240, -1));

        txt_Total.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_Total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TotalActionPerformed(evt);
            }
        });
        panelChild.add(txt_Total, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 290, 240, -1));

        jLabel19.setFont(new java.awt.Font("Sanskrit Text", 1, 14)); // NOI18N
        jLabel19.setText("Sr No :");
        panelChild.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        txt_Remarks.setColumns(20);
        txt_Remarks.setRows(5);
        jScrollPane1.setViewportView(txt_Remarks);

        panelChild.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, 290, 80));
        panelChild.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 280, 260, 10));

        jLabel20.setFont(new java.awt.Font("Sanskrit Text", 1, 14)); // NOI18N
        jLabel20.setText("Total in words :");
        panelChild.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, 30));

        btn_Print.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        btn_Print.setText("Print");
        btn_Print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PrintActionPerformed(evt);
            }
        });
        panelChild.add(btn_Print, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 390, 90, -1));

        jLabel21.setFont(new java.awt.Font("Sanskrit Text", 1, 14)); // NOI18N
        jLabel21.setText("Course :");
        panelChild.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel22.setFont(new java.awt.Font("Sanskrit Text", 1, 14)); // NOI18N
        jLabel22.setText("CGST : 9%");
        panelChild.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, -1, 30));

        txt_Roll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_RollActionPerformed(evt);
            }
        });
        panelChild.add(txt_Roll, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 62, 140, 30));

        txt_Year2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_Year2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Year2ActionPerformed(evt);
            }
        });
        panelChild.add(txt_Year2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, 140, -1));

        jLabel25.setFont(new java.awt.Font("Sanskrit Text", 1, 14)); // NOI18N
        jLabel25.setText("Remark :");
        panelChild.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, -1));

        txt_Words.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_Words.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_WordsActionPerformed(evt);
            }
        });
        panelChild.add(txt_Words, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, 290, -1));

        panelParent.add(panelChild, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 880, 460));

        lbl_Bank.setFont(new java.awt.Font("Sanskrit Text", 1, 14)); // NOI18N
        lbl_Bank.setText("Bank Name :");
        panelParent.add(lbl_Bank, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        combo_Payment.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        combo_Payment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DD", "Cheque", "Cash", "Card", " ", " " }));
        combo_Payment.setSelectedIndex(2);
        combo_Payment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_PaymentActionPerformed(evt);
            }
        });
        panelParent.add(combo_Payment, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 240, -1));

        txt_Bank.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_Bank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_BankActionPerformed(evt);
            }
        });
        panelParent.add(txt_Bank, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 240, -1));

        txt_DD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_DD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_DDActionPerformed(evt);
            }
        });
        panelParent.add(txt_DD, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 240, -1));

        jSeparator5.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));
        panelParent.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 130, 220, 10));

        jLabel12.setFont(new java.awt.Font("Broadway", 1, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("LOGIN");
        panelParent.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 410, 163, 44));

        jLabel23.setFont(new java.awt.Font("Broadway", 1, 36)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("LOGIN");
        panelParent.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 410, 163, 44));

        jLabel24.setFont(new java.awt.Font("Broadway", 1, 36)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("ADD FEES");
        panelParent.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, 210, 44));

        getContentPane().add(panelParent, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 880, 650));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseEntered
        // TODO add your handling code here:
        Color clr=new Color(51,153,255);
        panelHome.setBackground(clr);
    }//GEN-LAST:event_btnHomeMouseEntered

    private void btnHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseExited
        // TODO add your handling code here:
         Color clr=new Color(153,204,255);
        panelHome.setBackground(clr);
    }//GEN-LAST:event_btnHomeMouseExited

    private void btnLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseEntered
        // TODO add your handling code here:
         Color clr=new Color(102,0,102);
        panelLogout.setBackground(clr);
    }//GEN-LAST:event_btnLogoutMouseEntered

    private void btnLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseExited
        // TODO add your handling code here:
          Color clr=new Color(153,67,153);
        panelLogout.setBackground(clr);
    }//GEN-LAST:event_btnLogoutMouseExited

    private void btnSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseEntered
        // TODO add your handling code here:
         Color clr=new Color(8,82,119);
        panelSearch.setBackground(clr);
        
    }//GEN-LAST:event_btnSearchMouseEntered

    private void btnSearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseExited
        // TODO add your handling code here:
          Color clr=new Color(74,124,174);
        panelSearch.setBackground(clr);
    }//GEN-LAST:event_btnSearchMouseExited

    private void btnEditMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseEntered
        // TODO add your handling code here:
         Color clr=new Color(255,102,51);
        panelEdit.setBackground(clr);
    }//GEN-LAST:event_btnEditMouseEntered

    private void btnEditMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseExited
        // TODO add your handling code here:
          Color clr=new Color(246,167,114);
        panelEdit.setBackground(clr);
    }//GEN-LAST:event_btnEditMouseExited

    private void btnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseEntered
        // TODO add your handling code here:
         Color clr=new Color(120,159,5);
        panelBack.setBackground(clr);
    }//GEN-LAST:event_btnBackMouseEntered

    private void btnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseExited
        // TODO add your handling code here:
          Color clr=new Color(153,204,0);
        panelBack.setBackground(clr);
    }//GEN-LAST:event_btnBackMouseExited

    private void btnRecordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRecordMouseEntered
        // TODO add your handling code here:
         Color clr=new Color(204,0,102);
        panelRecord.setBackground(clr);
    }//GEN-LAST:event_btnRecordMouseEntered

    private void btnRecordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRecordMouseExited
        // TODO add your handling code here:
          Color clr=new Color(238,73,114);
        panelRecord.setBackground(clr);
    }//GEN-LAST:event_btnRecordMouseExited

    private void txt_AmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_AmountActionPerformed
        // for calculating the total amount by adding both the gst
        float amnt= Float.parseFloat(txt_Amount.getText());
        Float cgst=(float)(amnt * 0.09 );
        Float sgst=(float)(amnt * 0.09 );
        txt_Cgst.setText(cgst.toString());
           txt_Sgst.setText(sgst.toString());
           float total=amnt+cgst+sgst;
           txt_Total.setText(Float.toString(total));
           
          
           
           //for converting the total amount in words
          txt_Words.setText(NumberToWordConverter.convert((int)total)+ " only");
    }//GEN-LAST:event_txt_AmountActionPerformed

    private void txt_RecieptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_RecieptActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_RecieptActionPerformed

    private void txt_ChequeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ChequeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ChequeActionPerformed

    private void combo_CourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_CourseActionPerformed
        // TODO add your handling code here:
        txt_CourseHead.setText(combo_Course.getSelectedItem().toString());
    }//GEN-LAST:event_combo_CourseActionPerformed

    private void txt_RecievedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_RecievedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_RecievedActionPerformed

    private void txt_Year1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Year1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Year1ActionPerformed

    private void combo_PaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_PaymentActionPerformed
        // TODO add your handling code here:
        if(combo_Payment.getSelectedIndex()==0){
              lbl_DD.setVisible(true);
              txt_DD.setVisible(true);
              lbl_Cheque.setVisible(false);
              txt_Cheque.setVisible(false);
                lbl_Bank.setVisible(true);
                  txt_Bank.setVisible(true); 
        }
         if(combo_Payment.getSelectedIndex()==1){
              lbl_DD.setVisible(false);
              txt_DD.setVisible(false);
              lbl_Cheque.setVisible(true);
              txt_Cheque.setVisible(true);
                lbl_Bank.setVisible(true);
                  txt_Bank.setVisible(true); 
        }
          if(combo_Payment.getSelectedIndex()==2){
              lbl_DD.setVisible(false);
              txt_DD.setVisible(false);
              lbl_Cheque.setVisible(false);
              txt_Cheque.setVisible(false);
                lbl_Bank.setVisible(false);
                  txt_Bank.setVisible(false); 
        }
           if(combo_Payment.getSelectedIndex()==3){
              lbl_DD.setVisible(false);
              txt_DD.setVisible(false);
              lbl_Cheque.setVisible(false);
              txt_Cheque.setVisible(false);
                lbl_Bank.setVisible(true);
                  txt_Bank.setVisible(true); 
        }
    }//GEN-LAST:event_combo_PaymentActionPerformed

    private void txt_BankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_BankActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BankActionPerformed

    private void txt_CgstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CgstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CgstActionPerformed

    private void txt_CourseHeadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CourseHeadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CourseHeadActionPerformed

    private void txt_SgstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_SgstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SgstActionPerformed

    private void txt_TotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TotalActionPerformed

    private void btn_PrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PrintActionPerformed
        // TODO add your handling code here:
        if(validation()==true){
               String result= insertData();
               if(result.equals("success")){
                 JOptionPane.showMessageDialog(this, "Record inserted successfully......"); 
                 PrintReciept p=new PrintReciept();
                 p.setVisible(true);
                 this.dispose();
               }
               else{
                    JOptionPane.showMessageDialog(this, "Record insertion failed!!!!!");
               }
        }
        
    }//GEN-LAST:event_btn_PrintActionPerformed

    private void txt_DDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_DDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_DDActionPerformed

    private void txt_RollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_RollActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_RollActionPerformed

    private void txt_Year2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Year2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Year2ActionPerformed

    private void btnHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseClicked
        // TODO add your handling code here:
        home h=new home();
        h.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHomeMouseClicked

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        // TODO add your handling code here:
        SearchRecord search=new SearchRecord();
        search.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSearchMouseClicked

    private void btnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseClicked
        // TODO add your handling code here:
         home h=new home();
        h.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackMouseClicked

    private void btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseClicked
        // TODO add your handling code here:
        Signup_Page sign=new Signup_Page();
        sign.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogoutMouseClicked

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

    private void txt_WordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_WordsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_WordsActionPerformed

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
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddFees().setVisible(true);
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
    private javax.swing.JButton btn_Print;
    private javax.swing.JComboBox<String> combo_Course;
    private javax.swing.JComboBox<String> combo_Payment;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lbl_Bank;
    private javax.swing.JLabel lbl_Cheque;
    private javax.swing.JLabel lbl_DD;
    private javax.swing.JPanel panelBack;
    private javax.swing.JPanel panelChild;
    private javax.swing.JPanel panelEdit;
    private javax.swing.JPanel panelHome;
    private javax.swing.JPanel panelLogout;
    private javax.swing.JPanel panelParent;
    private javax.swing.JPanel panelRecord;
    private javax.swing.JPanel panelSearch;
    private javax.swing.JPanel panelsideBar;
    private javax.swing.JTextField txt_Amount;
    private javax.swing.JTextField txt_Bank;
    private javax.swing.JTextField txt_Cgst;
    private javax.swing.JTextField txt_Cheque;
    private javax.swing.JTextField txt_CourseHead;
    private javax.swing.JTextField txt_DD;
    private javax.swing.JTextField txt_Reciept;
    private javax.swing.JTextField txt_Recieved;
    private javax.swing.JTextArea txt_Remarks;
    private javax.swing.JTextField txt_Roll;
    private javax.swing.JTextField txt_Sgst;
    private javax.swing.JTextField txt_Total;
    private javax.swing.JTextField txt_Words;
    private javax.swing.JTextField txt_Year1;
    private javax.swing.JTextField txt_Year2;
    // End of variables declaration//GEN-END:variables
}
