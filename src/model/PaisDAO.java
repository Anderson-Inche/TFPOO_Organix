/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
/**
 *
 * @author ANDERSON
 */
public class PaisDAO {
    public boolean validarPais(int idPais, String nombrePais){
        boolean state = true;
        try {
             Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select idPais from pais where idPais = '" + idPais + "' or nombrePais = '" + nombrePais+"'" );
                ResultSet rs = pst.executeQuery();
                if (rs.next()){
                    return false;
                }
            cn.close();   
        } catch (SQLException e) {
            System.err.println("Error al validar usuario " + e);
        }
        return state;
    }
    public boolean addPais( Pais pais){
        try {
            Connection cn2 = Conexion.conectar();
            PreparedStatement pst2 = cn2.prepareStatement(
                    "insert  into pais values (?,?)");
            pst2.setInt(1, pais.getIdPais());
            pst2.setString(2, pais.getNombrePais());
            pst2.executeUpdate();
            cn2.close();

            return true;
        } catch (SQLException e) {
            System.err.println("Error al validar usuario " + e);
            return false;
        }
    }    
    
}
