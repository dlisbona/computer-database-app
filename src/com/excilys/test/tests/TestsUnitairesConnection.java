package tests;

import static org.junit.Assert.fail;
import java.sql.Connection;
import org.junit.Test;
import com.excilys.access.ConnectionMySQL;;


public class TestsUnitairesConnection {

     Connection connectionMysql = ConnectionMySQL
          .getInstanceConnection();



     @Test
     public void test() {
          fail("Not yet implemented");
     }

}
