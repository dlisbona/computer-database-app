package com.excilys.UI;

import java.util.ArrayList;
import java.util.List;
import com.excilys.DTO.ComputerDTO;

public class Pagination {

  int numberPages;
  int numbercomputer;
  int choiceLimit;
  int currentPage;
  int pagination;
  int[] pageMenu = new int[5];

  List<ComputerDTO> computerListTotal = new ArrayList<ComputerDTO>();
  String pageDirection;


  public static List<ComputerDTO> getPages(List<ComputerDTO> list, int i) {
    return list.subList(i, 10 + i);
  }
}

