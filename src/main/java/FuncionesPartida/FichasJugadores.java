/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FuncionesPartida;

import funcionalidades.*;
import java.awt.Color;
import java.io.Serializable;
import javax.swing.JLabel;

/**
 *
 * @author chejohrpp
 */
public class FichasJugadores implements Serializable {
    private final int ALTO_LABEL = 19;
    private final int LARGO_LABEL = 90;
    private Tablero[] tablero;
    private JLabel label = new JLabel();
    private Jugadores jugador;
    public FichasJugadores(Jugadores jugador,Tablero[] tablero){
        this.jugador = jugador;
        this.tablero = tablero;
    }
    public void format(int posicion){
        label.setText(jugador.getNombre());
        label.setOpaque(true);
        label.setBackground(jugador.colorJugador());
        label.setForeground(Color.black);
        label.setBounds(posX(), posY(posicion), LARGO_LABEL, ALTO_LABEL);
        
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }
    private int posX(){
        int casillaX = tablero[jugador.getPosicioTablero()].getBoton().getX();
        return casillaX+17;
    }
    private int posY(int posicion){
        int casillaY = tablero[jugador.getPosicioTablero()].getBoton().getY();
        return casillaY + ALTO_LABEL*posicion;
    }
    
    
}
