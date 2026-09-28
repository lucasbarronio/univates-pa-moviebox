package br.univates.moviebox.view;

import br.univates.moviebox.controller.ListasController;
import br.univates.moviebox.controller.FilmesController;
import br.univates.moviebox.controller.FilmesListasController;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import br.univates.moviebox.models.Filme;
import br.univates.moviebox.models.FilmeLista;
import br.univates.moviebox.models.Lista;
import br.univates.moviebox.utils.ComboItem;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
/**
 *
 * @author lucas
 */
public class IfrListas extends javax.swing.JInternalFrame {
    
    ListasController listasController;
    FilmesController filmesController;
    FilmesListasController filmesListasController;
    javax.swing.JComboBox<ComboItem> cmbFilmes;
    javax.swing.JTable tblFilmesDaLista;
    javax.swing.JLabel lblStatusFilmes;
    
    public IfrListas() {
        initComponents();
        listasController = new ListasController();
        filmesController = new FilmesController();
        filmesListasController = new FilmesListasController();
        configuraRelacionamentos();
        carregaInformacoes(txtPesquisar.getText());
    }
    
    private void carregaInformacoes(String criterio) {
        ArrayList<Lista> listas = listasController.recuperarTodos(criterio);
        if (listas == null) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao consultar as listas.");
        } else {
            tblListas.setModel(new AbstractTableModel() {
                @Override
                public String getColumnName(int column) {
                    switch (column) {
                        case 0:
                            return "Código";
                        case 1:
                            return "Nome";
                        case 2:
                            return "Descrição";
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
                    return listas.size();
                }
                
                @Override
                public Object getValueAt(int rowIndex, int columnIndex) {
                    Lista t = listas.get(rowIndex);
                    
                    if (t != null) {
                        switch (columnIndex) {
                            case 0:
                                return t.getId();
                            case 1:
                                return t.getNome();
                            case 2:
                                return t.getDescricao();
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
        txtDescricao = new javax.swing.JTextField();
        jlblDescricao = new javax.swing.JLabel();
        jlblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        txtPesquisar = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblListas = new javax.swing.JTable();

        setClosable(true);
        setResizable(true);
        setTitle("Listas");

        jlblNome.setText("Nome:");

        btnSalvar.setText("Cadastrar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        txtDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescricaoActionPerformed(evt);
            }
        });

        jlblDescricao.setText("Descrição:");

        jlblCodigo.setText("Código:");

        txtCodigo.setEditable(false);

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
                    .addComponent(txtDescricao)
                    .addComponent(jlblDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCodigo)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 9, Short.MAX_VALUE)))
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
                .addComponent(jlblDescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        tblListas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblListas.setShowGrid(true);
        jScrollPane2.setViewportView(tblListas);

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
        txtDescricao.setText("");
    }

    private void configuraRelacionamentos() {
        javax.swing.JPanel painel = new javax.swing.JPanel(new java.awt.BorderLayout(8, 8));
        javax.swing.JPanel controles = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        cmbFilmes = new javax.swing.JComboBox<>();
        javax.swing.JButton btnAdicionar = new javax.swing.JButton("Adicionar filme");
        javax.swing.JButton btnRemover = new javax.swing.JButton("Remover filme");
        tblFilmesDaLista = new javax.swing.JTable();
        lblStatusFilmes = new javax.swing.JLabel("Selecione uma lista para consultar seus filmes.");

        controles.add(new javax.swing.JLabel("Filme:"));
        controles.add(cmbFilmes);
        controles.add(btnAdicionar);
        controles.add(btnRemover);
        painel.add(controles, java.awt.BorderLayout.NORTH);
        painel.add(new javax.swing.JScrollPane(tblFilmesDaLista), java.awt.BorderLayout.CENTER);
        painel.add(lblStatusFilmes, java.awt.BorderLayout.SOUTH);
        jTabbedPane1.addTab("Filmes da lista", painel);

        btnAdicionar.addActionListener(evt -> adicionarFilmeALista());
        btnRemover.addActionListener(evt -> removerFilmeDaLista());
        tblListas.getSelectionModel().addListSelectionListener(evt -> carregaFilmesDaLista());
        carregaFilmesDisponiveis();
    }

    private void carregaFilmesDisponiveis() {
        cmbFilmes.removeAllItems();
        for (Filme filme : filmesController.recuperarTodos("")) {
            ComboItem item = new ComboItem();
            item.setCodigo(filme.getId());
            item.setDescricao(filme.getTitulo());
            cmbFilmes.addItem(item);
        }
    }

    private void carregaFilmesDaLista() {
        int linha = tblListas.getSelectedRow();
        if (linha < 0) {
            tblFilmesDaLista.setModel(new javax.swing.table.DefaultTableModel());
            lblStatusFilmes.setText("Selecione uma lista para consultar seus filmes.");
            return;
        }

        int idLista = Integer.parseInt(String.valueOf(tblListas.getModel().getValueAt(linha, 0)));
        ArrayList<FilmeLista> relacionamentos = filmesListasController.recuperaPorLista(idLista);
        tblFilmesDaLista.setModel(new javax.swing.table.AbstractTableModel() {
            @Override
            public int getRowCount() {
                return relacionamentos.size();
            }

            @Override
            public int getColumnCount() {
                return 2;
            }

            @Override
            public String getColumnName(int column) {
                return column == 0 ? "Código" : "Filme";
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                Filme filme = relacionamentos.get(rowIndex).getFilme();
                return columnIndex == 0 ? filme.getId() : filme.getTitulo();
            }
        });
        lblStatusFilmes.setText(relacionamentos.isEmpty()
                ? "Nenhuma relação cadastrada."
                : relacionamentos.size() + " filme(s) relacionado(s).");
    }

    private void adicionarFilmeALista() {
        int linha = tblListas.getSelectedRow();
        ComboItem item = (ComboItem) cmbFilmes.getSelectedItem();
        if (linha < 0 || item == null) {
            JOptionPane.showMessageDialog(null, "Selecione uma lista e um filme.");
            return;
        }

        int idLista = Integer.parseInt(String.valueOf(tblListas.getModel().getValueAt(linha, 0)));
        FilmeLista relacionamento = new FilmeLista(new Filme(item.getCodigo()), new Lista(idLista));
        if (filmesListasController.existe(relacionamento)) {
            JOptionPane.showMessageDialog(null, "Este filme já está nesta lista.");
            return;
        }

        filmesListasController.salvar(relacionamento);
        carregaFilmesDaLista();
        JOptionPane.showMessageDialog(null, "Filme adicionado à lista.");
    }

    private void removerFilmeDaLista() {
        int linhaLista = tblListas.getSelectedRow();
        int linhaFilme = tblFilmesDaLista.getSelectedRow();
        if (linhaLista < 0 || linhaFilme < 0) {
            JOptionPane.showMessageDialog(null, "Selecione uma lista e um filme relacionado.");
            return;
        }

        int idLista = Integer.parseInt(String.valueOf(tblListas.getModel().getValueAt(linhaLista, 0)));
        int idFilme = Integer.parseInt(String.valueOf(tblFilmesDaLista.getModel().getValueAt(linhaFilme, 0)));
        filmesListasController.excluir(idFilme, idLista);
        carregaFilmesDaLista();
        JOptionPane.showMessageDialog(null, "Filme removido da lista.");
    }
    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        carregaInformacoes(txtPesquisar.getText());
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void txtDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescricaoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        String nome = txtNome.getText();
        String descricao = txtDescricao.getText();
        
        if (txtCodigo.getText().equals("")) {
            Lista novaLista = new Lista(nome, descricao);
            boolean retorno = listasController.salvar(novaLista);
            if (retorno) {
                limpaCampos();
                carregaInformacoes(txtPesquisar.getText());
                txtNome.grabFocus();
            } else {
                
            }
        } else {
            int codigo = Integer.parseInt(txtCodigo.getText());
            Lista editarLista = new Lista(codigo, nome, descricao);
            boolean retorno = listasController.editar(editarLista);
            if (retorno) {
                limpaCampos();
                carregaInformacoes(txtPesquisar.getText());
                txtNome.grabFocus();
            } else {
                
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int linha = tblListas.getSelectedRow();
        if (linha < 0) {
            JOptionPane.showMessageDialog(null, "Selecione uma lista.");
            return;
        }
        int codigo = Integer.parseInt(String.valueOf(tblListas.getModel().getValueAt(linha, 0)));
        
        Lista listas = listasController.recuperaUm(codigo);
        if (listas == null) {
            JOptionPane.showMessageDialog(null, "Lista não encontrada.");
        } else {
            txtCodigo.setText(String.valueOf(codigo));
            txtNome.setText(listas.getNome());
            txtDescricao.setText(listas.getDescricao());
            jTabbedPane1.setSelectedIndex(0);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int linha = tblListas.getSelectedRow();
        if (linha < 0) {
            JOptionPane.showMessageDialog(null, "Selecione uma lista.");
            return;
        }
        int codigo = Integer.parseInt(String.valueOf(tblListas.getModel().getValueAt(linha, 0)));
        
        Lista listas = listasController.recuperaUm(codigo);
        if (listas == null) {
            JOptionPane.showMessageDialog(null, "Lista não encontrada.");
        } else {
            boolean retorno = listasController.excluir(codigo);
            if (retorno) {
                JOptionPane.showMessageDialog(null, "Lista " + codigo + " apagada com sucesso!");
                carregaInformacoes(txtPesquisar.getText());
            } else {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar excluir a Lista " + codigo);
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
    private javax.swing.JLabel jlblDescricao;
    private javax.swing.JLabel jlblNome;
    private javax.swing.JTable tblListas;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPesquisar;
    // End of variables declaration//GEN-END:variables
}
