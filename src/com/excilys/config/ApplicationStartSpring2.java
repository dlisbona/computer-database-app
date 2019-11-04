package com.excilys.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ApplicationStartSpring2 extends AbstractAnnotationConfigDispatcherServletInitializer {

     @Override
     protected Class<?>[] getRootConfigClasses() {
          return null;
     }



     @Override
     protected Class<?>[] getServletConfigClasses() {
          return new Class[] {DispatcherServletSpring.class};
     }



     @Override
     protected String[] getServletMappings() {
          return new String[] {"/"};
     }

}
