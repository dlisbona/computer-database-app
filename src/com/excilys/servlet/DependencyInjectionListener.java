package com.excilys.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import com.excilys.access.AbstractDAO;
import com.excilys.access.CompanyDAO;
import com.excilys.access.ComputerDAO;
import com.excilys.access.FactoryDAO;
import com.excilys.services.ComputerService;


@WebListener
public class DependencyInjectionListener implements ServletContextListener {

     @Override
     public void contextInitialized(ServletContextEvent servletContextEvent) {

          FactoryDAO factoryDAO = new FactoryDAO();
          AbstractDAO
               .setFactoryDAO(factoryDAO);

          ComputerDAO computerDAO = new ComputerDAO();
          factoryDAO
               .setComputerDAO(computerDAO);

          ComputerService computerService = new ComputerService();
          WebAppGetDashboard
               .setComputerService(computerService);


          CompanyDAO companyDAO = new CompanyDAO();
          factoryDAO
               .setCompanyDAO(companyDAO);


     }



     public void contextDestroyed(ServletContextEvent servletContextEvent) {

     }


}
