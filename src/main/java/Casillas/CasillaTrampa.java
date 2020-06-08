/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Casillas;
import java.awt.Color;
import java.io.Serializable;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author chejohrpp
 */
public class CasillaTrampa extends Casilla implements Serializable {
    private JButton casTrampa;
    private int idAccion;
    private String mensaje;
    private int accion;
    private final String[] DATA = {"Vaya a la carcel", "multa", "perder turno"};

    public CasillaTrampa() {        
           casTrampa = new JButton();
    }
    public void format(JButton casTrampa){
        verificarOpcion();
        casTrampa.setOpaque(true);
        casTrampa.setBackground(Color.BLUE);        
        casTrampa.setText(mensaje);
        casTrampa.setToolTipText(mensaje);
        casTrampa.setForeground(Color.WHITE);        
        casTrampa.setFont(new java.awt.Font("Comic Sans MS", 0, 12));        
    }    

    public int getIdAccionTrampa() {
        return idAccion;
    }

    public void setIdAccionTrampa(int accionTrampa) {
        this.idAccion = accionTrampa;
    }
    private void verificarOpcion(){
        String opcion;
        opcion = (String) JOptionPane.showInputDialog(null,"Seleccione el tipo de accion de la casilla", "Elegir",JOptionPane.QUESTION_MESSAGE,null,DATA, DATA[0]);
        if ( opcion != null){
       //try{
            if (opcion.equalsIgnoreCase("Vaya a la carcel")) {
                idAccion = 1;
                 mensaje = "Vaya a la carcel";
                accion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese al cantidad de turnos en la carcel"));
            } else if (opcion.equalsIgnoreCase("multa")) {
                idAccion = 2;
                 mensaje = JOptionPane.showInputDialog("Ingrese su mensaje");
                accion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de multa"));
            } else if (opcion.equalsIgnoreCase("perder turno")) {
                idAccion = 3;
                 mensaje = JOptionPane.showInputDialog("Ingrese su mensaje");
                accion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de turnos a perder"));
            }
       /*}catch (Exception e){
           JOptionPane.showMessageDialog(null, "Ingreso invalido, no se guardara");
       }*/
        }else{
            mensaje = "Error, vuelva a reescribir la casilla";
        }
    }
    public JButton getCasTrampa() {
        return casTrampa;
    }

    public int getIdAccion() {
        return idAccion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public int getAccion() {
        return accion;
    }
    
}
