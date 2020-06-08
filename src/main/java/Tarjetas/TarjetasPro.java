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
public class TarjetasPro implements Serializable {
    private String mensaje;
    private int cantCopias;
    private String grupoTT;
    private int accion;

    public TarjetasPro(String mensaje, int cantCopias, String grupoTT) {
        this.mensaje = mensaje;
        this.cantCopias = cantCopias;
        this.grupoTT = grupoTT;
    }
    
    public int getCantCopias() {
        return cantCopias;
    }

    public void setCantCopias(int cantCopias) {
        this.cantCopias = cantCopias;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getGrupoTT() {
        return grupoTT;
    }

    public void setGrupoTT(String grupoTT) {
        this.grupoTT = grupoTT;
    }

    public int getAccion() {
        return accion;
    }

    public void setAccion(int accion) {
        this.accion = accion;
    }
    
    /**
     *
     */
    public void Accion(){       
    }
    
}
