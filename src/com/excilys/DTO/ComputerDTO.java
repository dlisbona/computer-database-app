package com.excilys.DTO;


public class ComputerDTO {

  public ComputerDTO(int id, String name, String introduced, String discontinued, int company_id) {
    super();
    this.id = id;
    this.name = name;
    this.introduced = introduced;
    this.discontinued = discontinued;
    this.company_id = company_id;
  }

  public ComputerDTO(int id, String name, String introduced, String discontinued,
      String companyName) {
    super();
    this.id = id;
    this.name = name;
    this.introduced = introduced;
    this.discontinued = discontinued;
    this.companyName = companyName;
  }


  private int id;
  private String name;
  private String introduced;
  private String discontinued;
  private int company_id;
  private String companyName;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getIntroduced() {
    return introduced;
  }

  public void setIntroduced(String introduced) {
    this.introduced = introduced;
  }

  public String getDiscontinued() {
    return discontinued;
  }

  public void setDiscontinued(String discontinued) {
    this.discontinued = discontinued;
  }

  public int getCompany_id() {
    return company_id;
  }

  public void setCompany_id(int company_id) {
    this.company_id = company_id;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

}
