package com.excylis.access;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;			
import com.excylis.model.BeanComputer;

public class ComputerDAO {
	private static Connection connect = ConnectionMySQL.getInstance();
    private static ResultSet result; 
    
    
    
public static List<BeanComputer> requete(String requeteSQL){
List<BeanComputer> computers = new ArrayList<BeanComputer>();
		
       		try {
			result = connect.createStatement().executeQuery(requeteSQL);
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
    
    
   public static void insert(BeanComputer computerBean) {
    String sql = "INSERT INTO computer(id,name,introduced,discontinued,company_id) VALUES(?,?,?,?,?)";
System.out.println("intitialisation sql");
try (
		
    PreparedStatement pstmt = connect.prepareStatement(sql)) {
    pstmt.setDouble (1, computerBean.getId());
    System.out.println("intitialisation 1");

    pstmt.setString(2, computerBean.getName()); 
    System.out.println("intitialisation 2");

    pstmt.setTimestamp(3, computerBean.getIntroduced());
    System.out.println("intitialisation 3");
   
    pstmt.setTimestamp(4, computerBean.getDiscontinued());
    System.out.println("intitialisation 4");
   
    pstmt.setDouble(5, computerBean.getCompany_id());
    System.out.println("intitialisation 5");
   
    pstmt.executeUpdate();
    System.out.println("update");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        }
   
   public static void delete(int idDelete) {
	    String sql = "DELETE FROM computer WHERE id="+idDelete ;
System.out.println("intitialisation sql");
	        try (
	        		
	            PreparedStatement pstmt = connect.prepareStatement(sql)
	            
	        	) 
	        	{
	            pstmt.executeUpdate();
	        	} 
	        catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        }
   
   public static void update(int idUpdate, String fieldUpdated) {
   
//	   String sql = "UPDATE computer SET "+ fieldToUpdate"="+valueUpdate + " WHERE id=" + idUpdate;
//   System.out.println("intitialisation sql");
//	        try (
//	        	PreparedStatement pstmt = connect.prepareStatement(sql)) 
//	        	{
//	            pstmt.executeUpdate();
//	        	} 
//	        catch (SQLException e) {
//	            System.out.println(e.getMessage());
//	        }
	        }
   
   
}
    
    
    
    
    

