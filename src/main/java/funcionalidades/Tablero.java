/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionalidades;

import Casillas.Casilla;
import java.awt.Color;
import java.io.Serializable;
import javax.swing.JButton;

/**
 *
 * @author chejohrpp
 */
public class Tablero implements Serializable {
    
    private String tipo;
    private JButton boton;
    private int posicion;
    private Casilla casilla;
    private String ToolTipText;

    public Casilla getCasilla() {
        return casilla;
    }

    public void setCasilla(Casilla casilla) {
        this.casilla = casilla;
    }


    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    
    public Tablero(JButton boton){
        this.boton = new JButton();
        this.boton.setText(boton.getText());        
        this.boton.setOpaque(true);
        this.boton.setForeground(boton.getForeground());
        this.boton.setBackground(boton.getBackground());               
        this.boton.setFont(boton.getFont());  
        this.boton.setBounds(boton.getBounds());
        ToolTipText = boton.getToolTipText();
        //this.boton.setToolTipText(boton.getToolTipText());
        this.boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAccion(evt);
            }
        });
        
    }    
    public void setBoton(JButton boton){
        this.boton = boton;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public JButton getBoton() {
        return boton;
    }
    public JButton botonAccion(java.awt.event.ActionEvent evt){
        //System.out.println(boton.getText());
        return boton;
    }
    public void setPosicionTablero(JButton boton){
        this.boton.setToolTipText(ToolTipText + " No. Casilla: " + posicion);
    }  
}
