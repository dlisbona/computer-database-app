package com.excilys.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
public class WebAppGetValidatorName extends HttpServlet {
     public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


          String computerName;

          computerName = request
               .getParameter("computerName");
          System.out
               .println(computerName);

          if(computerName == null || ""
               .equals(computerName)) {
               response
                    .setContentType("text/plain");
               response
                    .getWriter()
                    .write("attention nom d'ordinateur vide");
          }


          ServletContext servletContext = this
               .getServletContext();
          RequestDispatcher requestDispacher = servletContext
               .getRequestDispatcher("/WEB-INF/404.jsp");
          requestDispacher
               .forward(request, response);


     }
}

