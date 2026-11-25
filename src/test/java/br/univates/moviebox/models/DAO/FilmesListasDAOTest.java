package br.univates.moviebox.models.DAO;

import br.univates.moviebox.models.Filme;
import br.univates.moviebox.models.FilmeLista;
import br.univates.moviebox.models.Lista;
import br.univates.moviebox.utils.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.UUID;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FilmesListasDAOTest {

    private static Connection conexao;
    private FilmesListasDAO filmesListasDAO;
    private int idDiretor;
    private int idGenero;
    private int idFilme;
    private int idLista;

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
        filmesListasDAO = new FilmesListasDAO();
        idDiretor = inserirRegistro("INSERT INTO diretor (nome) VALUES (?)", "Diretor " + UUID.randomUUID());
        idGenero = inserirRegistro("INSERT INTO genero (nome) VALUES (?)", "Gênero " + UUID.randomUUID());
        idFilme = inserirFilme("Filme " + UUID.randomUUID());
        idLista = inserirRegistro("INSERT INTO lista (nome) VALUES (?)", "Lista " + UUID.randomUUID());
    }

    @AfterEach
    public void tearDown() throws Exception {
        conexao.rollback();
        conexao.setAutoCommit(true);
    }

    @Test
    public void testSalvar() throws Exception {
        FilmeLista filmeLista = new FilmeLista(new Filme(idFilme), new Lista(idLista));

        filmesListasDAO.salvar(filmeLista);
        boolean existe = filmesListasDAO.existe(filmeLista);

        assertTrue(existe);
    }

    @Test
    public void testExiste() throws Exception {
        FilmeLista filmeLista = new FilmeLista(new Filme(idFilme), new Lista(idLista));

        boolean existeAntes = filmesListasDAO.existe(filmeLista);
        filmesListasDAO.salvar(filmeLista);
        boolean existeDepois = filmesListasDAO.existe(filmeLista);

        assertFalse(existeAntes);
        assertTrue(existeDepois);
    }

    @Test
    public void testExcluir() throws Exception {
        inserirAssociacao(idFilme, idLista);

        filmesListasDAO.excluir(idFilme, idLista);
        boolean existe = filmesListasDAO.existe(new FilmeLista(new Filme(idFilme), new Lista(idLista)));

        assertFalse(existe);
    }

    @Test
    public void testRecuperarTodos() throws Exception {
        inserirAssociacao(idFilme, idLista);

        ArrayList<FilmeLista> filmeListas = filmesListasDAO.recuperarTodos();
        FilmeLista filmeLista = filmeListas.stream()
                .filter(relacao -> relacao.getFilme().getId() == idFilme
                && relacao.getLista().getId() == idLista)
                .findFirst()
                .orElse(null);

        assertNotNull(filmeLista);
        assertTrue(filmeLista.getFilme().getTitulo().startsWith("Filme "));
        assertTrue(filmeLista.getLista().getNome().startsWith("Lista "));
    }

    @Test
    public void testRecuperaPorFilme() throws Exception {
        int idLista2 = inserirRegistro("INSERT INTO lista (nome) VALUES (?)", "Lista " + UUID.randomUUID());
        inserirAssociacao(idFilme, idLista);
        inserirAssociacao(idFilme, idLista2);

        ArrayList<FilmeLista> filmeListas = filmesListasDAO.recuperaPorFilme(idFilme);

        assertEquals(2, filmeListas.size());
        assertTrue(filmeListas.stream().allMatch(relacao -> relacao.getFilme().getId() == idFilme));
    }

    @Test
    public void testRecuperaPorLista() throws Exception {
        int idFilme2 = inserirFilme("Filme " + UUID.randomUUID());
        inserirAssociacao(idFilme, idLista);
        inserirAssociacao(idFilme2, idLista);

        ArrayList<FilmeLista> filmeListas = filmesListasDAO.recuperaPorLista(idLista);

        assertEquals(2, filmeListas.size());
        assertTrue(filmeListas.stream().allMatch(relacao -> relacao.getLista().getId() == idLista));
    }

    private int inserirFilme(String titulo) throws Exception {
        String sql = "INSERT INTO filme (titulo, ano_lancamento, sinopse, id_diretor, id_genero) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement comando = conexao.prepareStatement(sql + " RETURNING id")) {
            comando.setString(1, titulo);
            comando.setInt(2, 2024);
            comando.setString(3, "Sinopse do filme");
            comando.setInt(4, idDiretor);
            comando.setInt(5, idGenero);
            try (ResultSet resultado = comando.executeQuery()) {
                resultado.next();
                return resultado.getInt("id");
            }
        }
    }

    private int inserirRegistro(String sql, String valor) throws Exception {
        try (PreparedStatement comando = conexao.prepareStatement(sql + " RETURNING id")) {
            comando.setString(1, valor);
            try (ResultSet resultado = comando.executeQuery()) {
                resultado.next();
                return resultado.getInt("id");
            }
        }
    }

    private void inserirAssociacao(int idFilme, int idLista) throws Exception {
        String sql = "INSERT INTO filme_lista (id_filme, id_lista) VALUES (?, ?)";
        try (PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setInt(1, idFilme);
            comando.setInt(2, idLista);
            comando.executeUpdate();
        }
    }
}
