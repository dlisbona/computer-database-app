package com.excilys.access;

import java.sql.Connection;
import java.sql.SQLException;
import com.excilys.util.DBproperties2;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionMySQL {

     private static HikariConfig cfg = new HikariConfig();
     private static HikariDataSource ds;

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



     private ConnectionMySQL() {};



     public static Connection getInstanceConnection() throws SQLException {

          return ds
               .getConnection();
     }

}

