package tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import org.junit.Test;
import com.excilys.access.ConnectionMySQL;

public class TestsUnitairesConnection {

     @Test
     public void test() {

          try {
               ConnectionMySQL connectionMysql = ConnectionMySQL
                    .getInstanceConnection();
               assertNotNull(connectionMysql);
          } catch (Exception e) {
               // exception
          }
          fail("Not yet implemented");
     }

}
