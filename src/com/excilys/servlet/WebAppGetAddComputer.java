package com.excilys.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
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
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import com.excilys.DTO.ComputerDTO;
import com.excilys.access.ComputerDAO;
import com.excilys.mapper.Mapper;
import com.excilys.model.BeanComputer;
import com.excilys.services.CompanyService;


@WebServlet(name = "addComputer", urlPatterns = "/addcomputer")
@SuppressWarnings("serial")
public class WebAppGetAddComputer extends HttpServlet {
     List<ComputerDTO> computerListTotal = new ArrayList<ComputerDTO>();

     @Autowired
     private CompanyService companyService;

     @Autowired
     private ComputerDAO computerDAO;



     public void init(ServletConfig config) throws ServletException {
          super.init(config);
          SpringBeanAutowiringSupport
               .processInjectionBasedOnCurrentContext(this);
     }



     public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          ServletContext servletContext = this
               .getServletContext();
          RequestDispatcher requestDispacher = servletContext
               .getRequestDispatcher("/WEB-INF/addComputer.jsp");

          try {
               List<String> companyNames = companyService
                    .getCompanyListSorted();
               request
                    .setAttribute("companyNames", companyNames);
          } catch (SQLException e) {
               e
                    .printStackTrace();
          }
          requestDispacher
               .forward(request, response);
     }



     public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
          try {

               int idComputer = 0;
               String nameComputer = request
                    .getParameter("nameComputer");
               String introducedDateString = request
                    .getParameter("introducedDate");
               String discontinuedDateString = request
                    .getParameter("discontinuedDate");
               Timestamp introducedTimestamp = Mapper
                    .stringToTime(introducedDateString);
               Timestamp discontinuedTimestamp = Mapper
                    .stringToTime(discontinuedDateString);
               String companyComputerName = request
                    .getParameter("companyComputerName");

               List<String> companyNames = companyService
                    .getCompanyListString();

               int companyComputerId = companyNames
                    .indexOf(companyComputerName) + 2;


               BeanComputer computerToAdd = new BeanComputer(idComputer, nameComputer, introducedTimestamp, discontinuedTimestamp, companyComputerId);

               computerDAO
                    .insert(computerToAdd);

          } catch (SQLException e) {
               // TODO Auto-generated catch block
               e
                    .printStackTrace();
          }
     }
}

