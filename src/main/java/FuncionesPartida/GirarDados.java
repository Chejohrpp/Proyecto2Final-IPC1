/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FuncionesPartida;
import Excepciones.Exceptions;
import javax.swing.JLabel;
/**
 *
 * @author chejohrpp
 */
public class GirarDados {
    
    private int cantDados;
    public static int[] dados;
    private int vecesLanzado = 0;
    JLabel lDado1, lDado2, lDado3;
    private int total;
    private boolean verificarLanzamiento = false;
    public GirarDados(JLabel lDado1, JLabel lDado2, JLabel lDado3, int cantDados, int vecesLanzados){
        dados = new int[cantDados];
        this.lDado1 = lDado1;
        this.lDado2 = lDado2;
        this.lDado3 = lDado3;        
        this.cantDados = cantDados;
        this.vecesLanzado = vecesLanzados;
    }
    public void sumarDados(int total) throws InterruptedException{
        Thread dado1 = new Dados(0,cantDados, lDado1);      
        dado1.start();
        dado1.join();
        Thread dado2 = new Dados(1,cantDados, lDado2);
        dado2.start();
        dado2.join();
        Thread dado3 = new Dados(2,cantDados,lDado3); 
        dado3.start();        
        dado3.join();   
        total();
        verificarCantDados();
        
    }
    public void total(){
        for (int i = 0; i < dados.length; i++) {
            total += dados[i];
        }
        //System.out.println("Total "+  total);
    }
    public int totals(){
        return total;
    }
    
    public void verificarCantDados(){
        if (cantDados == 3) {
            if (dados[0] == dados[1] && dados[0] == dados[2]) {
                vecesLanzado++;               
                verificarLanzamiento = true;
            } else{
                verificarLanzamiento = false;
            }
        } else if(cantDados == 2){
            if (dados[0] == dados[1]){
                verificarLanzamiento = true;
                vecesLanzado++; 
            } else{
                verificarLanzamiento = false;
                
            }
        }
    }
    public boolean isVerificarLanzamiento(){
        return verificarLanzamiento;
    }
    
}
