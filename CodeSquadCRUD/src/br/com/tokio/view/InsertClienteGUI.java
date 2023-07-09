package br.com.tokio.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class InsertClienteGUI {

	private JFrame insertCliente;
	private JTextField txtNomeInsert;
	private JTextField txtCPFInsert;
	private JTextField txtTelefoneInsert;
	private JTextField txtDataNascimentoInsert;
	private JTextField txtEmailInsert;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertClienteGUI window = new InsertClienteGUI();
					window.insertCliente.setVisible(true);
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
		insertCliente.setBounds(100, 100, 1000, 600);
		insertCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		insertCliente.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 984, 561);
		insertCliente.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(InsertClienteGUI.class.getResource("/br/com/tokio/images/marinonanona.png")));
		lblNewLabel_1.setBounds(51, 66, 231, 442);
		panel.add(lblNewLabel_1);
		
		JLabel lblAquiVocPode = new JLabel("Aqui vocÃª pode criar um cliente!");
		lblAquiVocPode.setForeground(Color.WHITE);
		lblAquiVocPode.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblAquiVocPode.setBounds(387, 43, 421, 88);
		panel.add(lblAquiVocPode);
		
		JButton btnCriarCliente = new JButton("Criar cliente");
		btnCriarCliente.setBounds(554, 485, 89, 43);
		panel.add(btnCriarCliente);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(307, 143, 585, 331);
		panel.add(panel_1);
		
		JLabel lblNewLabel_2_3 = new JLabel("Telefone:");
		lblNewLabel_2_3.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_2_3.setBounds(48, 241, 193, 25);
		panel_1.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("CPF:");
		lblNewLabel_2_4.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_2_4.setBounds(48, 177, 193, 25);
		panel_1.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("E-mail:");
		lblNewLabel_2_3_1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_2_3_1.setBounds(341, 177, 193, 25);
		panel_1.add(lblNewLabel_2_3_1);
		
		JLabel lblNewLabel_2_4_1 = new JLabel("Data de nascimento:");
		lblNewLabel_2_4_1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_2_4_1.setBounds(341, 108, 193, 25);
		panel_1.add(lblNewLabel_2_4_1);
		
		JLabel lblNewLabel_2_4_2 = new JLabel("Nome:");
		lblNewLabel_2_4_2.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_2_4_2.setBounds(48, 108, 193, 25);
		panel_1.add(lblNewLabel_2_4_2);
		
		txtNomeInsert = new JTextField();
		txtNomeInsert.setColumns(10);
		txtNomeInsert.setBounds(48, 131, 207, 33);
		panel_1.add(txtNomeInsert);
		
		txtCPFInsert = new JTextField();
		txtCPFInsert.setColumns(10);
		txtCPFInsert.setBounds(48, 197, 207, 33);
		panel_1.add(txtCPFInsert);
		
		txtTelefoneInsert = new JTextField();
		txtTelefoneInsert.setColumns(10);
		txtTelefoneInsert.setBounds(48, 261, 207, 33);
		panel_1.add(txtTelefoneInsert);
		
		txtDataNascimentoInsert = new JTextField();
		txtDataNascimentoInsert.setColumns(10);
		txtDataNascimentoInsert.setBounds(341, 131, 207, 33);
		panel_1.add(txtDataNascimentoInsert);
		
		txtEmailInsert = new JTextField();
		txtEmailInsert.setColumns(10);
		txtEmailInsert.setBounds(341, 197, 207, 33);
		panel_1.add(txtEmailInsert);
		
		JLabel lblInsiraAbaixoOs = new JLabel("Insira abaixo os dados do cliente.");
		lblInsiraAbaixoOs.setForeground(new Color(0, 0, 0));
		lblInsiraAbaixoOs.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblInsiraAbaixoOs.setBounds(106, 22, 357, 88);
		panel_1.add(lblInsiraAbaixoOs);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(InsertClienteGUI.class.getResource("/br/com/tokio/images/fundo_login_maior.png")));
		lblNewLabel.setBounds(0, 0, 984, 561);
		panel.add(lblNewLabel);
	}
}