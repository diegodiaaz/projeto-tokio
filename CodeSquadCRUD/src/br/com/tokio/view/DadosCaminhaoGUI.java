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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DadosCaminhaoGUI {

	public JFrame frameDadosCaminhao;
	private JTextField txtPlacaCaminhao;
	private JTextField txtAnoCaminhao;
	private JTextField txtModeloCaminhao;
	private JTextField txtPorteCaminhao;
	private JTextField txtCombustivelCaminhao;
	private JTextField txtCepCaminhao;
	private JTextField txtMarcaCaminhao;
	private JTextField txtProprietarioCaminhao;
	private JTextField txtCorCaminhao;
	private JTextField txtIdCaminhao;
	private JTextField txtContratoCaminhao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DadosCaminhaoGUI window = new DadosCaminhaoGUI();
					window.frameDadosCaminhao.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DadosCaminhaoGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameDadosCaminhao = new JFrame();
		frameDadosCaminhao.setTitle("TOKIO MARINE SEGURADORA");
		frameDadosCaminhao.setIconImage(Toolkit.getDefaultToolkit().getImage(DadosCaminhaoGUI.class.getResource("/br/com/tokio/images/logo_tokio.png")));
		frameDadosCaminhao.setBounds(100, 100, 1000, 601);
		frameDadosCaminhao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameDadosCaminhao.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 984, 561);
		frameDadosCaminhao.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnVoltar = new JButton("");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrudClienteGUI telaCliente = new CrudClienteGUI();
				telaCliente.newscreen(null);
			}
		});
		btnVoltar.setIcon(new ImageIcon(DadosCaminhaoGUI.class.getResource("/br/com/tokio/images/botao_voltar.png")));
		btnVoltar.setBounds(10, 11, 46, 23);
		panel.add(btnVoltar);
		
		JLabel lblAquiVocPode_1 = new JLabel("Aqui você pode adicionar o caminão de um cliente!");
		lblAquiVocPode_1.setForeground(Color.WHITE);
		lblAquiVocPode_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblAquiVocPode_1.setBounds(175, 0, 716, 88);
		panel.add(lblAquiVocPode_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(DadosCaminhaoGUI.class.getResource("/br/com/tokio/images/marinonanona.png")));
		lblNewLabel_1.setBounds(0, 77, 231, 442);
		panel.add(lblNewLabel_1);
		
		JButton btnAdicionarMoto = new JButton("Adicionar caminhão");
		btnAdicionarMoto.setBounds(845, 493, 129, 43);
		panel.add(btnAdicionarMoto);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(206, 77, 611, 459);
		panel.add(panel_1);
		
		JLabel lblNewLabel_2_3 = new JLabel("Modelo:");
		lblNewLabel_2_3.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_2_3.setBounds(53, 259, 193, 25);
		panel_1.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Ano:");
		lblNewLabel_2_4.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_2_4.setBounds(53, 195, 193, 25);
		panel_1.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("Tipo de combustível:");
		lblNewLabel_2_3_1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_2_3_1.setBounds(344, 60, 193, 25);
		panel_1.add(lblNewLabel_2_3_1);
		
		JLabel lblNewLabel_2_4_1 = new JLabel("Porte:");
		lblNewLabel_2_4_1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_2_4_1.setBounds(344, 250, 193, 25);
		panel_1.add(lblNewLabel_2_4_1);
		
		JLabel lblNewLabel_2_4_2 = new JLabel("Placa:");
		lblNewLabel_2_4_2.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_2_4_2.setBounds(53, 128, 193, 25);
		panel_1.add(lblNewLabel_2_4_2);
		
		txtPlacaCaminhao = new JTextField();
		txtPlacaCaminhao.setColumns(10);
		txtPlacaCaminhao.setBounds(53, 151, 207, 33);
		panel_1.add(txtPlacaCaminhao);
		
		txtAnoCaminhao = new JTextField();
		txtAnoCaminhao.setColumns(10);
		txtAnoCaminhao.setBounds(53, 215, 207, 33);
		panel_1.add(txtAnoCaminhao);
		
		txtModeloCaminhao = new JTextField();
		txtModeloCaminhao.setColumns(10);
		txtModeloCaminhao.setBounds(53, 279, 207, 33);
		panel_1.add(txtModeloCaminhao);
		
		txtPorteCaminhao = new JTextField();
		txtPorteCaminhao.setColumns(10);
		txtPorteCaminhao.setBounds(344, 273, 207, 33);
		panel_1.add(txtPorteCaminhao);
		
		txtCombustivelCaminhao = new JTextField();
		txtCombustivelCaminhao.setColumns(10);
		txtCombustivelCaminhao.setBounds(344, 80, 207, 33);
		panel_1.add(txtCombustivelCaminhao);
		
		JLabel lblInsiraOsDados = new JLabel("Insira os dados do caminhão abaixo:");
		lblInsiraOsDados.setForeground(Color.BLACK);
		lblInsiraOsDados.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblInsiraOsDados.setBounds(87, 11, 419, 49);
		panel_1.add(lblInsiraOsDados);
		
		JLabel lblNewLabel_2_3_2 = new JLabel("CEP per noite:");
		lblNewLabel_2_3_2.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_2_3_2.setBounds(344, 124, 193, 25);
		panel_1.add(lblNewLabel_2_3_2);
		
		txtCepCaminhao = new JTextField();
		txtCepCaminhao.setColumns(10);
		txtCepCaminhao.setBounds(344, 144, 207, 33);
		panel_1.add(txtCepCaminhao);
		
		JLabel lblNewLabel_2_3_3 = new JLabel("Marca:");
		lblNewLabel_2_3_3.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_2_3_3.setBounds(53, 320, 193, 25);
		panel_1.add(lblNewLabel_2_3_3);
		
		txtMarcaCaminhao = new JTextField();
		txtMarcaCaminhao.setColumns(10);
		txtMarcaCaminhao.setBounds(53, 340, 207, 33);
		panel_1.add(txtMarcaCaminhao);
		
		JLabel lblNewLabel_2_3_2_1 = new JLabel("Proprietário:");
		lblNewLabel_2_3_2_1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_2_3_2_1.setBounds(344, 185, 193, 25);
		panel_1.add(lblNewLabel_2_3_2_1);
		
		txtProprietarioCaminhao = new JTextField();
		txtProprietarioCaminhao.setColumns(10);
		txtProprietarioCaminhao.setBounds(344, 205, 207, 33);
		panel_1.add(txtProprietarioCaminhao);
		
		txtCorCaminhao = new JTextField();
		txtCorCaminhao.setColumns(10);
		txtCorCaminhao.setBounds(53, 404, 207, 33);
		panel_1.add(txtCorCaminhao);
		
		JLabel lblNewLabel_2_3_3_1 = new JLabel("Cor:");
		lblNewLabel_2_3_3_1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_2_3_3_1.setBounds(53, 384, 193, 25);
		panel_1.add(lblNewLabel_2_3_3_1);
		
		JLabel lblNewLabel_2_4_1_1 = new JLabel("Id:");
		lblNewLabel_2_4_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_2_4_1_1.setBounds(53, 60, 193, 25);
		panel_1.add(lblNewLabel_2_4_1_1);
		
		txtIdCaminhao = new JTextField();
		txtIdCaminhao.setColumns(10);
		txtIdCaminhao.setBounds(53, 83, 207, 33);
		panel_1.add(txtIdCaminhao);
		
		JLabel lblNewLabel_2_4_1_2 = new JLabel("Contrato:");
		lblNewLabel_2_4_1_2.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_2_4_1_2.setBounds(344, 317, 193, 25);
		panel_1.add(lblNewLabel_2_4_1_2);
		
		txtContratoCaminhao = new JTextField();
		txtContratoCaminhao.setColumns(10);
		txtContratoCaminhao.setBounds(344, 340, 207, 33);
		panel_1.add(txtContratoCaminhao);
		
		JLabel labelGradiente = new JLabel("");
		labelGradiente.setBounds(0, 0, 984, 561);
		labelGradiente.setIcon(new ImageIcon(DadosCaminhaoGUI.class.getResource("/br/com/tokio/images/fundo_login_maior.png")));
		panel.add(labelGradiente);
	}
}