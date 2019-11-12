package com.excilys.util;

public @interface DBproperties {

     String DBname = "com.mysql.jdbc.Driver";
     String DBurl = "jdbc:mysql://localhost:3306/computer-database-db";
     String DBuser = "admincdb";
     String DBpassword = "qwerty1234";
     String PROPERTY_SHOW_SQL = "hibernate.show_sql";
     String PROPERTY_DIALECT = "hibernate.dialect";

     boolean cachePrepStmts = true;
     int prepStmtCacheSize = 256;
     int prepStmtCacheSqlLimit = 2048;

     boolean useServerPrepStmts = true;

}
