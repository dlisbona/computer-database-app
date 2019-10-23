package com.excilys.services;

public abstract class AbstractService {

     private static ComputerService computerService;



     protected ComputerService getComputerService() {
          return computerService;
     }



     public static void setComputerService(ComputerService setComputerService) {
          computerService = setComputerService;
     }
}

