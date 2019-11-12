package com.excilys.access;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class FactoryDAO extends AbstractDAO {

     @Autowired
     private ComputerDAO computerDAO;
     @Autowired
     private CompanyDAO companyDAO;



     public ComputerDAO getComputerDAO() {
          return computerDAO;
     }



     public CompanyDAO getCompanyDAO() {
          return companyDAO;
     }

}
