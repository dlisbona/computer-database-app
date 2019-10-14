package com.excilys.access;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.excilys.model.BeanCompany;


public class CompanyDAO {
  private static CompanyDAO instanceCompanyDAO;
  private ResultSet result;

  private CompanyDAO() {}

  public static CompanyDAO getInstanceCompanyDAO() throws SQLException {
    if (instanceCompanyDAO == null) {
      instanceCompanyDAO = new CompanyDAO();
    }
    return instanceCompanyDAO;
  }

  public List<BeanCompany> requete(String requeteSQL) {
    List<BeanCompany> companies = new ArrayList<BeanCompany>();
    Statement statement;

    try {
      statement = ConnectionMySQLSansHikari.getInstanceConnection().getConnection().createStatement();
      result = statement.executeQuery(requeteSQL);

      while (result.next()) {
        final int id;
        final String name;

        id = result.getInt("id");
        name = result.getString("name");

        BeanCompany company = new BeanCompany(id, name);
        company.setId(id);
        company.setName(name);
        companies.add(company);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return companies;
  }



}
