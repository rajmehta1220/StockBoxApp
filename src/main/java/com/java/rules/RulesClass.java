/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.rules;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author aakashbhatt
 */
public class RulesClass {

    
    double transactiontotal;
    double sumoftransaction;
    int id;
    String type;
    String profile_type;
    String transactiondate;
    
    
    
    
    public ArrayList RulesValidation(String type) throws SQLException, ClassNotFoundException {
        //Fetching the transaction details of a user
        ArrayList<Integer> rulesInvalidate = new ArrayList<>();
        String profReg = "";
        try{
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

                String sql = "SELECT sum(transactiontotal) , profileid from transaction group by profileid;";
                p = con.prepareStatement(sql);
                rs = p.executeQuery();
                Object[] tran=new Object[3];
                while (rs.next()) 
                {
                    tran[0] = rs.getInt("profileid");
                    tran[1]= rs.getDouble("sum(transactiontotal)");
                    
                    Connection con1 = null;
                    PreparedStatement p1 = null;
                    ResultSet rs1 = null;

                    String url1= "jdbc:mysql://127.0.0.1:3306/stockdb"; // table details 
                    String username1 = "root"; // MySQL credentials
                    String password1 = "root123$";
                    
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con1 = DriverManager.getConnection(url1, username1, password1);
                    

                    String sql1 = "SELECT * from profile WHERE id="+rs.getInt("profileid")+";";
                    p1 = con.prepareStatement(sql1);
                    rs1 = p1.executeQuery();
                    while(rs1.next()){
                        String typeProf = rs1.getString("type");
                        if(typeProf.equals("Customer") && rs.getDouble("sum(transactiontotal)")>100000 && rs1.getString("region").equals(type)){
                            rulesInvalidate.add(rs.getInt("profileid"));
                        }
                        else if(typeProf.equals("Business") && rs.getDouble("sum(transactiontotal)")>200000 && rs1.getString("region").equals(type)){
                            rulesInvalidate.add(rs.getInt("profileid"));
                        }
                        else if(typeProf.equals("Investor") && rs.getDouble("sum(transactiontotal)")>300000 && rs1.getString("region").equals(type)){
                            rulesInvalidate.add(rs.getInt("profileid"));
                        }
                        
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
        
     return rulesInvalidate;   
    }
    
    public double returnTransTotal(int profileid) throws ClassNotFoundException{
        double tt = 0;
        try{
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

                String sql = "SELECT sum(transactiontotal) , profileid from transaction group by profileid";
                p = con.prepareStatement(sql);
                rs = p.executeQuery();
                Object[] tran=new Object[3];
                while (rs.next()) 
                {
                    if(profileid == rs.getInt("profileid")){
                        tt = rs.getDouble("sum(transactiontotal)");
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
        
     return tt;   
    
    }
    
    public String returnProfType(int profileid) throws ClassNotFoundException{
        String type = "";
        try{
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

                String sql = "SELECT * from profile where id="+profileid+";";
                p = con.prepareStatement(sql);
                rs = p.executeQuery();
                while (rs.next()) 
                {
                    type= rs.getString("region");
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
        
     return type;   
    
    }
    
}