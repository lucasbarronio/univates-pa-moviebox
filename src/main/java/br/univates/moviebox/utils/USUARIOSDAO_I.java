package br.univates.moviebox.utils;

import br.univates.moviebox.models.Usuario;
import java.sql.SQLException;

public interface USUARIOSDAO_I<O> {

    public Usuario autenticar(String login, String senha) throws SQLException;

    public void salvar(String nome, String login, String senha) throws SQLException;
}
