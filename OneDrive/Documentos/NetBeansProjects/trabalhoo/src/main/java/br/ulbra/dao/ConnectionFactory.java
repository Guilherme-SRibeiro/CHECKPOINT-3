package br.ulbra.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ti_escola",
                "root",
                "nextage"
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
         }
    }
 }