package br.com.tokio.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection conectar() {
		
		try {
			return DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "tm_vitor_romao", "150306");
		} catch (SQLException e) { 
			System.out.println("Erro de conexão.");
			throw new RuntimeException(e); 
		}
	}

	
}
