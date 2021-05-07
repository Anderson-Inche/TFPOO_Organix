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

public class ControlPais implements ActionListener{
    PaisDAO modeloPais = new PaisDAO();
    RegistrarPais RegistrarPaisfrm= new RegistrarPais();
    
    public ControlPais(RegistrarPais RegistrarPaisfrm){
        this.RegistrarPaisfrm =RegistrarPaisfrm;
        this.RegistrarPaisfrm.ButtonRegistrar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        int id; 
        String nombrePais;
        id = Integer.parseInt(RegistrarPaisfrm.txtidPais.getText());
        nombrePais = RegistrarPaisfrm.txtnombrePais.getText();
        
        Pais pais = new Pais(id, nombrePais);
        int validacion = 0;
        if(RegistrarPaisfrm.txtidPais.getText().equals("")){
            RegistrarPaisfrm.txtidPais.setBackground(Color.red);
            validacion++;
        }
        if (RegistrarPaisfrm.txtidPais.getText().equals("")){
            RegistrarPaisfrm.txtnombrePais.setBackground(Color.red);
            validacion++;
        }
        
         if (validacion == 0) {
            if (modeloPais.validarPais(pais.getIdPais(),pais.getNombrePais())) {
                if (modeloPais.addPais(pais)){
                    RegistrarPaisfrm.txtidPais.setBackground(Color.green);
                    RegistrarPaisfrm.txtnombrePais.setBackground(Color.green);

                    JOptionPane.showMessageDialog(null, "Registro exitoso.");
                    
                }  
            } else {
                RegistrarPaisfrm.txtidPais.setBackground(Color.red);
                JOptionPane.showMessageDialog(null, "País no disponible");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
        }
        
    }
    
}
