package com.java.dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.tree.DefaultTreeModel;

public class DbConnectionNSE {
    public static void main(String[] args) throws Exception
    {
        DefaultTreeModel NSETable=null;
        readNSETable(NSETable);
    }
    public static DefaultTreeModel readNSETable(DefaultTreeModel NSETable) throws ClassNotFoundException
    {

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
            
            String sql = "select * from stocksdatatableNSE";
            p = con.prepareStatement(sql);
            rs = p.executeQuery();

            // Printing ID, name, email of customers
            // of the SQL command above
            System.out.println("stockname\t\tstockprice\t\tstocktag");

            // Condition check
            while (rs.next()) 
            {
                String name = rs.getString("stockname");
                double price = rs.getDouble("stockprice");
                String tag = rs.getString("stocktag");
                model=(DefaultTableModel) NSETable.getModel();
                model.setRowCount(0);
                 Object[] row=new Object[3];
                 row[0]=rs.getString("stockname");
                 row[1]=rs.getDouble("stockprice");
                 row[2]=rs.getString("stocktag");
                 row[3]=rs.getString("type");
                 row[4]=rs.getDate("stockdate");
                 row[5]=rs.getString("currency");
                 row[6]=rs.getDouble("changerate");
                 row[7]=rs.getDouble("bid");
                 row[8]=rs.getDouble("dayhigh");
                 row[9]=rs.getDouble("daylow");
                 row[10]=rs.getDate("lastfetched");
                 
   
                 model.addRow(row);
                 System.out.println(name+"\t\t"+price+"\t\t"+tag);
                
            } 
            return NSETable;
        }
    } 
    catch (SQLException ex) 
    {
        // handle any errors
        System.out.println("SQLException: " + ex.getMessage());
        System.out.println("SQLState: " + ex.getSQLState());
        System.out.println("VendorError: " + ex.getErrorCode());
    }
    }//main end
}
