package br.univates.moviebox.models.DAO;

import br.univates.moviebox.models.Lista;
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

public class ListasDAOTest {

    private static Connection conexao;
    private ListasDAO listasDAO;

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
        listasDAO = new ListasDAO();
    }

    @AfterEach
    public void tearDown() throws Exception {
        conexao.rollback();
        conexao.setAutoCommit(true);
    }

    @Test
    public void testSalvar() throws Exception {
        String nome = "Lista " + UUID.randomUUID();
        String descricao = "Descrição da lista";
        Lista lista = new Lista(nome, descricao);

        listasDAO.salvar(lista);
        ArrayList<Lista> listas = listasDAO.recuperarTodos(nome);

        assertEquals(1, listas.size());
        assertEquals(nome, listas.get(0).getNome());
        assertEquals(descricao, listas.get(0).getDescricao());
    }

    @Test
    public void testEditar() throws Exception {
        String nome = "Lista " + UUID.randomUUID();
        Lista lista = new Lista(nome, "Descrição original");
        listasDAO.salvar(lista);
        lista.setId(listasDAO.recuperarTodos(nome).get(0).getId());
        lista.setNome(nome + " editada");
        lista.setDescricao("Descrição editada");

        listasDAO.editar(lista);
        Lista listaEditada = listasDAO.recuperaUm(lista.getId());

        assertEquals(lista.getId(), listaEditada.getId());
        assertEquals(lista.getNome(), listaEditada.getNome());
        assertEquals(lista.getDescricao(), listaEditada.getDescricao());
    }

    @Test
    public void testExcluir() throws Exception {
        String nome = "Lista " + UUID.randomUUID();
        listasDAO.salvar(new Lista(nome, "Descrição da lista"));
        int idLista = listasDAO.recuperarTodos(nome).get(0).getId();

        listasDAO.excluir(idLista);
        Lista lista = listasDAO.recuperaUm(idLista);

        assertNull(lista);
    }

    @Test
    public void testRecuperarTodos() throws Exception {
        String termoBusca = UUID.randomUUID().toString();
        String nome = "Lista " + termoBusca;
        String descricao = "Descrição " + termoBusca;
        listasDAO.salvar(new Lista(nome, "Descrição sem correspondência"));
        listasDAO.salvar(new Lista("Outra lista " + UUID.randomUUID(), descricao));

        ArrayList<Lista> listas = listasDAO.recuperarTodos(termoBusca);

        assertEquals(2, listas.size());
        assertTrue(listas.stream().anyMatch(lista -> lista.getNome().equals(nome)));
        assertTrue(listas.stream().anyMatch(lista -> lista.getDescricao().equals(descricao)));
    }

    @Test
    public void testRecuperaUm() throws Exception {
        String nome = "Lista " + UUID.randomUUID();
        String descricao = "Descrição da lista";
        listasDAO.salvar(new Lista(nome, descricao));
        int idLista = listasDAO.recuperarTodos(nome).get(0).getId();

        Lista lista = listasDAO.recuperaUm(idLista);

        assertEquals(idLista, lista.getId());
        assertEquals(nome, lista.getNome());
        assertEquals(descricao, lista.getDescricao());
    }
}
