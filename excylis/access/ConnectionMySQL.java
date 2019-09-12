package com.excylis.access;
import java.sql.*;

public class ConnectionMySQL {
	        	       
		  	private static String url = "jdbc:mysql://localhost:3306/computer-database-db";
		  	private static String user = "admincdb";
		  	private static String passwd = "qwerty1234";
		  	private static Connection connect;
		  	
		  	public static Connection getInstance(){
		  		try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
		  	
		  	if(connect == null){
		  			try {
		  				connect = DriverManager.getConnection(url, user, passwd);
		  		    } 
		  			catch (SQLException mysql) {
		  				mysql.printStackTrace();
		  			}
		  		}		
		  		return connect;	
	   		  	}	
	     }

