/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LecturaYEscritura;

import Excepciones.Exceptions;
import funcionalidades.*;
import java.io.*;


/**
 *
 * @author chejohrpp
 */
public class RnWJugar {
    public RnWJugar(){
        
    }
    public void WriteGameG(String path, JuegoGame juegoG) throws Exceptions{
        try {
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(path));
            salida.writeObject(juegoG);
            salida.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exceptions("Error al guardar el juego");
        }
    }
    public JuegoGame ReadGameG(String path)throws Exceptions {
        try {
            ObjectInputStream flujoSalida = new ObjectInputStream(new FileInputStream(path));
            Object salida = flujoSalida.readObject();
            flujoSalida.close();
            return (JuegoGame) salida;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new Exceptions("Error al leer el juego");
        }
    }
}
