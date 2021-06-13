/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Ciudad;
import model.CiudadDAO;
import model.Pais;
import vistas.BuscarCiudad;
import vistas.ModificarCiudad;
import vistas.RegistrarCiudad;

public class ControlCiudad implements ActionListener {

    CiudadDAO modeloCiudad = new CiudadDAO();
    RegistrarCiudad registrarCiudadfrm = new RegistrarCiudad();
    BuscarCiudad buscaCiudadfrm = new BuscarCiudad();
    ModificarCiudad modificarCiudad = new ModificarCiudad();

    public ControlCiudad(RegistrarCiudad registrarCiudadfrm) {
        this.registrarCiudadfrm = registrarCiudadfrm;
        this.registrarCiudadfrm.ButtonRegistrar.addActionListener(this);
    }

    public ControlCiudad(BuscarCiudad buscaCiudadfrm) {
        this.buscaCiudadfrm = buscaCiudadfrm;
        this.buscaCiudadfrm.buttonModificar.addActionListener(this);
        this.buscaCiudadfrm.buttonEliminar.addActionListener(this);
    }

    public ControlCiudad(ModificarCiudad modificarCiudad) {
        this.modificarCiudad = modificarCiudad;
        this.modificarCiudad.ButtonModificar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == registrarCiudadfrm.ButtonRegistrar) {
            String nombreCiudad;
            String nombrePais;
            int validacion = 0;

            if (registrarCiudadfrm.txtNombre.getText().equals("")) {
                registrarCiudadfrm.txtNombre.setBackground(Color.red);
                validacion++;
            }
            nombreCiudad = registrarCiudadfrm.txtNombre.getText();
            nombrePais = registrarCiudadfrm.cbxPais.getSelectedItem().toString();
            int idCuidad = Integer.parseInt(registrarCiudadfrm.lblId.getText());
            Pais pais = new Pais(modeloCiudad.GetIdPais(nombrePais), nombrePais);
            if (validacion == 0) {
                Ciudad ciudad = new Ciudad(idCuidad, nombreCiudad, pais);
                if (modeloCiudad.validarCiudad(ciudad.getNombreCiudad())) {
                    if (modeloCiudad.insertarCiudad(ciudad)) {

                        registrarCiudadfrm.txtNombre.setBackground(Color.green);
                        JOptionPane.showMessageDialog(null, "Registro exitoso.");
                        registrarCiudadfrm.setVisible(false);
                        registrarCiudadfrm.dispose();
                    }
                } else {
                    registrarCiudadfrm.txtNombre.setBackground(Color.red);
                    JOptionPane.showMessageDialog(null, "Ciudad ya registrado");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
            }
        }

        if (event.getSource() == buscaCiudadfrm.buttonEliminar) {
            int idEliminar = Integer.parseInt(buscaCiudadfrm.lableCodigo.getText());
            Ciudad ciudad = new Ciudad();
            ciudad.setIdCiudad(idEliminar);
            if (modeloCiudad.eliminarCiudad(ciudad)) {
                JOptionPane.showMessageDialog(null, "Ciudad eliminado satisfactoriamente.");
                buscaCiudadfrm.setVisible(false);
                buscaCiudadfrm.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Ciudad no se pudó eliminar");
            }
        }

        if (event.getSource() == modificarCiudad.ButtonModificar) {
            int idCiudad = Integer.parseInt(modificarCiudad.labelCodigo.getText());
            String nombrePais;

            int validacion = 0;
            if (modificarCiudad.txtNombreCiudad.equals("")) {
                modificarCiudad.txtNombreCiudad.setBackground(Color.red);
                validacion++;
            }
            if (validacion == 0) {
                String nombre = modificarCiudad.txtNombreCiudad.getText();
                nombrePais = modificarCiudad.cbxPais.getSelectedItem().toString();
                Pais pais = new Pais(modeloCiudad.GetIdPais(nombrePais), nombrePais);
                Ciudad ciudad = new Ciudad(idCiudad, nombre, pais);
                if (modeloCiudad.modificarCiudad(ciudad)) {
                    JOptionPane.showMessageDialog(null, "Ciudad Modificado");
                    modificarCiudad.dispose();
                }
            }
        }

    }
}
