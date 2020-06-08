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
public class JuegoBoard implements Serializable {
    private Generalidades general;
    private Tablero[] tablero;
    private Tarjetas[] tarjetas;
    private int alto;
    private int largo;
    private String[] gruposPropiedad;
    private String[] grupoTT;

    public String[] getGruposPropiedad() {
        return gruposPropiedad;
    }

    public void setGruposPropiedad(String[] gruposPropiedad) {
        this.gruposPropiedad = gruposPropiedad;
    }

    public String[] getGrupoTT() {
        return grupoTT;
    }

    public void setGrupoTT(String[] grupoTT) {
        this.grupoTT = grupoTT;
    }

    
    public void setAltoLargo(int largo, int alto){
        this. alto = alto;
        this.largo = largo;
    }

    public int getAlto() {
        return alto;
    }

    public int getLargo() {
        return largo;
    }
    


    public JuegoBoard(){
        
    }
    public void setJuegoBoard(JuegoBoard juegoC){
        
    }

    public Generalidades getGeneral() {
        return general;
    }

    public void setGeneral(Generalidades general) {
        this.general = general;
    }

    public Tablero[] getTablero() {
        return tablero;
    }

    public void setTablero(Tablero[] tablero) {
        this.tablero = tablero;
    }

    public Tarjetas[] getTarjetas() {
        return tarjetas;
    }

    public void setTarjetas(Tarjetas[] tarjetas) {
        this.tarjetas = tarjetas;
    }
    
}
