/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.plannerInterface;

import java.util.*;
import deposito.*;
import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cosimocorbisiero
 */
public class MaintainerChooseDayInterface extends javax.swing.JFrame {

    /**
     * Creates new form MaintainerChooseDayInterface
     */
    Planner planner;
    Maintainer man;
    AbstractActivity attivita;
    int giorno;
    JFrame parent;
    public MaintainerChooseDayInterface() {
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(Color.orange);
    }

    MaintainerChooseDayInterface(JFrame parent, Planner planner, AbstractActivity attivita, Maintainer man, int i) {
        this();
        this.parent=parent;
        this.planner = planner;
        this.man = man;
        this.attivita = attivita;
        this.giorno = i;
        this.insertDati(attivita);
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                
            }

            @Override
            public void windowClosing(WindowEvent e) {
                
            }

            @Override
            public void windowClosed(WindowEvent e) {
                parent.dispatchEvent(new WindowEvent(parent,WindowEvent.WINDOW_CLOSING));
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
    
    private void insertDati(AbstractActivity act){
        this.tableDay.setSelectionMode(0);
        this.panelWeek.setText(Integer.toString(this.currentWeek()));
        String stringa = Integer.toString(act.getId())+" - "+act.getSito().getOffice()+" "
                +act.getSito().getArea()+" - "+ act.getTipologia()+ " - "+Integer.toString(act.getTempo())+"'";
        this.paneActivity.setText(stringa);
        this.areaWNotes.setText(act.getWnotes());
        this.labelAv.setText("AVAILABILITY "+this.man.getNome());
        
        this.refreshTable();
        GregorianCalendar gc = new GregorianCalendar();
        if(giorno == 1){
            this.labelGiorno.setText("Monday");
            this.panelDay.setText(Integer.toString(giorno));
        }else if(giorno == 2){
            this.labelGiorno.setText("Tuesday");
            this.panelDay.setText(Integer.toString(giorno));
        }else if(giorno == 3){
            this.labelGiorno.setText("Wednesday");
            this.panelDay.setText(Integer.toString(giorno));
        }else if(giorno == 4){
            this.labelGiorno.setText("Thursday");
            this.panelDay.setText(Integer.toString(giorno));
        }else {
            this.labelGiorno.setText("Friday");
            this.panelDay.setText(Integer.toString(giorno));
        }
        
    }
    
    private int currentWeek(){
        Calendar c = Calendar.getInstance();
        Date date = new Date();
        c.setTime(date);
        return c.get(Calendar.WEEK_OF_YEAR);
    }
    
    private void refreshTable(){
        DefaultTableModel model=(DefaultTableModel)this.tableDay.getModel();
        
        HashMap mappa = this.planner.maintainerAval(man, giorno);
        if(mappa == null){
            JOptionPane.showMessageDialog(new JFrame(), "Errore nella ricezione dei dati di disponibilità");
        }
        String skill = this.skill();
        ArrayList<Integer> array = new ArrayList<>();
        for(Object i : mappa.values()){
            array.add((int)i);
        }
        
        model.insertRow(model.getRowCount(), new Object[]{man.getNome(),skill,array.get(0),array.get(1),array.get(2),array.get(3),array.get(4),array.get(5),array.get(6)});
        
    }
    private String skill(){
        Set<String> set = man.getSkill();
        int j = 0;
        List<String> list = this.attivita.getCompetenze();
        if(set == null || list == null){
            JOptionPane.showMessageDialog(new JFrame(), "Errore Set o Skill sono null");
            this.dispatchEvent(new WindowEvent(this,WindowEvent.WINDOW_CLOSING));
        }
        for(String s : list){
            if(set.remove(s)){
                j++;
            }
        }
        return ""+j+"/"+list.size();
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
        panelWeek = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        panelDay = new javax.swing.JTextPane();
        labelGiorno = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        paneActivity = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        areaWNotes = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableDay = new javax.swing.JTable();
        btnSend = new javax.swing.JToggleButton();
        labelAv = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelWeek.setEditable(false);
        jScrollPane1.setViewportView(panelWeek);

        jLabel1.setText("Week");

        panelDay.setEditable(false);
        jScrollPane2.setViewportView(panelDay);

        labelGiorno.setText("giorno");

        paneActivity.setEditable(false);
        jScrollPane3.setViewportView(paneActivity);

        jLabel2.setText("Activity to assign");

        areaWNotes.setEditable(false);
        areaWNotes.setColumns(20);
        areaWNotes.setRows(5);
        jScrollPane4.setViewportView(areaWNotes);

        jLabel3.setText("WORKSPACE NOTES");

        tableDay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Maintainer", "Skills", "Avail 8-9", "Avail 9-10", "Avail 10-11", "Avail 11-12", "Avail 14-15", "Avail 15-16", "Avail 16-17"
            }
        ));
        tableDay.setColumnSelectionAllowed(true);
        tableDay.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(tableDay);
        tableDay.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        btnSend.setText("Send");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        labelAv.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        labelAv.setText("jLabel4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelGiorno)))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(212, 212, 212))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(labelAv, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1)
                        .addGap(15, 15, 15)
                        .addComponent(labelGiorno))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelAv, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        int index = this.tableDay.getSelectedColumn();
        System.out.println(index);
        String ora="Errore";
        if(index==0 || index==1 || index==-1){
            JOptionPane.showMessageDialog(new JFrame(),"ERRORE SELEZIONE NON VALIDA");
        }else {
            ora = this.ora(index);
            if(ora.equals("Errore") || ora.equals("")){
                JOptionPane.showMessageDialog(new JFrame(), "Errore nella selezione dell'orario ");
                this.dispatchEvent(new WindowEvent(this,WindowEvent.WINDOW_CLOSING));
            }
            System.out.println(ora);
            if(attivita instanceof EwoActivity){
                if(this.planner.assegnaManEWO(man, (EwoActivity) attivita, giorno, ora)== -1){
                    JOptionPane.showMessageDialog(new JFrame(), "Errore!\nAssegnazione non avvenuta");
                    this.dispatchEvent(new WindowEvent(this,WindowEvent.WINDOW_CLOSING));
                }
                JOptionPane.showMessageDialog(new JFrame(), "Assegnazione avvenuta con successo");
                this.dispatchEvent(new WindowEvent(this,WindowEvent.WINDOW_CLOSING));
            }else{
            if(this.planner.assegnaMan(man, attivita, giorno, ora)==-1){
                JOptionPane.showMessageDialog(new JFrame(), "Errore!\nAssegnazione non avvenuta");
                this.dispatchEvent(new WindowEvent(this,WindowEvent.WINDOW_CLOSING));
            
            }else{

            JOptionPane.showMessageDialog(new JFrame(), "Assegnazione avvenuta con successo");
            this.dispatchEvent(new WindowEvent(this,WindowEvent.WINDOW_CLOSING));
            }
            }
        
        }
    }//GEN-LAST:event_btnSendActionPerformed
    private String ora(int index){
            String ora="Errore";
            if(index==2){
                ora="o8_9";
            }else if(index==3){
                ora="o9_10";
            }else if(index==4){
                ora="o10_11";
            }else if(index==5){
                ora="o11_12";
            }else if(index==6){
                ora="o14_15";
            }else if(index==7){
                ora="o15_16";
            }else{
            ora="o17_18";
            }
            return ora;
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
            java.util.logging.Logger.getLogger(MaintainerChooseDayInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MaintainerChooseDayInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MaintainerChooseDayInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MaintainerChooseDayInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MaintainerChooseDayInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaWNotes;
    private javax.swing.JToggleButton btnSend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel labelAv;
    private javax.swing.JLabel labelGiorno;
    private javax.swing.JTextPane paneActivity;
    private javax.swing.JTextPane panelDay;
    private javax.swing.JTextPane panelWeek;
    private javax.swing.JTable tableDay;
    // End of variables declaration//GEN-END:variables
}
