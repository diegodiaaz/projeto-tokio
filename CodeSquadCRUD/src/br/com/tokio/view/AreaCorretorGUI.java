package br.com.tokio.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import br.com.tokio.connection.ConnectionFactory;
import br.com.tokio.model.Cliente;
import br.com.tokio.repository.ClienteDAO;

public class AreaCorretorGUI {

	private Connection conexao;

	public JFrame frmT;
	private JLabel labelBackground;
	private JTable tableInfoClientes;
	private JTextArea textCPF, textNome;
	ClienteDAO clienteDao = new ClienteDAO();
	private DefaultTableModel TABELACRUD;
	private JTextField txtNome;
	private JTextField txtCpf;

	/**
	 * Launch the application.
	 */
	public static void newScreen(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AreaCorretorGUI window = new AreaCorretorGUI();
					window.frmT.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AreaCorretorGUI() {
		initialize();
		this.conexao = new ConnectionFactory().conectar();
	}

	private void initialize() {
		frmT = new JFrame();
		frmT.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(AreaCorretorGUI.class.getResource("/br/com/tokio/images/logo_tokio.png")));
		frmT.setTitle("TOKIO MARINE SEGURADORA");
		frmT.setBounds(100, 100, 1000, 600);
		frmT.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmT.getContentPane().setLayout(null);

		JButton botaoLimparTabela = new JButton("Limpar Tabela");
		botaoLimparTabela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				limparTabela();
			}
		});
		botaoLimparTabela.setBounds(162, 441, 120, 23);
		frmT.getContentPane().add(botaoLimparTabela);

		txtCpf = new JTextField();
		txtCpf.setBounds(23, 279, 259, 30);
		frmT.getContentPane().add(txtCpf);
		txtCpf.setColumns(10);

		txtNome = new JTextField();
		txtNome.setBounds(23, 341, 259, 30);
		frmT.getContentPane().add(txtNome);
		txtNome.setColumns(10);

		JPanel linhaTextoClientes = new JPanel();
		linhaTextoClientes.setBackground(new Color(51, 204, 153));
		linhaTextoClientes.setBounds(23, 201, 238, 5);
		frmT.getContentPane().add(linhaTextoClientes);

		JLabel labelTextoClientes = new JLabel("Consulte seus clientes aqui:");
		labelTextoClientes.setForeground(new Color(255, 255, 255));
		labelTextoClientes.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		labelTextoClientes.setBounds(23, 147, 295, 88);
		frmT.getContentPane().add(labelTextoClientes);

		JLabel labelTextoMarina = new JLabel("Seja bem-vindo(a) de volta, corretor.");
		labelTextoMarina.setForeground(new Color(255, 255, 255));
		labelTextoMarina.setFont(new Font("Tahoma", Font.BOLD, 26));
		labelTextoMarina.setBounds(428, 46, 629, 88);
		frmT.getContentPane().add(labelTextoMarina);

		JPanel panelFundoMarina = new JPanel();
		panelFundoMarina.setBackground(new Color(0, 153, 102));
		panelFundoMarina.setBounds(330, 46, 629, 88);
		frmT.getContentPane().add(panelFundoMarina);
		panelFundoMarina.setLayout(null);

		JLabel labelMarina = new JLabel("");
		labelMarina.setBounds(10, 0, 103, 88);
		panelFundoMarina.add(labelMarina);
		labelMarina.setIcon(new ImageIcon(AreaCorretorGUI.class.getResource("/br/com/tokio/images/marinaaaa.png")));

		JButton botaoVoltar = new JButton("");
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmT.dispose();
				LoginCorretorGUI login = new LoginCorretorGUI();
				login.frmCorretor.setVisible(true);

			}
		});
		botaoVoltar.setIcon(new ImageIcon(AreaCorretorGUI.class.getResource("/br/com/tokio/images/botao_voltar.png")));
		botaoVoltar.setBounds(10, 11, 46, 23);
		frmT.getContentPane().add(botaoVoltar);

		JButton botaoLimpar = new JButton("Limpar");
		botaoLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		botaoLimpar.setBounds(200, 407, 82, 23);

		frmT.getContentPane().add(botaoLimpar);

		JButton botaoExcluir = new JButton("Excluir\r\n");
		botaoExcluir.setBounds(108, 407, 82, 23);
		frmT.getContentPane().add(botaoExcluir);
		botaoExcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				deletar();

			}

		});

		JLabel labelNome = new JLabel("Nome");
		labelNome.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelNome.setForeground(Color.WHITE);
		labelNome.setBounds(26, 316, 46, 14);
		frmT.getContentPane().add(labelNome);

		JLabel labelCPF = new JLabel("CPF");
		labelCPF.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelCPF.setForeground(new Color(255, 255, 255));
		labelCPF.setBounds(26, 254, 46, 14);
		frmT.getContentPane().add(labelCPF);

		JButton botaoBuscar = new JButton("Buscar");
		botaoBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PreencerTabelaCPF();

				limpar();
			}

		});

		botaoBuscar.setBounds(23, 407, 75, 23);
		frmT.getContentPane().add(botaoBuscar);

		tableInfoClientes = new JTable();
		tableInfoClientes.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"CPF", "NOME", "DATA NASC", "EMAIL", "TELEFONE"
			}
		));
		tableInfoClientes.getColumnModel().getColumn(0).setPreferredWidth(132);
		tableInfoClientes.getColumnModel().getColumn(1).setPreferredWidth(104);
		tableInfoClientes.getColumnModel().getColumn(2).setPreferredWidth(114);
		tableInfoClientes.getColumnModel().getColumn(3).setPreferredWidth(115);
		tableInfoClientes.getColumnModel().getColumn(4).setPreferredWidth(107);
		tableInfoClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		TABELACRUD = (DefaultTableModel) tableInfoClientes.getModel();

		TABELACRUD.addColumn("CPF do Cliente");
		TABELACRUD.addColumn("Nome do Cliente");

		tableInfoClientes.setBounds(320, 187, 646, 352);
		frmT.getContentPane().add(tableInfoClientes);

		JButton botaoBuscarTodos = new JButton("Buscar Todos");
		botaoBuscarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				preencherTabela();
			}
		});
		botaoBuscarTodos.setBounds(23, 441, 120, 23);
		frmT.getContentPane().add(botaoBuscarTodos);

		labelBackground = new JLabel("\r\n");
		labelBackground.setIcon(
				new ImageIcon(AreaCorretorGUI.class.getResource("/br/com/tokio/images/fundo_login_maior.png")));
		labelBackground.setBounds(0, -8, 984, 569);
		frmT.getContentPane().add(labelBackground);
	}

	protected static void dispose() {
		// TODO Auto-generated method stub

	}

	public void newScreen() {
		// TODO Auto-generated method stub

	}

	private void PreencerTabelaCPF() {
		String cpf;
		cpf = txtCpf.getText();
		txtCpf.setText(cpf);
		
		String nome;
		nome = txtNome.getText();
		txtNome.setText(nome);

		Cliente cliente = clienteDao.selectByCPF(cpf, nome);

		TABELACRUD.addRow(new Object[] { cliente.getCpfCliente(), cliente.getNomeCliente(), cliente.getDataNascimento(),
				cliente.getEmailCliente(), cliente.getGeneroCliente(), cliente.getTelefoneCliente(),
				cliente.getDataCadastro() });
	}

	private void limparTabela() {
		((DefaultTableModel) TABELACRUD).setRowCount(0);
	}

	private void preencherTabela() {
		List<Cliente> clientes = clienteDao.selectAll();
		try {
			for (Cliente cliente : clientes) {
				TABELACRUD.addRow(new Object[] { cliente.getCpfCliente(), cliente.getNomeCliente(),
						cliente.getDataNascimento(), cliente.getEmailCliente(), cliente.getGeneroCliente(),
						cliente.getTelefoneCliente(), cliente.getDataCadastro() });
			}
		} catch (Exception e) {
			throw e;
		}
	}

	private void deletar() {
		Object objetoDaLinha = (Object) TABELACRUD.getValueAt(tableInfoClientes.getSelectedRow(),
				tableInfoClientes.getSelectedColumn());
		if (objetoDaLinha instanceof String) {
			String CPF = (String) objetoDaLinha;
			this.clienteDao.deleteCliente(CPF);
			TABELACRUD.removeRow(tableInfoClientes.getSelectedRow());
			JOptionPane.showMessageDialog(null, "Item excluido com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Por favor, selecionar o ID");
		}
	}

	private void limpar() {
		this.txtNome.setText("");
		this.txtCpf.setText("");
	}

}