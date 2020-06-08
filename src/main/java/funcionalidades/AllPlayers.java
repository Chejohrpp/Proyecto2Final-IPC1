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
public class AllPlayers implements Serializable {  
    private Jugadores[] jugadores;
    private int cant;
    
    public AllPlayers(){
        
    }
    public void verificar(Jugadores[] jugadores){
        if (this.jugadores == null) {
            this.jugadores = new Jugadores[jugadores.length];
            for (int i = 0; i < jugadores.length; i++) {
            this.jugadores[i] = jugadores[i];
        }
        }else{
            redimensionar(jugadores);
        }
    }
    public void redimensionar(Jugadores[] jugadores){        
        Jugadores[] jugadores1 = new Jugadores[this.jugadores.length];
        for (int i = 0; i < this.jugadores.length; i++) {
            jugadores1[i] = this.jugadores[i];
        }
        
        this.jugadores = new Jugadores[jugadores1.length+jugadores.length];
        for (int i = 0; i < jugadores1.length; i++) {
            this.jugadores[i] = jugadores1[i];
        }
        
        cant = (jugadores1.length);
        for (int i = cant ; i < this.jugadores.length; i++) {
            this.jugadores[i] = jugadores[i-cant];
        }
    }
    public Jugadores[] getJugadores() {
        return jugadores;
    }

    public void setJugadores(Jugadores[] jugadores) {
        this.jugadores = jugadores;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }
    
}  

    

