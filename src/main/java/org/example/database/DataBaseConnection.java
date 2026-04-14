package org.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/Proyecto_Cafeteria";
    private static final String USER = "postgres";
    private static final String PASSWORD = "2525";

    public static Connection conectar(){
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }catch (SQLException e){
           throw new RuntimeException("Error de conexion", e);
        }
    }

}
