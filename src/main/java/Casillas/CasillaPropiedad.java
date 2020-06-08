/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Casillas;

import frontend.DPropiedad;
import frontend.MenuCrear;
import java.awt.Color;
import java.io.Serializable;
import javax.swing.*;


/**
 *
 * @author chejohrpp
 */
public class CasillaPropiedad extends Casilla implements Serializable {
    private String nombre;
    private int costo;    
    private int precioHipoteca;
    private boolean estadoHipoteca = false;
    private String tipoPropiedad;
    private String nombreDueño;
    private boolean tieneDueño = false;
    private CasillaTLugar casillaLugar = null;
    private CasillaTEstacion casillaEstacion = null;
    private CasillaTServivioB casillaServicio = null;

    public boolean isTieneDueño() {
        return tieneDueño;
    }

    public void setTieneDueño(boolean tieneDueño) {
        this.tieneDueño = tieneDueño;
    }

    public CasillaTLugar getCasillaLugar() {
        return casillaLugar;
    }

    public void setCasillaLugar(CasillaTLugar casillaLugar) {
        this.casillaLugar = casillaLugar;
    }

    public CasillaTEstacion getCasillaEstacion() {
        return casillaEstacion;
    }

    public void setCasillaEstacion(CasillaTEstacion casillaEstacion) {
        this.casillaEstacion = casillaEstacion;
    }

    public CasillaTServivioB getCasillaServicio() {
        return casillaServicio;
    }

    public void setCasillaServicio(CasillaTServivioB casillaServicio) {
        this.casillaServicio = casillaServicio;
    }
    
