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
import com.excilys.DTO.ComputerDTO;
import com.excilys.access.ComputerDAO;
import com.excilys.services.ComputerService;


@WebServlet(name = "dashboard", urlPatterns = "/dashboard")
@SuppressWarnings("serial")
public class WebAppGetDashboard extends HttpServlet {
     int pagination = 10;
     private int defaultReglage = 0;
     static ComputerService computerService;



     public static void setComputerService(ComputerService setComputerService) {

          computerService = setComputerService;
     }



     public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

          List<ComputerDTO> computerListTotal = new ArrayList<ComputerDTO>();
          ServletContext servletContext = this
               .getServletContext();
          RequestDispatcher requestDispacher = servletContext
               .getRequestDispatcher("/WEB-INF/dashboard.jsp");
          int computerListTotalLenght;

          computerService
               .getComputerService();

          // ComputerService computerService = ComputerService
          // .getInstance();

          // servletContext
          // .getAttribute("computerListTotal");


          try {

               String pageDirection = request
                    .getParameter("page");
               //
               // servletContext
               // .getAttribute("computerListTotal");


               if(pageDirection != null) {

                    switch (pageDirection) {

                         case "previous":
                              if(pagination > 0) pagination -= 10;

                              computerListTotal = computerService
                                   .getComputerList("listePagination", defaultReglage, pagination);

                              computerListTotalLenght = computerService
                                   .getComputerList("listeEntiere", defaultReglage, defaultReglage)
                                   .size();
                              request
                                   .setAttribute("computerListTotalLenght", computerListTotalLenght);
                              request
                                   .setAttribute("computerListTotal", computerListTotal);

                              requestDispacher
                                   .forward(request, response);
                              computerListTotal
                                   .clear();
                              break;


                         case "next":

                              computerListTotal = computerService
                                   .getComputerList("listePagination", defaultReglage, pagination);

                              computerListTotalLenght = computerService
                                   .getComputerList("listeEntiere", defaultReglage, defaultReglage)
                                   .size();

                              int computerListTotalPagination = computerListTotalLenght;

                              if(computerListTotalPagination % 10 != 0) {
                                   computerListTotalPagination = computerListTotalPagination - (computerListTotalPagination % 10);
                              } else {
                                   computerListTotalPagination = computerListTotalPagination - 10;
                              }

                              if(pagination < computerListTotalPagination) pagination += 10;
                              System.out
                                   .println(" la taille de la liste envoyée à la JSP = " + computerListTotal
                                        .size());
                              request
                                   .setAttribute("computerListTotalLenght", computerListTotalLenght);
                              request
                                   .setAttribute("computerListTotal", computerListTotal);

                              requestDispacher
                                   .forward(request, response);
                              computerListTotal
                                   .clear();
                              break;

                         default:
                              pagination = 10;
                              computerListTotal = computerService
                                   .getComputerList("listePagination", defaultReglage, defaultReglage);
                              computerListTotalLenght = computerService
                                   .getComputerList("listeEntiere", defaultReglage, defaultReglage)
                                   .size();
                              request
                                   .setAttribute("computerListTotalLenght", computerListTotalLenght);
                              request
                                   .setAttribute("computerListTotal", computerListTotal);
                              requestDispacher
                                   .forward(request, response);
                              computerListTotal
                                   .clear();

                    }

               } else {
                    pagination = 10;

                    computerListTotal = computerService
                         .getComputerList("listePagination", defaultReglage, defaultReglage);
                    computerListTotalLenght = computerService
                         .getComputerList("listeEntiere", defaultReglage, defaultReglage)
                         .size();
                    request
                         .setAttribute("computerListTotalLenght", computerListTotalLenght);
                    request
                         .setAttribute("computerListTotal", computerListTotal);
                    requestDispacher
                         .forward(request, response);
                    computerListTotal
                         .clear();

               }
          } catch (Exception e) {
               throw new ServletException(e);
          }
     }



     public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
          try {


               String[] idComputerCheckbox = request
                    .getParameterValues("selection");
               String[] idComputerParsed = idComputerCheckbox[0]
                    .split(",");
               ComputerDAO computerDAO = ComputerDAO
                    .getInstanceComputerDAO();

               for (String ordinateur : idComputerParsed) {

                    int idComputer = Integer
                         .parseInt(ordinateur);
                    computerDAO
                         .delete(idComputer);

               }
               doGet(request, response);
          } catch (Exception e) {
               throw new ServletException(e);
          }
     }

}

