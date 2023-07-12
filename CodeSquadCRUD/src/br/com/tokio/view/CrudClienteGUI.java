package br.com.tokio.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.tokio.controllers.ClienteController;
import br.com.tokio.model.Cliente;
import br.com.tokio.repository.ClienteDAO;

public class CrudClienteGUI {

	public JFrame frameCliente;
	private JTextField txtNomeCliente;
	private JTextField txtCpf;
	private JTextField txtTelefone;
	private JTextField txtDataNascimento;
	private JTextField txtEmail;
	ClienteDAO clienteDao = new ClienteDAO();
	private JTextField txtGenero;
	private JTextField txtTipoVeiculo;
	ClienteController control = new ClienteController();
	

	/**
	 * Launch the application.
	 */
	public static void newscreen(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrudClienteGUI window = new CrudClienteGUI();
					window.frameCliente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CrudClienteGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	private void initialize() {
		frameCliente = new JFrame();
		frameCliente.setTitle("TOKIO MARINE SEGURADORA");
		frameCliente.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(CrudClienteGUI.class.getResource("/br/com/tokio/images/logo_tokio.png")));
		frameCliente.setBounds(100, 100, 1000, 600);
		frameCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameCliente.getContentPane().setLayout(null);

		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0, 0, 984, 561);
		frameCliente.getContentPane().add(contentPane);

