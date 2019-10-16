package com.excilys.UI;
import java.util.ArrayList;
import java.util.List;
import com.excilys.DTO.ComputerDTO;
import com.excilys.services.ComputerService;

public class Pagination2 {
     private int numberPages;
     private int computerListTotalLenght;
     private int currentPage = 1;
     private int pagination;
     private final int defaultReglage = 0;

     List<ComputerDTO> computerListTotal = new ArrayList<ComputerDTO>();
     ComputerService computerService = ComputerService
          .getInstance();



     public int pageNumber(int page, int pagesLength, String pageDirection) {

          if(pageDirection != null) {
               switch (pageDirection) {

                    case "previous":
                         if(page > 0) currentPage--;
                         return currentPage;

                    case "next":
                         computerListTotalLenght = computerService
                              .getComputerList("listeEntiere", defaultReglage, defaultReglage)
                              .size();
                         int computerListTotalPages = computerListTotalLenght;
                         if(computerListTotalLenght % pagesLength != 0) {
                              computerListTotalPages = (computerListTotalPages - (computerListTotalPages % pagesLength)) / pagesLength + 1;
                         } else {
                              computerListTotalPages = (computerListTotalPages) / pagesLength;
                         }
                         if(page < computerListTotalPages) currentPage++;
                         return currentPage;

                    default:
                         currentPage = 1;
                         return currentPage;
               }
          } else {
               currentPage = 1;
               return currentPage;
          }
     }



     public List<ComputerDTO> navigationListPages(int pages, int pagesLength, String pageDirection) {

          if(pageDirection != null) {

               switch (pageDirection) {

                    case "previous":
                         if(pagination > 0) currentPage--;
                         computerListTotal
                              .clear();
                         pagination = currentPage * 10;
                         computerListTotal = computerService
                              .getComputerListPage(pages, pagesLength);
                         return computerListTotal;

                    case "next":
                         computerListTotalLenght = computerService
                              .getComputerList("listeEntiere", defaultReglage, defaultReglage)
                              .size();
                         int computerListTotalPagination = computerListTotalLenght;
                         if(computerListTotalLenght % pagesLength != 0) {
                              computerListTotalPagination = computerListTotalPagination - (computerListTotalPagination % pagesLength);
                         } else {
                              computerListTotalPagination = computerListTotalPagination - pagesLength;
                         }

                         if(pagination < computerListTotalPagination) pagination = currentPage * 10;
                         if(pagination < numberPages) currentPage++;

                         computerListTotal
                              .clear();
                         pagination = currentPage * 10;
                         computerListTotal = computerService
                              .getComputerListPage(pages, pagesLength);


                         return computerListTotal;


                    default:
                         currentPage = 1;
                         computerListTotal
                              .clear();
                         pagination = currentPage * 10;
                         computerListTotal = computerService
                              .getComputerListPage(pages, pagesLength);
                         return computerListTotal;
               }
          } else {
               currentPage = 1;
               computerListTotal
                    .clear();
               pagination = currentPage * 10;
               computerListTotal = computerService
                    .getComputerListPage(pages, pagesLength);
               return computerListTotal;
          }
     }
}
