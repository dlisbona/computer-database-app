package com.excilys.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.excilys.model.BeanComputer;

@SuppressWarnings("serial")
public class WebAppGetConnexion extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response)


      throws ServletException, IOException {
    String param = request.getParameter("auteur");

    BeanComputer beanComputer = new BeanComputer(0, param, null, null, 0);
    beanComputer.setName(param);
    beanComputer.setCompany_id(8);


    ServletContext servletContext = this.getServletContext();
    RequestDispatcher requestDispacher =
        servletContext.getRequestDispatcher("/WEB-INF/connexion.jsp");
    request.setAttribute("connexion", beanComputer);
    requestDispacher.forward(request, response);
  }
}

