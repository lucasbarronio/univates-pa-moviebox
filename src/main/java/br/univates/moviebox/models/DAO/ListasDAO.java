package br.univates.moviebox.models.DAO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import br.univates.moviebox.models.Lista;
import java.util.ArrayList;
import br.univates.moviebox.utils.ConexaoBD;
import java.sql.*;
import br.univates.moviebox.utils.DAO_I;

/**
 *
 * @author mateus
 */
public class ListasDAO implements DAO_I<Lista> {

    @Override
    public void salvar(Lista lista) throws Exception {
        String sql = "INSERT INTO lista "
                + "(nome, descricao) "
                + "VALUES (?, ?)";
        
        try (PreparedStatement ps = ConexaoBD.getInstance().getConnection().prepareStatement(sql)) {
            ps.setString(1, lista.getNome());
            ps.setString(2, lista.getDescricao());
            ps.executeUpdate();
        }
    }

    @Override
    public void editar(Lista lista) throws Exception {
        String sql = "UPDATE lista SET nome = ?, descricao = ? WHERE id = ?";
        
        try (PreparedStatement ps = ConexaoBD.getInstance().getConnection().prepareStatement(sql)) {
            ps.setString(1, lista.getNome());
            ps.setString(2, lista.getDescricao());
            ps.setInt(3, lista.getId());
            ps.executeUpdate();
        }
    }

    @Override
    public void excluir(int idLista) throws Exception {
        Connection conexao = ConexaoBD.getInstance().getConnection();
        boolean autoCommitAnterior = conexao.getAutoCommit();
        try {
            conexao.setAutoCommit(false);
            String sqlRelacionamentos = "DELETE FROM filme_lista WHERE id_lista = " + idLista;
            String sqlLista = "DELETE FROM lista WHERE id = " + idLista;
            System.out.println(sqlRelacionamentos);
            System.out.println(sqlLista);
            try (Statement statement = conexao.createStatement()) {
                statement.executeUpdate(sqlRelacionamentos);
                statement.executeUpdate(sqlLista);
            }
            conexao.commit();
        } catch (Exception ex) {
            conexao.rollback();
            throw ex;
        } finally {
            conexao.setAutoCommit(autoCommitAnterior);
        }
    }

    @Override
    public ArrayList<Lista> recuperarTodos(String termoBusca) throws Exception {
        ArrayList<Lista> listas = new ArrayList();
        String sql = "SELECT * FROM lista WHERE nome ILIKE ? OR descricao ILIKE ?";

        try (PreparedStatement ps = ConexaoBD.getInstance().getConnection().prepareStatement(sql)) {
            ps.setString(1, "%" + termoBusca + "%");
            ps.setString(2, "%" + termoBusca + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    listas.add(mapearLista(rs));
                }
            }
        }

        return listas;
    }

    @Override
    public Lista recuperaUm(int idLista) throws Exception {
        Lista lista = null;
        String sql = "SELECT * FROM lista WHERE id = ?";

        try (PreparedStatement consulta = ConexaoBD.getInstance().getConnection().prepareStatement(sql)) {
            consulta.setInt(1, idLista);
            try (ResultSet resultadoConsulta = consulta.executeQuery()) {
                if (resultadoConsulta.next()) {
                    lista = mapearLista(resultadoConsulta);
                }
            }
        }

        return lista;
    }

    private Lista mapearLista(ResultSet resultadoConsulta) throws SQLException {
        Lista lista = new Lista();
        lista.setId(resultadoConsulta.getInt("id"));
        lista.setNome(resultadoConsulta.getString("nome"));
        lista.setDescricao(resultadoConsulta.getString("descricao"));
        return lista;
    }

}
