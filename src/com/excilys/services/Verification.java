package com.excilys.services;

import java.time.LocalDateTime;
import com.excilys.mapper.Mapper;

public class Verification {

  public void verificationContenuNom(String computerName) throws Exception

  {
    if ("null".equals(computerName) || computerName.isEmpty()) {
      throw new Exception("String computerName is empty");
    }
  }


  public void verificationDate(String date) throws Exception

  {
    if ("null".equals(date) || date.isEmpty()) {
      throw new Exception("String Date is empty");
    }
  }



  public void verificationConcordanceDates(String dateIntroduced, String dateDiscontinued)
      throws Exception {

    LocalDateTime introduced = Mapper.stringToLocalDateTime(dateIntroduced);
    LocalDateTime discontinued = Mapper.stringToLocalDateTime(dateDiscontinued);
    if (introduced.isAfter(discontinued)) {

      throw new Exception("dateDiscontinued is anterious to dateIntroduced ");
    }

  }



}
