package br.univates.moviebox.view;

import br.univates.moviebox.controller.DiretoresController;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import br.univates.moviebox.models.Diretor;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
/**
 *
 * @author lucas
 */
public class IfrDiretores extends javax.swing.JInternalFrame {
    
    DiretoresController diretoresController;
    
    public IfrDiretores() {
        initComponents();
        diretoresController = new DiretoresController();
        carregaInformacoes(txtPesquisar.getText());
    }
    
    private void carregaInformacoes(String criterio ) {
        ArrayList<Diretor> diretores = diretoresController.recuperarTodos(criterio);
        if (diretores == null) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao consultar os diretores.");
        } else {
            tblDiretores.setModel(new AbstractTableModel() {
                @Override
                public String getColumnName(int column) {
                    switch (column) {
                        case 0:
                            return "Código";
                        case 1:
                            return "Nome";
                        case 2:
                            return "Nacionalidade";
                        default:
                            return "";
                    }
                }
                
                @Override
                public int getColumnCount() {
                    return 3;
                }
                
                @Override
                public int getRowCount() {
                    return diretores.size();
                }
                
                @Override
                public Object getValueAt(int rowIndex, int columnIndex) {
                    Diretor t = diretores.get(rowIndex);
                    
                    if (t != null) {
                        switch (columnIndex) {
                            case 0:
                                return t.getId();
                            case 1:
                                return t.getNome();
                            case 2:
                                return t.getNacionalidade();
                        }                        
                    }
                    
                    return "n/d";
                }
            });
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jlblNome = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        txtNome = new javax.swing.JTextField();
        jlblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jlblNacionalidade = new javax.swing.JLabel();
        txtNacionalidade = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        txtPesquisar = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDiretores = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setTitle("Diretores");

        jlblNome.setText("Nome:");

        btnSalvar.setText("Cadastrar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jlblCodigo.setText("Código:");

        txtCodigo.setEditable(false);

        jlblNacionalidade.setText("Nacionalidade:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalvar))
                    .addComponent(txtNome)
                    .addComponent(txtCodigo)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 9, Short.MAX_VALUE))
                    .addComponent(txtNacionalidade)
                    .addComponent(jlblNacionalidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jlblCodigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlblNacionalidade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNacionalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 312, Short.MAX_VALUE)
                .addComponent(btnSalvar)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Cadastro", jPanel1);

        txtPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisarKeyReleased(evt);
            }
        });

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        tblDiretores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblDiretores.setShowGrid(true);
        jScrollPane2.setViewportView(tblDiretores);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(txtPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEditar)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnExcluir))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Consulta", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void limpaCampos() {
        txtCodigo.setText("");
        txtNome.setText("");
        txtNacionalidade.setText("");
    }
    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        carregaInformacoes(txtPesquisar.getText());
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        String nome = txtNome.getText();
        String nacionalidade = txtNacionalidade.getText();

        
        if (txtCodigo.getText().equals("")) {
            Diretor novoDiretor = new Diretor(nome, nacionalidade);
            boolean retorno = diretoresController.salvar(novoDiretor);
            if (retorno) {
                limpaCampos();
                carregaInformacoes(txtPesquisar.getText());
                txtNome.grabFocus();
            } else {
                
            }
        } else {
            int codigo = Integer.parseInt(txtCodigo.getText());
            Diretor editarDiretor = new Diretor(codigo, nome, nacionalidade);
            boolean retorno = diretoresController.editar(editarDiretor);
            if (retorno) {
                limpaCampos();
                carregaInformacoes(txtPesquisar.getText());
                txtNome.grabFocus();
            } else {
                
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int linha = tblDiretores.getSelectedRow();
        if (linha < 0) {
            JOptionPane.showMessageDialog(null, "Selecione um diretor.");
            return;
        }
        int codigo = Integer.parseInt(String.valueOf(tblDiretores.getModel().getValueAt(linha, 0)));
        
        Diretor diretores = diretoresController.recuperaUm(codigo);
        if (diretores == null) {
            JOptionPane.showMessageDialog(null, "Diretor não encontrado.");
        } else {
            txtCodigo.setText(String.valueOf(codigo));
            txtNome.setText(diretores.getNome());
            txtNacionalidade.setText(diretores.getNacionalidade());
            jTabbedPane1.setSelectedIndex(0);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int linha = tblDiretores.getSelectedRow();
        if (linha < 0) {
            JOptionPane.showMessageDialog(null, "Selecione um diretor.");
            return;
        }
        int codigo = Integer.parseInt(String.valueOf(tblDiretores.getModel().getValueAt(linha, 0)));
        
        Diretor diretores = diretoresController.recuperaUm(codigo);
        if (diretores == null) {
            JOptionPane.showMessageDialog(null, "Diretor não encontrado.");
        } else {
            boolean retorno = diretoresController.excluir(codigo);
            if (retorno) {
                JOptionPane.showMessageDialog(null, "Diretor " + codigo + " apagado com sucesso!");
                carregaInformacoes(txtPesquisar.getText());
            } else {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar excluir o diretor " + codigo);
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void txtPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarKeyReleased
        carregaInformacoes(txtPesquisar.getText());
    }//GEN-LAST:event_txtPesquisarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel jlblCodigo;
    private javax.swing.JLabel jlblNacionalidade;
    private javax.swing.JLabel jlblNome;
    private javax.swing.JTable tblDiretores;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNacionalidade;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPesquisar;
    // End of variables declaration//GEN-END:variables
}
