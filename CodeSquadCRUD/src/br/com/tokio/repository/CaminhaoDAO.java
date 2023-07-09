package br.com.tokio.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.tokio.connection.ConnectionFactory;
import br.com.tokio.model.Caminhao;

public class CaminhaoDAO {

	private Connection conexao;

	// CONEXAO PARA ESSA ENTIDADE
	public CaminhaoDAO() {

		this.conexao = new ConnectionFactory().conectar();
	}

// ------------Insert da Caminhao------------
	public void insertCadastroCaminhao(Caminhao caminhao) {

		String sql = "insert into t_tok_caminhao (cd_placa, nr_ano, ds_modelo, ds_marca, ds_cor, tp_combustivel, cd_cep_pernoite, ds_proprietario, ds_porte, cd_contrato) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);

			// Complemento da query
			stmt.setInt(1, caminhao.getIdCaminhao());
			stmt.setString(2, caminhao.getPlacaCaminhao());
			stmt.setInt(3, caminhao.getAnoCaminhao());
			stmt.setString(4, caminhao.getModeloCaminhao());
			stmt.setString(5, caminhao.getMarcaCaminhao());
			stmt.setString(6, caminhao.getCorCaminhao());
			stmt.setString(7, caminhao.getTipoCombustivelCaminhao());
			stmt.setString(8, caminhao.getCepPernoiteCaminhao());
			stmt.setString(9, caminhao.getProprietarioCaminhao());
			stmt.setString(10, caminhao.getPorteCaminhao());
			stmt.setInt(11, caminhao.getContratoCaminhao());

			// Executar a query
			stmt.execute();

			// Fechar a operação
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

// ------------SelectAll------------
	public List<Caminhao> selectAllCaminhao() {

		List<Caminhao> caminhoes = new ArrayList<Caminhao>();
		String sql = "select * from t_tok_caminhao order by cd_placa";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(); // Usar quando se trabalha com lista.

			// While para percorrer toda a tabela.

			while (rs.next()) {
				// Enquanto tiver dados na tabela, executa isso abaixo.

				// Instanciamos um usuario vazio, e temos que deixar um novo construtor vazio.
				Caminhao caminhao = new Caminhao();
				caminhao = new Caminhao();
				caminhao.setIdCaminhao(rs.getInt("id_serv_caminhao"));
				caminhao.setPlacaCaminhao(rs.getString("cd_placa"));
				caminhao.setAnoCaminhao(rs.getInt("nr_ano"));
				caminhao.setModeloCaminhao(rs.getString("ds_modelo"));
				caminhao.setMarcaCaminhao(rs.getString("ds_marca"));
				caminhao.setCorCaminhao(rs.getString("ds_cor"));
				caminhao.setTipoCombustivelCaminhao(rs.getString("tp_combustivel"));
				caminhao.setCepPernoiteCaminhao(rs.getString("cd_cep_pernoite"));
				caminhao.setProprietarioCaminhao(rs.getString("ds_proprietario"));
				caminhao.setPorteCaminhao(rs.getString("ds_porte"));
				caminhoes.add(caminhao); // Cada objeto caminhao adicionado a lista de caminhoes.
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return caminhoes;
	}

// ------------SelectByPlaca------------

	public Caminhao selectByPlaca(String placa) {

		Caminhao caminhao = null;
		String sql = "select * from t_tok_caminhao where cd_placa=?";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, placa);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				caminhao = new Caminhao();
				caminhao.setIdCaminhao(rs.getInt("id_serv_caminhao"));
				caminhao.setPlacaCaminhao(rs.getString("cd_placa"));
				caminhao.setAnoCaminhao(rs.getInt("nr_ano"));
				caminhao.setModeloCaminhao(rs.getString("ds_modelo"));
				caminhao.setMarcaCaminhao(rs.getString("ds_marca"));
				caminhao.setCorCaminhao(rs.getString("ds_cor"));
				caminhao.setTipoCombustivelCaminhao(rs.getString("tp_combustivel"));
				caminhao.setCepPernoiteCaminhao(rs.getString("cd_cep_pernoite"));
				caminhao.setProprietarioCaminhao(rs.getString("ds_proprietario"));
				caminhao.setPorteCaminhao(rs.getString("ds_porte"));
			} else {
				System.out.println("Placa nao encontrada");
			}
			rs.close();
			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return caminhao;
	}

// ------------Update------------ //
	public void updateCaminhao(Caminhao caminhao) {

		String sql = "UPDATE T_TOK_CAMINHAO SET cd_cep_pernoite=? WHERE cd_placa =?";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, caminhao.getCepPernoiteCaminhao());
			stmt.setString(2, caminhao.getPlacaCaminhao());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {

		}
	}

// ------------Delete------------

	public boolean deleteCaminhao(String placa) {

		String sql = "delete from T_TOK_CAMINHAO where (cd_placa = ?)";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, placa);
			stmt.executeUpdate();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

}
