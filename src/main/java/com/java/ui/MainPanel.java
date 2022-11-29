/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.java.ui;

import com.java.dbconn.DbConnectionBSE;
import com.java.dbconn.DbConnectionNSE;
import com.java.dbconn.DbConnectionNYSE;
import com.java.sebprofiles.SEBProfileClass;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import com.java.stocks.BSEClass;
import com.java.stocks.NSEClass;
import com.java.stocks.NYSEClass;
import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
/**
 *
 * @author rajmehta
 */
public class MainPanel extends javax.swing.JFrame {

    /**
     * Creates new form MainPanel
     */
    
    List<Integer> down = new ArrayList<>();
    Object[] aplStk = new Object[12]; 
    int loginId = 0;
    String loginName ="";
    String loginRegion = "";
    double loginFunds=0;
    
    public MainPanel(){
        initComponents();
        
        loginPage_ui.setVisible(true);
//        
//        //UI Elements
//        DefaultTableModel BSETableModel = (DefaultTableModel) BSETable.getModel();
//        DefaultTableModel NSETableModel = (DefaultTableModel) NSETable.getModel();
//        DefaultTableModel NYSETableModel = (DefaultTableModel) NYSETable.getModel();
//        
//        //Variables
//        
//        
//        //Objects
//        SEBProfileClass sebverify = new SEBProfileClass();
////       
////        //BSE Populate Table
//
//        //TABLE CUSTOMISE CODE
//        NYSETable.setDefaultRenderer(Object.class, new MonCellRenderer());
//        try{
//            ArrayList<BSEClass> allBSEStocks  = DbConnectionBSE.readBSETable();
//            BSETableModel.setRowCount(0);
//            int i =0;
//            for(BSEClass stock: allBSEStocks){
//                Object[] row = new Object[12];
//
//                row[0] = stock.getStocktag();
//                row[1] = stock.getStockname();
//                row[2] = stock.getDate();
//                row[3] = stock.getType();
//                row[4] = stock.getStockprice();
//                row[5] = stock.getChangerate();
//                row[6] = stock.getCurency();
//                row[7] = stock.getBid();
//                row[8] = stock.getDayhigh();
//                row[9] = stock.getDaylow();
//                row[10] = stock.getLastfetched();
//                row[11] = stock.getPrevprice();
//                
//                BSETableModel.addRow(row);
//                
//                if(stock.getStockprice() < stock.getPrevprice()){
//                    down.add(i);
//                }
//                
//                i++;
//            }
//        }catch(Exception e){e.printStackTrace();}
//        
//        //NSE Populate Table
//        try{
//            down = new ArrayList<>();
//            ArrayList<NSEClass> allNSEStocks  = DbConnectionNSE.readNSETable();
//            NSETableModel.setRowCount(0);
//            int i =0;
//            for(NSEClass stock: allNSEStocks){
//                Object[] row = new Object[12];
//
//                row[0] = stock.getStocktag();
//                row[1] = stock.getStockname();
//                row[2] = stock.getDate();
//                row[3] = stock.getType();
//                row[4] = stock.getStockprice();
//                row[5] = stock.getChangerate();
//                row[6] = stock.getCurency();
//                row[7] = stock.getBid();
//                row[8] = stock.getDayhigh();
//                row[9] = stock.getDaylow();
//                row[10] = stock.getLastfetched();
//                row[11] = stock.getPrevprice();
//                
//                NSETableModel.addRow(row);
//                
//                if(stock.getStockprice() < stock.getPrevprice()){
//                    down.add(i);
//                }
//                
//                i++;
//            }
//        }catch(Exception e){e.printStackTrace();}
//        
//        //NYSE Populate Table
//        try{
//            ArrayList<NYSEClass> allNYSEStocks  = DbConnectionNYSE.readNYSETable();
//            NYSETableModel.setRowCount(0);
//            int i =0;
//            for(NYSEClass stock: allNYSEStocks){
//                Object[] row = new Object[12];
//
//                row[0] = stock.getStocktag();
//                row[1] = stock.getStockname();
//                row[2] = stock.getDate();
//                row[3] = stock.getType();
//                row[4] = stock.getStockprice();
//                row[5] = stock.getChangerate();
//                row[6] = stock.getCurency();
//                row[7] = stock.getBid();
//                row[8] = stock.getDayhigh();
//                row[9] = stock.getDaylow();
//                row[10] = stock.getLastfetched();
//                row[11] = stock.getPrevprice();
//                
//                NYSETableModel.addRow(row);
//                
//                if(stock.getStockprice() < stock.getPrevprice()){
//                    down.add(i);
//                }
//                
//                
//                System.out.println(stock.getStocktag());
//                if(String.valueOf(stock.getStocktag()).equals("AAPL")){
//                    aplStk = row;
//                }
//                
//                i++;
//            }
//        }catch(Exception e){e.printStackTrace();}
//        
//        //verify is SEBProfile Exist
//        try{
//            Object[] loginProfileSEB = (Object[]) sebverify.verifySEBProfile(185047);
//            sebverify.banUser(1);
//            JOptionPane.showMessageDialog(this, loginProfileSEB[1] + " "+ loginProfileSEB[2]+ " "+ loginProfileSEB[3]);
//        }catch(Exception e){e.printStackTrace();}
        
        //AcceptIPO
//        try{
//            SEBProfileClass obj = new SEBProfileClass();
//            obj.approveIPO("AAPL", aplStk, "NYSE", 2000);
//        }catch(Exception e){e.printStackTrace();}
// 
//        //Reject IPO
//        try{
//            SEBProfileClass obj = new SEBProfileClass();
//            obj.rejectIPO("Apple");
//        }catch(Exception e){e.printStackTrace();}
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginPage_ui = new javax.swing.JPanel();
        idLogin_ui = new javax.swing.JTextField();
        passLogin_ui = new javax.swing.JTextField();
        login_ui = new javax.swing.JButton();
        signin_ui = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        signinPage_ui = new javax.swing.JPanel();
        nameSignin_ui = new javax.swing.JTextField();
        passSignin_ui = new javax.swing.JTextField();
        regionSignin_ui = new javax.swing.JComboBox<>();
        typeSignin_ui = new javax.swing.JComboBox<>();
        signinSignin_ui = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        backSignin_ui = new javax.swing.JButton();
        profileLink_ui = new javax.swing.JPanel();
        splitPane = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        loginName_ui = new javax.swing.JTextField();
        proceedMain_ui = new javax.swing.JButton();
        profileMain_ui = new javax.swing.JPanel();
        moreLoginPages_ui = new javax.swing.JPanel();
        splitPane1 = new javax.swing.JSplitPane();
        jPanel2 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        passLogin_ui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passLogin_uiActionPerformed(evt);
            }
        });

        login_ui.setText("Sign In");
        login_ui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_uiActionPerformed(evt);
            }
        });

        signin_ui.setText("Sign Up");
        signin_ui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signin_uiActionPerformed(evt);
            }
        });

        jLabel1.setText("Id:");

        jLabel2.setText("Password:");

        jButton1.setText("More Login Options");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loginPage_uiLayout = new javax.swing.GroupLayout(loginPage_ui);
        loginPage_ui.setLayout(loginPage_uiLayout);
        loginPage_uiLayout.setHorizontalGroup(
            loginPage_uiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPage_uiLayout.createSequentialGroup()
                .addGap(293, 293, 293)
                .addGroup(loginPage_uiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(loginPage_uiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(passLogin_ui)
                    .addGroup(loginPage_uiLayout.createSequentialGroup()
                        .addComponent(login_ui)
                        .addGap(18, 18, 18)
                        .addComponent(signin_ui))
                    .addComponent(idLogin_ui))
                .addContainerGap(431, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPage_uiLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(48, 48, 48))
        );
        loginPage_uiLayout.setVerticalGroup(
            loginPage_uiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPage_uiLayout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addGroup(loginPage_uiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLogin_ui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(31, 31, 31)
                .addGroup(loginPage_uiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passLogin_ui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(31, 31, 31)
                .addGroup(loginPage_uiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(login_ui)
                    .addComponent(signin_ui))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(31, 31, 31))
        );

        getContentPane().add(loginPage_ui, "card2");

        regionSignin_ui.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "INDIA", "USA", "BOSTON" }));

        typeSignin_ui.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Customer", "Business", "Investor" }));

        signinSignin_ui.setText("Sign Up");
        signinSignin_ui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signinSignin_uiActionPerformed(evt);
            }
        });

        jLabel3.setText("Name:");

        jLabel4.setText("Password:");

        jLabel5.setText("Region:");

        jLabel6.setText("Type:");

        backSignin_ui.setText("Back");
        backSignin_ui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backSignin_uiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout signinPage_uiLayout = new javax.swing.GroupLayout(signinPage_ui);
        signinPage_ui.setLayout(signinPage_uiLayout);
        signinPage_uiLayout.setHorizontalGroup(
            signinPage_uiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signinPage_uiLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(signinPage_uiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(signinPage_uiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(regionSignin_ui, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nameSignin_ui)
                    .addComponent(passSignin_ui)
                    .addComponent(typeSignin_ui, 0, 170, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(signinPage_uiLayout.createSequentialGroup()
                .addGap(439, 439, 439)
                .addComponent(signinSignin_ui)
                .addContainerGap(449, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, signinPage_uiLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backSignin_ui)
                .addGap(31, 31, 31))
        );
        signinPage_uiLayout.setVerticalGroup(
            signinPage_uiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signinPage_uiLayout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(signinPage_uiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameSignin_ui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(signinPage_uiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passSignin_ui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(signinPage_uiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regionSignin_ui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(signinPage_uiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeSignin_ui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(32, 32, 32)
                .addComponent(signinSignin_ui)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addComponent(backSignin_ui)
                .addGap(16, 16, 16))
        );

        getContentPane().add(signinPage_ui, "card3");

        splitPane.setDividerLocation(100);
        splitPane.setDividerSize(8);

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel7.setText("Welcome Back");

        loginName_ui.setEditable(false);

        proceedMain_ui.setText("Proceed");
        proceedMain_ui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proceedMain_uiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(proceedMain_ui, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                            .addComponent(loginName_ui, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loginName_ui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(proceedMain_ui)
                .addContainerGap(267, Short.MAX_VALUE))
        );

        splitPane.setLeftComponent(jPanel1);

        javax.swing.GroupLayout profileMain_uiLayout = new javax.swing.GroupLayout(profileMain_ui);
        profileMain_ui.setLayout(profileMain_uiLayout);
        profileMain_uiLayout.setHorizontalGroup(
            profileMain_uiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 856, Short.MAX_VALUE)
        );
        profileMain_uiLayout.setVerticalGroup(
            profileMain_uiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 459, Short.MAX_VALUE)
        );

        splitPane.setRightComponent(profileMain_ui);

        javax.swing.GroupLayout profileLink_uiLayout = new javax.swing.GroupLayout(profileLink_ui);
        profileLink_ui.setLayout(profileLink_uiLayout);
        profileLink_uiLayout.setHorizontalGroup(
            profileLink_uiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(splitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE)
        );
        profileLink_uiLayout.setVerticalGroup(
            profileLink_uiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(splitPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        getContentPane().add(profileLink_ui, "card4");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Broker", "SEB" }));

        jLabel8.setText("Login Profiles");

        jButton2.setText("Login");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2))
                    .addComponent(jLabel8))
                .addGap(0, 744, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(258, Short.MAX_VALUE))
        );

        splitPane1.setRightComponent(jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 429, Short.MAX_VALUE)
        );

        splitPane1.setLeftComponent(jPanel3);

        javax.swing.GroupLayout moreLoginPages_uiLayout = new javax.swing.GroupLayout(moreLoginPages_ui);
        moreLoginPages_ui.setLayout(moreLoginPages_uiLayout);
        moreLoginPages_uiLayout.setHorizontalGroup(
            moreLoginPages_uiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(splitPane1)
        );
        moreLoginPages_uiLayout.setVerticalGroup(
            moreLoginPages_uiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(splitPane1)
        );

        getContentPane().add(moreLoginPages_ui, "card5");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passLogin_uiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passLogin_uiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passLogin_uiActionPerformed

    private void login_uiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_uiActionPerformed
        // TODO add your handling code here:
        try 
        {
            Connection con = null;
            PreparedStatement p = null;
            ResultSet rs = null;

            String url= "jdbc:mysql://127.0.0.1:3306/stockdb"; // table details 
            String username = "root"; // MySQL credentials
            String password = "root123$";

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);

            if (con != null) 
            {
                System.out.println("Connected to the database StockDB");

                String sql = "Select * from profile where id="+Integer.parseInt(idLogin_ui.getText())+" AND password= '"+String.valueOf(passLogin_ui.getText())+"';";
                p = con.prepareStatement(sql);
                rs = p.executeQuery();
                
                boolean login = false;
                    while (rs.next()) 
                    {   
                            loginId = rs.getInt("id");
                            loginName =rs.getString("name");
                            loginRegion = rs.getString("region");
                            loginFunds = rs.getDouble("funds");
                            
                            login = true;
                            JOptionPane.showMessageDialog(this,"Login successful for "+loginId+ " Name: "+loginName);  
                            loginPage_ui.setVisible(false);
                            profileLink_ui.setVisible(true);
                            loginName_ui.setText(loginName);
                            
                    }
                    
                    if(!login){JOptionPane.showMessageDialog(this,"Enter Valid details");}
 
            }
        } 
        catch (SQLException ex) 
        {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_login_uiActionPerformed

    private void signin_uiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signin_uiActionPerformed
        // TODO add your handling code here:
        loginPage_ui.setVisible(false);
        signinPage_ui.setVisible(true); 
    }//GEN-LAST:event_signin_uiActionPerformed

    private void signinSignin_uiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signinSignin_uiActionPerformed
        // TODO add your handling code here:
        
        String fundsType = "";
        if(String.valueOf(regionSignin_ui.getSelectedItem()).equals("INDIA")){fundsType = "INR";}
        else{fundsType = "USD";}

        try 
        {
            Connection con = null;
            PreparedStatement p = null;
            ResultSet rs = null;

            String url= "jdbc:mysql://127.0.0.1:3306/stockdb"; // table details 
            String username = "root"; // MySQL credentials
            String password = "root123$";

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);

            if (con != null) 
            {
                System.out.println("Connected to the database StockDB");

                String sql = "INSERT INTO profile (name, funds, region, balance, type, password, fundstype) VALUES ('"+String.valueOf(nameSignin_ui.getText())+"',0,'"+String.valueOf(regionSignin_ui.getSelectedItem())+"',0,'"+String.valueOf(typeSignin_ui.getSelectedItem())+"','"+String.valueOf(passSignin_ui.getText())+"','"+fundsType+"');";

                p = con.prepareStatement(sql);
                int rowDeleted = p.executeUpdate(); 
                if(rowDeleted > 0){
                    String fetchId = "select * from profile where password = '" +String.valueOf(passSignin_ui.getText())+"' AND name = '"+String.valueOf(nameSignin_ui.getText())+"';";
                    p = con.prepareStatement(fetchId);
                    rs = p.executeQuery();

                    int id =0;

                    while (rs.next()) 
                    {   
                            id = rs.getInt("id");
                    }
                        JOptionPane.showMessageDialog(this,"Account Created with id: "+id );  
                }
                
            }
        } 
        catch (SQLException ex) 
        {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_signinSignin_uiActionPerformed

    private void backSignin_uiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backSignin_uiActionPerformed
        // TODO add your handling code here:
        signinPage_ui.setVisible(false);
        loginPage_ui.setVisible(true);
    }//GEN-LAST:event_backSignin_uiActionPerformed

    private void proceedMain_uiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proceedMain_uiActionPerformed
        // TODO add your handling code here:
        MainProfile mainProfileObj = new MainProfile(loginId, loginName, loginRegion, loginFunds, String.valueOf(passLogin_ui.getText()));
        splitPane.setRightComponent(mainProfileObj);
    }//GEN-LAST:event_proceedMain_uiActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        BrokerPanel bpObj = new BrokerPanel();
        splitPane1.setRightComponent(bpObj);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        moreLoginPages_ui.setVisible(true);
        loginPage_ui.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(MainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPanel().setVisible(true);
            }
        });
    }
      
    public class MonCellRenderer extends DefaultTableCellRenderer {

        public Component getTableCellRendererComponent(JTable table, Object value,
                        boolean isSelected, boolean hasFocus, int row, int column) {
            super.getTableCellRendererComponent(table, value,
                            isSelected, hasFocus, row, column);

            if (down.contains(row)) {
                setBackground(Color.decode("#3d754e"));
            } else {
                setBackground(Color.decode("#bf0205"));
            }
            return this;
        }
        
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backSignin_ui;
    private javax.swing.JTextField idLogin_ui;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField loginName_ui;
    private javax.swing.JPanel loginPage_ui;
    private javax.swing.JButton login_ui;
    private javax.swing.JPanel moreLoginPages_ui;
    private javax.swing.JTextField nameSignin_ui;
    private javax.swing.JTextField passLogin_ui;
    private javax.swing.JTextField passSignin_ui;
    private javax.swing.JButton proceedMain_ui;
    private javax.swing.JPanel profileLink_ui;
    private javax.swing.JPanel profileMain_ui;
    private javax.swing.JComboBox<String> regionSignin_ui;
    private javax.swing.JPanel signinPage_ui;
    private javax.swing.JButton signinSignin_ui;
    private javax.swing.JButton signin_ui;
    private javax.swing.JSplitPane splitPane;
    private javax.swing.JSplitPane splitPane1;
    private javax.swing.JComboBox<String> typeSignin_ui;
    // End of variables declaration//GEN-END:variables
}
