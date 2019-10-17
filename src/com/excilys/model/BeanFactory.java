package com.excilys.model;

import java.sql.Timestamp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanFactory {

     private static BeanFactory INSTANCE = new BeanFactory();



     BeanFactory() {
          super();
     };



     public static BeanFactory getInstance() {

          return BeanFactory.INSTANCE;
     }



     @Bean
     public BeanCompany GetBeanCompany(int id, String name) {
          return new BeanCompany(id, name);
     }



     @Bean
     public BeanComputer GetBeanComputer(int id, String name, Timestamp introduced, Timestamp discontinued, int companyID) {
          return new BeanComputer(id, name, introduced, discontinued, companyID);

     }



     @Bean
     public BeanComputer GetBeanComputer(int id, String name, Timestamp introduced, Timestamp discontinued, String companyName) {
          return new BeanComputer(id, name, introduced, discontinued, companyName);

     }

}

