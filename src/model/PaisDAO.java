package model;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

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
    
    public boolean insertarPais( Pais pais){
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
    public boolean modificarPais( Pais pais){
        try {
            Connection cn2 = Conexion.conectar();
            PreparedStatement pst2 = cn2.prepareStatement(
                    "UPDATE usuario SET nombrePais=? WHERE idPais = ?");
            pst2.setString(1, pais.getNombrePais());
            pst2.setInt(2, pais.getIdPais());

            pst2.execute();
            cn2.close();

            return true;
        } catch (SQLException e) {
            System.err.println("Error al validar usuario " + e);
            return false;
        }
    }
    
    public boolean eliminarPais( Pais pais){
          try {
            Connection cn2 = Conexion.conectar();
            PreparedStatement pst2 = cn2.prepareStatement(
                    "DELETE FROM pais WHERE idPais = ?");
            pst2.setInt(1, pais.getIdPais());
            pst2.execute();
            cn2.close();

            return true;
        } catch (SQLException e) {
            System.err.println("Error al validar usuario " + e);
            return false;
        }
    }      
    public boolean buscarPais( Pais pais){
        try {
             Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select * from pais where idPais = '" + pais.getIdPais() + "'");
                ResultSet rs = pst.executeQuery();
                if (rs.next()){
                    pais.setIdPais(Integer.parseInt(rs.getString("idPais")));
                    pais.setNombrePais(rs.getString("nombrePais"));
                    return true;
                }
                cn.close();  
                return false;  
        } catch (SQLException e) {
            System.err.println("Error al validar usuario " + e);
            return false;
        }
    }
}
