/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import funcionalidades.*;
import java.awt.*;
import javax.swing.*;


/**
 *
 * @author chejohrpp
 */
public class DiseñoCaminoTab extends javax.swing.JFrame {
    public final int ESPACIO_PIXELES = 126;
    public final int ESPACIO_INTERMEDIO = 2;
    public final int ESPACIO_JFRAME_LARGO = 17;
    public final int ESPACIO_JFRAME_ALTO = 85;
    private int alto;
    private int largo;
    
    private GenerarMatrizTab[][] posicionBoton;
    private Tablero[] tablero;
    private JuegoBoard juegoC;
    DiseñoCaminoTab diseñoCaminotab;
    private TableroGUI tableroGui;
    

    /**
     * Creates new form DiseñoCaminoTab
     * @param alto
     * @param largo
     */
    public DiseñoCaminoTab(int alto, int largo, JuegoBoard juegoC) {        
        this.alto = alto;
        this.largo = largo;
        initComponents();
        this.setSize(largo*ESPACIO_PIXELES + ESPACIO_INTERMEDIO*largo +ESPACIO_JFRAME_LARGO, alto*ESPACIO_PIXELES + ESPACIO_INTERMEDIO*alto+ESPACIO_JFRAME_ALTO);      
        panel.setSize(largo*ESPACIO_PIXELES + ESPACIO_INTERMEDIO*largo, alto*ESPACIO_PIXELES + ESPACIO_INTERMEDIO*alto);        
        this.juegoC = juegoC;
        tablero = juegoC.getTablero();        
        this.tableroGui = new TableroGUI(tablero);
        cargarDatos(juegoC);
    }
//    public DiseñoCaminoTab(){        
//    }
    private void Generar(Container pane){     
        posicionBoton = new GenerarMatrizTab[largo][alto];        
        for (int i = 0; i < largo; i++) {            
            for (int j = 0; j < alto; j++) {
                GenerarMatrizTab generarMatriz = new GenerarMatrizTab(tablero,tableroGui);                
                pane.add(generarMatriz.getBoton());
                generarMatriz.getFormat(i,j);
                posicionBoton[i][j] = generarMatriz;                
            }
        }
    }
    private void generarDatos(Container pane){
        for (int i = 0; i < largo; i++) {            
            for (int j = 0; j < alto; j++) {
                GenerarMatrizTab generarMatriz = new GenerarMatrizTab(tablero,tableroGui);                
                pane.add(generarMatriz.getBoton());
                generarMatriz.getFormat(i,j);
                for (int k = 0; k < tablero.length; k++) {
                    if (tablero[k].getBoton().getX() == generarMatriz.getBoton().getX() && tablero[k].getBoton().getY() == generarMatriz.getBoton().getY()) {
                        pane.remove(generarMatriz.getBoton());
                        pane.revalidate();
                        pane.repaint();
                        generarMatriz.setButton(tablero[k].getBoton());
                        pane.add(generarMatriz.getBoton());                        
                    }
                }
            }            
        }
    }
//    public void redimesionarCantCasillas(int cantCasillas){
//        for (int i = 0; i < largo; i++) {            
//            for (int j = 0; j < alto; j++) {                
//                posicionBoton[i][j].setCantCasillas(cantCasillas);                
//                
//            }            
//        }
//    }
//    public void setDiseñoCaminoTab(DiseñoCaminoTab diseñoCaminoTab){
//        this.diseñoCaminotab = diseñoCaminoTab;
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSave = new javax.swing.JButton();
        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnPrevisualizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 614, Short.MAX_VALUE)
        );

        jLabel1.setText("Nota: Solo se puede tener una casilla de inicio");

        btnPrevisualizar.setText("Previsualizar");
        btnPrevisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevisualizarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 483, Short.MAX_VALUE)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPrevisualizar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(jLabel1)
                    .addComponent(btnPrevisualizar)
                    .addComponent(btnCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        int aceptar = JOptionPane.showConfirmDialog(null, "Esta Seguro que desea guradar el tablero");
        if (aceptar == JOptionPane.YES_OPTION && verificarInicio()) {          
            posicionInicio(tableroGui.getTablero());         
            juegoC.setTablero(tableroGui.getTablero());
            juegoC.setAltoLargo(largo, alto);
            this.setVisible(false);      
            JOptionPane.showMessageDialog(null,"Tablero Guardado correctamente");
           //MenuCrear menu = new MenuCrear();
           //menu.setLocationRelativeTo(null);
           //menu.setVisible(true);
           //menu.setEnablebtnTablero(false);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnPrevisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevisualizarActionPerformed
        // TODO add your handling code here:
        
        if (tableroGui.getTablero() == null) {
            JOptionPane.showMessageDialog(null, "No hay casillas en el tablero");
        } else{          
            tableroGui.setLocationRelativeTo(null);
            tableroGui.setSizeJ(this.getSize(), panel.getSize());
            tableroGui.setVisible(true);
        }
        
    }//GEN-LAST:event_btnPrevisualizarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    public boolean verificarInicio(){
        int cantInicio = 0;
        for (Tablero tablero : tableroGui.getTablero()) {
            if (tablero.getBoton().getText().equalsIgnoreCase("Inicio")) {
                cantInicio++;
            }
        }
        if (cantInicio == 0) {
            JOptionPane.showMessageDialog(null, "NO hay una casilla inicio, ingrese solo una");
            return false;
        } else if (cantInicio > 1) {
            JOptionPane.showMessageDialog(null, "hay mas de una casilla inicio, vuelva a editar el tablero");
            return false;
        }
        return true;
    }
    private void posicionInicio(Tablero[] tablero){
        if (tablero[0].getBoton().getText().equalsIgnoreCase("Inicio")) {
            } else{
                for (int i = 1; i < tablero.length; i++) {
                    if (tablero[i].getBoton().getText().equalsIgnoreCase("Inicio")) {
                        Tablero aux = tablero[i];
                        tablero[i] = tablero[0];
                        tablero[0] = aux;
                        
                        tablero[0].setPosicion(1);
                        tablero[i].setPosicion(i+1);
                        
                        tablero[0].setPosicionTablero(tablero[0].getBoton());
                        tablero[i].setPosicionTablero(tablero[i].getBoton());
                    }
            }
        }
    }
    private boolean leerContenido(JuegoBoard juegoC){
        return (juegoC.getTablero() != null);        
    }
    private void cargarDatos(JuegoBoard juegoC){
        if (leerContenido(juegoC)) {
            generarDatos(panel);
        } else{
            Generar(panel);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnPrevisualizar;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
