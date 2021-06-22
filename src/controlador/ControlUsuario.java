package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Usuario;
import model.UsuarioDAO;
import vistas.BuscarUsuario;
import vistas.ModificarUsuario;
import vistas.RegistrarUsuario;
import vistas.RegistrarUsuarioAdmin;

public class ControlUsuario implements ActionListener {

    UsuarioDAO modeloUsuario = new UsuarioDAO();
    RegistrarUsuario panelRegistrarUser = new RegistrarUsuario();
    RegistrarUsuarioAdmin registrarUsuarioAdminFrm = new RegistrarUsuarioAdmin();
    BuscarUsuario buscarUsuario = new BuscarUsuario();
    ModificarUsuario modificarUsuario = new ModificarUsuario();
    JPanel loginpanel = new JPanel();

    public ControlUsuario(RegistrarUsuario panelRegistrarUser, JPanel loginpanel) {
        this.panelRegistrarUser = panelRegistrarUser;
        this.loginpanel = loginpanel;
        this.panelRegistrarUser.botonRegistrar.addActionListener(this);
    }

    public ControlUsuario(RegistrarUsuarioAdmin registrarUsuarioAdminFrm) {
        this.registrarUsuarioAdminFrm = registrarUsuarioAdminFrm;
        this.registrarUsuarioAdminFrm.ButtonRegistrar.addActionListener(this);
    }

    public ControlUsuario(BuscarUsuario buscarUsuario) {
        this.buscarUsuario = buscarUsuario;
        this.buscarUsuario.buttonModificar.addActionListener(this);
        this.buscarUsuario.buttonEliminar.addActionListener(this);
    }

