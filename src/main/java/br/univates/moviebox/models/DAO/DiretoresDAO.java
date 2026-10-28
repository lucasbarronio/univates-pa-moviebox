package br.univates.moviebox.models.DAO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import br.univates.moviebox.models.Diretor;
import java.util.ArrayList;
import br.univates.moviebox.utils.ConexaoBD;
import java.sql.*;
import br.univates.moviebox.utils.DAO_I;

/**
 *
 * @author mateus
 */
public class DiretoresDAO implements DAO_I<Diretor> {

    @Override
    public void salvar(Diretor diretor) throws Exception {
        String sql = "INSERT INTO diretor "
                + "(nome, nacionalidade) "
                + "VALUES "
                + "(?, ?)";

        try (PreparedStatement ps = ConexaoBD.getInstance().getConnection().prepareStatement(sql)) {
            ps.setString(1, diretor.getNome());
            ps.setString(2, diretor.getNacionalidade());
            ps.executeUpdate();
        }
    }

    @Override
    public void editar(Diretor diretor) throws Exception {
        String sql = "UPDATE diretor SET nome = ?, nacionalidade = ? WHERE id = ?";

        try (PreparedStatement ps = ConexaoBD.getInstance().getConnection().prepareStatement(sql)) {
            ps.setString(1, diretor.getNome());
            ps.setString(2, diretor.getNacionalidade());
            ps.setInt(3, diretor.getId());
            ps.executeUpdate();
        }
    }

    @Override
    public void excluir(int idDiretor) throws Exception {
        String sql = "DELETE FROM diretor WHERE id = ?";

        try (PreparedStatement ps = ConexaoBD.getInstance().getConnection().prepareStatement(sql)) {
            ps.setInt(1, idDiretor);
            ps.executeUpdate();
        }
    }

    @Override
    public ArrayList<Diretor> recuperarTodos(String termoBusca) throws Exception {
        ArrayList<Diretor> diretores = new ArrayList();
        String sql = "SELECT * FROM diretor WHERE nome ILIKE ? OR nacionalidade ILIKE ?";

        try (PreparedStatement ps = ConexaoBD.getInstance().getConnection().prepareStatement(sql)) {
            ps.setString(1, "%" + termoBusca + "%");
            ps.setString(2, "%" + termoBusca + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    diretores.add(mapearDiretor(rs));
                }
            }
        }

        return diretores;
    }

    @Override
    public Diretor recuperaUm(int idDiretor) throws Exception {
        Diretor diretor = null;
        String sql = "SELECT * FROM diretor WHERE id = ?";

        try (PreparedStatement ps = ConexaoBD.getInstance().getConnection().prepareStatement(sql)) {
            ps.setInt(1, idDiretor);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    diretor = mapearDiretor(rs);
                }
            }
        }

        return diretor;
    }

    private Diretor mapearDiretor(ResultSet resultadoConsulta) throws SQLException {
        Diretor diretor = new Diretor();
        diretor.setId(resultadoConsulta.getInt("id"));
        diretor.setNome(resultadoConsulta.getString("nome"));
        diretor.setNacionalidade(resultadoConsulta.getString("nacionalidade"));
        return diretor;
    }
}
