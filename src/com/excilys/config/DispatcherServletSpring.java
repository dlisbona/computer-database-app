// package com.excilys.config;
//
// import org.springframework.context.annotation.ComponentScan;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.context.WebApplicationContext;
// import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
// import org.springframework.web.servlet.config.annotation.EnableWebMvc;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
// @Configuration
// @EnableWebMvc
// @ComponentScan(basePackages = "com.excilys")
// public class DispatcherServletSpring implements WebMvcConfigurer {
//
// protected WebApplicationContext createServletApplicationContext() {
// AnnotationConfigWebApplicationContext normalWebAppContext = new
// AnnotationConfigWebApplicationContext();
// normalWebAppContext
// .register(DispatcherServletSpring.class);
// return normalWebAppContext;
// }
//
// }

package com.excilys.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = DispatcherServletSpring.class)
public class DispatcherServletSpring implements WebApplicationInitializer {

     @Override
     public void onStartup(ServletContext ctx) throws ServletException {
          System.out
               .println("Starting....");
          // Init application context
          AnnotationConfigWebApplicationContext webCtx = new AnnotationConfigWebApplicationContext();
          webCtx
               .register(DispatcherServletSpring.class);
          webCtx
               .setServletContext(ctx);
          // Init dispatcher servlet
          ServletRegistration.Dynamic servlet = ctx
               .addServlet("springapp", new DispatcherServlet(webCtx));
          servlet
               .setLoadOnStartup(1);
          servlet
               .addMapping("*.htm");
          servlet
               .addMapping("/actions/*");
     }

}
