package controlador;

import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Ciudad;
import model.CiudadDAO;
import model.Reserva;
import model.ReservaDAO;
import model.Usuario;
import model.UsuarioDAO;
import vistas.BuscarReserva;
import vistas.ModificarReserva;
import vistas.RegistrarReserva;

public class ControlReserva implements ActionListener{
    RegistrarReserva registrarReserva = new RegistrarReserva();
    ReservaDAO modelReserva = new ReservaDAO();
    BuscarReserva buscarReserva = new BuscarReserva();
    ModificarReserva modificarReserva = new ModificarReserva();
    public ControlReserva (RegistrarReserva registrarReserva){
        this.registrarReserva = registrarReserva;
        this.registrarReserva.ButtonRegistrar.addActionListener(this);
    }
    public ControlReserva (BuscarReserva buscarReserva){
        this.buscarReserva = buscarReserva;
        this.buscarReserva.buttonEliminar.addActionListener(this);
    }
    public ControlReserva(ModificarReserva modificarReserva){
        this.modificarReserva = modificarReserva;
        this.modificarReserva.ButtonModificar.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent event) {
       if (event.getSource() == registrarReserva.ButtonRegistrar) {
           int Id = Integer.parseInt(registrarReserva.lblId.getText());
           int validar=0;
           if (registrarReserva.cbxUsuario.getSelectedItem().toString().equals("Selecciona un Usuario")){
                registrarReserva.cbxUsuario.setBackground(Color.red);
                validar++;
           }
           if (registrarReserva.cbxCiudad.getSelectedItem().toString().equals("Seleccione una Ciudad")){
                registrarReserva.cbxCiudad.setBackground(Color.red);
                validar++;
           }
           if (registrarReserva.jdcFechaReserva.equals("")){
                registrarReserva.jdcFechaReserva.setBackground(Color.red);
                validar++;
           }
           if (registrarReserva.jdcFechaVencimiento.equals("")){
                registrarReserva.jdcFechaVencimiento.setBackground(Color.red);
                validar++;
           }
           if (registrarReserva.cbxAnulado.getSelectedItem().toString().equals("Seleccione")){
                registrarReserva.jdcFechaVencimiento.setBackground(Color.red);
                validar++;
           }
           if (validar == 0){
                String nombreUsuario = registrarReserva.cbxUsuario.getSelectedItem().toString();
                String nombreCiudad = registrarReserva.cbxCiudad.getSelectedItem().toString();

                Usuario user = new Usuario();
                UsuarioDAO modeloUser = new UsuarioDAO();
                user.setIdUsuario(modelReserva.GetIdUsuario(nombreUsuario));
                modeloUser.buscarUser(user);

                Ciudad ciudad = new Ciudad();
                ciudad.setIdCiudad(modelReserva.GetIdCiudad(nombreCiudad));
                CiudadDAO modelCiudad=new CiudadDAO();
                modelCiudad.buscarCiudad(ciudad);

                Date dayReserva = registrarReserva.jdcFechaReserva.getDate();
                long dateReserva = dayReserva.getTime();
                java.sql.Date fechaReserv = new java.sql.Date(dateReserva);
                Date dayLlegada = registrarReserva.jdcFechaLlegada.getDate();
                long dateLlegada = dayLlegada.getTime();
                java.sql.Date fechaLlegada = new java.sql.Date(dateLlegada);
                Date dayVencimiento = registrarReserva.jdcFechaVencimiento.getDate();
                long dateVencimiento = dayVencimiento.getTime();
                java.sql.Date fechaVencimiento = new java.sql.Date(dateVencimiento);
                String flagAnulado = registrarReserva.cbxAnulado.getSelectedItem().toString();

                Reserva reserva = new Reserva(Id, ciudad, user, fechaReserv, fechaLlegada, flagAnulado, fechaVencimiento);
                if (modelReserva.insertar(reserva)){
                    JOptionPane.showMessageDialog(null, "Registro exitoso. ");
                    registrarReserva.dispose();
                }else {
                    JOptionPane.showMessageDialog(null, "Reserva ya fue registrado.");
                }
           }
       }
       if (event.getSource() == buscarReserva.buttonEliminar){
           int idEliminar = Integer.parseInt(buscarReserva.lableCodigo.getText());
            Reserva reserva = new Reserva();
            reserva.setIdReserva(idEliminar);
            if (modelReserva.eliminar(reserva)) {
                JOptionPane.showMessageDialog(null, "Reserva eliminada satisfactoriamente.");
                buscarReserva.setVisible(false);
                buscarReserva.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Producto no se pudo eliminar");
            }
       }
       
       if (event.getSource() == modificarReserva.ButtonModificar){
           
           int Id = Integer.parseInt(modificarReserva.labelCodigo.getText());
           int validar=0;
           if (modificarReserva.cbxUsuario.getSelectedItem().toString().equals("Selecciona un Usuario")){
                modificarReserva.cbxUsuario.setBackground(Color.red);
                validar++;
           }
           if (modificarReserva.cbxCiudad.getSelectedItem().toString().equals("Seleccione una Ciudad")){
                modificarReserva.cbxCiudad.setBackground(Color.red);
                validar++;
           }
           if (modificarReserva.jdcFechaReserva.equals("")){
                modificarReserva.jdcFechaReserva.setBackground(Color.red);
                validar++;
           }
           if (modificarReserva.jdcFechaVencimiento.equals("")){
                modificarReserva.jdcFechaVencimiento.setBackground(Color.red);
                validar++;
           }
           if (modificarReserva.cbxAnulado.getSelectedItem().toString().equals("Seleccione")){
                modificarReserva.jdcFechaVencimiento.setBackground(Color.red);
                validar++;
           }
           if (validar == 0){
               String nombreUsuario = modificarReserva.cbxUsuario.getSelectedItem().toString();
                String nombreCiudad = modificarReserva.cbxCiudad.getSelectedItem().toString();

                Usuario user = new Usuario();
                UsuarioDAO modeloUser = new UsuarioDAO();
                user.setIdUsuario(modelReserva.GetIdUsuario(nombreUsuario));
                modeloUser.buscarUser(user);

                Ciudad ciudad = new Ciudad();
                ciudad.setIdCiudad(modelReserva.GetIdCiudad(nombreCiudad));
                CiudadDAO modelCiudad=new CiudadDAO();
                modelCiudad.buscarCiudad(ciudad);

                Date dayReserva = modificarReserva.jdcFechaReserva.getDate();
                long dateReserva = dayReserva.getTime();
                java.sql.Date fechaReserv = new java.sql.Date(dateReserva);
                Date dayLlegada = modificarReserva.jdcFechaLlegada.getDate();
                long dateLlegada = dayLlegada.getTime();
                java.sql.Date fechaLlegada = new java.sql.Date(dateLlegada);
                Date dayVencimiento = modificarReserva.jdcFechaVencimiento.getDate();
                long dateVencimiento = dayVencimiento.getTime();
                java.sql.Date fechaVencimiento = new java.sql.Date(dateVencimiento);
                String flagAnulado = modificarReserva.cbxAnulado.getSelectedItem().toString();

                Reserva reserva = new Reserva(Id, ciudad, user, fechaReserv, fechaLlegada, flagAnulado, fechaVencimiento);
                if (modelReserva.modificar(reserva)){
                    JOptionPane.showMessageDialog(null, "Reserva de modificó satisfactoriamente. ");
                    modificarReserva.dispose();
                }else {
                    JOptionPane.showMessageDialog(null, "Reserva ya fue registrado.");
                }
           }
       }
       
       
       
    }
    
}
