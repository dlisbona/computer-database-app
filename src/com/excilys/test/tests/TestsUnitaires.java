package tests;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import com.excilys.access.ComputerDAO;;


public class TestsUnitaires {
  ComputerDAO computerDAO = ComputerDAO.getInstanceComputerDAO();

  @Test
  public void testComputerDAO() {
    assertNotNull(computerDAO);
  }
}


