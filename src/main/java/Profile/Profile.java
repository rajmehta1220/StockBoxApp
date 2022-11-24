/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Profile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Profile {
    
    public Object verifyProfile(int verifyId) throws ClassNotFoundException, SQLException {
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

                String sql = "select * from Profile";
                p = con.prepareStatement(sql);
                rs = p.executeQuery();

                boolean flag = false;
                String region = "";
                Object[] loginProfile = new Object[6];
                
                while (rs.next()) 
                {
                    if(rs.getInt("id") == verifyId){
                        flag = true;
                        loginProfile[0] = rs.getInt("id");
                        loginProfile[1] = rs.getString("name");
                        loginProfile[2] = rs.getDouble("funds");
                        loginProfile[3] = rs.getString("region");
                        loginProfile[4] = rs.getDouble("balance");
                        loginProfile[5] = rs.getString("type");
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
    
    /*public void banUser(int banId)throws ClassNotFoundException {
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
    
//    public void approveIPO(String companyName, String board)throws ClassNotFoundException{
//        try 
//        {
//            Connection con = null;
//            PreparedStatement p = null;
//            ResultSet rs = null;
//
//            String url= "jdbc:mysql://127.0.0.1:3306/stockdb"; // table details 
//            String username = "root"; // MySQL credentials
//            String password = "root123$";
//
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            con = DriverManager.getConnection(url, username, password);
//
//            if (con != null) 
//            {
//                System.out.println("Connected to the database StockDB");
//
//                String sql = "INSERT INTO stocksdatatableBSE(stockname,stocktag,stockdate,type,stockprice,changerate,currency,bid,dayhigh,daylow,lastfetched,prevprice) VALUES ("'+stockname+'","'+stocktag+'",'+stockdate+',"'+stocktype+'",'+stockprice+','+changerate+',"'+currency+'",'+bid+','+dayhigh+','+daylow+','+lastfetched+','+prevPrice+');'
//
//                p = con.prepareStatement(sql);
//                rs = p.executeQuery();
//
//                boolean flag = false;
//                String region = "";
//                Object[] loginProfile = new Object[4];
//                
//                while (rs.next()) 
//                {
//                    if(rs.getInt("id") == verifyId){
//                        flag = true;
//                        loginProfile[0] = rs.getInt("id");
//                        loginProfile[1] = rs.getString("name");
//                        loginProfile[2] = rs.getString("board");
//                        loginProfile[3] = rs.getString("region");
//                    }
//                }
//            }
//        } 
//        catch (SQLException ex) 
//        {
//            // handle any errors
//            System.out.println("SQLException: " + ex.getMessage());
//            System.out.println("SQLState: " + ex.getSQLState());
//            System.out.println("VendorError: " + ex.getErrorCode());
//        }
//        
//    }*/
}
