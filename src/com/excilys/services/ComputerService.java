package com.excilys.services;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import com.excilys.DTO.ComputerDTO;
import com.excilys.UI.UserInterface;
import com.excilys.access.ComputerDAO;
import com.excilys.mapper.Mapper;
import com.excilys.model.BeanComputer;

public class ComputerService {
  private static ComputerService instanceComputerService;

  private ComputerService() {}

  public static ComputerService getInstance() {
    if (instanceComputerService == null) {
      instanceComputerService = new ComputerService();
    }
    return instanceComputerService;
  }


  final ComputerDAO computerDAO = ComputerDAO.getInstanceComputerDAO();

  public List<BeanComputer> getComputerList(int i) throws SQLException {

    if (i == 0) {

      List<BeanComputer> computerList = computerDAO.requete("SELECT * FROM computer");
      return computerList;


    } else {
      ComputerDAO computerDAO = ComputerDAO.getInstanceComputerDAO();
      final List<BeanComputer> computerList =
          computerDAO.requete("SELECT * FROM computer WHERE id='" + i + "'");
      return computerList;
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
            Mapper.localToTime(Mapper.stringToLocalDateTime(valueUpdate));

        sql = "UPDATE computer SET introduced='" + valueUpdateIntroduced + "' WHERE id="
            + selectionIdUpdate;
        computerDAO.updateComputer(sql);
        break;

      case updateComputerDiscontinued:

        valueUpdate = valueUpdate + "T00:00:00";

        Timestamp valueUpdateDiscontinued =
            Mapper.localToTime(Mapper.stringToLocalDateTime(valueUpdate));

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
