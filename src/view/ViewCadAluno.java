package view;

import model.bean.Usuario;
import javax.swing.JOptionPane;
import model.dao.UsuarioDAO;
import validacoes.*;

public class ViewCadAluno extends javax.swing.JFrame {

    ValidarCPF validarCpf;
    ValidarEmail validarEmail;
    AutenticacaoData validarData;
    boolean cpf;
    boolean email;
    boolean data;

    public ViewCadAluno() {
        initComponents();
        validarCpf = new ValidarCPF();
        validarEmail = new ValidarEmail();
        validarData = new AutenticacaoData();

        cpf = false;
        email = false;
        data = false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButtonCadastrar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtNomeCompleto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        dtNascUsuario = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        cpfUsuario = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        emailUsuario = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        possuiInstrumento = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastrar Aluno - Escola PentaSol");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setBackground(new java.awt.Color(255, 0, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Logo - PentaSol");

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel4.setText("Cadastrar Aluno");

        jButtonCadastrar.setFont(new java.awt.Font("Geometr415 Blk BT", 0, 18)); // NOI18N
        jButtonCadastrar.setText("Cadastrar");
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        jLabel5.setText("Nome Completo");

        txtNomeCompleto.setText("Nome Completo");

        jLabel6.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        jLabel6.setText("Data de Nascimento");

        dtNascUsuario.setText(" / /");
        dtNascUsuario.setToolTipText("");

        jLabel7.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        jLabel7.setText("CPF");

        cpfUsuario.setText("   .   .   -  ");
        cpfUsuario.setToolTipText("");
        cpfUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpfUsuarioActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        jLabel8.setText("Email");

        emailUsuario.setText("email");

        jLabel9.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        jLabel9.setText("Possui Instrumento?");

        possuiInstrumento.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        possuiInstrumento.setText("Sim");

        jCheckBox2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jCheckBox2.setText("Não");

        jLabel10.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        jLabel10.setText("Endereço");

        txtEndereco.setText("Endereço");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dtNascUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cpfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel4))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(75, 75, 75)
                        .addComponent(possuiInstrumento)
                        .addGap(60, 60, 60)
                        .addComponent(jCheckBox2))
                    .addComponent(jLabel5)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emailUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNomeCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(136, 136, 136))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNomeCompleto))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(dtNascUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtEndereco))
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cpfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(emailUsuario))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(possuiInstrumento)
                        .addComponent(jCheckBox2))
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addComponent(jButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed
        //Mensagens de erro
        /*msgEmailErro.setVisible(false);
        msgCPFErro.setVisible(false);
        msgDataErro.setVisible(false);
         */
        String varCpf = cpfUsuario.getText();
        String varEmail = emailUsuario.getText();
        String varDataNasc = dtNascUsuario.getText();
        String varEndereco = txtEndereco.getText();
        System.out.println(varDataNasc);

        if (validarData.validarNascimento(varDataNasc)) {            //Checa se a data de nascimento é válida
            System.out.println("NASCIMENTO CORRETO!");
            dtNascUsuario.setText(varDataNasc);
        } else {
            System.out.println("NASCIMENTO INCORRETO!");
            data = true; // msgDataErro.setVisible(true);
        }

        if (validarEmail.validarEmail(varEmail)) {                //Checa se o email é valido
            System.out.println("EMAIL CORRETO!");
            emailUsuario.setText(varEmail);
        } else {
            System.out.println("EMAIL INCORRETO!");
            email = true;// msgEmailErro.setVisible(true);
        }

        if (validarCpf.isCPF(varCpf)) {
            System.out.println("CPF CORRETO!");//Checa se o cpf  é valido
            cpfUsuario.setText(validarCpf.imprimeCPF(varCpf));
            //msgCPFErro.setVisible(false);
        } else {
            System.out.println("CPF INCORRETO!");
            cpf = true;// msgCPFErro.setVisible(true);
        }

        if (cpf || email || data) {
            JOptionPane.showMessageDialog(null,
                    "Contem erros",
                    "ERRO",
                    JOptionPane.ERROR_MESSAGE);
            System.out.println("ERRO");
        } else {
            System.out.println("CERTO");
            Usuario novoUsuario = new Usuario(txtNomeCompleto.getText(),
                    varDataNasc, varEndereco, varEmail,
                    varCpf, possuiInstrumento.isSelected());
            UsuarioDAO daoUsuario = new UsuarioDAO();
            daoUsuario.create(novoUsuario);

            JOptionPane.showMessageDialog(null,
                    "Aluno Cadastrado!",
                    "Confirmação de Cadastro",
                    JOptionPane.OK_OPTION);
        }							//Descartar janela atual
    }//GEN-LAST:event_jButtonCadastrarActionPerformed

    private void cpfUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpfUsuarioActionPerformed

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
            java.util.logging.Logger.getLogger(ViewCadAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewCadAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewCadAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewCadAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewCadAluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField cpfUsuario;
    private javax.swing.JFormattedTextField dtNascUsuario;
    private javax.swing.JTextField emailUsuario;
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JCheckBox possuiInstrumento;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNomeCompleto;
    // End of variables declaration//GEN-END:variables
}
