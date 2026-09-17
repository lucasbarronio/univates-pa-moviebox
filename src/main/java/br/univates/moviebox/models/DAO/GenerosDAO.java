package br.univates.moviebox.models.DAO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import br.univates.moviebox.models.Genero;
import java.util.ArrayList;
import br.univates.moviebox.utils.ConexaoBD;
import java.sql.*;
import br.univates.moviebox.utils.DAO_I;

/**
 *
 * @author mateus
 */
public class GenerosDAO implements DAO_I<Genero> {

    @Override
    public void salvar(Genero genero) throws Exception {
        String sql = "INSERT INTO genero "
                + "(nome) "
                + "VALUES "
                + "('" + genero.getNome() + "')";
        System.out.println(sql);
        ConexaoBD.executeUpdate(sql);
    }

    @Override
    public void editar(Genero genero) throws Exception {
        String sql = "UPDATE genero SET nome = '" + genero.getNome()
                + "' WHERE id = " + genero.getId();
        System.out.println(sql);
        ConexaoBD.executeUpdate(sql);
    }

    @Override
    public void excluir(int idGenero) throws Exception {
        String sql = "DELETE FROM genero WHERE id = " + idGenero;
        System.out.println(sql);
        ConexaoBD.executeUpdate(sql);
    }

    @Override
    public ArrayList<Genero> recuperarTodos(String termoBusca) throws Exception {
        ArrayList<Genero> generos = new ArrayList();
        String sql = "SELECT * FROM genero WHERE nome LIKE '%" + termoBusca + "%'";

        ResultSet resultadoConsulta = ConexaoBD.executeQuery(sql);
        while (resultadoConsulta.next()) {
            Genero genero = new Genero();
            genero.setId(resultadoConsulta.getInt("id"));
            genero.setNome(resultadoConsulta.getString("nome"));
            generos.add(genero);
        }

        return generos;
    }

    @Override
    public Genero recuperaUm(int idGenero) throws Exception {
        Genero genero = null;
        String sql = "SELECT * FROM genero WHERE id = " + idGenero;

        ResultSet resultadoConsulta = ConexaoBD.executeQuery(sql);
        if (resultadoConsulta.next()) {
            genero = new Genero();
            genero.setId(resultadoConsulta.getInt("id"));
            genero.setNome(resultadoConsulta.getString("nome"));
        }

        return genero;
    }

}
