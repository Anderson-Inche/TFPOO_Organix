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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Conexion;
import model.Usuario;
import vistas.LoginFrame;
import vistas.RegistrarUsuario;

public class ControlUsuario implements ActionListener {

    private Usuario user;
    private RegistrarUsuario panel;
    private LoginFrame login;
    private JPanel panel2;

    public ControlUsuario(RegistrarUsuario panel, JPanel panel2) {
        this.panel = panel;
        this.panel.botonRegistrar.addActionListener(this);
        this.panel2 = panel2;
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        String nombre, apellido, documento, direccion, email, password;
        if (event.getSource() == panel.botonRegistrar) {

            nombre = panel.txtNombre.getText().trim();
            apellido = panel.txtApellido.getText().trim();
            documento = panel.txtDocumento.getText().trim();
            direccion = panel.txtDireccion.getText().trim();
            email = panel.txtCorreo.getText().trim();
            password = panel.txtContraseña.getText().trim();

            Usuario user = new Usuario(WIDTH, nombre, apellido, documento, direccion, email, password, "Cliente");

            int validacion = 0;
            if (user.getEmail().equals("")) {
                panel.txtCorreo.setBackground(Color.red);
                validacion++;
            }
            if (user.getNombre().equals("")) {
                panel.txtNombre.setBackground(Color.red);
                validacion++;
            }
            if (user.getApellido().equals("")) {
                panel.txtApellido.setBackground(Color.red);
                validacion++;
            }
            if (user.getIdDocumento().equals("")) {
                panel.txtDocumento.setBackground(Color.red);
                validacion++;
            }
            if (user.getDireccion().equals("")) {
                panel.txtDireccion.setBackground(Color.red);
                validacion++;
            }
            if (user.getPassword().equals("")) {
                panel.txtContraseña.setBackground(Color.red);
                validacion++;
            }

            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select dni from usuario where dni = '" + user.getIdDocumento() + "'");
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    panel.txtDocumento.setBackground(Color.red);
                    JOptionPane.showMessageDialog(null, "Usuario no disponible");
                    cn.close();
                } else {
                    cn.close();
                    if (validacion == 0) {
                        try {
                            Connection cn2 = Conexion.conectar();
                            PreparedStatement pst2 = cn2.prepareStatement(
                                    "insert  into usuario values (?,?,?,?,?,?,?,?)");
                            pst2.setInt(1, 0);
                            pst2.setString(2, user.getNombre());
                            pst2.setString(3, user.getApellido());
                            pst2.setString(4, user.getIdDocumento());
                            pst2.setString(5, user.getDireccion());
                            pst2.setString(6, user.getEmail());
                            pst2.setString(7, user.getPassword());
                            pst2.setString(8, "Cliente");

                            pst2.executeUpdate();
                            cn2.close();

                            panel.txtCorreo.setBackground(Color.green);
                            panel.txtNombre.setBackground(Color.green);
                            panel.txtApellido.setBackground(Color.green);
                            panel.txtDocumento.setBackground(Color.green);
                            panel.txtDireccion.setBackground(Color.green);
                            panel.txtContraseña.setBackground(Color.green);

                            JOptionPane.showMessageDialog(null, "Registro exitoso.");
                            panel.setVisible(false);
                            panel2.setVisible(true);
                        } catch (SQLException e) {
                            System.err.println("Error al validar usuario " + e);
                            JOptionPane.showMessageDialog(null, "ERROR AL COMPARAR USUARIO, Contactar al Administrador");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
                    }
                }
            } catch (SQLException e) {
                System.err.println("Error al validar usuario " + e);
                JOptionPane.showMessageDialog(null, "ERROR AL COMPARAR USUARIO, Contactar al Administrador");
            }

        }
    }

}
