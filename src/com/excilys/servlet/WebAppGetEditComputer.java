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
import com.excilys.model.BeanCompany;
import com.excilys.model.BeanComputer;
import com.excilys.services.CompanyService;
import com.excilys.services.ComputerService;
import com.excilys.services.Verification;

@SuppressWarnings("serial")
public class WebAppGetEditComputer extends HttpServlet {

  private String erreurs = "message d'erreur";



  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    ServletContext servletContext = this.getServletContext();
    RequestDispatcher requestDispacher = servletContext.getRequestDispatcher("/WEB-INF/editComputer.jsp");
    int defaultParam = 0;

    ComputerService computerService = ComputerService.getInstance();

    try {

      int computerId = computerService.getComputerList("listeEntiere", defaultParam, defaultParam).get(0).getId();

      String computerIdString = request.getParameter("computerId");

      if (computerIdString != null)
        computerId = Integer.parseInt(request.getParameter("computerId"));


      List<ComputerDTO> computerDTOList = computerService.getComputerList("unComputer", computerId, 0);
      request.setAttribute("computerDTOList", computerDTOList);


      List<BeanCompany> companyListSortedBean = Mapper.beanCompanySorted(CompanyService.getCompanyList());
      request.setAttribute("companyNamesBean", companyListSortedBean);

      int computerCompanyId = computerDTOList.get(0).getCompany_id();

      BeanCompany companyComputerSelected = null;

      for (BeanCompany company : companyListSortedBean) {
        if (company.getId() == computerCompanyId)
          companyComputerSelected = company;
      }

      request.setAttribute("companySelected", companyComputerSelected);


      requestDispacher.forward(request, response);

      computerDTOList.clear();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }


  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    try {

      ComputerDAO computerDAO = ComputerDAO.getInstanceComputerDAO();

      int idComputer = Integer.parseInt(request.getParameter("computerId"));

      String nameComputer = request.getParameter("nameComputer");

      Verification verification = new Verification();
      verification.verificationContenuNom(nameComputer);

      String introducedDateString = request.getParameter("introducedDate");
      String discontinuedDateString = request.getParameter("discontinuedDate");


      try {
        verification.verificationConcordanceDates(introducedDateString, discontinuedDateString);
      } catch (Exception e) {
        request.setAttribute("erreurDates", e);

      }


      Timestamp introducedTimestamp = Mapper.stringToTime(introducedDateString);
      Timestamp discontinuedTimestamp = Mapper.stringToTime(discontinuedDateString);


      List<BeanCompany> companyListSortedBean = Mapper.beanCompanySorted(CompanyService.getCompanyList());
      request.setAttribute("companyNamesBean", companyListSortedBean);

      int companyComputerId = 0;

      for (BeanCompany company : companyListSortedBean) {
        if (company.getName().equals(request.getParameter("companyComputerName").trim()))
          companyComputerId = company.getId();
      }


      BeanComputer computerToAdd = new BeanComputer(idComputer, nameComputer, introducedTimestamp, discontinuedTimestamp, companyComputerId);
      computerDAO.update(computerToAdd);

      doGet(request, response);



    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}

