package com.company;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

    public Connection getConnection(String dbName, String user, String password){
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/" + dbName, user, password);
            if (connection != null){
                System.out.println("Connection established");
            }
            else {
                System.out.println("Connection failed");
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return connection;
    }
}
