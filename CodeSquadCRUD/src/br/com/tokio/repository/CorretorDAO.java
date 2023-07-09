package br.com.tokio.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.tokio.connection.ConnectionFactory;
import br.com.tokio.model.Corretor;

public class CorretorDAO {
	private Connection conexao;

	// CONEXAO PARA ESSA ENTIDADE
	public CorretorDAO() {

		this.conexao = new ConnectionFactory().conectar();
	}

	// -------------LOGIN CORRETOR------------- //
		public ResultSet loginCorretor(Corretor corretor) {

			try {
				String sql = "SELECT * FROM T_TOK_CORRETOR WHERE DS_EMAIL_COR = ? AND DS_SENHA_COR = ?";

				PreparedStatement stmt = conexao.prepareStatement(sql);
				stmt.setString(1, corretor.getEmailCorretor());
				stmt.setString(2, corretor.getSenhaCorretor());

				ResultSet rs = stmt.executeQuery();

				return rs;

			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "CorretorDAO: " + e);
				return null;
			}

		}

	// ------------Insert Corretor------------
	public void insertCorretor(Corretor corretor) {

		String sql = "insert into t_tok_corretor (DS_EMAIL_COR, DS_SENHA_COR) values (?, ?)";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);

			stmt.setString(1, corretor.getEmailCorretor());
			stmt.setString(2, corretor.getSenhaCorretor());

			stmt.execute();

			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// ------------SelectAll------------
	public List<Corretor> selectAllSeguro() {

		List<Corretor> corretores = new ArrayList<Corretor>();
		String sql = "select * from t_tok_corretor order by nm_corretor";

		try {

			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Corretor corretor = new Corretor();
				corretor = new Corretor();
				corretor.setEmailCorretor(rs.getString("ds_email_cor"));
				corretor.setSenhaCorretor(rs.getString("ds_senha_cor"));

				corretores.add(corretor); // Cada objeto seguro adicionado a lista de caminhoes.
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return corretores;
	}

	// ------------SelectByEmail------------

	public Corretor selectByCorretor(String codigoCorretor) {

		Corretor corretores = null;
		String sql = "select * from t_tok_corretor where ds_email_cor = ?";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, codigoCorretor);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				corretores = new Corretor();
				corretores.setEmailCorretor(rs.getString("ds_email_cor"));
				corretores.setSenhaCorretor(rs.getString("ds_senha_cor"));
			} else {
				System.out.println("Corretor não encontrado");
			}
			rs.close();
			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return corretores;
	}

	// ------------Delete------------ //

	public boolean deleteCorretor(String emailCorretor) {

		String sql = "delete from T_TOK_CORRETOR where (ds_email_cor = ?)";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, emailCorretor);
			stmt.executeUpdate();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}
}
