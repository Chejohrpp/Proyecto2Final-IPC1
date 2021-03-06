/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import Excepciones.Exceptions;
import LecturaYEscritura.RnWCrearJuego;
import LecturaYEscritura.RnWRanking;
import funcionalidades.*;
import java.awt.Color;
import java.awt.HeadlessException;
import javax.swing.JFileChooser;
import static javax.swing.JFileChooser.APPROVE_OPTION;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author chejohrpp
 */
public class Welcome extends javax.swing.JFrame {
    public static AllPlayers allPlayers = new AllPlayers();
    JuegoBoard juegoC;
    RnWCrearJuego readGameC = new RnWCrearJuego();
    
    /**
     * Creates new form Start
     */
    public Welcome() {
        initComponents();
        juegoC = new JuegoBoard();
        leerTodosJugadores();
        
    }
    public void leerTodosJugadores(){
        RnWRanking leerRanking = new RnWRanking();
        try{
            allPlayers = leerRanking.ReadRanking("Ranking.rkg");
        }catch(Exception e){
            allPlayers = new AllPlayers();
            //System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        btnCrear = new javax.swing.JButton();
        btnAcercaDe = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnRank = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnPlay = new javax.swing.JButton();

        jScrollPane1.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("VirtualGame ");
        setAutoRequestFocus(false);
        setFocusable(false);
        setMaximizedBounds(new java.awt.Rectangle(960, 666, 666, 666));
        setMaximumSize(new java.awt.Dimension(666, 666));
        setMinimumSize(new java.awt.Dimension(543, 645));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });
        getContentPane().add(btnCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 160, 50));

        btnAcercaDe.setText("Acerca de");
        btnAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcercaDeActionPerformed(evt);
            }
        });
        getContentPane().add(btnAcercaDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 510, 160, 50));

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 50)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(246, 242, 242));
        jLabel2.setText("Creador Virtual Games");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 530, 120));

        btnRank.setText("Ranking");
        btnRank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRankActionPerformed(evt);
            }
        });
        getContentPane().add(btnRank, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 430, 160, 50));

        btnEdit.setText("Editar");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        getContentPane().add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 160, 50));

        btnPlay.setText("Jugar");
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });
        getContentPane().add(btnPlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 160, 50));

        getAccessibleContext().setAccessibleName("VirtualGame");
        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        //vamos a la clase MenuCrear para empezar a diseñar el tablero
        MenuCrear diseñoTablero = new MenuCrear();
        this.setVisible(false);
        diseñoTablero.setLocationRelativeTo(null);
        diseñoTablero.setVisible(true);
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcercaDeActionPerformed
        //va a ver lo detalle del juego
        JFAcercaDe acercaDe = new JFAcercaDe();
        this.setVisible(false);
        acercaDe.setLocationRelativeTo(null);
        acercaDe.setVisible(true);
    }//GEN-LAST:event_btnAcercaDeActionPerformed

    private void btnRankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRankActionPerformed
        // TODO add your handling code here:
        //para ir a ver el ranking de los jugadores
        if (allPlayers != null) {
            DiseñoRanking diseñoRanking = new DiseñoRanking(allPlayers);
            diseñoRanking.setLocationRelativeTo(null);
            diseñoRanking.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "No hay jugadores", "Sin Jugadores", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_btnRankActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        //buscamos un archivo .board y lo enviamos a edicion en MenuCrear
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Archivo del juego", "board"));
            fileChooser.setAcceptAllFileFilterUsed(false);
            int seleccion = fileChooser.showOpenDialog(this);
            
            if (seleccion == APPROVE_OPTION) {
                System.out.println("Path: " + fileChooser.getSelectedFile().getPath());
                
                juegoC = readGameC.ReadGameC(fileChooser.getSelectedFile().getPath());
                
                MenuCrear diseñoTablero = new MenuCrear(juegoC);
                this.setVisible(false);
                diseñoTablero.setLocationRelativeTo(null);
                diseñoTablero.setVisible(true);
            } 
        } catch (HeadlessException | Exceptions e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Info", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        // TODO add your handling code here:
        //Nos envia a ver si queremos crear una paritda nueva o cargar una ya existente
        DiseñoJugar jugar = new DiseñoJugar();
        this.setVisible(false);
        jugar.setLocationRelativeTo(null);
        jugar.setVisible(true);
    }//GEN-LAST:event_btnPlayActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcercaDe;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnPlay;
    private javax.swing.JButton btnRank;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
