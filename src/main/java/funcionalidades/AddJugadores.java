/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionalidades;

import javax.swing.*;

/**
 *
 * @author chejohrpp
 */
public class AddJugadores {
    public final int ESPACIO_PIXELES = 65;
    public final int ESPACIO_INTERMEDIO = 4;
    public final int ALTO_TEXTO = 30;
    public final int ANCHO_TEXTO = 150;
    public final String[] COLOR = {"rojo","naranja", "blanco", "verde", "rosado","azul","violeta"};
    
    private JLabel jugador;
    private JTextField nombre;
    private JComboBox cmb;    

    public JComboBox getCmb() {
        return cmb;
    }    

    public AddJugadores(int position) {
        this.jugador = new JLabel("Nombre del jugador "+(position+1));
        this.nombre= new JTextField();
        this.cmb = new JComboBox(COLOR);
    }

    public JTextField getNombre() {
        return nombre;
    }

    public JLabel getJugador() {
        return jugador;
    }
    
    public void getFormat(int posy){
        int posY = (ESPACIO_PIXELES * posy)+ESPACIO_INTERMEDIO+80;
        jugador.setBounds(ESPACIO_INTERMEDIO, posY, 200, ALTO_TEXTO);
        jugador.setFont(new java.awt.Font("Ubuntu", 0, 18)); 
        nombre.setBounds(ESPACIO_INTERMEDIO + 200, posY, ANCHO_TEXTO, ALTO_TEXTO);
        cmb.setBounds(ESPACIO_INTERMEDIO + 204 + ANCHO_TEXTO, posY, ANCHO_TEXTO, ALTO_TEXTO);
        
    }
    public Jugadores getNewJugadores(){
        return new Jugadores(nombre.getText(),cmb.getSelectedItem().toString());
    }
    public boolean isEmpty(){
        return (nombre.getText().replaceAll(" ", "").isEmpty());
    }
    
}
