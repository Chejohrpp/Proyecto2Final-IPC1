/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Casillas;
import java.awt.Color;
import java.awt.event.*;
import java.io.Serializable;
import javax.swing.*;
/**
 *
 * @author chejohrpp
 */
public class CasilaInicio extends Casilla implements Serializable  {

    private JButton casInicio;
    public CasilaInicio() {
        casInicio = new JButton();             
    }
    
    public void format(JButton casInicio){
        casInicio.setText("Inicio");
        casInicio.setOpaque(true);
        casInicio.setToolTipText("Inicio");
        casInicio.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        casInicio.setForeground(Color.green);
        casInicio.setBackground(Color.green);
       
    }
    
}
