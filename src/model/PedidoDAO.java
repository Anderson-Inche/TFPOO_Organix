package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PedidoDAO {
    public boolean insertar(Pedido pedido) {
        try {
            Connection cn2 = Conexion.conectar();
            PreparedStatement pst2 = cn2.prepareStatement(
                    "insert  into pedido values (?,?,?,?)");
            pst2.setInt(1, pedido.getIdPedido());
            pst2.setDouble(2, pedido.getQuantityPeso());
            pst2.setInt(3, pedido.getProducto().getIdProducto());
            pst2.setInt(4, pedido.getReserva().getIdReserva());
            pst2.executeUpdate();
            cn2.close();
            
            return true;
        } catch (SQLException e) {
            System.err.println("Error al validar pedido " + e);
            return false;
        }
    }
    public boolean modificarProducto(Pedido pedido) {
        try {
            Connection cn2 = Conexion.conectar();
            PreparedStatement pst2 = cn2.prepareStatement(
                    "UPDATE pedido SET quantityPedido=? , idProducto=? , "
                    + "idReserva=? WHERE idPedido = ?");
            
            pst2.setDouble(1, pedido.getQuantityPeso());
            pst2.setInt(2, pedido.getProducto().getIdProducto());
            pst2.setInt(3, pedido.getReserva().getIdReserva());
            pst2.setInt(4, pedido.getIdPedido());
            
            pst2.execute();
            cn2.close();
            
            return true;
        } catch (SQLException e) {
            System.err.println("Error al validar pedido " + e);
            return false;
        }
    }
    public boolean eliminarProducto(Pedido pedido) {
        try {
            Connection cn2 = Conexion.conectar();
            PreparedStatement pst2 = cn2.prepareStatement(
                    "DELETE FROM pedido WHERE idPedido = ?");
            pst2.setInt(1, pedido.getIdPedido());
            
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
}
