/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.java.ui;

import com.java.broker.BrokerHandler;
import com.java.profile.Profile;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rajmehta
 */
public class BrokerPanel extends javax.swing.JPanel {

    /**
     * Creates new form BrokerPanel
     */
    
    int loginId = 0;
    String loginName = "";
    String loginRegion = "";
    double loginCommrate = 0;
    String fundsType = "";
    double loginBalance = 0;
    double convertedFunds;
    String loginPass;
    BrokerHandler brokhandobj = new BrokerHandler();
    DefaultTableModel brokerClients;
    DefaultTableModel transactionTable;
    
    public BrokerPanel() {
        initComponents();
        brokerClients = (DefaultTableModel) brokerClients_ui.getModel();
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
        id_brokerLogin_ui = new javax.swing.JTextField();
        pass_brokerLogin_ui = new javax.swing.JTextField();
        login_ui = new javax.swing.JButton();
        signin_ui = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        signinPage_ui = new javax.swing.JPanel();
        name_brokerSignin_ui = new javax.swing.JTextField();
        pass_brokerSignin_ui = new javax.swing.JTextField();
        regionSignin_ui = new javax.swing.JComboBox<>();
        signinSignin_ui = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        backSignin_ui = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        commrate_brokerSignup_ui = new javax.swing.JTextField();
        MainBrokerPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        brokerName_ui = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        totalCommUSD_ui = new javax.swing.JTextField();
        totalCommINR_ui = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        brokerClients_ui = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        transactionReq_ui = new javax.swing.JToggleButton();
        jLabel13 = new javax.swing.JLabel();
        commRate_ui = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        TransactionRequestPanel_ui = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        transacionTable_ui = new javax.swing.JTable();
        aproveStock = new javax.swing.JButton();
        denyStock = new javax.swing.JButton();

        setLayout(new java.awt.CardLayout());

        pass_brokerLogin_ui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pass_brokerLogin_uiActionPerformed(evt);
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
                    .addComponent(pass_brokerLogin_ui)
                    .addGroup(loginPage_uiLayout.createSequentialGroup()
                        .addComponent(login_ui)
                        .addGap(18, 18, 18)
                        .addComponent(signin_ui))
                    .addComponent(id_brokerLogin_ui))
                .addContainerGap(431, Short.MAX_VALUE))
        );
        loginPage_uiLayout.setVerticalGroup(
            loginPage_uiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPage_uiLayout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addGroup(loginPage_uiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id_brokerLogin_ui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(31, 31, 31)
                .addGroup(loginPage_uiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pass_brokerLogin_ui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(31, 31, 31)
                .addGroup(loginPage_uiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(login_ui)
                    .addComponent(signin_ui))
                .addContainerGap(285, Short.MAX_VALUE))
        );

        add(loginPage_ui, "card2");

        regionSignin_ui.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "INDIA", "USA", "BOSTON" }));

        signinSignin_ui.setText("Sign Up");
        signinSignin_ui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signinSignin_uiActionPerformed(evt);
            }
        });

        jLabel3.setText("Name:");

        jLabel4.setText("Password:");

        jLabel5.setText("Region:");

        backSignin_ui.setText("Back");
        backSignin_ui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backSignin_uiActionPerformed(evt);
            }
        });

        jLabel6.setText("Commission Rate:");

        javax.swing.GroupLayout signinPage_uiLayout = new javax.swing.GroupLayout(signinPage_ui);
        signinPage_ui.setLayout(signinPage_uiLayout);
        signinPage_uiLayout.setHorizontalGroup(
            signinPage_uiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, signinPage_uiLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backSignin_ui)
                .addGap(31, 31, 31))
            .addGroup(signinPage_uiLayout.createSequentialGroup()
                .addGap(0, 332, Short.MAX_VALUE)
                .addGroup(signinPage_uiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(signinPage_uiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(signinSignin_ui)
                    .addComponent(regionSignin_ui, javax.swing.GroupLayout.Alignment.TRAILING, 0, 170, Short.MAX_VALUE)
                    .addComponent(name_brokerSignin_ui, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pass_brokerSignin_ui, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(commrate_brokerSignup_ui))
                .addContainerGap(337, Short.MAX_VALUE))
        );
        signinPage_uiLayout.setVerticalGroup(
            signinPage_uiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signinPage_uiLayout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(signinPage_uiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name_brokerSignin_ui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(signinPage_uiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pass_brokerSignin_ui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(signinPage_uiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regionSignin_ui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(signinPage_uiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(commrate_brokerSignup_ui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(signinSignin_ui)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 233, Short.MAX_VALUE)
                .addComponent(backSignin_ui)
                .addGap(16, 16, 16))
        );

        add(signinPage_ui, "card3");

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        jLabel7.setText("Broker Panel");

        jLabel8.setText("Welcome Back:");

        brokerName_ui.setEditable(false);

        jLabel9.setText("Total Commission");

        totalCommUSD_ui.setEditable(false);
        totalCommUSD_ui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalCommUSD_uiActionPerformed(evt);
            }
        });

        totalCommINR_ui.setEditable(false);

        jLabel10.setText("USD");

        jLabel11.setText("INR");

        brokerClients_ui.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ProfileId", "Name", "Type"
            }
        ));
        jScrollPane1.setViewportView(brokerClients_ui);

        jLabel12.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel12.setText("My Clients");

        transactionReq_ui.setText("Transaction Requests");
        transactionReq_ui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transactionReq_uiActionPerformed(evt);
            }
        });

        jLabel13.setText("My Commission Rate:");

        commRate_ui.setEditable(false);

        jLabel14.setText("%");

        javax.swing.GroupLayout MainBrokerPanelLayout = new javax.swing.GroupLayout(MainBrokerPanel);
        MainBrokerPanel.setLayout(MainBrokerPanelLayout);
        MainBrokerPanelLayout.setHorizontalGroup(
            MainBrokerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainBrokerPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(MainBrokerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainBrokerPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(MainBrokerPanelLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(brokerName_ui, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(151, 151, 151)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(commRate_ui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MainBrokerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(totalCommUSD_ui)
                            .addComponent(totalCommINR_ui, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MainBrokerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(12, 12, 12))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainBrokerPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(MainBrokerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainBrokerPanelLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(344, 344, 344))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainBrokerPanelLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(396, 396, 396))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainBrokerPanelLayout.createSequentialGroup()
                        .addComponent(transactionReq_ui)
                        .addGap(394, 394, 394))))
        );
        MainBrokerPanelLayout.setVerticalGroup(
            MainBrokerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainBrokerPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel7)
                .addGroup(MainBrokerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainBrokerPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(MainBrokerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(brokerName_ui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel13)
                            .addComponent(commRate_ui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)))
                    .addGroup(MainBrokerPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(MainBrokerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(totalCommUSD_ui, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MainBrokerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totalCommINR_ui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))))
                .addGap(19, 19, 19)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(transactionReq_ui)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        add(MainBrokerPanel, "card4");

        transacionTable_ui.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "transactionId", "brokerId", "profileId", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11"
            }
        ));
        jScrollPane2.setViewportView(transacionTable_ui);

        aproveStock.setText("Approve");
        aproveStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aproveStockActionPerformed(evt);
            }
        });

        denyStock.setText("Deny");

        javax.swing.GroupLayout TransactionRequestPanel_uiLayout = new javax.swing.GroupLayout(TransactionRequestPanel_ui);
        TransactionRequestPanel_ui.setLayout(TransactionRequestPanel_uiLayout);
        TransactionRequestPanel_uiLayout.setHorizontalGroup(
            TransactionRequestPanel_uiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TransactionRequestPanel_uiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TransactionRequestPanel_uiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(TransactionRequestPanel_uiLayout.createSequentialGroup()
                        .addComponent(aproveStock, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(denyStock, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)))
                .addContainerGap())
        );
        TransactionRequestPanel_uiLayout.setVerticalGroup(
            TransactionRequestPanel_uiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TransactionRequestPanel_uiLayout.createSequentialGroup()
                .addContainerGap(106, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(TransactionRequestPanel_uiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aproveStock)
                    .addComponent(denyStock))
                .addGap(26, 26, 26))
        );

        add(TransactionRequestPanel_ui, "card5");
    }// </editor-fold>//GEN-END:initComponents

    private void pass_brokerLogin_uiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pass_brokerLogin_uiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pass_brokerLogin_uiActionPerformed

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

                String sql = "Select * from broker where brokerid="+Integer.parseInt(id_brokerLogin_ui.getText())+" AND password= '"+String.valueOf(pass_brokerLogin_ui.getText())+"';";
                p = con.prepareStatement(sql);
                rs = p.executeQuery();

                boolean login = false;
                while (rs.next())
                {
                    loginId = rs.getInt("brokerid");
                    loginName =rs.getString("name");
                    loginRegion = rs.getString("region");
                    loginCommrate = rs.getDouble("commissionrate");

                    login = true;
                    JOptionPane.showMessageDialog(this,"Login successful for "+loginId+ " Name: "+loginName);
                    
                    loadBrokerPage();
                    loginPage_ui.setVisible(false);
                    MainBrokerPanel.setVisible(true);
                    
                    refreshTransactionRequest();

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

                String sql = "INSERT INTO broker (name, region, commission, commissionrate, password) VALUES ('"+String.valueOf(name_brokerSignin_ui.getText())+"','"+String.valueOf(regionSignin_ui.getSelectedItem())+"',0,'"+String.valueOf(commrate_brokerSignup_ui.getText())+"','"+String.valueOf(pass_brokerSignin_ui.getText())+"');";

                p = con.prepareStatement(sql);
                int rowDeleted = p.executeUpdate();
                if(rowDeleted > 0){
                    String fetchId = "select * from broker where password = '" +String.valueOf(pass_brokerSignin_ui.getText())+"' AND name = '"+String.valueOf(name_brokerSignin_ui.getText())+"';";
                    p = con.prepareStatement(fetchId);
                    rs = p.executeQuery();

                    int id =0;

                    while (rs.next())
                    {
                        id = rs.getInt("brokerid");
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

    private void totalCommUSD_uiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalCommUSD_uiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalCommUSD_uiActionPerformed

    private void transactionReq_uiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionReq_uiActionPerformed
        // TODO add your handling code here:
        TransactionRequestPanel_ui.setVisible(true);
        MainBrokerPanel.setVisible(false);
        loginPage_ui.setVisible(false);
    }//GEN-LAST:event_transactionReq_uiActionPerformed

    private void aproveStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aproveStockActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = transacionTable_ui.getSelectedRow();
        if (selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row to Approve/Reject");
            return;
        }
        else{
            transactionTable = (DefaultTableModel) transacionTable_ui.getModel();
            int tid = (Integer) transactionTable.getValueAt(selectedRowIndex, 0);
            System.out.println("TransactionId is: "+tid);
            
            
        }
    }//GEN-LAST:event_aproveStockActionPerformed

    public void loadBrokerPage() throws ClassNotFoundException{
        brokerName_ui.setText(loginName);
        commRate_ui.setText(String.valueOf(loginCommrate));
        
        ArrayList<Profile> allProfiletoBrok = brokhandobj.viewAllProfileToBroker(loginId);
        Object[] rows = new Object[3];
        brokerClients.setRowCount(0);
        for(Profile p:allProfiletoBrok){
            rows[0]=p.getId();
            rows[1]=p.getName();
            rows[2]=p.getType();
            brokerClients.addRow(rows);
        }
    }
    
    public void refreshTransactionRequest(){
        transactionTable = (DefaultTableModel) transacionTable_ui.getModel();
        transactionTable.setRowCount(0);
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

                String sql = "Select * from transaction where brokerid="+loginId+";";
                System.out.println(sql);
                p = con.prepareStatement(sql);
                rs = p.executeQuery();
                Object[] row = new Object[11];
                    while (rs.next()) 
                    {   
                            row[0] = rs.getInt("transactionid");
                            row[1] = rs.getInt("brokerid");
                            row[2] = rs.getInt("profileid");
                            row[3] = rs.getInt("qty");
                            row[4] = rs.getString("type");
                            row[5] = rs.getDouble("stockprice");
                            row[6] = rs.getDouble("transactiontotal");
                            row[7] = rs.getString("stocktag");
                            row[8] = rs.getDouble("commission");
                            row[9] = rs.getString("transactiondate");
                            row[10] = rs.getString("action");
                            
                            transactionTable.addRow(row);
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
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainBrokerPanel;
    private javax.swing.JPanel TransactionRequestPanel_ui;
    private javax.swing.JButton aproveStock;
    private javax.swing.JButton backSignin_ui;
    private javax.swing.JTable brokerClients_ui;
    private javax.swing.JTextField brokerName_ui;
    private javax.swing.JTextField commRate_ui;
    private javax.swing.JTextField commrate_brokerSignup_ui;
    private javax.swing.JButton denyStock;
    private javax.swing.JTextField id_brokerLogin_ui;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel loginPage_ui;
    private javax.swing.JButton login_ui;
    private javax.swing.JTextField name_brokerSignin_ui;
    private javax.swing.JTextField pass_brokerLogin_ui;
    private javax.swing.JTextField pass_brokerSignin_ui;
    private javax.swing.JComboBox<String> regionSignin_ui;
    private javax.swing.JPanel signinPage_ui;
    private javax.swing.JButton signinSignin_ui;
    private javax.swing.JButton signin_ui;
    private javax.swing.JTextField totalCommINR_ui;
    private javax.swing.JTextField totalCommUSD_ui;
    private javax.swing.JTable transacionTable_ui;
    private javax.swing.JToggleButton transactionReq_ui;
    // End of variables declaration//GEN-END:variables
}
