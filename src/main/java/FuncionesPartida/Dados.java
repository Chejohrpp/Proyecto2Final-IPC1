/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FuncionesPartida;

import frontend.PartidaGUI;
import java.util.Random;
import javax.swing.JLabel;


/**
 *
 * @author chejohrpp
 */
public class Dados extends Thread {
    private int numDado;
    private int cantDado;
    private Random random = new Random();
    private JLabel label;
    public Dados(int numDado, int cantDado, JLabel label){
        this.numDado = numDado;
        this.cantDado = cantDado;
        this.label = label;
        
    }
    public Dados(String msg){
        super(msg);
    }
    @Override
    public void run() {
        if (numDado < cantDado) {
            int rnd = random.nextInt(6) + 1;
            label.setText("Dado "+  ((int)numDado+1) + " : " + rnd);                     
            GirarDados.dados[numDado] = rnd;
        } else {
            label.setText("");
        }
    }
    

}
