package br.com.tokio.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;

public class DadosMotoGUI {

	private JFrame frameDadosMoto;
	private JTextField txtPlacaMoto;
	private JTextField txtAnoMoto;
	private JTextField txtModeloMoto;
	private JTextField txtCorMoto;
	private JTextField txtCombustivelMoto;
	private JTextField txtCepMoto;
	private JTextField txtMarcaMoto;
	private JTextField txtProprietarioMoto;
	private JTextField txtContratoMoto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DadosMotoGUI window = new DadosMotoGUI();
					window.frameDadosMoto.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DadosMotoGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameDadosMoto = new JFrame();
		frameDadosMoto.setTitle("TOKIO MARINE SEGURADORA");
		frameDadosMoto.setIconImage(Toolkit.getDefaultToolkit().getImage(DadosMotoGUI.class.getResource("/br/com/tokio/images/logo_tokio.png")));
		frameDadosMoto.setBounds(100, 100, 1000, 601);
		frameDadosMoto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameDadosMoto.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 984, 561);
		frameDadosMoto.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblAquiVocPode_1 = new JLabel("Aqui você pode adicionar a moto de um cliente!");
		lblAquiVocPode_1.setForeground(Color.WHITE);
		lblAquiVocPode_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblAquiVocPode_1.setBounds(243, 0, 663, 88);
		panel.add(lblAquiVocPode_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(DadosMotoGUI.class.getResource("/br/com/tokio/images/marinonanona.png")));
		lblNewLabel_1.setBounds(42, 77, 231, 442);
		panel.add(lblNewLabel_1);
		
		JButton btnAdicionarMoto = new JButton("Adicionar moto");
		btnAdicionarMoto.setBounds(506, 507, 146, 43);
		panel.add(btnAdicionarMoto);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(263, 88, 623, 408);
		panel.add(panel_1);
		
		JLabel lblNewLabel_2_3 = new JLabel("Modelo:");
		lblNewLabel_2_3.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_2_3.setBounds(49, 206, 193, 25);
		panel_1.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Ano:");
		lblNewLabel_2_4.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_2_4.setBounds(49, 142, 193, 25);
		panel_1.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("Tipo de combustível:");
		lblNewLabel_2_3_1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_2_3_1.setBounds(342, 142, 193, 25);
		panel_1.add(lblNewLabel_2_3_1);
		
		JLabel lblNewLabel_2_4_1 = new JLabel("Cor:");
		lblNewLabel_2_4_1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_2_4_1.setBounds(342, 75, 193, 25);
		panel_1.add(lblNewLabel_2_4_1);
		
		JLabel lblNewLabel_2_4_2 = new JLabel("Placa:");
		lblNewLabel_2_4_2.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_2_4_2.setBounds(49, 75, 193, 25);
		panel_1.add(lblNewLabel_2_4_2);
		
		txtPlacaMoto = new JTextField();
		txtPlacaMoto.setColumns(10);
		txtPlacaMoto.setBounds(49, 98, 207, 33);
		panel_1.add(txtPlacaMoto);
		
		txtAnoMoto = new JTextField();
		txtAnoMoto.setColumns(10);
		txtAnoMoto.setBounds(49, 162, 207, 33);
		panel_1.add(txtAnoMoto);
		
		txtModeloMoto = new JTextField();
		txtModeloMoto.setColumns(10);
		txtModeloMoto.setBounds(49, 226, 207, 33);
		panel_1.add(txtModeloMoto);
		
		txtCorMoto = new JTextField();
		txtCorMoto.setColumns(10);
		txtCorMoto.setBounds(342, 98, 207, 33);
		panel_1.add(txtCorMoto);
		
		txtCombustivelMoto = new JTextField();
		txtCombustivelMoto.setColumns(10);
		txtCombustivelMoto.setBounds(342, 162, 207, 33);
		panel_1.add(txtCombustivelMoto);
		
		JLabel lblInsiraOsDados = new JLabel("Insira os dados da moto abaixo:");
		lblInsiraOsDados.setForeground(Color.BLACK);
		lblInsiraOsDados.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblInsiraOsDados.setBounds(128, 11, 345, 58);
		panel_1.add(lblInsiraOsDados);
		
		JLabel lblNewLabel_2_3_2 = new JLabel("CEP per noite:");
		lblNewLabel_2_3_2.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_2_3_2.setBounds(342, 206, 193, 25);
		panel_1.add(lblNewLabel_2_3_2);
		
		txtCepMoto = new JTextField();
		txtCepMoto.setColumns(10);
		txtCepMoto.setBounds(342, 226, 207, 33);
		panel_1.add(txtCepMoto);
		
		JLabel lblNewLabel_2_3_3 = new JLabel("Marca:");
		lblNewLabel_2_3_3.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_2_3_3.setBounds(49, 267, 193, 25);
		panel_1.add(lblNewLabel_2_3_3);
		
		txtMarcaMoto = new JTextField();
		txtMarcaMoto.setColumns(10);
		txtMarcaMoto.setBounds(49, 287, 207, 33);
		panel_1.add(txtMarcaMoto);
		
		JLabel lblNewLabel_2_3_2_1 = new JLabel("Proprietário:");
		lblNewLabel_2_3_2_1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_2_3_2_1.setBounds(342, 267, 193, 25);
		panel_1.add(lblNewLabel_2_3_2_1);
		
		txtProprietarioMoto = new JTextField();
		txtProprietarioMoto.setColumns(10);
		txtProprietarioMoto.setBounds(342, 287, 207, 33);
		panel_1.add(txtProprietarioMoto);
		
		txtContratoMoto = new JTextField();
		txtContratoMoto.setColumns(10);
		txtContratoMoto.setBounds(49, 351, 207, 33);
		panel_1.add(txtContratoMoto);
		
		JLabel lblNewLabel_2_3_3_1 = new JLabel("Contrato:");
		lblNewLabel_2_3_3_1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_2_3_3_1.setBounds(49, 331, 193, 25);
		panel_1.add(lblNewLabel_2_3_3_1);
		
		JLabel labelGradiente = new JLabel("");
		labelGradiente.setBounds(0, 0, 984, 561);
		labelGradiente.setIcon(new ImageIcon(DadosMotoGUI.class.getResource("/br/com/tokio/images/fundo_login_maior.png")));
		panel.add(labelGradiente);
	}
}