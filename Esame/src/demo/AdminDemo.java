/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import deposito.*;
import factories.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author franc
 */
public class AdminDemo extends javax.swing.JFrame {

    /**
     * Creates new form AdminDemo
     */
    private SystemAdministrator admin;
    public AdminDemo() {
        initComponents();
        SaBuilder bx= new SaBuilder();
        bx.reset("admin", "admin", "proprietario", "admin@admin.it");
        admin=bx.getResult();
        
        this.setTitle("BENEVENUTO");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lableBenvenuto = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        buttonCreate = new javax.swing.JButton();
        buttonModify = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lableBenvenuto.setText("GESTIONE PERSONALE");

        jLabel1.setText("CREAZIONE UTENTE");

        jLabel2.setText("MODIFICA UTENTE");

        jLabel3.setText("CANCELLA UTENTE");

        buttonCreate.setText("CREAZIONE");
        buttonCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCreateActionPerformed(evt);
            }
        });

        buttonModify.setText("MODIFICA");
        buttonModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonModifyActionPerformed(evt);
            }
        });

        buttonDelete.setText("CANCELLA");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(79, 79, 79)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(buttonCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonModify, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(lableBenvenuto)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lableBenvenuto, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(buttonCreate))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(buttonModify))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(buttonDelete))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCreateActionPerformed
        JFrame frame = new JFrame("Creazione Utente");
        AdminDemo temp=this;
        frame.setSize(800, 600);
        
        JTextField textNome = new JTextField();
        JTextField textUsername = new JTextField();
        JTextField textPassword = new JTextField();
        JTextField textEmail = new JTextField();
        
        JButton buttonOK = new JButton("OK");
        JButton buttonCancel = new JButton("CANCEL");
        
        JRadioButton rButtonPlanner = new JRadioButton("planner");
        JRadioButton rButtonMaintainer = new JRadioButton("maintainer");
        
        ButtonGroup bg = new ButtonGroup();
        
        this.setVisible(false);
        frame.setVisible(true);
        
        frame.addWindowListener( new WindowListener () {
            @Override
            public void windowOpened(WindowEvent we) {
            }

            @Override
            public void windowClosing(WindowEvent we) {
                temp.setVisible(true);
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
        frame.setLayout(new GridLayout(6, 2));
        
        frame.add(textNome);
        frame.add(new JLabel("nome"));
        
        frame.add(textUsername);
        frame.add(new JLabel("username"));
        
        frame.add(textPassword);
        frame.add(new JLabel("password"));
        
        frame.add(textEmail);
        frame.add(new JLabel("mail"));
        
        frame.add(rButtonPlanner);
        frame.add(rButtonMaintainer);
        rButtonPlanner.setSelected(true);
        bg.add(rButtonPlanner);
        bg.add(rButtonMaintainer);
        
        frame.add(buttonOK);
        frame.add(buttonCancel);
        
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                temp.setVisible(true);
                frame.dispose();
            }
        });
        
        buttonOK.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
               String nome =textNome.getText();
               String username = textUsername.getText();
               String password = textPassword.getText();
               String email = textEmail.getText();
               
               if (rButtonPlanner.isSelected())
                   try {
                       SystemAdministrator a= temp.admin;
                       a.createPlanner(username, password, nome, email);
               } catch (SQLException ex) {
                   JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), "ERRORE", JOptionPane.ERROR_MESSAGE);
               }
               else{
                   try {
                       SystemAdministrator x= temp.admin;
                       x.createMaintainer(username, password, nome, email);
                       
                   } catch (SQLException ex) {
                       JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), "ERRORE", JOptionPane.ERROR_MESSAGE);
                   }
               }
               textNome.setText("");
               textUsername.setText("");
               textPassword.setText("");
               textEmail.setText("");
            }
            
        });
    }//GEN-LAST:event_buttonCreateActionPerformed

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        JFrame frame= new JFrame("Cancellazione");
        AdminDemo temp = this;
        
        JButton buttonOK = new JButton("OK");
        JButton buttonCancel = new JButton("CANCEL");
        
        DefaultListModel listUsers = new DefaultListModel();
        
        frame.setSize(800, 600);
        frame.setLayout(new GridLayout(3, 1));
        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent we) {
            }

            @Override
            public void windowClosing(WindowEvent we) {
                temp.setVisible(true);
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
            
        });
        this.setVisible(false);
        frame.setVisible(true);
        
        ArrayList<Maintainer> mans = temp.admin.viewMaintainer();
        ArrayList<Planner> plans = temp.admin.viewPlanner();
        
        for(Planner p: plans)
            listUsers.addElement(p);
        for(Maintainer m: mans)
            listUsers.addElement(m);
        
        JList list= new JList(listUsers);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.setVisibleRowCount(plans.size()+mans.size());
        JScrollPane listScrollPane = new JScrollPane(list);
        
        frame.add(list);
        frame.add(buttonOK);
        frame.add(buttonCancel);
        
        buttonOK.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(list.getSelectedValue() instanceof deposito.Planner){
                    try {
                        temp.admin.cancellaPlanner((Planner) list.getSelectedValue());
                } catch (SQLException ex) {
                   JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), "ERRORE", JOptionPane.ERROR_MESSAGE);
                }
              }
                else{
                    try {
                        temp.admin.cancellaMaintainer((Maintainer) list.getSelectedValue());
                    } catch (SQLException ex) {
                      JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), "ERRORE", JOptionPane.ERROR_MESSAGE);  
                    }
                }
                JOptionPane.showMessageDialog(new JFrame(), "Cancellazione avvenuta con successo", "", JOptionPane.INFORMATION_MESSAGE);
                temp.setVisible(true);
                frame.dispose();
            }           
        });
        
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                temp.setVisible(true);
                frame.dispose();
            }
        });
    }//GEN-LAST:event_buttonDeleteActionPerformed

    private void buttonModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModifyActionPerformed
        JFrame frame= new JFrame("Modifica");
        AdminDemo temp = this;
        
        JButton buttonOK = new JButton("OK");
        JButton buttonCancel = new JButton("CANCEL");
        
        DefaultListModel listUsers = new DefaultListModel();
        
        frame.setSize(800, 600);
        frame.setLayout(new GridLayout(3, 1));
        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent we) {
            }

            @Override
            public void windowClosing(WindowEvent we) {
                temp.setVisible(true);
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
            
        });
        this.setVisible(false);
        frame.setVisible(true);
        
        ArrayList<Maintainer> mans = temp.admin.viewMaintainer();
        ArrayList<Planner> plans = temp.admin.viewPlanner();
        
        for(Planner p: plans)
            listUsers.addElement(p);
        for(Maintainer m: mans)
            listUsers.addElement(m);
        
        JList list= new JList(listUsers);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.setVisibleRowCount(plans.size()+mans.size());
        JScrollPane listScrollPane = new JScrollPane(list);
        
        frame.add(list);
        frame.add(buttonOK);
        frame.add(buttonCancel);
        
        buttonOK.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                JFrame frame1 = new JFrame();
                frame1.setSize(800, 600);
                frame1.setLayout(new GridLayout(5, 2));
                AbstractUtente val= (AbstractUtente) list.getSelectedValue();
                
                frame1.addWindowListener(new WindowListener(){
                            @Override
                            public void windowOpened(WindowEvent we) {
                            }

                            @Override
                            public void windowClosing(WindowEvent we) {
                                frame.setVisible(true);
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
                            
                        });
                frame.setVisible(false);
                frame1.setVisible(true);
                
                JTextField textNome = new JTextField();
                JTextField textUsername = new JTextField();
                JTextField textPassword = new JTextField();
                JTextField textEmail = new JTextField();
                
                JButton buttonOKm = new JButton("OK");
                JButton buttonCancelm = new JButton("CANCEL");
                
                textNome.setText(val.getNome());
                frame1.add(textNome);
                frame1.add(new JLabel("nome"));
                
                textUsername.setText(val.getUsername());
                frame1.add(textUsername);
                frame1.add(new JLabel("username"));
                
                textPassword.setText(val.getPassword());
                frame1.add(textPassword);
                frame1.add(new JLabel("password"));
                
                textEmail.setText(val.getEmail());
                frame1.add(textEmail);
                frame1.add(new JLabel("mail"));
                
                frame1.add(buttonOKm);
                frame1.add((buttonCancelm));
                
                buttonCancelm.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    frame.setVisible(true);
                    frame1.dispose();
                    }
                });
                
                buttonOKm.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        String nome = textNome.getText();
                        String username = textUsername.getText();
                        String password = textPassword.getText();
                        String email = textEmail.getText();
                        
                        if(val instanceof Planner){
                            try {
                                temp.admin.modificaPlanner((Planner)val, username, password, nome, email);
                            } catch (SQLException ex) {
                                JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), "ERRORE", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        else{
                            try{
                                temp.admin.modificaMaintainer((Maintainer)val, username, password, nome, email, null, null);
                            }catch (SQLException ex){
                                JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), "ERRORE", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        JOptionPane.showMessageDialog(new JFrame(), "Modifica avvenuta con successo", "", JOptionPane.INFORMATION_MESSAGE);
                        frame.setVisible(true);
                        frame1.dispose();
                        
                    }
                    
                });
            }              
        });
        buttonCancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    temp.setVisible(true);
                    frame.dispose();
                    }
                });
        
        
        
    }//GEN-LAST:event_buttonModifyActionPerformed

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
            java.util.logging.Logger.getLogger(AdminDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDemo().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCreate;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonModify;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lableBenvenuto;
    // End of variables declaration//GEN-END:variables
}
