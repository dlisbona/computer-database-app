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
  int pagination = 10;

  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ServletContext servletContext = this.getServletContext();
    RequestDispatcher requestDispacher =
        servletContext.getRequestDispatcher("/WEB-INF/dashboard.jsp");

    try {
      ComputerService computerService = ComputerService.getInstance();
      String pageDirection = request.getParameter("page");
      request.setAttribute("pageDirection", pageDirection);


      if (pageDirection != null) {
        switch (pageDirection) {
          case "previous":
            pagination -= 10;
            List<BeanComputer> computerListTotalPrevious =
                computerService.getComputerList(2, 0, pagination);
            request.setAttribute("computerListTotal", computerListTotalPrevious);
            requestDispacher.forward(request, response);
            break;
          case "next":
            pagination += 10;
            List<BeanComputer> computerListTotalNext =
                computerService.getComputerList(2, 0, pagination);
            request.setAttribute("computerListTotal", computerListTotalNext);
            requestDispacher.forward(request, response);
            break;
          default:

            List<BeanComputer> computerListTotal = computerService.getComputerList(2, 0, 0);
            request.setAttribute("computerListTotal", computerListTotal);
            requestDispacher.forward(request, response);
        }
      } else {
        List<BeanComputer> computerListTotal = computerService.getComputerList(2, 0, 0);
        request.setAttribute("computerListTotal", computerListTotal);
        requestDispacher.forward(request, response);
      }



    } catch (Exception e) {
      throw new ServletException(e);
    }



  }
}

