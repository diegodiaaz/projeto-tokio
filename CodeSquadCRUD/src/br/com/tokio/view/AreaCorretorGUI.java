package br.com.tokio.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import br.com.tokio.connection.ConnectionFactory;
import br.com.tokio.model.Cliente;
import br.com.tokio.model.Seguro;
import br.com.tokio.repository.CaminhaoDAO;
import br.com.tokio.repository.CarroDAO;
import br.com.tokio.repository.ClienteDAO;
import br.com.tokio.repository.MotoDAO;
import br.com.tokio.repository.SeguroDAO;

public class AreaCorretorGUI {

	private Connection conexao;

	public JFrame frameCorretor;
	private JLabel labelBackground;
	private JTable tableContratos;
	private JTextField textCPF, textNome;
	ClienteDAO clienteDao = new ClienteDAO();
	SeguroDAO seguroDao = new SeguroDAO();
	CarroDAO carroDao = new CarroDAO();
	MotoDAO motoDao = new MotoDAO();
	CaminhaoDAO caminhaoDao = new CaminhaoDAO();

	private DefaultTableModel TabelaContratos;
	private DefaultTableModel TabelaClientes;
	private JTextField txtCpfContrato;
	private JTable tableClientes;
	private JTextField txtCpfCli;

	/**
	 * Launch the application.
	 */
	public static void newScreen(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AreaCorretorGUI window = new AreaCorretorGUI();
					window.frameCorretor.setVisible(true);
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
		frameCorretor = new JFrame();
		frameCorretor.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(AreaCorretorGUI.class.getResource("/br/com/tokio/images/logo_tokio.png")));
		frameCorretor.setTitle("TOKIO MARINE SEGURADORA");
		frameCorretor.setBounds(100, 100, 1000, 600);
		frameCorretor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameCorretor.getContentPane().setLayout(null);

