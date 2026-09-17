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
    public void editar(FilmeLista filmeLista) throws Exception {
        String sql = "UPDATE filme_lista SET id_filme = " + filmeLista.getFilme().getId()
                + ", id_lista = " + filmeLista.getLista().getId()
                + " WHERE id_filme = " + filmeLista.getFilme().getId()
                + " AND id_lista = " + filmeLista.getLista().getId();
        System.out.println(sql);
        ConexaoBD.executeUpdate(sql);
    }

    @Override
    public void excluir(int idFilme, int idLista) throws Exception {
        String sql = "DELETE FROM filme_lista WHERE id_filme = " + idFilme + " AND id_lista = " + idLista;
        System.out.println(sql);
        ConexaoBD.executeUpdate(sql);
    }

    @Override
    public ArrayList<FilmeLista> recuperarTodos() throws Exception {
        ArrayList<FilmeLista> filmeListas = new ArrayList();
        String sql = "SELECT * FROM filme_lista";

        ResultSet resultadoConsulta = ConexaoBD.executeQuery(sql);
        while (resultadoConsulta.next()) {
            filmeListas.add(mapearFilmeLista(resultadoConsulta));
        }

        return filmeListas;
    }

    @Override
    public ArrayList<FilmeLista> recuperaPorFilme(int idFilme) throws Exception {
        ArrayList<FilmeLista> filmeListas = new ArrayList();
        String sql = "SELECT * FROM filme_lista WHERE id_filme = " + idFilme;

        ResultSet resultadoConsulta = ConexaoBD.executeQuery(sql);
        while (resultadoConsulta.next()) {
            filmeListas.add(mapearFilmeLista(resultadoConsulta));
        }

        return filmeListas;
    }

    @Override
    public ArrayList<FilmeLista> recuperaPorLista(int idLista) throws Exception {
        ArrayList<FilmeLista> filmeListas = new ArrayList();
        String sql = "SELECT * FROM filme_lista WHERE id_lista = " + idLista;

        ResultSet resultadoConsulta = ConexaoBD.executeQuery(sql);
        while (resultadoConsulta.next()) {
            filmeListas.add(mapearFilmeLista(resultadoConsulta));
        }

        return filmeListas;
    }

    private FilmeLista mapearFilmeLista(ResultSet resultadoConsulta) throws SQLException {
        FilmeLista filmeLista = new FilmeLista();
        filmeLista.setFilme(new Filme(resultadoConsulta.getInt("id_filme")));
        filmeLista.setLista(new Lista(resultadoConsulta.getInt("id_lista")));
        return filmeLista;
    }
}
