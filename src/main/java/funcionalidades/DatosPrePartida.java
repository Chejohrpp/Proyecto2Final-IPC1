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
public class DatosPrePartida implements Serializable {
    private Jugadores[] jugador;
    private int CantTiempo;

    public DatosPrePartida(Jugadores[] jugador, int CantTiempo) {
        this.jugador = jugador;
        this.CantTiempo = CantTiempo;
    }

    public Jugadores[] getJugador() {
        return jugador;
    }

    public void setJugador(Jugadores[] jugador) {
        this.jugador = jugador;
    }

    public int getCantTiempo() {
        return CantTiempo;
    }

    public void setCantTiempo(int CantTiempo) {
        this.CantTiempo = CantTiempo;
    }
    
}
