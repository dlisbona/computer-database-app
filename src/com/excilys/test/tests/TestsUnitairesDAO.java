package tests;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import com.excilys.access.ComputerDAO;;


public class TestsUnitairesDAO {
  ComputerDAO computerDAO = ComputerDAO.getInstanceComputerDAO();

  @Test
  public void testComputerDAO() {
    assertNotNull(computerDAO);
  }

}


