package br.univates.moviebox.models.DAO;

import br.univates.moviebox.models.Diretor;
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

public class DiretoresDAOTest {

    private static Connection conexao;
    private DiretoresDAO diretoresDAO;

    @BeforeAll
    public static void setUpClass() throws Exception {
        conexao = ConexaoBD.getInstance().getConnection();
    }

    @AfterAll
    public static void tearDownClass() {
        ConexaoBD.getInstance().shutDown();
    }

    @BeforeEach
    public void setUp() throws Exception {
        conexao.setAutoCommit(false);
        diretoresDAO = new DiretoresDAO();
    }

    @AfterEach
    public void tearDown() throws Exception {
        conexao.rollback();
        conexao.setAutoCommit(true);
    }

    @Test
    public void testSalvar() throws Exception {
        String nome = "Diretor " + UUID.randomUUID();
        String nacionalidade = "Brasileira";
        Diretor diretor = new Diretor(nome, nacionalidade);

        diretoresDAO.salvar(diretor);
        ArrayList<Diretor> diretores = diretoresDAO.recuperarTodos(nome);

        assertEquals(1, diretores.size());
        assertEquals(nome, diretores.get(0).getNome());
        assertEquals(nacionalidade, diretores.get(0).getNacionalidade());
    }

    @Test
    public void testEditar() throws Exception {
        String nome = "Diretor " + UUID.randomUUID();
        Diretor diretor = new Diretor(nome, "Brasileira");
        diretoresDAO.salvar(diretor);
        int idDiretor = diretoresDAO.recuperarTodos(nome).get(0).getId();
        diretor.setId(idDiretor);
        diretor.setNome(nome + " editado");
        diretor.setNacionalidade("Argentina");

        diretoresDAO.editar(diretor);
        Diretor diretorEditado = diretoresDAO.recuperaUm(idDiretor);

        assertEquals(diretor.getNome(), diretorEditado.getNome());
        assertEquals(diretor.getNacionalidade(), diretorEditado.getNacionalidade());
    }

    @Test
    public void testExcluir() throws Exception {
        String nome = "Diretor " + UUID.randomUUID();
        diretoresDAO.salvar(new Diretor(nome, "Brasileira"));
        int idDiretor = diretoresDAO.recuperarTodos(nome).get(0).getId();

        diretoresDAO.excluir(idDiretor);
        Diretor diretor = diretoresDAO.recuperaUm(idDiretor);

        assertNull(diretor);
    }

    @Test
    public void testRecuperarTodos() throws Exception {
        String nome = "Diretor " + UUID.randomUUID();
        String nacionalidade = "Nacionalidade " + UUID.randomUUID();
        diretoresDAO.salvar(new Diretor(nome, "Brasileira"));
        diretoresDAO.salvar(new Diretor("Outro " + UUID.randomUUID(), nacionalidade));

        ArrayList<Diretor> porNome = diretoresDAO.recuperarTodos(nome);
        ArrayList<Diretor> porNacionalidade = diretoresDAO.recuperarTodos(nacionalidade);

        assertEquals(1, porNome.size());
        assertEquals(nome, porNome.get(0).getNome());
        assertEquals(1, porNacionalidade.size());
        assertEquals(nacionalidade, porNacionalidade.get(0).getNacionalidade());
    }

    @Test
    public void testRecuperaUm() throws Exception {
        String nome = "Diretor " + UUID.randomUUID();
        String nacionalidade = "Brasileira";
        diretoresDAO.salvar(new Diretor(nome, nacionalidade));
        int idDiretor = diretoresDAO.recuperarTodos(nome).get(0).getId();

        Diretor diretor = diretoresDAO.recuperaUm(idDiretor);

        assertEquals(idDiretor, diretor.getId());
        assertEquals(nome, diretor.getNome());
        assertEquals(nacionalidade, diretor.getNacionalidade());
    }
}
