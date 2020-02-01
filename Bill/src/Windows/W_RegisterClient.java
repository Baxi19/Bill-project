/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Windows;

import Class.SQLiteMethods;
import javax.swing.JOptionPane;

/**
 *
 * @author Fabian
 */
public class W_RegisterClient extends javax.swing.JFrame {
    int clientId;
    int format;
    W_Menu wm;

    /**
     * Creates new form W_RegisterClient
     */
    public W_RegisterClient(int format, W_Menu wm) {
        initComponents();
        this.setSize(450,300);
        setLocationRelativeTo(null);
        this.wm = wm;
        this.format = format;
        if(format==1){
            loadRegisterClient();
        }
        else{
            loadRegisterNotify();
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

        jButton2 = new javax.swing.JButton();
        jButtonClose1 = new javax.swing.JButton();
        jLabelTitle = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jTextFieldDirection = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jTextFieldTelephone = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabelExport = new javax.swing.JLabel();
        jTextFieldExport = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListClients = new javax.swing.JList<>();
        jLabel21 = new javax.swing.JLabel();
        jButtonLogin3 = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(467, 3));
        getContentPane().setLayout(null);

        jButtonClose1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close1.png"))); // NOI18N
        jButtonClose1.setBorder(null);
        jButtonClose1.setBorderPainted(false);
        jButtonClose1.setContentAreaFilled(false);
        jButtonClose1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonClose1.setRequestFocusEnabled(false);
        jButtonClose1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close2.png"))); // NOI18N
        jButtonClose1.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close2.png"))); // NOI18N
        jButtonClose1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close2.png"))); // NOI18N
        jButtonClose1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonClose1MouseClicked(evt);
            }
        });
        jButtonClose1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClose1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonClose1);
        jButtonClose1.setBounds(370, 10, 70, 60);

        jLabelTitle.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTitle.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitle.setText("Registrar nuevo cliente");
        getContentPane().add(jLabelTitle);
        jLabelTitle.setBounds(20, 10, 320, 29);

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Nombre");
        getContentPane().add(jLabel20);
        jLabel20.setBounds(20, 50, 80, 30);

        jTextFieldName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNameActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldName);
        jTextFieldName.setBounds(110, 60, 230, 24);

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Direccíon");
        getContentPane().add(jLabel24);
        jLabel24.setBounds(20, 90, 80, 30);

        jTextFieldDirection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDirectionActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldDirection);
        jTextFieldDirection.setBounds(110, 100, 230, 24);

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Teléfono");
        getContentPane().add(jLabel22);
        jLabel22.setBounds(20, 140, 80, 30);

        jTextFieldTelephone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTelephoneActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldTelephone);
        jTextFieldTelephone.setBounds(110, 140, 230, 24);

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Email");
        getContentPane().add(jLabel25);
        jLabel25.setBounds(20, 180, 80, 30);

        jTextFieldEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEmailActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldEmail);
        jTextFieldEmail.setBounds(110, 180, 230, 24);

        jLabelExport.setBackground(new java.awt.Color(255, 255, 255));
        jLabelExport.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabelExport.setForeground(new java.awt.Color(255, 255, 255));
        jLabelExport.setText("Exporte");
        getContentPane().add(jLabelExport);
        jLabelExport.setBounds(20, 220, 80, 30);

        jTextFieldExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldExportActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldExport);
        jTextFieldExport.setBounds(110, 220, 230, 24);

        jListClients.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListClients.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListClientsValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jListClients);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(110, 220, 230, 60);

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Registrar");
        getContentPane().add(jLabel21);
        jLabel21.setBounds(370, 200, 80, 30);

        jButtonLogin3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/entrar.png"))); // NOI18N
        jButtonLogin3.setBorder(null);
        jButtonLogin3.setBorderPainted(false);
        jButtonLogin3.setContentAreaFilled(false);
        jButtonLogin3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonLogin3.setRequestFocusEnabled(false);
        jButtonLogin3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/entrar2.png"))); // NOI18N
        jButtonLogin3.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/entrar2.png"))); // NOI18N
        jButtonLogin3.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/entrar2.png"))); // NOI18N
        jButtonLogin3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonLogin3MouseClicked(evt);
            }
        });
        jButtonLogin3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogin3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLogin3);
        jButtonLogin3.setBounds(360, 220, 80, 70);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Hydrogen.jpg"))); // NOI18N
        bg.setMaximumSize(new java.awt.Dimension(450, 300));
        bg.setMinimumSize(new java.awt.Dimension(450, 300));
        bg.setPreferredSize(new java.awt.Dimension(450, 300));
        getContentPane().add(bg);
        bg.setBounds(0, 0, 450, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNameActionPerformed

    private void jTextFieldExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldExportActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldExportActionPerformed

    private void jTextFieldDirectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDirectionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDirectionActionPerformed

    private void jTextFieldEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEmailActionPerformed

    private void jTextFieldTelephoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTelephoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTelephoneActionPerformed

    private void jButtonLogin3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonLogin3MouseClicked
        
    }//GEN-LAST:event_jButtonLogin3MouseClicked

    private void jButtonLogin3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogin3ActionPerformed
        // TODO add your handling code here:
        if(format == 1){
            String name = jTextFieldName.getText();
            String export = jTextFieldExport.getText();
            String direction = jTextFieldDirection.getText();
            String phone = jTextFieldTelephone.getText();
            String email = jTextFieldEmail.getText();
            JOptionPane.showMessageDialog(rootPane, SQLiteMethods.getInstance().addClient(name, export, direction, phone)); 
            SQLiteMethods.getInstance().addEmail(SQLiteMethods.getInstance().getLastID(), email);
            jTextFieldName.setText("");
            jTextFieldExport.setText("");
            jTextFieldDirection.setText("");
            jTextFieldTelephone.setText("");
            jTextFieldEmail.setText("");
            wm.loadClients();
            this.dispose();
        }
        else{
            String name = jTextFieldName.getText();
            String direction = jTextFieldDirection.getText();
            String phone = jTextFieldTelephone.getText();
            String email = jTextFieldEmail.getText();
            JOptionPane.showMessageDialog(rootPane, SQLiteMethods.getInstance().addNotifyTo(name, direction, phone, email, clientId)); 
            jTextFieldName.setText("");
            jTextFieldExport.setText("");
            jTextFieldDirection.setText("");
            jTextFieldTelephone.setText("");
            jTextFieldEmail.setText("");
            wm.loadNotifyTo();
            this.dispose();
        } 
    }//GEN-LAST:event_jButtonLogin3ActionPerformed

    private void jButtonClose1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonClose1MouseClicked
        this.dispose();
    }//GEN-LAST:event_jButtonClose1MouseClicked

    private void jButtonClose1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClose1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonClose1ActionPerformed

    private void jListClientsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListClientsValueChanged
        // TODO add your handling code here:
         String client = jListClients.getSelectedValue();
         String[] dataClient = client.split("\\) ");
         this.clientId = Integer.parseInt(dataClient[0]);
    }//GEN-LAST:event_jListClientsValueChanged


    public void loadRegisterNotify(){
        jTextFieldExport.setVisible(false);
        jScrollPane1.setVisible(true);
        jListClients.setVisible(true);
        jLabelExport.setText("Cliente:");
        jLabelTitle.setText("Registrar nuevo notificado");
        jListClients.setModel(SQLiteMethods.getInstance().getClientList());
    }
    
    public void loadRegisterClient(){
        jScrollPane1.setVisible(false);
        jListClients.setVisible(false);
        jTextFieldExport.setVisible(true);
        jLabelExport.setText("Exporte:");
        jLabelTitle.setText("Registrar nuevo cliente");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonClose1;
    private javax.swing.JButton jButtonLogin3;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabelExport;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JList<String> jListClients;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldDirection;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldExport;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldTelephone;
    // End of variables declaration//GEN-END:variables
}
