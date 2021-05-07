/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Usuario;
import model.UsuarioDAO;
import vistas.RegistrarUsuario;

public class ControlUsuario implements ActionListener {

    UsuarioDAO modeloUsuario = new UsuarioDAO();
    RegistrarUsuario panelRegistrarUser = new RegistrarUsuario();
    JPanel loginpanel = new JPanel();

    public ControlUsuario(RegistrarUsuario panelRegistrarUser, JPanel loginpanel) {
        this.panelRegistrarUser = panelRegistrarUser;
        this.loginpanel = loginpanel;
        this.panelRegistrarUser.botonRegistrar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String nombre, apellido, documento, direccion, email, password;
        nombre = panelRegistrarUser.txtNombre.getText().trim();
        apellido = panelRegistrarUser.txtApellido.getText().trim();
        documento = panelRegistrarUser.txtDocumento.getText().trim();
        direccion = panelRegistrarUser.txtDireccion.getText().trim();
        email = panelRegistrarUser.txtCorreo.getText().trim();
        password = panelRegistrarUser.txtContraseña.getText().trim();
        Usuario user = new Usuario(WIDTH, nombre, apellido, documento, direccion, email, password, "Cliente");
        int validacion = 0;
        if (user.getEmail().equals("")) {
            panelRegistrarUser.txtCorreo.setBackground(Color.red);
            validacion++;
        }
        if (user.getNombre().equals("")) {
            panelRegistrarUser.txtNombre.setBackground(Color.red);
            validacion++;
        }
        if (user.getApellido().equals("")) {
            panelRegistrarUser.txtApellido.setBackground(Color.red);
            validacion++;
        }
        if (user.getIdDocumento().equals("")) {
            panelRegistrarUser.txtDocumento.setBackground(Color.red);
            validacion++;
        }
        if (user.getDireccion().equals("")) {
            panelRegistrarUser.txtDireccion.setBackground(Color.red);
            validacion++;
        }
        if (user.getPassword().equals("")) {
            panelRegistrarUser.txtContraseña.setBackground(Color.red);
            validacion++;
        }
        if (validacion == 0) {
            if (modeloUsuario.verificarUser(user.getIdDocumento())) {
                if (modeloUsuario.addUser(user)){
                    panelRegistrarUser.txtCorreo.setBackground(Color.green);
                    panelRegistrarUser.txtNombre.setBackground(Color.green);
                    panelRegistrarUser.txtApellido.setBackground(Color.green);
                    panelRegistrarUser.txtDocumento.setBackground(Color.green);
                    panelRegistrarUser.txtDireccion.setBackground(Color.green);
                    panelRegistrarUser.txtContraseña.setBackground(Color.green);
                    JOptionPane.showMessageDialog(null, "Registro exitoso.");
                    panelRegistrarUser.setVisible(false);
                    loginpanel.setVisible(true);
                }  
            } else {
                panelRegistrarUser.txtDocumento.setBackground(Color.red);
                JOptionPane.showMessageDialog(null, "Usuario no disponible");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
        }

    }

}
