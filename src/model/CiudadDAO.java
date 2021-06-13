
package model;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Vector;

public class CiudadDAO {
    public boolean validarCiudad(String nombreCiudad){
        boolean state = true;
        try {
             Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select idCiudad from ciudad where nameCiudad = '" + nombreCiudad+"'" );
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
    public boolean insertarCiudad( Ciudad ciudad){
       try {
           Connection cn2 = Conexion.conectar();
           PreparedStatement pst2 = cn2.prepareStatement(
                   "insert  into ciudad values (?,?,?)");
           pst2.setInt(1, ciudad.getIdCiudad());
           pst2.setInt(2, ciudad.getPais().getIdPais());
           pst2.setString(3, ciudad.getNombreCiudad());
           
           pst2.executeUpdate();
           cn2.close();
           return true;
       } catch (SQLException e) {
           System.err.println("Error al validar PAIS " + e);
           return false;
       }
    }      
    public boolean modificarCiudad( Ciudad ciudad){
        try {
            Connection cn2 = Conexion.conectar();
            PreparedStatement pst2 = cn2.prepareStatement(
                    "UPDATE ciudad SET nameCiudad=? , idPais = ? WHERE idCiudad = ?");
            pst2.setString(1, ciudad.getNombreCiudad());
            pst2.setInt(2, ciudad.getPais().getIdPais());
            pst2.setInt(3, ciudad.getIdCiudad());

            pst2.execute();
            cn2.close();

            return true;
        } catch (SQLException e) {
            System.err.println("Error al validar CIUDAD " + e);
            return false;
        }
    }
    public boolean eliminarCiudad( Ciudad ciudad){
          try {
            Connection cn2 = Conexion.conectar();
            PreparedStatement pst2 = cn2.prepareStatement(
                    "DELETE FROM ciudad WHERE idCiudad = ?");
            pst2.setInt(1, ciudad.getIdCiudad());
            pst2.execute();
            cn2.close();

            return true;
        } catch (SQLException e) {
            System.err.println("Error al validar usuario " + e);
            return false;
        }
    }
    public boolean buscarCiudad(Ciudad ciudad){
        try {
             Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select * from ciudad where idCiudad = '" + ciudad.getIdCiudad() + "'");
                ResultSet rs = pst.executeQuery();
                if (rs.next()){
                    ciudad.setIdCiudad(Integer.parseInt(rs.getString("idCiudad")));
                    ciudad.setNombreCiudad(rs.getString("nameCiudad"));
                    Pais pais = new Pais();
                    pais.setIdPais(Integer.parseInt(rs.getString("idPais")));
               
                    PaisDAO modeloPais = new PaisDAO();
                    modeloPais.buscarPais(pais);
                    ciudad.setPais(pais);
                    return true;
                }
                cn.close();  
                return false;
        } catch (SQLException e) {
            System.err.println("Error al validar CIUDAD " + e);
            return false;
        }
    }
    public String idIncrementable(){
          try {
             Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                       "SELECT AUTO_INCREMENT as id FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'bd_organix' AND TABLE_NAME = 'ciudad';" );
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
    public int GetIdPais(String nombre){
        int IdPais = 0;
        try {
             Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select * from pais where namePais = '" + nombre + "'");
                ResultSet rs = pst.executeQuery();
                if (rs.next()){
                    IdPais = rs.getInt("idPais");
                }
                cn.close();  
        } catch (SQLException e) {
            System.err.println("Error al validar usuario " + e);
        }
        return IdPais;
    }
}
