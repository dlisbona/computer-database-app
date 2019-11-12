package com.excilys.model.ORM;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class entityJPACompany {

     @Id
     @Column(name = "id")
     @GeneratedValue
     private int id;

     @Column(name = "name")
     private String name;

     @Column(name = "introduced")
     private Timestamp introduced;

     @Column(name = "discontinued")
     private Timestamp discontinued;

     @Column(name = "company_id")
     private int company_Id;

     // Column(name="id")
     // private String companyName;

     private boolean companyIdIsInt;



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
          return company_Id;
     }



     public void setCompany_id(int companyID) {
          this.company_Id = companyID;
     }

     // public String getCompanyName() {
     // return companyName;
     // }
     //
     //
     //
     // public void setCompanyName(String companyName) {
     // this.companyName = companyName;
     // }



     public int getId() {
          return id;
     }



     public void setId(int id) {
          this.id = id;
     }
}
