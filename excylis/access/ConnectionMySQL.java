package com.		excylis.access;
import java.sql.*;

// This class provide the JDBC connection

public class ConnectionMySQL {
	        	  
	// config JDBC <-> tomcat
		  	private static String url = "jdbc:mysql://localhost:3306/computer-database-db";
		  	private static String user = "admincdb";
		  	private static String passwd = "qwerty1234";
		  	private static Connection connect;
		  	
		  	public static Connection getInstance(){
		  		try {
		  			// JDBC driver instantiated 
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
		  	
		  	if(connect == null){
		  			try {
		  			// Call for connection
		  				connect = DriverManager.getConnection(url, user, passwd);
		  		    } 
		  			catch (SQLException mysql) {
		  				mysql.printStackTrace();
		  			}
		  		}		
		  		return connect;	
	   		  	}	
	}

