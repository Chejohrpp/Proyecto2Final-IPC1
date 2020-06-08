/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionalidades;

import Excepciones.Exceptions;
import FuncionesPartida.VerificarGanador;
import LecturaYEscritura.RnWRanking;
import frontend.PartidaGUI;
import frontend.VisualTerminarJuego;
import frontend.Welcome;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author chejohrpp
 */
public class Tiempo extends Thread {
    private int cantTiempo;
    private JLabel lblTime;
    private boolean tiempoAA;
    private Jugadores[] jugador;
    private int min = 0;
    private int seg = 0;
    
    public Tiempo(int cantTiempo, JLabel lblTime, boolean tiempoAA, Jugadores[] jugador){
        this.cantTiempo = cantTiempo;
        this. lblTime = lblTime;
        this.tiempoAA  = tiempoAA;
        this.jugador = jugador;
    }
    @Override
    public void run(){
        try{
            if (tiempoAA) {
                while(PartidaGUI.estadoTiempo == true){
                    Thread.sleep(1000);
                    modificarCont();
                    cantTiempo++; 
                    PartidaGUI.juegoG.setTiempoF(PartidaGUI.juegoG.getTiempoF()+1);
                }
            } else{
                while(cantTiempo > -1 && PartidaGUI.estadoTiempo == true){
                    modificarContAtras();
                    Thread.sleep(1000);
                     PartidaGUI.juegoG.setTiempoF(cantTiempo);
                    cantTiempo--;                   
                }
                PartidaGUI.estadoTiempo = false; 
                JOptionPane.showMessageDialog(null, "Se acabo el tiempo"); 
                terminoTiempo();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Tiempo.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error en ejecuta el tiempo " + ex.getMessage());
        }
    }
    public void modificarCont(){       
        
        if (cantTiempo > 59) {
            min = cantTiempo/60;
            seg = cantTiempo -(min*60);           
        }else {
            min = 0;
            seg = cantTiempo;
        }
        
        lblTime.setText("Contador "+ min +":" + seg);
    }
    public void modificarContAtras(){
        min = cantTiempo/60;
        seg = cantTiempo -(min*60);
        //System.out.println(min + ": " + seg);
        lblTime.setText("Temporizador "+ min +":" + seg);
   
    }
    
    private void terminarJuego(String winner){
        VisualTerminarJuego terminar = new VisualTerminarJuego(winner);        
        guardar();
        terminar.setLocationRelativeTo(null);
        terminar.setVisible(true);
    }
    private void terminoTiempo(){
        VerificarGanador ganador = new VerificarGanador(jugador);
        String winner = ganador.obtenerGanadorYa();
        terminarJuego(winner);
    }
    private void guardar(){
        RnWRanking guardarRanking = new RnWRanking();
        Welcome.allPlayers.verificar(jugador);
        try{
            guardarRanking.WriteRanking("Ranking.rkg", Welcome.allPlayers);
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    
}
