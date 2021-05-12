package model;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
/**
 *
 * @author ANDERSON
 */
public class ProductoDAO {
    public boolean validarProducto(int id) {
        boolean state = true;
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select idProducto from producto where idProducto = '" + id + "' ");
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
    
    public boolean insertarProducto(Producto producto) {
        try {
            Connection cn2 = Conexion.conectar();
            PreparedStatement pst2 = cn2.prepareStatement(
                    "insert  into producto values (?,?,?,?,?,?)");
            pst2.setInt(1, producto.getIdProducto());
            pst2.setString(2, producto.getNombreProducto());
            pst2.setDate(3, (Date) producto.getDiaReabastecimiento());
            pst2.setInt(4, producto.getStock());
            pst2.setInt(5, producto.getCantidadReservada());
            pst2.setDouble(6, producto.getPrecio());
            pst2.executeUpdate();
            cn2.close();
            
            return true;
        } catch (SQLException e) {
            System.err.println("Error al validar usuario " + e);
            return false;
        }
    }
    
    public boolean modificarProducto(Producto producto) {
        try {
            Connection cn2 = Conexion.conectar();
            PreparedStatement pst2 = cn2.prepareStatement(
                    "UPDATE usuario SET nombreProducto=? , diaReabastecimiento=? , "
                    + "cantidadStock=?, cantidadReserva=?, precio=?  WHERE idProducto = ?");
            
            pst2.setString(1, producto.getNombreProducto());
            pst2.setDate(2, (Date) producto.getDiaReabastecimiento());
            pst2.setInt(3, producto.getStock());
            pst2.setInt(4, producto.getCantidadReservada());
            pst2.setDouble(5, producto.getPrecio());
            pst2.setInt(6, producto.getIdProducto());
            
            pst2.execute();
            cn2.close();
            
            return true;
        } catch (SQLException e) {
            System.err.println("Error al validar usuario " + e);
            return false;
        }
    }
    
    public boolean eliminarProducto(Producto producto) {
        try {
            Connection cn2 = Conexion.conectar();
            PreparedStatement pst2 = cn2.prepareStatement(
                    "DELETE FROM pais WHERE idProducto = ?");
            pst2.setInt(1, producto.getIdProducto());
            
            pst2.execute();
            cn2.close();
            
            return true;
        } catch (SQLException e) {
            System.err.println("Error al validar usuario " + e);
            return false;
        }
    }    
    
    public boolean buscarPais(Producto producto) { 
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select * from producto where idProducto = '" + producto.getIdProducto() + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombreProducto(rs.getString("nombreProducto"));
                producto.setDiaReabastecimiento(rs.getDate("diaReabastecimiento"));
                producto.setStock(rs.getInt("cantidadStock"));
                producto.setCantidadReservada(rs.getInt("cantidadReserva"));
                producto.setPrecio(rs.getInt("precio"));
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
