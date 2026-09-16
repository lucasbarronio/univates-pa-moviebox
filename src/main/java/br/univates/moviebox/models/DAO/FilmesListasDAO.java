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
    public void salvar(FilmeLista fl) throws Exception {
        String sql = "INSERT INTO filme_lista "
                + "(id_filme, id_lista) "
                + "VALUES "
                + "('" + fl.getFilme().getId() + "', "
                + "'" + fl.getLista().getId() + "')";
        System.out.println(sql);
        ConexaoBD.executeUpdate(sql);
    }

    @Override
    public void editar(FilmeLista l) throws Exception {
        String sql = "UPDATE filme_lista SET id_filme = " + l.getFilme().getId()
                + ", id_lista = " + l.getLista().getId()
                + " WHERE id_filme = " + l.getFilme().getId()
                + " AND id_lista = " + l.getLista().getId();
        System.out.println(sql);
        ConexaoBD.executeUpdate(sql);
    }

    @Override
    public void excluir(int idFilme, int idlista) throws Exception {
        String sql = "DELETE FROM filme_lista WHERE id_filme = " + idFilme + " AND id_lista = " + idlista;
        System.out.println(sql);
        ConexaoBD.executeUpdate(sql);
    }

    @Override
    public ArrayList<FilmeLista> recuperarTodos() throws Exception {
        ArrayList<FilmeLista> filmeListas = new ArrayList();
        String sql = "SELECT * FROM filme_lista";

        ResultSet resultado = ConexaoBD.executeQuery(sql);
        while (resultado.next()) {
            FilmeLista fl = new FilmeLista();
            fl.setFilme(new Filme(resultado.getInt("id_filme")));
            fl.setLista(new Lista(resultado.getInt("id_lista")));
            filmeListas.add(fl);
        }

        return filmeListas;
    }

    @Override
    public ArrayList<FilmeLista> recuperaPorFilme(int id) throws Exception {
        ArrayList<FilmeLista> filmeListas = new ArrayList();
        String sql = "SELECT * FROM filme_lista WHERE id_filme = " + id;

        ResultSet resultado = ConexaoBD.executeQuery(sql);
        while (resultado.next()) {
            FilmeLista fl = new FilmeLista();
            fl.setFilme(new Filme(resultado.getInt("id_filme")));
            fl.setLista(new Lista(resultado.getInt("id_lista")));
            filmeListas.add(fl);
        }

        return filmeListas;
    }

    @Override
    public ArrayList<FilmeLista> recuperaPorLista(int id) throws Exception {
        ArrayList<FilmeLista> filmeListas = new ArrayList();
        String sql = "SELECT * FROM filme_lista WHERE id_lista = " + id;

        ResultSet resultado = ConexaoBD.executeQuery(sql);
        while (resultado.next()) {
            FilmeLista fl = new FilmeLista();
            fl.setFilme(new Filme(resultado.getInt("id_filme")));
            fl.setLista(new Lista(resultado.getInt("id_lista")));
            filmeListas.add(fl);
        }

        return filmeListas;
    }
}
