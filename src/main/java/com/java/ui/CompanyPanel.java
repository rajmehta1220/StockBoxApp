/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.java.ui;

//import com.java.broker.BrokerHandler;
import Company.CompanyProfile;
import com.java.Faker.Parser;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hp
 */
public class CompanyPanel extends javax.swing.JPanel {

    /**
     * Creates new form CompanyPanel
     */
    int loginId = 0;
    String loginUsername = "";
    String loginRegion = "";
    double loginRevenue = 0.0;
    String loginType = "";
    double loginListingPrice = 0.0;
    int loginQty=0;
    String loginPass="";
    //BrokerHandler brokhandobj = new BrokerHandler();
    //DefaultTableModel brokerClients;
    //DefaultTableModel transactionTable;
    public CompanyPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        createCompanyProfile = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        revenue_ui = new javax.swing.JTextField();
        companyname_ui = new javax.swing.JTextField();
        type_ui = new javax.swing.JTextField();
        listingprice_ui = new javax.swing.JTextField();
        qty_ui = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        enterpassword_ui = new javax.swing.JTextField();
        region_ui = new javax.swing.JComboBox<>();
        btback = new javax.swing.JButton();

        setLayout(new java.awt.CardLayout());

        createCompanyProfile.setBackground(new java.awt.Color(43, 63, 87));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 2, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Create Company Profile");

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 2, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Revenue");

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 2, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Company Name");

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 2, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Region");

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 2, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Type");

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 2, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Listing Price");

        jLabel9.setFont(new java.awt.Font("Helvetica Neue", 2, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Quantity");

        revenue_ui.setFont(new java.awt.Font("Helvetica Neue", 2, 18)); // NOI18N
        revenue_ui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                revenue_uiActionPerformed(evt);
            }
        });

        companyname_ui.setFont(new java.awt.Font("Helvetica Neue", 2, 18)); // NOI18N

        type_ui.setFont(new java.awt.Font("Helvetica Neue", 2, 18)); // NOI18N

        listingprice_ui.setFont(new java.awt.Font("Helvetica Neue", 2, 18)); // NOI18N

        qty_ui.setFont(new java.awt.Font("Helvetica Neue", 2, 18)); // NOI18N

        btnCreate.setFont(new java.awt.Font("Helvetica Neue", 2, 18)); // NOI18N
        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Helvetica Neue", 2, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Password");

        enterpassword_ui.setFont(new java.awt.Font("Helvetica Neue", 2, 18)); // NOI18N
        enterpassword_ui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterpassword_uiActionPerformed(evt);
            }
        });

        region_ui.setFont(new java.awt.Font("Helvetica Neue", 2, 18)); // NOI18N
        region_ui.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "INDIA", "USA", "BOSTON" }));

        btback.setFont(new java.awt.Font("Helvetica Neue", 2, 18)); // NOI18N
        btback.setText("Back");
        btback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout createCompanyProfileLayout = new javax.swing.GroupLayout(createCompanyProfile);
        createCompanyProfile.setLayout(createCompanyProfileLayout);
        createCompanyProfileLayout.setHorizontalGroup(
            createCompanyProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createCompanyProfileLayout.createSequentialGroup()
                .addGroup(createCompanyProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(createCompanyProfileLayout.createSequentialGroup()
                        .addGroup(createCompanyProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(createCompanyProfileLayout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(jLabel9))
                            .addGroup(createCompanyProfileLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(createCompanyProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10))))
                        .addGap(37, 37, 37)
                        .addGroup(createCompanyProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(revenue_ui, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                            .addComponent(companyname_ui)
                            .addComponent(type_ui)
                            .addComponent(listingprice_ui)
                            .addComponent(qty_ui)
                            .addComponent(enterpassword_ui)
                            .addComponent(region_ui, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(createCompanyProfileLayout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(158, 158, 158))
            .addGroup(createCompanyProfileLayout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(btnCreate)
                .addGap(65, 65, 65)
                .addComponent(btback)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        createCompanyProfileLayout.setVerticalGroup(
            createCompanyProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createCompanyProfileLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(createCompanyProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(revenue_ui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(createCompanyProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(companyname_ui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(createCompanyProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(enterpassword_ui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(createCompanyProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(region_ui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(createCompanyProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(type_ui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(15, 15, 15)
                .addGroup(createCompanyProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(listingprice_ui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(createCompanyProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(qty_ui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(createCompanyProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreate)
                    .addComponent(btback))
                .addGap(22, 22, 22))
        );

        add(createCompanyProfile, "card4");
    }// </editor-fold>//GEN-END:initComponents

    private void revenue_uiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_revenue_uiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_revenue_uiActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        Parser parser=new Parser();
        boolean flag3 = parser.isInteger(qty_ui.getText());
        if(revenue_ui.getText().isEmpty() || companyname_ui.getText().isEmpty() || enterpassword_ui.getText().isEmpty() || type_ui.getText().isEmpty() || listingprice_ui.getText().isEmpty() || qty_ui.getText().isEmpty()){flag3 = false;}
        if(flag3){
        CompanyProfile comobj = new CompanyProfile();
        
        double revenue = Double.parseDouble(revenue_ui.getText());
        String companyname = String.valueOf(companyname_ui.getText());
        String region = String.valueOf(region_ui.getSelectedItem());
        String type = String.valueOf(type_ui.getText());
        double listingprice = Double.parseDouble(listingprice_ui.getText());
        int qty = Integer.parseInt(qty_ui.getText());
        String password = String.valueOf(enterpassword_ui.getText());
        
        
        try {
            comobj.createCompanyProfile(companyname, revenue, region, type, listingprice,qty,password);
            // TODO add your handling code here:
        } catch (Exception ex) {
            //Logger.getLogger(CompanyPanel.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } /*catch (SQLException ex) {
            Logger.getLogger(CompanyPanel.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        }else{JOptionPane.showMessageDialog(this, "TypeMismatched or null");}
    }//GEN-LAST:event_btnCreateActionPerformed

    private void enterpassword_uiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterpassword_uiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enterpassword_uiActionPerformed

    private void btbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbackActionPerformed
        // TODO add your handling code here:
        createCompanyProfile.setVisible(false);
        MainPanel back = new MainPanel();
        back.setVisible(true);
    }//GEN-LAST:event_btbackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btback;
    private javax.swing.JButton btnCreate;
    private javax.swing.JTextField companyname_ui;
    private javax.swing.JPanel createCompanyProfile;
    private javax.swing.JTextField enterpassword_ui;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField listingprice_ui;
    private javax.swing.JTextField qty_ui;
    private javax.swing.JComboBox<String> region_ui;
    private javax.swing.JTextField revenue_ui;
    private javax.swing.JTextField type_ui;
    // End of variables declaration//GEN-END:variables
}
