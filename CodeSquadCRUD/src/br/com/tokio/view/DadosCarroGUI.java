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

public class DadosCarroGUI {

	public JFrame frameDadosCarro;
	private JTextField txtPlacaCarro;
	private JTextField txtAnoCarro;
	private JTextField txtModeloCarro;
	private JTextField txtCorCarro;
	private JTextField txtCombustivelCarro;
	private JTextField txtCepCarro;
	private JTextField txtMarcaCarro;
	private JTextField txtProprietarioCarro;

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
	 */
	private void initialize() {
		frameDadosCarro = new JFrame();
		frameDadosCarro.setTitle("TOKIO MARINE SEGURADORA");
		frameDadosCarro.setIconImage(Toolkit.getDefaultToolkit().getImage(DadosCarroGUI.class.getResource("/br/com/tokio/images/logo_tokio.png")));
		frameDadosCarro.setBounds(100, 100, 1000, 601);
		frameDadosCarro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameDadosCarro.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 984, 561);
		frameDadosCarro.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblAquiVocPode_1 = new JLabel("Aqui você pode adicionar o carro de um cliente!");
		lblAquiVocPode_1.setForeground(Color.WHITE);
		lblAquiVocPode_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblAquiVocPode_1.setBounds(251, 22, 663, 88);
		panel.add(lblAquiVocPode_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(DadosCarroGUI.class.getResource("/br/com/tokio/images/marinonanona.png")));
		lblNewLabel_1.setBounds(42, 77, 231, 442);
		panel.add(lblNewLabel_1);
		
		JButton btnAdicionarCarro = new JButton("Adicionar carro");
		btnAdicionarCarro.setBounds(526, 492, 146, 43);
		panel.add(btnAdicionarCarro);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(296, 121, 585, 360);
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
		
		txtPlacaCarro = new JTextField();
		txtPlacaCarro.setColumns(10);
		txtPlacaCarro.setBounds(49, 98, 207, 33);
		panel_1.add(txtPlacaCarro);
		
		txtAnoCarro = new JTextField();
		txtAnoCarro.setColumns(10);
		txtAnoCarro.setBounds(49, 162, 207, 33);
		panel_1.add(txtAnoCarro);
		
		txtModeloCarro = new JTextField();
		txtModeloCarro.setColumns(10);
		txtModeloCarro.setBounds(49, 226, 207, 33);
		panel_1.add(txtModeloCarro);
		
		txtCorCarro = new JTextField();
		txtCorCarro.setColumns(10);
		txtCorCarro.setBounds(342, 98, 207, 33);
		panel_1.add(txtCorCarro);
		
		txtCombustivelCarro = new JTextField();
		txtCombustivelCarro.setColumns(10);
		txtCombustivelCarro.setBounds(342, 162, 207, 33);
		panel_1.add(txtCombustivelCarro);
		
		JLabel lblInsiraOsDados = new JLabel("Insira os dados do carro abaixo:");
		lblInsiraOsDados.setForeground(Color.BLACK);
		lblInsiraOsDados.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblInsiraOsDados.setBounds(109, 16, 345, 58);
		panel_1.add(lblInsiraOsDados);
		
		JLabel lblNewLabel_2_3_2 = new JLabel("CEP per noite:");
		lblNewLabel_2_3_2.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_2_3_2.setBounds(342, 206, 193, 25);
		panel_1.add(lblNewLabel_2_3_2);
		
		txtCepCarro = new JTextField();
		txtCepCarro.setColumns(10);
		txtCepCarro.setBounds(342, 226, 207, 33);
		panel_1.add(txtCepCarro);
		
		JLabel lblNewLabel_2_3_3 = new JLabel("Marca:");
		lblNewLabel_2_3_3.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_2_3_3.setBounds(49, 267, 193, 25);
		panel_1.add(lblNewLabel_2_3_3);
		
		txtMarcaCarro = new JTextField();
		txtMarcaCarro.setColumns(10);
		txtMarcaCarro.setBounds(49, 287, 207, 33);
		panel_1.add(txtMarcaCarro);
		
		JLabel lblNewLabel_2_3_2_1 = new JLabel("Proprietário:");
		lblNewLabel_2_3_2_1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_2_3_2_1.setBounds(342, 267, 193, 25);
		panel_1.add(lblNewLabel_2_3_2_1);
		
		txtProprietarioCarro = new JTextField();
		txtProprietarioCarro.setColumns(10);
		txtProprietarioCarro.setBounds(342, 287, 207, 33);
		panel_1.add(txtProprietarioCarro);
		
		JLabel labelGradiente = new JLabel("");
		labelGradiente.setBounds(0, 0, 984, 561);
		labelGradiente.setIcon(new ImageIcon(DadosCarroGUI.class.getResource("/br/com/tokio/images/fundo_login_maior.png")));
		panel.add(labelGradiente);
	}
	
	public void inserir() {
		
	}
}