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
    public void salvar(Diretor diretor) throws Exception {
        String sql = "INSERT INTO diretor "
                + "(nome, nacionalidade) "
                + "VALUES "
                + "('" + diretor.getNome() + "', "
                + "'" + diretor.getNacionalidade() + "')";
        System.out.println(sql);
        ConexaoBD.executeUpdate(sql);
    }

    @Override
    public void editar(Diretor diretor) throws Exception {
        String sql = "UPDATE diretor SET nome = '" + diretor.getNome()
                + "', nacionalidade = '" + diretor.getNacionalidade()
                + "' WHERE id = " + diretor.getId();
        System.out.println(sql);
        ConexaoBD.executeUpdate(sql);
    }

    @Override
    public void excluir(int idDiretor) throws Exception {
        String sql = "DELETE FROM diretor WHERE id = " + idDiretor;
        System.out.println(sql);
        ConexaoBD.executeUpdate(sql);
    }

    @Override
    public ArrayList<Diretor> recuperarTodos(String termoBusca) throws Exception {
        ArrayList<Diretor> diretores = new ArrayList();
        String sql = "SELECT * FROM diretor WHERE nome LIKE '%" + termoBusca + "%'";

        ResultSet resultadoConsulta = ConexaoBD.executeQuery(sql);
        while (resultadoConsulta.next()) {
            diretores.add(mapearDiretor(resultadoConsulta));
        }

        return diretores;
    }

    @Override
    public Diretor recuperaUm(int idDiretor) throws Exception {
        Diretor diretor = null;
        String sql = "SELECT * FROM diretor WHERE id = " + idDiretor;

        ResultSet resultadoConsulta = ConexaoBD.executeQuery(sql);
        if (resultadoConsulta.next()) {
            diretor = mapearDiretor(resultadoConsulta);
        }

        return diretor;
    }

    private Diretor mapearDiretor(ResultSet resultadoConsulta) throws SQLException {
        Diretor diretor = new Diretor();
        diretor.setId(resultadoConsulta.getInt("id"));
        diretor.setNome(resultadoConsulta.getString("nome"));
        diretor.setNacionalidade(resultadoConsulta.getString("nacionalidade"));
        return diretor;
    }
}
