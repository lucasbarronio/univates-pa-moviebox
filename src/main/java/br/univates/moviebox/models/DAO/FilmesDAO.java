package br.univates.moviebox.models.DAO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import br.univates.moviebox.models.Diretor;
import br.univates.moviebox.models.Filme;
import br.univates.moviebox.models.Genero;
import java.util.ArrayList;
import br.univates.moviebox.utils.ConexaoBD;
import java.sql.*;
import br.univates.moviebox.utils.DAO_I;

/**
 *
 * @author mateus
 */
public class FilmesDAO implements DAO_I<Filme> {

    @Override
    public void salvar(Filme filme) throws Exception {
        String sql = "INSERT INTO filme "
                + "(titulo, ano_lancamento, sinopse, id_diretor, id_genero) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = ConexaoBD.getInstance().getConnection().prepareStatement(sql)) {
            ps.setString(1, filme.getTitulo());
            ps.setInt(2, filme.getAno_lancamento());
            ps.setString(3, filme.getSinopse());
            ps.setInt(4, filme.getDiretor().getId());
            ps.setInt(5, filme.getGenero().getId());
            ps.executeUpdate();
        }
    }

    @Override
    public void editar(Filme filme) throws Exception {
        String sql = "UPDATE filme SET titulo = ?, ano_lancamento = ?, sinopse = ?, id_diretor = ?, id_genero = ? WHERE id = ?";

        try (PreparedStatement ps = ConexaoBD.getInstance().getConnection().prepareStatement(sql)) {
            ps.setString(1, filme.getTitulo());
            ps.setInt(2, filme.getAno_lancamento());
            ps.setString(3, filme.getSinopse());
            ps.setInt(4, filme.getDiretor().getId());
            ps.setInt(5, filme.getGenero().getId());
            ps.setInt(6, filme.getId());
            ps.executeUpdate();
        }
    }

    @Override
    public void excluir(int idFilme) throws Exception {
        Connection conexao = ConexaoBD.getInstance().getConnection();
        boolean autoCommitAnterior = conexao.getAutoCommit();
        try {
            conexao.setAutoCommit(false);
            String sqlRelacionamentos = "DELETE FROM filme_lista WHERE id_filme = " + idFilme;
            String sqlFilme = "DELETE FROM filme WHERE id = " + idFilme;
            System.out.println(sqlRelacionamentos);
            System.out.println(sqlFilme);
            try (Statement statement = conexao.createStatement()) {
                statement.executeUpdate(sqlRelacionamentos);
                statement.executeUpdate(sqlFilme);
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
    public ArrayList<Filme> recuperarTodos(String termoBusca) throws Exception {
        ArrayList<Filme> filmes = new ArrayList<>();
        String sql = sqlFilmesComRelacionamentos() + " WHERE filme.titulo ILIKE ?";

        try (PreparedStatement consulta = ConexaoBD.getInstance().getConnection().prepareStatement(sql)) {
            consulta.setString(1, "%" + termoBusca + "%");
            try (ResultSet resultadoConsulta = consulta.executeQuery()) {
                while (resultadoConsulta.next()) {
                    filmes.add(mapearFilme(resultadoConsulta));
                }
            }
        }

        return filmes;
    }

    @Override
    public Filme recuperaUm(int idFilme) throws Exception {
        Filme filme = null;
        String sql = sqlFilmesComRelacionamentos() + " WHERE filme.id = ?";

        try (PreparedStatement consulta = ConexaoBD.getInstance().getConnection().prepareStatement(sql)) {
            consulta.setInt(1, idFilme);
            try (ResultSet resultadoConsulta = consulta.executeQuery()) {
                if (resultadoConsulta.next()) {
                    filme = mapearFilme(resultadoConsulta);
                }
            }
        }

        return filme;
    }

    private Filme mapearFilme(ResultSet resultadoConsulta) throws SQLException {
        Filme filme = new Filme();
        filme.setId(resultadoConsulta.getInt("id"));
        filme.setTitulo(resultadoConsulta.getString("titulo"));
        filme.setAno_lancamento(resultadoConsulta.getInt("ano_lancamento"));
        filme.setSinopse(resultadoConsulta.getString("sinopse"));

        Diretor diretor = new Diretor(resultadoConsulta.getInt("id_diretor"));
        diretor.setNome(resultadoConsulta.getString("nome_diretor"));
        filme.setDiretor(diretor);

        Genero genero = new Genero(resultadoConsulta.getInt("id_genero"));
        genero.setNome(resultadoConsulta.getString("nome_genero"));
        filme.setGenero(genero);
        return filme;
    }

    private String sqlFilmesComRelacionamentos() {
        return "SELECT filme.id, filme.titulo, filme.ano_lancamento, filme.sinopse, "
                + "filme.id_diretor, diretor.nome AS nome_diretor, "
                + "filme.id_genero, genero.nome AS nome_genero "
                + "FROM filme "
                + "JOIN diretor ON diretor.id = filme.id_diretor "
                + "JOIN genero ON genero.id = filme.id_genero";
    }

}
