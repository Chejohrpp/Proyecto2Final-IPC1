/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import Casillas.Casilla;
import funcionalidades.*;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author chejohrpp
 */
public class TableroGUI extends javax.swing.JFrame {
    private Tablero[] tablero;
    private int cont;
    private Container pane;

    /**
     * Creates new form TableroGUI
     */
    public TableroGUI(Tablero[] tablero) {
        initComponents();
        this.tablero = tablero;
        if (tablero == null) {
            cont = 0;
        } else{
            cont = tablero.length;
        }
        pane = jPanel1;        
    }
    
    public void generar(Container pane){        
        for (int i = 0; i < tablero.length; i++) {
            pane.add(tablero[i].getBoton());
            
        }          
    }
    public void limpiarPanel(Container pane){
        if (pane.getComponentCount() != 0) {
//            for (int i = 0; i < tablero.length; i++) {
//                pane.remove(tablero[i].getBoton());
//            }
            pane.removeAll();
            pane.revalidate();
            pane.repaint();
        }
    }
    
    public void setSizeJ(Dimension frame, Dimension panel){
        this.setSize(frame);
        jPanel1.setSize(panel);
        limpiarPanel(jPanel1);
        generar(jPanel1);
    }
    public void agregarBoton(JButton boton, boolean verificar, String tipo, Casilla casilla){
        //System.out.println(casilla.getClass());
        redimensionar(boton, verificar, tipo, casilla);
        //System.out.println(cont);
        //Tablero tablero = new Tablero(boton);
        //pane.add(tablero.getBoton());    
    }
    private void redimensionar(JButton boton, boolean verificar, String tipo, Casilla casilla){          
        if (verificarPosition(boton,verificar)) {
            if (cont == 1) {
                tablero = new Tablero[1];
                tablero[0] = new Tablero(boton);
                tablero[0].setTipo(tipo);
                tablero[0].setCasilla(casilla);
                tablero[0].setPosicion(1);
                tablero[0].setPosicionTablero(boton);
            } else{
                Tablero[] tablero1 = new Tablero[tablero.length];
            for (int i = 0; i < tablero.length; i++) {
                tablero1[i] = tablero[i];
            }
            tablero = new Tablero[cont];
            for (int i = 0; i < tablero1.length; i++) {
                tablero[i] = tablero1[i];
            }
             tablero[cont-1] = new Tablero(boton);
             tablero[cont-1].setTipo(tipo);
             tablero[cont-1].setCasilla(casilla);
             tablero[cont-1].setPosicion(cont);
             tablero[cont-1].setPosicionTablero(boton);
            }
        } else{
            for (int i = 0; i < cont; i++) {
                if (tablero[i].getBoton().getX() == boton.getX() && tablero[i].getBoton().getY() == boton.getY() ) {                    
                    tablero[i] = new Tablero(boton);
                    tablero[i].setTipo(tipo);
                    tablero[i].setCasilla(casilla);
                    tablero[i].setPosicion(i+1);
                    tablero[i].setPosicionTablero(boton);
                    System.out.println("posicion de la casilla asignada "+ i);
                }
            }           
        }      
    }
    private boolean verificarPosition(JButton boton, boolean verificar){
        if (verificar) {            
            cont++;
            return true;
        }
        //agregoCasilla = false;
        return false;
    }
    public Tablero[] getTablero(){
        return tablero;
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 669, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 626, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
