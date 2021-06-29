/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Producto;
import model.ProductoDAO;
import vistas.BuscarProducto;
import vistas.ModificarProducto;
import vistas.RegistrarProducto;
/**
 *
 * @author ANDERSON
 */
public class ControlProducto implements ActionListener {
    ProductoDAO modeloProducto = new ProductoDAO();
    RegistrarProducto registrarProductofrm = new RegistrarProducto();
    BuscarProducto buscarProducto = new BuscarProducto();
    ModificarProducto modificarProducto = new ModificarProducto();
    public ControlProducto(RegistrarProducto registrarProductofrm) {
        this.registrarProductofrm = registrarProductofrm;
        this.registrarProductofrm.ButtonRegistrar.addActionListener(this);
    }
    public ControlProducto(BuscarProducto buscarProducto){
        this.buscarProducto=buscarProducto;
        this.buscarProducto.buttonEliminar.addActionListener(this);
    }
    public ControlProducto(ModificarProducto modificarProducto){
        this.modificarProducto=modificarProducto;
        this.modificarProducto.ButtonModificar.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == registrarProductofrm.ButtonRegistrar) {
            int id = Integer.parseInt(registrarProductofrm.lblId.getText());
            int validar=0;
            if (registrarProductofrm.txtNombre.equals("")){
                registrarProductofrm.txtNombre.setBackground(Color.red);
                validar++;
            }
            if (registrarProductofrm.txtPrecio.equals("")){
                registrarProductofrm.txtPrecio.setBackground(Color.red);
                validar++;
            }
            if (registrarProductofrm.txtStockDisponible.equals("")){
                registrarProductofrm.txtStockDisponible.setBackground(Color.red);
                validar++;
            }
            if (registrarProductofrm.txtStockReservada.equals("")){
                registrarProductofrm.txtStockReservada.setBackground(Color.red);
                validar++;
            }
            if (registrarProductofrm.jdcDiaReabastecimiento.equals("")){
                registrarProductofrm.jdcDiaReabastecimiento.setBackground(Color.red);
                validar++;
            }
            if (validar == 0){
                
                String nombre = registrarProductofrm.txtNombre.getText();
                Double precio = Double.parseDouble(registrarProductofrm.txtPrecio.getText());
                Date dayReabastecimiento = registrarProductofrm.jdcDiaReabastecimiento.getDate();
                long date = dayReabastecimiento.getTime();
                java.sql.Date fecha = new java.sql.Date(date);
                double stockDisponible = Integer.parseInt(registrarProductofrm.txtStockDisponible.getText());
                double stockReservado = Integer.parseInt(registrarProductofrm.txtStockReservada.getText());
                
                Producto producto = new Producto(id, nombre, fecha, stockDisponible, stockReservado, precio);
                if (modeloProducto.validarProducto(nombre)){
                    if (modeloProducto.insertarProducto(producto)){
                        registrarProductofrm.txtNombre.setBackground(Color.green);
                        registrarProductofrm.txtPrecio.setBackground(Color.green);
                        registrarProductofrm.txtStockDisponible.setBackground(Color.green);
                        registrarProductofrm.txtStockReservada.setBackground(Color.green);
                        registrarProductofrm.jdcDiaReabastecimiento.setBackground(Color.green);
                        JOptionPane.showMessageDialog(null, "Registro exitoso.");
                        registrarProductofrm.setVisible(false);
                        registrarProductofrm.dispose();
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "Producto ya fue registrado.");
                }
                
            }
        }
        if (event.getSource() == buscarProducto.buttonEliminar) {
            int idEliminar = Integer.parseInt(buscarProducto.lableCodigo.getText());
            Producto producto = new Producto();
            producto.setIdProducto(idEliminar);
            if (modeloProducto.eliminarProducto(producto)) {
                JOptionPane.showMessageDialog(null, "Producto eliminado satisfactoriamente.");
                buscarProducto.setVisible(false);
                buscarProducto.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Producto no se pudo eliminar");
            }
        }
        if(event.getSource() == modificarProducto.ButtonModificar){
            int id = Integer.parseInt(modificarProducto.labelCodigo.getText());
            int validar=0;
            if (modificarProducto.txtNombre.equals("")){
                modificarProducto.txtNombre.setBackground(Color.red);
                validar++;
            }
            if (modificarProducto.txtPrecio.equals("")){
                modificarProducto.txtPrecio.setBackground(Color.red);
                validar++;
            }
            if (modificarProducto.txtStockDisponible.equals("")){
                modificarProducto.txtStockDisponible.setBackground(Color.red);
                validar++;
            }
            if (modificarProducto.txtStockReservada.equals("")){
                modificarProducto.txtStockReservada.setBackground(Color.red);
                validar++;
            }
            if (modificarProducto.jdcDiaReabastecimiento.equals("")){
                modificarProducto.jdcDiaReabastecimiento.setBackground(Color.red);
                validar++;
            }
            if (validar == 0){
                String nombre = modificarProducto.txtNombre.getText();
                Double precio = Double.parseDouble(modificarProducto.txtPrecio.getText());
                Date dayReabastecimiento = modificarProducto.jdcDiaReabastecimiento.getDate();
                long date = dayReabastecimiento.getTime();
                java.sql.Date fecha = new java.sql.Date(date);
                int stockDisponible = Integer.parseInt(modificarProducto.txtStockDisponible.getText());
                int stockReservado = Integer.parseInt(modificarProducto.txtStockReservada.getText());
                Producto producto = new Producto(id, nombre, fecha, stockDisponible, stockReservado, precio);
                if (modeloProducto.modificarProducto(producto)){
                    JOptionPane.showMessageDialog(null, "Producto modificado satisfactoriamente.");
                    modificarProducto.dispose();
                }
            }
        }
        
    }
}
