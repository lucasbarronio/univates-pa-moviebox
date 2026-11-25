package br.univates.moviebox.models.DAO;

import br.univates.moviebox.models.Diretor;
import br.univates.moviebox.models.Filme;
import br.univates.moviebox.models.Genero;
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

public class FilmesDAOTest {

    private static Connection conexao;
    private FilmesDAO filmesDAO;
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
        filmesDAO = new FilmesDAO();
        idDiretor = 0;
        idGenero = 0;
        idFilme = 0;
        idLista = 0;
    }

    @AfterEach
    public void tearDown() throws Exception {
        conexao.rollback();
        conexao.setAutoCommit(true);
        excluirRegistro("DELETE FROM filme_lista WHERE id_filme = ?", idFilme);
        excluirRegistro("DELETE FROM filme WHERE id = ?", idFilme);
        excluirRegistro("DELETE FROM lista WHERE id = ?", idLista);
        excluirRegistro("DELETE FROM diretor WHERE id = ?", idDiretor);
        excluirRegistro("DELETE FROM genero WHERE id = ?", idGenero);
    }

    @Test
    public void testSalvar() throws Exception {
        Filme filme = criarFilme("Filme " + UUID.randomUUID());

        filmesDAO.salvar(filme);
        ArrayList<Filme> filmes = filmesDAO.recuperarTodos(filme.getTitulo());

        assertEquals(1, filmes.size());
        assertEquals(filme.getTitulo(), filmes.get(0).getTitulo());
        assertEquals(filme.getAno_lancamento(), filmes.get(0).getAno_lancamento());
        assertEquals(filme.getSinopse(), filmes.get(0).getSinopse());
        assertEquals(filme.getDiretor().getNome(), filmes.get(0).getDiretor().getNome());
        assertEquals(filme.getGenero().getNome(), filmes.get(0).getGenero().getNome());
    }

    @Test
    public void testEditar() throws Exception {
        Filme filme = criarFilme("Filme " + UUID.randomUUID());
        filmesDAO.salvar(filme);
        idFilme = buscarIdFilme(filme.getTitulo());
        filme.setId(idFilme);
        filme.setTitulo(filme.getTitulo() + " editado");
        filme.setAno_lancamento(2025);
        filme.setSinopse("Sinopse editada");

        filmesDAO.editar(filme);
        Filme filmeEditado = filmesDAO.recuperaUm(idFilme);

        assertEquals(filme.getTitulo(), filmeEditado.getTitulo());
        assertEquals(filme.getAno_lancamento(), filmeEditado.getAno_lancamento());
        assertEquals(filme.getSinopse(), filmeEditado.getSinopse());
        assertEquals(filme.getDiretor().getId(), filmeEditado.getDiretor().getId());
        assertEquals(filme.getGenero().getId(), filmeEditado.getGenero().getId());
    }

    @Test
    public void testExcluir() throws Exception {
        Filme filme = criarFilme("Filme " + UUID.randomUUID());
        filmesDAO.salvar(filme);
        idFilme = buscarIdFilme(filme.getTitulo());
        idLista = inserirRegistro("INSERT INTO lista (nome) VALUES (?)", "Lista " + UUID.randomUUID());
        inserirAssociacao(idFilme, idLista);

        filmesDAO.excluir(idFilme);
        Filme filmeExcluido = filmesDAO.recuperaUm(idFilme);
        boolean associacaoExiste = existeAssociacao(idFilme, idLista);

        assertNull(filmeExcluido);
        assertFalse(associacaoExiste);
    }

    @Test
    public void testRecuperarTodos() throws Exception {
        Filme filme = criarFilme("Filme " + UUID.randomUUID());
        filmesDAO.salvar(filme);

        ArrayList<Filme> filmes = filmesDAO.recuperarTodos(filme.getTitulo());

        assertEquals(1, filmes.size());
        assertEquals(filme.getTitulo(), filmes.get(0).getTitulo());
        assertEquals(filme.getDiretor().getNome(), filmes.get(0).getDiretor().getNome());
        assertEquals(filme.getGenero().getNome(), filmes.get(0).getGenero().getNome());
    }

    @Test
    public void testRecuperaUm() throws Exception {
        Filme filme = criarFilme("Filme " + UUID.randomUUID());
        filmesDAO.salvar(filme);
        idFilme = buscarIdFilme(filme.getTitulo());

        Filme filmeRecuperado = filmesDAO.recuperaUm(idFilme);

        assertEquals(idFilme, filmeRecuperado.getId());
        assertEquals(filme.getTitulo(), filmeRecuperado.getTitulo());
        assertEquals(filme.getAno_lancamento(), filmeRecuperado.getAno_lancamento());
        assertEquals(filme.getSinopse(), filmeRecuperado.getSinopse());
        assertEquals(filme.getDiretor().getNome(), filmeRecuperado.getDiretor().getNome());
        assertEquals(filme.getGenero().getNome(), filmeRecuperado.getGenero().getNome());
    }

    private Filme criarFilme(String titulo) throws Exception {
        String nomeDiretor = "Diretor " + UUID.randomUUID();
        String nomeGenero = "Gênero " + UUID.randomUUID();
        idDiretor = inserirRegistro("INSERT INTO diretor (nome, nacionalidade) VALUES (?, ?)", nomeDiretor, "Brasileira");
        idGenero = inserirRegistro("INSERT INTO genero (nome) VALUES (?)", nomeGenero);
        return new Filme(titulo, 2024, "Sinopse do filme", new Diretor(idDiretor, nomeDiretor, "Brasileira"), new Genero(idGenero, nomeGenero));
    }

    private int buscarIdFilme(String titulo) throws Exception {
        String sql = "SELECT id FROM filme WHERE titulo = ?";
        try (PreparedStatement consulta = conexao.prepareStatement(sql)) {
            consulta.setString(1, titulo);
            try (ResultSet resultado = consulta.executeQuery()) {
                resultado.next();
                return resultado.getInt("id");
            }
        }
    }

    private int inserirRegistro(String sql, String... valores) throws Exception {
        try (PreparedStatement comando = conexao.prepareStatement(sql + " RETURNING id")) {
            for (int indice = 0; indice < valores.length; indice++) {
                comando.setString(indice + 1, valores[indice]);
            }
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

    private boolean existeAssociacao(int idFilme, int idLista) throws Exception {
        String sql = "SELECT 1 FROM filme_lista WHERE id_filme = ? AND id_lista = ?";
        try (PreparedStatement consulta = conexao.prepareStatement(sql)) {
            consulta.setInt(1, idFilme);
            consulta.setInt(2, idLista);
            try (ResultSet resultado = consulta.executeQuery()) {
                return resultado.next();
            }
        }
    }

    private void excluirRegistro(String sql, int id) throws Exception {
        if (id == 0) {
            return;
        }
        try (PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setInt(1, id);
            comando.executeUpdate();
        }
    }
}
