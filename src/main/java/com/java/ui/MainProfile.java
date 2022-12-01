/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.java.ui;

import com.java.dbconn.DbConnectionBSE;
import com.java.dbconn.DbConnectionNSE;
import com.java.dbconn.DbConnectionNYSE;
import com.java.sebprofiles.SEBProfileClass;
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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rajmehta
 */
public class MainProfile extends javax.swing.JPanel {

    /**
     * Creates new form LoginPanel
     */
    
    int loginId = 0;
    String loginName = "";
    String loginRegion = "";
    double loginFunds = 0;
    String fundsType = "";
    double loginBalance = 0;
    double convertedFunds;
    DefaultTableModel stocksTableModel;
    List<Integer> down = new ArrayList();
    String loginPass;
    String loginType;
    
    public MainProfile(int loginId, String loginName, String loginRegion, double loginFunds, String loginPass, String loginType) {
        initComponents();
        this.loginId = loginId;
        this.loginName = loginName;
        this.loginRegion = loginRegion;
        this.loginFunds = loginFunds;
        this.loginPass = loginPass;
        this.loginType =loginType;
    
        stocksTableModel = (DefaultTableModel) stocksTable.getModel();
        
        if(loginRegion.equals("INDIA")){fundsType = "INR";}
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

                String sql = "Select * from profile where id="+loginId+" AND password= '"+loginPass+"';";
                p = con.prepareStatement(sql);
                rs = p.executeQuery();
                
                    while (rs.next()) 
                    {   
                            this.loginId = rs.getInt("id");
                            this.loginName =rs.getString("name");
                            this.loginRegion = rs.getString("region");
                            this.loginFunds = rs.getDouble("funds");
                            loginBalance = rs.getDouble("balance");
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
        
        fundsConverter();
        if(loginType.equals("INDIA")){
            fundsUSD_ui.setText(String.valueOf(convertedFunds));
            fundsINR_ui.setText(String.valueOf(loginFunds));
        }
        else{
            fundsINR_ui.setText(String.valueOf(convertedFunds));
            fundsUSD_ui.setText(String.valueOf(loginFunds));
        }
        
        stockMarket_ui.removeAllItems();
        
        if(loginType.equals("Customer") && loginRegion.equals("INDIA")){
            stockMarket_ui.addItem("NSE");
            stockMarket_ui.addItem("BSE");
        }
        else if(loginType.equals("Customer") && loginRegion.equals("USA")){
            stockMarket_ui.addItem("NYSE");
        }
        else if(loginType.equals("Customer") && loginRegion.equals("BOSTON")){
            stockMarket_ui.addItem("NEUSE");
        }
        else if(loginType.equals("Business")){
            stockMarket_ui.addItem("BSE");
            stockMarket_ui.addItem("NSE");
            stockMarket_ui.addItem("NYSE");
        }
        else{
            stockMarket_ui.addItem("BSE");
            stockMarket_ui.addItem("NSE");
            stockMarket_ui.addItem("NYSE");
            stockMarket_ui.addItem("NEUSE");
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

        mainProfilePage = new javax.swing.JPanel();
        stockMarket_ui = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        loadStocks_ui1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        stocksTable = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        fundsUSD_ui = new javax.swing.JTextField();
        fundsINR_ui = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        portfolioPage = new javax.swing.JPanel();
        addFundsPage = new javax.swing.JPanel();
        addFunds_ui = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        addBal_ui = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        newsPage = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        stockMarket_ui.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel6.setText("Main Profile Panel");

        loadStocks_ui1.setText("Load Stocks");
        loadStocks_ui1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadStocks_ui1ActionPerformed(evt);
            }
        });

        jLabel7.setText("Select Stock Market:");

