package com.excilys.access;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import com.excilys.model.BeanComputer;

public class ComputerDAO {

  private Statement statement;
  private ResultSet result;
  private static ComputerDAO instanceComputerDAO;
  private List<BeanComputer> computers;


  private ComputerDAO() {}

  public static ComputerDAO getInstanceComputerDAO() {
    if (instanceComputerDAO == null) {
      instanceComputerDAO = new ComputerDAO();
    }
    return instanceComputerDAO;
  }


  public List<BeanComputer> requete(String requeteSQL) {
    computers = new ArrayList<BeanComputer>();
    try {
      statement = ConnectionMySQL.getInstanceConnection().getConnection().createStatement();
      result = statement.executeQuery(requeteSQL);

      while (result.next()) {
        final int id;
        final String name;
        final Timestamp introduced;
        final Timestamp discontinued;
        final int company_id;

        id = result.getInt("id");
        name = result.getString("name");
        introduced = result.getTimestamp("introduced");
        discontinued = result.getTimestamp("discontinued");
        company_id = result.getInt("company_id");
        BeanComputer computer = new BeanComputer(id, name, introduced, discontinued, company_id);
        computers.add(computer);

      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return computers;
  }

  public void insert(BeanComputer computerBean) {
    String sql =
        "INSERT INTO computer(id,name,introduced,discontinued,company_id) VALUES(?,?,?,?,?)";
    System.out.println("intitialisation sql");
    try (

        PreparedStatement pstmt =
            ConnectionMySQL.getInstanceConnection().getConnection().prepareStatement(sql)) {
      pstmt.setDouble(1, computerBean.getId());

      pstmt.setString(2, computerBean.getName());

      pstmt.setTimestamp(3, computerBean.getIntroduced());

      pstmt.setTimestamp(4, computerBean.getDiscontinued());

      pstmt.setDouble(5, computerBean.getCompany_id());

      pstmt.executeUpdate();

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public void delete(int idDelete) {
    String sql = "DELETE FROM computer WHERE id=" + idDelete;
    System.out.println("intitialisation sql");
    try (

        PreparedStatement pstmt =
            ConnectionMySQL.getInstanceConnection().getConnection().prepareStatement(sql)

    ) {
      pstmt.executeUpdate();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public void updateComputer(String sql) {
    System.out.println("update in");
    System.out.println(sql);

    System.out.println("intitialisation sql");
    try (PreparedStatement pstmt =
        ConnectionMySQL.getInstanceConnection().getConnection().prepareStatement(sql)) {
      pstmt.executeUpdate();
      System.out.println("update");
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }


}


