/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.neustockgenerator;

import com.java.University.College;
import com.java.University.CourseDirectory;
import com.java.University.Department;
import com.java.University.Professor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author aakashbhatt
 */
public class NeuStocks {

    public void generateNeuStocks(Department dept) throws ClassNotFoundException{
        int counter = 0;
        double price = 0;
        Random random = new Random();
        double changerate = 0;
        double prevprice = 0;
        double daylow = 0;
        double dayhigh = 0;
        String stocktag;
        double bid = 0;
        String type = "NEUSE";
        
        boolean flag;
        
        for(CourseDirectory c: dept.getCoursedir()){
            
            counter = c.getProfessor().size();
            while(price == 0){
                price = counter * (random.nextDouble() * (3050.84 - 50.24)+50.24);
//                price = counter *(random.nextDouble(3050.84 - 50.24)+50.24);
            }
            flag = random.nextBoolean();
            if(flag){
                prevprice = price - (random.nextDouble() * (20.12 - 0.24)+0.24);
//                prevprice = price - (random.nextDouble(20.12 - 0.24)+0.24); 
            }
            else {
                prevprice = price + (random.nextDouble() * (13.12 - 1.24)+1.24);
//                prevprice = price + (random.nextDouble(20.12 - 0.24)+0.24); 
            }
            stocktag = c.getCourse_name();
            changerate = price - prevprice;
            dayhigh = price + (random.nextDouble() * (50.12 - 10)+10);
            daylow = price - (random.nextDouble() * (50.12 - 10)+10);
//            dayhigh = price + (random.nextDouble(50.12 - 10)+10);
//            daylow = price - (random.nextDouble(50.12 - 10)+10);
            bid = price + 1;
            
            System.out.println("Stock Name: "+c.getCourse_name()+" Price: "+price+ " Prev Price : "+prevprice+" Change Rate: "+changerate+" dayhigh :"+dayhigh+" daylow: "+daylow);
            System.out.println();
            System.out.println("/////////////////////////");
            
            
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

                    String sql = "INSERT INTO stocksdatatableNEUSE (stockname, stocktag, type, stockdate, stockprice, changerate, bid, dayhigh, daylow, lastfetched, prevprice, currency) VALUES('"+c.getCourse_name()+"','" +c.getCourse_name()+"', '"+type+"', SYSDATE(), "+price+", "+changerate+", "+bid+", "+dayhigh+", "+daylow+", CURRENT_TIMESTAMP, "+prevprice+", 'USD');";
                    p = con.prepareStatement(sql);
                    
                    int a = p.executeUpdate();
                    if(a>0){
                        System.out.println("Inserted into NEUSE");
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
            price =0;    
        }
        
    }    
}