package com.excilys.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySQLPremier {

     private String url = com.excilys.util.DBproperties.DBurl;
     private String user = com.excilys.util.DBproperties.DBuser;
     private String passwd = com.excilys.util.DBproperties.DBpassword;
     private Connection connect;
     private static ConnectionMySQLPremier instanceConnection;



     private ConnectionMySQLPremier() throws SQLException {
          try {
               Class
                    .forName(com.excilys.util.DBproperties.DBname);
               this.connect = DriverManager
                    .getConnection(url, user, passwd);
          } catch (ClassNotFoundException e) {
               e
                    .printStackTrace();
          }
     }



     public static ConnectionMySQLPremier getInstanceConnection() throws SQLException {
          if(instanceConnection == null) {
               instanceConnection = new ConnectionMySQLPremier();
          } else if(instanceConnection
               .getConnection()
               .isClosed()) {
                    instanceConnection = new ConnectionMySQLPremier();
               }
          return instanceConnection;
     }



     public Connection getConnection() {
          return connect;
     }
}

