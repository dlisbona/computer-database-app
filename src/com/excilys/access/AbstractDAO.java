package com.excilys.access;

public abstract class AbstractDAO {

     private static FactoryDAO factoryDAO;



     protected static FactoryDAO getFactoryDAO() {
          return factoryDAO;
     }



     public static void setFactoryDAO(FactoryDAO setFactoryDAO) {
          factoryDAO = setFactoryDAO;
     }
}
