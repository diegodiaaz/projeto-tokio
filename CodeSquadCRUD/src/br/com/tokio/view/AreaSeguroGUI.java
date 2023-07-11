package br.com.tokio.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AreaSeguroGUI {

	private JFrame frmTokioMarineSeguradora;
	private JTextField txtCPFCliente;
	private JTextField txtEmailCorretor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AreaSeguroGUI window = new AreaSeguroGUI();
					window.frmTokioMarineSeguradora.setVisible(true);
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
		frmTokioMarineSeguradora.setIconImage(Toolkit.getDefaultToolkit().getImage(AreaSeguroGUI.class.getResource("/br/com/tokio/images/logo_tokio.png")));
		frmTokioMarineSeguradora.setTitle("TOKIO MARINE SEGURADORA");
		frmTokioMarineSeguradora.setBounds(100, 100, 1000, 600);
		frmTokioMarineSeguradora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTokioMarineSeguradora.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 984, 561);
		frmTokioMarineSeguradora.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel labelMarinaImagem = new JLabel("");
		labelMarinaImagem.setIcon(new ImageIcon(AreaSeguroGUI.class.getResource("/br/com/tokio/images/marinonanona.png")));
		labelMarinaImagem.setBounds(55, 11, 277, 536);
		panel.add(labelMarinaImagem);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(316, 112, 592, 353);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTipoSeguro = new JLabel("Tipo Veiculo:");
		lblTipoSeguro.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblTipoSeguro.setBounds(43, 86, 193, 25);
		panel_1.add(lblTipoSeguro);
		
		JComboBox cboTipoVeiculoContrato = new JComboBox();
		cboTipoVeiculoContrato.setModel(new DefaultComboBoxModel(new String[] {"<Selecione uma opção>", "Carro", "Moto", "Caminhão"}));
		cboTipoVeiculoContrato.setBounds(43, 115, 222, 40);
		panel_1.add(cboTipoVeiculoContrato);
		
		JLabel lblCpfDoCliente = new JLabel("Digite seu CPF:");
		lblCpfDoCliente.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblCpfDoCliente.setBounds(44, 182, 193, 25);
		panel_1.add(lblCpfDoCliente);
		
		txtCPFCliente = new JTextField();
		txtCPFCliente.setBounds(44, 212, 222, 40);
		panel_1.add(txtCPFCliente);
		txtCPFCliente.setColumns(10);
		
		JLabel lblTipoVeiculo_1_1 = new JLabel("E-mail do corretor:");
		lblTipoVeiculo_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblTipoVeiculo_1_1.setBounds(326, 182, 193, 25);
		panel_1.add(lblTipoVeiculo_1_1);
		
		txtEmailCorretor = new JTextField();
		txtEmailCorretor.setColumns(10);
		txtEmailCorretor.setBounds(326, 212, 222, 40);
		panel_1.add(txtEmailCorretor);
		
		JButton btnBotaoProximaEtapa = new JButton("Próxima etapa");
		btnBotaoProximaEtapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBotaoProximaEtapa.setBounds(429, 284, 118, 43);
		panel_1.add(btnBotaoProximaEtapa);
		
		JLabel lbltxtConfirme = new JLabel("Confirme as informações abaixo:");
		lbltxtConfirme.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbltxtConfirme.setBounds(186, 35, 244, 40);
		panel_1.add(lbltxtConfirme);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AreaSeguroGUI.class.getResource("/br/com/tokio/images/fundo_login_maior.png")));
		lblNewLabel.setBounds(0, 0, 984, 561);
		panel.add(lblNewLabel);
	}
}
