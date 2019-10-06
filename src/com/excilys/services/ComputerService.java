package com.excilys.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import com.excilys.DTO.ComputerDTO;
import com.excilys.UI.UserInterface;
import com.excilys.access.ComputerDAO;
import com.excilys.mapper.Mapper;
import com.excilys.model.BeanComputer;

public class ComputerService {
  private static ComputerService instanceComputerService;
  private String computerJoinCompany =
      "SELECT computer.id,computer.name,computer.introduced, computer.discontinued,company.name as company_name "
          + "FROM computer " + "LEFT OUTER JOIN company ON computer.company_id=company.id limit ";

  private ComputerService() {}

  public static ComputerService getInstance() {
    if (instanceComputerService == null) {
      instanceComputerService = new ComputerService();
    }
    return instanceComputerService;
  }

  final ComputerDAO computerDAO = ComputerDAO.getInstanceComputerDAO();

  List<ComputerDTO> computerDTOList = new ArrayList<ComputerDTO>();
  List<BeanComputer> computerList = new ArrayList<BeanComputer>();

  List<ComputerDTO> computerDTOListSeul = new ArrayList<ComputerDTO>();
  List<BeanComputer> computerListSeul = new ArrayList<BeanComputer>();

  List<ComputerDTO> computerDTOListPage = new ArrayList<ComputerDTO>();
  List<BeanComputer> computerListPage = new ArrayList<BeanComputer>();



  public List<ComputerDTO> getComputerList(String choix, int ordinateur, int pages) {
    switch (choix) {
      case "listeEntiere":
        computerList.clear();
        computerList = computerDAO.requete("SELECT * FROM computer");
        for (BeanComputer computer : computerList) {
          ComputerDTO computerDTO = Mapper.computerBeanToComputerDTO(computer);
          computerDTOList.add(computerDTO);
        }
        return computerDTOList;

      case "unComputer":
        computerListSeul.clear();
        computerListSeul =
            computerDAO.requete("SELECT * FROM computer WHERE id='" + ordinateur + "';");
        for (BeanComputer computer : computerListSeul) {
          ComputerDTO computerDTO = Mapper.computerBeanToComputerDTO(computer);
          computerDTOListSeul.add(computerDTO);
        }
        return computerDTOListSeul;

      case "listePagination":

        computerListPage.clear();
        computerListPage = computerDAO.requeteUI(computerJoinCompany + pages + ", 10 ;");


        computerDTOList.clear();

        for (BeanComputer computer : computerListPage) {
          ComputerDTO computerDTO = Mapper.computerBeanToComputerDTO(computer);
          computerDTOListPage.add(computerDTO);
        }
        return computerDTOListPage;


      default:
        return computerDTOList;

    }


  }



  public void addComputer(int id, String name, String beginDate, String endDate, int idCompany) {

    final ComputerDTO computerDTO = new ComputerDTO(id, name, beginDate, endDate, idCompany);

    final BeanComputer computerBean = Mapper.computerDTOToComputerBean(computerDTO);

    computerDAO.insert(computerBean);
  }



  public void deleteComputer(int i) {
    computerDAO.delete(i);
  }

  public void updateComputer(int selectionIdUpdate, String valueUpdate, int selectionMenu) {
    switch (Mapper.mapperSwitchUpdate(selectionMenu)) {

      case updateComputerName:
        String valueUpdateName = (String) valueUpdate;
        String sql =
            "UPDATE computer SET name='" + valueUpdateName + "' WHERE id=" + selectionIdUpdate;
        computerDAO.updateComputer(sql);
        break;

      case updateComputerId:
        int valueUpdateId = Integer.parseInt(valueUpdate);
        sql = "UPDATE computer SET name = '" + valueUpdateId + "' WHERE id = " + selectionIdUpdate;
        computerDAO.updateComputer(sql);
        break;

      case updateComputerIntroduced:

        valueUpdate = valueUpdate + "T00:00:00";

        Timestamp valueUpdateIntroduced =
            Mapper.localDateTimeToTimeStamp(Mapper.stringToLocalDateTime(valueUpdate));

        sql = "UPDATE computer SET introduced='" + valueUpdateIntroduced + "' WHERE id="
            + selectionIdUpdate;
        computerDAO.updateComputer(sql);
        break;

      case updateComputerDiscontinued:

        valueUpdate = valueUpdate + "T00:00:00";

        Timestamp valueUpdateDiscontinued =
            Mapper.localDateTimeToTimeStamp(Mapper.stringToLocalDateTime(valueUpdate));

        sql = "UPDATE computer SET discontinued='" + valueUpdateDiscontinued + "'WHERE id="
            + selectionIdUpdate;
        computerDAO.updateComputer(sql);
        break;

      case updateComputerCompanyId:
        int valueUpdateIdCompany = Integer.parseInt(valueUpdate);
        sql = "UPDATE computer SET company_id='" + valueUpdateIdCompany + "'WHERE id="
            + selectionIdUpdate;
        computerDAO.updateComputer(sql);
        break;
      case exit:

        UserInterface.setFieldUpdate(6);

        break;
    }
  }



}
