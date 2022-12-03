/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.broker;

import com.java.profile.Profile;
import com.java.stocks.BSEClass;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import com.java.broker.Broker;

/**
 *
 * @author rajmehta
 */
public class BrokerHandler {
    
    public ArrayList viewAllBrokerInfo(String custRegion) throws ClassNotFoundException{
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

                String sql = "select * from broker where region = '"+custRegion+"';";
                
                System.out.println(sql);
                p = con.prepareStatement(sql);
                rs = p.executeQuery();
                ArrayList<Broker> allBrokerList= new ArrayList<Broker>();

                while (rs.next()) 
                {
                    Broker obj = new Broker();

                    int brokerid = rs.getInt("brokerid");
                    String name = rs.getString("name");
                    String region = rs.getString("region");
                    double commission = rs.getDouble("commission");
                    double commissionrate = rs.getDouble("commissionrate");
                    String bpassword =rs.getString("password");

                    obj.setName(name);
                    obj.setBrokerid(brokerid);
                    obj.setRegion(region);
                    obj.setCommission(commission);
                    obj.setCommissionrate(commissionrate);
                    obj.setPassword(bpassword);

                    allBrokerList.add(obj);
                }
                return allBrokerList;
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
    
    public void assignBrokertoProfile(int profileId, int brokerId) throws ClassNotFoundException{
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

                String sql = "Insert into brokerToCustomer (brokerid, id) VALUES ("+brokerId+","+profileId+");";
                p = con.prepareStatement(sql);
                int rowInsert = p.executeUpdate(); 
                if(rowInsert > 0){
                    System.out.println("Assigned Broker to Customer");
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
    
    public ArrayList viewAllProfileToBroker(int brokerId) throws ClassNotFoundException{
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

                String sql = "select id from brokerToCustomer where brokerid = "+brokerId+";";
                System.out.println(sql);
                
                p = con.prepareStatement(sql);
                rs = p.executeQuery();
                ArrayList<Profile> allProfforBrokList= new ArrayList<Profile>();
                ArrayList<Integer> CustforBrok= new ArrayList<Integer>();

                while (rs.next()) 
                {
                    Broker obj = new Broker();

                    int brokerid = rs.getInt("id");
                    CustforBrok.add(brokerid);
                }
                
                for(int i=0; i<CustforBrok.size(); i++){
                     sql = "select * from profile where id = "+CustforBrok.get(i)+";";
                     p = con.prepareStatement(sql);
                     rs = p.executeQuery();
                     
                     while (rs.next()) 
                    {
                        Profile obj = new Profile();

                        int id = rs.getInt("id");
                        String name= rs.getString("name");
                        double funds=rs.getDouble("funds");
                        String region=rs.getString("region"); 
                        double balance=rs.getDouble("balance");
                        String type= rs.getString("type");
                        String Ppassword= rs.getString("password");
                        String fundstype= rs.getString("fundstype");

                        obj.setId(id);
                        obj.setName(name);
                        obj.setFunds(funds);
                        obj.setRegion(region);
                        obj.setBalance(balance);
                        obj.setType(type);
                        obj.setPassword(Ppassword);
                        obj.setFundstype(fundstype);

                        allProfforBrokList.add(obj);
                    }
                }
                return allProfforBrokList;
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
    
    public int getCustomerBroker(int id) throws ClassNotFoundException{
        int brokerid = 0;
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

                String sql = "select * from brokerToCustomer where id = "+id+";";
                System.out.println(sql);
                
                p = con.prepareStatement(sql);
                rs = p.executeQuery();
                ArrayList<Profile> allProfforBrokList= new ArrayList<Profile>();
                ArrayList<Integer> CustforBrok= new ArrayList<Integer>();

                while (rs.next()) 
                {
                    brokerid = rs.getInt("brokerid");
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
        return brokerid;
    }
    
}
