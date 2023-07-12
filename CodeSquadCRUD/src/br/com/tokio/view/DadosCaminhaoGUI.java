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
				CrudClienteGUI telaCrud = new CrudClienteGUI();
				telaCrud.frameCliente.setVisible(true);		
				frameDadosCaminhao.dispose();
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(206, 77, 611, 459);
		panel.add(panel_1);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblModelo.setBounds(44, 195, 193, 25);
		panel_1.add(lblModelo);
		
		JLabel lblAno = new JLabel("Ano:");
		lblAno.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblAno.setBounds(44, 131, 193, 25);
		panel_1.add(lblAno);
		
		JLabel lblTipoComb = new JLabel("Tipo de combustível:");
		lblTipoComb.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblTipoComb.setBounds(344, 60, 193, 25);
		panel_1.add(lblTipoComb);
		
		JLabel lblPorte = new JLabel("Porte:");
		lblPorte.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblPorte.setBounds(344, 250, 193, 25);
		panel_1.add(lblPorte);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblPlaca.setBounds(44, 64, 193, 25);
		panel_1.add(lblPlaca);
		
		txtPlacaCaminhao = new JTextField();
		txtPlacaCaminhao.setColumns(10);
		txtPlacaCaminhao.setBounds(44, 87, 207, 33);
		panel_1.add(txtPlacaCaminhao);
		
		txtAnoCaminhao = new JTextField();
		txtAnoCaminhao.setColumns(10);
		txtAnoCaminhao.setBounds(44, 151, 207, 33);
		panel_1.add(txtAnoCaminhao);
		
		txtModeloCaminhao = new JTextField();
		txtModeloCaminhao.setColumns(10);
		txtModeloCaminhao.setBounds(44, 215, 207, 33);
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
		
		JLabel lblCEP = new JLabel("CEP per noite:");
		lblCEP.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblCEP.setBounds(344, 124, 193, 25);
		panel_1.add(lblCEP);
		
		txtCepCaminhao = new JTextField();
		txtCepCaminhao.setColumns(10);
		txtCepCaminhao.setBounds(344, 144, 207, 33);
		panel_1.add(txtCepCaminhao);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblMarca.setBounds(44, 256, 193, 25);
		panel_1.add(lblMarca);
		
		txtMarcaCaminhao = new JTextField();
		txtMarcaCaminhao.setColumns(10);
		txtMarcaCaminhao.setBounds(44, 276, 207, 33);
		panel_1.add(txtMarcaCaminhao);
		
		JLabel lblProprietario = new JLabel("Proprietário:");
		lblProprietario.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblProprietario.setBounds(344, 185, 193, 25);
		panel_1.add(lblProprietario);
		
		txtProprietarioCaminhao = new JTextField();
		txtProprietarioCaminhao.setColumns(10);
		txtProprietarioCaminhao.setBounds(344, 205, 207, 33);
		panel_1.add(txtProprietarioCaminhao);
		
		txtCorCaminhao = new JTextField();
		txtCorCaminhao.setColumns(10);
		txtCorCaminhao.setBounds(44, 340, 207, 33);
		panel_1.add(txtCorCaminhao);
		
		JLabel lblCor = new JLabel("Cor:");
		lblCor.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblCor.setBounds(44, 320, 193, 25);
		panel_1.add(lblCor);
		
		JLabel lblContrato = new JLabel("Contrato:");
		lblContrato.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblContrato.setBounds(344, 317, 193, 25);
		panel_1.add(lblContrato);
		
		txtContratoCaminhao = new JTextField();
		txtContratoCaminhao.setColumns(10);
		txtContratoCaminhao.setBounds(344, 340, 207, 33);
		panel_1.add(txtContratoCaminhao);
		
		JButton btnAdicionarMoto = new JButton("Adicionar caminhão");
		btnAdicionarMoto.setBounds(422, 384, 129, 43);
		panel_1.add(btnAdicionarMoto);
		
		JLabel labelGradiente = new JLabel("");
		labelGradiente.setBounds(0, 0, 984, 561);
		labelGradiente.setIcon(new ImageIcon(DadosCaminhaoGUI.class.getResource("/br/com/tokio/images/fundo_login_maior.png")));
		panel.add(labelGradiente);
	}
}