package model;
import java.awt.List;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Vector;

public class PaisDAO {
    public boolean validarPais(int idPais, String nombrePais){
        boolean state = true;
        try {
             Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select idPais from pais where idPais = '" + idPais + "' or namePais = '" + nombrePais+"'" );
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
                    "UPDATE pais SET namePais=? WHERE idPais = ?");
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
                    pais.setNombrePais(rs.getString("namePais"));
                    return true;
                }
                cn.close();  
                return false;  
        } catch (SQLException e) {
            System.err.println("Error al validar usuario " + e);
            return false;
        }
    }
    public String idIncrementable(){
          try {
             Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                       "SELECT AUTO_INCREMENT as id FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'bd_organix' AND TABLE_NAME = 'pais';" );
                ResultSet rs = pst.executeQuery();
                if (rs.next()){
                    int id_incrementado = rs.getInt(1);
                    System.out.println("ID:" + String.valueOf(id_incrementado));
                    return String.valueOf(id_incrementado);
                    
                }
                cn.close(); 
                return "";
            } catch (SQLException e) {
                System.err.println("Error al validar usuario " + e);
                return "";
            }
    }
    public  Vector<Pais> mostrarPaises(){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = Conexion.conectar();
        Vector<Pais> datos = new Vector<Pais>();
        Pais dat= null;
        try{
            String sql = "SELECT * FROM pais";
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            dat = new Pais();
            dat.setIdPais(0);
            dat.setNombrePais("Selecciona País");
            datos.add(dat);
            while(rs.next()){
                dat = new Pais();
                dat.setIdPais(rs.getInt("idPais"));
                dat.setNombrePais(rs.getString("namePais"));
                datos.add(dat);
            }
            
        }catch(SQLException ex){
             System.err.println("Error al validar País " + ex);
        }
        return datos;
    }
}