    public CasillaPropiedad(){        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public int getPrecioHipoteca() {
        return precioHipoteca;
    }

    public void setPrecioHipoteca(int precioHipoteca) {
        this.precioHipoteca = precioHipoteca;
    }

    public boolean isEstadoHipoteca() {
        return estadoHipoteca;
    }

    public void setEstadoHipoteca(boolean estadoHipoteca) {
        this.estadoHipoteca = estadoHipoteca;
    }

    public String getTipoPropiedad() {
        return tipoPropiedad;
    }

    public void setTipoPropiedad(String tipoPropiedad) {
        this.tipoPropiedad = tipoPropiedad;
    }

    public String getNombreDueño() {
        return nombreDueño;
    }

    public void setNombreDueño(String nombreDueño) {
        this.nombreDueño = nombreDueño;
    }


    public void format(JButton boton) {        
        //configPropiedad(boton); 
        tipoPropiedad(boton);
    }
//    public void configPropiedad(JButton boton){
//        DPropiedad dPropiedad = new DPropiedad(boton);
//        dPropiedad.setLocationRelativeTo(null);
//        dPropiedad.setVisible(true);        
//    }
    //verifica el tipo de propiedad que se va a usar
    public void tipoPropiedad(JButton boton){      
         String[] tipo = {"Lugar", "Servicio Basico", "Estacion"};
          this.tipoPropiedad = (String) JOptionPane.showInputDialog(null,"Seleccione el tipo de propiedad", "Elegir",JOptionPane.QUESTION_MESSAGE,null,tipo, tipo[0]);
          boolean verAtributos = true;
          while(verAtributos == true){
            try{
                this.nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre");
                this.costo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el precio"));
                this.precioHipoteca = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el precio de hipoteca")); 
                verAtributos = false;
            }catch(Exception e){
                 JOptionPane.showMessageDialog(null, "Ingreso mal, vuelva a ingresar los atributos basicos");
            }
          }                     
          if (tipoPropiedad.equalsIgnoreCase("Lugar")) {
            boolean verificar = true;
            casillaLugar = new CasillaTLugar();
            while(verificar){
                try{
                    casillaLugar.setCostoEstancia(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el costo de estancia")));
                    casillaLugar.setPrecioCasa(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el precio de casa")));
                    casillaLugar.setPrecioHotel( Integer.parseInt(JOptionPane.showInputDialog("Ingrese el precio del hotel")));                   
                                       
                    casillaLugar.setCostoEstanciaCasa( Integer.parseInt(JOptionPane.showInputDialog("Ingrese el costo de estancia por casa")));    
                    casillaLugar.setConstoEstanciaHotel(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el costo de estancia por hotel")));                     
                    
                    casillaLugar.setGrupoPropiedad(JOptionPane.showInputDialog("Ingrese el grupo del lugar"));
                    verificarExiste(casillaLugar.getGrupoPropiedad());
                    verificar = false;
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null, "Ingreso mal, vuelva a ingresar los atributos de lugar de nuevo");
                }
            }            
            /*DPropiedad dpropiedad = new DPropiedad(casillaLugar, boton, nombre, costo);
            dpropiedad.setLocationRelativeTo(null);
            dpropiedad.setVisible(true);
            */
            config(boton);
        } else if (tipoPropiedad.equalsIgnoreCase("Servicio Basico")) {            
            casillaServicio = new CasillaTServivioB();
            boolean verificar = false;
            while(verificar == false){
                try{
                    casillaServicio.setCostoServicio(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el costo de servicio")));
                    verificar = true;
                } catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Ingreso mal, vuelva a ingresar el coste de servicio");
                }
            }
            
            configServivio(boton);
        } else if (tipoPropiedad.equalsIgnoreCase("Estacion")) {            
            casillaEstacion = new CasillaTEstacion();
            boolean verificar = false;
            while(verificar == false){
                try{
                     casillaEstacion.setCostoUsoE(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el costo de uso de la estacion" )));
                     verificar = true;
                } catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Ingreso mal, Ingrese de nuevo el coste de uso de la estacion");
                }
            }           
            configEstacion(boton);
        }               
        
    }
    private void verificarExiste(String nuevo){
        boolean verificar = false;
        if (MenuCrear.gruposPropiedad != null) {
            for (int i = 0; i < MenuCrear.gruposPropiedad.length; i++) {
                if (nuevo.equalsIgnoreCase(MenuCrear.gruposPropiedad[i])) {
                    verificar = true;
                    JOptionPane.showMessageDialog(null, "Agregado al grupo existente");
                }
            }
            if (verificar == false) {
                redimensionar(nuevo);
            }
        }else{
            MenuCrear.gruposPropiedad = new String[1];
            MenuCrear.gruposPropiedad[0] = nuevo;
        }
    }
    private void redimensionar(String nuevo){        
            String[] aux = new String[MenuCrear.gruposPropiedad.length];
            for (int i = 0; i < aux.length; i++) {
                aux[i] = MenuCrear.gruposPropiedad[i];
            }
            MenuCrear.gruposPropiedad = new String[aux.length+1];
            for (int i = 0; i < aux.length; i++) {
                MenuCrear.gruposPropiedad[i] = aux[i];
            }
            MenuCrear.gruposPropiedad[aux.length] = nuevo;
    }


    
    public void config(JButton boton){
        boton.setText(nombre+" \n $"+costo);
        boton.setOpaque(true);
        boton.setForeground(Color.pink);
        boton.setBackground(Color.PINK); 
        try{
            boton.setToolTipText(nombre+" \n $"+costo +" tipo:"+ casillaLugar.getGrupoPropiedad());    
        } catch (Exception e){
            System.out.println("propiedad");
        }        
        boton.setFont(new java.awt.Font("Comic Sans MS", 0, 11));
    }
    public void configEstacion(JButton boton){
        boton.setText(nombre+" \n $"+casillaEstacion.getCostoUsoE());
        
        boton.setOpaque(true);
        boton.setForeground(Color.YELLOW);
        boton.setBackground(Color.YELLOW);               
        boton.setFont(new java.awt.Font("Comic Sans MS", 0, 11));
        boton.setToolTipText(boton.getText() + "Tipo: Estacion");
    }
    public void configServivio(JButton boton){
        boton.setText(nombre+" \n $"+casillaServicio.getCostoServicio());
        
        boton.setOpaque(true);
        boton.setForeground(Color.MAGENTA);
        boton.setBackground(Color.MAGENTA);               
        boton.setFont(new java.awt.Font("Comic Sans MS", 0, 11));
        boton.setToolTipText(boton.getText() + "Tipo: Servicio Basico");
    }
    
    
}
