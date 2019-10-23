package com.excilys.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@SuppressWarnings("serial")
@WebServlet(name = "connexion", urlPatterns = {"/connexion", "/connection"})
public class WebAppGetConnexion extends HttpServlet {

     private static final long serialVersionUID = 1L;



     public void init(ServletConfig config) throws ServletException {
          super.init(config);
          SpringBeanAutowiringSupport
               .processInjectionBasedOnCurrentContext(this);
     }



     public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


          String userName = "";

          userName = request
               .getParameter("userName");

          if(userName == null || ""
               .equals(userName)) {
               userName = "Guest";
               ServletContext servletContext = this
                    .getServletContext();
               RequestDispatcher requestDispacher = servletContext
                    .getRequestDispatcher("/WEB-INF/connexion.jsp");
               requestDispacher
                    .forward(request, response);
          } else {
               userName = userName
                    .trim();
               String greetings = "Hello " + userName;
               response
                    .setContentType("text/html");
               response
                    .getWriter()
                    .write(greetings);
          }
     }
}

