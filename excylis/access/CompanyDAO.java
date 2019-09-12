package com.excylis.access;
import java.sql.*;
import java.util.*;
import com.excylis.model.BeanCompany;


public class CompanyDAO{

	    static Connection connect = ConnectionMySQL.getInstance();
	    private static ResultSet result; 
	    private static final String SQL_COMPANY_LIST =	"SELECT * FROM company";    	    
	    
	    
	    public static List<BeanCompany> requete() {
	    List<BeanCompany> companies = new ArrayList<BeanCompany>();
			
	       		try {
				result = connect.createStatement().executeQuery(SQL_COMPANY_LIST);
				
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
