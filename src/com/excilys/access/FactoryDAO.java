package com.excilys.access;

public class FactoryDAO {

     public ComputerDAO getComputerDAO() {
          return new ComputerDAO();
     }

     public CompanyDAO getCompanyDAO() {
          return new CompanyDAO();
     }

}
