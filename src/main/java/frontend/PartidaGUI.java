/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import Excepciones.Exceptions;
import FuncionesPartida.*;
import LecturaYEscritura.RnWJugar;
import LecturaYEscritura.RnWRanking;
import frontedPartida.*;
import funcionalidades.*;
import java.awt.Component;
import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import static javax.swing.JFileChooser.APPROVE_OPTION;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author chejohrpp
 */
public class PartidaGUI extends javax.swing.JFrame {
    public final int ESPACIO_PIXELES = 126;
    public final int ESPACIO_INTERMEDIO = 2;
    //JuegoBoard juegoC;
    private Tablero[] tablero;
    public static JuegoGame juegoG;
    private Jugadores[] jugador;
    private DefaultTableModel dfm = new DefaultTableModel();
    public static boolean estadoTiempo;
    private Tiempo tiempo;
    private int controlJ = 0;
    private int vecesLanzados;
    private FichasJugadores[] fichas;
    
    /**
     * Creates new form TableroVisual
     */
    public PartidaGUI(JuegoBoard juegoC, JuegoGame juegoG) {
        initComponents();
        fullScreen();        
        toolSize();
        limpiar();
        this.juegoG = juegoG;
        this.juegoG.setJuegoC(juegoC);
        this.tablero = this.juegoG.getJuegoC().getTablero();
        this.estadoTiempo = juegoG.isEstado();
        dfm = (DefaultTableModel) tableLista.getModel();
        panel1.setSize(juegoC.getLargo()*ESPACIO_PIXELES + ESPACIO_INTERMEDIO*juegoC.getLargo(), juegoC.getAlto()*ESPACIO_PIXELES + ESPACIO_INTERMEDIO*juegoC.getAlto());         
        NuevaPartida nuevaPartida = new NuevaPartida();       
        this.jugador = new Jugadores[juegoG.getJuegoC().getGeneral().getCantJugadores()];
        this.jugador =  nuevaPartida.RevolverJugadores(juegoG.getDatosPrePartida().getJugador());          
        agregarCantInicial();        
        generarJugadores();
        tiempo(juegoG);   
        mostrarFichas(panel1);
        generarTablero(panel1);  
    }
    public PartidaGUI(JuegoGame juegoG) {
        initComponents();
        fullScreen();        
        toolSize();
        limpiar();
        this.juegoG = juegoG;
        this.tablero = juegoG.getJuegoC().getTablero();
        this.jugador = juegoG.getDatosPrePartida().getJugador();
        this.controlJ = juegoG.getControlJ();
        dfm = (DefaultTableModel) tableLista.getModel();
        panel1.setSize(juegoG.getJuegoC().getLargo()*ESPACIO_PIXELES + ESPACIO_INTERMEDIO*juegoG.getJuegoC().getLargo(), juegoG.getJuegoC().getAlto()*ESPACIO_PIXELES + ESPACIO_INTERMEDIO*juegoG.getJuegoC().getAlto());
        estadoTiempo = true;
        generarJugadores();
        tiempo(juegoG);   
        mostrarFichas(panel1);
        generarTablero(panel1);        
    }
    public void fullScreen(){
        //this.setUndecorated(true);
        //this.setAlwaysOnTop(true);
        btnOpTarjetaCarcel.setVisible(false);
        this.setResizable(false);
        this.setVisible(true);
    }
    private void toolSize(){
        Toolkit tk = Toolkit.getDefaultToolkit();
        int largo = (int) tk.getScreenSize().getWidth();
        int alto = (int) tk.getScreenSize().getHeight();
        this.setSize(largo, alto);
    }    
    private void generarTablero(Container pane){
         Component[] componentes = pane.getComponents();
        for (Component componente : componentes) {
            if (componente instanceof JButton) {
                pane.remove(componente);
                pane.revalidate();
                pane.repaint();
            }
        }
        for (int i = 0; i < tablero.length; i++) {
            pane.add(tablero[i].getBoton());
        }
    }
    private void generarJugadores(){           
        //Limpiar listado
       int cantRow = tableLista.getRowCount();
        if (cantRow > 1 ) {
            for (int i = cantRow-1; i >= 0; i--) {
                dfm.removeRow(i);
            }
        }        
        //Agregar listado
        for (int i = 0; i < jugador.length; i++) {
            String[] data = {jugador[i].getNombre(), String.valueOf(jugador[i].getRiqueza()), jugador[i].getColorFicha(), jugador[i].getMostrarEstado()};
            //System.out.println(jugador[i].getNombre());
            dfm.addRow(data);
        }
        
    }
    private void mostrarFichas(Container pane){
        Component[] componentes = pane.getComponents();
        for (Component componente : componentes) {
            if (componente instanceof JLabel) {
                pane.remove(componente);
                pane.revalidate();
                pane.repaint();
            }
        }
        fichas = new FichasJugadores[jugador.length];
        for (int i = 0; i < jugador.length; i++) {
            FichasJugadores ficha = new FichasJugadores(jugador[i], tablero);            
            pane.add(ficha.getLabel());
            ficha.format(i);  
            fichas[i] = ficha;
       
        }
    }    
    private void agregarCantInicial(){
        for (int i = 0; i < jugador.length; i++) {
            jugador[i].setRiqueza(jugador[i].getRiqueza()+juegoG.getJuegoC().getGeneral().getCantInicial());
            jugador[i].setRiquezaTotal(jugador[i].getRiquezaTotal() + jugador[i].getRiqueza());
        }
    }
    private void tiempo(JuegoGame juegoG){
        if (juegoG.getDatosPrePartida().getCantTiempo() == 0 && juegoG.isEstado() && juegoG.getTiempoF() == 0 ) {
            Tiempo tiempo = new Tiempo(0, lblTime, true,jugador);
            this.tiempo = tiempo;
            this.tiempo.start();
            juegoG.setFormaTiempo(true);
            
        } else if (juegoG.getDatosPrePartida().getCantTiempo() != 0 && juegoG.isEstado() && juegoG.getTiempoF() == 0) {
            
            Tiempo tiempo = new Tiempo(juegoG.getDatosPrePartida().getCantTiempo()*60, lblTime, false,jugador);
            this.tiempo = tiempo;
            this.tiempo.start();
            juegoG.setFormaTiempo(false);
            
        } else if (juegoG.isFormaTiempo() && juegoG.getTiempoF() > 0) {
            Tiempo tiempo = new Tiempo(juegoG.getTiempoF(), lblTime, true,jugador);
            this.tiempo = tiempo;
            this.tiempo.start();
            juegoG.setFormaTiempo(true);       
            
        } else if (juegoG.isFormaTiempo() == false && juegoG.getTiempoF() > 0) {
            Tiempo tiempo = new Tiempo(juegoG.getTiempoF(), lblTime, false,jugador);
            this.tiempo = tiempo;
            this.tiempo.start();
            juegoG.setFormaTiempo(false); 
        }
    }
//    private Jugadores buscarJugador(){
//        for (int i = 0; i < jugador.length; i++) {
//            if (jugador[i].isEstado()) {
//                return jugador[i];
//            }
//        }
//        return null;
//    }
    private void buscarSiguienteJugador(){        
        while(true){
            controlJ++;
            if (controlJ == jugador.length) {
                controlJ = 0;
            }
            if (jugador[controlJ].getMostrarEstado().equalsIgnoreCase("")) {               
                jugador[controlJ].setEstado(true);
                jugador[controlJ].setMostrarEstado("Tu turno");
                break;
            }
            if (jugador[controlJ].isEstadoTrampa()) {
                jugador[controlJ].setTurnoPerdidos(jugador[controlJ].getTurnoPerdidos()- 1);
                if (jugador[controlJ].getTurnoPerdidos() == 0) {
                    jugador[controlJ].setMostrarEstado("");
                    jugador[controlJ].setEstadoTrampa(false);
                    jugador[controlJ].setEstado(false);
                } else {
                    jugador[controlJ].setMostrarEstado(jugador[controlJ].getTurnoPerdidos()+" turnos perdidos");
                }
            }
        }

    }
    private void verificarCantJugadores(){
        int canJugadoresActivos = 0;
        int posicionGanador = 0;
        String nombreJugador = "";
        for (int i = 0; i < jugador.length; i++) {
            if (jugador[i].getMostrarEstado().equalsIgnoreCase("") || jugador[i].isEstadoTrampa() == true) {
                canJugadoresActivos++;
                posicionGanador = i;
                nombreJugador = jugador[i].getNombre();
            }
        }
        if (canJugadoresActivos == 1) {
            //JOptionPane.showMessageDialog(null, "Felicidades " + nombreJugador + " ganastes");
            jugador[posicionGanador].setGanoPerdio(true);            
            terminarJuego(jugador[posicionGanador].getNombre());            
            //bloquear();
            //cerrar();
        } else if (canJugadoresActivos == 0) {
            System.out.println("Error de jugadores Activos");
        } else{            
            buscarSiguienteJugador();
        }
    }
    
