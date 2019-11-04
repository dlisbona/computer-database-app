package com.excilys.controler;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.excilys.DTO.ComputerDTO;
import com.excilys.services.ComputerService;

@Controller
@RequestMapping("/")
public class DashboardControler {
     private int pagination = 10;
     private int defaultReglage = 0;

     @Autowired
     private ComputerService computerService;



     @GetMapping(value = "dashboard")
     public String getDashboard(ModelMap model) throws ServletException {
          List<ComputerDTO> computerListTotal = new ArrayList<ComputerDTO>();
          int computerListTotalLenght;

          try {


               String pageDirection = (String) model
                    .getAttribute("page");

               if(pageDirection != null) {

                    switch (pageDirection) {

                         case "previous":
                              if(pagination > 0) pagination -= 10;

                              computerListTotal
                                   .clear();
                              model
                                   .clear();

                              computerListTotal = computerService
                                   .getComputerList("listePagination", defaultReglage, pagination);

                              computerListTotalLenght = computerService
                                   .getComputerList("listeEntiere", defaultReglage, defaultReglage)
                                   .size();


                              model
                                   .addAttribute("computerListTotalLenght", computerListTotalLenght);
                              model
                                   .addAttribute("computerListTotal", computerListTotal);

                              return "dashboard";


                         case "next":

                              computerListTotal
                                   .clear();
                              model
                                   .clear();

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

                              model
                                   .addAttribute("computerListTotalLenght", computerListTotalLenght);
                              model
                                   .addAttribute("computerListTotal", computerListTotal);

                              return "dashboard";

                         default:

                              pagination = 10;
                              computerListTotal
                                   .clear();
                              model
                                   .clear();

                              computerListTotal = computerService
                                   .getComputerList("listePagination", defaultReglage, defaultReglage);
                              computerListTotalLenght = computerService
                                   .getComputerList("listeEntiere", defaultReglage, defaultReglage)
                                   .size();
                              // model
                              // .addAttribute("computerListTotalLenght", computerListTotalLenght);
                              // model
                              // .addAttribute("computerListTotal", computerListTotal);
                              return "dashboard";


                    }

               } else {
                    pagination = 10;
                    computerListTotal
                         .clear();
                    model
                         .clear();

                    computerListTotal = computerService
                         .getComputerList("listePagination", defaultReglage, defaultReglage);
                    computerListTotalLenght = computerService
                         .getComputerList("listeEntiere", defaultReglage, defaultReglage)
                         .size();

                    model
                         .addAttribute("computerListTotalLenght", computerListTotalLenght);
                    model
                         .addAttribute("computerListTotal", computerListTotal);
                    return "dashboard";

               }
          } catch (Exception e) {
               throw new ServletException(e);
          }
     }
}

