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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import model.Pais;
import vistas.BuscarPais;
import vistas.PanelPais;

public class ControlPais implements ActionListener , KeyListener{

    PaisDAO modeloPais = new PaisDAO();
    RegistrarPais RegistrarPaisfrm = new RegistrarPais();
    PanelPais paisPanel = new PanelPais();
    BuscarPais buscaPaisfrm = new BuscarPais();

    public ControlPais(RegistrarPais RegistrarPaisfrm) {
        this.RegistrarPaisfrm = RegistrarPaisfrm;
        this.RegistrarPaisfrm.ButtonRegistrar.addActionListener(this);
    }

    public ControlPais(BuscarPais buscaPaisfrm) {
        this.buscaPaisfrm = buscaPaisfrm;
        this.buscaPaisfrm.buttonModificar.addActionListener(this);
    }

    public ControlPais(PanelPais paisPanel) {
        this.paisPanel = paisPanel;
        this.paisPanel.buttonBuscar.addActionListener(this);
        this.paisPanel.txtBuscaPais.addKeyListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == RegistrarPaisfrm.ButtonRegistrar) {
            int id;
            String nombrePais;
            id = Integer.parseInt(RegistrarPaisfrm.txtidPais.getText());
            nombrePais = RegistrarPaisfrm.txtnombrePais.getText();

            Pais pais = new Pais(id, nombrePais);
            int validacion = 0;
            if (RegistrarPaisfrm.txtidPais.getText().equals("")) {
                RegistrarPaisfrm.txtidPais.setBackground(Color.red);
                validacion++;
            }
            if (RegistrarPaisfrm.txtidPais.getText().equals("")) {
                RegistrarPaisfrm.txtnombrePais.setBackground(Color.red);
                validacion++;
            }

            if (validacion == 0) {
                if (modeloPais.validarPais(pais.getIdPais(), pais.getNombrePais())) {
                    if (modeloPais.insertarPais(pais)) {
                        RegistrarPaisfrm.txtidPais.setBackground(Color.green);
                        RegistrarPaisfrm.txtnombrePais.setBackground(Color.green);

                        JOptionPane.showMessageDialog(null, "Registro exitoso.");

                    }
                } else {
                    RegistrarPaisfrm.txtidPais.setBackground(Color.red);
                    JOptionPane.showMessageDialog(null, "País no disponible");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
            }
        }
        if (event.getSource() == paisPanel.buttonBuscar ){
            int validacion = 0;
            
            if (paisPanel.txtBuscaPais.getText().equals("")){
                paisPanel.txtBuscaPais.setBackground(Color.red);
                validacion++;
            }
            if (validacion==0){
                int codPaisBuscar = Integer.parseInt(paisPanel.txtBuscaPais.getText());
                Pais pais = new Pais(codPaisBuscar, "");
                if (modeloPais.buscarPais(pais)){
                    BuscarPais buscarPais = new BuscarPais();
                    buscarPais.setVisible(true);
                    buscarPais.lableCodigo.setText(String.valueOf(pais.getIdPais()));
                    buscarPais.labelNombre.setText(pais.getNombrePais());
                }
            }
        
        }   
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
     
    }

    @Override
    public void keyPressed(KeyEvent key) {
        if (key.getKeyCode() ==  KeyEvent.VK_ENTER){
            int validacion = 0;
            
            if (paisPanel.txtBuscaPais.getText().equals("")){
                paisPanel.txtBuscaPais.setBackground(Color.red);
                validacion++;
            }
            if (validacion==0){
                int codPaisBuscar = Integer.parseInt(paisPanel.txtBuscaPais.getText());
                Pais pais = new Pais(codPaisBuscar, "");
                if (modeloPais.buscarPais(pais)){
                    BuscarPais buscarPais = new BuscarPais();
                    buscarPais.setVisible(true);
                    buscarPais.lableCodigo.setText(String.valueOf(pais.getIdPais()));
                    buscarPais.labelNombre.setText(pais.getNombrePais());
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        
    }
    

}
