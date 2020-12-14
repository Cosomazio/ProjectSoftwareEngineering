/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.adminInterface;

import deposito.Maintainer;
import deposito.SystemAdministrator;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author tomma
 */
public class AddSkillMaintainerInterface extends javax.swing.JFrame {

    /**
     * Creates new form AddSkillMaintainerInterface
     */
    private Maintainer man;
    private SystemAdministrator admin;
    public AddSkillMaintainerInterface() {
        initComponents();
        this.setTitle("Gestione skill manutentore");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        maintainerSkillList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public AddSkillMaintainerInterface(JFrame parent,Maintainer man,SystemAdministrator admin){
        this();
        this.man=man;
        this.admin=admin;
        refreshMaintainerSkill();
        refreshDBSkill();
        this.addWindowListener( new WindowListener () {
            @Override
            public void windowOpened(WindowEvent we) {
            }

            @Override
            public void windowClosing(WindowEvent we) {
                parent.setVisible(true);
            }

            @Override
            public void windowClosed(WindowEvent we) {
            }

            @Override
            public void windowIconified(WindowEvent we) {
            }

            @Override
            public void windowDeiconified(WindowEvent we) {
            }

            @Override
            public void windowActivated(WindowEvent we) {
            }

            @Override
            public void windowDeactivated(WindowEvent we) {
            }
        } );
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
        skillDBList = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        maintainerSkillList = new javax.swing.JList<>();
        btAddSkill = new javax.swing.JButton();
        btDeleteSkill = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        skillDBList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(skillDBList);

        jLabel1.setText("Skill selezionabili");

        jLabel2.setText("Skill Selezionate");

        maintainerSkillList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(maintainerSkillList);

        btAddSkill.setText("Aggiungi skill");
        btAddSkill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddSkillActionPerformed(evt);
            }
        });

        btDeleteSkill.setText("Rimuovi skill");
        btDeleteSkill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteSkillActionPerformed(evt);
            }
        });

        btCancel.setText("CANCEL");
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(btAddSkill)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(btDeleteSkill))
                                .addGap(0, 91, Short.MAX_VALUE))
                            .addComponent(jScrollPane2))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btAddSkill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btDeleteSkill, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(btCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        // TODO add your handling code here:
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_btCancelActionPerformed
    
    private void errorMsg(String title,String msg){
        JOptionPane.showMessageDialog(this, msg, title, JOptionPane.ERROR_MESSAGE);
    }
    
    private void refreshMaintainerSkill(){
        DefaultListModel lm=new DefaultListModel();
        ArrayList<String> skills= admin.viewSkillMan(man);
        System.out.println(skills.toString());
        if(skills==null){
            errorMsg("errore", "errore accesso al db");
        }
        Set<String> competenze = new HashSet<String>();
        for (String skill:skills){
            competenze.add(skill);
            lm.addElement(skill);
        }
        man.setSkill(competenze);
        this.maintainerSkillList.setModel(lm);
    }
    
    public void refreshDBSkill(){
        DefaultListModel lm=new DefaultListModel();
        List<String> skillDB= admin.viewCompetenze();
        ArrayList<String> skillMan= admin.viewSkillMan(man);
        if(skillDB==null|| skillMan==null){
            errorMsg("errore", "errore accesso al DB");
        }
        skillDB.removeAll(skillMan);
        for (String skill:skillDB){
            lm.addElement(skill);
        }
        this.skillDBList.setModel(lm);
    }
    
    private void btAddSkillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddSkillActionPerformed
        // TODO add your handling code here:
        String skill=skillDBList.getSelectedValue();
        Set<String> skillSet=new HashSet<>();
        skillSet.add(skill);
        if(admin.addSkill(man, skillSet)==null){
            errorMsg("errore", "errore aggiunta elemento");
        }
        refreshDBSkill();
        refreshMaintainerSkill();
    }//GEN-LAST:event_btAddSkillActionPerformed

    private void btDeleteSkillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteSkillActionPerformed
        // TODO add your handling code here:
        String skill=maintainerSkillList.getSelectedValue();
        Set<String> skillSet=new HashSet<>();
        skillSet.add(skill);
        
        if(admin==null|| skill==null||man==null){
            errorMsg("null", "null pointer exception");
            System.out.println("adgsdvfwber");
        }
        if(admin.deleteSkill(man, skillSet)==null){
            errorMsg("errore", "errore eliminazione elemento");
        }
        refreshDBSkill();
        refreshMaintainerSkill();
    }//GEN-LAST:event_btDeleteSkillActionPerformed

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
            java.util.logging.Logger.getLogger(AddSkillMaintainerInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddSkillMaintainerInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddSkillMaintainerInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddSkillMaintainerInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddSkillMaintainerInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddSkill;
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btDeleteSkill;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> maintainerSkillList;
    private javax.swing.JList<String> skillDBList;
    // End of variables declaration//GEN-END:variables
}
