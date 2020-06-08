/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Casillas;

import frontend.DPropiedad;
import java.io.Serializable;

/**
 *
 * @author chejohrpp
 */
public class CasillaTLugar implements Serializable {
    private int CantHoteles = 0;
    private int cantCasas = 0;
    private int CostoEstancia;
    private int costoEstanciaCasa;
    private int constoEstanciaHotel;
    private int precioCasa;
    private int precioHotel;
    private String grupoPropiedad;
    public CasillaTLugar(){
        
    }

    public int getCantHoteles() {
        return CantHoteles;
    }

    public void setCantHoteles(int CantHoteles) {
        this.CantHoteles = CantHoteles;
    }

    public int getCantCasas() {
        return cantCasas;
    }

    public void setCantCasas(int cantCasas) {
        this.cantCasas = cantCasas;
    }

    public int getCostoEstancia() {
        return CostoEstancia;
    }

    public void setCostoEstancia(int CostoEstancia) {
        this.CostoEstancia = CostoEstancia;
    }

    public int getCostoEstanciaCasa() {
        return costoEstanciaCasa;
    }

    public void setCostoEstanciaCasa(int costoEstanciaCasa) {
        this.costoEstanciaCasa = costoEstanciaCasa;
    }

    public int getConstoEstanciaHotel() {
        return constoEstanciaHotel;
    }

    public void setConstoEstanciaHotel(int constoEstanciaHotel) {
        this.constoEstanciaHotel = constoEstanciaHotel;
    }

    public int getPrecioCasa() {
        return precioCasa;
    }

    public void setPrecioCasa(int precioCasa) {
        this.precioCasa = precioCasa;
    }

    public int getPrecioHotel() {
        return precioHotel;
    }

    public void setPrecioHotel(int precioHotel) {
        this.precioHotel = precioHotel;
    }

    public String getGrupoPropiedad() {
        return grupoPropiedad;
    }

    public void setGrupoPropiedad(String grupoPropiedad) {
        this.grupoPropiedad = grupoPropiedad;
    }
}