    private void bloquear(){
        btnDados.setEnabled(false);
        btnVProiedad.setEnabled(false);
        btnHPropiedad.setEnabled(false);
        btnBEdificios.setEnabled(false);
        btnBancarrota.setEnabled(false);
        btnTerminarTurno.setEnabled(false);
        estadoTiempo = false;
        btnGuardar.setEnabled(false);
        btnTerminarJuego.setEnabled(false);
        guardar();
    }
    private void guardar(){
        RnWRanking guardarRanking = new RnWRanking();
        Welcome.allPlayers.verificar(jugador);
        try{
            guardarRanking.WriteRanking("Ranking.rkg", Welcome.allPlayers);
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private void limpiar(){
        lblDado1.setText("          ");
        lblDado2.setText("          ");
        lblDado3.setText("          ");
        lblTotal.setText("          ");
         btnDados.setEnabled(true);
        btnVProiedad.setEnabled(true);
        btnHPropiedad.setEnabled(true);
        btnBEdificios.setEnabled(true);
        btnBancarrota.setEnabled(true);
        btnTerminarTurno.setEnabled(true);
    }
    private void moverJugador(int total){       
        for (int i = 0; i < total; i++) {
            if (jugador[controlJ].getPosicioTablero() == (tablero.length-1)) {
                jugador[controlJ].setPosicioTablero(0);
                JOptionPane.showMessageDialog(null, "Aqui tienes "+ juegoG.getJuegoC().getGeneral().getCantVuelta() + " por haber pasado al inicio");
                jugador[controlJ].setRiqueza(jugador[controlJ].getRiqueza() + juegoG.getJuegoC().getGeneral().getCantVuelta());
                jugador[controlJ].setRiquezaTotal(jugador[controlJ].getRiquezaTotal() + juegoG.getJuegoC().getGeneral().getCantVuelta());
            } else{
                 jugador[controlJ].setPosicioTablero(jugador[controlJ].getPosicioTablero()+1);
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableLista = new javax.swing.JTable();
        btnTerminarJuego = new javax.swing.JButton();
        lblTime = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnDados = new javax.swing.JButton();
        btnVProiedad = new javax.swing.JButton();
        btnHPropiedad = new javax.swing.JButton();
        btnBEdificios = new javax.swing.JButton();
        btnBancarrota = new javax.swing.JButton();
        btnTerminarTurno = new javax.swing.JButton();
        lblDado1 = new javax.swing.JLabel();
        lblDado2 = new javax.swing.JLabel();
        lblDado3 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        btnVerFichas = new javax.swing.JButton();
        btnOpTarjetaCarcel = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnRecuperarPropiedades = new javax.swing.JButton();
        btnVenderEdificios = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 632, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btnGuardar.setText("Guardar Partida");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        tableLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Dinero", "Color", "Estado"
            }
        ));
        jScrollPane1.setViewportView(tableLista);

        btnTerminarJuego.setText("Terminar Juego");
        btnTerminarJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminarJuegoActionPerformed(evt);
            }
        });

        lblTime.setText("Contador:");

        btnDados.setText("Girar Dados");
        btnDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDadosActionPerformed(evt);
            }
        });

        btnVProiedad.setText("Visualizar Mis Propiedades");
        btnVProiedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVProiedadActionPerformed(evt);
            }
        });

        btnHPropiedad.setText("Hipotecar Propiedad");
        btnHPropiedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHPropiedadActionPerformed(evt);
            }
        });

        btnBEdificios.setText("Construir Edificios");
        btnBEdificios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBEdificiosActionPerformed(evt);
            }
        });

        btnBancarrota.setText("Declarse en Bancarrota");
        btnBancarrota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBancarrotaActionPerformed(evt);
            }
        });

        btnTerminarTurno.setText("Terminar Turno");
        btnTerminarTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminarTurnoActionPerformed(evt);
            }
        });

        lblDado1.setText("Dado 1");

        lblDado2.setText("Dado 2");

        lblDado3.setText("Dado 3");

        lblTotal.setText("Total:");

        btnVerFichas.setText("Ver fichas");
        btnVerFichas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerFichasActionPerformed(evt);
            }
        });

        btnOpTarjetaCarcel.setText("Opciones tarjeta Carcel");
        btnOpTarjetaCarcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpTarjetaCarcelActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnRecuperarPropiedades.setText("Recuperar propiedades");
        btnRecuperarPropiedades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecuperarPropiedadesActionPerformed(evt);
            }
        });

        btnVenderEdificios.setText("Vender Edificios");
        btnVenderEdificios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVenderEdificiosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnBancarrota, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                                .addComponent(btnTerminarTurno, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnVProiedad)
                                .addGap(18, 18, 18)
                                .addComponent(lblDado2))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnBEdificios, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblTotal))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnHPropiedad, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(lblDado3)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(btnDados, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblDado1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnVerFichas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOpTarjetaCarcel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRecuperarPropiedades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVenderEdificios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDados)
                        .addComponent(lblDado1))
                    .addComponent(btnVerFichas))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnVProiedad)
                        .addComponent(lblDado2))
                    .addComponent(btnActualizar))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnHPropiedad)
                            .addComponent(btnRecuperarPropiedades)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblDado3)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBEdificios)
                        .addComponent(lblTotal))
                    .addComponent(btnVenderEdificios))
                .addGap(22, 22, 22)
                .addComponent(btnBancarrota)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTerminarTurno)
                    .addComponent(btnOpTarjetaCarcel))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(lblTime)
                            .addGap(2, 2, 2)
                            .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnTerminarJuego)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnGuardar))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTerminarJuego)
                            .addComponent(btnGuardar)
                            .addComponent(btnSalir)
                            .addComponent(lblTime))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTerminarJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminarJuegoActionPerformed
        // TODO add your handling code here:        
        terminoTiempo();
        
    }//GEN-LAST:event_btnTerminarJuegoActionPerformed

    private void terminarJuego(String winner){
        VisualTerminarJuego terminar = new VisualTerminarJuego(winner);        
        bloquear();
        this.setVisible(false);
        terminar.setLocationRelativeTo(null);
        terminar.setVisible(true);
    }
    private void terminoTiempo(){
        VerificarGanador ganador = new VerificarGanador(jugador);
        String winner = ganador.obtenerGanadorYa();
        terminarJuego(winner);
    }
    private void btnBancarrotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBancarrotaActionPerformed
        // TODO add your handling code here:
        jugador[controlJ].setEstado(false);
        jugador[controlJ].setMostrarEstado("Bancarrota");
        JOptionPane.showMessageDialog(null,"Ha sido Declarado en Bancarrota, sale del juego"); 
        vecesLanzados = 0;
        Bancarrota bancarrota = new Bancarrota(jugador[controlJ]);
        bancarrota.quitarTodo();
        limpiar();
        verificarCantJugadores();
        generarJugadores();
    }//GEN-LAST:event_btnBancarrotaActionPerformed

    private void btnTerminarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminarTurnoActionPerformed
        // TODO add your handling code here:
        jugador[controlJ].setEstado(false);
        jugador[controlJ].setMostrarEstado("");
        vecesLanzados = 0;
        limpiar();
        verificarCantJugadores();
        generarJugadores();
    }//GEN-LAST:event_btnTerminarTurnoActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        Welcome welcome = new Welcome();
        this.dispose();
        welcome.setLocationRelativeTo(null);
        welcome.setVisible(true);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDadosActionPerformed
        // TODO add your handling code here:
        int total = 0;
        GirarDados girarDados = new GirarDados(lblDado1, lblDado2, lblDado3, juegoG.getJuegoC().getGeneral().getCantDados(), vecesLanzados);        
        try {
            girarDados.sumarDados(total);
        } catch (InterruptedException ex) {
            Logger.getLogger(PartidaGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        total = girarDados.totals();
        lblTotal.setText("Total : " + total);
        moverJugador(total);
        mostrarFichas(panel1);
        generarTablero(panel1);
        if (girarDados.isVerificarLanzamiento() && vecesLanzados < 4) {
            btnDados.setEnabled(true);
        } else if (girarDados.isVerificarLanzamiento() == false){
            btnDados.setEnabled(false);
        } else if (vecesLanzados == 3) {
            JOptionPane.showMessageDialog(null, "Se va a la Carcel");
            
            btnDados.setEnabled(false);
        }
        
        TurnosJugadores accionesJugador = new TurnosJugadores(tablero,jugador[controlJ], jugador);
        accionesJugador.comprarPropiedad(jugador[controlJ]);
        accionesJugador.trampa(jugador[controlJ]);
        accionesJugador.tarjetas(jugador[controlJ]);   
        
        mostrarFichas(panel1);
        generarTablero(panel1);
        generarJugadores();
    }//GEN-LAST:event_btnDadosActionPerformed

    private void btnVProiedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVProiedadActionPerformed
        // TODO add your handling code here:
        VisualPropiedades propiedad = new VisualPropiedades(jugador[controlJ]);
        propiedad.setLocationRelativeTo(null);
        propiedad.setVisible(true);
    }//GEN-LAST:event_btnVProiedadActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        RnWJugar saveGameG = new RnWJugar();
        estadoTiempo = false;
        juegoG.getDatosPrePartida().setJugador(jugador);
        juegoG.setControlJ(controlJ);     
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Juego .game", "game"));
            fileChooser.setAcceptAllFileFilterUsed(false);
            int seleccion = fileChooser.showSaveDialog(this);
            if (seleccion == APPROVE_OPTION) {
                saveGameG.WriteGameG(fileChooser.getSelectedFile().getPath()+".game", juegoG);
                JOptionPane.showMessageDialog(null, "Se ha Guardado correctamente los datos");
                cerrar();                
            }
        } catch (HeadlessException | Exceptions e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Info", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnVerFichasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerFichasActionPerformed
        // TODO add your handling code here:
        mostrarFichas(panel1);
        generarTablero(panel1);
    }//GEN-LAST:event_btnVerFichasActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        mostrarFichas(panel1);
        generarTablero(panel1);
        generarJugadores();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnHPropiedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHPropiedadActionPerformed
        // TODO add your handling code here:
        VisualHipotecarP hipoteca = new VisualHipotecarP(jugador[controlJ], tablero,juegoG.getJuegoC().getGruposPropiedad());
        hipoteca.setLocationRelativeTo(null);
        hipoteca.setVisible(true);
    }//GEN-LAST:event_btnHPropiedadActionPerformed

    private void btnBEdificiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBEdificiosActionPerformed
        // TODO add your handling code here:
        VisualConstruirE cosntruir = new VisualConstruirE(jugador[controlJ], tablero, juegoG.getJuegoC().getGruposPropiedad());
        cosntruir.setLocationRelativeTo(null);
        cosntruir.setVisible(true);
    }//GEN-LAST:event_btnBEdificiosActionPerformed

    private void btnRecuperarPropiedadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecuperarPropiedadesActionPerformed
        // TODO add your handling code here:
        VisualRecuperar recuperar = new VisualRecuperar(jugador[controlJ]);
        recuperar.setLocationRelativeTo(null);
        recuperar.setVisible(true);
        
    }//GEN-LAST:event_btnRecuperarPropiedadesActionPerformed

    private void btnVenderEdificiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVenderEdificiosActionPerformed
        // TODO add your handling code here:
        VisualVenderE vender = new VisualVenderE(jugador[controlJ]);
        vender.setLocationRelativeTo(null);
        vender.setVisible(true);
    }//GEN-LAST:event_btnVenderEdificiosActionPerformed

    private void btnOpTarjetaCarcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpTarjetaCarcelActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnOpTarjetaCarcelActionPerformed

    //regresamos a inicio
    private void cerrar(){
        this.setVisible(false);
        Welcome welcome = new Welcome();
        welcome.setLocationRelativeTo(null);
        welcome.setVisible(true);
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBEdificios;
    private javax.swing.JButton btnBancarrota;
    private javax.swing.JButton btnDados;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnHPropiedad;
    private javax.swing.JButton btnOpTarjetaCarcel;
    private javax.swing.JButton btnRecuperarPropiedades;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnTerminarJuego;
    private javax.swing.JButton btnTerminarTurno;
    private javax.swing.JButton btnVProiedad;
    private javax.swing.JButton btnVenderEdificios;
    private javax.swing.JButton btnVerFichas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDado1;
    private javax.swing.JLabel lblDado2;
    private javax.swing.JLabel lblDado3;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel panel1;
    private javax.swing.JTable tableLista;
    // End of variables declaration//GEN-END:variables
}
