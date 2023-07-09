package br.com.tokio.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import br.com.tokio.connection.ConnectionFactory;
import br.com.tokio.model.Cliente;
import br.com.tokio.repository.ClienteDAO;


public class CrudClienteGUI extends LoginFrameGUI{

	public JFrame frmTokioMarineSeguradora;
	private Connection conexao;
	private JTextField txtTelefone;
	private JTextField txtDataNascimento;
	private JTextField txtEmail;
	private JTextField txtCPFUsuario;
	private JTextField txtNomeCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrudClienteGUI window = new CrudClienteGUI();
					window.frmTokioMarineSeguradora.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CrudClienteGUI() {
		initialize();
		this.conexao = new ConnectionFactory().conectar();
	}

	private void initialize() {
		frmTokioMarineSeguradora = new JFrame();
		frmTokioMarineSeguradora.setTitle("TOKIO MARINE SEGURADORA");
		frmTokioMarineSeguradora.setIconImage(Toolkit.getDefaultToolkit().getImage(CrudClienteGUI.class.getResource("/br/com/tokio/images/logo_tokio.png")));
		frmTokioMarineSeguradora.setBounds(100, 100, 1000, 600);
		frmTokioMarineSeguradora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTokioMarineSeguradora.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 984, 561);
		frmTokioMarineSeguradora.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton botaoVoltar = new JButton("");
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmTokioMarineSeguradora.dispose();
				LoginUsuarioGUI telaLogin = new LoginUsuarioGUI();
				telaLogin.newScreen();
				
			}
		});
		botaoVoltar.setIcon(new ImageIcon(CrudClienteGUI.class.getResource("/br/com/tokio/images/botao_voltar.png")));
		botaoVoltar.setBounds(20, 20, 47, 30);
		panel.add(botaoVoltar);
		
		JButton botaoGerarContrato = new JButton("Gerar contrato");
		botaoGerarContrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 Document document = new Document();
				 Cliente cliente = new Cliente();
				 ClienteDAO clienteDAO = new ClienteDAO();
				 LoginUsuarioGUI loginUser = new LoginUsuarioGUI();
				 
		          try {
		        	  String cpf = txtCPFUsuario.getText();
		        	  clienteDAO.selectByCPF(cpf);
		        	  String sql = "select * from T_TOK_CLIENTE where nr_cpf_cli = ?";
					try {
						PreparedStatement pmts = conexao.prepareStatement(sql);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

		              PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\User\\Desktop\\contrato-seguroauto.pdf"));
		              document.open();

		              // adicionando um parágrafo no pdf
		              document.add(new Paragraph("CODESQUAD®, 2023."));
		              document.add(new Paragraph("Contrato do seu Seguro Automotivo"));
		              document.add(new Paragraph("\n\n\n"));		             
		              document.add(new Paragraph("Nome do cliente: "+ txtNomeCliente.getText()));
		              document.add(new Paragraph("CPF: "+ txtCPFUsuario.getText()));
		              document.add(new Paragraph("Data de nascimento: "+  txtDataNascimento.getText()));
		              document.add(new Paragraph("E-mail: "  + txtEmail.getText()));
		              document.add(new Paragraph("Telefone: " + txtTelefone.getText()));
		              document.add(new Paragraph(""));
		              document.add(new Paragraph("____________________________________________________________________________"));
		              document.add(new Paragraph("\nDADOS DO VEÍCULO - "));
		              document.add(new Paragraph("\nTipo do veículo: "));
		              document.add(new Paragraph("Placa: "));
		              document.add(new Paragraph("Ano: "));
		              document.add(new Paragraph("Marca: "));
		              document.add(new Paragraph("Modelo: "));
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
		botaoGerarContrato.setForeground(new Color(0, 0, 0));
		botaoGerarContrato.setBackground(new Color(64, 128, 128));
		botaoGerarContrato.setBounds(693, 444, 126, 36);
		panel.add(botaoGerarContrato);
		
		JButton botaoExcluir = new JButton("Excluir");
		botaoExcluir.setBounds(339, 444, 108, 33);
		panel.add(botaoExcluir);
		
		JButton botaoEditar = new JButton("Editar");
		botaoEditar.setBounds(213, 444, 108, 33);
		panel.add(botaoEditar);
		
		JLabel labelTitulo = new JLabel("Seja bem-vindo(a) a área do cliente!");
		labelTitulo.setForeground(Color.WHITE);
		labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 26));
		labelTitulo.setBounds(310, 17, 489, 88);
		panel.add(labelTitulo);
		
		JLabel labelMarinaIcon = new JLabel("");
		labelMarinaIcon.setIcon(new ImageIcon(CrudClienteGUI.class.getResource("/br/com/tokio/images/marinaaaa.png")));
		labelMarinaIcon.setBounds(230, 26, 77, 72);
		panel.add(labelMarinaIcon);
		
		JPanel panelInfoCliente = new JPanel();
		panelInfoCliente.setBackground(new Color(255, 255, 255));
		panelInfoCliente.setBounds(213, 116, 606, 317);
		panel.add(panelInfoCliente);
		panelInfoCliente.setLayout(null);
		
		JLabel labelClienteIcon = new JLabel("");
		labelClienteIcon.setIcon(new ImageIcon(CrudClienteGUI.class.getResource("/br/com/tokio/images/usuario_Foto.png")));
		labelClienteIcon.setBounds(30, 25, 77, 83);
		panelInfoCliente.add(labelClienteIcon);
		
		JLabel labelSubTitleNome = new JLabel("Nome:");
		labelSubTitleNome.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		labelSubTitleNome.setBounds(117, 42, 193, 25);
		panelInfoCliente.add(labelSubTitleNome);
		
		JLabel labelSubTitleCPF = new JLabel("CPF:");
		labelSubTitleCPF.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		labelSubTitleCPF.setBounds(104, 137, 206, 33);
		panelInfoCliente.add(labelSubTitleCPF);
		
		JLabel labelSubTitleTelefone = new JLabel("Telefone:");
		labelSubTitleTelefone.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		labelSubTitleTelefone.setBounds(101, 224, 193, 25);
		panelInfoCliente.add(labelSubTitleTelefone);
		
		JLabel labelSubTitleDataNasc = new JLabel("Data de nascimento:");
		labelSubTitleDataNasc.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		labelSubTitleDataNasc.setBounds(371, 141, 193, 25);
		panelInfoCliente.add(labelSubTitleDataNasc);
		
		JLabel labelSubTitleEmail = new JLabel("E-mail:");
		labelSubTitleEmail.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		labelSubTitleEmail.setBounds(371, 224, 193, 25);
		panelInfoCliente.add(labelSubTitleEmail);
		
		txtTelefone = new JTextField();
		txtTelefone.setBackground(new Color(212, 212, 212));
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(101, 243, 209, 33);
		panelInfoCliente.add(txtTelefone);
		
		txtDataNascimento = new JTextField();
		txtDataNascimento.setBackground(new Color(212, 212, 212));
		txtDataNascimento.setColumns(10);
		txtDataNascimento.setBounds(371, 164, 209, 33);
		panelInfoCliente.add(txtDataNascimento);
		
		txtEmail = new JTextField();
		txtEmail.setBackground(new Color(212, 212, 212));
		txtEmail.setColumns(10);
		txtEmail.setBounds(371, 243, 209, 33);
		panelInfoCliente.add(txtEmail);
		
		txtCPFUsuario = new JTextField();
		txtCPFUsuario.setColumns(10);
		txtCPFUsuario.setBackground(new Color(212, 212, 212));
		txtCPFUsuario.setBounds(101, 164, 209, 33);
		panelInfoCliente.add(txtCPFUsuario);
		
		txtNomeCliente = new JTextField();
		txtNomeCliente.setColumns(10);
		txtNomeCliente.setBackground(new Color(212, 212, 212));
		txtNomeCliente.setBounds(117, 64, 209, 33);
		panelInfoCliente.add(txtNomeCliente);
		
		JLabel labelFundoGradient = new JLabel("");
		labelFundoGradient.setIcon(new ImageIcon(CrudClienteGUI.class.getResource("/br/com/tokio/images/fundo_login_maior.png")));
		labelFundoGradient.setBounds(0, 0, 984, 561);
		panel.add(labelFundoGradient);
	}
}
