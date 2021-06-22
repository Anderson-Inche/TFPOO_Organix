/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class ReservaDAO {

    public boolean insertar(Reserva reserva) {
        try {
            Connection cn2 = Conexion.conectar();
            PreparedStatement pst2 = cn2.prepareStatement(
                    "insert  into reserva values (?,?,?,?,?,?,?)");
            pst2.setInt(1, 0);
            pst2.setInt(2, reserva.getUsuario().getIdUsuario());
            pst2.setInt(3, reserva.getCiudad().getIdCiudad());
            pst2.setDate(4, (Date) reserva.getDayReserva());
            pst2.setDate(5, (Date) reserva.getDayLlegada());
            pst2.setString(6, reserva.getFlagAnulado());
            pst2.setDate(7, (Date) reserva.getDayVencimiento());
            
            pst2.executeUpdate();
            cn2.close();

            return true;
        } catch (SQLException e) {
            System.err.println("Error al validar reserva " + e);
            return false;
        }
    }

    public boolean modificar(Reserva reserva) {
        try {
            Connection cn2 = Conexion.conectar();
            PreparedStatement pst2 = cn2.prepareStatement(
                    "UPDATE reserva SET idUsuario= ?, idCiudad=?,dayReserva=?,dayLlegada=?,falgAnulado=?,dayVencimiento=? WHERE idReserva = ?");
            pst2.setInt(1, reserva.getUsuario().getIdUsuario());
            pst2.setInt(2, reserva.getCiudad().getIdCiudad());
            pst2.setDate(3, (Date) reserva.getDayReserva());
            pst2.setDate(4, (Date) reserva.getDayLlegada());
            pst2.setString(5, reserva.getFlagAnulado());
            pst2.setDate(6, (Date) reserva.getDayVencimiento());
            pst2.setInt(7, reserva.getIdReserva());

            pst2.execute();
            cn2.close();

            return true;
        } catch (SQLException e) {
            System.err.println("Error al validar RESERVA " + e);
            return false;
        }
    }

    public boolean eliminar(Reserva reserva) {
        try {
            Connection cn2 = Conexion.conectar();
            PreparedStatement pst2 = cn2.prepareStatement(
                    "DELETE FROM reserva WHERE idReserva = ?");
            pst2.setInt(1, reserva.getIdReserva());
            pst2.execute();
            cn2.close();

            return true;
        } catch (SQLException e) {
            System.err.println("Error al validar reserva: " + e);
            return false;
        }
    }

    public boolean buscar(Reserva reserva) {
        UsuarioDAO modelUsuario = new UsuarioDAO();
        CiudadDAO modelCiudad = new CiudadDAO();

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select * from reserva where idReserva = '" + reserva.getIdReserva() + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                reserva.setIdReserva(Integer.parseInt(rs.getString("idReserva")));
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(Integer.parseInt(rs.getString("idUsuario")));
                modelUsuario.buscarUser(usuario);
                Ciudad ciudad = new Ciudad();
                ciudad.setIdCiudad(Integer.parseInt(rs.getString("idCiudad")));
                modelCiudad.buscarCiudad(ciudad);
                reserva.setUsuario(usuario);
                reserva.setCiudad(ciudad);
                
                reserva.setDayReserva(rs.getDate("dayReserva"));
                System.out.println("FECHA:" + reserva.getDayReserva() );
                reserva.setDayLlegada(rs.getDate("dayLlegada"));
                reserva.setFlagAnulado(rs.getString("flagAnulado"));
                reserva.setDayVencimiento(rs.getDate("dayVencimiento"));
                return true;
            }
            cn.close();
            return false;
        } catch (SQLException e) {
            System.err.println("Error al BUSCAR " + e);
            return false;
        }
    }

    public String idIncrementable() {
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT AUTO_INCREMENT as id FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'bd_organix' AND TABLE_NAME = 'reserva';");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int id_incrementado = rs.getInt(1);
                System.out.println("ID:" + String.valueOf(id_incrementado));
                return String.valueOf(id_incrementado);

            }
            cn.close();
            return "";
        } catch (SQLException e) {
            System.err.println("Error al validar reserva " + e);
            return "";
        }
    }
    
    public  Vector<Usuario> mostrarUsuarios(){
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = Conexion.conectar();
        Vector<Usuario> datos = new Vector<Usuario>();
        Usuario dat= null;
        try{
            String sql = "SELECT * FROM usuario";
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            dat = new Usuario();
            dat.setIdUsuario(0);
            dat.setNombre("Selecciona un Usuario");
            datos.add(dat);
            while(rs.next()){
                dat = new Usuario();
                
                dat.setIdUsuario(rs.getInt("idUsuario"));
                dat.setNombre(rs.getString("nombreUsuario"));

                datos.add(dat);
            }
            
        }catch(SQLException ex){
             System.err.println("Error al validar País " + ex);
        }
        return datos;
    }

    public Vector<Ciudad> mostraCiudad() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = Conexion.conectar();
        Vector<Ciudad> datos = new Vector<Ciudad>();
        Ciudad dat = null;
        try {
            String sql = "SELECT idCiudad,nameCiudad FROM ciudad";
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();

            dat = new Ciudad();
            dat.setIdCiudad(0);
            dat.setNombreCiudad("Selecciona una Ciudad");
            datos.add(dat);
            System.out.println("ITEM: " + datos.firstElement());
            while (rs.next()) {
                dat = new Ciudad();
                dat.setIdCiudad(rs.getInt("idCiudad"));
                dat.setNombreCiudad(rs.getString("nameCiudad"));
                datos.add(dat);
            }

        } catch (SQLException ex) {
            System.err.println("Error al validar Ciudad " + ex);
        }
        return datos;
    }
    
    public int GetIdUsuario(String nombre){
        int Id = 0;
        try {
             Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select * from usuario where nombreUsuario = '" + nombre + "'");
                ResultSet rs = pst.executeQuery();
                if (rs.next()){
                    Id = rs.getInt("idUsuario");
                }
                cn.close();  
        } catch (SQLException e) {
            System.err.println("Error al validar usuario " + e);
        }
        return Id;
    }
    public int GetIdCiudad(String nombre){
        int Id = 0;
        try {
             Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select * from ciudad where nameCiudad= '" + nombre + "'");
                ResultSet rs = pst.executeQuery();
                if (rs.next()){
                    Id = rs.getInt("idCiudad");
                }
                cn.close();  
        } catch (SQLException e) {
            System.err.println("Error al validar usuario " + e);
        }
        return Id;
    }
}
