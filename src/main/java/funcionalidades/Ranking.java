/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionalidades;

import java.text.Collator;

/**
 *
 * @author chejohrpp
 */
public class Ranking {
    private Jugadores[] jugadores;
    
    public Ranking(Jugadores[] jugadores){
        this.jugadores = jugadores;
    }
    //se vizualiza los ganadores o perdedores
    public Jugadores[] verGanadorPerdedor(boolean estado){
        int cant = 0;
        for (int i = 0; i < jugadores.length; i++) {
            if (jugadores[i].isGanoPerdio() == estado) {
                cant++;
            }
        }
        if (cant != 0) {
            int starJ = 0;
            Jugadores[] jugador = new Jugadores[cant];
            for (int i = 0; i < cant; i++) {
                for (int j = starJ; j < jugadores.length; j++) {
                    if (jugadores[j].isGanoPerdio() == estado) {
                        jugador[i] = jugadores[j];
                        starJ = j+1;
                        j = jugadores.length;
                    }
                }
            }
            return jugador;
        }
        return null;        
    }
    //se ordena ascendente por riqueza con el metodo burbuja
    public Jugadores[] ordenarRiqueza(Jugadores[] jugadores){
        if (jugadores == null) {
            return null;
        }
        for (int i = 0; i < jugadores.length; i++) {
            for (int j = 0; j < jugadores.length-i-1; j++) {
                if (jugadores[j].getRiquezaTotal() > jugadores[j+1].getRiquezaTotal()) {
                    Jugadores aux = jugadores[j];
                    jugadores[j] = jugadores[j+1];
                    jugadores[j+1] = aux;
                }
            }
        }
       return jugadores;
    }
    //Se ordena descendente  con el metodo burbuja usando la riqueza
    public Jugadores[] ordenarRiquezaD(Jugadores[] jugadores){
        if (jugadores == null) {
            return null;
        }
        for (int i = 0; i < jugadores.length; i++) {
            for (int j = 0; j < jugadores.length-i-1; j++) {
                if (jugadores[j].getRiquezaTotal() < jugadores[j+1].getRiquezaTotal()) {
                    Jugadores aux = jugadores[j];
                    jugadores[j] = jugadores[j+1];
                    jugadores[j+1] = aux;
                }
            }
        }
       return jugadores;
    } 
    //Se compara cual es el nombre mayor y menor para los ordenamientos
    private boolean comparacion(String j1,String j2){
        Collator comparar = Collator.getInstance();
        comparar.setStrength(Collator.PRIMARY);
        int evaluar = comparar.compare(j1.toUpperCase(), j2.toUpperCase());
        if (evaluar == -1) {
            return true;
        }
        return false;
    }
    //Ordenamiento por nombre con el metodo burbuja
    public Jugadores[] OrdenaNombre(Jugadores[] jugadores){
        if (jugadores == null) {
            return null;
        }
        int largo = jugadores.length;
        //boolean moverPosicion = true;
        //while (moverPosicion == true){
            //moverPosicion = false;
            for (int i = 0; i < largo; i++) {
                for (int j = 0; j < largo-i-1; j++) {
                    if (comparacion(jugadores[j].getNombre(),jugadores[j+1].getNombre()) == false) {
                        Jugadores aux = jugadores[j];
                        jugadores[j] = jugadores[j+1];
                        jugadores[j+1]=aux;
                        //moverPosicion = true;
                    }
                }                
            }
        //}
        return jugadores;
    }
    //Ordenamiento Descendente con el nombre
    public Jugadores[] OrdenaNombreD(Jugadores[] jugadores){
        if (jugadores == null) {
            return null;
        }
        int largo = jugadores.length;
        //boolean moverPosicion = true;
        //while (moverPosicion == true){
            //moverPosicion = false;
            for (int i = 0; i < largo; i++) {
                for (int j = 0; j < largo-i-1; j++) {
                     if (comparacion(jugadores[j].getNombre(),jugadores[j+1].getNombre())) {
                        Jugadores aux = jugadores[j];
                        jugadores[j] = jugadores[j+1];
                        jugadores[j+1]=aux;
                        //moverPosicion = true;
                    }
                }               
            }
        //}
        return jugadores;
    }
}
