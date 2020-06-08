/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LecturaYEscritura;

import Excepciones.Exceptions;
import funcionalidades.JuegoBoard;
import java.io.*;


/**
 *
 * @author chejohrpp
 */
public class RnWCrearJuego {

    public RnWCrearJuego() {
        
    }
    public void WriteGameC(String path, JuegoBoard juegoC) throws Exceptions{
        try {
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(path));
            salida.writeObject(juegoC);
            salida.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exceptions("Error al guardar el juego");
        }
    }
    public JuegoBoard ReadGameC(String path)throws Exceptions {
        try {
            ObjectInputStream flujoSalida = new ObjectInputStream(new FileInputStream(path));
            Object salida = flujoSalida.readObject();
            flujoSalida.close();
            return (JuegoBoard) salida;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new Exceptions("Error al leer el juego");
        }
    }
}
