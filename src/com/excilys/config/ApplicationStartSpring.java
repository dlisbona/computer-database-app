// package com.excilys.config;
//
// import org.springframework.context.annotation.ComponentScan;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.context.AbstractContextLoaderInitializer;
// import org.springframework.web.context.WebApplicationContext;
// import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
// import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//
// @Configuration
// @EnableWebMvc
// @ComponentScan(basePackages = "com.excilys")
// public class ApplicationStartSpring extends AbstractContextLoaderInitializer {
//
// @Override
// protected WebApplicationContext createRootApplicationContext() {
// AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
// rootContext
// .register(ApplicationStartSpring.class);
// return rootContext;
// }
//
// }
