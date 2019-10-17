package com.excilys.model;

import java.sql.Timestamp;


public class BeanComputer {


     public BeanComputer(int id, String name, Timestamp introduced, Timestamp discontinued, int companyID) {
          super();
          this.id = id;
          this.name = name;
          this.introduced = introduced;
          this.discontinued = discontinued;
          this.companyID = companyID;
     }



     //

     public BeanComputer(int id, String name, Timestamp introduced, Timestamp discontinued, String companyName) {
          super();
          this.id = id;
          this.name = name;
          this.introduced = introduced;
          this.discontinued = discontinued;
          this.companyName = companyName;
     }


     private int id;
     private String name;
     private Timestamp introduced;
     private Timestamp discontinued;
     private int companyID;
     private String companyName;
     // pas d'underscore dans les noms de variables
     // Mieux vaut declarer directement un type company : private company companyId;



     public String getName() {
          return name;
     }



     public void setName(String name) {
          this.name = name;
     }



     public Timestamp getIntroduced() {
          return introduced;
     }



     public void setIntroduced(Timestamp introduced) {
          this.introduced = introduced;
     }



     public Timestamp getDiscontinued() {
          return discontinued;
     }



     public void setDiscontinued(Timestamp discontinued) {
          this.discontinued = discontinued;
     }



     public int getCompany_id() {
          return companyID;
     }



     public void setCompany_id(int companyID) {
          this.companyID = companyID;
     }



     public String getCompanyName() {
          return companyName;
     }



     public void setCompanyName(String companyName) {
          this.companyName = companyName;
     }



     public int getId() {
          return id;
     }



     public void setId(int id) {
          this.id = id;
     }

}
