package com.excilys.UI;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import com.excilys.mapper.Mapper;
import com.excilys.model.BeanCompany;
import com.excilys.model.BeanComputer;
import com.excilys.services.CompanyService;
import com.excilys.services.ComputerService;

public class UserInterface {
  private static ComputerService computerService = ComputerService.getInstance();
  private static boolean choiceExit;
  private static int fieldUpdate;

  public static void setChoiceExit(boolean choice) {
    choiceExit = choice;
  }

  public static void setFieldUpdate(int field) {
    fieldUpdate = field;
  }


  public static void main(String[] args) throws SQLException {

    System.out.println(" _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
    System.out.println("|                                |");
    System.out.println("|        INSERT SELECTION        |");
    System.out.println("|                                |");
    System.out.println("|       1 = Computer list        |");
    System.out.println("|       2 = Company  list        |");
    System.out.println("|       3 = Computer detail      |");
    System.out.println("|       4 = Insert computer      |");
    System.out.println("|       5 = Delete computer      |");
    System.out.println("|       6 = Update computer      |");
    System.out.println("|_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |");
    System.out.println();



    Scanner myInput = new Scanner(System.in);

    switch (Mapper.mapperSwitchEnum(myInput.nextInt())) {

      case computerList:
        myInput.close();
        List<BeanComputer> computerList = computerService.getComputerList(0);

        System.out.println();
        System.out.println(
            "-------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%5s %70s %23s %23s %13s", "ID", "NAME", "INTRODUCED", "DISCONTINUED",
            "COMPANY_ID");
        System.out.println();
        System.out.println(
            "-------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < computerList.size(); i++) {

          System.out.format("%5s %70s %23s %23s %13s", computerList.get(i).getId(),
              computerList.get(i).getName(), computerList.get(i).getIntroduced(),
              computerList.get(i).getDiscontinued(), computerList.get(i).getCompany_id());
          System.out.println();

        }
        break;

      case companyList:

        myInput.close();
        List<BeanCompany> company = CompanyService.getCompanyList();

        System.out.println();
        System.out.println(
            "--------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%10s %50s", "ID", "NAME");
        System.out.println();
        System.out.println(
            "--------------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < company.size(); i++) {

          System.out.format("%10s %50s", company.get(i).getId(), company.get(i).getName());
          System.out.println();
        }

        break;

      case computerDetail:

        System.out.println(" _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
        System.out.println("|                                |");
        System.out.println("|       INSERT COMPUTER ID       |");
        System.out.println("|_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |");
        System.out.println();

        int selectionId = myInput.nextInt();
        List<BeanComputer> computerDetail = computerService.getComputerList(selectionId);
        myInput.close();



        System.out.println();
        System.out.println(
            "-------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%5s %70s %23s %23s %13s", "ID", "NAME", "INTRODUCED", "DISCONTINUED",
            "COMPANY_ID");
        System.out.println();
        System.out.println(
            "-------------------------------------------------------------------------------------------------------------------------------------------");


        for (int i = 0; i < computerDetail.size(); i++) {
          System.out.format("%5s %70s %23s %23s %13s", computerDetail.get(i).getId(),
              computerDetail.get(i).getName(), computerDetail.get(i).getIntroduced(),
              computerDetail.get(i).getDiscontinued(), computerDetail.get(i).getCompany_id());
          System.out.println();
        }
        break;


      case insertComputer:

        myInput.close();
        System.out.println(" _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
        System.out.println("|                                |");
        System.out.println("|     INSERT NEW NAME            |");
        System.out.println("|                                |");
        String newComputerName = myInput.next();

        System.out.println("|     INSERT NEW          ID     |");
        int newComputerId = myInput.nextInt();

        System.out.println("|     INTRODUCTION DATE 1        |");

        String newIntroductionDate1 = myInput.next();
        System.out.println("|     END DATE 1                 |");

        String newEndDate1 = myInput.next();

        System.out.println("|     COMPANY ID                 |");
        int newCompanyId = myInput.nextInt();

        computerService.addComputer(newComputerId, newComputerName, newIntroductionDate1,
            newEndDate1, newCompanyId);

        break;


      case deleteComputer:

        System.out.println(" _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
        System.out.println("|                                |");
        System.out.println("|       INSERT COMPUTER ID       |");
        System.out.println("|_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |");
        System.out.println();

        int selectionIdDelete = myInput.nextInt();
        computerService.deleteComputer(selectionIdDelete);
        myInput.close();
        break;


      case updateComputer:
        System.out.println(" _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
        System.out.println("|                                |");
        System.out.println("|       INSERT COMPUTER ID       |");
        System.out.println("|_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |");
        System.out.println();

        int selectionIdUpdate = myInput.nextInt();
        while (choiceExit != true) {

          System.out.println(" _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
          System.out.println("|                                |");
          System.out.println("|     CHOOSE FIELD TO UPDATE     |");
          System.out.println("|                                |");
          System.out.println("|       1 = id                   |");
          System.out.println("|       2 = name                 |");
          System.out.println("|       3 = introduced           |");
          System.out.println("|       4 = discontinued         |");
          System.out.println("|       5 = id_company           |");
          System.out.println("|                                |");
          System.out.println("|       Press 6 to exit          |");
          System.out.println("|_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |");
          System.out.println();

          fieldUpdate = myInput.nextInt();
          System.out.print(fieldUpdate);

          if (fieldUpdate != 6) {
            System.out.println(" _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
            System.out.println("|                                |");
            System.out.println("|       INSERT NEW VALUE         |");
            System.out.println("|_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |");
            System.out.println();


            String valueUpdate = myInput.next();
            ComputerService computerService = ComputerService.getInstance();
            computerService.updateComputer(selectionIdUpdate, valueUpdate, fieldUpdate);
          } else {
            main(null);
          }
        }
    }
    myInput.close();
  }
}


