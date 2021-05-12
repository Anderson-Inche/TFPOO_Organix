/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
                    "select dni from usuario where dni = '" + DNI + "'");
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
                    "UPDATE usuario SET  nombre=? , apellido = ?, dni = ?, "
                    + "direccion=?, email=?, password=?, nivel_permiso=? WHERE id_usuario=?");

            pst2.setString(1, user.getNombre());
            pst2.setString(2, user.getApellido());
            pst2.setString(3, user.getIdDocumento());
            pst2.setString(4, user.getDireccion());
            pst2.setString(5, user.getEmail());
            pst2.setString(6, user.getPassword());
            pst2.setString(7, "Cliente");
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
                    "DELETE FROM usuario WHERE id_usuario = ?");
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
                    "select * from usuario where id_usuario = '" + user.getIdUsuario() + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                user.setIdUsuario(Integer.parseInt(rs.getString("id_usuario")));
                user.setNombre(rs.getString("nombre"));
                user.setNombre(rs.getString("apellido"));
                user.setNombre(rs.getString("dni"));
                user.setNombre(rs.getString("direccion"));
                user.setNombre(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setPassword(rs.getString("nivel_permiso"));
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
