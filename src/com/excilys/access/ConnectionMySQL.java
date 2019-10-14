package com.excilys.access;

import java.sql.Connection;
import java.sql.SQLException;
import com.excilys.util.DBproperties2;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionMySQL {

     private static HikariConfig cfg = new HikariConfig();
     private static HikariDataSource ds;
     private static ConnectionMySQL instanceConnection;
     private static Connection connect;

     static {
          cfg
               .setJdbcUrl(DBproperties2.DBurl);
          cfg
               .setUsername(DBproperties2.DBuser);
          cfg
               .setPassword(DBproperties2.DBpassword);
          cfg
               .addDataSourceProperty("cachePrepStmts", DBproperties2.cachePrepStmts);
          cfg
               .addDataSourceProperty("prepStmtCacheSize", DBproperties2.prepStmtCacheSize);
          cfg
               .addDataSourceProperty("prepStmtCacheSqlLimit", DBproperties2.prepStmtCacheSqlLimit);
          ds = new HikariDataSource(cfg);
     }



     private ConnectionMySQL() throws SQLException {
          ConnectionMySQL.connect = ds
               .getConnection();
     };



     public static ConnectionMySQL getInstanceConnection() throws SQLException {
          if(instanceConnection == null) {
               instanceConnection = new ConnectionMySQL();
          } else if(instanceConnection
               .getConnection()
               .isClosed()) {
                    instanceConnection = new ConnectionMySQL();
               }
          return instanceConnection;
     }



     public Connection getConnection() {
          return connect;
     }

}

