package br.univates.moviebox.models.DAO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import br.univates.moviebox.models.Filme;
import br.univates.moviebox.models.FilmeLista;
import br.univates.moviebox.models.Lista;
import java.util.ArrayList;
import br.univates.moviebox.utils.ConexaoBD;
import java.sql.*;
import br.univates.moviebox.utils.FILMESLISTAS_DAO;

/**
 *
 * @author mateus
 */
public class FilmesListasDAO implements FILMESLISTAS_DAO<FilmeLista> {

    @Override
    public void salvar(FilmeLista filmeLista) throws Exception {
        String sql = "INSERT INTO filme_lista "
                + "(id_filme, id_lista) "
                + "VALUES "
                + "('" + filmeLista.getFilme().getId() + "', "
                + "'" + filmeLista.getLista().getId() + "')";
        System.out.println(sql);
        ConexaoBD.executeUpdate(sql);
    }

    @Override
    public boolean existe(FilmeLista filmeLista) throws Exception {
        String sql = "SELECT 1 FROM filme_lista WHERE id_filme = "
                + filmeLista.getFilme().getId() + " AND id_lista = "
                + filmeLista.getLista().getId();
        try (ResultSet resultadoConsulta = ConexaoBD.executeQuery(sql)) {
            return resultadoConsulta.next();
        }
    }

    @Override
    public void excluir(int idFilme, int idLista) throws Exception {
        String sql = "DELETE FROM filme_lista WHERE id_filme = " + idFilme + " AND id_lista = " + idLista;
        System.out.println(sql);
        ConexaoBD.executeUpdate(sql);
    }

    @Override
    public ArrayList<FilmeLista> recuperarTodos() throws Exception {
        ArrayList<FilmeLista> filmeListas = new ArrayList<>();
        String sql = sqlRelacionamentos();

        ResultSet resultadoConsulta = ConexaoBD.executeQuery(sql);
        while (resultadoConsulta.next()) {
            filmeListas.add(mapearFilmeLista(resultadoConsulta));
        }

        return filmeListas;
    }

    @Override
    public ArrayList<FilmeLista> recuperaPorFilme(int idFilme) throws Exception {
        ArrayList<FilmeLista> filmeListas = new ArrayList<>();
        String sql = sqlRelacionamentos() + " WHERE filme.id = " + idFilme;

        ResultSet resultadoConsulta = ConexaoBD.executeQuery(sql);
        while (resultadoConsulta.next()) {
            filmeListas.add(mapearFilmeLista(resultadoConsulta));
        }

        return filmeListas;
    }

    @Override
    public ArrayList<FilmeLista> recuperaPorLista(int idLista) throws Exception {
        ArrayList<FilmeLista> filmeListas = new ArrayList<>();
        String sql = sqlRelacionamentos() + " WHERE lista.id = " + idLista;

        ResultSet resultadoConsulta = ConexaoBD.executeQuery(sql);
        while (resultadoConsulta.next()) {
            filmeListas.add(mapearFilmeLista(resultadoConsulta));
        }

        return filmeListas;
    }

    private FilmeLista mapearFilmeLista(ResultSet resultadoConsulta) throws SQLException {
        FilmeLista filmeLista = new FilmeLista();
        Filme filme = new Filme(resultadoConsulta.getInt("id_filme"));
        filme.setTitulo(resultadoConsulta.getString("titulo_filme"));
        filmeLista.setFilme(filme);

        Lista lista = new Lista(resultadoConsulta.getInt("id_lista"));
        lista.setNome(resultadoConsulta.getString("nome_lista"));
        filmeLista.setLista(lista);
        return filmeLista;
    }

    private String sqlRelacionamentos() {
        return "SELECT filme_lista.id_filme, filme.titulo AS titulo_filme, "
            + "filme_lista.id_lista, lista.nome AS nome_lista "
            + "FROM filme_lista "
            + "JOIN filme ON filme.id = filme_lista.id_filme "
            + "JOIN lista ON lista.id = filme_lista.id_lista";
    }
}
