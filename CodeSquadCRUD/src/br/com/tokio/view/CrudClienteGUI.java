package br.com.tokio.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class CrudClienteGUI {

	public JFrame frameCliente;
	private JTextField txtNomeCliente;
	private JTextField txtCpf;
	private JTextField txtTelefone;
	private JTextField txtDataNascimento;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void newscreen(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrudClienteGUI window = new CrudClienteGUI();
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
	public CrudClienteGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameCliente = new JFrame();
		frameCliente.setTitle("TOKIO MARINE SEGURADORA");
		frameCliente.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(CrudClienteGUI.class.getResource("/br/com/tokio/images/logo_tokio.png")));
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
				loginUsuario.newScreen();
				

			}
		});
		botaoVoltar.setIcon(new ImageIcon(CrudClienteGUI.class.getResource("/br/com/tokio/images/botao_voltar.png")));
		botaoVoltar.setBounds(20, 20, 47, 30);
		contentPane.add(botaoVoltar);

		JButton btnGerarContrato = new JButton("Gerar contrato");
		btnGerarContrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Document document = new Document();
		          try {

		              PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\Administrator\\Desktop\\contrato-seguro.pdf"));
		              document.open();

		              // adicionando um parágrafo no documento
		              document.add(new Paragraph("CODESQUAD®, 2023."));
		              document.add(new Paragraph("\n"));
		              document.add(new Paragraph("CONTRATO DO SEGURO AUTOMOTIVO"));
		              document.add(new Paragraph("______________________________________________________________________"));
		              document.add(new Paragraph("\n"));
		              document.add(new Paragraph("Nome do cliente: "+txtNomeCliente.getText()));
		              document.add(new Paragraph("CPF: "+txtNomeCliente.getText()));
		              document.add(new Paragraph("Telefone: "+txtTelefone.getText()));
		              document.add(new Paragraph("Data de nascimento: "+txtDataNascimento.getText()));
		              document.add(new Paragraph("E-mail: "+txtEmail.getText()));
		              document.add(new Paragraph("\n_____________________________________________________________________\n"));
		              document.add(new Paragraph("Dados do veículo:"));
		              document.add(new Paragraph("----------------------------"));
		              document.add(new Paragraph("Tipo do veículo: "));
		              document.add(new Paragraph("Placa do veículo: "));
		              document.add(new Paragraph("Marca: "));
		              document.add(new Paragraph("Modelo: "));
		              document.add(new Paragraph("Ano: "));
		              
		    }
		          catch(DocumentException de) {
		              System.err.println(de.getMessage());
		          }
		          catch(IOException ioe) {
		              System.err.println(ioe.getMessage());
		          }
		          document.close();
		      }

		});
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
		lblIconeUsuario
				.setIcon(new ImageIcon(CrudClienteGUI.class.getResource("/br/com/tokio/images/usuario_Foto.png")));
		lblIconeUsuario.setBounds(27, 27, 70, 70);
		panel.add(lblIconeUsuario);

		JLabel lblNewLabel_2_3 = new JLabel("Telefone:");
		lblNewLabel_2_3.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_2_3.setBounds(27, 241, 193, 25);
		panel.add(lblNewLabel_2_3);

		JLabel lblNewLabel_2_4 = new JLabel("CPF:");
		lblNewLabel_2_4.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_2_4.setBounds(27, 177, 193, 25);
		panel.add(lblNewLabel_2_4);

		JLabel lblNewLabel_2_3_1 = new JLabel("E-mail:");
		lblNewLabel_2_3_1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_2_3_1.setBounds(321, 192, 193, 25);
		panel.add(lblNewLabel_2_3_1);

		JLabel lblNewLabel_2_4_1 = new JLabel("Data de nascimento:");
		lblNewLabel_2_4_1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_2_4_1.setBounds(321, 121, 193, 25);
		panel.add(lblNewLabel_2_4_1);

		JLabel lblNewLabel_2_4_2 = new JLabel("Nome:");
		lblNewLabel_2_4_2.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_2_4_2.setBounds(27, 108, 193, 25);
		panel.add(lblNewLabel_2_4_2);

		txtNomeCliente = new JTextField();
		txtNomeCliente.setBounds(27, 131, 207, 33);
		panel.add(txtNomeCliente);
		txtNomeCliente.setColumns(10);

		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		txtCpf.setBounds(27, 197, 207, 33);
		panel.add(txtCpf);

		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(27, 261, 207, 33);
		panel.add(txtTelefone);

		txtDataNascimento = new JTextField();
		txtDataNascimento.setColumns(10);
		txtDataNascimento.setBounds(321, 149, 207, 33);
		panel.add(txtDataNascimento);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(321, 215, 207, 33);
		panel.add(txtEmail);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(
				new ImageIcon(CrudClienteGUI.class.getResource("/br/com/tokio/images/fundo_login_maior.png")));
		lblNewLabel.setBounds(0, 0, 984, 561);
		contentPane.add(lblNewLabel);
	}
}