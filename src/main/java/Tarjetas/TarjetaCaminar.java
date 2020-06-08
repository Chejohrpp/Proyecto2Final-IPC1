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
public class TarjetaCaminar extends TarjetasPro implements Serializable{
    private int accion;
    public TarjetaCaminar(String mensaje, int cantCopias, String grupoTT) {
        super(mensaje,cantCopias, grupoTT);
    }
    @Override
    public void Accion(){        
        try{
            this.accion = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de casilla a caminar"));
        }catch(HeadlessException | NumberFormatException e){
            System.out.println("no ingreso numeros "+ e.getMessage());
        }
    }
    
}
