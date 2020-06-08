/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FuncionesPartida;

import funcionalidades.*;
import java.util.Random;

/**
 *
 * @author chejohrpp
 */
public class NuevaPartida {
    Jugadores[] jugador;
    int numRandom;
    Random random = new Random();
    public NuevaPartida(){        
    }
    //Solo crea el turno aleatorios para los jugadores
    public Jugadores[] RevolverJugadores(Jugadores[] jugador){
        int tamaño = jugador.length;
        this.jugador = new Jugadores[jugador.length];
        for (int i = 0; i < jugador.length; i++) {
            this.jugador[i] = jugador[i];            
        }
        jugador = new Jugadores[this.jugador.length];
        int posicion = 0;
        while(true){
            numRandom = random.nextInt(tamaño);            
            if (this.jugador[numRandom] != null) {
                jugador[posicion] = this.jugador[numRandom];
                this.jugador[numRandom] = null;
                //System.out.println(jugador[posicion].getNombre());
                posicion++;
            }
            if (posicion == jugador.length) {
                jugador[0].setEstado(true);
                jugador[0].setMostrarEstado("Tu turno");
                return jugador;                
            }
        }        
    }
    public void generarTodasColas(){
        
    }
}
