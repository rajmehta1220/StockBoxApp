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
import java.util.List;
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
    
    public MainPanel(){
        initComponents();
        
        //UI Elements
        DefaultTableModel BSETableModel = (DefaultTableModel) BSETable.getModel();
        DefaultTableModel NSETableModel = (DefaultTableModel) NSETable.getModel();
        DefaultTableModel NYSETableModel = (DefaultTableModel) NYSETable.getModel();
        
        //Variables
        
        
        //Objects
        SEBProfileClass sebverify = new SEBProfileClass();
       
        //BSE Populate Table
        try{
            ArrayList<BSEClass> allBSEStocks  = DbConnectionBSE.readBSETable();
            BSETableModel.setRowCount(0);
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
                
                BSETableModel.addRow(row);
                
                if(stock.getStockprice() < stock.getPrevprice()){
                    down.add(i);
                }
                
                i++;
            }
        }catch(Exception e){e.printStackTrace();}
        
        //NSE Populate Table
        try{
            down = new ArrayList<>();
            ArrayList<NSEClass> allNSEStocks  = DbConnectionNSE.readNSETable();
            NSETableModel.setRowCount(0);
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
                
                NSETableModel.addRow(row);
                
                if(stock.getStockprice() < stock.getPrevprice()){
                    down.add(i);
                }
                
                i++;
            }
        }catch(Exception e){e.printStackTrace();}
        
        //NYSE Populate Table
        try{
            ArrayList<NYSEClass> allNYSEStocks  = DbConnectionNYSE.readNYSETable();
            NYSETableModel.setRowCount(0);
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
                
                NYSETableModel.addRow(row);
                
                if(stock.getStockprice() < stock.getPrevprice()){
                    down.add(i);
                }
                
                i++;
            }
        }catch(Exception e){e.printStackTrace();}
        
        //verify is SEBProfile Exist
        try{
            Object[] loginProfileSEB = (Object[]) sebverify.verifySEBProfile(185047);
            sebverify.banUser(1);
            JOptionPane.showMessageDialog(this, loginProfileSEB[1] + " "+ loginProfileSEB[2]+ " "+ loginProfileSEB[3]);
        }catch(Exception e){e.printStackTrace();}
      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        NYSETable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        BSETable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        NSETable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        NYSETable.setDefaultRenderer(Object.class, new MonCellRenderer());
        NYSETable.setForeground(new java.awt.Color(255, 255, 255));
        NYSETable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "stocktag", "stockname", "date", "type", "stockprice", "changerate", "currency", "bid", "dayHigh", "dayLow", "lastfetched", "prevprice"
            }
        ));
        jScrollPane1.setViewportView(NYSETable);

        BSETable.setDefaultRenderer(Object.class, new MonCellRenderer());
        BSETable.setForeground(new java.awt.Color(255, 255, 255));
        BSETable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "stocktag", "stockname", "date", "type", "stockprice", "changerate", "currency", "bid", "dayHigh", "dayLow", "lastfetched", "prevprice"
            }
        ));
        jScrollPane2.setViewportView(BSETable);

        NSETable.setDefaultRenderer(Object.class, new MonCellRenderer());
        NSETable.setForeground(new java.awt.Color(255, 255, 255));
        NSETable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "stocktag", "stockname", "date", "type", "stockprice", "changerate", "currency", "bid", "dayHigh", "dayLow", "lastfetched", "prevprice"
            }
        ));
        jScrollPane3.setViewportView(NSETable);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel1.setText("BSE Stock Market");

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel2.setText("NYSE Stock Market");

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel3.setText("NSE Stock Market");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 917, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 917, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(433, 433, 433)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(339, 339, 339))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(337, 337, 337))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JTable BSETable;
    private javax.swing.JTable NSETable;
    private javax.swing.JTable NYSETable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
