package com.excylis.access;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import com.excylis.model.BeanComputer;
public class ComputerDAO {
	static Connection connect = ConnectionMySQL.getInstance();
    private static ResultSet result; 
    private static final String SQL_COMPUTER_LIST =	"SELECT * FROM computer";    
    public static List<BeanComputer> requete(){
	List<BeanComputer> computers = new ArrayList<BeanComputer>();
			
	       		try {
				result = connect.createStatement().executeQuery(SQL_COMPUTER_LIST);
				
				while (result.next()) {
	    		   final int id;
	    		   final String name;
	    		   final Timestamp introduced;
	    		   final Timestamp discontinued;
	    		   final int company_id;
	    		   
	    		   id = result.getInt("id");
	               name = result.getString("name");
	               introduced = result.getTimestamp("introduced");
	               discontinued = result.getTimestamp("discontinued");
	               company_id = result.getInt("company_id");
	               
	               BeanComputer computer = new BeanComputer(id, name, introduced, discontinued, company_id); 
	            		   
	               computer.setId(id);
	               computer.setName(name);
	               computer.setIntroduced(introduced);
	               computer.setDiscontinued(discontinued);
	               computer.setCompany_id(company_id);
	               computers.add(computer);
	               
				}
		     	}
	       		
	       		
		    catch (SQLException e) 
			{
		            e.printStackTrace();
		    }
	       		return computers;
    }
	
}
