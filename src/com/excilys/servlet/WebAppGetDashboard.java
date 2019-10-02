package com.excilys.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.excilys.DTO.ComputerDTO;
import com.excilys.services.ComputerService;


@SuppressWarnings("serial")
public class WebAppGetDashboard extends HttpServlet {
  int pagination = 10;
  private int defaultReglage = 0;

  List<ComputerDTO> computerListTotal = new ArrayList<ComputerDTO>();

  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ServletContext servletContext = this.getServletContext();
    RequestDispatcher requestDispacher =
        servletContext.getRequestDispatcher("/WEB-INF/dashboard.jsp");
    int computerListTotalLenght;

    try {
      ComputerService computerService = ComputerService.getInstance();
      String pageDirection = request.getParameter("page");
      servletContext.getAttribute("computerListTotal");


      if (pageDirection != null) {

        switch (pageDirection) {

          case "previous":
            pagination -= 10;
            computerListTotal.clear();
            computerListTotal =
                computerService.getComputerList("listePagination", defaultReglage, pagination);
            computerListTotalLenght = computerService
                .getComputerList("listeEntiere", defaultReglage, defaultReglage).size();
            request.setAttribute("computerListTotalLenght", computerListTotalLenght);
            request.setAttribute("computerListTotal", computerListTotal);
            requestDispacher.forward(request, response);
            System.out.println(pagination);
            break;

          case "next":
            pagination += 10;
            computerListTotal.clear();
            computerListTotal =
                computerService.getComputerList("listePagination", defaultReglage, pagination);
            computerListTotalLenght = computerService
                .getComputerList("listeEntiere", defaultReglage, defaultReglage).size();
            request.setAttribute("computerListTotalLenght", computerListTotalLenght);
            request.setAttribute("computerListTotal", computerListTotal);
            requestDispacher.forward(request, response);
            break;

          default:
            computerListTotal.clear();
            computerListTotal =
                computerService.getComputerList("listePagination", defaultReglage, 0);
            computerListTotalLenght = computerService
                .getComputerList("listeEntiere", defaultReglage, defaultReglage).size();
            request.setAttribute("computerListTotalLenght", computerListTotalLenght);
            request.setAttribute("computerListTotal", computerListTotal);
            requestDispacher.forward(request, response);

        }

      } else {
        computerListTotal.clear();
        computerListTotal = computerService.getComputerList("listePagination", defaultReglage, 0);
        computerListTotalLenght =
            computerService.getComputerList("listeEntiere", defaultReglage, defaultReglage).size();
        request.setAttribute("computerListTotalLenght", computerListTotalLenght);
        request.setAttribute("computerListTotal", computerListTotal);
        requestDispacher.forward(request, response);

      }


    } catch (Exception e) {
      throw new ServletException(e);
    }



  }
}

