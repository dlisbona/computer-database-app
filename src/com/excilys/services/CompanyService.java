package com.excilys.services;

import java.sql.SQLException;
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
}
