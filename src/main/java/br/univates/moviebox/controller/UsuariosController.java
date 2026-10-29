package br.univates.moviebox.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import br.univates.moviebox.models.DAO.UsuariosDAO;
import br.univates.moviebox.models.Usuario;
import br.univates.moviebox.exceptions.PersistenciaException;
import java.sql.SQLException;

public class UsuariosController {

    private static final Logger LOGGER = Logger.getLogger(UsuariosController.class.getName());
    private final UsuariosDAO usuarioDAO = new UsuariosDAO();

    public Usuario autenticar(String login, String senha) {
        try {
            return usuarioDAO.autenticar(login, senha);
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Falha ao autenticar usuário", ex);
            throw new PersistenciaException("Não foi possível autenticar o usuário.", ex);
        }
    }

    public void salvar(String nome, String login, String senha) {
        try {
            usuarioDAO.salvar(nome, login, senha);
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Falha ao salvar usuário", ex);
            throw new RuntimeException("Erro ao salvar usuário.", ex);
        }
    }

    public String validar(String login, String senha) {
        if (login == null || login.trim().isEmpty()) {
            return "Informe o login.";
        }
        if (senha == null || senha.isEmpty()) {
            return "Informe a senha.";
        }
        return null;
    }
}
