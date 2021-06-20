package model;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
public class FacturaDAO {
    public boolean insertar(Factura factura) {
        try {
            Connection cn2 = Conexion.conectar();
            PreparedStatement pst2 = cn2.prepareStatement(
                    "insert  into factura values (?,?,?,?,?,?,?)");
            pst2.setInt(1, 0);
            pst2.setInt(2, factura.getReserva().getIdReserva());
            pst2.setDouble(3, factura.getMoneyPrecioFinal());
            pst2.setString(4, factura.getNumFactura());
            pst2.setString(5, factura.getNumSerie());
            pst2.setString(6, factura.getFlagCancelado());
            pst2.setDate(7, (Date) factura.getDayFactura());
            
            pst2.executeUpdate();
            cn2.close();

            return true;
        } catch (SQLException e) {
            System.err.println("Error al validar Factura " + e);
            return false;
        }
    }
    public boolean modificarFactura(Factura factura) {
        try {
            Connection cn2 = Conexion.conectar();
            PreparedStatement pst2 = cn2.prepareStatement(
                    "UPDATE factura SET idReserva=? , moneyPrecioFinal=? , "
                    + "numFactura=?, numSerie=?, flagCancelado=?, dayFactura=?  WHERE idFactura = ?");
           
            pst2.setInt(1, factura.getReserva().getIdReserva());
            pst2.setDouble(2,factura.getMoneyPrecioFinal()  );
            pst2.setString(3, factura.getNumFactura());
            pst2.setString(4, factura.getNumSerie());
            pst2.setString(5, factura.getFlagCancelado());
            pst2.setDate(6,(Date) factura.getDayFactura());
            pst2.setInt(7, factura.getIdFactura());
            pst2.execute();
            cn2.close();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al validar factura " + e);
            return false;
        }
    }
    public boolean eliminarFactura(Factura factura) {
        try {
            Connection cn2 = Conexion.conectar();
            PreparedStatement pst2 = cn2.prepareStatement(
                    "DELETE FROM factura WHERE idFactura = ?");
            pst2.setInt(1, factura.getIdFactura());
            
            pst2.execute();
            cn2.close();
            
            return true;
        } catch (SQLException e) {
            System.err.println("Error al validar FACTURA " + e);
            return false;
        }
    }    
    public boolean buscar(Factura factura) { 
        ReservaDAO modelReserva = new ReservaDAO();
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select * from factura where idFactura = '" + factura.getIdFactura()+ "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                factura.setIdFactura(rs.getInt("idFactura"));
                Reserva reserva = new Reserva();
                reserva.setIdReserva(rs.getInt("idReserva"));
                modelReserva.buscar(reserva);
                factura.setReserva(reserva);
                factura.setMoneyPrecioFinal(rs.getDouble("moneyPrecioFinal"));
                factura.setNumFactura(rs.getString("numFactura"));
                factura.setNumSerie(rs.getString("numSerie"));
                factura.setFlagCancelado(rs.getString("flagCancelado"));
                factura.setDayFactura(rs.getDate("dayFactura"));
                return true;
            }
            cn.close();            
            return false;            
        } catch (SQLException e) {
            System.err.println("Error al validar usuario " + e);
            return false;
        }
    }
    public String idIncrementable() {
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT AUTO_INCREMENT as id FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'bd_organix' AND TABLE_NAME = 'factura';");
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
    public  Vector<Reserva> mostrarReserva(){
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = Conexion.conectar();
        Vector<Reserva> datos = new Vector<Reserva>();
        Reserva dat= null;
        try{
            String sql = "SELECT * FROM reserva";
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()){
                dat = new Reserva();
                
                dat.setIdReserva(rs.getInt("idReserva"));
                datos.add(dat);
            }
            
        }catch(SQLException ex){
             System.err.println("Error al validar País " + ex);
        }
        return datos;
    }
}
