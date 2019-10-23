package com.excilys.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.springframework.stereotype.Component;


@Component
public class ConnectionMySQLSansHikari {

     private String url = com.excilys.util.DBproperties.DBurl;
     private String user = com.excilys.util.DBproperties.DBuser;
     private String passwd = com.excilys.util.DBproperties.DBpassword;

     private Connection connect;



     ConnectionMySQLSansHikari() throws SQLException {
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


     //
     // public static ConnectionMySQLSansHikari getInstanceConnection() throws SQLException {
     // if(instanceConnection == null) {
     // instanceConnection = new ConnectionMySQLSansHikari();
     // } else if(instanceConnection
     // .getConnection()
     // .isClosed()) {
     // instanceConnection = new ConnectionMySQLSansHikari();
     // }
     // return instanceConnection;
     // }



     public Connection getConnection() {
          return connect;
     }
}

