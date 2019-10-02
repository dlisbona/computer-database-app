package com.excilys.UI;

import java.util.List;
import com.excilys.DTO.ComputerDTO;

public class Pagination {

  public static List<ComputerDTO> getPages(List<ComputerDTO> list, int i) {
    return list.subList(i, 10 + i);
  }
}
