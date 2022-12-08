/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.sebprofiles;

import com.java.stocks.NYSEClass;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author rajmehta
 */
public class SEBProfileClass {
    
    public Object verifySEBProfile(int verifyId) throws ClassNotFoundException {
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

                String sql = "select * from SEBtable";
                p = con.prepareStatement(sql);
                rs = p.executeQuery();

                boolean flag = false;
                String region = "";
                Object[] loginProfile = new Object[4];
                
                while (rs.next()) 
                {
                    if(rs.getInt("id") == verifyId){
                        flag = true;
                        loginProfile[0] = rs.getInt("id");
                        loginProfile[1] = rs.getString("name");
                        loginProfile[2] = rs.getString("board");
                        loginProfile[3] = rs.getString("region");
                    }
                }
                
               return loginProfile;
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
    
    public void banUser(int banId)throws ClassNotFoundException {
        
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

                String sql = "delete from brokerToCustomer where id = "+banId+";";
                p = con.prepareStatement(sql);
                int rowDeleted = p.executeUpdate(); 
                if(rowDeleted > 0){
                    System.out.println("Banned User "+banId);
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

                String sql = "delete from transaction where profileid = "+banId+";";
                p = con.prepareStatement(sql);
                int rowDeleted = p.executeUpdate(); 
                if(rowDeleted > 0){
                    System.out.println("Banned User "+banId);
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

                String sql = "delete from profile where id = "+banId+";";
                p = con.prepareStatement(sql);
                int rowDeleted = p.executeUpdate(); 
                if(rowDeleted > 0){
                    System.out.println("Banned User "+banId);
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
    
    public void approveIPO(String companyName, Object[] stock,String board, double qty)throws ClassNotFoundException{
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

                String sql = "INSERT INTO stocksdatatable" +board+ " (stockname,stocktag,stockdate,type,stockprice,changerate,currency,bid,dayhigh,daylow,lastfetched,prevprice,qty) VALUES ('" +stock[0]+ "','" +stock[1]+ "',SYSDATE(), '" +stock[3]+ "',"+stock[4]+ ","+stock[5]+ ",'"+stock[6]+ "',"+stock[7]+ ","+stock[8]+ ","+stock[9]+ ",CURRENT_TIMESTAMP(),"+stock[11]+","+qty+ ");";

                p = con.prepareStatement(sql);
                int rowDeleted = p.executeUpdate(); 
                if(rowDeleted > 0){
                    System.out.println("Approved IPO for "+stock[0]);
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
    
    public void rejectIPO(String companyName) throws ClassNotFoundException{
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
                String sql = "delete from company where companyname = '"+companyName+"';";
                p = con.prepareStatement(sql);
                int rowDeleted = p.executeUpdate(); 
                if(rowDeleted > 0){
                    System.out.println("Rejected IPO for "+companyName);
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
    
}//end class
