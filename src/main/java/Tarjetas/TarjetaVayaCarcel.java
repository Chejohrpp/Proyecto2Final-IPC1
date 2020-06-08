/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarjetas;

import java.io.Serializable;

/**
 *
 * @author chejohrpp
 */
public class TarjetaVayaCarcel extends TarjetasPro implements Serializable {
    
    public TarjetaVayaCarcel(String mensaje, int cantCopias, String grupoTT) {
        super(mensaje, cantCopias, grupoTT);
    }
    public void Accion(){
        
    }
}
