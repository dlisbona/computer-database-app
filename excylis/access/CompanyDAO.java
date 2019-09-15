package com.excylis.access;
import java.sql.*;
import java.util.*;
import com.excylis.model.BeanCompany;

// This class allows java manipulation of the SQL table company

public class CompanyDAO{
	    private static Connection connect = ConnectionMySQL.getInstance();
	    private static ResultSet result;       
	    
	    // Return a list of company with java attributes 
	    public static List<BeanCompany> requete(String requeteSQL) {
	    List<BeanCompany> companies = new ArrayList<BeanCompany>();
			
	       		try {
				result = connect.createStatement().executeQuery(requeteSQL);
				
				// Explore all the table/result 
				while (result.next()) {
	    		   final int id;
	    		   final String name;
	    		   id = result.getInt("id");
	               name = result.getString("name");
	              
	               
	               
	               BeanCompany company = new BeanCompany(id, name);               
	               company.setId(id);
	               company.setName(name);
	               
	               companies.add(company);
	            }

		     	}
		    catch (SQLException e) 
			{
		            e.printStackTrace();
		    }
	       		return companies;
			}
	    
	    
	    

}
