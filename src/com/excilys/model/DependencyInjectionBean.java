package com.excilys.model;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class DependencyInjectionBean implements ServletContextListener {


     @Override
     public void contextInitialized(ServletContextEvent pServletContextEvent) {
          BeanFactory beanFactory = new BeanFactory();

          // Injection de l'instance de ManagerFactory dans la classe AbstractResource
          Abstract
               .setBeanfactory(beanFactory);
     }



     @Override
     public void contextDestroyed(ServletContextEvent pServletContextEvent) {
          // NOP
     }


}
