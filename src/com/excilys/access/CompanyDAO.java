package com.excilys.access;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.excilys.access.connection.ConnectionMySQLSansHikari;
import com.excilys.model.BeanCompany;

@Component
public class CompanyDAO {
     private ResultSet result;

     @Autowired
     private ConnectionMySQLSansHikari connectionMySQLSansHikari;



     public List<BeanCompany> requete(String requeteSQL) {
          List<BeanCompany> companies = new ArrayList<BeanCompany>();
          Statement statement;


          try {

               statement = connectionMySQLSansHikari
                    .getConnection()
                    .createStatement();


               result = statement
                    .executeQuery(requeteSQL);

               while (result
                    .next()) {
                    final int id;
                    final String name;

                    id = result
                         .getInt("id");
                    name = result
                         .getString("name");

                    BeanCompany company = new BeanCompany(id, name);
                    company
                         .setId(id);
                    company
                         .setName(name);
                    companies
                         .add(company);
               }

          } catch (SQLException e) {
               e
                    .printStackTrace();
          }
          return companies;
     }


}
