package com.excilys.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionMySQL {


  private String url = "jdbc:mysql://localhost:3306/computer-database-db";
  private String user = "admincdb";
  private String passwd = "qwerty1234";
  private Connection connect;
  private static ConnectionMySQL instanceConnection;

  private ConnectionMySQL() throws SQLException {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      this.connect = DriverManager.getConnection(url, user, passwd);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  public static ConnectionMySQL getInstanceConnection() throws SQLException {
    if (instanceConnection == null) {
      instanceConnection = new ConnectionMySQL();
    } else if (instanceConnection.getConnection().isClosed()) {
      instanceConnection = new ConnectionMySQL();
    }
    return instanceConnection;
  }

  public Connection getConnection() {
    return connect;
  }
}

