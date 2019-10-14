package com.excilys.util;

public @interface DBproperties2 {

     String DBname = "com.mysql.jdbc.Driver";
     String DBurl = "jdbc:mysql://localhost:3306/computer-database-db";
     String DBuser = "admincdb";
     String DBpassword = "qwerty1234";

     String cachePrepStmts = "true";
     String prepStmtCacheSize = "256";
     String prepStmtCacheSqlLimit = "2048";

     boolean useServerPrepStmts = true;

}
