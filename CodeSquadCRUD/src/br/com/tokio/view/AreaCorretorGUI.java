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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.tokio.connection.ConnectionFactory;
import br.com.tokio.model.Cliente;
import br.com.tokio.repository.ClienteDAO;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;

public class AreaCorretorGUI {

	private Connection conexao;

	public JFrame frmT;
	private JLabel labelBackground;
	private JTable tableInfoClientes;
	private JTextField textCPF, textNome;
	ClienteDAO clienteDao = new ClienteDAO();
	private DefaultTableModel TABELACRUD;
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
		
		JButton btnGerarContrato = new JButton("Gerar contrato");
		btnGerarContrato.setForeground(new Color(0, 51, 51));
		btnGerarContrato.setBounds(182, 355, 115, 29);
		frmT.getContentPane().add(btnGerarContrato);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AreaCorretorGUI.class.getResource("/br/com/tokio/images/logo_codesquad_pequena.png")));
		lblNewLabel.setBounds(23, 462, 104, 77);
		frmT.getContentPane().add(lblNewLabel);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setForeground(Color.WHITE);
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTelefone.setBounds(869, 166, 92, 14);
		frmT.getContentPane().add(lblTelefone);
		
		JLabel lblGenero = new JLabel("Gênero:");
		lblGenero.setForeground(Color.WHITE);
		lblGenero.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblGenero.setBounds(768, 166, 82, 14);
		frmT.getContentPane().add(lblGenero);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEmail.setBounds(667, 166, 82, 14);
		frmT.getContentPane().add(lblEmail);
		
		JLabel lblDataNasc = new JLabel("Data Nasc:");
		lblDataNasc.setForeground(Color.WHITE);
		lblDataNasc.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblDataNasc.setBounds(534, 165, 104, 14);
		frmT.getContentPane().add(lblDataNasc);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNome.setBounds(451, 165, 82, 14);
		frmT.getContentPane().add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setForeground(new Color(255, 255, 255));
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCpf.setBounds(359, 165, 82, 14);
		frmT.getContentPane().add(lblCpf);
		
		JButton botaoLimparTabela = new JButton("Limpar Tela");
		botaoLimparTabela.setForeground(new Color(0, 51, 51));
		botaoLimparTabela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparTabela();
			}
		});
		botaoLimparTabela.setBounds(98, 315, 115, 29);
		frmT.getContentPane().add(botaoLimparTabela);

		txtCpf = new JTextField();
		txtCpf.setBounds(10, 274, 287, 30); 
		frmT.getContentPane().add(txtCpf);
		txtCpf.setColumns(10);

		JPanel linhaTextoClientes = new JPanel();
		linhaTextoClientes.setBackground(new Color(51, 204, 153));
		linhaTextoClientes.setBounds(23, 201, 238, 5);
		frmT.getContentPane().add(linhaTextoClientes);

		JLabel labelTextoClientes = new JLabel("Consulte os possiveis aqui:");
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

		JButton botaoExcluir = new JButton("Excluir\r\n");
		botaoExcluir.setForeground(new Color(0, 51, 51));
		botaoExcluir.setBounds(10, 315, 78, 29);
		frmT.getContentPane().add(botaoExcluir);
		botaoExcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object[] arrayOpcoes = {"Sim", "Nao"};
                
	            int opcoes = JOptionPane.showOptionDialog(null, "Deseja deletar este cliente?", "Cuidado",
	                     JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
	                     null, arrayOpcoes, arrayOpcoes[0]);        
	            
	            if(opcoes == 0) {
	                deletar();
	            }else {
	                JOptionPane.showMessageDialog(null, "Exclusão cancelada!");
	            }
				deletar();

			}

		});

		JLabel labelCPF = new JLabel("CPF:");
		labelCPF.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelCPF.setForeground(new Color(255, 255, 255));
		labelCPF.setBounds(10, 256, 46, 14);
		frmT.getContentPane().add(labelCPF);

		JButton botaoBuscar = new JButton("Buscar");
		botaoBuscar.setForeground(new Color(255, 255, 255));
		botaoBuscar.setFont(new Font("Tahoma", Font.BOLD, 11));
		botaoBuscar.setBackground(new Color(0, 153, 102));
		botaoBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PreencerTabelaCPF();
				limpar();
			}

		});

		botaoBuscar.setBounds(223, 314, 74, 31);
		frmT.getContentPane().add(botaoBuscar);

		tableInfoClientes = new JTable();
		tableInfoClientes.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		TABELACRUD = (DefaultTableModel) tableInfoClientes.getModel();

		TABELACRUD.addColumn("CPF do Cliente");
		TABELACRUD.addColumn("Nome do Cliente");
		TABELACRUD.addColumn("E-mail do Cliente");
		TABELACRUD.addColumn("Telefone do Cliente");
		TABELACRUD.addColumn("Data Nascimento do Cliente");
		TABELACRUD.addColumn("Gênero do Cliente");
		
		

		tableInfoClientes.setBounds(320, 187, 646, 352);
		frmT.getContentPane().add(tableInfoClientes);

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

		Cliente cliente = clienteDao.selectByCPF(cpf);

		TABELACRUD.addRow(new Object[] { cliente.getCpfCliente(), cliente.getNomeCliente(), cliente.getDataNascimento(),
				cliente.getEmailCliente(), cliente.getGeneroCliente(), cliente.getTelefoneCliente(),
				cliente.getDataCadastro() });
	}

	private void limparTabela() {
		((DefaultTableModel) TABELACRUD).setRowCount(0);
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
		this.txtCpf.setText("");
	}
}