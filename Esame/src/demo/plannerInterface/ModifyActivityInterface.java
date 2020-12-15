/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.plannerInterface;

import deposito.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author cosimocorbisiero
 */

public class ModifyActivityInterface extends javax.swing.JFrame {

    /**
     * Creates new form ModifyActivityInterface
     */
    ArrayList<AbstractActivity> archivio;
    private Planner planner;
    public ModifyActivityInterface(JFrame parent, Planner planner){
        this();
        this.planner = planner;
        this.archivio=this.planner.viewActivities();
        this.listActivities();
      
        
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                
            }

            @Override
            public void windowClosing(WindowEvent e) {
                
            }

            @Override
            public void windowClosed(WindowEvent e) {
                parent.setVisible(true);
            }

            @Override
            public void windowIconified(WindowEvent e) {
                
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                
            }

            @Override
            public void windowActivated(WindowEvent e) {
                
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                
            }
        });
    }
    public ModifyActivityInterface() {
        initComponents();
        this.setTitle("Modificy Activity");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
    }
   
    private void listActivities(){
        
        DefaultListModel listAttivita = new DefaultListModel();
        
        
        if(this.planner.viewActivities()==null){
            JOptionPane.showMessageDialog(new JFrame(), "Errore non sono presenti attività");
            this.dispatchEvent(new WindowEvent(this,WindowEvent.WINDOW_CLOSING));
            
        }else{
        ArrayList<AbstractActivity> attivita = this.archivio;
        
        for(AbstractActivity act : attivita){
            listAttivita.addElement(act); 
            
        }
        
        this.listAttivitaModify.setModel(listAttivita);
        
        this.listAttivitaModify.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listAttivitaModify = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        panelWeek = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        panelID = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        areaNote = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        btnOkModify = new javax.swing.JButton();
        btnCancelModify = new javax.swing.JButton();
        btnDeleteActivity = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listAttivitaModify.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listAttivitaModifyMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listAttivitaModify);

        jLabel1.setText("SELEZIONA L'ATTIVITÀ DA MODIFICARE ");

        panelWeek.setEditable(false);
        jScrollPane2.setViewportView(panelWeek);

        panelID.setEditable(false);
        jScrollPane3.setViewportView(panelID);

        jLabel2.setText("WEEK");

        jLabel3.setText("ID");

        areaNote.setEditable(false);
        areaNote.setColumns(20);
        areaNote.setRows(5);
        jScrollPane4.setViewportView(areaNote);

        jLabel4.setText("WORKSPACE NOTE");

        btnOkModify.setText("Ok");
        btnOkModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkModifyActionPerformed(evt);
            }
        });

        btnCancelModify.setText("Cancel");
        btnCancelModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelModifyActionPerformed(evt);
            }
        });

        btnDeleteActivity.setText("Delete Activity");
        btnDeleteActivity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActivityActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(200, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(161, 161, 161))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDeleteActivity, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnOkModify, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancelModify, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(137, 137, 137)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel3))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnOkModify, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelModify, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDeleteActivity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkModifyActionPerformed
        AbstractActivity act = this.selectedActivities();
        if(act == null){
            JOptionPane.showMessageDialog(new JFrame(), "ERRORE");
            this.dispatchEvent(new WindowEvent(this,WindowEvent.WINDOW_CLOSING));
        }
        this.planner.modifyActivity(act, this.areaNote.getText());
        this.listActivities();
        
        JOptionPane.showMessageDialog(new JFrame(), "Modifica avvenuta con successo");
    }//GEN-LAST:event_btnOkModifyActionPerformed

    private void btnCancelModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelModifyActionPerformed
        this.dispatchEvent(new WindowEvent(this,WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_btnCancelModifyActionPerformed

    private void btnDeleteActivityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActivityActionPerformed
        AbstractActivity act = this.selectedActivities();
        int i= JOptionPane.showConfirmDialog(new JFrame(), "Sei Sicuro di voler eliminare l'attività selezionata?");
        if(i==0){
            this.planner.deleteActivity(act);
            this.listActivities();
        }
        
    }//GEN-LAST:event_btnDeleteActivityActionPerformed

    private void listAttivitaModifyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listAttivitaModifyMouseClicked
        AbstractActivity act = this.selectedActivities();
        if(act != null){
            this.panelID.setText(Integer.toString(act.getId()));
            this.panelWeek.setText(Integer.toString(act.getWeek()));
            this.areaNote.setEditable(true);
            this.areaNote.setText(act.getWnotes());
        }else{
            this.panelID.setText("");
            this.panelWeek.setText("");
            this.areaNote.setEditable(false);
        }
    }//GEN-LAST:event_listAttivitaModifyMouseClicked

    /**
     * @param args the command line arguments
     */
    private AbstractActivity selectedActivities(){
        /*int index = listAttivitaModify.getSelectedIndex();
        if(index >=0){
            AbstractActivity act = this.archivio.get(index);
            return act;
        }
        return null;*/
        return (AbstractActivity)this.listAttivitaModify.getSelectedValue();
    }
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
            java.util.logging.Logger.getLogger(ModifyActivityInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModifyActivityInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModifyActivityInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifyActivityInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModifyActivityInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaNote;
    private javax.swing.JButton btnCancelModify;
    private javax.swing.JButton btnDeleteActivity;
    private javax.swing.JButton btnOkModify;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList listAttivitaModify;
    private javax.swing.JTextPane panelID;
    private javax.swing.JTextPane panelWeek;
    // End of variables declaration//GEN-END:variables
}
