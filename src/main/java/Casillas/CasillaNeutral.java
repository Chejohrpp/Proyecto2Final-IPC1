/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Casillas;

import java.awt.Color;
import java.io.Serializable;
import javax.swing.JButton;

/**
 *
 * @author chejohrpp
 */
public class CasillaNeutral extends Casilla implements Serializable {
    
    public CasillaNeutral(){        
    }

    public void format(JButton boton){
        boton.setText("Neutral");
        boton.setOpaque(true);
        boton.setToolTipText("Neutral");
        boton.setForeground(Color.white);
        boton.setBackground(Color.white);               
        boton.setFont(new java.awt.Font("Comic Sans MS", 0, 29));
    }
    
}