		JButton btnGerarContrato = new JButton("Gerar contrato");
		btnGerarContrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameCorretor.dispose();
				AreaSeguroGUI areaSeguro = new AreaSeguroGUI();
				areaSeguro.frmAreaInicio.setVisible(true);
			}
		});

		JButton btnExcluirContrato = new JButton("Excluir Contrato");
		btnExcluirContrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] arrayOpcoes1 = { "Sim", "Nao" };

				int opcoes = JOptionPane.showOptionDialog(null, "Deseja deletar este contrato?", "Cuidado",
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, arrayOpcoes1, arrayOpcoes1[0]);

				if (opcoes == 0) {
					ExcluirContrato();
				} else {
					JOptionPane.showMessageDialog(null, "Exclusão cancelada!");
				}
				
			}
		});
		
		JLabel lblGenero = new JLabel("Gênero:");
		lblGenero.setForeground(Color.WHITE);
		lblGenero.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblGenero.setBounds(846, 341, 85, 23);
		frameCorretor.getContentPane().add(lblGenero);
		
		JLabel lblTelefone = new JLabel("Tel:");
		lblTelefone.setForeground(Color.WHITE);
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTelefone.setBounds(766, 341, 66, 23);
		frameCorretor.getContentPane().add(lblTelefone);
		
		JLabel lblEmailCli = new JLabel("Email:");
		lblEmailCli.setForeground(Color.WHITE);
		lblEmailCli.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEmailCli.setBounds(656, 341, 66, 23);
		frameCorretor.getContentPane().add(lblEmailCli);
		
		JLabel lblDataNasc = new JLabel("Data nasc:");
		lblDataNasc.setForeground(Color.WHITE);
		lblDataNasc.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblDataNasc.setBounds(530, 341, 94, 23);
		frameCorretor.getContentPane().add(lblDataNasc);
		
		JLabel lblNomeCli = new JLabel("Nome:");
		lblNomeCli.setForeground(Color.WHITE);
		lblNomeCli.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNomeCli.setBounds(443, 341, 57, 23);
		frameCorretor.getContentPane().add(lblNomeCli);
		
		JLabel lblCPFCli = new JLabel("CPF:");
		lblCPFCli.setForeground(Color.WHITE);
		lblCPFCli.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCPFCli.setBounds(357, 341, 57, 23);
		frameCorretor.getContentPane().add(lblCPFCli);
		
		JButton botaoExcluirCli = new JButton("Excluir\r\n");
		botaoExcluirCli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			deletarCliente();	
			}
		});
		botaoExcluirCli.setForeground(new Color(0, 51, 51));
		botaoExcluirCli.setBounds(145, 449, 78, 29);
		frameCorretor.getContentPane().add(botaoExcluirCli);
		
		JButton botaoLimparTabelaCli = new JButton("Limpar Tela");
		botaoLimparTabelaCli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparTabelaClientes();
			}
		});
		botaoLimparTabelaCli.setForeground(new Color(0, 51, 51));
		botaoLimparTabelaCli.setBounds(21, 449, 115, 29);
		frameCorretor.getContentPane().add(botaoLimparTabelaCli);
		
		JButton botaoBuscarCliente = new JButton("Buscar");
		botaoBuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreencherTabelaClientes();
			}
		});
		botaoBuscarCliente.setForeground(Color.WHITE);
		botaoBuscarCliente.setFont(new Font("Tahoma", Font.BOLD, 11));
		botaoBuscarCliente.setBackground(new Color(0, 153, 102));
		botaoBuscarCliente.setBounds(233, 449, 74, 68);
		frameCorretor.getContentPane().add(botaoBuscarCliente);
		
		JLabel labelCPF_1 = new JLabel("CPF:");
		labelCPF_1.setForeground(Color.WHITE);
		labelCPF_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelCPF_1.setBounds(22, 390, 46, 14);
		frameCorretor.getContentPane().add(labelCPF_1);
		
		txtCpfCli = new JTextField();
		txtCpfCli.setColumns(10);
		txtCpfCli.setBounds(22, 408, 287, 30);
		frameCorretor.getContentPane().add(txtCpfCli);
		
		JLabel lblConsultaCli = new JLabel("Consulte os possiveis clientes:");
		lblConsultaCli.setForeground(Color.WHITE);
		lblConsultaCli.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblConsultaCli.setBounds(12, 320, 295, 88);
		frameCorretor.getContentPane().add(lblConsultaCli);
		
		JPanel lineCliente = new JPanel();
		lineCliente.setBackground(new Color(51, 204, 153));
		lineCliente.setBounds(12, 374, 269, 5);
		frameCorretor.getContentPane().add(lineCliente);
		
		
		btnExcluirContrato.setForeground(new Color(0, 51, 51));
		btnExcluirContrato.setBounds(21, 255, 115, 29);
		frameCorretor.getContentPane().add(btnExcluirContrato);
		btnGerarContrato.setForeground(new Color(0, 51, 51));
		btnGerarContrato.setBounds(21, 489, 115, 29);
		frameCorretor.getContentPane().add(btnGerarContrato);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(
				new ImageIcon(AreaCorretorGUI.class.getResource("/br/com/tokio/images/logo_codesquad_pequena.png")));
		lblLogo.setBounds(108, 11, 104, 77);
		frameCorretor.getContentPane().add(lblLogo);

		JLabel lblTipoVeic = new JLabel("Tipo veiculo:");
		lblTipoVeic.setForeground(Color.WHITE);
		lblTipoVeic.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTipoVeic.setBounds(640, 109, 115, 23);
		frameCorretor.getContentPane().add(lblTipoVeic);

		JLabel lblEmailCor = new JLabel("Email:");
		lblEmailCor.setForeground(Color.WHITE);
		lblEmailCor.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEmailCor.setBounds(556, 111, 74, 19);
		frameCorretor.getContentPane().add(lblEmailCor);

		JLabel lblCdContrato = new JLabel("Cd contrato");
		lblCdContrato.setForeground(Color.WHITE);
		lblCdContrato.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCdContrato.setBounds(432, 111, 105, 14);
		frameCorretor.getContentPane().add(lblCdContrato);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setForeground(new Color(255, 255, 255));
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCpf.setBounds(357, 111, 57, 14);
		frameCorretor.getContentPane().add(lblCpf);

		JButton botaoLimparTabelaCont = new JButton("Limpar Tela");
		botaoLimparTabelaCont.setForeground(new Color(0, 51, 51));
		botaoLimparTabelaCont.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparTabelaContratos();
			}
		});
		botaoLimparTabelaCont.setBounds(21, 215, 115, 29);
		frameCorretor.getContentPane().add(botaoLimparTabelaCont);

		txtCpfContrato = new JTextField();
		txtCpfContrato.setBounds(20, 174, 287, 30);
		frameCorretor.getContentPane().add(txtCpfContrato);
		txtCpfContrato.setColumns(10);

		JPanel lineContratos = new JPanel();
		lineContratos.setBackground(new Color(51, 204, 153));
		lineContratos.setBounds(23, 140, 196, 5);
		frameCorretor.getContentPane().add(lineContratos);

		JLabel labelTextoClientes = new JLabel("Colsulte os contratos:");
		labelTextoClientes.setForeground(new Color(255, 255, 255));
		labelTextoClientes.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		labelTextoClientes.setBounds(23, 106, 295, 49);
		frameCorretor.getContentPane().add(labelTextoClientes);

		JLabel labelTextoMarina = new JLabel("Seja bem-vindo(a) de volta, corretor.");
		labelTextoMarina.setForeground(new Color(255, 255, 255));
		labelTextoMarina.setFont(new Font("Tahoma", Font.BOLD, 26));
		labelTextoMarina.setBounds(428, 11, 629, 88);
		frameCorretor.getContentPane().add(labelTextoMarina);

		JPanel panelFundoMarina = new JPanel();
		panelFundoMarina.setBackground(new Color(0, 153, 102));
		panelFundoMarina.setBounds(330, 11, 629, 88);
		frameCorretor.getContentPane().add(panelFundoMarina);
		panelFundoMarina.setLayout(null);

		JLabel labelMarina = new JLabel("");
		labelMarina.setBounds(10, 0, 103, 88);
		panelFundoMarina.add(labelMarina);
		labelMarina.setIcon(new ImageIcon(AreaCorretorGUI.class.getResource("/br/com/tokio/images/marinaaaa.png")));

		JButton botaoVoltar = new JButton("");
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameCorretor.dispose();
				LoginCorretorGUI login = new LoginCorretorGUI();
				login.frameLoginCorretor.setVisible(true);

			}
		});
		botaoVoltar.setIcon(new ImageIcon(AreaCorretorGUI.class.getResource("/br/com/tokio/images/botao_voltar.png")));
		botaoVoltar.setBounds(10, 11, 46, 23);
		frameCorretor.getContentPane().add(botaoVoltar);

		JLabel labelCPF = new JLabel("CPF:");
		labelCPF.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelCPF.setForeground(new Color(255, 255, 255));
		labelCPF.setBounds(20, 156, 46, 14);
		frameCorretor.getContentPane().add(labelCPF);

		JButton botaoBuscarContratos = new JButton("Buscar");
		botaoBuscarContratos.setForeground(new Color(255, 255, 255));
		botaoBuscarContratos.setFont(new Font("Tahoma", Font.BOLD, 11));
		botaoBuscarContratos.setBackground(new Color(0, 153, 102));
		botaoBuscarContratos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PreencerTabelaContrato();
				limparCampos();
			}

		});

		botaoBuscarContratos.setBounds(181, 214, 126, 70);
		frameCorretor.getContentPane().add(botaoBuscarContratos);
		

		tableClientes = new JTable();
		tableClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableClientes.setFillsViewportHeight(true);
		tableClientes.setColumnSelectionAllowed(true);
		tableClientes.setCellSelectionEnabled(true);
		TabelaClientes = (DefaultTableModel) tableClientes.getModel();
		tableClientes.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		TabelaClientes.addColumn("Nome");
        TabelaClientes.addColumn("Cpf");
        TabelaClientes.addColumn("Email");
        TabelaClientes.addColumn("Data Nascimento");
        TabelaClientes.addColumn("Telefone");
        TabelaClientes.addColumn("Genero");
		
		tableClientes.setBounds(347, 366, 607, 151);		
		frameCorretor.getContentPane().add(tableClientes);
		

		tableContratos = new JTable();
		tableContratos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableContratos.setFillsViewportHeight(true);
		tableContratos.setColumnSelectionAllowed(true);
		tableContratos.setCellSelectionEnabled(true);
		tableContratos.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		TabelaContratos = (DefaultTableModel) tableContratos.getModel();

		TabelaContratos.addColumn("Codigo Contrato");
		TabelaContratos.addColumn("Tipo Seguro");
		TabelaContratos.addColumn("CPF Cliente");
		TabelaContratos.addColumn("Email Corretor");
		

		tableContratos.setBounds(352, 133, 607, 121);
		frameCorretor.getContentPane().add(tableContratos);

		labelBackground = new JLabel("\r\n");
		labelBackground.setIcon(
				new ImageIcon(AreaCorretorGUI.class.getResource("/br/com/tokio/images/fundo_login_maior.png")));
		labelBackground.setBounds(0, -8, 984, 569);
		frameCorretor.getContentPane().add(labelBackground);
	}

	protected static void dispose() {
		// TODO Auto-generated method stub

	}

	public void newScreen() {
		// TODO Auto-generated method stub

	}
	
	private void PreencherTabelaClientes() {
		String cpf;
		cpf = txtCpfCli.getText();
		

		Cliente cliente = clienteDao.selectByCPF(cpf);

		TabelaClientes.addRow(new Object[] { cliente.getCpfCliente(), cliente.getNomeCliente(), cliente.getDataNascimento(), cliente.getEmailCliente(),
				cliente.getTelefoneCliente(), cliente.getGeneroCliente(), cliente.getDataCadastro()});
	}

	private void PreencerTabelaContrato() {
		String cpf;
		cpf = txtCpfContrato.getText();
		txtCpfContrato.setText(cpf);

		Seguro seguro = seguroDao.selectByContrato(cpf);

		TabelaContratos.addRow(new Object[] { seguro.getCpfCliente(), seguro.getCodigoContrato(), seguro.getEmailCorretor(),
				seguro.getTipoSeguro()});
	}

	private void limparTabelaContratos() {
		((DefaultTableModel) TabelaContratos).setRowCount(0);
	}
	
	private void limparTabelaClientes() {
		((DefaultTableModel) TabelaClientes).setRowCount(0);
	}


