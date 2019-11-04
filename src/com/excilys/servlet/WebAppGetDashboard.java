package com.excilys.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import com.excilys.DTO.ComputerDTO;
import com.excilys.access.ComputerDAO;
import com.excilys.services.ComputerService;

@Component
@WebServlet(name = "dashboard", urlPatterns = "/dashboard")
@SuppressWarnings("serial")
public class WebAppGetDashboard extends HttpServlet {
     int pagination = 10;
     private int defaultReglage = 0;

     @Autowired
     private ComputerService computerService;

     @Autowired
     private ComputerDAO computerDAO;



     @Override
     public void init(ServletConfig config) throws ServletException {
          super.init(config);
          SpringBeanAutowiringSupport
               .processInjectionBasedOnCurrentContext(this);
     }



     public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

          List<ComputerDTO> computerListTotal = new ArrayList<ComputerDTO>();
          ServletContext servletContext = this
               .getServletContext();
          RequestDispatcher requestDispacher = servletContext
               .getRequestDispatcher("/WEB-INF/dashboard.jsp");
          int computerListTotalLenght;


          try {

               String pageDirection = request
                    .getParameter("page");

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

