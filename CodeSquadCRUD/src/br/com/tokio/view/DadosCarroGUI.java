package br.com.tokio.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.tokio.controllers.CrudController;
import br.com.tokio.controllers.PdfController;
import br.com.tokio.model.Carro;
import br.com.tokio.repository.CarroDAO;

public class DadosCarroGUI {

	public JFrame frameDadosCarro;
	PdfController pdf = new PdfController();
	private JTextField txtPlacaCarro;
	private JTextField txtAnoCarro;
	private JTextField txtModeloCarro;
	private JTextField txtCorCarro;
	private JTextField txtCombustivelCarro;
	private JTextField txtCepCarro;
	private JTextField txtMarcaCarro;
	private JLabel lblTextCpfCli;

	String cpfCliente;
	private JTextField txtCodigoContrato;
	String tipoVeic;

	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DadosCarroGUI dadosCarroGUI = new DadosCarroGUI();
					dadosCarroGUI.frameDadosCarro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DadosCarroGUI() {
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 * 
	 */
	
	public void importarCpf(CrudController controller) {
		lblTextCpfCli.setText(controller.getCPF());
	}
	
	private void initialize() {
		frameDadosCarro = new JFrame();
		frameDadosCarro.setTitle("TOKIO MARINE SEGURADORA");
		frameDadosCarro.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(DadosCarroGUI.class.getResource("/br/com/tokio/images/logo_tokio.png")));
		frameDadosCarro.setBounds(100, 100, 1000, 601);
		frameDadosCarro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameDadosCarro.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 984, 561);
		frameDadosCarro.getContentPane().add(panel);
		panel.setLayout(null);

