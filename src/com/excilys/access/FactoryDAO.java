package com.excilys.access;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class FactoryDAO extends AbstractDAO {

     @Autowired
     private ComputerDAO computerDAO;
     @Autowired
     private CompanyDAO companyDAO;



     // public void setComputerDAO(ComputerDAO setComputerDAO) {
     // computerDAO = setComputerDAO;
     // }
     //
     //
     //
     // public void setCompanyDAO(CompanyDAO setCompanyDAO) {
     // companyDAO = setCompanyDAO;
     // }


     public ComputerDAO getComputerDAO() {
          return computerDAO;
     }



     public CompanyDAO getCompanyDAO() {
          return companyDAO;
     }

}
