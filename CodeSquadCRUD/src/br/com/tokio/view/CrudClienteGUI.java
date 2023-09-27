package br.com.tokio.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

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

	/**
	 * Launch the application.
	 */
	public static void newScreen(String[] args) {
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
		frameCliente.setBounds(100, 100, 1275, 765);
		frameCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameCliente.getContentPane().setLayout(null);

		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0, 0, 1259, 726);
		frameCliente.getContentPane().add(contentPane);

		JButton botaoVoltar = new JButton("");
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameCliente.dispose();
				ChatbotGUI areaChat = new ChatbotGUI();
				areaChat.newScreen();

			}
		});

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(
				new ImageIcon(CrudClienteGUI.class.getResource("/br/com/tokio/images/CodeSquadLogo.png")));
		lblLogo.setBounds(20, 532, 229, 183);
		contentPane.add(lblLogo);
		botaoVoltar.setIcon(new ImageIcon(CrudClienteGUI.class.getResource("/br/com/tokio/images/botao_voltar.png")));
		botaoVoltar.setBounds(20, 20, 47, 30);
		contentPane.add(botaoVoltar);

		JLabel lblSejaBemvindoaA = new JLabel("Seja bem-vindo(a) a área do cliente!");
		lblSejaBemvindoaA.setForeground(Color.WHITE);
		lblSejaBemvindoaA.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblSejaBemvindoaA.setBounds(381, 48, 607, 88);
		contentPane.add(lblSejaBemvindoaA);

		JLabel labelMarina = new JLabel("");
		labelMarina.setBounds(190, 22, 577, 88);
		contentPane.add(labelMarina);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(292, 147, 758, 420);
		contentPane.add(panel);

		JLabel lblIconeUsuario = new JLabel("");
		lblIconeUsuario
				.setIcon(new ImageIcon(CrudClienteGUI.class.getResource("/br/com/tokio/images/usuario_Foto.png")));
		lblIconeUsuario.setBounds(67, 43, 70, 70);
		panel.add(lblIconeUsuario);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setForeground(new Color(0, 51, 51));
		lblTelefone.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblTelefone.setBounds(449, 136, 193, 25);
		panel.add(lblTelefone);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setForeground(new Color(0, 51, 51));
		lblCpf.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblCpf.setBounds(67, 137, 193, 25);
		panel.add(lblCpf);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setForeground(new Color(0, 51, 51));
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblEmail.setBounds(449, 213, 193, 25);
		panel.add(lblEmail);

		JLabel lblDataNasc = new JLabel("Data de nascimento:");
		lblDataNasc.setForeground(new Color(0, 51, 51));
		lblDataNasc.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblDataNasc.setBounds(67, 211, 193, 25);
		panel.add(lblDataNasc);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(new Color(0, 51, 51));
		lblNome.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblNome.setBounds(147, 54, 193, 25);
		panel.add(lblNome);

		txtNomeCliente = new JTextField();
		txtNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNomeCliente.setBounds(147, 80, 220, 33);
		panel.add(txtNomeCliente);
		txtNomeCliente.setColumns(10);

		txtCpf = new JTextField();
		txtCpf.setEditable(false);
		txtCpf.setColumns(10);
		txtCpf.setBounds(67, 160, 220, 33);
		panel.add(txtCpf);

		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(453, 159, 220, 33);
		panel.add(txtTelefone);

		txtDataNascimento = new JTextField();
		txtDataNascimento.setEditable(false);
		txtDataNascimento.setColumns(10);
		txtDataNascimento.setBounds(67, 234, 220, 33);
		panel.add(txtDataNascimento);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(449, 233, 220, 33);
		panel.add(txtEmail);

		txtGenero = new JTextField();
		txtGenero.setEditable(false);
		txtGenero.setBounds(67, 310, 220, 33);
		panel.add(txtGenero);
		txtGenero.setColumns(10);

		JLabel lblGenero = new JLabel("Gênero:");
		lblGenero.setForeground(new Color(0, 51, 51));
		lblGenero.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblGenero.setBounds(67, 290, 193, 25);
		panel.add(lblGenero);

		JButton botaoEditar = new JButton("Editar");
		botaoEditar.setForeground(new Color(255, 255, 255));
		botaoEditar.setBounds(603, 301, 70, 42);
		panel.add(botaoEditar);
		botaoEditar.setBackground(new Color(39, 153, 11));

		JButton botaoPreencher = new JButton("Preencher dados");
		botaoPreencher.setForeground(new Color(0, 51, 51));
		botaoPreencher.setBounds(439, 301, 154, 42);
		panel.add(botaoPreencher);

		JButton btnCadastrarVeiculo = new JButton("Cadastrar veículo");
		btnCadastrarVeiculo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCadastrarVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String[] options = { "Caminhão", "Carro", "Moto"};

				int veiculo = JOptionPane.showOptionDialog(null, "Selecione seu veículo:",
						"TOKIO MARINE SEGURADORA", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options,
						options[0]);

				if (veiculo == 0) {
					DadosCaminhaoGUI dadosCaminhao = new DadosCaminhaoGUI();
					dadosCaminhao.frameDadosCaminhao.setVisible(true);
					frameCliente.dispose();
				} else if (veiculo == 1) {
					DadosCarroGUI dadosCarro = new DadosCarroGUI();
					dadosCarro.frameDadosCarro.setVisible(true);
					frameCliente.dispose();
				} else {
					DadosMotoGUI dadosMoto = new DadosMotoGUI();
					dadosMoto.frameDadosMoto.setVisible(true);
					frameCliente.dispose();
				}
			}
		});
		btnCadastrarVeiculo.setForeground(new Color(0, 51, 51));
		btnCadastrarVeiculo.setBounds(502, 76, 171, 36);
		panel.add(btnCadastrarVeiculo);
		botaoPreencher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				preencherCampos();
			}
		});
		botaoEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Alterar();
			}
		});

		JLabel lblPrincipal = new JLabel("");
		lblPrincipal
				.setIcon(new ImageIcon(CrudClienteGUI.class.getResource("/br/com/tokio/images/background_redimensionado.png")));
		lblPrincipal.setBounds(0, 0, 1260, 728);
		contentPane.add(lblPrincipal);
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