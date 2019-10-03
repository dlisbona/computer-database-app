package com.excilys.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.excilys.access.CompanyDAO;
import com.excilys.model.BeanCompany;

public class CompanyService {
  private static CompanyService InstanceCompanyService;

  private CompanyService() {}

  public static CompanyService getInstance() {
    if (InstanceCompanyService == null) {
      InstanceCompanyService = new CompanyService();
    }
    return InstanceCompanyService;
  }


  public static List<BeanCompany> getCompanyList() throws SQLException {
    final CompanyDAO companyDAO = CompanyDAO.getInstanceCompanyDAO();
    final List<BeanCompany> company = companyDAO.requete("SELECT * FROM company");
    return company;
  }

  public static List<String> getCompanyListString() throws SQLException {
    final CompanyDAO companyDAO = CompanyDAO.getInstanceCompanyDAO();
    final List<BeanCompany> company = companyDAO.requete("SELECT * FROM company");
    final List<String> companyListString = new ArrayList<String>();
    for (BeanCompany companyName : company) {
      companyListString.add(companyName.getName());
    }
    return companyListString;
  }

  public static List<String> getCompanyListSorted() throws SQLException {
    final CompanyDAO companyDAO = CompanyDAO.getInstanceCompanyDAO();
    final List<BeanCompany> company = companyDAO.requete("SELECT * FROM company");
    final List<String> companySorted = new ArrayList<String>();
    for (BeanCompany companyName : company) {
      companySorted.add(companyName.getName());
    }
    Collections.sort(companySorted);
    return companySorted;
  }

}
