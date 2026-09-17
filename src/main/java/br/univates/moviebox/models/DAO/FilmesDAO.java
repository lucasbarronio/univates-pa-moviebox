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
                + "VALUES "
                + "('" + filme.getTitulo() + "', "
                + "'" + filme.getAno_lancamento() + "', "
                + "'" + filme.getSinopse() + "', "
                + "'" + filme.getDiretor().getId() + "', "
                + "'" + filme.getGenero().getId() + "')";
        System.out.println(sql);
        ConexaoBD.executeUpdate(sql);
    }

    @Override
    public void editar(Filme filme) throws Exception {
        String sql = "UPDATE filme SET titulo = '" + filme.getTitulo()
                + "', ano_lancamento = '" + filme.getAno_lancamento()
                + "', sinopse = '" + filme.getSinopse()
                + "', id_diretor = '" + filme.getDiretor().getId()
                + "', id_genero = '" + filme.getGenero().getId()
                + "' WHERE id = " + filme.getId();
        System.out.println(sql);
        ConexaoBD.executeUpdate(sql);
    }

    @Override
    public void excluir(int idFilme) throws Exception {
        String sql = "DELETE FROM filme WHERE id = " + idFilme;
        System.out.println(sql);
        ConexaoBD.executeUpdate(sql);
    }

    @Override
    public ArrayList<Filme> recuperarTodos(String termoBusca) throws Exception {
        ArrayList<Filme> filmes = new ArrayList();
        String sql = "SELECT * FROM filme WHERE titulo LIKE '%" + termoBusca + "%'";

        ResultSet resultadoConsulta = ConexaoBD.executeQuery(sql);
        while (resultadoConsulta.next()) {
            Filme filme = new Filme();
            filme.setId(resultadoConsulta.getInt("id"));
            filme.setTitulo(resultadoConsulta.getString("titulo"));
            filme.setAno_lancamento(resultadoConsulta.getInt("ano_lancamento"));
            filme.setSinopse(resultadoConsulta.getString("sinopse"));
            filme.setDiretor(new Diretor(resultadoConsulta.getInt("id_diretor")));
            filme.setGenero(new Genero(resultadoConsulta.getInt("id_genero")));
            filmes.add(filme);
        }

        return filmes;
    }

    @Override
    public Filme recuperaUm(int idFilme) throws Exception {
        Filme filme = null;
        String sql = "SELECT * FROM filme WHERE id = " + idFilme;

        ResultSet resultadoConsulta = ConexaoBD.executeQuery(sql);
        if (resultadoConsulta.next()) {
            filme = new Filme();
            filme.setId(resultadoConsulta.getInt("id"));
            filme.setTitulo(resultadoConsulta.getString("titulo"));
            filme.setAno_lancamento(resultadoConsulta.getInt("ano_lancamento"));
            filme.setSinopse(resultadoConsulta.getString("sinopse"));
            filme.setDiretor(new Diretor(resultadoConsulta.getInt("id_diretor")));
            filme.setGenero(new Genero(resultadoConsulta.getInt("id_genero")));
        }

        return filme;
    }

}
