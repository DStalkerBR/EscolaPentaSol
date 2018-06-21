package view;

import control.LoginController;
import java.awt.Color;
import javax.swing.JOptionPane;
import model.bean.Administrador;
import model.bean.Professor;
import services.Sessao;

public class ViewLogin extends javax.swing.JFrame {

    public ViewLogin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        txtLogin = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        Acessar = new javax.swing.JButton();
        lembrar = new javax.swing.JCheckBox();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login - Escola PentaSol");
        setUndecorated(true);
        setSize(new java.awt.Dimension(738, 665));

        jPanel3.setBackground(new java.awt.Color(153, 54, 85));
        jPanel3.setForeground(new java.awt.Color(204, 204, 204));
        jPanel3.setLayout(null);

        txtLogin.setBackground(new java.awt.Color(196, 179, 191));
        txtLogin.setFont(new java.awt.Font("Humanst521 Lt BT", 0, 18)); // NOI18N
        txtLogin.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(196, 179, 191)));
        txtLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLoginActionPerformed(evt);
            }
        });
        jPanel3.add(txtLogin);
        txtLogin.setBounds(235, 258, 200, 30);

        txtPassword.setBackground(new java.awt.Color(196, 176, 191));
        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(196, 179, 191)));
        jPanel3.add(txtPassword);
        txtPassword.setBounds(235, 308, 200, 30);

        Acessar.setBackground(new java.awt.Color(196, 179, 191));
        Acessar.setFont(new java.awt.Font("Humanst521 Lt BT", 0, 24)); // NOI18N
        Acessar.setForeground(new java.awt.Color(51, 0, 51));
        Acessar.setText("Acessar");
        Acessar.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(196, 179, 191)));
        Acessar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AcessarMouseEntered(evt);
            }
        });
        Acessar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AcessarActionPerformed(evt);
            }
        });
        jPanel3.add(Acessar);
        Acessar.setBounds(210, 370, 201, 45);

        lembrar.setBackground(new java.awt.Color(27, 33, 69));
        lembrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lembrarActionPerformed(evt);
            }
        });
        jPanel3.add(lembrar);
        lembrar.setBounds(180, 490, 21, 21);

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(27, 33, 69));
        jTextField1.setFont(new java.awt.Font("Humanst521 Lt BT", 1, 16)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(204, 204, 204));
        jTextField1.setText("Lembrar-me");
        jTextField1.setBorder(null);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField1);
        jTextField1.setBounds(205, 489, 90, 23);

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(27, 33, 69));
        jTextField2.setFont(new java.awt.Font("Humanst521 Lt BT", 1, 16)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(204, 204, 204));
        jTextField2.setText("Esqueceu a senha?");
        jTextField2.setBorder(null);
        jPanel3.add(jTextField2);
        jTextField2.setBounds(310, 490, 150, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BackgroundLogin6.png"))); // NOI18N
        jPanel3.add(jLabel1);
        jLabel1.setBounds(0, 0, 620, 650);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void txtLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoginActionPerformed
       
    }//GEN-LAST:event_txtLoginActionPerformed

    private void AcessarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AcessarMouseEntered
        Acessar.setBackground(new Color(19, 73, 58));
        Acessar.setForeground(new Color(196, 179, 191));
    }//GEN-LAST:event_AcessarMouseEntered

    private void AcessarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AcessarActionPerformed
        Object generic;        
        if ((generic = LoginController.fazerLogin(txtLogin.getText(), new String(txtPassword.getPassword()))) instanceof Administrador){
            Administrador admin = (Administrador) generic;
            Sessao sessao = Sessao.getInstance();
            sessao.setAdmin(admin);
            System.out.println(sessao.getAdmin().toString());
            new ViewGerenciamento().setVisible(true);
            this.dispose();
        } else if (generic instanceof Professor){
            Professor prof = (Professor) generic;
            Sessao sessao = Sessao.getInstance();
            sessao.setProf(prof);
            System.out.println(sessao.getProf().toString());     
            new ViewGerenciamento().setVisible(true);
            this.dispose();
        } else{
            JOptionPane.showMessageDialog(null, "Nome ou Senha Inválidos", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_AcessarActionPerformed

    private void lembrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lembrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lembrarActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    public boolean checkLogin(String login, String senha){
        return login.equals("Junior") && senha.equals("adminJunior");
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
            java.util.logging.Logger.getLogger(ViewLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Acessar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JCheckBox lembrar;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
