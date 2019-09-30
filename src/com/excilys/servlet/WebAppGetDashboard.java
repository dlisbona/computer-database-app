package com.excilys.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.excilys.model.BeanComputer;
import com.excilys.services.ComputerService;


@SuppressWarnings("serial")
public class WebAppGetDashboard extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      ComputerService computerService = ComputerService.getInstance();
      List<BeanComputer> computerListTotal = computerService.getComputerList(2);

      request.setAttribute("computerListTotal", computerListTotal);

    } catch (Exception e) {
      throw new ServletException(e);
    }

    ServletContext servletContext = this.getServletContext();
    RequestDispatcher requestDispacher =
        servletContext.getRequestDispatcher("/WEB-INF/dashboard.jsp");
    requestDispacher.forward(request, response);

  }

}