        stocksTable.setDefaultRenderer(Object.class, new MonCellRenderer());
        stocksTable.setForeground(new java.awt.Color(255, 255, 255));
        stocksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Tag", "CompanyName", "Date", "Price", "ChangeRate", "Currency", "Bid", "DayHigh", "DayLow", "LastFetched", "PrevPrice", "Qty"
            }
        ));
        jScrollPane2.setViewportView(stocksTable);

        jButton4.setText("Today's News");

        jButton5.setText("My Portfolio");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        fundsUSD_ui.setEditable(false);

        fundsINR_ui.setEditable(false);

        jLabel8.setText("Funds USD");

        jLabel9.setText("Funds INR");

        jButton1.setText("Add Funds");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainProfilePageLayout = new javax.swing.GroupLayout(mainProfilePage);
        mainProfilePage.setLayout(mainProfilePageLayout);
        mainProfilePageLayout.setHorizontalGroup(
            mainProfilePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainProfilePageLayout.createSequentialGroup()
                .addGroup(mainProfilePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainProfilePageLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jButton4)
                        .addGap(50, 50, 50)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(mainProfilePageLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainProfilePageLayout.createSequentialGroup()
                .addGroup(mainProfilePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(mainProfilePageLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addGap(122, 122, 122))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainProfilePageLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stockMarket_ui, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainProfilePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainProfilePageLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addGroup(mainProfilePageLayout.createSequentialGroup()
                                .addComponent(loadStocks_ui1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fundsUSD_ui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fundsINR_ui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(19, 19, 19))
        );
        mainProfilePageLayout.setVerticalGroup(
            mainProfilePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainProfilePageLayout.createSequentialGroup()
                .addGroup(mainProfilePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainProfilePageLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(mainProfilePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(mainProfilePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fundsINR_ui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(fundsUSD_ui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(stockMarket_ui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(loadStocks_ui1)
                            .addComponent(jLabel7)))
                    .addGroup(mainProfilePageLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel10)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(mainProfilePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(34, 34, 34))
        );

        add(mainProfilePage, "card14");

        javax.swing.GroupLayout portfolioPageLayout = new javax.swing.GroupLayout(portfolioPage);
        portfolioPage.setLayout(portfolioPageLayout);
        portfolioPageLayout.setHorizontalGroup(
            portfolioPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 768, Short.MAX_VALUE)
        );
        portfolioPageLayout.setVerticalGroup(
            portfolioPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 535, Short.MAX_VALUE)
        );

        add(portfolioPage, "card15");

        addFunds_ui.setText("Add Funds");
        addFunds_ui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFunds_uiActionPerformed(evt);
            }
        });

        jLabel1.setText("Card Number");

        jLabel2.setText("Expiry");

        jLabel3.setText("CVV ");

        jLabel4.setText("Funds to add");

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel5.setText("Add Funds");

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addFundsPageLayout = new javax.swing.GroupLayout(addFundsPage);
        addFundsPage.setLayout(addFundsPageLayout);
        addFundsPageLayout.setHorizontalGroup(
            addFundsPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addFundsPageLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(30, 30, 30))
            .addGroup(addFundsPageLayout.createSequentialGroup()
                .addGroup(addFundsPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addFundsPageLayout.createSequentialGroup()
                        .addGap(322, 322, 322)
                        .addComponent(addFunds_ui, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addFundsPageLayout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addGroup(addFundsPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(addFundsPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1)
                            .addGroup(addFundsPageLayout.createSequentialGroup()
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
                            .addComponent(addBal_ui)
                            .addComponent(jTextField5)))
                    .addGroup(addFundsPageLayout.createSequentialGroup()
                        .addGap(340, 340, 340)
                        .addComponent(jLabel5)))
                .addContainerGap(231, Short.MAX_VALUE))
        );
        addFundsPageLayout.setVerticalGroup(
            addFundsPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addFundsPageLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel5)
                .addGap(94, 94, 94)
                .addGroup(addFundsPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(addFundsPageLayout.createSequentialGroup()
                        .addGroup(addFundsPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(addFundsPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(24, 24, 24)
                        .addGroup(addFundsPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addBal_ui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4))
                .addGap(28, 28, 28)
                .addComponent(addFunds_ui)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(19, 19, 19))
        );

        add(addFundsPage, "card15");

        javax.swing.GroupLayout newsPageLayout = new javax.swing.GroupLayout(newsPage);
        newsPage.setLayout(newsPageLayout);
        newsPageLayout.setHorizontalGroup(
            newsPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 768, Short.MAX_VALUE)
        );
        newsPageLayout.setVerticalGroup(
            newsPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 535, Short.MAX_VALUE)
        );

        add(newsPage, "card15");
    }// </editor-fold>//GEN-END:initComponents

    private void loadStocks_ui1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadStocks_ui1ActionPerformed
        // TODO add your handling code here:
        if(String.valueOf(stockMarket_ui.getSelectedItem()).equals("BSE")){
        //BSE Populate Table
            try{
                ArrayList<BSEClass> allBSEStocks  = DbConnectionBSE.readBSETable();
                stocksTableModel.setRowCount(0);
                int i =0;
                for(BSEClass stock: allBSEStocks){
                    Object[] row = new Object[12];

                    row[0] = stock.getStocktag();
                    row[1] = stock.getStockname();
                    row[2] = stock.getDate();
                    row[3] = stock.getType();
                    row[4] = stock.getStockprice();
                    row[5] = stock.getChangerate();
                    row[6] = stock.getCurency();
                    row[7] = stock.getBid();
                    row[8] = stock.getDayhigh();
                    row[9] = stock.getDaylow();
                    row[10] = stock.getLastfetched();
                    row[11] = stock.getPrevprice();

                    stocksTableModel.addRow(row);

                    if(stock.getStockprice() < stock.getPrevprice()){
                        down.add(i);
                    }

                    i++;
                }
            }catch(Exception e){e.printStackTrace();}
            
        }
        else if(String.valueOf(stockMarket_ui.getSelectedItem()).equals("NSE")){
        //NSE Populate Table
            try{
                down = new ArrayList<>();
                ArrayList<NSEClass> allNSEStocks  = DbConnectionNSE.readNSETable();
                stocksTableModel.setRowCount(0);
                int i =0;
                for(NSEClass stock: allNSEStocks){
                    Object[] row = new Object[12];

                    row[0] = stock.getStocktag();
                    row[1] = stock.getStockname();
                    row[2] = stock.getDate();
                    row[3] = stock.getType();
                    row[4] = stock.getStockprice();
                    row[5] = stock.getChangerate();
                    row[6] = stock.getCurency();
                    row[7] = stock.getBid();
                    row[8] = stock.getDayhigh();
                    row[9] = stock.getDaylow();
                    row[10] = stock.getLastfetched();
                    row[11] = stock.getPrevprice();

                    stocksTableModel.addRow(row);

                    if(stock.getStockprice() < stock.getPrevprice()){
                        down.add(i);
                    }

                    i++;
                }
            }catch(Exception e){e.printStackTrace();}
            
        }
        else{
            //NYSE Populate Table
            try{
                down = new ArrayList<>();
                ArrayList<NYSEClass> allNYSEStocks  = DbConnectionNYSE.readNYSETable();
                stocksTableModel.setRowCount(0);
                int i =0;
                for(NYSEClass stock: allNYSEStocks){
                    Object[] row = new Object[12];

                    row[0] = stock.getStocktag();
                    row[1] = stock.getStockname();
                    row[2] = stock.getDate();
                    row[3] = stock.getType();
                    row[4] = stock.getStockprice();
                    row[5] = stock.getChangerate();
                    row[6] = stock.getCurency();
                    row[7] = stock.getBid();
                    row[8] = stock.getDayhigh();
                    row[9] = stock.getDaylow();
                    row[10] = stock.getLastfetched();
                    row[11] = stock.getPrevprice();

                    stocksTableModel.addRow(row);

                    if(stock.getStockprice() < stock.getPrevprice()){
                        down.add(i);
                    }

                    i++;
                }
            }catch(Exception e){e.printStackTrace();}
        }//populate end
        
        
    }//GEN-LAST:event_loadStocks_ui1ActionPerformed

    private void addFunds_uiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFunds_uiActionPerformed
        // TODO add your handling code here:
        double balancetoadd = loginFunds + Double.parseDouble(addBal_ui.getText());
        
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

                String sql = "Update profile SET funds = "+balancetoadd+" where id="+loginId+" AND password= '"+loginPass+"';";
                p = con.prepareStatement(sql);
                int rowsDeleted = p.executeUpdate();
                    if (rowsDeleted > 0) {
                        System.out.println("Added Funds!");
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
        
    }//GEN-LAST:event_addFunds_uiActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        mainProfilePage.setVisible(false);
        addFundsPage.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        mainProfilePage.setVisible(true);
        addFundsPage.setVisible(false);
        refreshTable();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        mainProfilePage.setVisible(false);
        portfolioPage.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    public void fundsConverter(){
        if(fundsType.equals("INR")){convertedFunds = loginFunds/80;}
        else{convertedFunds = loginFunds * 80;}
    }

    private void refreshTable() {
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

                String sql = "Select * from profile where id="+loginId+" AND password= '"+loginPass+"';";
                p = con.prepareStatement(sql);
                rs = p.executeQuery();
                
                    while (rs.next()) 
                    {   
                            this.loginId = rs.getInt("id");
                            this.loginName =rs.getString("name");
                            this.loginRegion = rs.getString("region");
                            this.loginFunds = rs.getDouble("funds");
                            this.loginBalance = rs.getDouble("balance");
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
        
        fundsConverter();
        if(loginRegion.equals("INDIA")){
            fundsUSD_ui.setText(String.valueOf(convertedFunds));
            fundsINR_ui.setText(String.valueOf(loginFunds));
        }
        else{
            fundsINR_ui.setText(String.valueOf(convertedFunds));
            fundsUSD_ui.setText(String.valueOf(loginFunds));
        }
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
    private javax.swing.JTextField addBal_ui;
    private javax.swing.JPanel addFundsPage;
    private javax.swing.JButton addFunds_ui;
    private javax.swing.JTextField fundsINR_ui;
    private javax.swing.JTextField fundsUSD_ui;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JButton loadStocks_ui1;
    private javax.swing.JPanel mainProfilePage;
    private javax.swing.JPanel newsPage;
    private javax.swing.JPanel portfolioPage;
    private javax.swing.JComboBox<String> stockMarket_ui;
    private javax.swing.JTable stocksTable;
    // End of variables declaration//GEN-END:variables
}
