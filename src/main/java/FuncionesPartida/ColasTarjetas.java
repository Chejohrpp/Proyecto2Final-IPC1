/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FuncionesPartida;

import funcionalidades.*;

/**
 *
 * @author chejohrpp
 * @param <T>
 */
public class ColasTarjetas<T> {
    private JuegoGame juegoG;
    private Tarjetas[] tarjetas;
    private int tamaño;
    private T[] cola;
    private int indiceFin;
    public ColasTarjetas(JuegoGame juegoG){
        tarjetas = juegoG.getJuegoC().getTarjetas();
    }
        public ColasTarjetas(int tamaño) {
        this.cola = (T[]) new Object[tamaño];
        this.tamaño = tamaño;
        this.indiceFin = -1;
    }

    public boolean esVacia() {
        return indiceFin == -1;
    }

    public void encolar(T elemento)
            throws Exception {
        if (indiceFin < tamaño - 1) {
            indiceFin++;
            cola[indiceFin] = elemento;
        } else {
            throw new Exception("La cola está llena, no se puede insertar el elemento: " + elemento);
        }
    }

    public T desencolar()
            throws Exception {
        if (!esVacia()) {
            T elemento = cola[0];

            for (int i = 0; i < indiceFin; i++) {
                cola[i] = cola[i + 1];
            }
            indiceFin--;

            return elemento;
        } else {
            throw new Exception("La cola está vacía.");
        }
    }

    public T inspeccionarFrente()
            throws Exception {
        if (esVacia()) {
            throw new Exception("La cola está vacía.");
        }
        return cola[0];
    }

    public T inspeccionarFin()
            throws Exception {
        if (esVacia()) {
            throw new Exception("La cola está vacía.");
        }
        return cola[indiceFin];
    }

    public T verIndice(int indice) {
        return cola[indice];
    }

    public int getTamaño() {
        return tamaño;
    }
    
}
