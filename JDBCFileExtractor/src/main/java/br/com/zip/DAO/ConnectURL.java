package br.com.zip.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectURL {
    
    private String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=db_zip;user=javaacesso;password=071283";
    
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(connectionUrl);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }    
}  