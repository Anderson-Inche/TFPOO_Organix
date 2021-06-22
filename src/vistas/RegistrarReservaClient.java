/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import model.Ciudad;
import model.CiudadDAO;
import model.Reserva;
import model.ReservaDAO;
import model.Usuario;
import model.UsuarioDAO;

/**
 *
 * @author ANDERSON
 */
public class RegistrarReservaClient extends javax.swing.JFrame {

    String user;
    ReservaDAO modelReserva = new ReservaDAO();
    public RegistrarReservaClient() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        user = LoginFrame.user;
        lblId.setText(modelReserva.idIncrementable());
        DefaultComboBoxModel modeloCiudad = new DefaultComboBoxModel(modelReserva.mostraCiudad());
        cbxCiudad.setModel(modeloCiudad);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ButtonRegistrar = new javax.swing.JButton();
        lblId = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbxCiudad = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jdcFechaReserva = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(33, 45, 62));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTRAR RESERVA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(205, 205, 205)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel2.setText("Código");

        ButtonRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons/boton_registrar.png"))); // NOI18N
        ButtonRegistrar.setBorderPainted(false);
        ButtonRegistrar.setContentAreaFilled(false);
        ButtonRegistrar.setFocusPainted(false);
        ButtonRegistrar.setFocusable(false);
        ButtonRegistrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons/botonPress_registrar.png"))); // NOI18N
        ButtonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRegistrarActionPerformed(evt);
            }
        });

        lblId.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel6.setText("Ciudad:");

        cbxCiudad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCiudadActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel7.setText("Fecha de reserva:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(64, 64, 64)
                                .addComponent(jdcFechaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6))
                                .addGap(129, 129, 129)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(ButtonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdcFechaReserva, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(ButtonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCiudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxCiudadActionPerformed

    private void ButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRegistrarActionPerformed
        
        int Id = Integer.parseInt(lblId.getText());
        int validar = 0;
        if (cbxCiudad.getSelectedItem().toString().equals("Seleccione una Ciudad")) {
            cbxCiudad.setBackground(Color.red);
            validar++;
        }
        if (jdcFechaReserva.equals("")) {
            jdcFechaReserva.setBackground(Color.red);
            validar++;
        }
        if (validar == 0) {
            String nombreUsuario = user;
            String nombreCiudad = cbxCiudad.getSelectedItem().toString();

            Usuario usuario = new Usuario();
            UsuarioDAO modeloUser = new UsuarioDAO();
            usuario.setIdUsuario(modelReserva.GetIdUsuario(nombreUsuario));
            modeloUser.buscarUser(usuario);

            Ciudad ciudad = new Ciudad();
            ciudad.setIdCiudad(modelReserva.GetIdCiudad(nombreCiudad));
            CiudadDAO modelCiudad = new CiudadDAO();
            modelCiudad.buscarCiudad(ciudad);
            
            
            Date dayReserva = jdcFechaReserva.getDate();
            long dateReserva = dayReserva.getTime();
            java.sql.Date fechaReserv = new java.sql.Date(dateReserva);
            
            String flagAnulado = "No";
            
            String fechaLlegada = new SimpleDateFormat("yyyyy-MM-dd").format(dayReserva);
            String [] f = fechaLlegada.split("-");
            Calendar calendar = Calendar.getInstance();
            calendar.set(Integer.parseInt(f[0]), Integer.parseInt(f[1])-1, Integer.parseInt(f[2]));
            calendar.add(Calendar.DAY_OF_MONTH, 5);
            SimpleDateFormat fe = new SimpleDateFormat("yyyyy-MM-dd");
            String xfechallegada = fe.format(calendar.getTime());
            Date dateLlegada = null;
            try {
                java.util.Date nfechallegada = fe.parse(xfechallegada);
                dateLlegada = new java.sql.Date(nfechallegada.getTime());
            } catch (ParseException ex) {
                Logger.getLogger(RegistrarReservaClient.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            String fechaVencimiento = new SimpleDateFormat("yyyyy-MM-dd").format(dayReserva);
            String [] fec = fechaVencimiento.split("-");
            Calendar calendar2 = Calendar.getInstance();
            calendar2.set(Integer.parseInt(fec[0]), Integer.parseInt(fec[1])-1, Integer.parseInt(fec[2]));
            calendar2.add(Calendar.DAY_OF_MONTH, 30);
            SimpleDateFormat fecha = new SimpleDateFormat("yyyyy-MM-dd");
            String xfechavencimiento = fecha.format(calendar2.getTime());
            Date dateVencimiento = null;
            try {
                java.util.Date nfechavencimiento = fe.parse(xfechavencimiento);
                dateVencimiento = new java.sql.Date(nfechavencimiento.getTime());
            } catch (ParseException ex) {
                Logger.getLogger(RegistrarReservaClient.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            Reserva reserva = new Reserva(Id, ciudad, usuario, fechaReserv, dateLlegada, flagAnulado, dateVencimiento);
            
            if (modelReserva.insertar(reserva)) {
                JOptionPane.showMessageDialog(null, "Registro exitoso. ");
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Reserva ya fue registrado.");
            }
        }
    }//GEN-LAST:event_ButtonRegistrarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegistrarReservaClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarReservaClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarReservaClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarReservaClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarReservaClient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton ButtonRegistrar;
    public javax.swing.JComboBox<String> cbxCiudad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public com.toedter.calendar.JDateChooser jdcFechaReserva;
    public javax.swing.JLabel lblId;
    // End of variables declaration//GEN-END:variables
}
