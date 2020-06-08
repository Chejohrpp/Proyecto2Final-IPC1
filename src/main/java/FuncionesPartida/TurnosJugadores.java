/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FuncionesPartida;

import funcionalidades.*;
import java.io.Serializable;
import Casillas.*;
import Tarjetas.*;
import static frontend.PartidaGUI.juegoG;
import javax.swing.JOptionPane;

/**
 *
 * @author chejohrpp
 */
public class TurnosJugadores implements Serializable {
  private int posicion;
  private Tablero[] tablero;
  private int cantPropiedades;
  private CasillaPropiedad[] propiedades;
  private Jugadores[] jugadores;
  
  
  public TurnosJugadores(Tablero[] tablero, Jugadores jugador, Jugadores[] jugadores){
      this.posicion = jugador.getPosicioTablero();
      this.tablero = tablero;   
      this.propiedades = jugador.getPropiedades();
      this.cantPropiedades = jugador.getCantPropiedades();
      this.jugadores = jugadores;
  }
  //verificar si el jugador esta en una casilla de propiedad y ve si se puede comprar
  public void comprarPropiedad(Jugadores jugador){
      //System.out.println(tablero[posicion].getCasilla().getClass());      
      if (tablero[posicion].getCasilla() instanceof CasillaPropiedad) {
         CasillaPropiedad propiedad = (CasillaPropiedad) tablero[posicion].getCasilla();
          if (propiedad.isTieneDueño() == false) {            
            if(jugador.getRiqueza() > propiedad.getCosto()){
                int opcion = JOptionPane.showConfirmDialog(null, "Deseas comprar esta Propiedad? por $"+ propiedad.getCosto());
                if (opcion == JOptionPane.YES_OPTION) {
                    jugador.setRiqueza(jugador.getRiqueza()-propiedad.getCosto());
                    //jugador.setRiquezaTotal(jugador.getRiquezaTotal() + propiedad.getCosto());
                    JOptionPane.showMessageDialog(null, "Comprado");
                    propiedad.setTieneDueño(true);
                    propiedad.setNombreDueño(jugador.getColorFicha());
                    cantPropiedades++;
                    redimensionar(jugador);
                    if (propiedad.getCasillaEstacion() != null) {
                        jugador.setCantEstacion(jugador.getCantEstacion() + 1);
                    } else if (propiedad.getCasillaServicio() != null) {
                        jugador.setCantServiciosB(jugador.getCantServiciosB() + 1);
                    }
                } 
            } else {
                JOptionPane.showMessageDialog(null, "No tiene la cantidad suficiente");
            }
          } else if (propiedad.isEstadoHipoteca() == false && jugador.getColorFicha().equalsIgnoreCase(propiedad.getNombreDueño()) == false) {
              
              if (propiedad.getCasillaEstacion() != null) {
                  
                  int cantEstacion = cantEstacion(propiedad);
                  int costo = 0;
                  if (cantEstacion == 1) {
                      costo = propiedad.getCasillaEstacion().getCostoUsoE() ;
                  }else{
                      costo = propiedad.getCasillaEstacion().getCostoUsoE() * 2 * (cantEstacion-1);
                  }   
                  JOptionPane.showMessageDialog(null, "Caistes en una Estacion con dueño, le tienes que pagar $"+ costo);
                  
                  buscarJugador(propiedad, costo);
                  jugador.setRiqueza(jugador.getRiqueza()-costo);
                  jugador.setRiquezaTotal(jugador.getRiquezaTotal() - costo);
                  
                  
              } else if (propiedad.getCasillaLugar() != null) {
                 int costo = propiedad.getCasillaLugar().getCostoEstancia() + propiedad.getCasillaLugar().getCantCasas()* propiedad.getCasillaLugar().getCostoEstanciaCasa() + 
                          propiedad.getCasillaLugar().getCantHoteles()* propiedad.getCasillaLugar().getConstoEstanciaHotel();
                  JOptionPane.showMessageDialog(null, "Caistes en una propiedad con dueño, le tienes que pagar $"+ costo);
                  
                  buscarJugador(propiedad, costo);                  
                  jugador.setRiqueza(jugador.getRiqueza()- costo);
                  jugador.setRiquezaTotal(jugador.getRiquezaTotal() - costo);
                  
                  
              } else if (propiedad.getCasillaServicio() != null) {                  
                  int cantServicio = cantServicioB(propiedad);
                  int costo = propiedad.getCasillaServicio().getCostoServicio() * cantServicio;
                  JOptionPane.showMessageDialog(null, "Caistes en una servicio basico con dueño, le tienes que pagar $"+ costo);
                  buscarJugador(propiedad, costo);
                  jugador.setRiqueza(jugador.getRiqueza()-costo);
                  jugador.setRiquezaTotal(jugador.getRiquezaTotal() - costo);
              }
          }

      }
  }
  //redimensiona las propiedades del jugador cuando compra una nueva
  private void redimensionar(Jugadores jugador){
      if (jugador.getCantPropiedades() == 0) {
          propiedades  = new CasillaPropiedad[1];
          propiedades[0] = (CasillaPropiedad) tablero[posicion].getCasilla();          
      } else{
          CasillaPropiedad[] propiedad = new CasillaPropiedad[propiedades.length];
          for (int i = 0; i < propiedades.length; i++) {
              propiedad[i] = propiedades[i];
          }
          propiedades = new CasillaPropiedad[cantPropiedades];
          for (int i = 0; i < propiedad.length; i++) {
              propiedades[i] = propiedad[i];
          }
          propiedades[cantPropiedades-1] = (CasillaPropiedad) tablero[posicion].getCasilla();
      }
      
      jugador.setCantPropiedades(cantPropiedades);
      jugador.setPropiedades(propiedades);
  }
  public void verificarEstanciaPropiedades(Jugadores jugador){
      
  }
  //busca al jugar y le da 
  private void buscarJugador(CasillaPropiedad propiedad, int cantidad){
      for (int i = 0; i < jugadores.length; i++) {
          if (jugadores[i].getColorFicha().equalsIgnoreCase(propiedad.getNombreDueño())) {
              jugadores[i].setRiqueza(jugadores[i].getRiqueza()+cantidad);
              jugadores[i].setRiquezaTotal(jugadores[i].getRiquezaTotal() + cantidad);
          }
      }
  }
  //retorna la cantidad de estacion del jugador al que le tienen que pagar
  private int cantEstacion(CasillaPropiedad propiedad){
      for (Jugadores jugadore : jugadores) {
          if (jugadore.getColorFicha().equalsIgnoreCase(propiedad.getNombreDueño())) {
              return jugadore.getCantEstacion();
          }
      }
      return 0;
  }
  //retortna la cantidad de sevicios del jugador que tienes que pgar
  private int cantServicioB(CasillaPropiedad propiedad){
      for (Jugadores jugadore : jugadores) {
          if (jugadore.getColorFicha().equalsIgnoreCase(propiedad.getNombreDueño())) {
              return jugadore.getCantServiciosB();
          }
      }
      return 0;
  }
  //verificar si aun tiene riqueza total o sino se sale del juejo, entra en bancarrota
  public boolean verificarRiquezaTotal(Jugadores jugador){
      return (jugador.getRiquezaTotal() <= 0);
  }
  //revisa si cayo en una casiila tipo tarjeta
  public void tarjetas(Jugadores jugador){
      if (tablero[posicion].getCasilla() instanceof CasillaTarjeta) {
          CasillaTarjeta casilla = (CasillaTarjeta) tablero[posicion].getCasilla();          
          JOptionPane.showMessageDialog(null, "Mensaje tarjeta " + casilla.getGrupoTT());
          
          TarjetasPro tarjeta = tomarPrimeraTarjeta();
          JOptionPane.showMessageDialog(null, tarjeta.getMensaje());
          if (tarjeta != null){
          
            if (tarjeta instanceof TarjetaCaminar) {
                TarjetaCaminar tarjetaN = (TarjetaCaminar) tarjeta;
                caminar(jugador,tarjetaN.getAccion());

            } else if (tarjeta instanceof TarjetaMoverCasilla) {
                TarjetaMoverCasilla tarjetaN = (TarjetaMoverCasilla) tarjeta;
                moverCasilla(jugador,tarjetaN.getAccion());

            } else if (tarjeta instanceof TarjetaPersonalizada) {
                TarjetaPersonalizada tarjetaN = (TarjetaPersonalizada) tarjeta;
                personalizada(tarjetaN,jugador);

            } else if (tarjeta instanceof TarjetaPremio) {
                TarjetaPremio tarjetaN = (TarjetaPremio) tarjeta;
                premio(jugador,tarjetaN.getAccion());

            } else if (tarjeta instanceof TarjetaVayaCarcel) {
                TarjetaVayaCarcel tarjetaN = (TarjetaVayaCarcel) tarjeta;
                vayaCarcel(jugador,tarjetaN.getAccion());

            } else if (tarjeta instanceof TarjetaPagoJugadores) {
                TarjetaPagoJugadores tarjetaN = (TarjetaPagoJugadores) tarjeta;
                pagoJugadores(jugador,tarjetaN.getAccion());

            } else if (tarjeta instanceof TarjetaMulta) {
                TarjetaMulta tarjetaN = (TarjetaMulta) tarjeta;
                multa(jugador,tarjetaN.getAccion());

            } else if (tarjeta instanceof TarjetaPerderTurno) {
                TarjetaPerderTurno tarjetaN = (TarjetaPerderTurno) tarjeta;
                perderTurno(jugador,tarjetaN.getAccion());              
            }
            if (tarjeta instanceof TarjetaSalgaCarcel) {
                salgaCarcel(jugador);
            } else {
                regresarTarjeta(tarjeta);
            }
          } else {
              JOptionPane.showMessageDialog(null, "No hay tarjetas en este grupo");
          }
      }
  }
  
