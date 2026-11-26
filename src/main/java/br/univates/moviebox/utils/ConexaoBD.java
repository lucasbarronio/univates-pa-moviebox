package br.univates.moviebox.utils;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author fabricio.pretto
 * - cria conexao com o BD e estrutura da classe
 * 
 * @author mateus.roveda
 * 16/05/2023 - criado metodos para consulta e updates; atualizada documentacao.
 */
public class ConexaoBD {

    private static ConexaoBD instancia = null;
    private Connection conexao = null;

    public ConexaoBD() {
        try {
            Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
            String dbdriver = dotenv.get("DB_DRIVER");
            String dburl = dotenv.get("DB_URL");
            String dbuser = dotenv.get("DB_USER");
            String dbsenha = dotenv.get("DB_PASSWORD");

            // Carrega Driver do Banco de Dados
            Class.forName(dbdriver);

            conexao = DriverManager.getConnection(dburl, dbuser, dbsenha);

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }

    /**
     * Retorna instância
     *
     * @return ConexaoBD
     */
    public static ConexaoBD getInstance() {
        if (instancia == null) {
            instancia = new ConexaoBD();
        }
        return instancia;
    }

    /**
     * Retorna conexo
     *
     * @return conexao
     */
    public Connection getConnection() {
        if (conexao == null) {
            throw new RuntimeException("A conexão com o banco de dados não foi estabelecida.");
        }
        return conexao;
    }

    /**
     * Executa um insert/update no banco de dados
     *
     * @param sql: query a ser executada
     * @return int
     * @throws java.sql.SQLException
     */
    public static int executeUpdate(String sql) throws SQLException {
        return ConexaoBD.getInstance().getConnection().createStatement().executeUpdate(sql);
    }

    /**
     * Executa uma consulta no banco de dados
     *
     * @param sql: query a ser executada
     * @return ResultSet
     * @throws java.sql.SQLException
     */
    public static ResultSet executeQuery(String sql) throws SQLException {
        return ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);
    }

    /**
     * Efetua o fechamento da conexao
     */
    public void shutDown() {
        try {
            conexao.close();
            instancia = null;
            conexao = null;
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

}
