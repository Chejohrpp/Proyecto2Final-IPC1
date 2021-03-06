/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import Excepciones.Exceptions;
import LecturaYEscritura.RnWCrearJuego;
import LecturaYEscritura.RnWJugar;
import funcionalidades.JuegoBoard;
import funcionalidades.JuegoGame;
import java.awt.HeadlessException;
import javax.swing.JFileChooser;
import static javax.swing.JFileChooser.APPROVE_OPTION;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author chejohrpp
 */
public class VisualTerminarJuego extends javax.swing.JFrame {
    JuegoGame juegoG = new JuegoGame();
    JuegoBoard juegoC = new JuegoBoard();
    /**
     * Creates new form VisualTerminarJuego
     */
    public VisualTerminarJuego(String ganador) {
        initComponents();
        lblGanador.setText("Felicidades "+ ganador + " Has ganado");
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblGanador = new javax.swing.JLabel();
        btnJugarNuevo = new javax.swing.JButton();
        btnOtroJuego = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblGanador.setFont(new java.awt.Font("Ubuntu", 0, 36)); // NOI18N
        lblGanador.setText("Felicidades Jugador ha ganado");

        btnJugarNuevo.setText("Jugar de Nuevo");
        btnJugarNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugarNuevoActionPerformed(evt);
            }
        });

        btnOtroJuego.setText("Escoger otro juego");
        btnOtroJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtroJuegoActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(lblGanador))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnOtroJuego)
                            .addComponent(btnJugarNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(lblGanador)
                .addGap(62, 62, 62)
                .addComponent(btnJugarNuevo)
                .addGap(56, 56, 56)
                .addComponent(btnOtroJuego)
                .addGap(54, 54, 54)
                .addComponent(btnSalir)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOtroJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtroJuegoActionPerformed
        // TODO add your handling code here:
        
        try {
            RnWCrearJuego readGameC = new RnWCrearJuego();            
            JFileChooser fileChooser = new JFileChooser();            
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Archivo del juego", "board"));
            fileChooser.setAcceptAllFileFilterUsed(false);
            int seleccion = fileChooser.showOpenDialog(this);
            
            if (seleccion == APPROVE_OPTION) {
                System.out.println("Path: " + fileChooser.getSelectedFile().getPath());               
                juegoC = readGameC.ReadGameC(fileChooser.getSelectedFile().getPath());               
                PrePartida partida = new PrePartida(juegoC, juegoG);                
                this.setVisible(false);
                partida.setLocationRelativeTo(null);
                partida.setVisible(true);
            } 
        } catch (HeadlessException | Exceptions e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Info", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnOtroJuegoActionPerformed

    private void btnJugarNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugarNuevoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnJugarNuevoActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Welcome welcome = new Welcome();
        welcome.setLocationRelativeTo(null);
        welcome.setVisible(true);
    }//GEN-LAST:event_btnSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnJugarNuevo;
    private javax.swing.JButton btnOtroJuego;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel lblGanador;
    // End of variables declaration//GEN-END:variables
}