//	private void ExcluirCarro() {
//		Object objetoDaLinha = (Object) TABELACRUD.getValueAt(tableInfoClientes.getSelectedRow(),
//				tableInfoClientes.getSelectedColumn());
//		if(objetoDaLinha instanceof String) {
//			String codigoContrato = (String) objetoDaLinha;
//			this.carroDao.deleteCarro(codigoContrato);
//			TABELACRUD.removeRow(tableInfoClientes.getSelectedRow());
//		} else {
//			JOptionPane.showMessageDialog(null, "Por favor, selecione o codigo de contrato");
//		}
//	}

	private void ExcluirContrato() {
		Object objetoDaLinha = (Object) TabelaContratos.getValueAt(tableContratos.getSelectedRow(),
				tableContratos.getSelectedColumn());
		if (objetoDaLinha instanceof String) {
			String codigoContrato = (String) objetoDaLinha;
			this.carroDao.deleteCarro(codigoContrato);
			this.seguroDao.deleteSeguro(codigoContrato);
			TabelaContratos.removeRow(tableContratos.getSelectedRow());
		} else {
			JOptionPane.showMessageDialog(null, "Por favor, selecione o codigo de contrato");
		}
	}
	
//	private void ExcluirCliente() {
//		Object objetoDaLinha = (Object) TabelaClientes.getValueAt(tableClientes.getSelectedRow(),
//				tableClientes.getSelectedColumn());
//		if (objetoDaLinha instanceof String) {
//			String codigoContrato = (String) objetoDaLinha;
//			this.carroDao.deleteCarro(codigoContrato);
//			this.seguroDao.deleteSeguro(codigoContrato);
//			TabelaClientes.removeRow(tableClientes.getSelectedRow());
//		} else {
//			JOptionPane.showMessageDialog(null, "Por favor, selecione o codigo de contrato");
//		}
//	}

	private void deletarCliente() {
		Object objetoSelecionado = (Object) tableClientes.getValueAt(tableClientes.getSelectedRow(),
				tableClientes.getSelectedColumn());
		if (objetoSelecionado instanceof String) {
			String CPF = (String) objetoSelecionado;

			this.clienteDao.deleteCliente(CPF);
			TabelaClientes.removeRow(tableClientes.getSelectedRow());
			JOptionPane.showMessageDialog(null, "Item excluido com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Por favor, selecione o CPF");
		}
	}

	private void limparCampos() {
		this.txtCpfContrato.setText("");
	}
}