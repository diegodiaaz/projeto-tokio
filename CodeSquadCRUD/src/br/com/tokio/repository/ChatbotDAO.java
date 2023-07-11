package br.com.tokio.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import br.com.tokio.connection.ConnectionFactory;
import br.com.tokio.model.ChatbotUI;

public class ChatbotDAO {
	
	private Connection conexao;

	// Conexão para essa entidade.
	public ChatbotDAO() {
		this.conexao = new ConnectionFactory().conectar();
	}

	// ------------Insert do Carro------------
	public void insertMensagem(String mensagem) {

        String sql = "INSERT INTO mensagens VALUES (?)";

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
	
	public void insertDadosCliente(String mensagem) {

        String sql = "INSERT INTOT_TOK_CLIENTE VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);

			// Complemento da query
			stmt.setString(1, mensagem);
			stmt.setString(2, mensagem);
			stmt.setString(3, mensagem);
			stmt.setString(4, mensagem);
			stmt.setString(5, mensagem);
			stmt.setString(6, mensagem);
			stmt.setString(7, mensagem);
			stmt.setString(8, mensagem);
			
	
			// Executar a query
			stmt.execute();

			// Fechar a operação
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