    public ControlUsuario(ModificarUsuario modificarUsuario) {
        this.modificarUsuario = modificarUsuario;
        this.modificarUsuario.ButtonModificar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        String nombre, apellido, documento, direccion, email, password;
        if (event.getSource() == panelRegistrarUser.botonRegistrar) {

            String nombreUsuario = panelRegistrarUser.txtNombreUsuario.getText().trim();
            nombre = panelRegistrarUser.txtNombre.getText().trim();
            apellido = panelRegistrarUser.txtApellido.getText().trim();
            documento = panelRegistrarUser.txtDocumento.getText().trim();
            direccion = panelRegistrarUser.txtDireccion.getText().trim();
            email = panelRegistrarUser.txtCorreo.getText().trim();
            password = panelRegistrarUser.txtContraseña.getText().trim();

            Usuario user = new Usuario(WIDTH, nombreUsuario, nombre, apellido, documento, direccion, email, password, "Cliente");
            int validacion = 0;
            if (user.getNombreUsuario().equals("")) {
                panelRegistrarUser.txtNombreUsuario.setBackground(Color.red);
                validacion++;
            }
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
                if (modeloUsuario.verificarUser(user.getNombreUsuario())) {

                    if (modeloUsuario.insertarUser(user)) {
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
            } else {
                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
            }
        }
        if (event.getSource() == registrarUsuarioAdminFrm.ButtonRegistrar) {

            int validacion = 0;
            if (registrarUsuarioAdminFrm.lblId.getText().equals("")) {
                registrarUsuarioAdminFrm.txtCorreo.setBackground(Color.red);
                validacion++;
            }
            if (registrarUsuarioAdminFrm.txtNombre.getText().equals("")) {
                registrarUsuarioAdminFrm.txtNombre.setBackground(Color.red);
                validacion++;
            }
            if (registrarUsuarioAdminFrm.txtApellido.getText().equals("")) {
                registrarUsuarioAdminFrm.txtApellido.setBackground(Color.red);
                validacion++;
            }
            if (registrarUsuarioAdminFrm.txtDocumento.getText().equals("")) {
                registrarUsuarioAdminFrm.txtDocumento.setBackground(Color.red);
                validacion++;
            }
            if (registrarUsuarioAdminFrm.txtDireccion.getText().equals("")) {
                registrarUsuarioAdminFrm.txtDireccion.setBackground(Color.red);
                validacion++;
            }
            if (registrarUsuarioAdminFrm.txtCorreo.equals("")) {
                registrarUsuarioAdminFrm.txtContraseña.setBackground(Color.red);
                validacion++;
            }
            if (registrarUsuarioAdminFrm.txtContraseña.equals("")) {
                registrarUsuarioAdminFrm.txtContraseña.setBackground(Color.red);
                validacion++;
            }
            int id = Integer.parseInt(registrarUsuarioAdminFrm.lblId.getText().trim());
            nombre = registrarUsuarioAdminFrm.txtNombre.getText().trim();
            apellido = registrarUsuarioAdminFrm.txtApellido.getText().trim();
            documento = registrarUsuarioAdminFrm.txtDocumento.getText().trim();
            direccion = registrarUsuarioAdminFrm.txtDireccion.getText().trim();
            email = registrarUsuarioAdminFrm.txtCorreo.getText().trim();
            password = registrarUsuarioAdminFrm.txtContraseña.getText().trim();
            String permiso = registrarUsuarioAdminFrm.cbxPermiso.getSelectedItem().toString();
            String nombreUsuario = registrarUsuarioAdminFrm.txtNombreUsuario.getText().trim();

            Usuario user = new Usuario(id, nombreUsuario, nombre, apellido, documento, direccion, email, password, permiso);

            if (validacion == 0) {
                if (modeloUsuario.verificarUser( user.getNombreUsuario())) {

                    if (modeloUsuario.insertarUser(user)) {
                        registrarUsuarioAdminFrm.txtNombreUsuario.setBackground(Color.green);
                        registrarUsuarioAdminFrm.txtCorreo.setBackground(Color.green);
                        registrarUsuarioAdminFrm.txtNombre.setBackground(Color.green);
                        registrarUsuarioAdminFrm.txtApellido.setBackground(Color.green);
                        registrarUsuarioAdminFrm.txtDocumento.setBackground(Color.green);
                        registrarUsuarioAdminFrm.txtDireccion.setBackground(Color.green);
                        registrarUsuarioAdminFrm.txtContraseña.setBackground(Color.green);
                        JOptionPane.showMessageDialog(null, "Registro exitoso.");
                        registrarUsuarioAdminFrm.dispose();
                    }
                } else {
                    panelRegistrarUser.txtDocumento.setBackground(Color.red);
                    JOptionPane.showMessageDialog(null, "Usuario no disponible");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
            }
        }
        if (event.getSource() == buscarUsuario.buttonEliminar) {
            int idEliminar = Integer.parseInt(buscarUsuario.lbId.getText());
            Usuario usuario = new Usuario();
            usuario.setIdUsuario(idEliminar);
            if (modeloUsuario.eliminarUser(usuario)) {
                JOptionPane.showMessageDialog(null, "Usuario eliminado satisfactoriamente.");
                buscarUsuario.setVisible(false);
                buscarUsuario.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Usuario no se pudó eliminar");
            }
        }
        if (event.getSource() == modificarUsuario.ButtonModificar) {
            int validacion = 0;

            if (modificarUsuario.txtNombreUsuario.getText().equals("")) {
                modificarUsuario.txtNombreUsuario.setBackground(Color.red);
                validacion++;
            }
            if (modificarUsuario.txtApellido.getText().equals("")) {
                modificarUsuario.txtApellido.setBackground(Color.red);
                validacion++;
            }
            if (modificarUsuario.txtDocumento.getText().equals("")) {
                modificarUsuario.txtDocumento.setBackground(Color.red);
                validacion++;
            }
            if (modificarUsuario.txtDireccion.getText().equals("")) {
                modificarUsuario.txtDireccion.setBackground(Color.red);
                validacion++;
            }
            if (modificarUsuario.txtCorreo.getText().equals("")) {
                modificarUsuario.txtContraseña.setBackground(Color.red);
                validacion++;
            }
            if (modificarUsuario.txtContraseña.getText().equals("")) {
                modificarUsuario.txtContraseña.setBackground(Color.red);
                validacion++;
            }
            if (modificarUsuario.cbxPermiso.getSelectedItem().toString().equals("Seleccione un permiso")) {
                modificarUsuario.cbxPermiso.setBackground(Color.red);
                validacion++;
            }
            if (validacion == 0) {
                int id = Integer.parseInt(modificarUsuario.labelCodigo.getText().trim());
                nombre = modificarUsuario.txtNombre1.getText().trim();
                apellido = modificarUsuario.txtApellido.getText().trim();
                documento = modificarUsuario.txtDocumento.getText().trim();
                direccion = modificarUsuario.txtDireccion.getText().trim();
                email = modificarUsuario.txtCorreo.getText().trim();
                password = modificarUsuario.txtContraseña.getText().trim();
                String permiso = modificarUsuario.cbxPermiso.getSelectedItem().toString();
                String nombreUsuario = modificarUsuario.txtNombreUsuario.getText().trim();
                Usuario user = new Usuario(id, nombreUsuario, nombre, apellido, documento, direccion, email, password, permiso);
//                if (modeloUsuario.verificarUser( nombreUsuario)) {
                    if (modeloUsuario.modificarUser(user)) {
                        JOptionPane.showMessageDialog(null, "Usuario Modificado");
                        modificarUsuario.dispose();
                    }
//                }else
//                    JOptionPane.showMessageDialog(null, "Nombre de Usuario ya existe");
            }
        }

    }
}
