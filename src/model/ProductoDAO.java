package model;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
/**
 *
 * @author ANDERSON
 */
public class ProductoDAO {
    public boolean validarProducto(String nombre) {
        boolean state = true;
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select nameProducto from producto where nameProducto = '" + nombre + "' ");
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
                    "UPDATE producto SET nameProducto=? , dayReabastecimiento=? , "
                    + "quantityStock=?, quantityReserva=?, moneyPrecio=?  WHERE idProducto = ?");
            
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
                    "DELETE FROM producto WHERE idProducto = ?");
            pst2.setInt(1, producto.getIdProducto());
            
            pst2.execute();
            cn2.close();
            
            return true;
        } catch (SQLException e) {
            System.err.println("Error al validar usuario " + e);
            return false;
        }
    }    
    
    public boolean buscarProducto(Producto producto) { 
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select * from producto where idProducto = '" + producto.getIdProducto() + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombreProducto(rs.getString("nameProducto"));
                producto.setDiaReabastecimiento(rs.getDate("dayReabastecimiento"));
                producto.setStock(rs.getInt("quantityStock"));
                producto.setCantidadReservada(rs.getInt("quantityReserva"));
                producto.setPrecio(rs.getInt("moneyPrecio"));
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
                       "SELECT AUTO_INCREMENT as id FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'bd_organix' AND TABLE_NAME = 'producto';" );
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
