package tests;


import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import com.excilys.services.ComputerService;;

public class TestUnitairesServices {
  ComputerService computerService = ComputerService.getInstance();

  @Test
  public void testComputerService() {
    assertNotNull(computerDTO);
  }
}
