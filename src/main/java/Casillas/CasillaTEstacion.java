/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Casillas;

import java.io.Serializable;
import javax.swing.JButton;

/**
 *
 * @author chejohrpp
 */
public class CasillaTEstacion implements Serializable {
    private int costoUsoE;
    public CasillaTEstacion(){
        
    }

    public int getCostoUsoE() {
        return costoUsoE;
    }

    public void setCostoUsoE(int costoUsoE) {
        this.costoUsoE = costoUsoE;
    }
}
