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
        this.listaMateriali();
        this.listaSito();
        this.listaTipologie();
        this.listaCompetenze();
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
        this.getContentPane().setBackground(Color.orange);
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbPlanned);
        bg.add(rbUnplanned);  
        bg.add(rbExtra);
        bg.add(rbEWO);
        rbPlanned.setSelected(true);
        
    }
    
    private void errorMsg(String title,String msg){
        JOptionPane.showMessageDialog(this, msg,title, JOptionPane.ERROR_MESSAGE);
    }
/*-------------------------------------------------------------
                    INSERIMENTO NEL BOX DELLA LISTA DELLE TIPOLOGIE   */
    private void listaTipologie(){
        List<String> tipologia= this.planner.listaTipologia();
        if(tipologia==null){
            errorMsg("errore", "errore accesso al db");
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
        for(int i = 0; i<tipologia.size(); i++){
            this.boxTipologia.addItem(tipologia.get(i));
        }
    }
    /*-------------------------------------------------------------
                    INSERIMENTO NEL BOX DELLA LISTA DEI MATERIALI   */
    private void listaMateriali(){
        
        List<String> materiali =this.planner.listaMateriali();
        if(materiali==null){
            errorMsg("errore", "errore accesso al db");
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
        DefaultListModel<String> list = new DefaultListModel<>();
        for(int i = 0; i< materiali.size();i++){
            list.addElement(materiali.get(i));
        }
        this.listMateriali.setModel(list);
        this.listMateriali.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    }
    
    /*------------------------------------------------------------
                INSERIMENTO NELLA LISTA DI SKILL */
    private void listaCompetenze(){
        
        List<String> competenze = this.planner.listaCompetenze();
        if(competenze==null){
            errorMsg("errore", "errore accesso al db");
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
        DefaultListModel<String> list = new DefaultListModel<>();
        for(int i = 0; i< competenze.size();i++){
            list.addElement(competenze.get(i));
        }
        this.listSkill.setModel(list);
        this.listSkill.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    }
                
    
    /*-------------------------------------------------------------
                    INSERIMENTO NEL BOX DELLA LISTA DEI SITI   */
    private void listaSito(){
        List<String> sito = this.planner.listaSito();
        if(sito==null){
            errorMsg("errore", "errore accesso al db");
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
        for(int i = 0; i< sito.size();i++){
            this.boxSito.addItem(sito.get(i));
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
        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel8 = new javax.swing.JLabel();
        btnOkCreate = new javax.swing.JButton();
        btnCancelCreate = new javax.swing.JButton();
        boxSito = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaWnotes = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listSkill = new javax.swing.JList<>();
        rbPlanned = new javax.swing.JRadioButton();
        rbUnplanned = new javax.swing.JRadioButton();
        rbExtra = new javax.swing.JRadioButton();
        rbEWO = new javax.swing.JRadioButton();

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

        jLabel10.setText("Competenze");

        listSkill.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(listSkill);

        rbPlanned.setText("Planned");

        rbUnplanned.setText("Unplanned");

        rbExtra.setText("Extra");

        rbEWO.setText("EWO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(320, 320, 320)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(106, 106, 106))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(89, 89, 89))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(29, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnOkCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnCancelCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(rbPlanned)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(276, 276, 276)
                        .addComponent(rbExtra)
                        .addGap(40, 40, 40)
                        .addComponent(rbEWO))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(rbUnplanned)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(90, 90, 90))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
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
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10)
                        .addGap(13, 13, 13)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(textDescrizione, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbPlanned)
                            .addComponent(rbUnplanned)
                            .addComponent(rbExtra)
                            .addComponent(rbEWO))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnOkCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
    
    /*
    * Dà true se almeno una stringa nell'array è true
    */
    private boolean checkEmptyStrings(String s[]){
        Boolean res=false;
        for(String str:s){
            String trimmedSkill=str.trim();
            if(trimmedSkill.equals("")){
                res=true;
            }
        }
        return res;
    }
    
    /*
    * Dà un messaggio di errore quando a==b con un messaggio
    * con titolo title e messaggio msg
    */
    private boolean assertEqualValue(int a,int b,String title,String msg){
        if(a==b){
            errorMsg(title, msg);
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            return true;
        }
        return false;
    }
    
    private boolean inputChecks(){
        Boolean tipo= assertEqualValue(this.boxTipologia.getSelectedIndex(), -1, "error", "nessuna tipologia selezionata");
        Boolean sito= assertEqualValue(this.boxSito.getSelectedIndex(), -1, "error", "nessun sito selezionato");
        if(checkEmptyStrings(new String[]{this.textDescrizione.getText()})){
            errorMsg("errore", "stringa descrizione vuota");
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            return true;
        }
        Boolean matKo = assertEqualValue(this.listMateriali.getSelectedValuesList().size(), 0, "errore", "nessun materiale selezionato");
        Boolean compKo = assertEqualValue(this.listSkill.getSelectedValuesList().size(), 0, "errore", "nessuna competenza selezionata");
        if(tipo==true || sito==true || matKo==true|| compKo==true){
            return true;
        }
        return false;
    }
    
    private void btnOkCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkCreateActionPerformed
        if(inputChecks()==true){
            return;
        }
        int tempo=0;
        try{
            tempo = Integer.parseInt(this.textTempo.getText());
        }catch(NumberFormatException nex){
            errorMsg("errore", "string tempo non valida");
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            return;
        }
        
        String descrizione = this.textDescrizione.getText();
        
        List<String> materiali = this.listMateriali.getSelectedValuesList();
        List<String> competenze = this.listSkill.getSelectedValuesList();
        
        String tipologia = (String) this.boxTipologia.getSelectedItem();
        String a = (String)this.boxSito.getSelectedItem();
        String [] b = a.split("-");
        Sito sito = new Sito(b[0],b[1]);
        String wNotes=this.areaWnotes.getText();
        
        int week = Integer.parseInt((String) this.boxWeek.getSelectedItem());
        
        Boolean interrompibile = false;
        if(this.boxInterrompibile.isSelected()){
            interrompibile = true;
        }
        String tipoAttivita = this.tipoActivity();
        Procedure procedura = new Procedure("smp","nomefile");

        AbstractActivity act = planner.createActivity(sito, tipologia, descrizione, tempo, materiali, week, competenze, interrompibile, procedura, wNotes,tipoAttivita);
        if(act != null){
            JOptionPane.showMessageDialog(new JFrame(), "Inserimento avvenuto con successo");
        }else{
            errorMsg("errore", "errore creazione attività nel db");
        }
            
        
        
    }//GEN-LAST:event_btnOkCreateActionPerformed
    private String tipoActivity(){
        
        String tipoAttivita=""; 
        if(this.rbEWO.isSelected()){
            tipoAttivita = "Ewo";
        }else if(this.rbExtra.isSelected()){
            tipoAttivita = "Extra";
        }else if(this.rbPlanned.isSelected()){
            tipoAttivita = "Planned";
        }else if(this.rbUnplanned.isSelected()){
            tipoAttivita = "Unplanned";
        }
        return tipoAttivita;
    }
    private void btnCancelCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelCreateActionPerformed
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_btnCancelCreateActionPerformed
    
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
    private javax.swing.JCheckBox boxInterrompibile;
    private javax.swing.JComboBox<String> boxSito;
    private javax.swing.JComboBox<String> boxTipologia;
    private javax.swing.JComboBox<String> boxWeek;
    private javax.swing.JButton btnCancelCreate;
    private javax.swing.JButton btnOkCreate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList<String> listMateriali;
    private javax.swing.JList<String> listSkill;
    private javax.swing.JRadioButton rbEWO;
    private javax.swing.JRadioButton rbExtra;
    private javax.swing.JRadioButton rbPlanned;
    private javax.swing.JRadioButton rbUnplanned;
    private javax.swing.JTextField textDescrizione;
    private javax.swing.JTextField textTempo;
    // End of variables declaration//GEN-END:variables
}
