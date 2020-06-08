/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontedPartida;

import Casillas.CasillaPropiedad;
import frontend.PartidaGUI;
import funcionalidades.*;
import javax.swing.JOptionPane;

/**
 *
 * @author chejohrpp
 */
public class VisualConstruirE extends javax.swing.JFrame {
    private Jugadores jugador;
    private Tablero[] tablero;
    private String[] grupoPropiedades;
    private int[] cantGP;
    private CasillaPropiedad propiedadConst;
    private int[] cantGPJ;
    private int costoConstruccion;
    private int casaHotel;
    
    
    
    /**
     * Creates new form VisualConstruirE
     */
    public VisualConstruirE(Jugadores jugador, Tablero[] tablero, String[] grupoPropiedades) {        
        this.jugador = jugador;
        this.tablero = tablero;        
        this.grupoPropiedades = grupoPropiedades;
        initComponents();
        lblCosotConstruccion.setVisible(false);
        verificar();
        generar();
    }
    private void generar(){
        //cuenta cuantas casilla tiene el jugador de cada grupo de propiedades
        if (jugador.getCantPropiedades() != 0) {
            cantGPJ = new int[grupoPropiedades.length];
            for (int i = 0; i < jugador.getPropiedades().length; i++) {
                CasillaPropiedad propiedad = (CasillaPropiedad) jugador.getPropiedades()[i];
                if (propiedad.getCasillaLugar() != null) {
                    for (int j = 0; j < grupoPropiedades.length; j++) {
                        if (propiedad.getCasillaLugar().getGrupoPropiedad().equalsIgnoreCase(grupoPropiedades[j])) {
                            cantGPJ[j]++;
                            //System.out.println(cantGPJ[j]);
                        }
                    }
                }
            }
            //agrega todas las propiedades del grupo completo solo si el jugador las tiene en su coleccion
            for (int i = 0; i < grupoPropiedades.length; i++) {
                if (cantGPJ[i] == cantGP[i]) {
                    for (int j = 0; j < tablero.length; j++) {
                        if (tablero[j].getCasilla() instanceof CasillaPropiedad) {
                            CasillaPropiedad propiedad = (CasillaPropiedad) tablero[j].getCasilla();
                            if (propiedad.getCasillaLugar() != null) {
                                if (propiedad.getCasillaLugar().getGrupoPropiedad().equalsIgnoreCase(grupoPropiedades[i]) && propiedad.isEstadoHipoteca() == false) {
                                    cmbContruir.addItem(propiedad.getNombre());
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    //verifica la cantidad de propiedades de cada grupo en el tablero
    private void verificar(){
        cantGP = new int[grupoPropiedades.length];
        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i].getCasilla() instanceof CasillaPropiedad) {
                CasillaPropiedad propiedad = (CasillaPropiedad) tablero[i].getCasilla();
                if (propiedad.getCasillaLugar() != null) {
                    for (int j = 0; j < grupoPropiedades.length; j++) {
                        if (propiedad.getCasillaLugar().getGrupoPropiedad().equalsIgnoreCase(grupoPropiedades[j])) {
                            cantGP[j]++;
                        }
                    }
                }
            }
        }
    }
    private int verificarLimiteCasas(String grupo){
        int cantCasas = 0;
        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i].getCasilla() instanceof CasillaPropiedad) {
                CasillaPropiedad propiedad = (CasillaPropiedad)tablero[i].getCasilla();
                if (propiedad.getCasillaLugar() != null) {
                    if (propiedad.getCasillaLugar().getGrupoPropiedad().equalsIgnoreCase(grupo)) {
                        cantCasas = cantCasas + propiedad.getCasillaLugar().getCantCasas();
                    }
                }
            }
        }
        return cantCasas;
    }
    private int verificarLimiteHoteles(String grupo){
       int cantHoteles = 0;
        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i].getCasilla() instanceof CasillaPropiedad) {
                CasillaPropiedad propiedad = (CasillaPropiedad)tablero[i].getCasilla();
                if (propiedad.getCasillaLugar() != null) {
                    if (propiedad.getCasillaLugar().getGrupoPropiedad().equalsIgnoreCase(grupo)) {
                        cantHoteles = cantHoteles + propiedad.getCasillaLugar().getCantHoteles();
                    }
                }
            }
        }
        return cantHoteles;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbContruir = new javax.swing.JComboBox<>();
        btnConstruir = new javax.swing.JButton();
        lblCosotConstruccion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 30)); // NOI18N
        jLabel1.setText("En donde desea construir");

        jLabel2.setText("Nota: solo se visualizaran las propiedades donde se puede construir");

        jLabel3.setText("Solo se puede construir cuando tienes todas las propiedades de un tipo");

        cmbContruir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbContruirActionPerformed(evt);
            }
        });

        btnConstruir.setText("Constuir");
        btnConstruir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConstruirActionPerformed(evt);
            }
        });

        lblCosotConstruccion.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblCosotConstruccion.setText("Costo de construccion : 000");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(320, 320, 320)
                        .addComponent(btnConstruir))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(lblCosotConstruccion))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(cmbContruir, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(182, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(63, 63, 63)
                .addComponent(cmbContruir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(lblCosotConstruccion)
                .addGap(32, 32, 32)
                .addComponent(btnConstruir)
                .addGap(53, 53, 53))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConstruirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConstruirActionPerformed
        // TODO add your handling code here:
        //contruye tanto casas como hoteles, dependiendo de la propiedad
        if (cmbContruir.getSelectedIndex() != -1){
            int opcion = JOptionPane.showConfirmDialog(null, "¿Seguro desea contruir esta edificacion?");
            if (opcion == JOptionPane.YES_OPTION) {
                if (jugador.getRiqueza() < costoConstruccion) {
                    JOptionPane.showMessageDialog(null, "No tiene suficiente dinero para cosntuir");
                } else {                    
                    if (casaHotel == 1) {
                        propiedadConst.getCasillaLugar().setCantCasas(propiedadConst.getCasillaLugar().getCantCasas() + 1);
                        jugador.setRiqueza(jugador.getRiqueza() - costoConstruccion);
                        jugador.setRiquezaTotal(jugador.getRiquezaTotal() - costoConstruccion);
                        JOptionPane.showMessageDialog(null, "Construido \n presione actualizar para ver si nuevo saldo");
                    } else if (casaHotel == 2) {
                        if (propiedadConst.getCasillaLugar().getCantCasas() == 0) {
                            propiedadConst.getCasillaLugar().setCantHoteles(propiedadConst.getCasillaLugar().getCantHoteles() + 1);
                            jugador.setRiqueza(jugador.getRiqueza() - costoConstruccion);
                            jugador.setRiquezaTotal(jugador.getRiquezaTotal() - costoConstruccion);
                            JOptionPane.showMessageDialog(null, "Construido \n presione actualizar para ver si nuevo saldo");
                        }else{
                            JOptionPane.showMessageDialog(null, "Tiene casas, no puede construir hoteles aqui");
                        }                        
                    }
                    
                }

            }
        } else {
            JOptionPane.showMessageDialog(null, "No ha seleccionada una propiedad");
        }   
    }//GEN-LAST:event_btnConstruirActionPerformed

    private void cmbContruirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbContruirActionPerformed
        // TODO add your handling code here:
        //busca la posicion de la propiedad de la propiedad y verificar si tiene que ser una casa u hotel el que se va a construir
        if(cmbContruir.getSelectedItem() != null){
            
            for (int i = 0; i < jugador.getPropiedades().length; i++) {
                if (cmbContruir.getSelectedItem().toString().equalsIgnoreCase(jugador.getPropiedades()[i].getNombre())) {
                    propiedadConst = jugador.getPropiedades()[i];
                    
                    if (verificarLimiteCasas(propiedadConst.getCasillaLugar().getGrupoPropiedad()) <= PartidaGUI.juegoG.getJuegoC().getGeneral().getLimiteCasas()) {
                        costoConstruccion = propiedadConst.getCasillaLugar().getPrecioCasa();
                        lblCosotConstruccion.setText("Costo de casa: "+String.valueOf(propiedadConst.getCasillaLugar().getPrecioCasa()));
                        btnConstruir.setEnabled(true);
                        casaHotel = 1;
                        
                    } else if (verificarLimiteHoteles(propiedadConst.getCasillaLugar().getGrupoPropiedad()) <= PartidaGUI.juegoG.getJuegoC().getGeneral().getLimiteHoteles()) {
                        costoConstruccion = propiedadConst.getCasillaLugar().getPrecioHotel();
                         lblCosotConstruccion.setText("Costo del hotel: "+String.valueOf(propiedadConst.getCasillaLugar().getPrecioHotel()));
                         btnConstruir.setEnabled(true);
                         casaHotel = 2;
                         
                    } else {
                        lblCosotConstruccion.setText("No se puede construir mas en esa propiedad");
                        btnConstruir.setEnabled(false);
                    }

                    lblCosotConstruccion.setVisible(true);
                }
            }
            
        }   
    }//GEN-LAST:event_cmbContruirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConstruir;
    private javax.swing.JComboBox<String> cmbContruir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblCosotConstruccion;
    // End of variables declaration//GEN-END:variables
}
