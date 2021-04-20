/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ANDERSON
 */
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
