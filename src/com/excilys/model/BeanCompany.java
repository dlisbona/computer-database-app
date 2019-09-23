package com.excilys.model;


// This class return a company with SQL compatibles attributes
public class BeanCompany {

  public BeanCompany(Integer id, String name) {
    super();
    this.id = id;
    this.name = name;
  }

  private int id;
  private String name;


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



}
