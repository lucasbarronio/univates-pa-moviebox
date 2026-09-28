package br.univates.moviebox.view;

import br.univates.moviebox.controller.FilmesController;
import br.univates.moviebox.controller.DiretoresController;
import br.univates.moviebox.controller.GenerosController;
import br.univates.moviebox.controller.FilmesListasController;
import br.univates.moviebox.controller.ListasController;
import br.univates.moviebox.models.Diretor;
import br.univates.moviebox.models.FilmeLista;
import br.univates.moviebox.models.Lista;
import br.univates.moviebox.utils.ComboItem;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import br.univates.moviebox.models.Filme;
import br.univates.moviebox.models.Genero;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
/**
 *
 * @author lucas
 */
public class IfrFilmes extends javax.swing.JInternalFrame {
    
    FilmesController filmesController;
    DiretoresController diretoresController;
    GenerosController generosController;
    FilmesListasController filmesListasController;
    ListasController listasController;
    javax.swing.JComboBox<ComboItem> cmbListas;
    javax.swing.JTable tblListasDoFilme;
    javax.swing.JLabel lblStatusListas;
    
    public IfrFilmes() {
        initComponents();
        filmesController = new FilmesController();
        diretoresController = new DiretoresController();
        generosController = new GenerosController();
        filmesListasController = new FilmesListasController();
        listasController = new ListasController();
        configuraRelacionamentos();
        carregaInformacoes(txtPesquisar.getText());
    }
    
