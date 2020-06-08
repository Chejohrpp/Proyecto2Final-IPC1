/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LecturaYEscritura;

import Excepciones.Exceptions;
import funcionalidades.*;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author chejohrpp
 */
public class RnWRanking {
    public RnWRanking(){
        
    }
    //Escribe o almacena los jugadores para el ranking
    public void WriteRanking(String path, AllPlayers allPlayers)throws Exceptions{        
        try {
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(path));
            salida.writeObject(allPlayers);
            salida.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exceptions("Error de escritura");
        }

        
    }
    //Lee los jugadores pata el ranking
    public AllPlayers ReadRanking(String path)throws Exceptions {
        try {
            ObjectInputStream flujoSalida = new ObjectInputStream(new FileInputStream(path));
            Object salida = flujoSalida.readObject();
            flujoSalida.close();
            return (AllPlayers) salida;
        } catch (IOException | ClassNotFoundException e) {
            //e.printStackTrace();
            
            throw new Exceptions("No hay nada");
        }
    }
}
