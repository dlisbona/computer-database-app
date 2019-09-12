package com.excylis.UI;
import com.excylis.access.CompanyDAO;
import com.excylis.model.BeanCompany;
import com.excylis.access.ComputerDAO;
import com.excylis.model.BeanComputer;
import java.util.List;
import java.util.Scanner;


public class UserInterface {
	public static void main (String[] args){
	    
		
     

		List<BeanCompany> company= CompanyDAO.requete();
		List<BeanComputer> computer = ComputerDAO.requete();

	    System.out.println("|         SELECTION        |");
	    System.out.println("|                          |");
	    System.out.println("|        1. Computer       |");
	    System.out.println("|        2. Company        |");


	    Scanner myInput = new Scanner( System.in );
	    int selection = myInput.nextInt();
	    
	    switch(selection)
	    {
	    case 1:
			  System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
		    System.out.printf("%10s %40s %30s %30s %20s", "ID", "NAME", "INTRODUCED", "DISCONTINUED", "COMPANY_ID");
		    System.out.println();
		    System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
		    for(int i=0;i<computer.size();i++){
		        System.out.format("%10s %40s %30s %30s %20s",
		                computer.get(i).getId(), computer.get(i).getName(), computer.get(i).getIntroduced(), computer.get(i).getDiscontinued(), computer.get(i).getCompany_id());
		        System.out.println();
		    }    
	    break;
	    
	    case 2:
			for(int i=0;i<company.size();i++)
			{		
			    System.out.print("\t " + company.get(i).getId()+ "\t ");
			    System.out.println(company.get(i).getName());
			}
			
	    break;
	    }
		}
		}
		


