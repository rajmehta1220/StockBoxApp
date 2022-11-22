package com.java.dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {
    public static void main(String[] args) throws Exception
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
                System.out.println(name + "\t\t" + price+ "\t\t" + tag);
            }       
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
