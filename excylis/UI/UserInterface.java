package com.excylis.UI;
import com.excylis.DTO.ComputerDTO;
import com.excylis.access.CompanyDAO;
import com.excylis.model.BeanCompany;
import com.excylis.access.ComputerDAO;
import com.excylis.mapper.Mapper;
import com.excylis.model.BeanComputer;

import java.util.List;
import java.util.Scanner;

// This class provide an interfac
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
	    switch(selection)
	    {
	    
	    // Return the entire computer list 
	    case 1:
	    	myInput.close();
	    	final List<BeanComputer> computer = ComputerDAO.requete("SELECT * FROM computer");
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
	         	final List<BeanCompany> company= CompanyDAO.requete("SELECT * FROM company");
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
	 	    final List<BeanComputer> computerDetail = ComputerDAO.requete("SELECT * FROM computer WHERE id='" + selectionId + "'");
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
//		    String newComputerName = myInput.next();
		    String newComputerName = "name2";
		    
		    System.out.println("|     INSERT NEW          ID     |");
//		    int newComputerId = myInput.nextInt();
		    int newComputerId = 576;
		    
		    System.out.println("|     INTRODUCTION DATE 1          |");
//		    String newIntroductionDate1 = myInput.next();
		    
		    System.out.println("|     INTRODUCTION DATE 2          |");
//		    String newIntroductionDate2 = myInput.next();
		    
	 	    System.out.println("|     END DATE 1                  |");
//	 	    String newEndDate1 = myInput.next();
	 	    
	 	    System.out.println("|     END DATE 2                  |");
//	 	    String newEndDate2 = myInput.next();
	 	    
	 	    
	 	    System.out.println("|     COMPANY ID                 |");
//	 	    int newCompanyID = myInput.nextInt();
	 	    int newCompanyID =1;
	 	  
//	 	    String newEndDate = newEndDate1 +" "+ newEndDate1;
//	 	    String newIntroductionDate = newIntroductionDate1  +" "+  newIntroductionDate2;
	 	    
	 	   String newEndDate = "2007-08-20 12:30:01";
	 	   String newIntroductionDate = "2003-05-03 13:32:20";
	 	    
	 	   myInput.close();
	 	    
	 	    
	 	   ComputerDTO computerDTO = new ComputerDTO(newComputerId, newComputerName, 
	 			   newIntroductionDate, newEndDate, newCompanyID);
	 	  	 	   BeanComputer computerBean = Mapper.computerDTOToComputerBean(computerDTO);
	 	 	  	 	   ComputerDAO.insert(computerBean);
	 	 	
	 	  
	 	   break;
	 	   
	 	  // Delete a computer based on its Id
	       case 5:
	    	    myInput.close();
				System.out.println(" _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
			    System.out.println("|                                |");
			    System.out.println("|       INSERT COMPUTER ID       |");
			    System.out.println("|_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |");
			    System.out.println();
			    
		 	    int selectionIdDelete = myInput.nextInt();
		 	    ComputerDAO.delete(selectionIdDelete);
		 	    myInput.close();
    		    break;
	      
	       case 6:
	    	   	
//	    	    
//	    	    myInput.close();	
//				System.out.println(" _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
//			    System.out.println("|                                |");
//			    System.out.println("|       INSERT COMPUTER ID       |");
//			    System.out.println("|_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |");
//			    System.out.println();
//			    
//		 	   int selectionIdUpdate= myInput.nextInt();
//		 	  
//		 	   final List<BeanComputer> computerSelected = ComputerDAO.requete("SELECT * FROM computer WHERE id='" + selectionIdUpdate + "'");
//		 	   myInput.close();
//		 	   
//		 	  ComputerDTO computerDTO = new ComputerDTO(newComputerId, newComputerName, 
//		 			   newIntroductionDate, newEndDate, newCompanyID);
//		 	  
//		 	  BeanComputer computerBean = Mapper.computerDTOToComputerBean(computerDTO);
//		 	 	  	 	   ComputerDAO.insert(computerBean);
//		 	   
//		 	   
//		 	    
//		 		System.out.println(" _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
//			    System.out.println("|                                |");
//			    System.out.println("|     CHOOSE FIELD TO UPDATE     |");
//			    System.out.println("|                                |");
//			    System.out.println("|       1 = id                   |");
//			    System.out.println("|       2 = name                 |");
//			    System.out.println("|       3 = introduced           |");
//			    System.out.println("|       4 = discontinued         |");
//			    System.out.println("|       5 = id_company        	 |");
//			    System.out.println("|       6 = Update computer      |");
//			    System.out.println("|_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |");
//			    System.out.println();
//		 	    
//			    String fieldUpdate= myInput.next();
//		 	    ComputerDAO.update(selectionIdUpdate, fieldUpdate);
//		 	    myInput.close();
//    		    break;
    		    
	    }
		}
		}
		


