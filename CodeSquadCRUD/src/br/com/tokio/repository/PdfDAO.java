//package br.com.tokio.repository;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//
//import javax.swing.JOptionPane;
//
//import br.com.tokio.connection.ConnectionFactory;
//import br.com.tokio.model.Cliente;
//
//public class PdfDAO {
//	
//	public Connection conexao;
//
//	// Conexão para essa entidade.
//	public PdfDAO() {
//		this.conexao = new ConnectionFactory().conectar();
//	}
//	
//	public Cliente selectByCPF(String cpf) {
//
//		Cliente cliente = null;
//		String sql = "select * from t_tok_seguro where nr_cpf_cli=?";
//
//		try {
//			PreparedStatement stmt = conexao.prepareStatement(sql);
//			stmt.setString(1, cpf);
//
//			ResultSet rs = stmt.executeQuery();
//
//			if (rs.next()) {
//				cliente = new Cliente();
//				cliente.setNomeCliente(rs.getString("nm_cliente"));
//				cliente.setCpfCliente(rs.getString("nr_cpf_cli"));
//				cliente.setDataNascimento(rs.getString("dt_nascimento"));
//				cliente.setEmailCliente(rs.getString("ds_email_cli"));
//				cliente.setTelefoneCliente(rs.getString("nr_telefone_cli"));
//				cliente.setGeneroCliente(rs.getString("ds_genero_cli"));
//				cliente.setDataCadastro(rs.getDate("dt_Cadastro_cli"));
//
//			} else {
//				JOptionPane.showMessageDialog(null, "Cliente nao encontrado");
//			}
//			rs.close();
//			stmt.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return cliente;
//	}
//}
