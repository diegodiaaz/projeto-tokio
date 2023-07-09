package br.com.tokio.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClienteCrudGUI1 {

	public JFrame frameCliente;

	/**
	 * Launch the application.
	 */
	public static void newscreen(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteCrudGUI1 window = new ClienteCrudGUI1();
					window.frameCliente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ClienteCrudGUI1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameCliente = new JFrame();
		frameCliente.setTitle("TOKIO MARINE SEGURADORA");
		frameCliente.setIconImage(Toolkit.getDefaultToolkit().getImage(ClienteCrudGUI1.class.getResource("/br/com/tokio/images/logo_tokio.png")));
		frameCliente.setBounds(100, 100, 1000, 600);
		frameCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameCliente.getContentPane().setLayout(null);
		
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0, 0, 984, 561);
		frameCliente.getContentPane().add(contentPane);
		
		JButton botaoVoltar = new JButton("");
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameCliente.dispose();
				LoginUsuarioGUI loginUsuario = new LoginUsuarioGUI();
				loginUsuario.newScreen(null);
				
			}
		});
		botaoVoltar.setIcon(new ImageIcon(ClienteCrudGUI1.class.getResource("/br/com/tokio/images/botao_voltar.png")));
		botaoVoltar.setBounds(20, 20, 47, 30);
		contentPane.add(botaoVoltar);
		
		JButton btnGerarContrato = new JButton("Gerar contrato");
		btnGerarContrato.setForeground(Color.WHITE);
		btnGerarContrato.setBackground(new Color(64, 128, 128));
		btnGerarContrato.setBounds(667, 477, 126, 36);
		contentPane.add(btnGerarContrato);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(273, 477, 89, 36);
		contentPane.add(btnExcluir);
		
		JButton btnNewButton = new JButton("Editar");
		btnNewButton.setBounds(172, 477, 89, 36);
		contentPane.add(btnNewButton);
		
		JLabel lblSejaBemvindoaA = new JLabel("Seja bem-vindo(a) a área do cliente!");
		lblSejaBemvindoaA.setForeground(Color.WHITE);
		lblSejaBemvindoaA.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblSejaBemvindoaA.setBounds(278, 22, 489, 88);
		contentPane.add(lblSejaBemvindoaA);
		
		JLabel labelMarina = new JLabel("");
		labelMarina.setBounds(190, 22, 577, 88);
		contentPane.add(labelMarina);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(190, 132, 585, 331);
		contentPane.add(panel);
		
		JLabel lblIconeUsuario = new JLabel("");
		lblIconeUsuario.setIcon(new ImageIcon(ClienteCrudGUI1.class.getResource("/br/com/tokio/images/usuario_Foto.png")));
		lblIconeUsuario.setBounds(27, 27, 70, 70);
		panel.add(lblIconeUsuario);
		
		JLabel lblNewLabel_2_3 = new JLabel("Telefone:");
		lblNewLabel_2_3.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_2_3.setBounds(27, 221, 193, 25);
		panel.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("CPF:");
		lblNewLabel_2_4.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_2_4.setBounds(27, 157, 193, 25);
		panel.add(lblNewLabel_2_4);
		
		JLabel lblNomeCliente = new JLabel("Cliente Silva Souza");
		lblNomeCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeCliente.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblNomeCliente.setBounds(27, 121, 172, 33);
		panel.add(lblNomeCliente);
		
		JLabel lblCPF = new JLabel("123.456.789-10");
		lblCPF.setHorizontalAlignment(SwingConstants.CENTER);
		lblCPF.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblCPF.setBounds(27, 185, 172, 33);
		panel.add(lblCPF);
		
		JLabel lblTelefone = new JLabel("11 91234-5678");
		lblTelefone.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefone.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblTelefone.setBounds(27, 251, 172, 33);
		panel.add(lblTelefone);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(ClienteCrudGUI1.class.getResource("/br/com/tokio/images/fundo texto.png")));
		lblNewLabel_3.setBounds(27, 251, 172, 25);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setIcon(new ImageIcon(ClienteCrudGUI1.class.getResource("/br/com/tokio/images/fundo texto.png")));
		lblNewLabel_3_1.setBounds(27, 185, 172, 25);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("");
		lblNewLabel_3_2.setIcon(new ImageIcon(ClienteCrudGUI1.class.getResource("/br/com/tokio/images/fundo texto.png")));
		lblNewLabel_3_2.setBounds(27, 121, 172, 25);
		panel.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("E-mail:");
		lblNewLabel_2_3_1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_2_3_1.setBounds(321, 185, 193, 25);
		panel.add(lblNewLabel_2_3_1);
		
		JLabel lblNewLabel_2_4_1 = new JLabel("Data de nascimento:");
		lblNewLabel_2_4_1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_2_4_1.setBounds(321, 121, 193, 25);
		panel.add(lblNewLabel_2_4_1);
		
		JLabel lblDataNasc = new JLabel("01/01/2001");
		lblDataNasc.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataNasc.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblDataNasc.setBounds(321, 149, 172, 33);
		panel.add(lblDataNasc);
		
		JLabel lblEmail = new JLabel("clientesilva@gmail.com");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblEmail.setBounds(321, 215, 232, 33);
		panel.add(lblEmail);
		
		JLabel lblNewLabel_3_3 = new JLabel("");
		lblNewLabel_3_3.setIcon(new ImageIcon(ClienteCrudGUI1.class.getResource("/br/com/tokio/images/fundo_texto.png")));
		lblNewLabel_3_3.setBounds(321, 215, 232, 25);
		panel.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("");
		lblNewLabel_3_1_1.setIcon(new ImageIcon(ClienteCrudGUI1.class.getResource("/br/com/tokio/images/fundo texto.png")));
		lblNewLabel_3_1_1.setBounds(321, 149, 172, 25);
		panel.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ClienteCrudGUI1.class.getResource("/br/com/tokio/images/fundo_login_maior.png")));
		lblNewLabel.setBounds(0, 0, 984, 561);
		contentPane.add(lblNewLabel);
	}

}
