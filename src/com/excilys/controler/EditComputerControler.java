package com.excilys.controler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import com.excilys.DTO.ComputerDTO;
import com.excilys.mapper.Mapper;
import com.excilys.model.BeanCompany;
import com.excilys.services.CompanyService;
import com.excilys.services.ComputerService;


@Controller

public class EditComputerControler {


     @Autowired
     private CompanyService companyService;


     @Autowired
     private ComputerService computerService;



     @GetMapping("/editcomputer")
     public String getEditComputer(ModelMap model, @RequestHeader(name = "referer", required = false) String referer, @RequestParam(name = "computerId", required = false) String computerIdString, @RequestParam(name = "computerName", required = false) String computerName)
               throws ServletException, IOException {


          if(""
               .equals(computerName) & referer != null) {
               System.out
                    .println("[EditComputer l42] vide ");

               return "vide";
          } else if(!""
               .equals(computerName) & referer != null) {
                    System.out
                         .println("[EditComputer l48] nonVide ");

                    return "nonVide";
               }

          String erreur = "true";


          erreur = "false";
          model
               .addAttribute("erreur", erreur);

          int defaultParam = 0;

          try {
               int computerId;
               computerId = computerService
                    .getComputerList("listeEntiere", defaultParam, defaultParam)
                    .get(0)
                    .getId();


               if(computerIdString != null) computerId = Integer
                    .parseInt(computerIdString);

               List<ComputerDTO> computerDTOListBig = computerService
                    .getComputerList("unComputer", computerId, 0);


               ComputerDTO computerDTOList = computerDTOListBig
                    .get(0);


               model
                    .addAttribute("computerDTOList", computerDTOList);

               List<BeanCompany> companyListSortedBean = Mapper
                    .beanCompanySorted(companyService
                         .getCompanyList());
               model
                    .addAttribute("companyNamesBean", companyListSortedBean);


               int computerCompanyId;
               computerCompanyId = computerDTOListBig
                    .get(0)
                    .getCompany_id();

               BeanCompany companyComputerSelected = null;

               for (BeanCompany company : companyListSortedBean) {
                    if(company
                         .getId() == computerCompanyId) companyComputerSelected = company;
               }

               model
                    .addAttribute("companySelected", companyComputerSelected);

               computerDTOListBig
                    .clear();

               return "editComputer";

          } catch (SQLException e) {
               e
                    .printStackTrace();
          }


          return "editComputer";
     }


     //
     // public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,
     // ServletException {
     // try {
     //
     //
     // int idComputer = Integer
     // .parseInt(request
     // .getParameter("computerId"));
     //
     // String nameComputer = request
     // .getParameter("nameComputer");
     //
     // String introducedDateString = request
     // .getParameter("introducedDate");
     // String discontinuedDateString = request
     // .getParameter("discontinuedDate");
     //
     // Timestamp introducedTimestamp = Mapper
     // .stringToTime(introducedDateString);
     // Timestamp discontinuedTimestamp = Mapper
     // .stringToTime(discontinuedDateString);
     //
     //
     // List<BeanCompany> companyListSortedBean = Mapper
     // .beanCompanySorted(companyService
     // .getCompanyList());
     // request
     // .setAttribute("companyNamesBean", companyListSortedBean);
     //
     // int companyComputerId = 0;
     //
     // for (BeanCompany company : companyListSortedBean) {
     // if(company
     // .getName()
     // .equals(request
     // .getParameter("companyComputerName")
     // .trim()))
     // companyComputerId = company
     // .getId();
     // }
     //
     //
     // BeanComputer computerToAdd = new BeanComputer(idComputer, nameComputer, introducedTimestamp,
     // discontinuedTimestamp, companyComputerId);
     // computerDAO
     // .update(computerToAdd);
     //
     // doGet(request, response);
     //
     //
     // } catch (Exception e) {
     // throw new ServletException(e);
     // }
     // }

}

