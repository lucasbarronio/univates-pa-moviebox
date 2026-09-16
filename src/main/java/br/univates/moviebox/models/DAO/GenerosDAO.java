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
    public void salvar(Genero g) throws Exception {
        String sql = "INSERT INTO genero "
                + "(nome) "
                + "VALUES "
                + "('" + g.getNome()+ "')";
        System.out.println(sql);
        ConexaoBD.executeUpdate(sql);
    }

    @Override
    public void editar(Genero g) throws Exception {
        String sql = "UPDATE genero SET nome = '" + g.getNome()
                + "' WHERE id = " + g.getId();
        System.out.println(sql);
        ConexaoBD.executeUpdate(sql);
    }

    @Override
    public void excluir(int id) throws Exception {
        String sql = "DELETE FROM genero WHERE id = " + id;
        System.out.println(sql);
        ConexaoBD.executeUpdate(sql);
    }

    @Override
    public ArrayList<Genero> recuperarTodos(String criterio) throws Exception {
        ArrayList<Genero> generos = new ArrayList();
        String sql = "SELECT * FROM genero WHERE nome LIKE '%" + criterio + "%'";

        ResultSet resultado = ConexaoBD.executeQuery(sql);
        while (resultado.next()) {
            Genero g = new Genero();
            g.setId(resultado.getInt("id"));
            g.setNome(resultado.getString("nome"));
            generos.add(g);
        }

        return generos;
    }

    @Override
    public Genero recuperaUm(int id) throws Exception {
        Genero g = null;
        String sql = "SELECT * FROM genero WHERE id = " + id;

        ResultSet resultado = ConexaoBD.executeQuery(sql);
        if (resultado.next()) {
            g = new Genero();
            g.setId(resultado.getInt("id"));
            g.setNome(resultado.getString("nome"));
        }

        return g;
    }

}
