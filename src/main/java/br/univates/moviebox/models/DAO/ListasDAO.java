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
    public void salvar(Lista lista) throws Exception {
        String sql = "INSERT INTO lista "
                + "(nome, descricao) "
                + "VALUES "
                + "('" + lista.getNome() + "', "
                + "'" + lista.getDescricao() + "')";
        System.out.println(sql);
        ConexaoBD.executeUpdate(sql);
    }

    @Override
    public void editar(Lista lista) throws Exception {
        String sql = "UPDATE lista SET nome = '" + lista.getNome()
                + "', descricao = '" + lista.getDescricao()
                + "' WHERE id = " + lista.getId();
        System.out.println(sql);
        ConexaoBD.executeUpdate(sql);
    }

    @Override
    public void excluir(int idLista) throws Exception {
        String sql = "DELETE FROM lista WHERE id = " + idLista;
        System.out.println(sql);
        ConexaoBD.executeUpdate(sql);
    }

    @Override
    public ArrayList<Lista> recuperarTodos(String termoBusca) throws Exception {
        ArrayList<Lista> listas = new ArrayList();
        String sql = "SELECT * FROM lista WHERE nome LIKE '%" + termoBusca + "%'";

        ResultSet resultadoConsulta = ConexaoBD.executeQuery(sql);
        while (resultadoConsulta.next()) {
            listas.add(mapearLista(resultadoConsulta));
        }

        return listas;
    }

    @Override
    public Lista recuperaUm(int idLista) throws Exception {
        Lista lista = null;
        String sql = "SELECT * FROM lista WHERE id = " + idLista;

        ResultSet resultadoConsulta = ConexaoBD.executeQuery(sql);
        if (resultadoConsulta.next()) {
            lista = mapearLista(resultadoConsulta);
        }

        return lista;
    }

    private Lista mapearLista(ResultSet resultadoConsulta) throws SQLException {
        Lista lista = new Lista();
        lista.setId(resultadoConsulta.getInt("id"));
        lista.setNome(resultadoConsulta.getString("nome"));
        lista.setDescricao(resultadoConsulta.getString("descricao"));
        return lista;
    }

}
