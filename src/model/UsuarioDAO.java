package model;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UsuarioDAO extends Conexion {

    public boolean verificarUser(String DNI) {
        boolean state = true;
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select dni from usuario where idDocumento = '" + DNI + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return false;
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error al validar usuario " + e);
        }
        return state;
    }

    public boolean insertarUser(Usuario user) {
        try {
            Connection cn2 = Conexion.conectar();
            PreparedStatement pst2 = cn2.prepareStatement(
                    "insert  into usuario values (?,?,?,?,?,?,?,?)");
            pst2.setInt(1, 0);
            pst2.setString(2, user.getNombre());
            pst2.setString(3, user.getApellido());
            pst2.setString(4, user.getIdDocumento());
            pst2.setString(5, user.getDireccion());
            pst2.setString(6, user.getEmail());
            pst2.setString(7, user.getPassword());
            pst2.setString(8, "Cliente");

            pst2.executeUpdate();
            cn2.close();

            return true;
        } catch (SQLException e) {
            System.err.println("Error al validar usuario " + e);
            return false;
        }
    }

    public boolean modificarUser(Usuario user) {
        try {
            Connection cn2 = Conexion.conectar();
            PreparedStatement pst2 = cn2.prepareStatement(
                    "UPDATE usuario SET  nameUsuario=? , nameApellido = ?, iddocumento = ?, "
                    + "direccion=?, email=?, password=?, permiso=? WHERE idUsuario=?");

            pst2.setString(1, user.getNombre());
            pst2.setString(2, user.getApellido());
            pst2.setString(3, user.getIdDocumento());
            pst2.setString(4, user.getDireccion());
            pst2.setString(5, user.getEmail());
            pst2.setString(6, user.getPassword());
            pst2.setString(7, user.getNivel_permiso());
            pst2.setInt(8, user.getIdUsuario());

            pst2.executeUpdate();
            cn2.close();

            return true;
        } catch (SQLException e) {
            System.err.println("Error al validar usuario " + e);
            return false;
        }
    }

    public boolean eliminarUser(Usuario user) {
        try {
            Connection cn2 = Conexion.conectar();
            PreparedStatement pst2 = cn2.prepareStatement(
                    "DELETE FROM usuario WHERE idUsuario = ?");
            pst2.setInt(1, user.getIdUsuario());

            pst2.executeUpdate();
            cn2.close();

            return true;
        } catch (SQLException e) {
            System.err.println("Error al validar usuario " + e);
            return false;
        }
    }

    public boolean buscarUser(Usuario user) {

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select * from usuario where idUsuario = '" + user.getIdUsuario() + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                user.setIdUsuario(Integer.parseInt(rs.getString("idUsuario")));
                user.setNombre(rs.getString("nameUsuario"));
                user.setApellido(rs.getString("nameApellido"));
                user.setIdDocumento(rs.getString("idDocumento"));
                user.setDireccion(rs.getString("direccion"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setNivel_permiso(rs.getString("permiso"));
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
                     "SELECT AUTO_INCREMENT as id FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'bd_organix' AND TABLE_NAME = 'usuario';" );
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
    
}
