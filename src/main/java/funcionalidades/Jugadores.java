/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionalidades;

import Casillas.*;
import Tarjetas.TarjetaVayaCarcel;
import java.awt.Color;
import java.io.Serializable;

/**
 *
 * @author chejohrpp
 */
public class Jugadores implements Serializable {
    private String nombre;
    private int riqueza;
    private boolean estado;
    private String colorFicha;
    private String mostrarEstado = "";
    private boolean estadoTrampa;
    private int posicioTablero = 0;
    private CasillaPropiedad[] propiedades;
    private int cantPropiedades = 0;
    private boolean GanoPerdio = false;
    private int riquezaTotal;
    private int tarjetasSalgaCarcel;
    private int cantServiciosB;
    private int cantEstacion;
    private int turnoPerdidos;

    public int getTurnoPerdidos() {
        return turnoPerdidos;
    }

    public void setTurnoPerdidos(int turnoPerdidos) {
        this.turnoPerdidos = turnoPerdidos;
    }

    public int getCantServiciosB() {
        return cantServiciosB;
    }

    public void setCantServiciosB(int cantServiciosB) {
        this.cantServiciosB = cantServiciosB;
    }

    public int getCantEstacion() {
        return cantEstacion;
    }

    public void setCantEstacion(int cantEstacion) {
        this.cantEstacion = cantEstacion;
    }

    public int getTarjetasSalgaCarcel() {
        return tarjetasSalgaCarcel;
    }

    public void setTarjetasSalgaCarcel(int tarjetasSalgaCarcel) {
        this.tarjetasSalgaCarcel = tarjetasSalgaCarcel;
    }
    
    public int getRiquezaTotal() {
        return riquezaTotal;
    }

    public void setRiquezaTotal(int riquezaTotal) {
        this.riquezaTotal = riquezaTotal;
    }

    public boolean isGanoPerdio() {
        return GanoPerdio;
    }

    public void setGanoPerdio(boolean GanoPerdio) {
        this.GanoPerdio = GanoPerdio;
    }

    public int getCantPropiedades() {
        return cantPropiedades;
    }

    public void setCantPropiedades(int cantPropiedades) {
        this.cantPropiedades = cantPropiedades;
    }

    public CasillaPropiedad[] getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(CasillaPropiedad[] propiedades) {
        this.propiedades = propiedades;
    }
    

    public int getPosicioTablero() {
        return posicioTablero;
    }

    public void setPosicioTablero(int posicioTablero) {
        this.posicioTablero = posicioTablero;
    }

    public boolean isEstadoTrampa() {
        return estadoTrampa;
    }

    public void setEstadoTrampa(boolean estadoTrampa) {
        this.estadoTrampa = estadoTrampa;
    }

    public String getMostrarEstado() {
        return mostrarEstado;
    }

    public void setMostrarEstado(String mostrarEstado) {
        this.mostrarEstado = mostrarEstado;
    }
    
    public Jugadores(String nombre, String coloFicha){
        this.nombre = nombre;
        this.colorFicha = coloFicha;
        estado = false;
        estadoTrampa = false;
    }
    public Color colorJugador(){
        if (colorFicha.equalsIgnoreCase("rojo")) {
            return Color.RED;
        } else if (colorFicha.equalsIgnoreCase("naranja")) {
            return Color.orange;            
        } else if (colorFicha.equalsIgnoreCase("blanco")) {
            return Color.white;
        } else if (colorFicha.equalsIgnoreCase("verde")) {
            return Color.green;
        } else if (colorFicha.equalsIgnoreCase("rosado")) {
            return Color.pink;
        } else if (colorFicha.equalsIgnoreCase("azul")) {
            return Color.blue;
        } else if (colorFicha.equalsIgnoreCase("violeta")) {
            return Color.MAGENTA;
        }
        return Color.BLACK;
    }

    public String getColorFicha() {
        return colorFicha;
    }

    public void setColorFicha(String colorFicha) {
        this.colorFicha = colorFicha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRiqueza() {
        return riqueza;
    }

    public void setRiqueza(int riqueza) {
        this.riqueza = riqueza;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
}
