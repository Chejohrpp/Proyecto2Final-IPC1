/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import funcionalidades.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author chejohrpp
 */
public class DiseñoRanking extends javax.swing.JFrame {
    private AllPlayers allPlayers;
    private Ranking ranking;
    private Jugadores[] jugadores;
    private Jugadores[] jugador;
    private DefaultTableModel dfm = new DefaultTableModel();
    
    /**
     * Creates new form DiseñoRanking
     */
    public DiseñoRanking(AllPlayers allPlayers) {
        initComponents();
        this.allPlayers = allPlayers;
        this.jugadores = allPlayers.getJugadores();
        ranking = new Ranking(allPlayers.getJugadores());
        dfm = (DefaultTableModel) tableLista.getModel();
        generar(jugadores);
        desaparecer();
        jugador = jugadores;
    }
    private void desaparecer(){
        if (jugadores == null) {
            jPanel1.setVisible(false);
            jPanel2.setVisible(false);
        } else {
            jPanel1.setVisible(true);
            jPanel2.setVisible(true);
        }
    }
    private void generar(Jugadores[] jugadores){
         //Limpiar listado
       int cantRow = tableLista.getRowCount();
       //if (jugadores != null){
            //if (jugadores.length > 0 ) {
                for (int i = cantRow-1; i >= 0; i--) {
                    dfm.removeRow(i);
                }
            //}
        //}    
        //Agregar listado
        if (jugadores != null) {
            for (int i = 0; i < jugadores.length; i++) {
                String data[] = {jugadores[i].getNombre(), String.valueOf(jugadores[i].getRiquezaTotal()), perdioGano(jugadores[i])};
                dfm.addRow(data);
            }
        }

    }
    private String perdioGano(Jugadores jugador){
        if (jugador.isGanoPerdio()) {
            return "Ganador";
        }
        return "Perdedor";
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupOrdenar = new javax.swing.ButtonGroup();
        groupVer = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableLista = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        rBtnName = new javax.swing.JRadioButton();
        rBtnRich = new javax.swing.JRadioButton();
        rBtnNameD = new javax.swing.JRadioButton();
        rBtnRichD = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        rBtnWinners = new javax.swing.JRadioButton();
        rBtnLosers = new javax.swing.JRadioButton();
        rBtnAll = new javax.swing.JRadioButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 48)); // NOI18N
        jLabel1.setText("Ranking");

        tableLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Riqueza Total", "Estado"
            }
        ));
        jScrollPane1.setViewportView(tableLista);

        jLabel2.setText("Ordenar Por");

        groupOrdenar.add(rBtnName);
        rBtnName.setText("Nombre  Ascendente");
        rBtnName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtnNameActionPerformed(evt);
            }
        });

        groupOrdenar.add(rBtnRich);
        rBtnRich.setText("Riqueza  Ascendente");
        rBtnRich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtnRichActionPerformed(evt);
            }
        });

        groupOrdenar.add(rBtnNameD);
        rBtnNameD.setText("Nombre Descendente");
        rBtnNameD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtnNameDActionPerformed(evt);
            }
        });

        groupOrdenar.add(rBtnRichD);
        rBtnRichD.setText("Riqueza Descendente");
        rBtnRichD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtnRichDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rBtnName)
                            .addComponent(rBtnRich))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rBtnNameD)
                            .addComponent(rBtnRichD))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rBtnNameD)
                        .addGap(18, 18, 18)
                        .addComponent(rBtnRichD))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(rBtnName)
                        .addGap(18, 18, 18)
                        .addComponent(rBtnRich)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jLabel3.setText("Ver :");

        groupVer.add(rBtnWinners);
        rBtnWinners.setText("Gandores");
        rBtnWinners.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtnWinnersActionPerformed(evt);
            }
        });

        groupVer.add(rBtnLosers);
        rBtnLosers.setText("Perdedores");
        rBtnLosers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtnLosersActionPerformed(evt);
            }
        });

        groupVer.add(rBtnAll);
        rBtnAll.setText("Todos");
        rBtnAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtnAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(rBtnWinners))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(rBtnLosers))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(rBtnAll))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel3)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(rBtnWinners)
                .addGap(18, 18, 18)
                .addComponent(rBtnLosers)
                .addGap(18, 18, 18)
                .addComponent(rBtnAll)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        btnBack.setText("Volver");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(287, 287, 287))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rBtnNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtnNameActionPerformed
        // TODO add your handling code here:        
        generar(ranking.OrdenaNombre(jugador));
    }//GEN-LAST:event_rBtnNameActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:        
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void rBtnRichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtnRichActionPerformed
        // TODO add your handling code here:
        generar(ranking.ordenarRiqueza(jugador));
    }//GEN-LAST:event_rBtnRichActionPerformed

    private void rBtnWinnersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtnWinnersActionPerformed
        // TODO add your handling code here:
        jugador = ranking.verGanadorPerdedor(true);
        generar(jugador);
    }//GEN-LAST:event_rBtnWinnersActionPerformed

    private void rBtnLosersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtnLosersActionPerformed
        // TODO add your handling code here:
        jugador = ranking.verGanadorPerdedor(false);
        generar(jugador);
    }//GEN-LAST:event_rBtnLosersActionPerformed

    private void rBtnAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtnAllActionPerformed
        // TODO add your handling code here:
        jugador = jugadores;
        generar(jugador);
    }//GEN-LAST:event_rBtnAllActionPerformed

    private void rBtnNameDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtnNameDActionPerformed
        // TODO add your handling code here:
        generar(ranking.OrdenaNombreD(jugador));
    }//GEN-LAST:event_rBtnNameDActionPerformed

    private void rBtnRichDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtnRichDActionPerformed
        // TODO add your handling code here:
        generar(ranking.ordenarRiquezaD(jugador));
    }//GEN-LAST:event_rBtnRichDActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.ButtonGroup groupOrdenar;
    private javax.swing.ButtonGroup groupVer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rBtnAll;
    private javax.swing.JRadioButton rBtnLosers;
    private javax.swing.JRadioButton rBtnName;
    private javax.swing.JRadioButton rBtnNameD;
    private javax.swing.JRadioButton rBtnRich;
    private javax.swing.JRadioButton rBtnRichD;
    private javax.swing.JRadioButton rBtnWinners;
    private javax.swing.JTable tableLista;
    // End of variables declaration//GEN-END:variables
}
