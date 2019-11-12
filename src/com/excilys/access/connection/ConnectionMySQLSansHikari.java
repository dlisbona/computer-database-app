package com.excilys.access.connection;

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



     public Connection getConnection() {
          return connect;
     }
}

