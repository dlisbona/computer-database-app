package com.excilys.mapper;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import com.excilys.DTO.ComputerDTO;
import com.excilys.model.BeanCompany;
import com.excilys.model.BeanComputer;


public class Mapper {

     public static LocalDateTime stringToLocalDateTime(String i) {
          String date = i + "T00:00:00";
          final LocalDateTime stringToLocalDateTime = LocalDateTime
               .parse(date);
          return stringToLocalDateTime;
     }



     public static List<BeanCompany> beanCompanySorted(List<BeanCompany> beanCompanyList) {

          beanCompanyList
               .sort(Comparator
                    .comparing(BeanCompany::getName));

          List<BeanCompany> beanCompanySorted = beanCompanyList;


          return beanCompanySorted;


     }



     public static Timestamp localDateTimeToTimeStamp(LocalDateTime i) {
          final Timestamp mapped = Timestamp
               .valueOf(i);
          return mapped;
     }



     public static Timestamp stringToTime(String i) {
          final Timestamp mapped = Timestamp
               .valueOf(i + " 00:00:00");
          return mapped;
     }



     private static String timeStampToSring(Timestamp i) {
          if(i != null) {
               String timeStampToString = String
                    .valueOf(i);
               timeStampToString = timeStampToString
                    .replace("00:00:00.0", " ");
               timeStampToString = timeStampToString
                    .trim();

               return timeStampToString;
          } else {
               String timeStampToStringNull = "_";
               return timeStampToStringNull;
          }

     }



     public static BeanComputer computerDTOToComputerBean(ComputerDTO computerDTO) {

          int idComputer = computerDTO
               .getId();
          String name = computerDTO
               .getName();
          Timestamp introduced = stringToTime(computerDTO
               .getIntroduced());
          Timestamp discontinued = stringToTime(computerDTO
               .getDiscontinued());

          if(computerDTO
               .getcompanyIdIsInt() == true) {
               int companyName = computerDTO
                    .getCompany_id();
               BeanComputer computerBean = new BeanComputer(idComputer, name, introduced, discontinued, companyName);
               return computerBean;
          } else {
               String companyName = computerDTO
                    .getCompanyName();
               BeanComputer computerBean = new BeanComputer(idComputer, name, introduced, discontinued, companyName);
               return computerBean;
          }

     }



     public static ComputerDTO computerBeanToComputerDTO(BeanComputer computerBean) {
          int id = computerBean
               .getId();
          String name = computerBean
               .getName();
          String introduced = timeStampToSring(computerBean
               .getIntroduced());
          String discontinued = timeStampToSring(computerBean
               .getDiscontinued());

          String companyName = computerBean
               .getCompanyName();

          ComputerDTO computerDTO = new ComputerDTO(id, name, introduced, discontinued, companyName);

          return computerDTO;

     }



     public static ComputerDTO computerBeanToComputerDTOCompanyIdIsInt(BeanComputer computerBean) {

          int id = computerBean
               .getId();
          String name = computerBean
               .getName();
          String introduced = timeStampToSring(computerBean
               .getIntroduced());
          String discontinued = timeStampToSring(computerBean
               .getDiscontinued());

          int companyId = computerBean
               .getCompany_id();

          ComputerDTO computerDTO = new ComputerDTO(id, name, introduced, discontinued, companyId);

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
