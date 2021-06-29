package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    //Conexion local
    public static Connection conectar(){
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bd_organix", "root", "");
            return conexion;
        } catch (SQLException e) {
            System.out.println("Error en la conexion local " + e);
        }
        return (null);
    }
}
