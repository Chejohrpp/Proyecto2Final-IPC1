/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionalidades;

import java.io.Serializable;

/**
 *
 * @author chejohrpp
 */
public class JuegoGame implements Serializable {
    private DatosPrePartida datosPrePartida;
    private JuegoBoard juegoC;
    private boolean estado = true;
    private boolean formaTiempo;
    private int tiempoF;
    private int controlJ;

    public int getControlJ() {
        return controlJ;
    }

    public void setControlJ(int controlJ) {
        this.controlJ = controlJ;
    }

    public boolean isFormaTiempo() {
        return formaTiempo;
    }

    public void setFormaTiempo(boolean formaTiempo) {
        this.formaTiempo = formaTiempo;
    }

    public int getTiempoF() {
        return tiempoF;
    }

    public void setTiempoF(int tiempoF) {
        this.tiempoF = tiempoF;
    }

    public JuegoBoard getJuegoC() {
        return juegoC;        
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setJuegoC(JuegoBoard juegoC) {
        this.juegoC = juegoC;
    }
    
    public JuegoGame(){
        
    }

    public DatosPrePartida getDatosPrePartida() {
        return datosPrePartida;
    }

    public void setDatosPrePartida(DatosPrePartida datosPrePartida) {
        this.datosPrePartida = datosPrePartida;
    }
    
}
