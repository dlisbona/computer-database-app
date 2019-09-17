package com.excilys.mapper;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import com.excilys.DTO.ComputerDTO;
import com.excilys.model.BeanComputer;


public class Mapper {

  private static LocalDate stringToLocalDate(String i) {
    final LocalDate mapped = LocalDate.parse(i);
    return mapped;

  }

  private static LocalTime stringToLocalTime(String i) {
    final LocalTime mapped = LocalTime.parse(i);
    return mapped;
  }

  private static LocalDateTime datePlusTime(LocalDate date, LocalTime time) {
    final LocalDateTime mapped = LocalDateTime.of(date, time);
    return mapped;
  }

  private static Timestamp localToTimeStamp(String i) {
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
    updateComputerName, updateComputerId, updateComputerIntroduced, updateComputerDiscontinued, updateComputerCompanyId,
  };

  public static updateEnum mapperSwitchUpdate(int selectionMenu) {

    if (selectionMenu == 1) {
      return updateEnum.updateComputerName;
    }
    if (selectionMenu == 2) {
      return updateEnum.updateComputerId;
    }
    if (selectionMenu == 3) {
      return updateEnum.updateComputerIntroduced;
    }
    if (selectionMenu == 4) {
      return updateEnum.updateComputerDiscontinued;
    }
    if (selectionMenu == 5) {
      return updateEnum.updateComputerCompanyId;
    } else {
      return updateEnum.updateComputerName;
    }
  }

  public enum selectionEnum {
    computerList, companyList, computerDetail, insertComputer, deleteComputer, updateComputer
  };

  public static selectionEnum mapperSwitchEnum(int selectionMenu) {

    if (selectionMenu == 1) {
      return selectionEnum.computerList;
    }
    if (selectionMenu == 2) {
      return selectionEnum.companyList;
    }
    if (selectionMenu == 3) {
      return selectionEnum.computerDetail;
    }
    if (selectionMenu == 4) {
      return selectionEnum.insertComputer;
    }
    if (selectionMenu == 5) {
      return selectionEnum.deleteComputer;
    }
    if (selectionMenu == 6) {
      return selectionEnum.updateComputer;
    } else {
      return selectionEnum.updateComputer;
    }
  }
}
