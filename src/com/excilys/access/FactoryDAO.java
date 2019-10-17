package com.excilys.access;

public class FactoryDAO {

     private ComputerDAO computerDAO;

     private CompanyDAO companyDAO;



     public void setComputerDAO(ComputerDAO setComputerDAO) {
          computerDAO = setComputerDAO;
     }



     public void setCompanyDAO(CompanyDAO setCompanyDAO) {
          companyDAO = setCompanyDAO;
     }



     public ComputerDAO getComputerDAO() {
          return computerDAO;
     }



     public CompanyDAO getCompanyDAO() {
          return companyDAO;
     }

}
