package br.com.tokio.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.tokio.connection.ConnectionFactory;
import br.com.tokio.model.Cliente;

public class ClienteDAO {

	// Pertecente a classe USUARIODAO.
	public Connection conexao;

	// Conexão para essa entidade.
	public ClienteDAO() {
		this.conexao = new ConnectionFactory().conectar();
	}

	// -----------Operações de CRUD:-----------//

	// -------------LOGIN Cliente------------- //
	public ResultSet loginCliente(Cliente cliente) {

		try {
			String sql = "SELECT * FROM T_TOK_CLIENTE WHERE DS_EMAIL_CLI = ? AND NR_CPF_CLI = ?";

			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cliente.getEmailCliente());
			stmt.setString(2, cliente.getCpfCliente());

			ResultSet rs = stmt.executeQuery();

			return rs;

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "ClienteDAO: " + e);
			return null;
		}

	}

	// ------------Insert do Cliente------------
		public void insertCadastroCliente(Cliente cliente) {

			String sql = "insert into t_tok_cliente (NR_CPF_CLI, NM_CLIENTE, DT_NASCIMENTO, DS_EMAIL_CLI, NR_TELEFONE_CLI, DS_GENERO_CLI, DT_CADASTRO_CLI) values (?, ?, ?, ?, ?, ?, ?)";

			try {
				PreparedStatement stmt = conexao.prepareStatement(sql);

				// Complemento da query
				stmt.setString(1, cliente.getCpfCliente());
				stmt.setString(2, cliente.getNomeCliente());
				stmt.setString(3, cliente.getDataNascimento());
				stmt.setString(4, cliente.getEmailCliente());
				stmt.setString(5, cliente.getTelefoneCliente());
				stmt.setString(6, cliente.getGeneroCliente());
				stmt.setDate(7, cliente.getDataCadastro());

				// Executar a query
				stmt.execute();

				// Fechar a operação
				stmt.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// ------------SelectAll------------
		public List<Cliente> selectAll() {

			List<Cliente> usuarios = new ArrayList<Cliente>();
			String sql = "select * from t_tok_cliente order by nm_cliente";

			try {
				PreparedStatement stmt = conexao.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					Cliente cliente = new Cliente();
					cliente = new Cliente();
					cliente.setNomeCliente(rs.getString("nm_cliente"));
					cliente.setCpfCliente(rs.getString("nr_cpf_cli"));
					cliente.setDataNascimento(rs.getString("dt_nascimento"));
					cliente.setEmailCliente(rs.getString("ds_email_cli"));
					cliente.setTelefoneCliente(rs.getString("nr_telefone_cli"));
					cliente.setGeneroCliente(rs.getString("ds_genero_cli"));
					cliente.setDataCadastro(rs.getDate("dt_Cadastro_cli"));
					usuarios.add(cliente); // Cada objeto usuário adicionado a lista de usuários.
				}
				rs.close();
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return usuarios;
		}

		// ------------Select TipoSeguro by CPFCliente------------ //
		public Cliente selectTipoSeguro(String cpf) {

			Cliente cliente = null;
			String sql = "SELECT" + "    P.NR_CPF ' -- '  TP_SEGURO  " + "	   FROM "
					+ "    T_TOK_CLIENTE P INNER JOIN T_TOK_SEGURO D ON" + "    (P.NR_CPF = D.NR_CPF);";

			try {
				PreparedStatement stmt = conexao.prepareStatement(sql);
				stmt.setString(1, cpf);

				ResultSet rs = stmt.executeQuery();

				if (rs.next()) {
					cliente = new Cliente();
					cliente.setNomeCliente(rs.getString("nm_cliente"));
					cliente.setCpfCliente(rs.getString("nr_cpf_cli"));
					cliente.setDataNascimento(rs.getString("dt_nascimento_cli"));
					cliente.setEmailCliente(rs.getString("ds_email_cli"));
					cliente.setTelefoneCliente(rs.getString("nr_telefone_cli"));
					cliente.setGeneroCliente(rs.getString("ds_genero_cli"));
					cliente.setDataCadastro(rs.getDate("dt_Cadastro_cli"));
				} else {
					System.out.println("Cliente não encontrado");
				}
				rs.close();
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return cliente;
		}
		
		//------------SELECTBYCPF----------------//
		public Cliente selectByCPF(String cpf) {

			Cliente cliente = null;
			String sql = "select * from t_tok_cliente where nr_cpf_cli=?";

			try {
				PreparedStatement stmt = conexao.prepareStatement(sql);
				stmt.setString(1, cpf);

				ResultSet rs = stmt.executeQuery();

				if (rs.next()) {
					cliente = new Cliente();
					cliente.setNomeCliente(rs.getString("nm_cliente"));
					cliente.setCpfCliente(rs.getString("nr_cpf_cli"));
					cliente.setDataNascimento(rs.getString("dt_nascimento"));
					cliente.setEmailCliente(rs.getString("ds_email_cli"));
					cliente.setTelefoneCliente(rs.getString("nr_telefone_cli"));
					cliente.setGeneroCliente(rs.getString("ds_genero_cli"));
					cliente.setDataCadastro(rs.getDate("dt_Cadastro_cli"));

				} else {
					JOptionPane.showMessageDialog(null, "Cliente nao encontrado");
				}
				rs.close();
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return cliente;
		}

		// ------------SelectByCPFAndName------------

		public Cliente selectByCPFAndName(String cpf, String nome) {

			Cliente cliente = null;
			String sql = "select * from t_tok_cliente where nr_cpf_cli=? and nm_cliente=?";

			try {
				PreparedStatement stmt = conexao.prepareStatement(sql);
				stmt.setString(1, cpf);
				stmt.setString(2, nome);

				ResultSet rs = stmt.executeQuery();

				if (rs.next()) {
					cliente = new Cliente();
					cliente.setNomeCliente(rs.getString("nm_cliente"));
					cliente.setCpfCliente(rs.getString("nr_cpf_cli"));
					cliente.setDataNascimento(rs.getString("dt_nascimento"));
					cliente.setEmailCliente(rs.getString("ds_email_cli"));
					cliente.setTelefoneCliente(rs.getString("nr_telefone_cli"));
					cliente.setGeneroCliente(rs.getString("ds_genero_cli"));
					cliente.setDataCadastro(rs.getDate("dt_Cadastro_cli"));

				} else {
					JOptionPane.showMessageDialog(null, "Cliente nao encontrado");
				}
				rs.close();
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return cliente;
		}

		// ------------Update------------ DEVEMOS ALTERAR O METODO DE UPDATE CLIENTE JA
		// QUE NAO TEM MAIS SENHA!!!! (RAFAEL FORTI)
		public void updateCliente(Cliente cliente) {

			String sql = "UPDATE T_TOK_CLIENTE SET nr_cpf_cli =?, nm_cliente=? ,ds_email_cli=?, nr_telefone_cli =?, ds_genero_cli=? WHERE nr_cpf_cli =?";

			try {
				PreparedStatement stmt = conexao.prepareStatement(sql);
				stmt.setString(1, cliente.getCpfCliente());
				stmt.setString(2, cliente.getNomeCliente());
				stmt.setString(3, cliente.getEmailCliente());
				stmt.setString(4, cliente.getTelefoneCliente());
				stmt.setString(5, cliente.getGeneroCliente());
				stmt.setString(6, cliente.getDataNascimento());
				stmt.execute();
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// ------------Delete------------
		public void deleteCliente(String CPF) {

			String sql = "delete from T_TOK_CLIENTE where (NR_CPF_cli = ?)";

			try {
				PreparedStatement stmt = conexao.prepareStatement(sql);
				stmt.setString(1, CPF);
				stmt.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

}
