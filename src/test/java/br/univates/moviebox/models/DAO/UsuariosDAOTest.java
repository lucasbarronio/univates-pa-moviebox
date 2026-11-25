package br.univates.moviebox.models.DAO;

import br.univates.moviebox.models.Usuario;
import br.univates.moviebox.utils.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsuariosDAOTest {

    private static Connection conexao;
    private UsuariosDAO usuariosDAO;

    @BeforeAll
    public static void setUpClass() throws Exception {
        conexao = ConexaoBD.getInstance().getConnection();
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
        if (conexao != null && !conexao.isClosed()) {
            ConexaoBD.getInstance().shutDown();
        }
    }

    @BeforeEach
    public void setUp() throws Exception {
        conexao.setAutoCommit(false);
        usuariosDAO = new UsuariosDAO();
    }

    @AfterEach
    public void tearDown() throws Exception {
        conexao.rollback();
        conexao.setAutoCommit(true);
    }

    @Test
    public void testAutenticar() throws Exception {
        String nome = "Usuário " + UUID.randomUUID();
        String login = "usuario_" + UUID.randomUUID().toString().replace("-", "");
        String senha = "Senha-" + UUID.randomUUID();
        usuariosDAO.salvar(nome, login, senha);

        Usuario usuario = usuariosDAO.autenticar(login, senha);
        Usuario usuarioSenhaIncorreta = usuariosDAO.autenticar(login, senha + " incorreta");

        assertNotNull(usuario);
        assertTrue(usuario.getCodigo() > 0);
        assertEquals(nome, usuario.getNome());
        assertEquals(login, usuario.getLogin());
        assertNull(usuarioSenhaIncorreta);
    }

    @Test
    public void testSalvar() throws Exception {
        String nome = "Usuário " + UUID.randomUUID();
        String login = "usuario_" + UUID.randomUUID().toString().replace("-", "");
        String senha = "Senha-" + UUID.randomUUID();

        usuariosDAO.salvar(nome, login, senha);
        Usuario usuario = usuariosDAO.autenticar(login, senha);
        String senhaArmazenada = recuperarSenhaArmazenada(login);

        assertNotNull(usuario);
        assertEquals(nome, usuario.getNome());
        assertEquals(login, usuario.getLogin());
        assertNotEquals(senha, senhaArmazenada);
        assertEquals(64, senhaArmazenada.length());
    }

    private String recuperarSenhaArmazenada(String login) throws Exception {
        String sql = "SELECT senha_hash FROM usuario WHERE login = ?";
        try (PreparedStatement consulta = conexao.prepareStatement(sql)) {
            consulta.setString(1, login);
            try (ResultSet resultado = consulta.executeQuery()) {
                resultado.next();
                return resultado.getString("senha_hash").trim();
            }
        }
    }
}
