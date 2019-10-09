package com.excilys.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(name = "WebAppGetConnexion", urlPatterns = {"/connexion", "/connection"})
public class WebAppGetConnexion extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    List<String> list = new ArrayList<>();

    list.add("item1");
    list.add("item2");
    list.add("item3");

    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    request.setAttribute("test", list);

    ServletContext servletContext = this.getServletContext();
    RequestDispatcher requestDispacher = servletContext.getRequestDispatcher("/WEB-INF/connexion.jsp");
    requestDispacher.forward(request, response);

  }
}

