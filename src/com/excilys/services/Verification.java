package com.excilys.services;

import java.time.LocalDateTime;
import com.excilys.mapper.Mapper;

@SuppressWarnings("serial")
public class Verification extends Exception {

     public Verification(String errorMessage, Throwable err) {
          super(errorMessage, err);
     }



     public Verification(String errorMessage) {
          super(errorMessage);
     }



     public void verificationContenuNom(String computerName) throws Verification

     {
          if("null"
               .equals(computerName)
                    || computerName
                         .isEmpty()) {
               throw new Verification("String Date is empty");
          }

     }



     public void verificationDate(String date) throws Exception

     {
          if("null"
               .equals(date)
                    || date
                         .isEmpty()) {
               throw new Exception("String Date is empty");
          }
     }



     public void verificationConcordanceDates(String dateIntroduced, String dateDiscontinued) throws Exception {

          LocalDateTime introduced = Mapper
               .stringToLocalDateTime(dateIntroduced);
          LocalDateTime discontinued = Mapper
               .stringToLocalDateTime(dateDiscontinued);
          if(introduced
               .isAfter(discontinued)) {

               throw new Exception("dateDiscontinued is anterious to dateIntroduced ");
          }

     }


}
