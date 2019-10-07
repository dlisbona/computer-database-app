package com.excilys.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.excilys.DTO.ComputerDTO;
import com.excilys.access.ComputerDAO;
import com.excilys.mapper.Mapper;
import com.excilys.model.BeanComputer;
import com.excilys.services.CompanyService;
import com.excilys.services.ComputerService;

@SuppressWarnings("serial")
public class WebAppGetEditComputer extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ServletContext servletContext = this.getServletContext();
    RequestDispatcher requestDispacher =
        servletContext.getRequestDispatcher("/WEB-INF/editComputer.jsp");

    List<String> companyNames;
    try {
      companyNames = CompanyService.getCompanyListSorted();
      request.setAttribute("companyNames", companyNames);

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    int computerId = 1;

    String computerIdString = request.getParameter("computerId");

    if (computerIdString != null)
      computerId = Integer.parseInt(request.getParameter("computerId"));

    ComputerService computerService = ComputerService.getInstance();

    List<ComputerDTO> computerDTOList =
        computerService.getComputerList("unComputer", computerId, 0);



    try {
      List<String> companyNamesIndexes = CompanyService.getCompanyListString();

      String companyName = null;
      if (computerDTOList.get(0).getCompany_id() != 0)
        companyName = companyNamesIndexes.get(computerDTOList.get(0).getCompany_id() - 1);


      request.setAttribute("companyName", companyName);

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    request.setAttribute("computerDTOList", computerDTOList);

    requestDispacher.forward(request, response);
    computerDTOList.clear();

  }


  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    try {

      System.out.println(request.getParameterNames().hasMoreElements());

      ComputerDAO computerDAO = ComputerDAO.getInstanceComputerDAO();
      int idComputer = 0;


      String nameComputer = request.getParameter("nameComputer");
      System.out.println(nameComputer);


      String introducedDateString = request.getParameter("introducedDate");
      System.out.println(introducedDateString);



      String discontinuedDateString = request.getParameter("discontinuedDate");


      Timestamp introducedTimestamp = Mapper.stringToTime(introducedDateString);
      Timestamp discontinuedTimestamp = Mapper.stringToTime(discontinuedDateString);

      String companyComputerName = request.getParameter("companyComputerName");



      List<String> companyNames = CompanyService.getCompanyListString();
      int companyComputerId = companyNames.indexOf(companyComputerName) + 2;
      BeanComputer computerToAdd = new BeanComputer(idComputer, nameComputer, introducedTimestamp,
          discontinuedTimestamp, companyComputerId);
      computerDAO.insert(computerToAdd);


    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}

