package br.com.tokio.view;

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

import br.com.tokio.model.Seguro;
import br.com.tokio.repository.SeguroDAO;
import java.awt.Color;

public class AreaSeguroGUI {

	public JFrame frmTokioMarineSeguradora;
	private JTextField txtCPFCliente;
	private JTextField txtEmailCorretor;
	String tipoVeic;

	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AreaSeguroGUI areaSeguro = new AreaSeguroGUI();
					areaSeguro.frmTokioMarineSeguradora.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AreaSeguroGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTokioMarineSeguradora = new JFrame();
		frmTokioMarineSeguradora.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(AreaSeguroGUI.class.getResource("/br/com/tokio/images/logo_tokio.png")));
		frmTokioMarineSeguradora.setTitle("TOKIO MARINE SEGURADORA");
		frmTokioMarineSeguradora.setBounds(100, 100, 1000, 600);
		frmTokioMarineSeguradora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTokioMarineSeguradora.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 984, 561);
		frmTokioMarineSeguradora.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lbl = new JLabel("Bem vindo de volta, corretor(a)!");
		lbl.setForeground(new Color(255, 255, 255));
		lbl.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lbl.setBounds(404, 39, 418, 51);
		panel.add(lbl);

		JLabel labelMarinaImagem = new JLabel("");
		labelMarinaImagem
				.setIcon(new ImageIcon(AreaSeguroGUI.class.getResource("/br/com/tokio/images/marina_InsertCliente.png")));
		labelMarinaImagem.setBounds(55, 11, 277, 536);
		panel.add(labelMarinaImagem);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(316, 112, 592, 353);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblTipoSeguro = new JLabel("Tipo veiculo do cliente:");
		lblTipoSeguro.setForeground(new Color(0, 51, 51));
		lblTipoSeguro.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblTipoSeguro.setBounds(43, 86, 193, 25);
		panel_1.add(lblTipoSeguro);

		JComboBox<String> comboTipoVeic = new JComboBox<String>();
		comboTipoVeic.setModel(new DefaultComboBoxModel<String>(
				new String[] { "<Selecione uma opção>", "Carro", "Moto", "Caminhão" }));
		comboTipoVeic.setBounds(43, 115, 222, 40);
		panel_1.add(comboTipoVeic);
		

		JLabel lblCpfDoCliente = new JLabel("Digite o CPF do cliente:");
		lblCpfDoCliente.setForeground(new Color(0, 51, 51));
		lblCpfDoCliente.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblCpfDoCliente.setBounds(44, 182, 193, 25);
		panel_1.add(lblCpfDoCliente);

		txtCPFCliente = new JTextField();
		txtCPFCliente.setBounds(44, 212, 222, 40);
		panel_1.add(txtCPFCliente);
		txtCPFCliente.setColumns(10);

		JLabel lblEmail = new JLabel("Digite seu e-mail:");
		lblEmail.setForeground(new Color(0, 51, 51));
		lblEmail.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblEmail.setBounds(326, 182, 193, 25);
		panel_1.add(lblEmail);

		txtEmailCorretor = new JTextField();
		txtEmailCorretor.setColumns(10);
		txtEmailCorretor.setBounds(326, 212, 222, 40);
		panel_1.add(txtEmailCorretor);

		JButton btnBotaoProximaEtapa = new JButton("Próxima etapa");
		btnBotaoProximaEtapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InserirSeguro();
				AreaCorretorGUI areaCorretor = new AreaCorretorGUI();
				areaCorretor.frmT.setVisible(true);
				frmTokioMarineSeguradora.dispose();
			}
			
		});

		btnBotaoProximaEtapa.setBounds(429, 284, 118, 43);
		panel_1.add(btnBotaoProximaEtapa);

		JLabel lbltxtConfirme = new JLabel("Confirme as informações abaixo:");
		lbltxtConfirme.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbltxtConfirme.setBounds(186, 35, 244, 40);
		panel_1.add(lbltxtConfirme);

		JLabel lblFundo = new JLabel("");
		lblFundo
				.setIcon(new ImageIcon(AreaSeguroGUI.class.getResource("/br/com/tokio/images/fundo_login_maior.png")));
		lblFundo.setBounds(0, 0, 994, 561);
		panel.add(lblFundo);
	}
	
	public void InserirSeguro() {
		SeguroDAO seguroDao = new SeguroDAO();
		Seguro seguro = new Seguro();
		
		seguro.setCpfCliente(txtCPFCliente.getText());
		seguro.setEmailCorretor(txtEmailCorretor.getText());
		seguro.setTipoSeguro(tipoVeic);
	
		seguroDao.insertCadastroSeguro(seguro);
		
		

	}
}
