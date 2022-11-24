/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.dbconn;

/**
 *
 * @author rajmehta
 */
import com.java.stocks.BSEClass;
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
public class DbConnectionBSE {
   
    
    public static void main(String[] args) throws Exception
    {
    }

    public static ArrayList readBSETable() throws ClassNotFoundException {
        try 
        {
            ArrayList<BSEClass> allBSEStocks = new ArrayList<BSEClass>();
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

                String sql = "select * from stocksdatatableBSE";
                p = con.prepareStatement(sql);
                rs = p.executeQuery();

                // Printing ID, name, email of customers
                // of the SQL command above
                System.out.println("stockname\t\tstockprice\t\tstocktag");

                while (rs.next()) 
                {
                    BSEClass obj = new BSEClass();

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
                    

                    allBSEStocks.add(obj);
                    System.out.println("OBJ: "+obj);
                }
                return allBSEStocks;
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
    public static Object readBSEStock(String stocktag) throws ClassNotFoundException, SQLException{
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

                    String sql = "select * from stocksdatatableBSE where stocktag = '"+stocktag+"';";
                    p = con.prepareStatement(sql);
                    rs = p.executeQuery();

                    // Printing ID, name, email of customers
                    // of the SQL command above
                    System.out.println("stockname\t\tstockprice\t\tstocktag");
                    Object[] stock = new Object[12];
                    while (rs.next()) 
                    {
                        stock[0] = rs.getString("stockname");
                        stock[1]= rs.getDouble("stockprice");
                        stock[2] = rs.getString("stocktag");
                        stock[3] = rs.getString("type");
                        stock[4] = rs.getDouble("changerate");
                        stock[5] =rs.getString("currency");
                        stock[6] = rs.getDouble("bid");
                        stock[7] = rs.getDouble("dayhigh");
                        stock[8] = rs.getDouble("prevprice");
                        stock[9] = rs.getDouble("daylow");
                        stock[10] = rs.getDate("lastfetched");

                      
                    }
                    return stock;
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
    
    public void deleteBSEStock(String stocktag) throws ClassNotFoundException{
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

                    String sql = "delete * from stocksdatatableBSE where stocktag = '"+stocktag+"';";
                    p = con.prepareStatement(sql);
//                    rs = p.executeQuery();
                    
                    int rowsDeleted = p.executeUpdate();
                    if (rowsDeleted > 0) {
                        System.out.println("A user was deleted successfully!");
                    }
                    // Printing ID, name, email of customers
                    // of the SQL command above
//                    System.out.println("stockname\t\tstockprice\t\tstocktag");
//                    Object[] stock = new Object[12];
//                    while (rs.next()) 
//                    {
//                        stock[0] = rs.getString("stockname");
//                        stock[1]= rs.getDouble("stockprice");
//                        stock[2] = rs.getString("stocktag");
//                        stock[3] = rs.getString("type");
//                        stock[4] = rs.getDouble("changerate");
//                        stock[5] =rs.getString("currency");
//                        stock[6] = rs.getDouble("bid");
//                        stock[7] = rs.getDouble("dayhigh");
//                        stock[8] = rs.getDouble("prevprice");
//                        stock[9] = rs.getDouble("daylow");
//                        stock[10] = rs.getDate("lastfetched");
//
//                      
//                    }
                    
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

}
