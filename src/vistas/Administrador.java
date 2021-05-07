/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import javax.swing.WindowConstants;

/**
 *
 * @author ANDERSON
 */
public class Administrador extends javax.swing.JFrame {
    
    String user, nombre_usuario;
    public static int sesion_usuario;
  

    /**
     * Creates new form Administrador
     */
    public Administrador() {
        initComponents();

        user = LoginFrame.user;
        sesion_usuario = 1;
        //no modifica el tamaño de la ventana
        setResizable(false);
        //asigna titulo
        setTitle("Administrador - Sesión de "+ user );
        //centrar la pantalla en el medio
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ButtonUsuario = new javax.swing.JButton();
        ButtonProductos = new javax.swing.JButton();
        ButtonReserva = new javax.swing.JButton();
        ButtonFactura = new javax.swing.JButton();
        ButtonPais = new javax.swing.JButton();
        ButtonCiudad = new javax.swing.JButton();
        PanelHeader = new javax.swing.JPanel();
        lbTitulo = new javax.swing.JLabel();
        PanelMain = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(108, 188, 172));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel1.setText("ADMINISTRADOR");

        ButtonUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons/Boton-bar-Usuarios.png"))); // NOI18N
        ButtonUsuario.setContentAreaFilled(false);
        ButtonUsuario.setFocusPainted(false);
        ButtonUsuario.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons/BotonPress-bar-usuarios.png"))); // NOI18N
        ButtonUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonUsuarioActionPerformed(evt);
            }
        });

        ButtonProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons/Boton-bar-Productos.png"))); // NOI18N
        ButtonProductos.setContentAreaFilled(false);
        ButtonProductos.setFocusPainted(false);
        ButtonProductos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons/BotonPress-bar-productos.png"))); // NOI18N
        ButtonProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonProductosActionPerformed(evt);
            }
        });

        ButtonReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons/Boton-bar-reservas.png"))); // NOI18N
        ButtonReserva.setContentAreaFilled(false);
        ButtonReserva.setFocusPainted(false);
        ButtonReserva.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons/BotonPress-bar-reservas.png"))); // NOI18N
        ButtonReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonReservaActionPerformed(evt);
            }
        });

        ButtonFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons/Boton-bar-facturas.png"))); // NOI18N
        ButtonFactura.setContentAreaFilled(false);
        ButtonFactura.setFocusPainted(false);
        ButtonFactura.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons/BotonPress-bar-facturas.png"))); // NOI18N
        ButtonFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonFacturaActionPerformed(evt);
            }
        });

        ButtonPais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons/Boton-bar-paises.png"))); // NOI18N
        ButtonPais.setBorder(null);
        ButtonPais.setContentAreaFilled(false);
        ButtonPais.setFocusPainted(false);
        ButtonPais.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons/BotonPress-bar-paises.png"))); // NOI18N
        ButtonPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonPaisActionPerformed(evt);
            }
        });

        ButtonCiudad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons/Boton-bar-ciudades.png"))); // NOI18N
        ButtonCiudad.setContentAreaFilled(false);
        ButtonCiudad.setFocusPainted(false);
        ButtonCiudad.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons/BotonPress-bar-ciudades.png"))); // NOI18N
        ButtonCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCiudadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(ButtonReserva, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(ButtonFactura, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(ButtonProductos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(ButtonUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(ButtonPais, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ButtonCiudad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(183, 183, 183)
                .addComponent(ButtonPais, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButtonCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButtonUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButtonProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButtonReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButtonFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(247, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 910));

        PanelHeader.setBackground(new java.awt.Color(33, 45, 62));

        lbTitulo.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lbTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lbTitulo.setText("Principal");

        javax.swing.GroupLayout PanelHeaderLayout = new javax.swing.GroupLayout(PanelHeader);
        PanelHeader.setLayout(PanelHeaderLayout);
        PanelHeaderLayout.setHorizontalGroup(
            PanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHeaderLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(lbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1038, Short.MAX_VALUE))
        );
        PanelHeaderLayout.setVerticalGroup(
            PanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHeaderLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        getContentPane().add(PanelHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 1320, -1));

        PanelMain.setLayout(new java.awt.BorderLayout());
        getContentPane().add(PanelMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 1320, 810));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonPaisActionPerformed
       
        lbTitulo.setText("Países");
        PanelPais panelpais= new PanelPais();
        PanelMain.add(panelpais);
        
    }//GEN-LAST:event_ButtonPaisActionPerformed

    private void ButtonCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCiudadActionPerformed
        // TODO add your handling code here:
        lbTitulo.setText("Ciudades");
    }//GEN-LAST:event_ButtonCiudadActionPerformed

    private void ButtonUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonUsuarioActionPerformed
        // TODO add your handling code here:
        lbTitulo.setText("Usuarios");
    }//GEN-LAST:event_ButtonUsuarioActionPerformed

    private void ButtonProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonProductosActionPerformed
        // TODO add your handling code here:
        lbTitulo.setText("Productos");
    }//GEN-LAST:event_ButtonProductosActionPerformed

    private void ButtonReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonReservaActionPerformed
        // TODO add your handling code here:
        lbTitulo.setText("Reservas");
    }//GEN-LAST:event_ButtonReservaActionPerformed

    private void ButtonFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonFacturaActionPerformed
        // TODO add your handling code here:
        lbTitulo.setText("Facturas");
    }//GEN-LAST:event_ButtonFacturaActionPerformed

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
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonCiudad;
    private javax.swing.JButton ButtonFactura;
    private javax.swing.JButton ButtonPais;
    private javax.swing.JButton ButtonProductos;
    private javax.swing.JButton ButtonReserva;
    private javax.swing.JButton ButtonUsuario;
    private javax.swing.JPanel PanelHeader;
    private javax.swing.JPanel PanelMain;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbTitulo;
    // End of variables declaration//GEN-END:variables
}
