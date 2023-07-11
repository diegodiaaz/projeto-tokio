package br.com.tokio.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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

import br.com.tokio.model.Cliente;
import br.com.tokio.repository.ClienteDAO;
import java.awt.Toolkit;

public class InsertClienteGUI {

	JFrame insertCliente;
	private JTextField txtNomeInsert;
	private JTextField txtCPFInsert;
	private JTextField txtTelefoneInsert;
	private JTextField txtDataNascimentoInsert;
	private JTextField txtEmailInsert;
	String Genero;

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

		JLabel lblMarina = new JLabel("");
		lblMarina.setIcon(new ImageIcon(InsertClienteGUI.class.getResource("/br/com/tokio/images/marinonanona.png")));
		lblMarina.setBounds(51, 66, 231, 442);
		panel.add(lblMarina);

		JLabel lblAquiVocPode = new JLabel("Aqui você pode criar um cliente!");
		lblAquiVocPode.setForeground(Color.WHITE);
		lblAquiVocPode.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblAquiVocPode.setBounds(387, 43, 421, 88);
		panel.add(lblAquiVocPode);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(307, 143, 585, 342);
		panel.add(panel_1);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblTelefone.setBounds(48, 199, 193, 25);
		panel_1.add(lblTelefone);

		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblCPF.setBounds(48, 135, 193, 25);
		panel_1.add(lblCPF);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblEmail.setBounds(341, 135, 193, 25);
		panel_1.add(lblEmail);

		JLabel lblDataNasc = new JLabel("Data de nascimento:");
		lblDataNasc.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblDataNasc.setBounds(341, 66, 193, 25);
		panel_1.add(lblDataNasc);

		JLabel lblNome = new JLabel("Nome:");
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
		lblGenero.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblGenero.setBounds(341, 199, 193, 25);
		panel_1.add(lblGenero);

		JComboBox<String> comboGenero = new JComboBox<String>();
		comboGenero.setModel(new DefaultComboBoxModel<String>(
				new String[] { "<Selecione o Gênero>", "Masculino", "Feminino", "Outros", "Prefiro não dizer" }));
		comboGenero.setBounds(341, 219, 207, 33);
		panel_1.add(comboGenero);

		JButton btnCriarCliente = new JButton("Criar cliente");
		btnCriarCliente.setForeground(new Color(255, 255, 255));
		btnCriarCliente.setBackground(new Color(58, 168, 137));
		btnCriarCliente.setBounds(424, 278, 124, 43);
		panel_1.add(btnCriarCliente);

		JLabel lblTxtInsiraClientes = new JLabel("Insira os dados do cliente:");
		lblTxtInsiraClientes.setBounds(173, -11, 275, 77);
		panel_1.add(lblTxtInsiraClientes);
		lblTxtInsiraClientes.setForeground(new Color(0, 0, 0));
		lblTxtInsiraClientes.setFont(new Font("Tahoma", Font.PLAIN, 22));

		JComboBox<String> comboTipoVeic = new JComboBox<String>();
		comboTipoVeic.setModel(
				new DefaultComboBoxModel<String>(new String[] { "<Selecione uma opção>", "Carro", "Moto", "Caminhão" }));
		comboTipoVeic.setBounds(48, 283, 207, 33);
		panel_1.add(comboTipoVeic);

		JLabel lblTipoVeic = new JLabel("Tipo Veiculo:");
		lblTipoVeic.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblTipoVeic.setBounds(48, 263, 193, 25);
		panel_1.add(lblTipoVeic);

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
				
				if(comboTipoVeic.getSelectedItem().equals("<Selecione uma opção>")) {
					JOptionPane.showMessageDialog(null, "Erro");
				} else if(comboTipoVeic.getSelectedItem().equals("Carro")) {
					DadosCarroGUI areaInsertCarro = new DadosCarroGUI();
					insertCliente.dispose();
					areaInsertCarro.frameDadosCarro.setVisible(true);
				} else if(comboTipoVeic.getSelectedItem().equals("Moto")) {
					DadosMotoGUI areaInsertMoto = new DadosMotoGUI();
					insertCliente.dispose();
					areaInsertMoto.frameDadosMoto.setVisible(true);
				} else if(comboTipoVeic.getSelectedItem().equals("Caminhão")) {
					DadosCaminhaoGUI areaInsertCaminhao = new DadosCaminhaoGUI();
					insertCliente.dispose();
					areaInsertCaminhao.frameDadosCaminhao.setVisible(true);
				}

			}
		});

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(
				new ImageIcon(InsertClienteGUI.class.getResource("/br/com/tokio/images/fundo_login_maior.png")));
		lblNewLabel.setBounds(0, 0, 984, 561);
		panel.add(lblNewLabel);

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