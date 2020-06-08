/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import Casillas.*;
import funcionalidades.*;
import javax.swing.ButtonModel;
import javax.swing.JButton;

/**
 *
 * @author chejohrpp
 */
public class OpcionCasila extends javax.swing.JFrame {
    
    private JButton boton;
    private Tablero[] tablero;
     
    TableroGUI tableroGui;
    private String tipo;
    
    
    
    //private boolean agregoCasilla;
    //private int posicionCasilla;
    
    /**
     * Creates new form OpcionCasila
     */
    public OpcionCasila(JButton boton, Tablero[] tablero,TableroGUI tableroGui) {
        initComponents();        
        this.boton = boton;
        this.tablero = tablero;
        //this.tableroGui = new TableroGUI(tablero);
        this.tableroGui = tableroGui;
    }
    
    public void setBoton(JButton boton){
        this.boton = boton;
    }

//    public void setCantCasillas( int cantCasillas, DiseñoCaminoTab diseñoCaminoTab){
//        this.contCasilla = cantCasillas; 
//        this.diseñoCaminoTab = diseñoCaminoTab;
//    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnTrampa = new javax.swing.JButton();
        btnInicio = new javax.swing.JButton();
        btnNeutral = new javax.swing.JButton();
        btnTomaTarjeta = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnPropiedad = new javax.swing.JButton();
        btnCarcel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel1.setText("¿Que desea hacer con este espacio?");

        btnTrampa.setText("Casilla Trampa");
        btnTrampa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrampaActionPerformed(evt);
            }
        });

        btnInicio.setText("Casilla de Inicio");
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });

        btnNeutral.setText("Casilla Neutral");
        btnNeutral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNeutralActionPerformed(evt);
            }
        });

        btnTomaTarjeta.setText("Casilla de toma tarjeta");
        btnTomaTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTomaTarjetaActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnPropiedad.setText("Casilla de Propiedad");
        btnPropiedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPropiedadActionPerformed(evt);
            }
        });

        btnCarcel.setText("Casilla de Carcel");
        btnCarcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCancel)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(31, 31, 31)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(93, 93, 93)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnTomaTarjeta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCarcel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnPropiedad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnTrampa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnNeutral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnInicio)
                .addGap(18, 18, 18)
                .addComponent(btnNeutral)
                .addGap(18, 18, 18)
                .addComponent(btnTrampa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPropiedad)
                .addGap(18, 18, 18)
                .addComponent(btnTomaTarjeta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCarcel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(btnCancel)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTrampaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrampaActionPerformed
       CasillaTrampa casTrampa = new CasillaTrampa();
       boolean verificarPosition = verificarPosition();
       casTrampa.format(boton);
       tipo = "trampa";
       redimensionar(verificarPosition,casTrampa);
       this.setVisible(false);       
    }//GEN-LAST:event_btnTrampaActionPerformed

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        CasilaInicio casInicio = new CasilaInicio();
        boolean verificarPosition = verificarPosition();
        tipo = "inicio";
        casInicio.format(boton);        
        redimensionar(verificarPosition,casInicio);
        this.setVisible(false);         
    }//GEN-LAST:event_btnInicioActionPerformed

    private void btnNeutralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNeutralActionPerformed
        CasillaNeutral casNeutral = new CasillaNeutral();
        boolean verificarPosition = verificarPosition();
        tipo = "neutral";
        casNeutral.format(boton);
        redimensionar(verificarPosition, casNeutral);
        this.setVisible(false);
    }//GEN-LAST:event_btnNeutralActionPerformed

    private void btnTomaTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTomaTarjetaActionPerformed
        // TODO add your handling code here:
        CasillaTarjeta casTarjeta = new CasillaTarjeta();
        boolean verificarPosition = verificarPosition();
        tipo = "tomaTarjeta";
        casTarjeta.format(boton);
        redimensionar(verificarPosition, casTarjeta);
        this.setVisible(false);
    }//GEN-LAST:event_btnTomaTarjetaActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.setVisible(false);        
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnPropiedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPropiedadActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        CasillaPropiedad casPropiedad = new CasillaPropiedad();  
        tipo = "propiedad";
        boolean verificarPosition = verificarPosition();
        casPropiedad.format(boton);        
        redimensionar(verificarPosition, casPropiedad);        
    }//GEN-LAST:event_btnPropiedadActionPerformed

    private void btnCarcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarcelActionPerformed
        // TODO add your handling code here:
        CasillaCarcel casCarcel = new CasillaCarcel();
        boolean verificarPosition = verificarPosition();
        tipo = "carcel";
        casCarcel.format(boton);
        redimensionar(verificarPosition,casCarcel);
        this.setVisible(false);
    }//GEN-LAST:event_btnCarcelActionPerformed

    private void redimensionar(boolean verificarPosition, Casilla casilla){
        //agregarBoton(boton,verificarPosition);
        tableroGui.agregarBoton(boton,verificarPosition,tipo, casilla);
    }
//    private void catchNewFormat(){
//        if (agregoCasilla) {
//            tablero[contCasilla-1] = new Tablero(boton);
//            tablero[contCasilla-1].setPosicion(contCasilla-1);
//        } else{
//            tablero[posicionCasilla] = new Tablero(boton);
//            tablero[posicionCasilla].setPosicion(posicionCasilla);
//        }
//    }
//    public void agregarBoton(JButton boton, boolean verificarPosition, Casilla casilla){
//        tableroGui.agregarBoton(boton,verificarPosition,tipo, casilla);        
//    }    
    private boolean verificarPosition(){
        if (boton.getText().equalsIgnoreCase("")) {            
            //agregoCasilla = true;
            return true;
        }
        //agregoCasilla = false;
        return false;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCarcel;
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnNeutral;
    private javax.swing.JButton btnPropiedad;
    private javax.swing.JButton btnTomaTarjeta;
    private javax.swing.JButton btnTrampa;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
