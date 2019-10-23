package com.excilys.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.excilys.access.CompanyDAO;
import com.excilys.model.BeanCompany;

@Component
public class CompanyService {
     private static CompanyService InstanceCompanyService;


     @Autowired
     private CompanyDAO companyDAO;



     public CompanyService() {}



     public static CompanyService getInstance() {
          if(InstanceCompanyService == null) {
               InstanceCompanyService = new CompanyService();
          }
          return InstanceCompanyService;
     }



     public List<BeanCompany> getCompanyList() throws SQLException {

          final List<BeanCompany> company = companyDAO
               .requete("SELECT * FROM company");
          return company;
     }



     public List<String> getCompanyListString() throws SQLException {

          final List<BeanCompany> company = companyDAO
               .requete("SELECT * FROM company");
          final List<String> companyListString = new ArrayList<String>();
          for (BeanCompany companyName : company) {
               companyListString
                    .add(companyName
                         .getName());
          }
          return companyListString;
     }



     public List<String> getCompanyListSorted() throws SQLException {

          final List<BeanCompany> company = companyDAO
               .requete("SELECT * FROM company");
          final List<String> companySorted = new ArrayList<String>();
          for (BeanCompany companyName : company) {
               companySorted
                    .add(companyName
                         .getName());
          }
          Collections
               .sort(companySorted);

          return companySorted;
     }


}
