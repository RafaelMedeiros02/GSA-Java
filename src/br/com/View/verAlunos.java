/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.View;

import br.com.DAO.AlunosDAO;
import br.com.Model.ModelAlunos;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rafael Medeiros
 */
public class verAlunos extends javax.swing.JFrame {

     public void pesquisaAlunos_porNome() {
                
        DefaultTableModel tabelaAlunos = (DefaultTableModel) jTableAlunos.getModel();
        AlunosDAO adao = new AlunosDAO();
        try {
            tabelaAlunos.setNumRows(0);
            for (ModelAlunos mA : adao.pesquisarAlunos(jTextFieldPesquisa.getText())) {
                tabelaAlunos.addRow(new Object[]{
                   mA.getRM(),
                   mA.getRA(),
                   mA.getNome(),
                   mA.getDataNasc(),
                   mA.getEndereco(),
                   mA.getTelefone(),
                   mA.getDataIngresso(),
                   mA.getPeriodo(),
                   mA.getSituacao()
                });
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    
    }
     
        public void pesquisaAlunos_porRA() {
                
        DefaultTableModel tabelaAlunos = (DefaultTableModel) jTableAlunos.getModel();
        AlunosDAO adao = new AlunosDAO();
        try {
            tabelaAlunos.setNumRows(0);
            for (ModelAlunos mA : adao.pesquisarAlunos_RA(jTextFieldPesquisa.getText())) {
                tabelaAlunos.addRow(new Object[]{
                   mA.getRM(),
                   mA.getRA(),
                   mA.getNome(),
                   mA.getDataNasc(),
                   mA.getEndereco(),
                   mA.getTelefone(),
                   mA.getDataIngresso(),
                   mA.getPeriodo(),
                   mA.getSituacao()
                });
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    
    }
        
           public void pesquisaAlunos_porRM() {
                
        DefaultTableModel tabelaAlunos = (DefaultTableModel) jTableAlunos.getModel();
        AlunosDAO adao = new AlunosDAO();
        try {
            tabelaAlunos.setNumRows(0);
            for (ModelAlunos mA : adao.pesquisarAlunos_RM(jTextFieldPesquisa.getText())) {
                tabelaAlunos.addRow(new Object[]{
                   mA.getRM(),
                   mA.getRA(),
                   mA.getNome(),
                   mA.getDataNasc(),
                   mA.getEndereco(),
                   mA.getTelefone(),
                   mA.getDataIngresso(),
                   mA.getPeriodo(),
                   mA.getSituacao()
                });
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    
    }
    
    
    
    
    public verAlunos() {
        initComponents();
         setIconImage(new ImageIcon("Img/iconeSistema.png").getImage());
        setTitle("GSA - Gerenciamento de Secretaria Agil  ");
        jRadioButtonNome.setSelected(true);
        pesquisaAlunos_porNome();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTextFieldRM = new javax.swing.JTextField();
        Fundo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jRadioButtonRA = new javax.swing.JRadioButton();
        jRadioButtonRM = new javax.swing.JRadioButton();
        jRadioButtonNome = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldPesquisa = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAlunos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldNomeSelecionado = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        jTextFieldRM.setEditable(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Filtrar alunos por:");

        buttonGroup1.add(jRadioButtonRA);
        jRadioButtonRA.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButtonRA.setText("RA");

        buttonGroup1.add(jRadioButtonRM);
        jRadioButtonRM.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButtonRM.setText("RM");

        buttonGroup1.add(jRadioButtonNome);
        jRadioButtonNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButtonNome.setText("Nome");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Informe:");

        jTextFieldPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldPesquisaKeyReleased(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTableAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RM", "RA", "NOME", "DATA NASC", "ENDERECO", "TELEFONE", "DATA ING", "PERIODO", "SITUACAO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableAlunos.getTableHeader().setReorderingAllowed(false);
        jTableAlunos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAlunosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableAlunos);
        if (jTableAlunos.getColumnModel().getColumnCount() > 0) {
            jTableAlunos.getColumnModel().getColumn(0).setResizable(false);
            jTableAlunos.getColumnModel().getColumn(0).setPreferredWidth(130);
            jTableAlunos.getColumnModel().getColumn(1).setResizable(false);
            jTableAlunos.getColumnModel().getColumn(1).setPreferredWidth(130);
            jTableAlunos.getColumnModel().getColumn(2).setResizable(false);
            jTableAlunos.getColumnModel().getColumn(2).setPreferredWidth(159);
            jTableAlunos.getColumnModel().getColumn(3).setResizable(false);
            jTableAlunos.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTableAlunos.getColumnModel().getColumn(4).setResizable(false);
            jTableAlunos.getColumnModel().getColumn(4).setPreferredWidth(200);
            jTableAlunos.getColumnModel().getColumn(5).setResizable(false);
            jTableAlunos.getColumnModel().getColumn(5).setPreferredWidth(100);
            jTableAlunos.getColumnModel().getColumn(6).setResizable(false);
            jTableAlunos.getColumnModel().getColumn(6).setPreferredWidth(100);
            jTableAlunos.getColumnModel().getColumn(7).setResizable(false);
            jTableAlunos.getColumnModel().getColumn(7).setPreferredWidth(70);
            jTableAlunos.getColumnModel().getColumn(8).setResizable(false);
            jTableAlunos.getColumnModel().getColumn(8).setPreferredWidth(70);
        }

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Selecionado:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 950, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNomeSelecionado, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldNomeSelecionado, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Img/icons8-cancelar-20.png"))); // NOI18N
        jButton1.setText("Excluir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Img/icons8-documento-20.png"))); // NOI18N
        jButton3.setText("Declaração");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Img/escola.png"))); // NOI18N

        javax.swing.GroupLayout FundoLayout = new javax.swing.GroupLayout(Fundo);
        Fundo.setLayout(FundoLayout);
        FundoLayout.setHorizontalGroup(
            FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FundoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(FundoLayout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(FundoLayout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jRadioButtonRA)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jRadioButtonRM)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jRadioButtonNome))
                                .addGroup(FundoLayout.createSequentialGroup()
                                    .addComponent(jButton1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton3))
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(FundoLayout.createSequentialGroup()
                            .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FundoLayout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(530, 530, 530))
                                .addGroup(FundoLayout.createSequentialGroup()
                                    .addComponent(jSeparator4, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                                    .addGap(521, 521, 521)))
                            .addComponent(jLabel4)
                            .addGap(27, 27, 27)))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        FundoLayout.setVerticalGroup(
            FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FundoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jRadioButtonRA)
                    .addComponent(jRadioButtonRM)
                    .addComponent(jRadioButtonNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FundoLayout.createSequentialGroup()
                        .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton3)))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jMenu1.setText("Atalhos");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jMenuItem1.setText("Atualizar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1017, 625));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPesquisaKeyReleased
       if (jRadioButtonRA.isSelected()) {
            pesquisaAlunos_porRA();
       } 
       else {
       if (jRadioButtonRM.isSelected()) {
           pesquisaAlunos_porRM();
       }
       else {
       if (jRadioButtonNome.isSelected()) {
           pesquisaAlunos_porNome();
       }
       }
       
       }
    }//GEN-LAST:event_jTextFieldPesquisaKeyReleased

    private void jTableAlunosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAlunosMouseClicked
            int setar = jTableAlunos.getSelectedRow();
            jTextFieldRM.setText(jTableAlunos.getModel().getValueAt(setar, 0).toString());
            jTextFieldNomeSelecionado.setText(jTableAlunos.getModel().getValueAt(setar,2).toString());
            
            int escolha = JOptionPane.showConfirmDialog(null, "Visualizar ficha completa? ", "Informações", JOptionPane.YES_NO_OPTION);
            if (escolha == JOptionPane.YES_OPTION) {
                
            CadastrarAluno cA = new CadastrarAluno();
            cA.jButtonCadastrar.setEnabled(false);
            cA.jTextFieldNomeAluno.setText(jTableAlunos.getModel().getValueAt(setar,2).toString());
            cA.jFormattedTextFieldDataNascimento.setText(jTableAlunos.getModel().getValueAt(setar,3).toString());
            cA.jTextFieldEndereco.setText(jTableAlunos.getModel().getValueAt(setar,4).toString());
            cA.jFormattedTextFieldDataIngresso.setText(jTableAlunos.getModel().getValueAt(setar,6).toString());
            cA.jTextFieldRA.setText(jTableAlunos.getModel().getValueAt(setar,1).toString());
            cA.jTextFieldRM.setText(jTableAlunos.getModel().getValueAt(setar,0).toString());
            cA.jComboBoxPeriodo.setSelectedItem((jTableAlunos.getModel().getValueAt(setar,7).toString()));
            cA.jComboBoxSituacao.setSelectedItem((jTableAlunos.getModel().getValueAt(setar,8).toString()));
            cA.jTextFieldTelefone.setText(jTableAlunos.getModel().getValueAt(setar,5).toString());
            cA.setVisible(true);
            } else {
            
            }
            

    }//GEN-LAST:event_jTableAlunosMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       if (jTextFieldNomeSelecionado.getText().isEmpty()
               ||jTextFieldRM.getText().isEmpty()) {
       JOptionPane.showMessageDialog(null, "Selecione algum aluno antes de apagar!", "Alerta", JOptionPane.WARNING_MESSAGE);
       }
       else {
            int escolha = JOptionPane.showConfirmDialog(null, "Deseja apagar o aluno: " + jTextFieldNomeSelecionado.getText() + "?", "Cadastro", JOptionPane.YES_NO_OPTION);
       if (escolha == JOptionPane.YES_OPTION) {
           ModelAlunos mA = new ModelAlunos();
           mA.setNome(jTextFieldNomeSelecionado.getText());
           mA.setRM(Integer.parseInt(jTextFieldRM.getText()));
           AlunosDAO adao = new AlunosDAO();
           adao.apagarAluno(mA);
           JOptionPane.showMessageDialog(null, "Aluno apagado com sucesso!");
           this.dispose();
           new verAlunos().setVisible(true);
       }
       }
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       Declaracoes D = new Declaracoes();
        int setar = jTableAlunos.getSelectedRow();
       D.jTextFieldNomeSelected.setText(jTableAlunos.getModel().getValueAt(setar,2).toString());
       D.jTextFieldRA.setText(jTableAlunos.getModel().getValueAt(setar,1).toString());
       D.jTextFieldPeriodo.setText(jTableAlunos.getModel().getValueAt(setar,7).toString());
       D.jTextFieldDataNasc.setText(jTableAlunos.getModel().getValueAt(setar,3).toString());
       this.dispose();
       D.show();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       this.dispose();
           new verAlunos().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(verAlunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(verAlunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(verAlunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(verAlunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new verAlunos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fundo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButtonNome;
    private javax.swing.JRadioButton jRadioButtonRA;
    private javax.swing.JRadioButton jRadioButtonRM;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable jTableAlunos;
    private javax.swing.JTextField jTextFieldNomeSelecionado;
    private javax.swing.JTextField jTextFieldPesquisa;
    private javax.swing.JTextField jTextFieldRM;
    // End of variables declaration//GEN-END:variables
}
