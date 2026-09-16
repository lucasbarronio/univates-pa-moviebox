package br.univates.moviebox.models.DAO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import br.univates.moviebox.models.Lista;
import java.util.ArrayList;
import br.univates.moviebox.utils.ConexaoBD;
import java.sql.*;
import br.univates.moviebox.utils.DAO_I;

/**
 *
 * @author mateus
 */
public class ListasDAO implements DAO_I<Lista> {

    @Override
    public void salvar(Lista l) throws Exception {
        String sql = "INSERT INTO lista "
            + "(nome, descricao) "
                + "VALUES "
                + "('" + l.getNome()+ "', "
                + "'" + l.getDescricao()+ "')";
        System.out.println(sql);
        ConexaoBD.executeUpdate(sql);
    }

    @Override
    public void editar(Lista l) throws Exception {
        String sql = "UPDATE lista SET nome = '" + l.getNome()
                + "', descricao = '" + l.getDescricao()
                + "' WHERE id = " + l.getId();
        System.out.println(sql);
        ConexaoBD.executeUpdate(sql);
    }

    @Override
    public void excluir(int id) throws Exception {
        String sql = "DELETE FROM lista WHERE id = " + id;
        System.out.println(sql);
        ConexaoBD.executeUpdate(sql);
    }

    @Override
    public ArrayList<Lista> recuperarTodos(String criterio) throws Exception {
        ArrayList<Lista> listas = new ArrayList();
        String sql = "SELECT * FROM lista WHERE nome LIKE '%" + criterio + "%'";

        ResultSet resultado = ConexaoBD.executeQuery(sql);
        while (resultado.next()) {
            Lista l = new Lista();
            l.setId(resultado.getInt("id"));
            l.setNome(resultado.getString("nome"));
            l.setDescricao(resultado.getString("descricao"));
            listas.add(l);
        }

        return listas;
    }

    @Override
    public Lista recuperaUm(int id) throws Exception {
        Lista l = null;
        String sql = "SELECT * FROM lista WHERE id = " + id;

        ResultSet resultado = ConexaoBD.executeQuery(sql);
        if (resultado.next()) {
            l = new Lista();
            l.setId(resultado.getInt("id"));
            l.setNome(resultado.getString("nome"));
            l.setDescricao(resultado.getString("descricao"));            
        }

        return l;
    }

}
