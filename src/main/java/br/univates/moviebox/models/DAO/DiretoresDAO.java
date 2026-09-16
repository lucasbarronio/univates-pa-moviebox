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
    public void salvar(Diretor d) throws Exception {
        String sql = "INSERT INTO diretor "
                + "(nome, nacionalidade) "
                + "VALUES "
                + "('" + d.getNome()+ "', "
                + "'" + d.getNacionalidade()+ "')";
        System.out.println(sql);
        ConexaoBD.executeUpdate(sql);
    }

    @Override
    public void editar(Diretor d) throws Exception {
        String sql = "UPDATE filme SET";
        System.out.println(sql);
        ConexaoBD.executeUpdate(sql);
    }

    @Override
    public void excluir(int id) throws Exception {
        String sql = "DELETE FROM diretor WHERE id = " + id;
        System.out.println(sql);
        ConexaoBD.executeUpdate(sql);
    }

    @Override
    public ArrayList<Diretor> recuperarTodos(String criterio) throws Exception {
        ArrayList<Diretor> diretores = new ArrayList();
        String sql = "SELECT * FROM diretor WHERE nome LIKE '%" + criterio + "%'";

        ResultSet resultado = ConexaoBD.executeQuery(sql);
        while (resultado.next()) {
            Diretor d = new Diretor();
            d.setId(resultado.getInt("id"));
            d.setNome(resultado.getString("nome"));
            d.setNacionalidade(resultado.getString("nacionalidade"));
            diretores.add(d);
        }

        return diretores;
    }

    @Override
    public Diretor recuperaUm(int id) throws Exception {
        Diretor d = null;
        String sql = "SELECT * FROM diretor WHERE id = " + id;

        ResultSet resultado = ConexaoBD.executeQuery(sql);
        if (resultado.next()) {
            d = new Diretor();
            d.setId(resultado.getInt("id"));
            d.setNome(resultado.getString("nome"));
            d.setNacionalidade(resultado.getString("nacionalidade"));
        }

        return d;
    }

}
