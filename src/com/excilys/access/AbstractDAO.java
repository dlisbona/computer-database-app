package com.excilys.access;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDAO {

     @Autowired
     private static FactoryDAO factoryDAO;



     protected static FactoryDAO getFactoryDAO() {
          return factoryDAO;
     }

}
