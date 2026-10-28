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
                + "VALUES (?)";

        try (PreparedStatement ps = ConexaoBD.getInstance().getConnection().prepareStatement(sql)) {
            ps.setString(1, genero.getNome());
            ps.executeUpdate();
        }
    }

    @Override
    public void editar(Genero genero) throws Exception {
        String sql = "UPDATE genero SET nome = ? WHERE id = ?";

        try (PreparedStatement ps = ConexaoBD.getInstance().getConnection().prepareStatement(sql)) {
            ps.setString(1, genero.getNome());
            ps.setInt(2, genero.getId());
            ps.executeUpdate();
        }
    }

    @Override
    public void excluir(int idGenero) throws Exception {
        String sql = "DELETE FROM genero WHERE id = ?";

        try (PreparedStatement ps = ConexaoBD.getInstance().getConnection().prepareStatement(sql)) {
            ps.setInt(1, idGenero);
            ps.executeUpdate();
        }
    }

    @Override
    public ArrayList<Genero> recuperarTodos(String termoBusca) throws Exception {
        ArrayList<Genero> generos = new ArrayList();
        String sql = "SELECT * FROM genero WHERE nome ILIKE ?";

        try (PreparedStatement ps = ConexaoBD.getInstance().getConnection().prepareStatement(sql)) {
            ps.setString(1, "%" + termoBusca + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    generos.add(mapearGenero(rs));
                }
            }
        }

        return generos;
    }

    @Override
    public Genero recuperaUm(int idGenero) throws Exception {
        Genero genero = null;
        String sql = "SELECT * FROM genero WHERE id = ?";

        try (PreparedStatement ps = ConexaoBD.getInstance().getConnection().prepareStatement(sql)) {
            ps.setInt(1, idGenero);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    genero = mapearGenero(rs);
                }
            }
        }

        return genero;
    }

    private Genero mapearGenero(ResultSet resultadoConsulta) throws SQLException {
        Genero genero = new Genero();
        genero.setId(resultadoConsulta.getInt("id"));
        genero.setNome(resultadoConsulta.getString("nome"));
        return genero;
    }

}
