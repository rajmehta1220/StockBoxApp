/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.java.ui;

import com.java.broker.BrokerHandler;
import com.java.dbconn.DbConnectionBSE;
import com.java.dbconn.DbConnectionNEUSE;
import com.java.dbconn.DbConnectionNSE;
import com.java.dbconn.DbConnectionNYSE;
import com.java.sebprofiles.SEBProfileClass;
import com.java.stocks.BSEClass;
import com.java.stocks.NSEClass;
import com.java.stocks.NYSEClass;
import com.java.stocks.NeuSEClass;
import com.java.transaction.TransactionHandler;
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
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.lang.Math;

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
    List<Integer> loss = new ArrayList();
    String loginPass;
    String loginType;
    ArrayList<String> stkTagPortfolio;
    String selectedTag;
    int selectedQty;
    String selectedMarket;
    double selectedPrice;
    double selectedCommission;
    int selectedBrokerId;
    DefaultTableModel portfolioTable;
    
    double currPrice=0;
    String portType;
    String portStockTag;
    
    private static final DecimalFormat df = new DecimalFormat("0.000");
    
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
        
        refreshPortfolioTable();
        
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
            
            fundsUSDPortfolio_ui.setText(String.valueOf(convertedFunds));
            fundsINRPortfolio_ui.setText(String.valueOf(loginFunds));
        }
        else{
            fundsINR_ui.setText(String.valueOf(convertedFunds));
            fundsUSD_ui.setText(String.valueOf(loginFunds));
            
            fundsINRPortfolio_ui.setText(String.valueOf(convertedFunds));
            fundsUSDPortfolio_ui.setText(String.valueOf(loginFunds));
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
        jLabel11 = new javax.swing.JLabel();
        fundsUSDPortfolio_ui = new javax.swing.JTextField();
        fundsINRPortfolio_ui = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        portfolioTitle_ui = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        portfolioTable_ui = new javax.swing.JTable();
        portfolioStockTag_ui = new javax.swing.JComboBox<>();
        portfolioQty_ui = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        portfolioPrice_ui = new javax.swing.JTextField();
        portfolioLoadPrice_ui = new javax.swing.JButton();
        portfolioBuy_ui = new javax.swing.JButton();
        portfolioComm_ui = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        balance_ui = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
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
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Tag", "CompanyName", "Date", "Market", "Price", "ChangeRate", "Currency", "Bid", "DayHigh", "DayLow", "LastFetched", "PrevPrice", "Qty"
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

        jLabel11.setText("Funds");

        fundsUSDPortfolio_ui.setEditable(false);
        fundsUSDPortfolio_ui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fundsUSDPortfolio_uiActionPerformed(evt);
            }
        });

        fundsINRPortfolio_ui.setEditable(false);

        jLabel12.setText("USD");

        jLabel13.setText("INR");

        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        portfolioTitle_ui.setFont(new java.awt.Font("Helvetica Neue", 1, 30)); // NOI18N
        portfolioTitle_ui.setText("Raj's Portfolio Page");

        portfolioTable_ui.setDefaultRenderer(Object.class, new MonCellRenderer());
        portfolioTable_ui.setForeground(new java.awt.Color(255, 255, 255));
        portfolioTable_ui.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "stockName", "TransactionId", "Qty", "Market", "BuyPrice", "BuyTotal", "Commission", "BuyDate", "CurrentPrice", "P&L"
            }
        ));
        portfolioTable_ui.setToolTipText("");
        jScrollPane1.setViewportView(portfolioTable_ui);

        portfolioStockTag_ui.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel14.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel14.setText("Buy Stocks");

        jLabel15.setText("StockTag");

        jLabel16.setText("Qty");

        portfolioPrice_ui.setEditable(false);

        portfolioLoadPrice_ui.setText("Load Price");
        portfolioLoadPrice_ui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                portfolioLoadPrice_uiActionPerformed(evt);
            }
        });

        portfolioBuy_ui.setText("Buy Stocks");
        portfolioBuy_ui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                portfolioBuy_uiActionPerformed(evt);
            }
        });

        portfolioComm_ui.setEditable(false);

        jLabel17.setText("Price");

        jLabel18.setText("Commission");

        jLabel19.setText("Portfolio P&L:");

        javax.swing.GroupLayout portfolioPageLayout = new javax.swing.GroupLayout(portfolioPage);
        portfolioPage.setLayout(portfolioPageLayout);
        portfolioPageLayout.setHorizontalGroup(
            portfolioPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, portfolioPageLayout.createSequentialGroup()
                .addContainerGap(261, Short.MAX_VALUE)
                .addGroup(portfolioPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, portfolioPageLayout.createSequentialGroup()
                        .addGroup(portfolioPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(portfolioPageLayout.createSequentialGroup()
                                .addComponent(portfolioTitle_ui)
                                .addGap(89, 89, 89))
                            .addGroup(portfolioPageLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(portfolioPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fundsUSDPortfolio_ui, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                            .addComponent(fundsINRPortfolio_ui))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(portfolioPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, portfolioPageLayout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addContainerGap())))
            .addGroup(portfolioPageLayout.createSequentialGroup()
                .addGroup(portfolioPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(portfolioPageLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(portfolioPageLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(portfolioPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(portfolioPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, portfolioPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(portfolioPageLayout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addGap(18, 18, 18)
                                        .addComponent(portfolioComm_ui))
                                    .addGroup(portfolioPageLayout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addGap(18, 18, 18)
                                        .addComponent(portfolioPrice_ui, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, portfolioPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(portfolioPageLayout.createSequentialGroup()
                                        .addComponent(portfolioStockTag_ui, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(portfolioQty_ui, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(portfolioPageLayout.createSequentialGroup()
                                        .addGap(82, 82, 82)
                                        .addComponent(jLabel14))
                                    .addGroup(portfolioPageLayout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(jLabel15)
                                        .addGap(68, 68, 68)
                                        .addComponent(jLabel16))))
                            .addComponent(portfolioLoadPrice_ui, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(portfolioBuy_ui, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, portfolioPageLayout.createSequentialGroup()
                .addGap(0, 173, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(balance_ui, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(276, 276, 276))
        );
        portfolioPageLayout.setVerticalGroup(
            portfolioPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(portfolioPageLayout.createSequentialGroup()
                .addGroup(portfolioPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(portfolioPageLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(portfolioPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fundsUSDPortfolio_ui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(portfolioPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fundsINRPortfolio_ui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)))
                    .addGroup(portfolioPageLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(portfolioTitle_ui)
                        .addGap(13, 13, 13)
                        .addComponent(jLabel11)))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(portfolioPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(balance_ui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(portfolioPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addGap(2, 2, 2)
                .addGroup(portfolioPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(portfolioStockTag_ui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(portfolioQty_ui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(portfolioPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(portfolioPrice_ui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(12, 12, 12)
                .addGroup(portfolioPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(portfolioComm_ui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(portfolioLoadPrice_ui)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(portfolioBuy_ui)
                .addGap(33, 33, 33)
                .addComponent(jButton3)
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 231, Short.MAX_VALUE)
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
            .addGap(0, 635, Short.MAX_VALUE)
        );

        add(newsPage, "card15");
    }// </editor-fold>//GEN-END:initComponents

    private void loadStocks_ui1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadStocks_ui1ActionPerformed
        // TODO add your handling code here:
        if(String.valueOf(stockMarket_ui.getSelectedItem()).equals("BSE")){
            stkTagPortfolio = new ArrayList<String>();
            loss = new ArrayList<>();
        //BSE Populate Table
            try{
                ArrayList<BSEClass> allBSEStocks  = DbConnectionBSE.readBSETable();
                stocksTableModel.setRowCount(0);
                int i =0;
                for(BSEClass stock: allBSEStocks){
                    Object[] row = new Object[13];

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
                    row[12] = stock.getQty();

                    stkTagPortfolio.add(stock.getStocktag());
                    stocksTableModel.addRow(row);

                    if(stock.getStockprice() < stock.getPrevprice()){
                        down.add(i);
                    }

                    i++;
                }
            }catch(Exception e){e.printStackTrace();}
            
        }
        else if(String.valueOf(stockMarket_ui.getSelectedItem()).equals("NSE")){
            stkTagPortfolio = new ArrayList<String>();
            loss = new ArrayList<>();
        //NSE Populate Table
            try{
                down = new ArrayList<>();
                ArrayList<NSEClass> allNSEStocks  = DbConnectionNSE.readNSETable();
                stocksTableModel.setRowCount(0);
                int i =0;
                for(NSEClass stock: allNSEStocks){
                    Object[] row = new Object[13];

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
                    row[12] = stock.getQty();
                    stkTagPortfolio.add(stock.getStocktag());
                    stocksTableModel.addRow(row);

                    if(stock.getStockprice() < stock.getPrevprice()){
                        down.add(i);
                    }

                    i++;
                }
            }catch(Exception e){e.printStackTrace();}
            
        }
        else if(String.valueOf(stockMarket_ui.getSelectedItem()).equals("NYSE")){
            //NYSE Populate Table
            stkTagPortfolio = new ArrayList<String>();
            loss = new ArrayList<>();
            try{
                down = new ArrayList<>();
                ArrayList<NYSEClass> allNYSEStocks  = DbConnectionNYSE.readNYSETable();
                stocksTableModel.setRowCount(0);
                int i =0;
                for(NYSEClass stock: allNYSEStocks){
                    Object[] row = new Object[13];

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
                    row[12] = stock.getQty();

                    stkTagPortfolio.add(stock.getStocktag());
                    stocksTableModel.addRow(row);

                    if(stock.getStockprice() < stock.getPrevprice()){
                        down.add(i);
                    }

                    i++;
                }
            }catch(Exception e){e.printStackTrace();}
        }
        else{
            stkTagPortfolio = new ArrayList<String>();
            loss = new ArrayList<>();
            try{
                down = new ArrayList<>();
                ArrayList<NeuSEClass> allNeuSEStocks  = DbConnectionNEUSE.readNEUSETable();
                stocksTableModel.setRowCount(0);
                int i =0;
                for(NeuSEClass stock: allNeuSEStocks){
                    Object[] row = new Object[13];

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
                    row[12] = stock.getQty();

                    stkTagPortfolio.add(stock.getStocktag());
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
                        JOptionPane.showMessageDialog(this,"Added Funds!");
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
        refreshPortfolioPage();
        refreshPortfolioTable();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void fundsUSDPortfolio_uiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fundsUSDPortfolio_uiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fundsUSDPortfolio_uiActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        mainProfilePage.setVisible(true);
        portfolioPage.setVisible(false);
        reloadStocksDataTable();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void portfolioLoadPrice_uiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_portfolioLoadPrice_uiActionPerformed
        // TODO add your handling code here:
        TransactionHandler obj = new TransactionHandler();
        BrokerHandler bobj = new BrokerHandler();
        
        selectedTag= String.valueOf(portfolioStockTag_ui.getSelectedItem());
        selectedQty = Integer.parseInt(portfolioQty_ui.getText());
        selectedMarket = String.valueOf(stockMarket_ui.getSelectedItem());
        
        try {
            selectedPrice = obj.buyStock(selectedTag, selectedQty, selectedMarket);
            portfolioPrice_ui.setText(String.valueOf(df.format(selectedPrice)));
            
            selectedBrokerId = bobj.getCustomerBroker(loginId);
            selectedCommission = obj.getCommission(selectedBrokerId, selectedPrice);
            portfolioComm_ui.setText(String.valueOf(df.format(selectedCommission)));
            
        } catch (Exception ex) {ex.printStackTrace();}
    }//GEN-LAST:event_portfolioLoadPrice_uiActionPerformed

    private void portfolioBuy_uiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_portfolioBuy_uiActionPerformed
        // TODO add your handling code here:
        TransactionHandler obj = new TransactionHandler();
        try {
            obj.stockRequest(selectedBrokerId, loginId, selectedQty, selectedMarket, selectedPrice, selectedTag, selectedCommission);
            refreshPortfolioTable();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_portfolioBuy_uiActionPerformed

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
            
            fundsUSDPortfolio_ui.setText(String.valueOf(convertedFunds));
            fundsINRPortfolio_ui.setText(String.valueOf(loginFunds));
        }
        else{
            fundsINR_ui.setText(String.valueOf(convertedFunds));
            fundsUSD_ui.setText(String.valueOf(loginFunds));
            
            fundsINRPortfolio_ui.setText(String.valueOf(convertedFunds));
            fundsUSDPortfolio_ui.setText(String.valueOf(loginFunds));
        }
    }

    private void refreshPortfolioPage() {
        portfolioTitle_ui.setText(loginName+"'s Portfolio Page");
        portfolioStockTag_ui.removeAllItems();
        
        for(int i=0; i<stkTagPortfolio.size();i++){
            portfolioStockTag_ui.addItem(String.valueOf(stkTagPortfolio.get(i)));
        }
    }

    private void refreshPortfolioTable() {
        portfolioTable = (DefaultTableModel) portfolioTable_ui.getModel();
        portfolioTable.setRowCount(0);
        double pnl = 0;
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

                String sql = "Select * from transaction where profileid="+loginId+";";
                p = con.prepareStatement(sql);
                rs = p.executeQuery();
                Object[] row = new Object[11];
                int m =0;
                down = new ArrayList<>();
                    while (rs.next()) 
                    {   
                            row[0] = rs.getString("stocktag");
                            row[1] = rs.getInt("transactionid");
                            row[2] = rs.getInt("qty");
                            row[3] = rs.getString("type");
                            
                            portType = rs.getString("type");
                            portStockTag = rs.getString("stocktag");
                            row[4] = rs.getDouble("stockprice");
                            row[5] = rs.getDouble("transactiontotal");
                            row[6] = rs.getDouble("commission");
                            row[7] = rs.getString("transactiondate");

                            getPortfolioValues();
                            
                            row[8] = currPrice;
                            row[9] = currPrice - rs.getDouble("stockprice");
                            double check = currPrice - rs.getDouble("stockprice");
                            
                            pnl+= check;
                            if(check < 0){
                                loss.add(m);
                            }
                            portfolioTable.addRow(row);
                            m++;
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
        balance_ui.setText(String.valueOf(pnl));
    }

    private void getPortfolioValues() throws ClassNotFoundException {
        try
        {
            Connection con1 = null;
            PreparedStatement p1 = null;
            ResultSet rs1 = null;

            String url1= "jdbc:mysql://127.0.0.1:3306/stockdb"; // table details 
            String username1 = "root"; // MySQL credentials
            String password1 = "root123$";

            Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection(url1, username1, password1);

            if (con1 != null) 
            {                                    
                System.out.println("Connected to the database StockDB");
                
                String sql1 = "select * from stocksdatatable"+portType+" WHERE stocktag='"+portStockTag+"';";
                p1 = con1.prepareStatement(sql1);
                rs1 = p1.executeQuery();

                while (rs1.next()) 
                {
                    currPrice = rs1.getDouble("stockprice");
                }
                System.out.println("Fetched Latest stock price");
                }
            }
        catch (SQLException ex)
        {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    private void reloadStocksDataTable() {
        if(String.valueOf(stockMarket_ui.getSelectedItem()).equals("BSE")){
            stkTagPortfolio = new ArrayList<String>();
            loss = new ArrayList<>();
        //BSE Populate Table
            try{
                ArrayList<BSEClass> allBSEStocks  = DbConnectionBSE.readBSETable();
                stocksTableModel.setRowCount(0);
                int i =0;
                for(BSEClass stock: allBSEStocks){
                    Object[] row = new Object[13];

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
                    row[12] = stock.getQty();

                    stkTagPortfolio.add(stock.getStocktag());
                    stocksTableModel.addRow(row);

                    if(stock.getStockprice() < stock.getPrevprice()){
                        down.add(i);
                    }

                    i++;
                }
            }catch(Exception e){e.printStackTrace();}
            
        }
        else if(String.valueOf(stockMarket_ui.getSelectedItem()).equals("NSE")){
            stkTagPortfolio = new ArrayList<String>();
            loss = new ArrayList<>();
        //NSE Populate Table
            try{
                down = new ArrayList<>();
                ArrayList<NSEClass> allNSEStocks  = DbConnectionNSE.readNSETable();
                stocksTableModel.setRowCount(0);
                int i =0;
                for(NSEClass stock: allNSEStocks){
                    Object[] row = new Object[13];

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
                    row[12] = stock.getQty();
                    stkTagPortfolio.add(stock.getStocktag());
                    stocksTableModel.addRow(row);

                    if(stock.getStockprice() < stock.getPrevprice()){
                        down.add(i);
                    }

                    i++;
                }
            }catch(Exception e){e.printStackTrace();}
            
        }
        else if(String.valueOf(stockMarket_ui.getSelectedItem()).equals("NYSE")){
            //NYSE Populate Table
            stkTagPortfolio = new ArrayList<String>();
            loss = new ArrayList<>();
            try{
                down = new ArrayList<>();
                ArrayList<NYSEClass> allNYSEStocks  = DbConnectionNYSE.readNYSETable();
                stocksTableModel.setRowCount(0);
                int i =0;
                for(NYSEClass stock: allNYSEStocks){
                    Object[] row = new Object[13];

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
                    row[12] = stock.getQty();

                    stkTagPortfolio.add(stock.getStocktag());
                    stocksTableModel.addRow(row);

                    if(stock.getStockprice() < stock.getPrevprice()){
                        down.add(i);
                    }

                    i++;
                }
            }catch(Exception e){e.printStackTrace();}
        }
        else{
            stkTagPortfolio = new ArrayList<String>();
            loss = new ArrayList<>();
            try{
                down = new ArrayList<>();
                ArrayList<NeuSEClass> allNeuSEStocks  = DbConnectionNEUSE.readNEUSETable();
                stocksTableModel.setRowCount(0);
                int i =0;
                for(NeuSEClass stock: allNeuSEStocks){
                    Object[] row = new Object[13];

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
                    row[12] = stock.getQty();

                    stkTagPortfolio.add(stock.getStocktag());
                    stocksTableModel.addRow(row);

                    if(stock.getStockprice() < stock.getPrevprice()){
                        down.add(i);
                    }

                    i++;
                }
            }catch(Exception e){e.printStackTrace();}
        }//populate end
        
    }
    
    public class MonCellRenderer extends DefaultTableCellRenderer {

        public Component getTableCellRendererComponent(JTable table, Object value,
                        boolean isSelected, boolean hasFocus, int row, int column) {
            super.getTableCellRendererComponent(table, value,
                            isSelected, hasFocus, row, column);

            if(!down.isEmpty()){
                if (down.contains(row)) {
                    setBackground(Color.decode("#bf0205"));
                } else {
                    setBackground(Color.decode("#3d754e"));
                }
                return this;
            }
            else{
                if (loss.contains(row)) {
                    setBackground(Color.decode("#bf0205"));
                } else {
                    setBackground(Color.decode("#3d754e"));
                }
                return this;
            }
        }  
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addBal_ui;
    private javax.swing.JPanel addFundsPage;
    private javax.swing.JButton addFunds_ui;
    private javax.swing.JTextField balance_ui;
    private javax.swing.JTextField fundsINRPortfolio_ui;
    private javax.swing.JTextField fundsINR_ui;
    private javax.swing.JTextField fundsUSDPortfolio_ui;
    private javax.swing.JTextField fundsUSD_ui;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JButton loadStocks_ui1;
    private javax.swing.JPanel mainProfilePage;
    private javax.swing.JPanel newsPage;
    private javax.swing.JButton portfolioBuy_ui;
    private javax.swing.JTextField portfolioComm_ui;
    private javax.swing.JButton portfolioLoadPrice_ui;
    private javax.swing.JPanel portfolioPage;
    private javax.swing.JTextField portfolioPrice_ui;
    private javax.swing.JTextField portfolioQty_ui;
    private javax.swing.JComboBox<String> portfolioStockTag_ui;
    private javax.swing.JTable portfolioTable_ui;
    private javax.swing.JLabel portfolioTitle_ui;
    private javax.swing.JComboBox<String> stockMarket_ui;
    private javax.swing.JTable stocksTable;
    // End of variables declaration//GEN-END:variables
}