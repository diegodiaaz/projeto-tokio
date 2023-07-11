package br.com.tokio.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import br.com.tokio.connection.ConnectionFactory;
import br.com.tokio.model.Chatbot;

public class ChatbotDAO {
	
	private Connection conexao;

	// Conexão para essa entidade.
	public ChatbotDAO() {
		this.conexao = new ConnectionFactory().conectar();
	}

	public void insertDadosCliente(String mensagem) {

        String sql = "INSERT INTO T_TOK_CHATBOT (DS_MENSAGEM) VALUES (?)";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);

			// Complemento da query
			stmt.setString(1, mensagem);
			
			// Executar a query
			stmt.execute();

			// Fechar a operação
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

