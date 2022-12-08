/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.ipo;

import Company.Company;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Hp
 */
public class IPO {
    
    String companyname;
     double revenue;
     String region;
     String type;
     double listingprice;
     int qty;
     String password;

    /*public IPO(String companyname, double revenue, String region, String type, double listingprice, int qty, String password) {
        this.companyname = companyname;
        this.revenue = revenue;
        this.region = region;
        this.type = type;
        this.listingprice = listingprice;
        this.qty = qty;
        this.password = password;
    }*/

   /* public IPO() 
    {
    }*/

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getListingprice() {
        return listingprice;
    }

    public void setListingprice(double listingprice) {
        this.listingprice = listingprice;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
    
     public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

     public void ApproveIPOReq(String companyname, double revenue, String region, String type, double listingprice, int qty, String cpassword,String currency) throws ClassNotFoundException{
        
         if(region.equalsIgnoreCase("INDIA"))
         {
             type="NSE";
             currency="INR";
         }
         else if(region.equalsIgnoreCase("USA")) 
         {
             type="NYSE";
             currency="USD";
         }
          else if(region.equalsIgnoreCase("BOSTON")) 
         {
             type="NEUSE";
             currency="USD";
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

                String sql = "INSERT INTO stocksdatatable"+type+" (stockname, stocktag, type, stockdate, stockprice, changerate, bid, dayhigh, daylow, lastfetched, prevprice, currency, qty) VALUES('"+companyname+"','" +companyname+"', '"+type+"', SYSDATE(), "+listingprice+", 0, 0, 0, 0, CURRENT_TIMESTAMP, 0, '"+currency+"', "+qty+");";
                System.out.println(sql);
                p = con.prepareStatement(sql);
                int rowInsert = p.executeUpdate(); 
                if(rowInsert > 0){
                    System.out.println("Approved IPO");
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
      public void RejectIPOReq(String companyname) throws ClassNotFoundException{
        
         
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

                String sql = "DELETE FROM company WHERE companyname='"+companyname+"';";
                
                System.out.println(sql);
                p = con.prepareStatement(sql);
                int rowInsert = p.executeUpdate(); 
                if(rowInsert > 0){
                    System.out.println("Rejected IPO!");
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
      
       public ArrayList autoTrigger(String region) throws ClassNotFoundException{
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

                String sql = "select * from company where region ='"+region+"';";
                
                System.out.println(sql);
                p = con.prepareStatement(sql);
                rs = p.executeQuery();
                ArrayList<String> rulesInvalidateCompany= new ArrayList<>();

                while (rs.next()) 
                {
                    
                        String cname = rs.getString("companyname");
                        double revenue= rs.getDouble("revenue");
                        if(region.equals("INDIA") && revenue<2000000){
                            rulesInvalidateCompany.add(cname);
                        }
                        else if(region.equals("USA") && revenue<200000){
                            rulesInvalidateCompany.add(cname);
                        }
                        else if(region.equals("BOSTON") && revenue<150000){
                            rulesInvalidateCompany.add(cname);
                        }
                        else{System.out.print("Region or revenue Error");} 
                }
                return rulesInvalidateCompany;
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
