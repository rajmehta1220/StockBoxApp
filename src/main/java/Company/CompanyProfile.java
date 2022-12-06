/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Hp
 */
public class CompanyProfile {
   
    public Object verifyCompanyProfile(String companyname) throws ClassNotFoundException, SQLException {
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

                String sql = "select * from Company";
                p = con.prepareStatement(sql);
                rs = p.executeQuery();

                boolean flag = false;
                String region = "";
                Object[] companyProfile = new Object[7];
                
                while (rs.next()) 
                {
                   if((rs.getString("companyname")).equalsIgnoreCase(companyname))
                    {
                        flag = true;
                        companyProfile[0] = rs.getString("companyname");
                        companyProfile[1] = rs.getDouble("revenue");
                        companyProfile[2] = rs.getString("region");
                        companyProfile[3] = rs.getString("type");
                        companyProfile[4] = rs.getDouble("listingprice");
                        companyProfile[5] = rs.getInt("qty");
                        companyProfile[7] = rs.getString("password");
                    }
                }
                
               return companyProfile;
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
    
    
   public Object createCompanyProfile(String companyname, double revenue,String region,String type,double listingprice,int qty, String cpassword) throws ClassNotFoundException, SQLException {
       Object[] companyProfile = new Object[7]; 
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

                String sql = "INSERT INTO company(revenue,companyname,region,type,listingprice,qty,password) VALUES ("+revenue+",'"+companyname+"','"+region+"','"+type+"',"+listingprice+","+qty+",'"+cpassword+"');";
                p = con.prepareStatement(sql);
                int rowInsert = p.executeUpdate(); 
                if(rowInsert > 0){
                    System.out.print("Created Company Successfully");
                }
                else{System.out.print("Company Already Exists");}
            }
      
        return companyProfile;
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