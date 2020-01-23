/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Windows;

import Class.Methods;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Baxi
 */
public class W_Login extends javax.swing.JFrame {

    /**
     * Creates new form W_Main
     */
    public W_Login() {
        initComponents();
        this.setSize(1200,800);
        setLocationRelativeTo(null);
        jPanelLogin.setBackground(new Color(0, 0, 0 , 240));
        jButtonLogin.setBackground(new Color(0, 0, 0 , 240));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelLogin = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButtonLogin = new javax.swing.JButton();
        jButtonOff = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanelLogin.setBackground(new java.awt.Color(96, 96, 96));
        jPanelLogin.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 204, 204), java.awt.Color.white));
        jPanelLogin.setToolTipText("");
        jPanelLogin.setAlignmentX(0.0F);
        jPanelLogin.setAlignmentY(0.0F);
        jPanelLogin.setMaximumSize(new java.awt.Dimension(500, 400));
        jPanelLogin.setMinimumSize(new java.awt.Dimension(500, 400));
        jPanelLogin.setName("panelLogin"); // NOI18N
        jPanelLogin.setPreferredSize(new java.awt.Dimension(500, 400));
        jPanelLogin.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 148, 148));
        jLabel3.setText("Plantas Hermanos Araya");
        jLabel3.setToolTipText("");
        jPanelLogin.add(jLabel3);
        jLabel3.setBounds(50, 40, 390, 42);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo.jpg"))); // NOI18N
        jLabel6.setToolTipText("");
        jPanelLogin.add(jLabel6);
        jLabel6.setBounds(60, 130, 360, 160);

        jButtonLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/entrar.png"))); // NOI18N
        jButtonLogin.setBorder(null);
        jButtonLogin.setBorderPainted(false);
        jButtonLogin.setContentAreaFilled(false);
        jButtonLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonLogin.setRequestFocusEnabled(false);
        jButtonLogin.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/entrar2.png"))); // NOI18N
        jButtonLogin.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/entrar2.png"))); // NOI18N
        jButtonLogin.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/entrar2.png"))); // NOI18N
        jButtonLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonLoginMouseClicked(evt);
            }
        });
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });
        jPanelLogin.add(jButtonLogin);
        jButtonLogin.setBounds(230, 330, 50, 50);

        getContentPane().add(jPanelLogin);
        jPanelLogin.setBounds(350, 150, 500, 400);

        jButtonOff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/off1.png"))); // NOI18N
        jButtonOff.setBorder(null);
        jButtonOff.setBorderPainted(false);
        jButtonOff.setContentAreaFilled(false);
        jButtonOff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonOff.setRequestFocusEnabled(false);
        jButtonOff.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/off2.png"))); // NOI18N
        jButtonOff.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/off2.png"))); // NOI18N
        jButtonOff.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/off2.png"))); // NOI18N
        jButtonOff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonOffMouseClicked(evt);
            }
        });
        jButtonOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOffActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonOff);
        jButtonOff.setBounds(1120, 40, 40, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/backg.jpg"))); // NOI18N
        jLabel1.setAlignmentY(0.0F);
        jLabel1.setMaximumSize(new java.awt.Dimension(1200, 800));
        jLabel1.setMinimumSize(new java.awt.Dimension(1200, 800));
        jLabel1.setPreferredSize(new java.awt.Dimension(1200, 800));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1200, 800);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonOffMouseClicked
        Methods.getInstance().closeSystem();
    }//GEN-LAST:event_jButtonOffMouseClicked

    private void jButtonOffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOffActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonOffActionPerformed

    private void jButtonLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonLoginMouseClicked
        W_Menu w = new W_Menu();
        w.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonLoginMouseClicked

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonLoginActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Windows (introduced in Java SE 6) is not available, stay with the default look and feel.
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
            java.util.logging.Logger.getLogger(W_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(W_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(W_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(W_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new W_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JButton jButtonOff;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanelLogin;
    // End of variables declaration//GEN-END:variables
}