  private TarjetasPro tomarPrimeraTarjeta(){
      return null;
  }
  private void regresarTarjeta(TarjetasPro tarjeta){
      
  }
  public void trampa(Jugadores jugador){
      if (tablero[posicion].getCasilla() instanceof CasillaTrampa) {
          CasillaTrampa trampa = (CasillaTrampa) tablero[posicion].getCasilla();
          JOptionPane.showMessageDialog(null, trampa.getMensaje());
          switch (trampa.getIdAccion()) {
              case 1:
                  {
                      int accion = trampa.getAccion();
                      vayaCarcel(jugador,accion);
                      break;
                  }
              case 2:
                  {
                      int accion = trampa.getAccion();
                      multa(jugador,accion);
                      break;
                  }
              case 3:
                  {
                      int accion = trampa.getAccion();
                      perderTurno(jugador,accion);
                      break;
                  }
              default:
                  break;
          }
      }
  }
  private void vayaCarcel(Jugadores jugador, int accion){
      //JOptionPane.showMessageDialog(null, mensaje);      
      int adelante = posicion;
      int atras = posicion;
      for (int i = 0; i < ((tablero.length)/2) + 1; i++) {          
          if (adelante == tablero.length) {
              adelante = 0;
          }
          if (atras == -1) {
              atras = tablero.length-1;
          }
          if (tablero[adelante].getCasilla() instanceof CasillaCarcel) {
              jugador.setPosicioTablero(adelante);
              perderTurno(jugador, accion);
              break;
          } 
          if (tablero[atras].getCasilla() instanceof CasillaCarcel) {
              jugador.setPosicioTablero(atras);
              perderTurno(jugador,accion);
              break;
          }
          adelante++;
          atras--;
      }
  }
  private void multa(Jugadores jugador, int accion){
      //JOptionPane.showMessageDialog(null,"presiona actualizar para ver su nuevo saldo");
      jugador.setRiqueza(jugador.getRiqueza() - accion);
      jugador.setRiquezaTotal(jugador.getRiquezaTotal() - accion);
  }
  private void perderTurno(Jugadores jugador, int accion){
      //JOptionPane.showMessageDialog(null, mensaje);
      jugador.setEstadoTrampa(true);
      jugador.setMostrarEstado(accion + " turno perdidos");
      jugador.setTurnoPerdidos(accion);
  }
  private void caminar(Jugadores jugador, int accion){
      //JOptionPane.showMessageDialog(null, mensaje);
      moverJugador(jugador,accion);
  }
  private void moverJugador(Jugadores jugador, int accion){       
        for (int i = 0; i < accion; i++) {
            if (jugador.getPosicioTablero() == (tablero.length-1)) {
                jugador.setPosicioTablero(0);
                JOptionPane.showMessageDialog(null, "Aqui tienes "+ juegoG.getJuegoC().getGeneral().getCantVuelta() + " por haber pasado al inicio");
                jugador.setRiqueza(jugador.getRiqueza() + juegoG.getJuegoC().getGeneral().getCantVuelta());
                jugador.setRiquezaTotal(jugador.getRiquezaTotal() + juegoG.getJuegoC().getGeneral().getCantVuelta());
            } else{
                 jugador.setPosicioTablero(jugador.getPosicioTablero()+1);
            }
        }
    }
  private void moverCasilla(Jugadores jugador, int accion){
      //JOptionPane.showMessageDialog(null, mensaje);
      jugador.setPosicioTablero(accion-1);
  }
  private void pagoJugadores(Jugadores jugador, int accion){
      for (int i = 0; i < jugadores.length; i++) {
          if (jugadores[i].getColorFicha().equalsIgnoreCase(jugador.getColorFicha()) == false) {
              jugadores[i].setRiqueza(jugadores[i].getRiqueza() + accion);
              jugadores[i].setRiquezaTotal(jugadores[i].getRiquezaTotal() + accion);
              jugador.setRiqueza(jugador.getRiqueza() - accion);
              jugador.setRiquezaTotal(jugador.getRiquezaTotal() - accion);
          }
      }
  }
  private void personalizada(TarjetaPersonalizada personalizada, Jugadores jugador){
      //JOptionPane.showMessageDialog(null, personalizada.getMensaje());
      if (personalizada.isCaminar()) {
          caminar(jugador,personalizada.getIntCaminar());
      }
      if (personalizada.isMover()) {
          moverCasilla(jugador,personalizada.getIntMover());
      }
      if (personalizada.isMulta()) {
          multa(jugador,personalizada.getIntMulta());
      }
      if (personalizada.isPagoJugadores()) {
          pagoJugadores(jugador, personalizada.getIntPagoJugadores());
      }
      if (personalizada.isPremio()) {
          premio(jugador, personalizada.getIntPremio());
      }
      if (personalizada.isPerderTurno()) {
          perderTurno(jugador,personalizada.getIntPerderTurno());
      }
      if (personalizada.isVayaCarcel()) {
          vayaCarcel(jugador,1);
      }
  }
  private void premio(Jugadores jugador, int accion){
      //JOptionPane.showMessageDialog(null, mensaje);
      jugador.setRiqueza(jugador.getRiqueza() + accion);
      jugador.setRiquezaTotal(jugador.getRiquezaTotal() + accion);
  }
  private void salgaCarcel(Jugadores jugador){
      jugador.setTarjetasSalgaCarcel(jugador.getTarjetasSalgaCarcel()+1);
  }
   
}
