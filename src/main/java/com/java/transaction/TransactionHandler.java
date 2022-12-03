/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.transaction;

import com.java.stocks.BSEClass;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author rajmehta
 */
public class TransactionHandler {
    
    double commRate;
    int stkQty;
    double stkPrice;
    double stkPriceTotal;
    double funds;
    String fundstype;
    
    public double buyStock(String stockTag, int qty, String marketType) throws ClassNotFoundException{
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

                String sql = "select * from stocksdatatable"+marketType+" WHERE stocktag = '"+stockTag+"';";
                p = con.prepareStatement(sql);
                rs = p.executeQuery();

                while (rs.next()) 
                {
                    stkQty = rs.getInt("qty");
                    if(stkQty<qty){
                        System.out.println("Cannot Buy stocks more than available Quantity");
                    }
                    else{
                        stkPrice = rs.getDouble("stockprice");
                        stkPriceTotal = stkPrice * qty;
                    }
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
        return stkPriceTotal;  
    }
    
    public double getCommission(int brokerId, double price) throws ClassNotFoundException{
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

                String sql = "select * from broker WHERE brokerid="+brokerId+";";
                p = con.prepareStatement(sql);
                rs = p.executeQuery();

                while (rs.next()) 
                {
                    commRate = rs.getDouble("commissionrate");
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
        return price*(commRate/100);   
    }
    
    public void stockRequest(int brokerId, int profileId, int qty, String type, double stkpricetotal, String stktag, double commission) throws ClassNotFoundException{
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

                String sql = "select * from stocksdatatable"+type+" WHERE stocktag = '"+stktag+"';";
                p = con.prepareStatement(sql);
                rs = p.executeQuery();

                while (rs.next()) 
                {
                    stkPrice = rs.getDouble("stockprice");
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

                String sql = "Insert into transaction (brokerid, profileid, qty, type, stockprice, transactiontotal, stocktag, commission, transactiondate, action) VALUES ("+brokerId+"," +profileId+","+ qty+",'"+type+"',"+stkPrice+","+stkpricetotal+",'" +stktag+"',"+commission+",SYSDATE(),'PENDING');";
                System.out.println(sql);
                p = con.prepareStatement(sql);
                int rowInsert = p.executeUpdate(); 
                if(rowInsert > 0){
                    System.out.println("Added Transaction");
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
    }
    
    public void ApproveStkReq(int transactionid, double tprice, double commission, int profId, String type, int qty) throws ClassNotFoundException{
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

                String sql = "UPDATE transaction SET action = 'APPROVED' WHERE transactionid = "+transactionid+";";
                System.out.println(sql);
                p = con.prepareStatement(sql);
                int rowInsert = p.executeUpdate(); 
                if(rowInsert > 0){
                    System.out.println("Added Transaction");
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
        
        //get profile balance
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

                String sql = "select * from profile WHERE id="+profId+";";
                p = con.prepareStatement(sql);
                rs = p.executeQuery();

                while (rs.next()) 
                {
                    funds = rs.getDouble("funds");
                    fundstype = rs.getString("fundstype");
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
        
        if(fundstype.equals("INR") && type.equals("NSE")){
            funds = funds - (commission + tprice);
        }
        else if(fundstype.equals("INR") && type.equals("BSE")){
            funds = funds - (commission + tprice);
        }
        else if(fundstype.equals("USD") && type.equals("NYSE")){
            funds = funds - (commission + tprice);
        }
        else if(fundstype.equals("USD") && type.equals("NEUSE")){
            funds = funds - (commission + tprice);
        }
        else if(fundstype.equals("USD") && type.equals("NSE") || fundstype.equals("USD") && type.equals("BSE")){
            funds = funds - ((commission + tprice)/80);
        }
        else if(fundstype.equals("INR") && type.equals("NYSE") || fundstype.equals("INR") && type.equals("NEUSE")){
            funds = funds - ((commission + tprice)*80);
        }
        else{System.out.println("Funds Coversion error");}
        
        
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

                String sql = "UPDATE profile SET funds = "+funds+" WHERE id = "+profId+";";
                System.out.println(sql);
                p = con.prepareStatement(sql);
                int rowInsert = p.executeUpdate(); 
                if(rowInsert > 0){
                    System.out.println("Approved Transaction");
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
        
    }
    
    public double sellStock(){
    
        return 0;
    }
}
