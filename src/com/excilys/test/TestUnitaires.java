package com.excilys.test;

import java.util.List;
import com.excilys.access.ComputerDAO;
import com.excilys.model.BeanComputer;
import junit.framework.TestCase;

public class TestUnitaires extends TestCase {
  ComputerDAO computerDAO;

  public TestUnitaires() {
    this.computerDAO = ComputerDAO.getInstanceComputerDAO();
  }

  public void getComputerListTest() {
    List<BeanComputer> computers = computerDAO.requete("SELECT * FROM computer");
    assertNotNull("Yes ça marche !", computers);
  }

}