		JButton botaoVoltar = new JButton("");
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameDadosCarro.dispose();
				CrudClienteGUI telaCrud = new CrudClienteGUI();
				telaCrud.frameCliente.setVisible(true);
			}
		});
		botaoVoltar.setIcon(new ImageIcon(DadosCarroGUI.class.getResource("/br/com/tokio/images/botao_voltar.png")));
		botaoVoltar.setBounds(10, 11, 47, 30);
		panel.add(botaoVoltar);

		JLabel lblAquiVocPode_1 = new JLabel("Insira os dados do carro abaixo:");
		lblAquiVocPode_1.setForeground(Color.WHITE);
		lblAquiVocPode_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblAquiVocPode_1.setBounds(369, 11, 663, 88);
		panel.add(lblAquiVocPode_1);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(DadosCarroGUI.class.getResource("/br/com/tokio/images/marinonanona.png")));
		lblNewLabel_1.setBounds(42, 77, 231, 442);
		panel.add(lblNewLabel_1);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(295, 87, 585, 429);
		panel.add(panel_1);
		
		lblTextCpfCli = new JLabel("");
		lblTextCpfCli.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblTextCpfCli .setBounds(48, 31, 253, 33);
		panel_1.add(lblTextCpfCli);

		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblModelo.setBounds(48, 209, 193, 25);
		panel_1.add(lblModelo);

		JLabel lblAno = new JLabel("Ano:");
		lblAno.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblAno.setBounds(48, 142, 193, 25);
		panel_1.add(lblAno);

		JLabel lblTpComb = new JLabel("Tipo de combustível:");
		lblTpComb.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblTpComb.setBounds(341, 209, 193, 25);
		panel_1.add(lblTpComb);

		JLabel lblCor = new JLabel("Cor:");
		lblCor.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblCor.setBounds(341, 142, 193, 25);
		panel_1.add(lblCor);

		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblPlaca.setBounds(48, 75, 193, 25);
		panel_1.add(lblPlaca);

		txtPlacaCarro = new JTextField();
		txtPlacaCarro.setColumns(10);
		txtPlacaCarro.setBounds(48, 98, 207, 33);
		panel_1.add(txtPlacaCarro);

		txtAnoCarro = new JTextField();
		txtAnoCarro.setColumns(10);
		txtAnoCarro.setBounds(48, 162, 207, 33);
		panel_1.add(txtAnoCarro);

		txtModeloCarro = new JTextField();
		txtModeloCarro.setColumns(10);
		txtModeloCarro.setBounds(48, 229, 207, 33);
		panel_1.add(txtModeloCarro);

		txtCorCarro = new JTextField();
		txtCorCarro.setColumns(10);
		txtCorCarro.setBounds(341, 165, 207, 33);
		panel_1.add(txtCorCarro);

		txtCombustivelCarro = new JTextField();
		txtCombustivelCarro.setColumns(10);
		txtCombustivelCarro.setBounds(341, 229, 207, 33);
		panel_1.add(txtCombustivelCarro);

		JLabel lblCEP = new JLabel("CEP per noite:");
		lblCEP.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblCEP.setBounds(341, 273, 193, 25);
		panel_1.add(lblCEP);

		txtCepCarro = new JTextField();
		txtCepCarro.setColumns(10);
		txtCepCarro.setBounds(341, 293, 207, 33);
		panel_1.add(txtCepCarro);

		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblMarca.setBounds(48, 273, 193, 25);
		panel_1.add(lblMarca);

		txtMarcaCarro = new JTextField();
		txtMarcaCarro.setColumns(10);
		txtMarcaCarro.setBounds(48, 293, 207, 33);
		panel_1.add(txtMarcaCarro);

		JLabel lblUsoVeic = new JLabel("Uso Veiculo:");
		lblUsoVeic.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblUsoVeic.setBounds(48, 337, 193, 25);
		panel_1.add(lblUsoVeic);

		txtCodigoContrato = new JTextField();
		txtCodigoContrato.setColumns(10);
		txtCodigoContrato.setBounds(341, 98, 207, 33);
		panel_1.add(txtCodigoContrato);

		JLabel lblCodigoContrato = new JLabel("Codigo Contrato:");
		lblCodigoContrato.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblCodigoContrato.setBounds(341, 75, 193, 25);
		panel_1.add(lblCodigoContrato);

		JComboBox<String> comboUsoVeic = new JComboBox<String>();
		comboUsoVeic.setBounds(48, 363, 207, 33);
		panel_1.add(comboUsoVeic);
		comboUsoVeic.setModel(new DefaultComboBoxModel<String>(
				new String[] { "<Selecione uma das opções>", "Pessoal", "Empresarial" }));

		JButton btnAdicionarCarro = new JButton("Adicionar carro");
		btnAdicionarCarro.setBackground(new Color(39, 153, 11));
		btnAdicionarCarro.setBounds(376, 354, 158, 50);
		panel_1.add(btnAdicionarCarro);
		
		JLabel lblCpfCli = new JLabel("Cliente: ");
		lblCpfCli.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		lblCpfCli.setBounds(49, 11, 81, 25);
		panel_1.add(lblCpfCli);
		
		
		btnAdicionarCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboUsoVeic.getSelectedItem().equals("<Selecione uma das opções>")) {
					JOptionPane.showMessageDialog(null, "Selecione uma opção valida");
				} else if (comboUsoVeic.getSelectedItem().equals("Pessoal")) {
					tipoVeic = "Pessoal";
					InserirCarro();
					
					pdf.construirPdf(lblCpfCli, lblCodigoContrato);
					
					JOptionPane.showMessageDialog(null, "Veiculo cadastrado");
				} else if (comboUsoVeic.getSelectedItem().equals("Empresarial")) {
					tipoVeic = "Empresarial";
					JOptionPane.showMessageDialog(null, "Veiculo cadastrado");
					InserirCarro();
				}
				frameDadosCarro.dispose();
				CrudClienteGUI telaCliente = new CrudClienteGUI();
				telaCliente.frameCliente.setVisible(true);

			}
		});

		JLabel labelGradiente = new JLabel("");
		labelGradiente.setBounds(0, 0, 984, 561);
		labelGradiente
				.setIcon(new ImageIcon(DadosCarroGUI.class.getResource("/br/com/tokio/images/fundo_login_maior.png")));
		panel.add(labelGradiente);
	}
	
	

	public JLabel getLblCpfCliente() {
		return lblTextCpfCli;
	}

	public void setLblCpfCliente(JLabel txtCpfCliente) {
		this.lblTextCpfCli = txtCpfCliente;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public void InserirCarro() {
		String anoCarro = txtAnoCarro.getText();
		int anoCarroI = Integer.parseInt(anoCarro);

		CarroDAO carroDao = new CarroDAO();
		Carro carro = new Carro();
		carro.setCepPernoiteCarro(txtCepCarro.getText());
		carro.setCorCarro(txtCorCarro.getText());
		carro.setAnoCarro(anoCarroI);
		carro.setTipoCombustivelCarro(txtCombustivelCarro.getText());
		carro.setMarcaCarro(txtMarcaCarro.getText());
		carro.setModeloCarro(txtModeloCarro.getText());
		carro.setPlacaCarro(txtPlacaCarro.getText());
		carro.setProprietarioCarro(tipoVeic);
		carro.setCodigoContrato(txtCodigoContrato.getText());
		carroDao.insertCadastroCarro(carro);

	}
}