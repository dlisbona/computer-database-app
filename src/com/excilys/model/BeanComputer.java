package com.excilys.model;

import java.sql.Timestamp;

// This class return a computer with SQL compatible attributes

public class BeanComputer {

  public BeanComputer(int id, String name, Timestamp introduced, Timestamp discontinued,
      int company_id) {
    super();
    this.id = id;
    this.name = name;
    this.introduced = introduced;
    this.discontinued = discontinued;
    this.company_id = company_id;
  }

  private int id;
  private String name;
  private Timestamp introduced;
  private Timestamp discontinued;
  private int company_id; // pas d'underscore dans les noms de variables
  // Mieux vaut declarer directement un type company : private company companyId;


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
    return company_id;
  }

  public void setCompany_id(int company_id) {
    this.company_id = company_id;
  }
}
