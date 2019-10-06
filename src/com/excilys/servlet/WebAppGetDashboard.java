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
import com.excilys.access.ComputerDAO;
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
            if (pagination > 0)
              pagination -= 10;
            computerListTotal.clear();
            computerListTotal =
                computerService.getComputerList("listePagination", defaultReglage, pagination);
            computerListTotalLenght = computerService
                .getComputerList("listeEntiere", defaultReglage, defaultReglage).size();
            request.setAttribute("computerListTotalLenght", computerListTotalLenght);
            request.setAttribute("computerListTotal", computerListTotal);

            requestDispacher.forward(request, response);
            break;

          case "next":

            computerListTotal.clear();
            computerListTotal =
                computerService.getComputerList("listePagination", defaultReglage, pagination);
            computerListTotalLenght = computerService
                .getComputerList("listeEntiere", defaultReglage, defaultReglage).size();
            int computerListTotalPagination = computerListTotalLenght;
            if (computerListTotalPagination % 10 != 0) {
              computerListTotalPagination =
                  computerListTotalPagination - (computerListTotalPagination % 10);
            } else {
              computerListTotalPagination = computerListTotalPagination - 10;
            }

            if (pagination < computerListTotalPagination)
              pagination += 10;

            System.out.println(computerListTotalPagination);

            request.setAttribute("computerListTotalLenght", computerListTotalLenght);
            request.setAttribute("computerListTotal", computerListTotal);
            requestDispacher.forward(request, response);
            break;

          default:
            pagination = 10;
            computerListTotal.clear();
            computerListTotal =
                computerService.getComputerList("listePagination", defaultReglage, defaultReglage);
            computerListTotalLenght = computerService
                .getComputerList("listeEntiere", defaultReglage, defaultReglage).size();
            request.setAttribute("computerListTotalLenght", computerListTotalLenght);
            request.setAttribute("computerListTotal", computerListTotal);
            requestDispacher.forward(request, response);

        }

      } else {
        pagination = 10;
        computerListTotal.clear();
        computerListTotal =
            computerService.getComputerList("listePagination", defaultReglage, defaultReglage);
        computerListTotalLenght =
            computerService.getComputerList("listeEntiere", defaultReglage, defaultReglage).size();
        request.setAttribute("computerListTotalLenght", computerListTotalLenght);
        request.setAttribute("computerListTotal", computerListTotal);
        requestDispacher.forward(request, response);

      }

      System.out.println(pagination);



    } catch (Exception e) {
      throw new ServletException(e);
    }
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    try {



      String[] idComputerCheckbox = request.getParameterValues("selection");
      String[] idComputerParsed = idComputerCheckbox[0].split(",");
      ComputerDAO computerDAO = ComputerDAO.getInstanceComputerDAO();

      for (String ordinateur : idComputerParsed) {

        int idComputer = Integer.parseInt(ordinateur);
        computerDAO.delete(idComputer);

      }
      doGet(request, response);
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }

}

