package br.com.tokio.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.tokio.model.Moto;
import br.com.tokio.connection.ConnectionFactory;

public class MotoDAO {

	private Connection conexao;

	// CONEXAO PARA ESSA ENTIDADE
	public MotoDAO() {

		this.conexao = new ConnectionFactory().conectar();
	}

// ------------Insert da Moto------------
	public void insertCadastroMoto(Moto moto) {

		String sql = "insert into t_tok_moto (CD_PLACA, NR_ANO, DS_MODELO, DS_MARCA, DS_COR, TP_COMBUSTIVEL, CD_CEP_PERNOITE, DS_PROPRIETARIO, CD_CONTRATO ) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);

			// Complemento da query
			stmt.setString(1, moto.getPlacaMoto());
			stmt.setInt(2, moto.getAnoMoto());
			stmt.setString(3, moto.getModeloMoto());
			stmt.setString(4, moto.getMarcaMoto());
			stmt.setString(5, moto.getCorMoto());
			stmt.setString(6, moto.getTipoCombustivelMoto());
			stmt.setString(7, moto.getCepPernoiteMoto());
			stmt.setString(8, moto.getProprietarioMoto());
			stmt.setInt(9, moto.getContratoMoto());

			// Executar a query
			stmt.execute();

			// Fechar a operação
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

// ------------SelectAll------------
	public List<Moto> selectAllMoto() {

		List<Moto> motos = new ArrayList<Moto>();
		String sql = "select * from t_tok_moto order by cd_placa";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(); // Usar quando se trabalha com lista.

			// While para percorrer toda a tabela.

			while (rs.next()) {
				// Enquanto tiver dados na tabela, executa isso abaixo.

				// Instanciamos um usuario vazio, e temos que deixar um novo construtor vazio.
				Moto moto = new Moto();
				moto = new Moto();
				moto.setPlacaMoto(rs.getString("cd_placa"));
				moto.setAnoMoto(rs.getInt("nr_ano"));
				moto.setModeloMoto(rs.getString("ds_modelo"));
				moto.setMarcaMoto(rs.getString("ds_marca"));
				moto.setCorMoto(rs.getString("ds_cor"));
				moto.setTipoCombustivelMoto(rs.getString("tp_combustivel"));
				moto.setCepPernoiteMoto(rs.getString("cd_cep_pernoite"));
				moto.setProprietarioMoto(rs.getString("ds_proprietario"));
				motos.add(moto); // Cada objeto moto adicionado a lista de motos.
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return motos;
	}

// ------------SelectByPlaca------------

	public Moto selectByPlaca(String placa) {

		Moto moto = null;
		String sql = "select * from t_tok_moto where cd_placa=?";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, placa);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				moto = new Moto();
				moto.setPlacaMoto(rs.getString("cd_placa"));
				moto.setAnoMoto(rs.getInt("nr_ano"));
				moto.setModeloMoto(rs.getString("ds_modelo"));
				moto.setMarcaMoto(rs.getString("ds_marca"));
				moto.setCorMoto(rs.getString("ds_cor"));
				moto.setTipoCombustivelMoto(rs.getString("tp_combustivel"));
				moto.setCepPernoiteMoto(rs.getString("cd_cep_pernoite"));
				moto.setProprietarioMoto(rs.getString("ds_proprietario"));

			} else {
				System.out.println("Placa nao encontrada");
			}
			rs.close();
			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return moto;
	}

// ------------Update------------ //
	public void updateMoto(Moto moto) {

		String sql = "UPDATE T_TOK_MOTO SET cd_cep_pernoite=? WHERE cd_placa =?";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, moto.getCepPernoiteMoto());
			stmt.setString(2, moto.getPlacaMoto());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {

		}
	}

// ------------Delete------------
	public boolean deleteMoto(String Placa) {
		String sql = "delete from T_TOK_MOTO where (cd_placa = ?)";

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
