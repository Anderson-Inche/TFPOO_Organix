/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controlador.ControlPais;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.JOptionPane;
import model.Conexion;
import model.Pais;
import model.PaisDAO;

/**
 *
 * @author ANDERSON
 */
public class PanelPais extends javax.swing.JPanel {

    /**
     * Creates new form PanelPais
     */
    public PanelPais() {
        initComponents();
        MostrarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButtonRegistrar = new javax.swing.JButton();
        buttonBuscar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePaises = new javax.swing.JTable();
        actualizar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        ButtonRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons/Boton_Agregar1.png"))); // NOI18N
        ButtonRegistrar.setBorderPainted(false);
        ButtonRegistrar.setContentAreaFilled(false);
        ButtonRegistrar.setFocusPainted(false);
        ButtonRegistrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons/Boton_Agregar.png"))); // NOI18N
        ButtonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRegistrarActionPerformed(evt);
            }
        });

        buttonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons/search-icon.png"))); // NOI18N
        buttonBuscar.setBorderPainted(false);
        buttonBuscar.setContentAreaFilled(false);
        buttonBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        buttonBuscar.setFocusPainted(false);
        buttonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBuscarActionPerformed(evt);
            }
        });

        txtBuscar.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtBuscar.setBorder(null);
        txtBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        jTablePaises.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "C??DIGO", "NOMBRE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTablePaises);

        actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons/updated.png"))); // NOI18N
        actualizar.setBorderPainted(false);
        actualizar.setContentAreaFilled(false);
        actualizar.setFocusPainted(false);
        actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(ButtonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 727, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1))
                .addGap(90, 90, 90))
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1091, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRegistrarActionPerformed
        // TODO add your handling code here:
        RegistrarPais registrarPais = new RegistrarPais();
        registrarPais.setVisible(true);
        ControlPais controlPais = new ControlPais(registrarPais);

    }//GEN-LAST:event_ButtonRegistrarActionPerformed

    private void buttonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBuscarActionPerformed
        // TODO add your handling code here:
       BuscarPais();
    }//GEN-LAST:event_buttonBuscarActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtBuscarKeyPressed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            BuscarPais();
        }

    }//GEN-LAST:event_txtBuscarKeyReleased

    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed
        MostrarTabla();  
    }//GEN-LAST:event_actualizarActionPerformed
    public void BuscarPais(){
        int validacion = 0;
            PaisDAO modeloPais = new PaisDAO();
            if (txtBuscar.getText().equals("")) {
                txtBuscar.setBackground(Color.red);
                validacion++;
            }
            if (validacion == 0) {
                int codPaisBuscar = Integer.parseInt(txtBuscar.getText());
                Pais pais = new Pais(codPaisBuscar, "");
                if (modeloPais.buscarPais(pais)) {
                    BuscarPais buscaPais = new BuscarPais();
                    buscaPais.setVisible(true);
                    buscaPais.lableCodigo.setText(String.valueOf(pais.getIdPais()));
                    buscaPais.labelNombre.setText(pais.getNombrePais());
                    ControlPais controlPais = new ControlPais(buscaPais);
                } else {
                    JOptionPane.showMessageDialog(null, "Pa??s no registrado");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe ingresar el Id del pa??s a buscar");
            }
    }
    void MostrarTabla(){
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            jTablePaises.setModel(modelo);
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT idPais, namePais FROM pais");

            ResultSet result = pst.executeQuery();

            ResultSetMetaData rsMd = result.getMetaData();
            int cantidadColumns = rsMd.getColumnCount();

            modelo.addColumn("C??DIGO");
            modelo.addColumn("NOMBRE");
            while (result.next()) {
                Object[] filas = new Object[cantidadColumns];
                for (int i = 0; i < cantidadColumns; i++) {
                    filas[i] = result.getObject(i + 1);
                }
                modelo.addRow(filas);
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonRegistrar;
    private javax.swing.JButton actualizar;
    public javax.swing.JButton buttonBuscar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTablePaises;
    public javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
