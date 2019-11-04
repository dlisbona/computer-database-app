package com.excilys.services;

import org.springframework.stereotype.Component;

@Component
public abstract class AbstractService {

     private static ComputerService computerService;



     protected ComputerService getComputerService() {
          return computerService;
     }



     public static void setComputerService(ComputerService setComputerService) {
          computerService = setComputerService;
     }
}

