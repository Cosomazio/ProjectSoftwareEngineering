/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.plannerInterface;

import deposito.*;
import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
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
public class CreateActivityInterface extends javax.swing.JFrame {

    /**
     * Creates new form CreateActivityInterface
     */
    private Planner planner = null;
    public CreateActivityInterface(JFrame parent, Planner planner) {
        this();
        this.planner=planner;
        
        this.addWindowListener(new WindowListener () {
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

    private CreateActivityInterface() {
        initComponents();
        
        this.setTitle("Creazione Attività");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.listaMateriali();
        this.listaSito();
        this.listaTipologie();
        
       
        
        
    }
/*-------------------------------------------------------------
                    INSERIMENTO NEL BOX DELLA LISTA DELLE TIPOLOGIE   */
    private void listaTipologie(){
        List<String> tipologia= new ArrayList<>();
        Comunicatore com = Comunicatore.getInstance();
        try {
            com.apri();
            ResultSet rs = com.selectionQuery("tipologia", null, null);
            com.chiudi();
            while(rs.next()){
                tipologia.add(rs.getString("tipologia"));
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
        for(int i = 0; i<tipologia.size();i++){
            this.boxTipologia.addItem(tipologia.get(i));
        }
    }
    /*-------------------------------------------------------------
                    INSERIMENTO NEL BOX DELLA LISTA DEI MATERIALI   */
    private void listaMateriali(){
        Comunicatore com = Comunicatore.getInstance();
        List<String> materiali = new ArrayList<>();
        try {
            com.apri();
            ResultSet rsMaterial = com.selectionQuery("materiali", null, null);
            com.chiudi();
            while(rsMaterial.next()){
                materiali.add(rsMaterial.getString("materiale"));
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
        DefaultListModel<String> list = new DefaultListModel<>();
        for(int i = 0; i< materiali.size();i++){
            list.addElement(materiali.get(i));
        }
        this.listMateriali.setModel(list);
        this.listMateriali.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    }
    
    /*-------------------------------------------------------------
                    INSERIMENTO NEL BOX DELLA LISTA DEI SITI   */
    private void listaSito(){
        List<String> sito = new ArrayList<>();
        Comunicatore com = Comunicatore.getInstance();
        try {
            com.apri();
            ResultSet rs2= com.selectionQuery("Sito", null, null);
            com.chiudi();
            while(rs2.next()){
                sito.add(rs2.getString("office")+"-"+rs2.getString("area"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
        for(int i = 0; i< sito.size();i++){
            this.boxSito.addItem(sito.get(i));
        }
        
    }
    
    private void boxTipoAttivita(){
       
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
        textDescrizione = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        boxWeek = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listMateriali = new javax.swing.JList<>();
        jLabel6 = new javax.swing.JLabel();
        textTempo = new javax.swing.JTextField();
        boxTipologia = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        boxInterrompibile = new javax.swing.JCheckBox();
        boxPlanned = new javax.swing.JCheckBox();
        boxUnplanned = new javax.swing.JCheckBox();
        boxEwo = new javax.swing.JCheckBox();
        boxExtra = new javax.swing.JCheckBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel8 = new javax.swing.JLabel();
        btnOkCreate = new javax.swing.JButton();
        btnCancelCreate = new javax.swing.JButton();
        boxSito = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaWnotes = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Creazione Attività");

        jLabel2.setText("Descrizione");

        boxWeek.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7 ", "6 ", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52" }));
        boxWeek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxWeekActionPerformed(evt);
            }
        });

        jLabel3.setText("Settimana");

        jLabel4.setText("Sito");

        jLabel5.setText("Materiali");

        listMateriali.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listMateriali);

        jLabel6.setText("Tempo Intervento(in Minuti)");

        textTempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTempoActionPerformed(evt);
            }
        });

        jLabel7.setText("Tipologia");

        boxInterrompibile.setText("Interrompibile");
        boxInterrompibile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxInterrompibileActionPerformed(evt);
            }
        });

        boxPlanned.setText("Planned");
        boxPlanned.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxPlannedActionPerformed(evt);
            }
        });

        boxUnplanned.setText("Unplanned");
        boxUnplanned.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxUnplannedActionPerformed(evt);
            }
        });

        boxEwo.setText("EWO");
        boxEwo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxEwoActionPerformed(evt);
            }
        });

        boxExtra.setText("Extra");
        boxExtra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxExtraActionPerformed(evt);
            }
        });

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.setEnabled(false);
        jScrollPane3.setViewportView(jList1);

        jLabel8.setText("Procedure");

        btnOkCreate.setText("Ok");
        btnOkCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkCreateActionPerformed(evt);
            }
        });

        btnCancelCreate.setText("Cancel");
        btnCancelCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelCreateActionPerformed(evt);
            }
        });

        jLabel9.setText("WORKSPACE NOTES");

        areaWnotes.setColumns(20);
        areaWnotes.setRows(5);
        jScrollPane1.setViewportView(areaWnotes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(320, 320, 320)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(boxPlanned)
                        .addGap(64, 64, 64)
                        .addComponent(boxUnplanned))
                    .addComponent(btnOkCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(boxExtra)
                        .addGap(40, 40, 40)
                        .addComponent(boxEwo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(30, 30, 30)
                                .addComponent(boxWeek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(boxSito, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(boxInterrompibile)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(boxTipologia, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(textTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textDescrizione)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(80, 80, 80))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(90, 90, 90))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boxWeek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(textTempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(boxSito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(boxTipologia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addComponent(boxInterrompibile))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(textDescrizione, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boxExtra)
                            .addComponent(boxPlanned)
                            .addComponent(boxUnplanned)
                            .addComponent(boxEwo))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnOkCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boxWeekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxWeekActionPerformed
        
    }//GEN-LAST:event_boxWeekActionPerformed

    private void textTempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTempoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTempoActionPerformed

    private void boxInterrompibileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxInterrompibileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxInterrompibileActionPerformed

    private void btnOkCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkCreateActionPerformed
        
        String tipologia = (String) this.boxTipologia.getSelectedItem();
        String a = (String)this.boxSito.getSelectedItem();
        String [] b = a.split("-");
        Sito sito = new Sito(b[0],b[1]);
        String wNotes=this.areaWnotes.getText();
       
        String descrizione = this.textDescrizione.getText();
       
        int tempo = Integer.parseInt(this.textTempo.getText());
        
        List<String> materiali = this.listMateriali.getSelectedValuesList();
        int week = Integer.parseInt((String) this.boxWeek.getSelectedItem());
        
        Boolean interrompibile = false;
        if(this.boxInterrompibile.isSelected()){
            interrompibile = true;
        }
        
        String tipoAttivita="Planned"; //DEVE ESSERE CAMBIATO PERCHÈ AL MOMENTO NON GESTISCIAMO IL FATTO CHE NON L'UTENTE NON SELEZIONI NULLA
        if(this.boxEwo.isSelected()){
            tipoAttivita = "Ewo";
        }else if(this.boxExtra.isSelected()){
            tipoAttivita = "Extra";
        }else if(this.boxPlanned.isSelected()){
            tipoAttivita = "Planned";
        }else if(this.boxUnplanned.isSelected()){
            tipoAttivita = "Unplanned";
        }
       
        Procedure procedura = new Procedure("smp","nomefile");
        
        
       
        AbstractActivity act = planner.createActivity(sito, tipologia, descrizione, tempo, materiali, week, interrompibile, procedura, wNotes,tipoAttivita);
        if(act != null){
            JOptionPane.showMessageDialog(new JFrame(), "Inserimento avvenuto con successo");
        }
        
    }//GEN-LAST:event_btnOkCreateActionPerformed

    private void btnCancelCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelCreateActionPerformed
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_btnCancelCreateActionPerformed

    private void boxPlannedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxPlannedActionPerformed
         if(this.boxPlanned.isSelected()){
            this.boxEwo.setEnabled(false);
            this.boxExtra.setEnabled(false);
            this.boxUnplanned.setEnabled(false);
         }else{
            this.boxEwo.setEnabled(true);
            this.boxExtra.setEnabled(true);
            this.boxUnplanned.setEnabled(true);
         }
         
    }//GEN-LAST:event_boxPlannedActionPerformed

    private void boxUnplannedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxUnplannedActionPerformed
        if(this.boxUnplanned.isSelected()){
            this.boxEwo.setEnabled(false);
            this.boxExtra.setEnabled(false);
            this.boxPlanned.setEnabled(false);
         }else{
            this.boxEwo.setEnabled(true);
            this.boxExtra.setEnabled(true);
            this.boxPlanned.setEnabled(true);
         }
    }//GEN-LAST:event_boxUnplannedActionPerformed

    private void boxExtraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxExtraActionPerformed
        if(this.boxExtra.isSelected()){
            this.boxEwo.setEnabled(false);
            this.boxPlanned.setEnabled(false);
            this.boxUnplanned.setEnabled(false);
         }else{
            this.boxEwo.setEnabled(true);
            this.boxPlanned.setEnabled(true);
            this.boxUnplanned.setEnabled(true);
         }
    }//GEN-LAST:event_boxExtraActionPerformed

    private void boxEwoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxEwoActionPerformed
        if(this.boxEwo.isSelected()){
            this.boxPlanned.setEnabled(false);
            this.boxExtra.setEnabled(false);
            this.boxUnplanned.setEnabled(false);
         }else{
            this.boxPlanned.setEnabled(true);
            this.boxExtra.setEnabled(true);
            this.boxUnplanned.setEnabled(true);
         }
    }//GEN-LAST:event_boxEwoActionPerformed
    
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
            java.util.logging.Logger.getLogger(CreateActivityInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateActivityInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateActivityInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateActivityInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CreateActivityInterface frame = new CreateActivityInterface();
                frame.setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaWnotes;
    private javax.swing.JCheckBox boxEwo;
    private javax.swing.JCheckBox boxExtra;
    private javax.swing.JCheckBox boxInterrompibile;
    private javax.swing.JCheckBox boxPlanned;
    private javax.swing.JComboBox<String> boxSito;
    private javax.swing.JComboBox<String> boxTipologia;
    private javax.swing.JCheckBox boxUnplanned;
    private javax.swing.JComboBox<String> boxWeek;
    private javax.swing.JButton btnCancelCreate;
    private javax.swing.JButton btnOkCreate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<String> listMateriali;
    private javax.swing.JTextField textDescrizione;
    private javax.swing.JTextField textTempo;
    // End of variables declaration//GEN-END:variables
}
