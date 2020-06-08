/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionalidades;

import frontend.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author chejohrpp
 */


public class GenerarMatrizTab extends JFrame{
    public final int ESPACIO_PIXELES = 125;
    public final int ESPACIO_INTERMEDIO = 2;
    public final int ALTO_TEXTO = 125;
    public final int ANCHO_TEXTO = 125;
    
    private Tablero[] tablero;
    private JButton boton;
    OpcionCasila opcionCas;
    private TableroGUI tableroGui;
    //DiseñoCaminoTab diseñoCaminoTab;

    public GenerarMatrizTab(Tablero[] tablero,TableroGUI tableroGui) {
        this.boton = new JButton();
        boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                btnactionPerformed(ae);
            }
        });        
        this.tablero = tablero;
        
        //this.tableroGui = new TableroGUI(tablero);
        this.tableroGui = tableroGui;
    }


    

    public JButton getBoton() {
        return boton;
    }
    public void setButton(JButton boton){
        this.boton.setText(boton.getText());        
        this.boton.setOpaque(true);
        this.boton.setForeground(boton.getForeground());
        this.boton.setBackground(boton.getBackground());               
        this.boton.setFont(boton.getFont());  
        this.boton.setBounds(boton.getBounds());        
    }
    
    public void getFormat(int xPosition, int yPosition){
        int YPosition = (ESPACIO_PIXELES * yPosition) + ESPACIO_INTERMEDIO;
        int XPosition = (ESPACIO_PIXELES * xPosition) + ESPACIO_INTERMEDIO;        
        boton.setBounds(XPosition, YPosition, ANCHO_TEXTO, ALTO_TEXTO);
    }
    private void btnactionPerformed(java.awt.event.ActionEvent ae) {
        if (ae.getSource() == boton) {
            opcionCas = new OpcionCasila(boton,tablero,tableroGui);
            opcionCas.setBoton(boton);
            //opcionCas.setCantCasillas(cantCasillas, diseñoCaminoTab);
            opcionCas.setLocationRelativeTo(null);
            opcionCas.setVisible(true);  
            
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }
    public void setBoton(boolean estado){
        boton.setEnabled(estado);
    }
    public Tablero getNewTablero(){
        return new Tablero(boton);
    }
    
}
