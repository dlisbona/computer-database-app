package com.excylis.access;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;			
import com.excylis.model.BeanComputer;

public class ComputerDAO {
	private ConnectionMySQL connect;
    private static ResultSet result; 
    
    public ComputerDAO() {
    	super();
    	this.connect = ConnectionMySQL.getInstance();
    }
// This class allows java manipulation of the SQL table computer

// Return a list of company with java attributes 
public List<BeanComputer> requete(String requeteSQL){
List<BeanComputer> computers = new ArrayList<BeanComputer>();
		
       		try {
			result = connect.getConnection().createStatement().executeQuery(requeteSQL);
			
			// Explore all the table/result
			while (result.next()) {
    		   final int id;
    		   final String name;
    		   final Timestamp introduced;
    		   final Timestamp discontinued;
    		   final int company_id;
    		   
    		   // Harvest the fields 
      		   id = result.getInt("id");
			   name = result.getString("name");
			   introduced = result.getTimestamp("introduced");
			   discontinued = result.getTimestamp("discontinued");
			   company_id = result.getInt("company_id");
               
               // Instantiate and set company's attributes
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
    
//Insert a computer to the table  
   public void insert(BeanComputer computerBean) {
    String sql = "INSERT INTO computer(id,name,introduced,discontinued,company_id) VALUES(?,?,?,?,?)";
	System.out.println("intitialisation sql");
	try (
			
    PreparedStatement pstmt = connect.getConnection().prepareStatement(sql)) {
    pstmt.setDouble (1, computerBean.getId());
//    System.out.println("intitialisation 1");

    pstmt.setString(2, computerBean.getName()); 
//    System.out.println("intitialisation 2");

    pstmt.setTimestamp(3, computerBean.getIntroduced());
//    System.out.println("intitialisation 3");
   
    pstmt.setTimestamp(4, computerBean.getDiscontinued());
//    System.out.println("intitialisation 4");
   
    pstmt.setDouble(5, computerBean.getCompany_id());
//    System.out.println("intitialisation 5");
   
    pstmt.executeUpdate();
//    System.out.println("update");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        }
   
 //Delete a computer from the table using the id
   public void delete(int idDelete) {
	    String sql = "DELETE FROM computer WHERE id="+idDelete ;
	    System.out.println("intitialisation sql");
	        try (
	        		
	            PreparedStatement pstmt = connect.getConnection().prepareStatement(sql)
	            
	        	) 
	        	{
	            pstmt.executeUpdate();
	        	} 
	        catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        }
   
   public void updateComputer (String sql) {
	   System.out.println("update in");
	   System.out.println(sql);
	   
	System.out.println("intitialisation sql");
	        try (
	        	PreparedStatement pstmt = connect.getConnection().prepareStatement(sql)) 
	        	{
	            pstmt.executeUpdate();
	            System.out.println("update");
	        	} 
	        catch (SQLException e) {
	            System.out.println(e.getMessage()); 
	        }	    
	        }
   }
  

    
    
    
    

