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
    public void salvar(Filme f) throws Exception {
        String sql = "INSERT INTO filme "
                + "(titulo, ano_lancamento, sinopse, id_diretor, id_genero) "
                + "VALUES "
                + "('" + f.getTitulo()+ "', "
                + "'" + f.getAno_lancamento()+ "', "
                + "'" + f.getSinopse()+ "', "
                + "'" + f.getDiretor().getId()+ "', "
                + "'" + f.getGenero().getId()+ "')";
        System.out.println(sql);
        ConexaoBD.executeUpdate(sql);
    }

    @Override
    public void editar(Filme f) throws Exception {
        String sql = "UPDATE filme SET";
        System.out.println(sql);
        ConexaoBD.executeUpdate(sql);
    }

    @Override
    public void excluir(int id) throws Exception {
        String sql = "DELETE FROM filme WHERE id = " + id;
        System.out.println(sql);
        ConexaoBD.executeUpdate(sql);
    }

    @Override
    public ArrayList<Filme> recuperarTodos(String criterio) throws Exception {
        ArrayList<Filme> filmes = new ArrayList();
        String sql = "SELECT * FROM filme WHERE titulo LIKE '%" + criterio + "%'";

        ResultSet resultado = ConexaoBD.executeQuery(sql);
        while (resultado.next()) {
            Filme f = new Filme();
            f.setId(resultado.getInt("id"));
            f.setTitulo(resultado.getString("titulo"));
            f.setAno_lancamento(resultado.getInt("ano_lancamento"));
            f.setSinopse(resultado.getString("sinopse"));
            f.setDiretor(new Diretor(resultado.getInt("id_diretor")));
            f.setGenero(new Genero(resultado.getInt("id_genero")));
            filmes.add(f);
        }

        return filmes;
    }

    @Override
    public Filme recuperaUm(int id) throws Exception {
        Filme f = null;
        String sql = "SELECT * FROM filme WHERE id = " + id;

        ResultSet resultado = ConexaoBD.executeQuery(sql);
        if (resultado.next()) {
            f = new Filme();
            f.setId(resultado.getInt("id"));
            f.setTitulo(resultado.getString("titulo"));
            f.setAno_lancamento(resultado.getInt("ano_lancamento"));
            f.setSinopse(resultado.getString("sinopse"));
            f.setDiretor(new Diretor(resultado.getInt("id_diretor")));
            f.setGenero(new Genero(resultado.getInt("id_genero")));
        }

        return f;
    }

}
