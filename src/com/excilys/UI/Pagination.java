package com.excilys.UI;

import java.util.List;
import com.excilys.model.BeanComputer;

public class Pagination {

  public static List<BeanComputer> getPages(List<BeanComputer> list, int i) {
    return list.subList(i, 10 + i);
  }
}
