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
public class Generalidades implements Serializable {
    private String nombreJuego;
    private int cantInicial;
    private int canVuelta;
    private int cantDados;
    private int limiteCasas;
     private int limiteHoteles;
    private double porcentajeHipoteca;
    private int cantJugadores;

    public int getCanVuelta() {
        return canVuelta;
    }

    public void setCanVuelta(int canVuelta) {
        this.canVuelta = canVuelta;
    }

    public int getCantJugadores() {
        return cantJugadores;
    }

    public void setCantJugadores(int cantJugadores) {
        this.cantJugadores = cantJugadores;
    }

    public Generalidades(String nombreJuego, int cantInicial, int canVuelta, int cantDados, int limiteCasas, int limiteHoteles, double porcentajeHipoteca, int CantJugadores) {
        this.nombreJuego = nombreJuego;
        this.cantInicial = cantInicial;
        this.canVuelta = canVuelta;
        this.cantDados = cantDados;
        this.limiteCasas = limiteCasas;
        this.limiteHoteles = limiteHoteles;
        this.porcentajeHipoteca = porcentajeHipoteca;
        this.cantJugadores = CantJugadores;
    }

    public String getNombreJuego() {
        return nombreJuego;
    }

    public void setNombreJuego(String nombreJuego) {
        this.nombreJuego = nombreJuego;
    }

    public int getCantInicial() {
        return cantInicial;
    }

    public void setCantInicial(int cantInicial) {
        this.cantInicial = cantInicial;
    }

    public int getCantVuelta() {
        return canVuelta;
    }

    public void setCantVuelta(int canVuelta) {
        this.canVuelta = canVuelta;
    }

    public int getCantDados() {
        return cantDados;
    }

    public void setCantDados(int cantDados) {
        this.cantDados = cantDados;
    }

    public int getLimiteCasas() {
        return limiteCasas;
    }

    public void setLimiteCasas(int limiteCasas) {
        this.limiteCasas = limiteCasas;
    }

    public int getLimiteHoteles() {
        return limiteHoteles;
    }

    public void setLimiteHoteles(int limiteHoteles) {
        this.limiteHoteles = limiteHoteles;
    }

    public double getPorcentajeHipoteca() {
        return porcentajeHipoteca;
    }

    public void setPorcentajeHipoteca(double porcentajeHipoteca) {
        this.porcentajeHipoteca = porcentajeHipoteca;
    }
    
}
