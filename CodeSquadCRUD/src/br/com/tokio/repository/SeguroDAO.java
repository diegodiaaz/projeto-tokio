package br.com.tokio.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.tokio.connection.ConnectionFactory;
import br.com.tokio.model.Seguro;

public class SeguroDAO {
	private Connection conexao;

	// CONEXAO PARA ESSA ENTIDADE
	public SeguroDAO() {

		this.conexao = new ConnectionFactory().conectar();
	}

	// ------------Insert da SEGURO------------
	public void insertCadastroSeguro(Seguro seguro) {

		String sql = "insert into t_tok_seguro (TP_SEGURO, nr_cpf_cli, ds_email_cor) values (?, ?, ?)";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);

			stmt.setString(1, seguro.getTipoSeguro());
			stmt.setString(2, seguro.getCpfCliente());
			stmt.setString(3, seguro.getEmailCorretor());

			stmt.execute();

			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// ------------SelectAll------------
	public List<Seguro> selectAllSeguro() {

		List<Seguro> seguros = new ArrayList<Seguro>();
		String sql = "select * from t_tok_seguro order by cd_contrato";

		try {

			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Seguro seguro = new Seguro();
				seguro = new Seguro();
				seguro.setTipoSeguro(rs.getString("tp_seguro"));

				seguros.add(seguro); // Cada objeto seguro adicionado a lista de caminhoes.
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return seguros;
	}

	// ------------SelectByCodigoContrato------------

	public Seguro selectByContrato(String codigoContrato) {

		Seguro seguro = null;
		String sql = "select tp_seguro from t_tok_seguro where cd_contrato = ?";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, codigoContrato);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				seguro = new Seguro();
				seguro.setTipoSeguro(rs.getString("tp_seguro"));
			} else {
				System.out.println("Contrato nao encontrado");
			}
			rs.close();
			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return seguro;
	}

	// ------------Delete------------

}
