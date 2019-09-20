package com.excilys.mapper;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import com.excilys.DTO.ComputerDTO;
import com.excilys.model.BeanComputer;


public class Mapper {

  public static LocalDateTime stringToLocalDateTime(String i) {
    final LocalDateTime mapped = LocalDateTime.parse(i);
    return mapped;
  }

  public static Timestamp localToTime(LocalDateTime i) {
    final Timestamp mapped = Timestamp.valueOf(i);
    return mapped;
  }


  public static Timestamp stringToTime(String i) {
    final Timestamp mapped = Timestamp.valueOf(i);
    return mapped;
  }


  private static String timeToSring(Timestamp i) {
    final String mapped = String.valueOf(i);
    return mapped;
  }

  public static BeanComputer computerDTOToComputerBean(ComputerDTO computerDTO) {
    int id = computerDTO.getId();
    String name = computerDTO.getName();
    Timestamp introduced = stringToTime(computerDTO.getIntroduced());
    Timestamp discontinued = stringToTime(computerDTO.getDiscontinued());
    int company_id = computerDTO.getCompany_id();
    BeanComputer computerBean = new BeanComputer(id, name, introduced, discontinued, company_id);

    return computerBean;

  }

  public static ComputerDTO computerBeanToComputerDTO(BeanComputer computerBean) {

    int id = computerBean.getId();
    String name = computerBean.getName();
    String introduced = timeToSring(computerBean.getIntroduced());
    String discontinued = timeToSring(computerBean.getDiscontinued());

    int company_id = computerBean.getCompany_id();

    ComputerDTO computerDTO = new ComputerDTO(id, name, introduced, discontinued, company_id);
    System.out.println("conversion ok");
    return computerDTO;

  }

  public enum updateEnum {
    updateComputerId, updateComputerName, updateComputerIntroduced, updateComputerDiscontinued, updateComputerCompanyId, exit
  };

  public static updateEnum mapperSwitchUpdate(int selectionMenu) {

    switch (selectionMenu) {
      case 1:
        return updateEnum.updateComputerId;
      case 2:
        return updateEnum.updateComputerName;
      case 3:
        return updateEnum.updateComputerIntroduced;
      case 4:
        return updateEnum.updateComputerDiscontinued;
      case 5:
        return updateEnum.updateComputerCompanyId;
      case 6:
    }
    return updateEnum.exit;
  }

  public enum selectionEnum {
    computerList, companyList, computerDetail, insertComputer, deleteComputer, updateComputer
  };

  public static selectionEnum mapperSwitchEnum(int selectionMenu) {

    switch (selectionMenu) {
      case 1:
        return selectionEnum.computerList;
      case 2:
        return selectionEnum.companyList;
      case 3:
        return selectionEnum.computerDetail;
      case 4:
        return selectionEnum.insertComputer;
      case 5:
        return selectionEnum.deleteComputer;
      case 6:
        return selectionEnum.updateComputer;
    }
    return selectionEnum.companyList;
  }
}
