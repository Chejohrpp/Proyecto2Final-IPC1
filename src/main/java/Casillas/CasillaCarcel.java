/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Casillas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import javax.swing.JButton;

/**
 *
 * @author chejohrpp
 */
public class CasillaCarcel extends Casilla implements Serializable {
    
    public CasillaCarcel(){
        
    }


    public void format(JButton boton) {
        boton.setText("Carcel");
        boton.setOpaque(true);
        boton.setToolTipText("Carcel");
        boton.setForeground(Color.red);
        boton.setBackground(Color.red);               
        boton.setFont(new java.awt.Font("Comic Sans MS", 0, 31));        
    }
    
}
