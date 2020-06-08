/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FuncionesPartida;
import funcionalidades.*;
import Casillas.*;
import javax.swing.JOptionPane;
/**
 *
 * @author chejohrpp
 */
public class VerificarGanador {
    private Jugadores jugador;
    private Tablero[] tablero;
    private boolean hayGanador;
    private Jugadores[] jugadores;
    public VerificarGanador(Jugadores jugador, Tablero[] tablero){
        this.jugador  = jugador;
        this.tablero = tablero;
    }
    public VerificarGanador(Jugadores[] jugadores){
        this.jugadores = jugadores;
    }

    public boolean isHayGanador() {
        return hayGanador;
    }
    public void verificarSiGanadoPropiedades(){
        int cantPropiedades = 0;
        for (Tablero tablero : tablero) {
            if (tablero.getCasilla() instanceof CasillaPropiedad) {
                cantPropiedades++;
            }
        }
        if (cantPropiedades == jugador.getCantPropiedades()) {
            JOptionPane.showMessageDialog(null, "Felicidades "+ jugador.getNombre() +  " ha ganado");
            hayGanador = true;
        } else {
            hayGanador = false;
        }
    }
    public String obtenerGanadorYa(){
        for (int i = 0; i < jugadores.length; i++) {
            for (int j = 0; j < jugadores.length-i-1; j++) {
                 if (jugadores[j].getRiquezaTotal() < jugadores[j+1].getRiquezaTotal()) {
                    Jugadores aux = jugadores[j];
                    jugadores[j] = jugadores[j+1];
                    jugadores[j+1] = aux;
                }
            }
        }
        jugadores[0].setGanoPerdio(true);
        return jugadores[0].getNombre();
    }
}
