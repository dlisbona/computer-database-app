package tests;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import com.excilys.DTO.ComputerDTO;

public class TestsUnitairesDTO {
  ComputerDTO computerDTO = new ComputerDTO(0, "a", "b", "c", 0);

  @Test
  public void testComputerDTO() {
    assertNotNull(computerDTO);
  }

}
