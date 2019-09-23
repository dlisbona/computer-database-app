package test; 

import java.util.List;
import org.junit.Test;
import com.excilys.access.ComputerDAO;
import com.excilys.model.BeanComputer;
import junit.framework.TestCase;

public class TestUnitaires extends TestCase {
  ComputerDAO computerDAO;

  public TestUnitaires() {
    this.computerDAO = ComputerDAO.getInstanceComputerDAO();
  }

  @Test
  public void getComputerListTest() {
    List<BeanComputer> computers = computerDAO.requete("SELECT * FROM computer");
    System.out.println(computers.size());
    System.out.println(computers);
    assertNotNull("Yes ça marche !", computers);
  }
}
