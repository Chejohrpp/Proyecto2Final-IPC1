/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Casillas;

import frontend.MenuCrear;
import java.awt.Color;
import java.io.Serializable;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author chejohrpp
 */
public class CasillaTarjeta extends Casilla implements Serializable{
    private String grupoTT;
    public CasillaTarjeta(){
        
    }
    public void format(JButton boton) {
        this.grupoTT = JOptionPane.showInputDialog("Ingrese el grupo de tarjeta");
        VerificarGrupo();
        //System.out.println(MenuCrear.grupoTT.length);
        boton.setText(grupoTT);
        boton.setToolTipText(grupoTT);
        boton.setOpaque(true);
        boton.setForeground(Color.orange);
        boton.setBackground(Color.ORANGE);               
        boton.setFont(new java.awt.Font("Comic Sans MS", 0, 11));  
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void VerificarGrupo(){
        boolean ver = false;
        if (MenuCrear.grupoTT != null) {
            for (int i = 0; i < MenuCrear.grupoTT.length; i++) {
                //System.out.println(MenuCrear.grupoTT[i]);
                if (grupoTT.equalsIgnoreCase(MenuCrear.grupoTT[i])) {
                    JOptionPane.showMessageDialog(null, "Se agrego con los demas del grupo");
                    ver = true;
                }
            }
            if (ver == false) {
                redimensionar(grupoTT);
            }
        } else {
            MenuCrear.grupoTT = new String[1];
            MenuCrear.grupoTT[0] = grupoTT;
        }
        
    }
   private void redimensionar(String nuevo){
        if (MenuCrear.grupoTT == null) {
            MenuCrear.grupoTT = new String[1];
            MenuCrear.grupoTT[0] = nuevo;
        } else {
            String[] aux = new String[MenuCrear.grupoTT.length];
            for (int i = 0; i < aux.length; i++) {
                aux[i] = MenuCrear.grupoTT[i];
            }
            MenuCrear.grupoTT = new String[aux.length+1];
            for (int i = 0; i < aux.length; i++) {
                MenuCrear.grupoTT[i] = aux[i];
            }
            MenuCrear.grupoTT[aux.length] = nuevo;
        }
    }

    public String getGrupoTT() {
        return grupoTT;
    }

    public void setGrupoTT(String grupoTT) {
        this.grupoTT = grupoTT;
    }
    
}
