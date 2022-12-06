/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Company;

import com.java.broker.Broker;
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
public class CompanyHandler {
    
     public ArrayList viewAllCompanyInfo(String companyname) throws ClassNotFoundException{
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

                String sql = "select * from Company where companyname = '"+companyname+"';";
                
                System.out.println(sql);
                p = con.prepareStatement(sql);
                rs = p.executeQuery();
                ArrayList<Company> allCompanyList= new ArrayList<Company>();

                while (rs.next()) 
                {
                    Company obj = new Company();
                        String cname = rs.getString("companyname");
                        double revenue= rs.getDouble("revenue");
                        String region= rs.getString("region");
                        String type = rs.getString("type");
                        double listingprice = rs.getDouble("listingprice");
                        int qty = rs.getInt("qty");

                    obj.setCompanyname(cname);
                    obj.setRevenue(revenue);
                    obj.setRegion(region);
                    obj.setType(type);
                    obj.setListingprice(listingprice);
                    obj.setQty(qty);

                    allCompanyList.add(obj);
                }
                return allCompanyList;
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
