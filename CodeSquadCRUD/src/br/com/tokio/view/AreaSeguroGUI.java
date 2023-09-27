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
		frmTokioMarineSeguradora.setBounds(100, 100, 1276, 675);
		frmTokioMarineSeguradora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTokioMarineSeguradora.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1259, 711);
		frmTokioMarineSeguradora.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblMarcaDAguaTokio = new JLabel("");
		lblMarcaDAguaTokio.setIcon(new ImageIcon(AreaSeguroGUI.class.getResource("/br/com/tokio/images/marca_d'agua_tokio.png")));
		lblMarcaDAguaTokio.setBounds(203, 452, 196, 78);
		panel.add(lblMarcaDAguaTokio);
		
		JLabel lbl = new JLabel("Bem vindo de volta, corretor(a)!");
		lbl.setForeground(new Color(255, 255, 255));
		lbl.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
		lbl.setBounds(447, 76, 502, 51);
		panel.add(lbl);

		JLabel labelMarinaImagem = new JLabel("");
		labelMarinaImagem
				.setIcon(new ImageIcon(AreaSeguroGUI.class.getResource("/br/com/tokio/images/marina_pensando.png")));
		labelMarinaImagem.setBounds(181, 35, 277, 536);
		panel.add(labelMarinaImagem);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(439, 138, 626, 395);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblTipoSeguro = new JLabel("Tipo veiculo do cliente:");
		lblTipoSeguro.setForeground(new Color(0, 51, 51));
		lblTipoSeguro.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblTipoSeguro.setBounds(43, 237, 193, 25);
		panel_1.add(lblTipoSeguro);

		JComboBox<String> comboTipoVeic = new JComboBox<String>();
		comboTipoVeic.setModel(new DefaultComboBoxModel<String>(
				new String[] { "<Selecione uma opção>", "Carro", "Moto", "Caminhão" }));
		comboTipoVeic.setBounds(43, 260, 222, 40);
		panel_1.add(comboTipoVeic);
		

		JLabel lblCpfDoCliente = new JLabel("Digite o CPF do cliente:");
		lblCpfDoCliente.setForeground(new Color(0, 51, 51));
		lblCpfDoCliente.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblCpfDoCliente.setBounds(43, 142, 193, 25);
		panel_1.add(lblCpfDoCliente);

		txtCPFCliente = new JTextField();
		txtCPFCliente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCPFCliente.setBounds(43, 167, 222, 40);
		panel_1.add(txtCPFCliente);
		txtCPFCliente.setColumns(10);

		JLabel lblEmail = new JLabel("Digite seu e-mail:");
		lblEmail.setForeground(new Color(0, 51, 51));
		lblEmail.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblEmail.setBounds(325, 142, 193, 25);
		panel_1.add(lblEmail);

		txtEmailCorretor = new JTextField();
		txtEmailCorretor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtEmailCorretor.setColumns(10);
		txtEmailCorretor.setBounds(325, 167, 222, 40);
		panel_1.add(txtEmailCorretor);

		JButton btnBotaoProximaEtapa = new JButton("Próxima etapa");
		btnBotaoProximaEtapa.setForeground(new Color(0, 51, 51));
		btnBotaoProximaEtapa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBotaoProximaEtapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InserirSeguro();
				AreaCorretorGUI areaCorretor = new AreaCorretorGUI();
				areaCorretor.frmT.setVisible(true);
				frmTokioMarineSeguradora.dispose();
			}
			
		});

		btnBotaoProximaEtapa.setBounds(325, 255, 222, 46);
		panel_1.add(btnBotaoProximaEtapa);

		JLabel lbltxtConfirme = new JLabel("Confirme as informações abaixo:");
		lbltxtConfirme.setForeground(new Color(0, 51, 51));
		lbltxtConfirme.setFont(new Font("Tahoma", Font.BOLD, 19));
		lbltxtConfirme.setBounds(167, 45, 336, 40);
		panel_1.add(lbltxtConfirme);

		JLabel lblFundo = new JLabel("");
		lblFundo
				.setIcon(new ImageIcon(AreaSeguroGUI.class.getResource("/br/com/tokio/images/background_redimensionado.png")));
		lblFundo.setBounds(0, -25, 1332, 784);
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
