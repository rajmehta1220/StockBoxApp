package com.java.dbconn;

import java.sql.*;


public class DatabaseConnection {

		// TODO Auto-generated method stub
	static final String DB_URL = "jdbc:mysql://sql201.unaux.com/unaux_32772773_stockbox";
	static final String USER = "unaux_32772773";
	static final String PASS = "Apple123$";
	static final String QUERY = "SELECT * FROM stocksdatatable";
	
	public static java.sql.Date getCurrentDatetime() {
	    java.util.Date today = new java.util.Date();
	    return new java.sql.Date(today.getTime());
	}

	   public static void main(String[] args) {
	      // Open a connection
		   try{  
			   Class.forName("com.mysql.jdbc.Driver");  
			   Connection con=DriverManager.getConnection(DB_URL,USER,PASS);  
			   Statement stmt=con.createStatement();  
			   ResultSet rs=stmt.executeQuery(QUERY);  
			   
			   String sql = "INSERT INTO stocksdatatable (stockname, stocktag, stockdate, type, stockprice, changerate, currency, bid) VALUES (?, ?, ?, ?, ?, ?, ? ,?)";
			   
			   PreparedStatement statement = con.prepareStatement(sql);
			   statement.setString(1, "Apple");
			   statement.setString(2, "AAPL");
			   
			   java.sql.Date date = getCurrentDatetime();	
			   statement.setDate(3, date);
			   statement.setString(4, "NYSE");
			   statement.setDouble(5, 123.76);
			   statement.setDouble(6, -12.4);
			   statement.setString(7, "USD");
			   statement.setDouble(8, 122.6);
			    
			   int rowsInserted = statement.executeUpdate();
			   if (rowsInserted > 0) {
			       System.out.println("A new stock was inserted successfully!");
			   }
			   
			   }catch(Exception e){ System.out.println(e);}  
	   }  

	   
}
