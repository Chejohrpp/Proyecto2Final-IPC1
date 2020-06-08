/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FuncionesPartida;

import Casillas.CasillaPropiedad;
import static frontend.PartidaGUI.juegoG;
import funcionalidades.Jugadores;

/**
 *
 * @author chejohrpp
 */
public class Bancarrota {
    private Jugadores jugador;
    public Bancarrota(Jugadores jugador){
        this.jugador = jugador;
    }
    public void quitarTodo(){
        if (jugador.getPropiedades() != null) {
            for (int i = 0; i < jugador.getPropiedades().length; i++) {
                jugador.getPropiedades()[i].setTieneDueño(false);
                if (jugador.getPropiedades()[i].getCasillaLugar() != null) {
                    CasillaPropiedad propiedad = jugador.getPropiedades()[i];
                    propiedad.getCasillaLugar().setCantCasas(0);
                    propiedad.getCasillaLugar().setCantHoteles(0);
                }
            }
        }
    }
}
