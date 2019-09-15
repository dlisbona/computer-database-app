package com.excylis.mapper;
import java.sql.Timestamp;
import com.excylis.DTO.ComputerDTO;
import com.excylis.model.BeanComputer;

public class Mapper {
	
	private static Timestamp stringToTime(String i) {
		final Timestamp mapped = Timestamp.valueOf(i);
		return mapped;
	}
	
	private static String timeToString(Timestamp i) {
		final String mapped = String.valueOf(i);
		return mapped;
	}

	public static BeanComputer computerDTOToComputerBean(ComputerDTO computerDTO) {
		int id = computerDTO.getId();
		String name = computerDTO.getName();
		
		System.out.println("date introduced");
		System.out.println(computerDTO.getIntroduced());
		System.out.println(computerDTO.getDiscontinued().getClass().getName());
		
		System.out.println("date discontinued");
		System.out.println(computerDTO.getDiscontinued());
		System.out.println(computerDTO.getDiscontinued().getClass().getName());
	 	   
		Timestamp introduced = stringToTime(computerDTO.getIntroduced());
		Timestamp discontinued = stringToTime(computerDTO.getDiscontinued());
		
		int company_id = computerDTO.getCompany_id();	
		BeanComputer computerBean = new BeanComputer(id, name, introduced, discontinued,company_id);
		System.out.println("conversion ok");
		return computerBean;
		
	}
	
	public static ComputerDTO computerBeanToComputerDTO(BeanComputer computerBean) {
		
		int id = computerBean.getId();
		String name = computerBean.getName();
		
		System.out.println("date introduced");
		System.out.println(computerBean.getIntroduced());
		System.out.println(computerBean.getDiscontinued().getClass().getName());
		
		System.out.println("date discontinued");
		System.out.println(computerBean.getDiscontinued());
		System.out.println(computerBean.getDiscontinued().getClass().getName());
	 	   
		String introduced = timeToString(computerBean.getIntroduced());
		String discontinued = timeToString(computerBean.getDiscontinued());
		
		int company_id = computerBean.getCompany_id();	
		
		ComputerDTO computerDTO = new ComputerDTO(id, name, introduced, discontinued,company_id);
		System.out.println("conversion ok");
		return computerDTO;
		
	}
}
