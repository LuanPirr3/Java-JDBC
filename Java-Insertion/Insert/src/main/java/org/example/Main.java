package org.example;
import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // replace by your database
        String url = "jdbc:mysql://localhost:3306/database";
        String username = "root";
        String password = " password";

        // make your inquiry here
        String query = "INSERT INTO cliente (NOME, SEXO, EMAIL, CPF) VALUES('JONAS','M','JONAS.TESTE@YAHOO.COM','12415654')";

        // trying connection
        try {
            // load drivers
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection(url,username,password);

            // create statement
            Statement st = c.createStatement();

            // execute the query
            int count = st.executeUpdate(query);
            System.out.println("Number of rows affected by this query: " + count);

            //close connection
            st.close();
            c.close();
            System.out.println("Connection closed");
        }
        catch (ClassNotFoundException e){
            System.err.println("SQL Error: " + e.getMessage());
        }
        catch (SQLException e){
            System.err.println("JDBC Driver not found: " + e.getMessage());
        }
    }
}