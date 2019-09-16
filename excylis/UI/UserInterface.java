package com.excylis.UI;
import com.excylis.DTO.ComputerDTO;
import com.excylis.access.CompanyDAO;
import com.excylis.model.BeanCompany;
import com.excylis.access.ComputerDAO;
import com.excylis.mapper.Mapper;
import com.excylis.model.BeanComputer;

import java.util.List;
import java.util.Scanner;

// This class provide an interface
public class UserInterface {
	
		public static void main (String[] args){
				
		System.out.println(" _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
	    System.out.println("|                                |");
	    System.out.println("|        INSERT SELECTION        |");
	    System.out.println("|                                |");
	    System.out.println("|       1 = Computer list        |");
	    System.out.println("|       2 = Company  list        |");
	    System.out.println("|       3 = Computer detail      |");
	    System.out.println("|       4 = Insert computer      |");
	    System.out.println("|       5 = Delete computer      |");
	    System.out.println("|       6 = Update computer      |");
	    System.out.println("|_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |");
	    System.out.println();
	    
	    Scanner myInput = new Scanner( System.in );
	    int selection = myInput.nextInt();
    	ComputerDAO computerDAO = new ComputerDAO();
    	CompanyDAO companyDAO = new CompanyDAO();
    	
    	
	    switch(selection)
	    {
	    
	    // Return the entire computer list 
	    case 1:
	    	myInput.close();
	    	final List<BeanComputer> computer = computerDAO.requete("SELECT * FROM computer");
	    	System.out.println();
	    	System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
		    System.out.printf("%5s %70s %23s %23s %13s", "ID", "NAME", "INTRODUCED", "DISCONTINUED", "COMPANY_ID");
		    System.out.println();
		    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
		    for(int i=0;i<computer.size();i++){
		        System.out.format("%5s %70s %23s %23s %13s",
		                computer.get(i).getId(), computer.get(i).getName(), computer.get(i).getIntroduced(), computer.get(i).getDiscontinued(), computer.get(i).getCompany_id());
		        System.out.println();
		    }    
	    break;
	    
	    // Return the entire company list 
	    case 2:
	    		myInput.close();
	         	final List<BeanCompany> company= companyDAO.requete("SELECT * FROM company");
	         	System.out.println();
	         	System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
			    System.out.printf("%10s %50s", "ID", "NAME");
			    System.out.println();
			    System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
			    for(int i=0;i<company.size();i++){
			        System.out.format("%10s %50s",
			                company.get(i).getId(),company.get(i).getName());
			        System.out.println();
			    }
			
	    break;
	    
	    // Return a list with only one id selected computer
	    case 3:
	    	myInput.close();
			System.out.println(" _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
		    System.out.println("|                                |");
		    System.out.println("|       INSERT COMPUTER ID       |");
		    System.out.println("|_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |");
		    System.out.println();
		    
	 	    int selectionId = myInput.nextInt();
	 	    final List<BeanComputer> computerDetail = computerDAO.requete("SELECT * FROM computer WHERE id='" + selectionId + "'");
	 	    myInput.close();
	 	    
	    	System.out.println();
	    	System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
		    System.out.printf("%5s %70s %23s %23s %13s", "ID", "NAME", "INTRODUCED", "DISCONTINUED", "COMPANY_ID");
		    System.out.println();
		    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
		    for(int i=0;i<computerDetail.size();i++){
		        System.out.format("%5s %70s %23s %23s %13s",
		                computerDetail.get(i).getId(), computerDetail.get(i).getName(), computerDetail.get(i).getIntroduced(), computerDetail.get(i).getDiscontinued(), computerDetail.get(i).getCompany_id());
		        System.out.println();
		 		    }    
	    break;
	    
	 // Insert a new computer
	    case 4:
	    	myInput.close();
			System.out.println(" _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
		    System.out.println("|                                |");
		    System.out.println("|     INSERT NEW NAME            |");
		    System.out.println("|                                |");    
		    String newComputerName = myInput.next();

		    
		    System.out.println("|     INSERT NEW          ID     |");
		    int newComputerId = myInput.nextInt();
		   
		    
		    System.out.println("|     INTRODUCTION DATE 1          |");
		    String newIntroductionDate1 = myInput.next();
		    
		    System.out.println("|     INTRODUCTION DATE 2          |");
		    String newIntroductionDate2 = myInput.next();
		    
	 	    System.out.println("|     END DATE 1                  |");
	 	    String newEndDate1 = myInput.next();
	 	    
	 	    System.out.println("|     END DATE 2                  |");
	 	    String newEndDate2 = myInput.next();
	 	    
	 	    
	 	    System.out.println("|     COMPANY ID                 |");
	 	    int newCompanyID = myInput.nextInt();

	 	  
	 	    String newEndDate = newEndDate1 +" "+ newEndDate1;
	 	    String newIntroductionDate = newIntroductionDate1  +" "+  newIntroductionDate2;
	 	    
//	 	   String newEndDate = "2007-08-20 12:30:01";
//	 	   String newIntroductionDate = "2003-05-03 13:32:20";
//	 	    
	 	   myInput.close();
	 	    
	 	    
	 	   ComputerDTO computerDTO = new ComputerDTO(newComputerId, newComputerName, 
	 			   newIntroductionDate, newEndDate, newCompanyID);
	 	  	 	   BeanComputer computerBean = Mapper.computerDTOToComputerBean(computerDTO);
	 	 	  	 	   computerDAO.insert(computerBean);
	 	 	
	 	  
	 	   break;
	 	   
	 	  // Delete a computer based on its Id
	       case 5:
	    	 
				System.out.println(" _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
			    System.out.println("|                                |");
			    System.out.println("|       INSERT COMPUTER ID       |");
			    System.out.println("|_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |");
			    System.out.println();
			    
		 	    int selectionIdDelete = myInput.nextInt();
		 	    computerDAO.delete(selectionIdDelete);
		 	    myInput.close();
    		    break;
	      
	       case 6:
	    	   	 
				System.out.println(" _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
			    System.out.println("|                                |");
			    System.out.println("|       INSERT COMPUTER ID       |");
			    System.out.println("|_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |");
			    System.out.println();
			    
		 	   int selectionIdUpdate= myInput.nextInt();
		 	  
		 	    
		 		System.out.println(" _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
			    System.out.println("|                                |");
			    System.out.println("|     CHOOSE FIELD TO UPDATE     |");
			    System.out.println("|                                |");
			    System.out.println("|       1 = id                   |");
			    System.out.println("|       2 = name                 |");
			    System.out.println("|       3 = introduced           |");
			    System.out.println("|       4 = discontinued         |");
			    System.out.println("|       5 = id_company        	 |");
			    System.out.println("|_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |");
			    System.out.println();
		 	    
			    int fieldUpdate= myInput.nextInt();
			    
	    	   	
				System.out.println(" _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
			    System.out.println("|                                |");
			    System.out.println("|       INSERT NEW VALUE         |");
			    System.out.println("|_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |");
			    System.out.println();
		 	    
			    
			String valueUpdateString = "";
			String sql = "";
			int valueUpdateInt = 0; 
			
	       switch(fieldUpdate)
	       {
	       case 1:
	    	   valueUpdateInt = myInput.nextInt();
	    	   sql = "UPDATE computer SET id=" + valueUpdateInt + " WHERE id=" + selectionIdUpdate;
	    	   computerDAO.updateComputer(sql);
	    	   myInput.close();
	       break;
	       
	       case 2:
	    	   valueUpdateString = myInput.next();
	    	   sql = "UPDATE computer SET name = '" + valueUpdateString + "' WHERE id = " + selectionIdUpdate;
	    	   computerDAO.updateComputer(sql);
	    	   myInput.close();
	       break;
	      
	       case 3:
	    	   valueUpdateString = myInput.next();
	    	   sql = "UPDATE computer SET introduced=" + valueUpdateString + " WHERE id=" + selectionIdUpdate;
	    	   computerDAO.updateComputer(sql);
	    	   myInput.close();
	       break;
	       
	       case 4:
	    	   valueUpdateString = myInput.next();
	    	   sql = "UPDATE computer SET discontinued" + valueUpdateString + " WHERE id=" + selectionIdUpdate;
	    	   computerDAO.updateComputer(sql);
	    	   myInput.close();
	       break;
	       
	       case 5:
	    	   valueUpdateInt = myInput.nextInt();
	    	   sql = "UPDATE computer SET company_id=" + valueUpdateInt + " WHERE id=" + selectionIdUpdate;
	    	   computerDAO.updateComputer(sql);
	    	   myInput.close();
	       break;
	       }
	    }
    }
}

		