		JButton botaoVoltar = new JButton("");
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameCliente.dispose();
				LoginUsuarioGUI loginUsuario = new LoginUsuarioGUI();
				loginUsuario.newScreen();

			}
		});

		JButton botaoInserir = new JButton("Inserir");
		botaoInserir.setForeground(new Color(255, 255, 255));
		botaoInserir.setBackground(new Color(64, 128, 128));
		botaoInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				control.setCPF(txtCpf.getText());
				Inserir();

			}
		});
		
		JButton botaoPreencher = new JButton("Preencher dados");
		botaoPreencher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				preencherCampos();
			}
		});
		botaoPreencher.setBounds(427, 477, 153, 36);
		contentPane.add(botaoPreencher);
		botaoInserir.setBounds(686, 477, 89, 36);
		contentPane.add(botaoInserir);
		botaoVoltar.setIcon(new ImageIcon(CrudClienteGUI.class.getResource("/br/com/tokio/images/botao_voltar.png")));
		botaoVoltar.setBounds(20, 20, 47, 30);
		contentPane.add(botaoVoltar);

		JButton botaoEditar = new JButton("Editar");
		botaoEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Alterar();
			}
		});
		botaoEditar.setBounds(589, 477, 89, 36);
		contentPane.add(botaoEditar);

		JLabel lblSejaBemvindoaA = new JLabel("Seja bem-vindo(a) a área do cliente!");
		lblSejaBemvindoaA.setForeground(Color.WHITE);
		lblSejaBemvindoaA.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblSejaBemvindoaA.setBounds(278, 22, 489, 88);
		contentPane.add(lblSejaBemvindoaA);

		JLabel labelMarina = new JLabel("");
		labelMarina.setBounds(190, 22, 577, 88);
		contentPane.add(labelMarina);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(190, 132, 585, 331);
		contentPane.add(panel);

		JLabel lblIconeUsuario = new JLabel("");
		lblIconeUsuario
				.setIcon(new ImageIcon(CrudClienteGUI.class.getResource("/br/com/tokio/images/usuario_Foto.png")));
		lblIconeUsuario.setBounds(27, 27, 70, 70);
		panel.add(lblIconeUsuario);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblTelefone.setBounds(27, 241, 193, 25);
		panel.add(lblTelefone);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblCpf.setBounds(27, 177, 193, 25);
		panel.add(lblCpf);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblEmail.setBounds(321, 177, 193, 25);
		panel.add(lblEmail);

		JLabel lblDataNasc = new JLabel("Data de nascimento:");
		lblDataNasc.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblDataNasc.setBounds(321, 108, 193, 25);
		panel.add(lblDataNasc);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNome.setBounds(27, 108, 193, 25);
		panel.add(lblNome);

		txtNomeCliente = new JTextField();
		txtNomeCliente.setBounds(27, 131, 207, 33);
		panel.add(txtNomeCliente);
		txtNomeCliente.setColumns(10);

		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		txtCpf.setBounds(27, 197, 207, 33);
		panel.add(txtCpf);

		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(27, 261, 207, 33);
		panel.add(txtTelefone);

		txtDataNascimento = new JTextField();
		txtDataNascimento.setColumns(10);
		txtDataNascimento.setBounds(321, 131, 207, 33);
		panel.add(txtDataNascimento);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(321, 197, 207, 33);
		panel.add(txtEmail);

		txtGenero = new JTextField();
		txtGenero.setBounds(321, 261, 207, 33);
		panel.add(txtGenero);
		txtGenero.setColumns(10);

		JLabel lblGenero = new JLabel("Genero:");
		lblGenero.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblGenero.setBounds(321, 241, 193, 25);
		panel.add(lblGenero);

		JLabel lblTipoVeiculo = new JLabel("Tipo Veiculo:");
		lblTipoVeiculo.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblTipoVeiculo.setBounds(321, 27, 193, 25);
		panel.add(lblTipoVeiculo);

		txtTipoVeiculo = new JTextField();
		txtTipoVeiculo.setColumns(10);
		txtTipoVeiculo.setBounds(321, 51, 207, 33);
		panel.add(txtTipoVeiculo);

		JLabel lblPrincipal = new JLabel("");
		lblPrincipal .setIcon(new ImageIcon(CrudClienteGUI.class.getResource("/br/com/tokio/images/fundo_login_maior.png")));
		lblPrincipal.setBounds(0, 0, 984, 561);
		contentPane.add(lblPrincipal);
	}

	public void Inserir() {

		Cliente cliente = new Cliente();
		Date data;
		data = new Date(System.currentTimeMillis());
		cliente.setNomeCliente(txtNomeCliente.getText());
		cliente.setCpfCliente(txtCpf.getText());
		cliente.setTelefoneCliente(txtTelefone.getText());
		cliente.setDataNascimento(txtDataNascimento.getText());
		cliente.setEmailCliente(txtEmail.getText());
		cliente.setGeneroCliente(txtGenero.getText());
		cliente.setDataCadastro(data);
		clienteDao.insertCadastroCliente(cliente);

		if (txtTipoVeiculo.getText().equalsIgnoreCase("carro")) {

			
			
			DadosCarroGUI areaInsertCarro = new DadosCarroGUI();
			frameCliente.dispose();
			areaInsertCarro.importarNome(control);
			areaInsertCarro.frameDadosCarro.setVisible(true);
			
		} else if (txtTipoVeiculo.getText().equalsIgnoreCase("moto")) {
			DadosMotoGUI areaInsertMoto = new DadosMotoGUI();
			frameCliente.dispose();
			areaInsertMoto.frameDadosMoto.setVisible(true);
		} else if (txtTipoVeiculo.getText().equalsIgnoreCase("caminhao")) {
			DadosCaminhaoGUI areaInsertCaminhao = new DadosCaminhaoGUI();
			frameCliente.dispose();
			areaInsertCaminhao.frameDadosCaminhao.setVisible(true);
		}

	}

	public void Alterar() {
		Cliente update = clienteDao.selectByCPF(txtCpf.getText());
		update.setNomeCliente(txtNomeCliente.getText());
		update.setCpfCliente(txtCpf.getText());
		update.setTelefoneCliente(txtTelefone.getText());
		update.setDataNascimento(txtDataNascimento.getText());
		update.setEmailCliente(txtEmail.getText());
		update.setGeneroCliente(txtGenero.getText());
		clienteDao.updateCliente(update);

	}
	
	public String getTxtCpf() {
		return txtCpf.toString();
				
	}

	public void setTxtCpf(JTextField txtCpf) {
		this.txtCpf = txtCpf;
	}

	public JTextField getTxtTelefone() {
		return txtTelefone;
	}

	public void setTxtTelefone(JTextField txtTelefone) {
		this.txtTelefone = txtTelefone;
	}

	public void preencherCampos() {
		String cpf = JOptionPane.showInputDialog(null, "Digite o CPF:");
		Cliente cliente = clienteDao.selectByCPF(cpf);
		txtCpf.setText(cliente.getCpfCliente());
		txtNomeCliente.setText(cliente.getNomeCliente());
		txtTelefone.setText(cliente.getTelefoneCliente());
		txtEmail.setText(cliente.getEmailCliente());
		txtDataNascimento.setText(cliente.getDataNascimento());
		txtGenero.setText(cliente.getGeneroCliente());
		
	}
	

	
	
}
















