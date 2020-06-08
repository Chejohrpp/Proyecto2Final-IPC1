/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarjetas;

import funcionalidades.JuegoBoard;
import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author chejohrpp
 */
public class TarjetaPersonalizada extends TarjetasPro implements Serializable {
    //private TarjetasPro[] tipos;
    public static boolean caminar = false;
    public static boolean mover = false;
    public static boolean vayaCarcel = false;
    public static boolean multa = false;
    public static boolean premio = false;
    public static boolean perderTurno = false;
    public static boolean pagoJugadores = false;
    private JuegoBoard juegoC;
    private int intCaminar;
    private int intMover;
    private int intMulta;
    private int intPremio;
    private int intPerderTurno;
    private int intPagoJugadores;
    
    public TarjetaPersonalizada(String mensaje, int cantCopias, String grupoTT, JuegoBoard juegoC) {
        super(mensaje, cantCopias, grupoTT);
        this.juegoC = juegoC;
    }
    public void Accion(){
        while(true){
            try{
                if (caminar == true) {
                     intCaminar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de pasos a caminar"));
                }
                if (multa == true) {
                    intMulta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de multa"));
                }
                if (premio == true) {
                    intPremio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de premio"));
                }
                if (perderTurno == true) {
                    intPerderTurno = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de turnos perdidos"));
                }
                if (pagoJugadores == true) {
                    intPagoJugadores = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad que tiene que paga a todos los jugadores"));
                }
                break;
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Vuelva a ingresar correctamente los datos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (mover== true) {
            while(true){
                try{
                    intMover = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de casilla \n (si no se recuerda del nuemero ir a previsualizar del diseño del Tablero)"));
                    if (intMover > juegoC.getTablero().length || intMover < 1) {
                        JOptionPane.showMessageDialog(null, "No se encontro la casilla colocada");
                    } else {
                        break;
                    }             
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Vuelva a ingresar la casilla a mover", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public boolean isCaminar() {
        return caminar;
    }

    public static void setCaminar(boolean caminar) {
        TarjetaPersonalizada.caminar = caminar;
    }

    public  boolean isMover() {
        return mover;
    }

    public static void setMover(boolean mover) {
        TarjetaPersonalizada.mover = mover;
    }

    public  boolean isVayaCarcel() {
        return vayaCarcel;
    }

    public static void setVayaCarcel(boolean vayaCarcel) {
        TarjetaPersonalizada.vayaCarcel = vayaCarcel;
    }

    public  boolean isMulta() {
        return multa;
    }

    public static void setMulta(boolean multa) {
        TarjetaPersonalizada.multa = multa;
    }

    public  boolean isPremio() {
        return premio;
    }

    public static void setPremio(boolean premio) {
        TarjetaPersonalizada.premio = premio;
    }

    public  boolean isPerderTurno() {
        return perderTurno;
    }

    public static void setPerderTurno(boolean perderTurno) {
        TarjetaPersonalizada.perderTurno = perderTurno;
    }

    public  boolean isPagoJugadores() {
        return pagoJugadores;
    }

    public static void setPagoJugadores(boolean pagoJugadores) {
        TarjetaPersonalizada.pagoJugadores = pagoJugadores;
    }

    public JuegoBoard getJuegoC() {
        return juegoC;
    }

    public void setJuegoC(JuegoBoard juegoC) {
        this.juegoC = juegoC;
    }

    public int getIntCaminar() {
        return intCaminar;
    }

    public void setIntCaminar(int intCaminar) {
        this.intCaminar = intCaminar;
    }

    public int getIntMover() {
        return intMover;
    }

    public void setIntMover(int intMover) {
        this.intMover = intMover;
    }

    public int getIntMulta() {
        return intMulta;
    }

    public void setIntMulta(int intMulta) {
        this.intMulta = intMulta;
    }

    public int getIntPremio() {
        return intPremio;
    }

    public void setIntPremio(int intPremio) {
        this.intPremio = intPremio;
    }

    public int getIntPerderTurno() {
        return intPerderTurno;
    }

    public void setIntPerderTurno(int intPerderTurno) {
        this.intPerderTurno = intPerderTurno;
    }

    public int getIntPagoJugadores() {
        return intPagoJugadores;
    }

    public void setIntPagoJugadores(int intPagoJugadores) {
        this.intPagoJugadores = intPagoJugadores;
    }
    
}
