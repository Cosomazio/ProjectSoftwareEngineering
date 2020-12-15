/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.plannerInterface;

import deposito.EwoActivity;
import deposito.Planner;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author franc
 */
public class ViewEwoInterface extends javax.swing.JFrame {
    private Planner planner;
    private JFrame parent;

    /**
     * Creates new form ViewEwoInterface
     */
    public ViewEwoInterface() {
        initComponents();
    }
    public ViewEwoInterface(JFrame parent, Planner planner){
        this();
        this.planner=planner;
        this.parent=parent;
        this.aggiornaTabella();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtWeek = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        txtDay = new javax.swing.JTextField();
        txtDayW = new javax.swing.JTextField();
        lblass = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEwo = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblState = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtWeek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWeekActionPerformed(evt);
            }
        });

        jTextField1.setEditable(false);
        jTextField1.setText("Week n°");

        lblass.setBackground(new java.awt.Color(255, 0, 0));
        lblass.setForeground(new java.awt.Color(255, 255, 51));
        lblass.setText("                         ASSIGNED TICKETS");
        lblass.setOpaque(true);

        tblEwo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "EWO", "AREA", "TYPE", "Estimated Intervention Time [min]"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEwo.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblEwo);
        if (tblEwo.getColumnModel().getColumnCount() > 0) {
            tblEwo.getColumnModel().getColumn(0).setResizable(false);
            tblEwo.getColumnModel().getColumn(1).setResizable(false);
            tblEwo.getColumnModel().getColumn(2).setResizable(false);
        }

        tblState.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DEPARTMENT", "MAINTAINER", "STATE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblState.setColumnSelectionAllowed(true);
        tblState.setRowHeight(20);
        tblState.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblState);

        jLabel2.setText("                           STATE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(18, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                            .addComponent(txtDay))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtWeek, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDayW, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblass, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtWeek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDayW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblass, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtWeekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWeekActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtWeekActionPerformed
    private void aggiornaTabella(){
        DefaultTableModel dm = (DefaultTableModel) this.tblEwo.getModel();
        DefaultTableModel dm1 = (DefaultTableModel) this.tblState.getModel();
        ArrayList<EwoActivity> attuale = new ArrayList<>();
        HashMap<EwoActivity, Integer> mappa = this.planner.plannedEwo();
        Set<EwoActivity> chiavi = mappa.keySet();
        Calendar c = Calendar.getInstance();
        java.util.Date d= new java.util.Date();
        c.setTime(d);
        
        for(EwoActivity e: chiavi){
             if(mappa.get(e)==c.get(Calendar.DAY_OF_WEEK)-1){ // perché Calendar considera domenica come 1 e noi invece consideriamo lunedì come 1; domenica non funziona
                 attuale.add(e);                               // ma va bene pke la domenica non si lavora altrimenti viene il sindacato sotto casa
             }
        }
        this.txtDayW.setText(String.valueOf(c.get(Calendar.DAY_OF_MONTH))); //giorno nel mese
        this.txtDay.setText(c.getDisplayName(Calendar.DAY_OF_WEEK ,Calendar.LONG, Locale.ENGLISH));
        this.txtWeek.setText(String.valueOf(c.get(Calendar.WEEK_OF_YEAR)));
        
        for(EwoActivity ew: attuale){
            dm.insertRow(dm.getRowCount(), new Object[]{
                ew.getEwoID(), ew.getSito().getOffice() +" - "+ ew.getSito().getArea(), ew.getTipologia(), ew.getTempo()
            });
            dm1.insertRow(dm1.getRowCount(), new Object[]{
                ew.getAreaStatus(), ew.getManStatus(), ew.getGeneralStatus()
            });
        }
        this.tblEwo.setModel(dm);
        this.tblState.setModel(dm1);
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewEwoInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewEwoInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewEwoInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewEwoInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewEwoInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblass;
    private javax.swing.JTable tblEwo;
    private javax.swing.JTable tblState;
    private javax.swing.JTextField txtDay;
    private javax.swing.JTextField txtDayW;
    private javax.swing.JTextField txtWeek;
    // End of variables declaration//GEN-END:variables
}
