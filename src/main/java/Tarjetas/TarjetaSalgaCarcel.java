/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarjetas;

import funcionalidades.Jugadores;
import java.awt.HeadlessException;
import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author chejohrpp
 */
public class TarjetaSalgaCarcel extends TarjetasPro implements Serializable {
    private Jugadores dueño;
    public TarjetaSalgaCarcel(String mensaje, int cantCopias, String grupoTT) {
        super(mensaje, cantCopias, grupoTT);
    }
    public void Accion(Jugadores dueño){
       this.dueño = dueño;
    }
}
