/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.dbconn;

/**
 *
 * @author rajmehta
 */
import com.java.stocks.NSEClass;
import com.java.stocks.NYSEClass;
import com.java.ui.MainPanel;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultTreeModel;
public class DbConnectionNYSE {
   
    
    public static void main(String[] args) throws Exception
    {
    }

    public static ArrayList readNYSETable() throws ClassNotFoundException {
        try 
        {
            ArrayList<NYSEClass> allNYSEStocks = new ArrayList<NYSEClass>();
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

                String sql = "select * from stocksdatatableNYSE";
                p = con.prepareStatement(sql);
                rs = p.executeQuery();


                while (rs.next()) 
                {
                    NYSEClass obj = new NYSEClass();

                    String name = rs.getString("stockname");
                    double stockprice = rs.getDouble("stockprice");
                    String tag = rs.getString("stocktag");
                    String type = rs.getString("type");
                    double changerate = rs.getDouble("changerate");
                    String currency =rs.getString("currency");
                    double bid = rs.getDouble("bid");
                    double dayhigh = rs.getDouble("dayhigh");
                    double prevprice = rs.getDouble("prevprice");
                    double daylow = rs.getDouble("daylow");
                    Date lastfetched = rs.getDate("lastfetched");

                    obj.setStockname(name);
                    obj.setStockprice(stockprice);
                    obj.setStocktag(tag);
                    obj.setType(type);
                    obj.setBid(bid);
                    obj.setChangerate(changerate);
                    obj.setDayhigh(dayhigh);
                    obj.setDaylow(daylow);
                    obj.setCurency(currency);
                    obj.setPrevprice(prevprice);
                    obj.setLastfetched(String.valueOf(lastfetched));
                    obj.setDate(String.valueOf(rs.getDate("stockdate")));
                    

                    allNYSEStocks.add(obj);
                    System.out.println("OBJ: "+obj);
                }
                return allNYSEStocks;
            }
    } 
    catch (SQLException ex) 
    {
        // handle any errors
        System.out.println("SQLException: " + ex.getMessage());
        System.out.println("SQLState: " + ex.getSQLState());
        System.out.println("VendorError: " + ex.getErrorCode());
    }
    return null;
    }
}
