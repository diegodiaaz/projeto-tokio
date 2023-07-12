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
		insertCliente.setBounds(100, 100, 1000, 600);
		insertCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		insertCliente.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 984, 561);
		insertCliente.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblMarcaDAguaTokio = new JLabel("");
		lblMarcaDAguaTokio.setIcon(
				new ImageIcon(InsertClienteGUI.class.getResource("/br/com/tokio/images/marca_d'agua_tokio.png")));
		lblMarcaDAguaTokio.setBounds(54, 428, 233, 62);
		panel.add(lblMarcaDAguaTokio);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(
				new ImageIcon(InsertClienteGUI.class.getResource("/br/com/tokio/images/marina_InsertCliente.png")));
		lblNewLabel.setBounds(25, 126, 271, 315);
		panel.add(lblNewLabel);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(
				new ImageIcon(InsertClienteGUI.class.getResource("/br/com/tokio/images/logo_codesquad_pequena.png")));
		lblLogo.setBounds(911, 484, 104, 77);
		panel.add(lblLogo);

		JLabel labelLogo = new JLabel("");
		labelLogo.setBounds(911, 487, 63, 63);
		panel.add(labelLogo);

		JLabel lblAquiVocPode = new JLabel("Certo! Aqui você pode prosseguir com o seu cadastro!");
		lblAquiVocPode.setForeground(Color.WHITE);
		lblAquiVocPode.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblAquiVocPode.setBounds(286, 55, 688, 88);
		panel.add(lblAquiVocPode);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(307, 143, 585, 342);
		panel.add(panel_1);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setForeground(new Color(0, 51, 51));
		lblTelefone.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblTelefone.setBounds(48, 199, 193, 25);
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
		txtNomeInsert.setColumns(10);
		txtNomeInsert.setBounds(48, 89, 207, 33);
		panel_1.add(txtNomeInsert);

		txtCPFInsert = new JTextField();
		txtCPFInsert.setColumns(10);
		txtCPFInsert.setBounds(48, 155, 207, 33);
		panel_1.add(txtCPFInsert);

		txtTelefoneInsert = new JTextField();
		txtTelefoneInsert.setColumns(10);
		txtTelefoneInsert.setBounds(48, 219, 207, 33);
		panel_1.add(txtTelefoneInsert);

		txtDataNascimentoInsert = new JTextField();
		txtDataNascimentoInsert.setColumns(10);
		txtDataNascimentoInsert.setBounds(341, 89, 207, 33);
		panel_1.add(txtDataNascimentoInsert);

		txtEmailInsert = new JTextField();
		txtEmailInsert.setColumns(10);
		txtEmailInsert.setBounds(341, 155, 207, 33);
		panel_1.add(txtEmailInsert);

		JLabel lblGenero = new JLabel("Genero:");
		lblGenero.setForeground(new Color(0, 51, 51));
		lblGenero.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblGenero.setBounds(341, 199, 193, 25);
		panel_1.add(lblGenero);

		JComboBox<String> comboGenero = new JComboBox<String>();
		comboGenero.setModel(new DefaultComboBoxModel<String>(
				new String[] { "<Selecione o Gênero>", "Masculino", "Feminino", "Outros", "Prefiro não dizer" }));
		comboGenero.setBounds(341, 219, 207, 33);
		panel_1.add(comboGenero);

		JButton btnCriarCliente = new JButton("Criar conta");
		btnCriarCliente.setForeground(new Color(255, 255, 255));
		btnCriarCliente.setBackground(new Color(39, 153, 11));
		btnCriarCliente.setBounds(418, 288, 130, 33);
		panel_1.add(btnCriarCliente);

		JLabel lblTxtInsiraClientes = new JLabel("Informe seus dados:");
		lblTxtInsiraClientes.setBounds(189, 0, 275, 77);
		panel_1.add(lblTxtInsiraClientes);
		lblTxtInsiraClientes.setForeground(new Color(0, 51, 51));
		lblTxtInsiraClientes.setFont(new Font("Tahoma", Font.PLAIN, 21));

		JButton btnJaSouCliente = new JButton("Ja tenho cadastro");
		btnJaSouCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChatbotGUI chatBot = new ChatbotGUI();
				chatBot.newScreen();
				insertCliente.dispose();
			}
		});
		btnJaSouCliente.setForeground(new Color(0, 0, 0));
		btnJaSouCliente.setBackground(new Color(208, 196, 100));
		btnJaSouCliente.setBounds(48, 288, 147, 33);
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
				new ImageIcon(InsertClienteGUI.class.getResource("/br/com/tokio/images/fundo_login_maior.png")));
		lblFundoImagem.setBounds(0, 0, 984, 561);
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