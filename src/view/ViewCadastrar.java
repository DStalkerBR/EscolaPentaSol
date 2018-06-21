package view;

public class ViewCadastrar extends javax.swing.JFrame {

    public ViewCadastrar() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButtonCadAluno = new javax.swing.JButton();
        jButtonCadMaterial = new javax.swing.JButton();
        jButtonCadAula = new javax.swing.JButton();
        jButtonCadProfessor = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastrar - Escola PentaSol");
        setMaximumSize(new java.awt.Dimension(1200, 768));
        setSize(new java.awt.Dimension(1200, 768));

        jPanel2.setPreferredSize(new java.awt.Dimension(1200, 768));
        jPanel2.setLayout(null);

        jButtonCadAluno.setFont(new java.awt.Font("Humanst521 Lt BT", 0, 18)); // NOI18N
        jButtonCadAluno.setText("Clique");
        jButtonCadAluno.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonCadAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadAlunoActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonCadAluno);
        jButtonCadAluno.setBounds(130, 670, 140, 20);

        jButtonCadMaterial.setFont(new java.awt.Font("Humanst521 Lt BT", 0, 18)); // NOI18N
        jButtonCadMaterial.setText("Clique");
        jButtonCadMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadMaterialActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonCadMaterial);
        jButtonCadMaterial.setBounds(970, 670, 140, 20);

        jButtonCadAula.setFont(new java.awt.Font("Humanst521 Lt BT", 0, 18)); // NOI18N
        jButtonCadAula.setText("Clique");
        jButtonCadAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadAulaActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonCadAula);
        jButtonCadAula.setBounds(690, 670, 140, 20);

        jButtonCadProfessor.setFont(new java.awt.Font("Humanst521 Lt BT", 0, 18)); // NOI18N
        jButtonCadProfessor.setText("Clique");
        jButtonCadProfessor.setMaximumSize(new java.awt.Dimension(47, 25));
        jButtonCadProfessor.setMinimumSize(new java.awt.Dimension(47, 25));
        jButtonCadProfessor.setPreferredSize(new java.awt.Dimension(47, 25));
        jButtonCadProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadProfessorActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonCadProfessor);
        jButtonCadProfessor.setBounds(410, 670, 140, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/CadastrarRes2.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(0, 0, 1200, 768);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCadAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadAlunoActionPerformed
        new ViewCadAluno().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonCadAlunoActionPerformed

    private void jButtonCadProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadProfessorActionPerformed
        new ViewCadFuncionario().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonCadProfessorActionPerformed

    private void jButtonCadAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadAulaActionPerformed
        new ViewCadAula().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonCadAulaActionPerformed

    private void jButtonCadMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadMaterialActionPerformed
        new ViewCadMaterial().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonCadMaterialActionPerformed

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
            java.util.logging.Logger.getLogger(ViewCadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewCadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewCadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewCadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewCadastrar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCadAluno;
    private javax.swing.JButton jButtonCadAula;
    private javax.swing.JButton jButtonCadMaterial;
    private javax.swing.JButton jButtonCadProfessor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