    private void carregaInformacoes(String criterio) {
        ArrayList<Filme> filmes = filmesController.recuperarTodos(criterio);
        if (filmes == null) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao consultar os filmes.");
        } else {
            tblFilmes.setModel(new AbstractTableModel() {
                @Override
                public String getColumnName(int column) {
                    switch (column) {
                        case 0:
                            return "Código";
                        case 1:
                            return "Título";
                        case 2:
                            return "Diretor";
                        case 3:
                            return "Ano";
                        case 4:
                            return "Gênero";
                        case 5:
                            return "Sinopse";
                        default:
                            return "";
                    }
                }
                
                @Override
                public int getColumnCount() {
                    return 6;
                }
                
                @Override
                public int getRowCount() {
                    return filmes.size();
                }
                
                @Override
                public Object getValueAt(int rowIndex, int columnIndex) {
                    Filme t = filmes.get(rowIndex);
                    
                    if (t != null) {
                        switch (columnIndex) {
                            case 0:
                                return t.getId();
                            case 1:
                                return t.getTitulo();
                            case 2:
                                return t.getDiretor();
                            case 3:
                                return t.getAno_lancamento();
                            case 4:
                                return t.getGenero();
                            case 5:
                                return t.getSinopse();
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
        jlblTitulo = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        txtTitulo = new javax.swing.JTextField();
        txtDiretor = new javax.swing.JTextField();
        jlblDiretor = new javax.swing.JLabel();
        txtAno = new javax.swing.JTextField();
        jlblAno = new javax.swing.JLabel();
        jlblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtGenero = new javax.swing.JTextField();
        jlblGenero = new javax.swing.JLabel();
        jlblSinopse = new javax.swing.JLabel();
        txtSinopse = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        txtPesquisar = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblFilmes = new javax.swing.JTable();

        setClosable(true);
        setResizable(true);
        setTitle("Filmes");

        jlblTitulo.setText("Título:");

        btnSalvar.setText("Cadastrar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        txtDiretor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiretorActionPerformed(evt);
            }
        });

        jlblDiretor.setText("Diretor:");

        jlblAno.setText("Ano de lançamento:");

        jlblCodigo.setText("Código:");

        txtCodigo.setEditable(false);

        jlblGenero.setText("Gênero:");

        jlblSinopse.setText("Sinopse:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalvar))
                    .addComponent(txtTitulo)
                    .addComponent(txtDiretor)
                    .addComponent(jlblDiretor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtGenero)
                    .addComponent(jlblGenero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtAno)
                    .addComponent(jlblAno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCodigo)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 9, Short.MAX_VALUE))
                    .addComponent(txtSinopse)
                    .addComponent(jlblSinopse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jlblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlblDiretor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDiretor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlblGenero)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlblAno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlblSinopse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSinopse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
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

        tblFilmes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblFilmes.setShowGrid(true);
        jScrollPane2.setViewportView(tblFilmes);

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
        txtTitulo.setText("");
        txtDiretor.setText("");
        txtAno.setText("");
        txtGenero.setText("");
        txtSinopse.setText("");
    }

    private Diretor buscarDiretor(String nome) {
        for (Diretor diretor : diretoresController.recuperarTodos(nome)) {
            if (diretor.getNome().equalsIgnoreCase(nome.trim())) {
                return diretor;
            }
        }
        return null;
    }

    private Genero buscarGenero(String nome) {
        for (Genero genero : generosController.recuperarTodos(nome)) {
            if (genero.getNome().equalsIgnoreCase(nome.trim())) {
                return genero;
            }
        }
        return null;
    }

    private void configuraRelacionamentos() {
        javax.swing.JPanel painel = new javax.swing.JPanel(new java.awt.BorderLayout(8, 8));
        javax.swing.JPanel controles = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        cmbListas = new javax.swing.JComboBox<>();
        javax.swing.JButton btnAdicionar = new javax.swing.JButton("Adicionar à lista");
        javax.swing.JButton btnRemover = new javax.swing.JButton("Remover da lista");
        tblListasDoFilme = new javax.swing.JTable();
        lblStatusListas = new javax.swing.JLabel("Selecione um filme para consultar suas listas.");

        controles.add(new javax.swing.JLabel("Lista:"));
        controles.add(cmbListas);
        controles.add(btnAdicionar);
        controles.add(btnRemover);
        painel.add(controles, java.awt.BorderLayout.NORTH);
        painel.add(new javax.swing.JScrollPane(tblListasDoFilme), java.awt.BorderLayout.CENTER);
        painel.add(lblStatusListas, java.awt.BorderLayout.SOUTH);
        jTabbedPane1.addTab("Listas do filme", painel);

        btnAdicionar.addActionListener(evt -> adicionarFilmeALista());
        btnRemover.addActionListener(evt -> removerFilmeDaLista());
        tblFilmes.getSelectionModel().addListSelectionListener(evt -> carregaListasDoFilme());
        carregaListasDisponiveis();
    }

    private void carregaListasDisponiveis() {
        cmbListas.removeAllItems();
        for (Lista lista : listasController.recuperarTodos("")) {
            ComboItem item = new ComboItem();
            item.setCodigo(lista.getId());
            item.setDescricao(lista.getNome());
            cmbListas.addItem(item);
        }
    }

    private void carregaListasDoFilme() {
        int linha = tblFilmes.getSelectedRow();
        if (linha < 0) {
            tblListasDoFilme.setModel(new javax.swing.table.DefaultTableModel());
            lblStatusListas.setText("Selecione um filme para consultar suas listas.");
            return;
        }

        int idFilme = Integer.parseInt(String.valueOf(tblFilmes.getModel().getValueAt(linha, 0)));
        ArrayList<FilmeLista> relacionamentos = filmesListasController.recuperaPorFilme(idFilme);
        tblListasDoFilme.setModel(new javax.swing.table.AbstractTableModel() {
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
                return column == 0 ? "Código" : "Lista";
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                Lista lista = relacionamentos.get(rowIndex).getLista();
                return columnIndex == 0 ? lista.getId() : lista.getNome();
            }
        });
        lblStatusListas.setText(relacionamentos.isEmpty()
                ? "Nenhuma relação cadastrada."
                : relacionamentos.size() + " lista(s) relacionada(s).");
    }

    private void adicionarFilmeALista() {
        int linha = tblFilmes.getSelectedRow();
        ComboItem item = (ComboItem) cmbListas.getSelectedItem();
        if (linha < 0 || item == null) {
            JOptionPane.showMessageDialog(null, "Selecione um filme e uma lista.");
            return;
        }

        int idFilme = Integer.parseInt(String.valueOf(tblFilmes.getModel().getValueAt(linha, 0)));
        FilmeLista relacionamento = new FilmeLista(new Filme(idFilme), new Lista(item.getCodigo()));
        if (filmesListasController.existe(relacionamento)) {
            JOptionPane.showMessageDialog(null, "Este filme já está nesta lista.");
            return;
        }

        filmesListasController.salvar(relacionamento);
        carregaListasDoFilme();
        JOptionPane.showMessageDialog(null, "Filme adicionado à lista.");
    }

    private void removerFilmeDaLista() {
        int linhaFilme = tblFilmes.getSelectedRow();
        int linhaLista = tblListasDoFilme.getSelectedRow();
        if (linhaFilme < 0 || linhaLista < 0) {
            JOptionPane.showMessageDialog(null, "Selecione um filme e uma lista relacionada.");
            return;
        }

        int idFilme = Integer.parseInt(String.valueOf(tblFilmes.getModel().getValueAt(linhaFilme, 0)));
        int idLista = Integer.parseInt(String.valueOf(tblListasDoFilme.getModel().getValueAt(linhaLista, 0)));
        filmesListasController.excluir(idFilme, idLista);
        carregaListasDoFilme();
        JOptionPane.showMessageDialog(null, "Filme removido da lista.");
    }
    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        carregaInformacoes(txtPesquisar.getText());
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void txtDiretorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiretorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiretorActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        String titulo = txtTitulo.getText();
        Diretor diretor = buscarDiretor(txtDiretor.getText());
        int ano_lancamento = Integer.parseInt(txtAno.getText());
        Genero genero = buscarGenero(txtGenero.getText());
        String sinopse = txtSinopse.getText();

        if (diretor == null || genero == null) {
            JOptionPane.showMessageDialog(null, "Diretor ou gênero não encontrado.");
            return;
        }
        
        if (txtCodigo.getText().equals("")) {
            Filme novoFilme = new Filme(titulo, ano_lancamento, sinopse, diretor, genero);
            boolean retorno = filmesController.salvar(novoFilme);
            if (retorno) {
                limpaCampos();
                carregaInformacoes(txtPesquisar.getText());
                txtTitulo.grabFocus();
            } else {
                
            }
        } else {
            int codigo = Integer.parseInt(txtCodigo.getText());
            Filme editarFilme = new Filme(codigo, titulo, ano_lancamento, sinopse, diretor, genero);
            boolean retorno = filmesController.editar(editarFilme);
            if (retorno) {
                limpaCampos();
                carregaInformacoes(txtPesquisar.getText());
                txtTitulo.grabFocus();
            } else {
                
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int linha = tblFilmes.getSelectedRow();
        if (linha < 0) {
            JOptionPane.showMessageDialog(null, "Selecione um filme.");
            return;
        }
        int codigo = Integer.parseInt(String.valueOf(tblFilmes.getModel().getValueAt(linha, 0)));
        
        Filme filmes = filmesController.recuperaUm(codigo);
        if (filmes == null) {
            JOptionPane.showMessageDialog(null, "Filme não encontrado.");
        } else {
            txtCodigo.setText(String.valueOf(codigo));
            txtTitulo.setText(filmes.getTitulo());
            txtDiretor.setText(filmes.getDiretor().getNome());
            txtAno.setText(Integer.toString(filmes.getAno_lancamento()));
            txtGenero.setText(filmes.getGenero().getNome());
            txtSinopse.setText(filmes.getSinopse());
            jTabbedPane1.setSelectedIndex(0);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int linha = tblFilmes.getSelectedRow();
        if (linha < 0) {
            JOptionPane.showMessageDialog(null, "Selecione um filme.");
            return;
        }
        int codigo = Integer.parseInt(String.valueOf(tblFilmes.getModel().getValueAt(linha, 0)));
        
        Filme filmes = filmesController.recuperaUm(codigo);
        if (filmes == null) {
            JOptionPane.showMessageDialog(null, "Filme não encontrado.");
        } else {
            boolean retorno = filmesController.excluir(codigo);
            if (retorno) {
                JOptionPane.showMessageDialog(null, "Filme " + codigo + " apagada com sucesso!");
                carregaInformacoes(txtPesquisar.getText());
            } else {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar excluir o filme " + codigo);
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
    private javax.swing.JLabel jlblAno;
    private javax.swing.JLabel jlblCodigo;
    private javax.swing.JLabel jlblDiretor;
    private javax.swing.JLabel jlblGenero;
    private javax.swing.JLabel jlblSinopse;
    private javax.swing.JLabel jlblTitulo;
    private javax.swing.JTable tblFilmes;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDiretor;
    private javax.swing.JTextField txtGenero;
    private javax.swing.JTextField txtPesquisar;
    private javax.swing.JTextField txtSinopse;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
