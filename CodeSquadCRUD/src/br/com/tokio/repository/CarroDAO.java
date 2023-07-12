package br.com.tokio.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.tokio.connection.ConnectionFactory;
import br.com.tokio.model.Carro;

public class CarroDAO {

	private Connection conexao;

	// Conexão para essa entidade.
	public CarroDAO() {
		this.conexao = new ConnectionFactory().conectar();
	}

	// ------------Insert do Carro------------
	public void insertCadastroCarro(Carro carro) {

		String sql = "insert into t_tok_carro (cd_placa, nr_ano, ds_modelo, ds_marca, ds_cor, tp_combustivel, cd_cep_pernoite, ds_proprietario, cd_contrato) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);

			// Complemento da query
			stmt.setString(1, carro.getPlacaCarro());
			stmt.setInt(2, carro.getAnoCarro());
			stmt.setString(3, carro.getModeloCarro());
			stmt.setString(4, carro.getMarcaCarro());
			stmt.setString(5, carro.getCorCarro());
			stmt.setString(6, carro.getTipoCombustivelCarro());
			stmt.setString(7, carro.getCepPernoiteCarro());
			stmt.setString(8, carro.getProprietarioCarro());
			stmt.setString(9, carro.getCodigoContrato());

			// Executar a query
			stmt.execute();

			// Fechar a operação
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// ------------SelectAll------------
	public List<Carro> selectAllCarro() {

		List<Carro> carros = new ArrayList<Carro>();
		String sql = "select * from t_tok_carro order by cd_placa";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(); // Usar quando se trabalha com lista.

			// While para percorrer toda a tabela.

			while (rs.next()) {
				// Enquanto tiver dados na tabela, executa isso abaixo.

				// Instanciamos um usuario vazio, e temos que deixar um novo construtor vazio.
				Carro carro = new Carro();
				carro = new Carro();
				carro.setPlacaCarro(rs.getString("cd_placa"));
				carro.setAnoCarro(rs.getInt("nr_ano"));
				carro.setModeloCarro(rs.getString("ds_modelo"));
				carro.setMarcaCarro(rs.getString("ds_marca"));
				carro.setCorCarro(rs.getString("ds_cor"));
				carro.setTipoCombustivelCarro(rs.getString("tp_combustivel"));
				carro.setCepPernoiteCarro(rs.getString("cd_cep_pernoite"));
				carro.setProprietarioCarro(rs.getString("ds_proprietario"));
				carros.add(carro); // Cada objeto usuário adicionado a lista de usuários.
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return carros;
	}

	// ------------SelectByPlaca------------

	public Carro selectByPlaca(String placa) {

		Carro carro = null;
		String sql = "select * from t_tok_carro where cd_placa=?";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, placa);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				carro = new Carro();
				carro.setPlacaCarro(rs.getString("cd_placa"));
				carro.setAnoCarro(rs.getInt("nr_ano"));
				carro.setModeloCarro(rs.getString("ds_modelo"));
				carro.setMarcaCarro(rs.getString("ds_marca"));
				carro.setCorCarro(rs.getString("ds_cor"));
				carro.setTipoCombustivelCarro(rs.getString("tp_combustivel"));
				carro.setCepPernoiteCarro(rs.getString("cd_cep_pernoite"));
				carro.setProprietarioCarro(rs.getString("ds_proprietario"));

			} else {
				System.out.println("Placa nao encontrada");
			}
			rs.close();
			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return carro;
	}

	// ------------Update------------ //
	public void updateCarro(Carro carro) {

		String sql = "UPDATE T_TOK_CARRO SET cd_cep_pernoite=? WHERE cd_placa =?";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, carro.getCepPernoiteCarro());
			stmt.setString(2, carro.getPlacaCarro());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {

		}
	}

	// ------------Delete------------
	public boolean deleteCarro(String Placa) {
		String sql = "delete from T_TOK_CARRO where (cd_placa = ?)";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, Placa);
			stmt.executeUpdate();
			return true;
					
		} catch (SQLException e) {
			System.out.println("Placa nao existente");
			e.printStackTrace();
			return false;
		}
		
	}

}
