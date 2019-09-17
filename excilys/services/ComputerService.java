package com.excilys.services;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import com.excilys.DTO.ComputerDTO;
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

      final List<BeanComputer> computerList = computerDAO.requete("SELECT * FROM computer");
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

  public void computerUpdate(int selectionIdUpdate, int selection, String valueUpdate) {

    switch (Mapper.mapperSwitchUpdate(selectionIdUpdate)) {
      case updateComputerName:
        int valueUpdateId = Integer.parseInt(valueUpdate);
        String sql = "UPDATE computer SET id=" + valueUpdateId + " WHERE id=" + selectionIdUpdate;
        computerDAO.updateComputer(sql);

      case updateComputerId:
        String valueUpdateName = (String) valueUpdate;
        sql =
            "UPDATE computer SET name = '" + valueUpdateName + "' WHERE id = " + selectionIdUpdate;
        computerDAO.updateComputer(sql);

      case updateComputerIntroduced:

        Timestamp valueUpdateIntroduced = Mapper.stringToTime((String) valueUpdate);
        sql = "UPDATE computer SET introduced=" + valueUpdateIntroduced + " WHERE id="
            + selectionIdUpdate;
        computerDAO.updateComputer(sql);

      case updateComputerDiscontinued:
        Timestamp valueUpdateDiscontinued = Mapper.stringToTime((String) valueUpdate);
        sql = "UPDATE computer SET discontinued" + valueUpdateDiscontinued + " WHERE id="
            + selectionIdUpdate;
        computerDAO.updateComputer(sql);

      case updateComputerCompanyId:
        int valueUpdateIdCompany = Integer.parseInt(valueUpdate);
        sql = "UPDATE computer SET company_id=" + valueUpdateIdCompany + " WHERE id="
            + selectionIdUpdate;
        computerDAO.updateComputer(sql);

    }
  }



}
