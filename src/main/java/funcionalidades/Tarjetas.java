/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionalidades;

import Tarjetas.*;
import java.io.Serializable;
import javax.swing.JTextField;

/**
 *
 * @author chejohrpp
 */
public class Tarjetas implements Serializable{
    private TarjetasPro tarjeta;
    private String tipoTarjeta;

    public Tarjetas(TarjetasPro tarjeta, String tipo) {
        this.tarjeta = tarjeta;
        this.tipoTarjeta = tipo;
    }
    public Tarjetas(){
        
    }

    public TarjetasPro getTarjeta() {        
        return tarjeta;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }
    public void setTipoTarjeta(String tipoTarjeta){
        this.tipoTarjeta = tipoTarjeta;
    }

    public void setTarjeta(TarjetasPro tarjeta) {
        this.tarjeta = tarjeta;
    }
    
    public TarjetasPro verificarTipo(String tipo, String mensaje, JTextField txtCantTarjetas, JuegoBoard juegoC, String grupoTT){        
        switch (tipo) {
            case "Caminar":
                TarjetaCaminar caminar = new TarjetaCaminar(mensaje,Integer.parseInt(txtCantTarjetas.getText()), grupoTT);
                caminar.Accion();
                return caminar;                
            case "Premio":
                TarjetaPremio premio = new TarjetaPremio(mensaje,Integer.parseInt(txtCantTarjetas.getText()), grupoTT);
                premio.Accion();                
                return premio;
            case "Multa":
                TarjetaMulta multa = new TarjetaMulta(mensaje,Integer.parseInt(txtCantTarjetas.getText()), grupoTT);
                multa.Accion();
                return multa;
            case "Pago a Jugadores":
                TarjetaPagoJugadores pagoJugadores = new TarjetaPagoJugadores(mensaje,Integer.parseInt(txtCantTarjetas.getText()), grupoTT);
                pagoJugadores.Accion();
                return pagoJugadores;
            case "Mover a Casilla":
                TarjetaMoverCasilla moverCasilla = new TarjetaMoverCasilla(mensaje,Integer.parseInt(txtCantTarjetas.getText()), juegoC, grupoTT );
                moverCasilla.Accion();
                return moverCasilla;
            case "Vaya a la Carcel":
                TarjetaVayaCarcel vayaCarcel = new TarjetaVayaCarcel(mensaje,Integer.parseInt(txtCantTarjetas.getText()), grupoTT);
                
                return vayaCarcel;
            case "Perder Turno":
                TarjetaPerderTurno perderTurno = new TarjetaPerderTurno(mensaje,Integer.parseInt(txtCantTarjetas.getText()), grupoTT);
                perderTurno.Accion();
                return perderTurno;
            case "Salga de la Carcel":
                TarjetaSalgaCarcel salgaCarcel = new TarjetaSalgaCarcel(mensaje,Integer.parseInt(txtCantTarjetas.getText()), grupoTT);
                
                return salgaCarcel;
                
            case "Tarjeta Personalizada":
                TarjetaPersonalizada personalizada = new TarjetaPersonalizada(mensaje,Integer.parseInt(txtCantTarjetas.getText()), grupoTT, juegoC);
                personalizada.Accion();
                return personalizada;
        }
         return null;
    }
    
}
