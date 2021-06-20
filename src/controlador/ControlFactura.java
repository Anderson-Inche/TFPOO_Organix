package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.util.Date;
import model.Factura;
import model.FacturaDAO;
import model.Reserva;
import vistas.BuscarFactura;
import vistas.ModificarFactura;
import vistas.RegistrarFactura;

public class ControlFactura implements ActionListener {
    RegistrarFactura registrarFactura = new RegistrarFactura();
    BuscarFactura buscarFactura = new BuscarFactura();
    ModificarFactura modificarFactura= new ModificarFactura();
    FacturaDAO modelFactura = new FacturaDAO();
    
    public ControlFactura(RegistrarFactura registrarFactura){
        this.registrarFactura = registrarFactura;
        this.registrarFactura.ButtonRegistrar.addActionListener(this);
    }
    public ControlFactura(BuscarFactura buscarFactura){
        this.buscarFactura= buscarFactura;
        this.buscarFactura.buttonEliminar.addActionListener(this);
        this.buscarFactura.buttonModificar.addActionListener(this);
    }
    public ControlFactura( ModificarFactura modificarFactura){
        this.modificarFactura = modificarFactura;
        this.modificarFactura.ButtonModificar.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent event) {
       if (event.getSource() == registrarFactura.ButtonRegistrar){
           int Id = Integer.parseInt(registrarFactura.lblCodigo.getText());
           int validar = 0;
           if (registrarFactura.txtNumFac.getText().equals("")){
               validar++;
               registrarFactura.txtNumFac.setBackground(Color.red);
           }
           if (registrarFactura.txtNumSerie.getText().equals("")){
               validar++;
               registrarFactura.txtNumSerie.setBackground(Color.red);
           }
           if (registrarFactura.jdcFecha.equals("")){
               validar++;
               registrarFactura.jdcFecha.setBackground(Color.red);
           }
           if (registrarFactura.txtMonto.getText().equals("")){
               validar++;
               registrarFactura.txtMonto.setBackground(Color.red);
           }
           
           if (validar == 0){
                Reserva reserva = new Reserva();
                reserva.setIdReserva(Integer.parseInt(registrarFactura.cbxReserva.getSelectedItem().toString()));
             
                double moneyPrecioFinal = Double.parseDouble(registrarFactura.txtMonto.getText());             
                String numFactura = registrarFactura.txtNumFac.getText();
                String numSerie = registrarFactura.txtNumSerie.getText();
                String flagCancelado= registrarFactura.cbxCancelado.getSelectedItem().toString();
                Date dayFactura =registrarFactura.jdcFecha.getDate(); 
                long date = dayFactura.getTime();
                java.sql.Date fecha = new java.sql.Date(date);
                Factura factura = new Factura(Id, reserva, moneyPrecioFinal, numFactura, numSerie, flagCancelado, fecha);
                if (modelFactura.insertar(factura)){
                    registrarFactura.txtNumFac.setBackground(Color.green);
                    registrarFactura.txtNumSerie.setBackground(Color.green);
                    registrarFactura.jdcFecha.setBackground(Color.green);
                    registrarFactura.txtMonto.setBackground(Color.green);
                    JOptionPane.showMessageDialog(null, "Registro exitoso.");
                    registrarFactura.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Factura ya fue registrado.");
                }
           }
       }
       if (event.getSource() == buscarFactura.buttonEliminar){
            int idEliminar = Integer.parseInt(buscarFactura.lableCodigo.getText());
            Factura factura = new Factura();
            factura.setIdFactura(idEliminar);
            if (modelFactura.eliminarFactura(factura)) {
                JOptionPane.showMessageDialog(null, "Factura eliminada satisfactoriamente.");
                buscarFactura.setVisible(false);
                buscarFactura.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Factura no se pudo eliminar");
            }
           
       }
       if (event.getSource() == modificarFactura.ButtonModificar){
           int Id = Integer.parseInt(modificarFactura.lblCodigo.getText());
           int validar = 0;
           if (modificarFactura.txtNumFac.getText().equals("")){
               validar++;
               modificarFactura.txtNumFac.setBackground(Color.red);
           }
           if (modificarFactura.txtNumSerie.getText().equals("")){
               validar++;
               modificarFactura.txtNumSerie.setBackground(Color.red);
           }
           if (modificarFactura.jdcFecha.equals("")){
               validar++;
               modificarFactura.jdcFecha.setBackground(Color.red);
           }
           if (modificarFactura.txtMonto.getText().equals("")){
               validar++;
               modificarFactura.txtMonto.setBackground(Color.red);
           }
           if (validar == 0){
               Reserva reserva = new Reserva();
                reserva.setIdReserva(Integer.parseInt(modificarFactura.cbxReserva.getSelectedItem().toString()));
             
                double moneyPrecioFinal = Double.parseDouble(modificarFactura.txtMonto.getText());             
                String numFactura = modificarFactura.txtNumFac.getText();
                String numSerie = modificarFactura.txtNumSerie.getText();
                String flagCancelado= modificarFactura.cbxCancelado.getSelectedItem().toString();
                Date dayFactura =modificarFactura.jdcFecha.getDate(); 
                long date = dayFactura.getTime();
                java.sql.Date fecha = new java.sql.Date(date);
                Factura factura = new Factura(Id, reserva, moneyPrecioFinal, numFactura, numSerie, flagCancelado, fecha);
                if (modelFactura.modificarFactura(factura)){
                    modificarFactura.txtNumFac.setBackground(Color.green);
                    modificarFactura.txtNumSerie.setBackground(Color.green);
                    modificarFactura.jdcFecha.setBackground(Color.green);
                    modificarFactura.txtMonto.setBackground(Color.green);
                    JOptionPane.showMessageDialog(null, "Factura modificada satisfactoriamente.");
                    modificarFactura.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Error al modificar");
                }
           }
           
       }
       
    }
    
    
}
