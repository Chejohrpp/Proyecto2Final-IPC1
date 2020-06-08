/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarjetas;


import frontend.TableroGUI;
import funcionalidades.JuegoBoard;
import java.awt.HeadlessException;
import java.io.Serializable;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author chejohrpp
 */
public class TarjetaMoverCasilla extends TarjetasPro implements Serializable{
    JuegoBoard juegoC;
    private int accion;
    
    public TarjetaMoverCasilla(String mensaje, int cantCopias, JuegoBoard juegoC, String grupoTT) {
        super(mensaje, cantCopias, grupoTT);
        this.juegoC = juegoC;
    }
    @Override
    public void Accion(){
        while(true){
            try{
                accion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el No. Casilla donde quiere ser enviado \n ( Si no se acuerda de cual es el No. Casilla puede ir a"
                        + " verlo en: Diseño de tablero-previsualizar-Haciendo rollover en la casilla"));
                if (accion > juegoC.getTablero().length || accion < 1) {
                    JOptionPane.showMessageDialog(null, "No se encontro la casilla colocada");
                } else {
                 break;   
                }
                if (accion == JOptionPane.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(null, "Se ha cancelado");
                    break;
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Ingreso erroneo vuelva a ingresarlo de nuevo");
            }
        }
        
        
        
        
    }
}
