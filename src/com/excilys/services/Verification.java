package com.excilys.services;

import java.time.LocalDateTime;
import com.excilys.mapper.Mapper;

public class Verification {

  protected static boolean verificationContenuNom(String computerName)

  {
    if (computerName.equals("_") || computerName == "r") {
      return false;
    }
    return true;
  }


  protected static boolean verificationConcordanceDates(String dateIntroduced,
      String dateDiscontinued)

  {
    LocalDateTime introduced = Mapper.stringToLocalDateTime(dateIntroduced);
    LocalDateTime discontinued = Mapper.stringToLocalDateTime(dateDiscontinued);
    if (introduced.isBefore(discontinued)) {
      return true;
    } else {
      return false;
    }
  }
}
