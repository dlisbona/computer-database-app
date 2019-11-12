package com.excilys.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableTransactionManagement
@EnableWebMvc
@EnableJpaRepositories("com.excilys.model.ORM")
@ComponentScan({"com.excilys.access", "com.excilys.controler", "com.excilys.DTO", "com.excilys.services", "com.excilys.servlet",})
@PropertySource("classpath:com.excilys.util")
public class DispatcherServletSpring implements WebMvcConfigurer {

     @Autowired
     Environment environment;



     @Bean
     public ViewResolver viewResolver() {
          InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
          viewResolver
               .setViewClass(JstlView.class);
          viewResolver
               .setPrefix("/WEB-INF/");
          viewResolver
               .setSuffix(".jsp");
          return viewResolver;
     }



     @Bean
     LocalContainerEntityManagerFactoryBean entityManagerFactory() {
          LocalContainerEntityManagerFactoryBean lfb = new LocalContainerEntityManagerFactoryBean();
          lfb
               .setDataSource(dataSource());
          lfb
               .setPackagesToScan("com.excilys.model.ORM");
          lfb
               .setJpaProperties(hibernateProps());

          return lfb;
     }



     @Bean
     DataSource dataSource() {
          DriverManagerDataSource ds = new DriverManagerDataSource();
          ds
               .setUrl(environment
                    .getProperty(com.excilys.util.DBproperties.DBurl));
          ds
               .setUsername(environment
                    .getProperty(com.excilys.util.DBproperties.DBuser));
          ds
               .setPassword(environment
                    .getProperty(com.excilys.util.DBproperties.DBpassword));
          ds
               .setDriverClassName(environment
                    .getProperty(com.excilys.util.DBproperties.DBname));
          return ds;
     }



     Properties hibernateProps() {
          Properties properties = new Properties();
          properties
               .setProperty(com.excilys.util.DBproperties.PROPERTY_DIALECT, environment
                    .getProperty(com.excilys.util.DBproperties.PROPERTY_DIALECT));
          properties
               .setProperty(com.excilys.util.DBproperties.PROPERTY_SHOW_SQL, environment
                    .getProperty(com.excilys.util.DBproperties.PROPERTY_SHOW_SQL));
          return properties;
     }



     public void addResourceHandlers(ResourceHandlerRegistry registry) {
          registry
               .addResourceHandler("/front/**")
               .addResourceLocations("/front/");
     }

}
