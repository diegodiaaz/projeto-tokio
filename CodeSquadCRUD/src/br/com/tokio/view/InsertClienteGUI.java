package br.com.tokio.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.tokio.model.Chatbot;
import br.com.tokio.model.Cliente;
import br.com.tokio.repository.ClienteDAO;

public class InsertClienteGUI {

	public JFrame insertCliente;
	private JTextField txtNomeInsert;
	private JTextField txtCPFInsert;
	private JTextField txtTelefoneInsert;
	private JTextField txtDataNascimentoInsert;
	private JTextField txtEmailInsert;
	String Genero;
	String tipoVeic;

	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertClienteGUI insertCliente = new InsertClienteGUI();
					insertCliente.insertCliente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InsertClienteGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		insertCliente = new JFrame();
		insertCliente.setTitle("TOKIO MARINE SEGURADORA");
		insertCliente.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(InsertClienteGUI.class.getResource("/br/com/tokio/images/logo_tokio.png")));
		insertCliente.setBounds(100, 100, 1276, 675);
		insertCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		insertCliente.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1401, 636);
		insertCliente.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblMarcaDAguaTokio = new JLabel("");
		lblMarcaDAguaTokio.setIcon(
				new ImageIcon(InsertClienteGUI.class.getResource("/br/com/tokio/images/marca_d'agua_tokio.png")));
		lblMarcaDAguaTokio.setBounds(70, 473, 233, 62);
		panel.add(lblMarcaDAguaTokio);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(
				new ImageIcon(InsertClienteGUI.class.getResource("/br/com/tokio/images/marina_pensando.png")));
		lblNewLabel.setBounds(44, 170, 271, 315);
		panel.add(lblNewLabel);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(
				new ImageIcon(InsertClienteGUI.class.getResource("/br/com/tokio/images/CodeSquadLogo.png")));
		lblLogo.setBounds(1082, 454, 216, 171);
		panel.add(lblLogo);

		JLabel labelLogo = new JLabel("");
		labelLogo.setBounds(911, 487, 63, 63);
		panel.add(labelLogo);

		JLabel lblAquiVocPode = new JLabel("Certo! Aqui você pode prosseguir com o seu cadastro!");
		lblAquiVocPode.setForeground(Color.WHITE);
		lblAquiVocPode.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblAquiVocPode.setBounds(320, 54, 688, 88);
		panel.add(lblAquiVocPode);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(307, 143, 668, 392);
		panel.add(panel_1);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setForeground(new Color(0, 51, 51));
		lblTelefone.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblTelefone.setBounds(48, 209, 193, 25);
		panel_1.add(lblTelefone);

		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setForeground(new Color(0, 51, 51));
		lblCPF.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblCPF.setBounds(48, 135, 193, 25);
		panel_1.add(lblCPF);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setForeground(new Color(0, 51, 51));
		lblEmail.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblEmail.setBounds(341, 135, 193, 25);
		panel_1.add(lblEmail);

		JLabel lblDataNasc = new JLabel("Data de nascimento:");
		lblDataNasc.setForeground(new Color(0, 51, 51));
		lblDataNasc.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblDataNasc.setBounds(341, 66, 193, 25);
		panel_1.add(lblDataNasc);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(new Color(0, 51, 51));
		lblNome.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNome.setBounds(48, 66, 193, 25);
		panel_1.add(lblNome);

		txtNomeInsert = new JTextField();
		txtNomeInsert.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNomeInsert.setColumns(10);
		txtNomeInsert.setBounds(48, 89, 241, 41);
		panel_1.add(txtNomeInsert);

		txtCPFInsert = new JTextField();
		txtCPFInsert.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCPFInsert.setColumns(10);
		txtCPFInsert.setBounds(48, 155, 241, 41);
		panel_1.add(txtCPFInsert);

		txtTelefoneInsert = new JTextField();
		txtTelefoneInsert.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTelefoneInsert.setColumns(10);
		txtTelefoneInsert.setBounds(48, 229, 241, 41);
		panel_1.add(txtTelefoneInsert);

		txtDataNascimentoInsert = new JTextField();
		txtDataNascimentoInsert.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtDataNascimentoInsert.setColumns(10);
		txtDataNascimentoInsert.setBounds(341, 89, 241, 41);
		panel_1.add(txtDataNascimentoInsert);

		txtEmailInsert = new JTextField();
		txtEmailInsert.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtEmailInsert.setColumns(10);
		txtEmailInsert.setBounds(341, 155, 243, 41);
		panel_1.add(txtEmailInsert);

		JLabel lblGenero = new JLabel("Genero:");
		lblGenero.setForeground(new Color(0, 51, 51));
		lblGenero.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblGenero.setBounds(339, 209, 193, 25);
		panel_1.add(lblGenero);

		JComboBox<String> comboGenero = new JComboBox<String>();
		comboGenero.setModel(new DefaultComboBoxModel<String>(
				new String[] { "<Selecione o Gênero>", "Masculino", "Feminino", "Outros", "Prefiro não dizer" }));
		comboGenero.setBounds(339, 229, 243, 41);
		panel_1.add(comboGenero);

		JButton btnCriarCliente = new JButton("Criar conta");
		btnCriarCliente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCriarCliente.setForeground(new Color(255, 255, 255));
		btnCriarCliente.setBackground(new Color(39, 153, 11));
		btnCriarCliente.setBounds(430, 299, 154, 41);
		panel_1.add(btnCriarCliente);

		JLabel lblTxtInsiraClientes = new JLabel("Informe seus dados:");
		lblTxtInsiraClientes.setBounds(222, 0, 275, 77);
		panel_1.add(lblTxtInsiraClientes);
		lblTxtInsiraClientes.setForeground(new Color(0, 51, 51));
		lblTxtInsiraClientes.setFont(new Font("Tahoma", Font.PLAIN, 21));

		JButton btnJaSouCliente = new JButton("Ja tenho cadastro");
		btnJaSouCliente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnJaSouCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChatbotGUI chatBot = new ChatbotGUI();
				chatBot.newScreen();
				insertCliente.dispose();
			}
		});
		btnJaSouCliente.setForeground(new Color(0, 0, 0));
		btnJaSouCliente.setBackground(new Color(208, 196, 100));
		btnJaSouCliente.setBounds(48, 299, 154, 41);
		panel_1.add(btnJaSouCliente);

		btnCriarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboGenero.getSelectedItem().equals("<Selecione o Gênero>")) {
					JOptionPane.showMessageDialog(null, "Selecione uma opção valida");
				} else if (comboGenero.getSelectedItem().equals("Masculino")) {
					Genero = "Masculino";
				} else if (comboGenero.getSelectedItem().equals("Feminino")) {
					Genero = "Feminino";
				} else if (comboGenero.getSelectedItem().equals("Outros")) {
					Genero = "Outros";
				} else if (comboGenero.getSelectedItem().equals("Prefiro não dizer")) {
					Genero = "Prefiro não dizer";
				}
				Inserir();
				ChatbotGUI chatBot = new ChatbotGUI();
				chatBot.newScreen();
				insertCliente.dispose();
				;
			}
		});

		JLabel lblFundoImagem = new JLabel("");
		lblFundoImagem.setIcon(
				new ImageIcon(InsertClienteGUI.class.getResource("/br/com/tokio/images/background_redimensionado.png")));
		lblFundoImagem.setBounds(0, 0, 1265, 636);
		panel.add(lblFundoImagem);

	}

	public void Inserir() {
		ClienteDAO clienteDao = new ClienteDAO();
		Cliente cliente = new Cliente();
		Date data;
		data = new Date(System.currentTimeMillis());
		cliente.setNomeCliente(txtNomeInsert.getText());
		cliente.setCpfCliente(txtCPFInsert.getText());
		cliente.setTelefoneCliente(txtTelefoneInsert.getText());
		cliente.setDataNascimento(txtDataNascimentoInsert.getText());
		cliente.setEmailCliente(txtEmailInsert.getText());
		cliente.setGeneroCliente(Genero);
		cliente.setDataCadastro(data);
		clienteDao.insertCadastroCliente(cliente);

	}
}