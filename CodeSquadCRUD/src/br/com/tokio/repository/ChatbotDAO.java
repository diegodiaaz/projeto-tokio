package br.com.tokio.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import br.com.tokio.connection.ConnectionFactory;

public class ChatbotDAO {
	
	private Connection conexao;

	// Conexão para essa entidade.
	public ChatbotDAO() {
		this.conexao = new ConnectionFactory().conectar();
	}

	public void insertDadosCliente(String mensagem) {


        Map<Integer, String> mapa = new HashMap<>();

		String sql = "insert into t_tok_cliente (NR_CPF_CLI, NM_CLIENTE, DT_NASCIMENTO, DS_EMAIL_CLI, NR_TELEFONE_CLI, DS_GENERO_CLI, DT_CADASTRO_CLI) values (?, ?, ?, ?, ?, ?, ?)";

		mapa.put(1, sql);
        
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);

			String comandoSQLRecuperado = mapa.get(1);
			executarComandoSQL(comandoSQLRecuperado);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void executarComandoSQL(String comandoSQL) {

        System.out.println("Executando o comando SQL: " + comandoSQL);

	}
}

