/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Modelos.LeerArchivo;
import ajedrezia.AjedrezIA;
import Controladores.ControladorInicio;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author Joaquin
 */
public class InicioGUI extends javax.swing.JFrame {

    /**
     * Creates new form InicioGUI
     */
    
    public String jugador;
    
    public InicioGUI() {
        initComponents();
        
        btnGroup.add(opc_Archivo);
        btnGroup.add(opc_Manual);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroup = new javax.swing.ButtonGroup();
        PantallaInicio = new javax.swing.JPanel();
        labelNombre = new javax.swing.JLabel();
        txtjugador = new javax.swing.JTextField();
        opc_Archivo = new javax.swing.JRadioButton();
        opc_Manual = new javax.swing.JRadioButton();
        btnIngresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PantallaInicio.setBackground(new java.awt.Color(255, 255, 255));
        PantallaInicio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        labelNombre.setText("INGRESE SU NOMBRE: ");

        opc_Archivo.setText("Cargar desde Archivo");

        opc_Manual.setText("Cargar Manualmente");

        btnIngresar.setText("INGRESAR");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PantallaInicioLayout = new javax.swing.GroupLayout(PantallaInicio);
        PantallaInicio.setLayout(PantallaInicioLayout);
        PantallaInicioLayout.setHorizontalGroup(
            PantallaInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PantallaInicioLayout.createSequentialGroup()
                .addGroup(PantallaInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PantallaInicioLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(PantallaInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PantallaInicioLayout.createSequentialGroup()
                                .addComponent(opc_Archivo)
                                .addGap(18, 18, 18)
                                .addComponent(opc_Manual))
                            .addGroup(PantallaInicioLayout.createSequentialGroup()
                                .addComponent(labelNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtjugador, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(PantallaInicioLayout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(btnIngresar)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        PantallaInicioLayout.setVerticalGroup(
            PantallaInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PantallaInicioLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(PantallaInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombre)
                    .addComponent(txtjugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PantallaInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(opc_Archivo)
                    .addComponent(opc_Manual))
                .addGap(37, 37, 37)
                .addComponent(btnIngresar)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PantallaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PantallaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        // TODO add your handling code here:
        jugador = txtjugador.getText();
        if(!"".equals(jugador)){
            if(opc_Archivo.isSelected()){
                
                File selectedFile = null;
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File("./src/Files"));
                int result = fileChooser.showOpenDialog(this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    selectedFile = fileChooser.getSelectedFile();
                    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                }
                ArrayList<String> comandos = new ArrayList<>();
                LeerArchivo read = new LeerArchivo();
                try {
                    comandos = read.readFile(selectedFile.getAbsolutePath());
                } catch (IOException ex) {
                    Logger.getLogger(AjedrezIA.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                ControladorInicio.CargarArchivo(jugador,comandos);
            }
            else if(opc_Manual.isSelected()){
                ControladorInicio.CargarManual(jugador);
            }
            else{
                System.out.println("Seleccione el modo de Inicio Juego");
            }
        }
        else{
            System.out.println("Debe ingresar el nombre del Jugador");
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

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
            java.util.logging.Logger.getLogger(InicioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicioGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PantallaInicio;
    private javax.swing.ButtonGroup btnGroup;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JRadioButton opc_Archivo;
    private javax.swing.JRadioButton opc_Manual;
    private javax.swing.JTextField txtjugador;
    // End of variables declaration//GEN-END:variables
}