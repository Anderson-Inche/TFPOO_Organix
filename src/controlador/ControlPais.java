/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.awt.Color;
import model.PaisDAO;
import vistas.RegistrarPais;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Pais;
import vistas.BuscarPais;
import vistas.ModificarPais;

public class ControlPais implements ActionListener {

    PaisDAO modeloPais = new PaisDAO();
    RegistrarPais RegistrarPaisfrm = new RegistrarPais();
    BuscarPais buscaPaisfrm = new BuscarPais();
    ModificarPais modificarPais = new ModificarPais();

    public ControlPais(RegistrarPais RegistrarPaisfrm) {
        this.RegistrarPaisfrm = RegistrarPaisfrm;
        this.RegistrarPaisfrm.ButtonRegistrar.addActionListener(this);
    }

    public ControlPais(BuscarPais buscaPaisfrm) {
        this.buscaPaisfrm = buscaPaisfrm;
        this.buscaPaisfrm.buttonModificar.addActionListener(this);
        this.buscaPaisfrm.buttonEliminar.addActionListener(this);
    }

    public ControlPais(ModificarPais modificarPais) {
        this.modificarPais = modificarPais;
        this.modificarPais.ButtonModificar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == RegistrarPaisfrm.ButtonRegistrar) {
            
            int id = Integer.parseInt(modeloPais.idIncrementable());
            
            int validacion = 0;
            
            if (RegistrarPaisfrm.txtnombrePais.getText().equals("")) {
                RegistrarPaisfrm.txtnombrePais.setBackground(Color.red);
                validacion++;
            }
            
            if (validacion == 0) {
                String nombrePais = RegistrarPaisfrm.txtnombrePais.getText();
                Pais pais = new Pais(id, nombrePais);
                if (modeloPais.validarPais(pais.getIdPais(), pais.getNombrePais())) {
                    if (modeloPais.insertarPais(pais)) {
                        
                        RegistrarPaisfrm.txtnombrePais.setBackground(Color.green);
                        JOptionPane.showMessageDialog(null, "Registro exitoso.");
                        RegistrarPaisfrm.setVisible(false);
                        RegistrarPaisfrm.dispose();
                    }
                } else {
                    RegistrarPaisfrm.txtnombrePais.setBackground(Color.red);
                    JOptionPane.showMessageDialog(null, "País ya registrado");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
            }
        }

        if (event.getSource() == buscaPaisfrm.buttonEliminar) {
            int idEliminar = Integer.parseInt(buscaPaisfrm.lableCodigo.getText());
            String nombreEliminar = buscaPaisfrm.labelNombre.getText();
            Pais pais = new Pais(idEliminar, nombreEliminar);
            if (modeloPais.eliminarPais(pais)) {
                JOptionPane.showMessageDialog(null, "País eliminado satisfactoriamente.");
                buscaPaisfrm.setVisible(false);
                buscaPaisfrm.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "País no se pudó eliminar");
            }
        }
        if (event.getSource() == modificarPais.ButtonModificar) {
            int idPais = Integer.parseInt(modificarPais.labelCodigo.getText());
            String nombre = modificarPais.txtNombrePais.getText();
            int validacion = 0;
            if (modificarPais.txtNombrePais.equals("")){
                modificarPais.txtNombrePais.setBackground(Color.red);
                validacion++;
            }
            if (validacion == 0){
                Pais pais = new Pais(idPais, nombre);
                if(modeloPais.modificarPais(pais)){
                    JOptionPane.showMessageDialog(null, "Pais Modificado");
                    modificarPais.dispose();
                }
            }
        }

    }

}
