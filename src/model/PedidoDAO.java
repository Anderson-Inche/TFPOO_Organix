package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class PedidoDAO {
    public boolean insertar(Pedido pedido) {
        try {
            Connection cn2 = Conexion.conectar();
            PreparedStatement pst2 = cn2.prepareStatement(
                    "insert  into pedido values (?,?,?,?,?)");
            pst2.setInt(1, pedido.getIdPedido());
            pst2.setInt(2, pedido.getProducto().getIdProducto());
            pst2.setInt(3, pedido.getReserva().getIdReserva());
            pst2.setDouble(4, pedido.getQuantityPeso());
            pst2.setDouble(5, pedido.getMoneyPrecio());
            pst2.executeUpdate();
            cn2.close();
            
            return true;
        } catch (SQLException e) {
            System.err.println("Error al validar pedido " + e);
            return false;
        }
    }
    public boolean modificar(Pedido pedido) {
        try {
            Connection cn2 = Conexion.conectar();
            PreparedStatement pst2 = cn2.prepareStatement(
                    "UPDATE pedido SET quantityPedido=? , idProducto=? , "
                    + "idReserva=?, moneyPrecio=? WHERE idPedido = ?");
            System.out.println("ID PRODUCTO"+  pedido.getProducto().getIdProducto());
            pst2.setDouble(1, pedido.getQuantityPeso());
            pst2.setInt(2, pedido.getProducto().getIdProducto());
            pst2.setInt(3, pedido.getReserva().getIdReserva());
            pst2.setDouble(4, pedido.getMoneyPrecio());
            pst2.setInt(5, pedido.getIdPedido());
            
            pst2.execute();
            cn2.close();
            
            return true;
        } catch (SQLException e) {
            System.err.println("Error al validar pedido " + e);
            return false;
        }
    }
    public boolean eliminar(Pedido pedido) {
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
    public boolean buscarPedido(Pedido pedido) { 
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select * from pedido where idPedido = '" + pedido.getIdPedido() + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                pedido.setIdPedido(rs.getInt("idPedido"));
                pedido.setQuantityPeso(rs.getDouble("quantityPedido"));
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));
                ProductoDAO modelPro = new ProductoDAO();
                modelPro.buscarProducto(producto);
                pedido.setProducto(producto);
                Reserva reserva = new Reserva();
                reserva.setIdReserva(rs.getInt("idReserva"));
                ReservaDAO modelReserv = new ReservaDAO();
                modelReserv.buscar(reserva);
                pedido.setReserva(reserva);
                pedido.setMoneyPrecio(rs.getInt("moneyPrecio"));
                return true;
            }
            cn.close();            
            return false;            
        } catch (SQLException e) {
            System.err.println("Error al validar usuario " + e);
            return false;
        }
    }
    
    public  Vector<Producto> mostrarProductos(){
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = Conexion.conectar();
        Vector<Producto> datos = new Vector<Producto>();
        Producto dat= null;
        try{
            String sql = "SELECT * FROM producto";
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            dat = new Producto();
            dat.setIdProducto(0);
            dat.setNombreProducto("Selecciona un Producto");
            datos.add(dat);
            while(rs.next()){
                dat = new Producto();
                
                dat.setIdProducto(rs.getInt("idProducto"));
                dat.setNombreProducto(rs.getString("nameProducto"));

                datos.add(dat);
            }
        }catch(SQLException ex){
             System.err.println("Error al validar País " + ex);
        }
        return datos;
    }
        public String idIncrementable(){
          try {
             Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                       "SELECT AUTO_INCREMENT as id FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'bd_organix' AND TABLE_NAME = 'pedido';" );
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
    public int GetIdProducto(String nombre){
        int Id = 0;
        try {
             Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select * from producto where nameProducto = '" + nombre + "'");
                ResultSet rs = pst.executeQuery();
                if (rs.next()){
                    Id = rs.getInt("idProducto");
                }
                cn.close();  
        } catch (SQLException e) {
            System.err.println("Error al validar Producto " + e);
        }
        return Id;
    }
}
