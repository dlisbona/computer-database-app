package com.excilys.UI;

import java.util.Scanner;

public class NavigationPagination {

  static Scanner sc = new Scanner(System.in);
  static int nombreComputer = 0;

  public static int pageSuivante(char reponse) {

    while (reponse != 'O' && reponse != 'N') {
      reponse = sc.nextLine().charAt(0);
      nombreComputer = nombreComputer + 10;
      return nombreComputer;
    }
    return nombreComputer;
  }
}
