package br.univates.moviebox.models.DAO;

import br.univates.moviebox.models.Genero;
import br.univates.moviebox.utils.ConexaoBD;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.UUID;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GenerosDAOTest {

    private static Connection conexao;
    private GenerosDAO generosDAO;

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
        generosDAO = new GenerosDAO();
    }

    @AfterEach
    public void tearDown() throws Exception {
        conexao.rollback();
        conexao.setAutoCommit(true);
    }

    @Test
    public void testSalvar() throws Exception {
        String nome = "Gênero " + UUID.randomUUID();
        Genero genero = new Genero(nome);

        generosDAO.salvar(genero);
        ArrayList<Genero> generos = generosDAO.recuperarTodos(nome);

        assertEquals(1, generos.size());
        assertEquals(nome, generos.get(0).getNome());
    }

    @Test
    public void testEditar() throws Exception {
        String nome = "Gênero " + UUID.randomUUID();
        Genero genero = new Genero(nome);
        generosDAO.salvar(genero);
        genero.setId(generosDAO.recuperarTodos(nome).get(0).getId());
        genero.setNome(nome + " editado");

        generosDAO.editar(genero);
        Genero generoEditado = generosDAO.recuperaUm(genero.getId());

        assertEquals(genero.getId(), generoEditado.getId());
        assertEquals(genero.getNome(), generoEditado.getNome());
    }

    @Test
    public void testExcluir() throws Exception {
        String nome = "Gênero " + UUID.randomUUID();
        generosDAO.salvar(new Genero(nome));
        int idGenero = generosDAO.recuperarTodos(nome).get(0).getId();

        generosDAO.excluir(idGenero);
        Genero genero = generosDAO.recuperaUm(idGenero);

        assertNull(genero);
    }

    @Test
    public void testRecuperarTodos() throws Exception {
        String termoBusca = UUID.randomUUID().toString();
        String primeiroNome = "Gênero " + termoBusca + " A";
        String segundoNome = "Gênero " + termoBusca + " B";
        generosDAO.salvar(new Genero(primeiroNome));
        generosDAO.salvar(new Genero(segundoNome));

        ArrayList<Genero> generos = generosDAO.recuperarTodos(termoBusca);

        assertEquals(2, generos.size());
        assertTrue(generos.stream().anyMatch(genero -> genero.getNome().equals(primeiroNome)));
        assertTrue(generos.stream().anyMatch(genero -> genero.getNome().equals(segundoNome)));
    }

    @Test
    public void testRecuperaUm() throws Exception {
        String nome = "Gênero " + UUID.randomUUID();
        generosDAO.salvar(new Genero(nome));
        int idGenero = generosDAO.recuperarTodos(nome).get(0).getId();

        Genero genero = generosDAO.recuperaUm(idGenero);

        assertEquals(idGenero, genero.getId());
        assertEquals(nome, genero.getNome());
    }
}
