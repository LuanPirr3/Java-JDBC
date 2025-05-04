package org.example;

import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws  Exception{
        // data connect database
        String url = "jdbc:mysql://localhost:3306/curso";
        String username = "root";
        String password = "Lu4n.Dev.Engs0ft2024";

        // search database
        String query = "select NOME, CPF, EMAIL FROM cliente;";

        // load and reguster the driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // estabilish connection
        Connection con = DriverManager.getConnection(url, username, password);
        System.out.println("Connection estabilished successfully");

        // create statament
        Statement st = con.createStatement();

        // execute the query
        ResultSet rs = st.executeQuery(query);

        while (rs.next()){
            String name = rs.getString("NOME");
            String cpf = rs.getString("CPF");
            String email = rs.getString("EMAIL");

            System.out.println("Nome: " + name);
            System.out.println("CPF: " + cpf);
            System.out.println("Email: " + email);
            System.out.println("-----");

        }

        // close statament and connection
        rs.close();
        st.close();
        con.close();
        System.out.println("Connection closed");

    }
}