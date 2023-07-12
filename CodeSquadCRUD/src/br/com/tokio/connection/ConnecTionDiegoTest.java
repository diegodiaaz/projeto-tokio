package br.com.tokio.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnecTionDiegoTest {

	public Connection conectarDiego() {
		
		try {
			return DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "tm_diego_diaz", "290705");
		} catch (SQLException e) { 
			System.out.println("Erro de conexão.");
			throw new RuntimeException(e); 
		}
	}

	
}