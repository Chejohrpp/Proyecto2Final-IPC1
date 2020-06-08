/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarjetas;

import java.awt.HeadlessException;
import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author chejohrpp
 */
public class TarjetaPagoJugadores extends TarjetasPro implements Serializable{
    private int accion;
    public TarjetaPagoJugadores(String mensaje, int cantCopias, String grupoTT) {
        super(mensaje, cantCopias, grupoTT);
    }
    public void Accion(){
        try{
            this.accion = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de dinero para cada jugador"));
        }catch(HeadlessException | NumberFormatException e){
            System.out.println("no ingreso numeros "+ e.getMessage());
        }
    }
}
