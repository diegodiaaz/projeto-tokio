package br.com.tokio.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;

import br.com.tokio.model.Cliente;
import br.com.tokio.repository.ClienteDAO;


public class LoginUsuarioGUI {

	public JFrame frameUsuario;
	private JTextField txtEmail;
	private JTextField txtCPF;


	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUsuarioGUI login = new LoginUsuarioGUI();
					login.frameUsuario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginUsuarioGUI() {
		initialize();
	}

	private void initialize() {
		frameUsuario = new JFrame();
		frameUsuario.setIconImage(Toolkit.getDefaultToolkit().getImage(LoginUsuarioGUI.class.getResource("/br/com/tokio/images/logo_tokio.png")));
		frameUsuario.setTitle("TOKIO MARINE SEGURADORA");
		frameUsuario.setBounds(100, 100, 1000,600);
		frameUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameUsuario.getContentPane().setLayout(null);
		
		JPanel painelFundo = new JPanel();
		painelFundo.setBounds(0, 0, 1000, 600);
		frameUsuario.getContentPane().add(painelFundo);
		painelFundo.setLayout(null);
		
		JButton botaoVoltar = new JButton("");
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameUsuario.dispose();
				UsuarioFrameGUI telaChat = new UsuarioFrameGUI();
				telaChat.newScreen();
			}
		});
		botaoVoltar.setIcon(new ImageIcon(LoginUsuarioGUI.class.getResource("/br/com/tokio/images/botao_voltar.png")));
		botaoVoltar.setBounds(20, 20, 47, 30);
		painelFundo.add(botaoVoltar);
		
		JLabel LabelIconeMarina = new JLabel("");
		LabelIconeMarina.setIcon(new ImageIcon(LoginUsuarioGUI.class.getResource("/br/com/tokio/images/marinaaaa.png")));
		LabelIconeMarina.setBounds(458, 10, 105, 93);
		painelFundo.add(LabelIconeMarina);
		
		JLabel lblBemvindoarea = new JLabel("Bem-vindo(a) à área de login do cliente.\r\n");
		lblBemvindoarea.setForeground(Color.WHITE);
		lblBemvindoarea.setFont(new Font("Arial", Font.BOLD, 18));
		lblBemvindoarea.setBounds(330, 77, 434, 68);
		painelFundo.add(lblBemvindoarea);
		
		JPanel painelLogin = new JPanel();
		painelLogin.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 153, 102), new Color(0, 153, 51)));
		painelLogin.setBackground(new Color(255, 255, 255));
		painelLogin.setBounds(309, 145, 385, 375);
		painelFundo.add(painelLogin);
		painelLogin.setLayout(null);
		
		JLabel lbl_msg_login = new JLabel("Faça seu login");
		lbl_msg_login.setBounds(123, 40, 152, 43);
		painelLogin.add(lbl_msg_login);
		lbl_msg_login.setForeground(new Color(0, 51, 51));
		lbl_msg_login.setFont(new Font("Arial", Font.BOLD, 20));
		
		JLabel lbl_email = new JLabel("E-mail:");
		lbl_email.setForeground(new Color(0, 51, 51));
		lbl_email.setFont(new Font("Arial", Font.BOLD, 14));
		lbl_email.setBounds(45, 93, 105, 43);
		painelLogin.add(lbl_email);
		
		txtEmail = new JTextField();
		txtEmail.setForeground(Color.BLACK);
		txtEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtEmail.setColumns(10);
		txtEmail.setBackground(UIManager.getColor("Button.background"));
		txtEmail.setBounds(45, 132, 299, 37);
		painelLogin.add(txtEmail);
		
		JLabel lbl_senha = new JLabel("CPF:");
		lbl_senha.setForeground(new Color(0, 51, 51));
		lbl_senha.setFont(new Font("Arial", Font.BOLD, 14));
		lbl_senha.setBounds(44, 180, 124, 37);
		painelLogin.add(lbl_senha);
		
		setTxtCPF(new JTextField());
		getTxtCPF().setForeground(Color.BLACK);
		getTxtCPF().setFont(new Font("Tahoma", Font.BOLD, 14));
		getTxtCPF().setBackground(UIManager.getColor("Button.background"));
		getTxtCPF().setBounds(45, 214, 299, 37);
		painelLogin.add(getTxtCPF());
		
		JButton btn_entrar = new JButton("ENTRAR");
		btn_entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
			
				String emailUsuario, cpfUsuario;
				emailUsuario = txtEmail.getText();
				cpfUsuario = getTxtCPF().getText();

				try {
					// VALIDAÇÃO DO LOGIN

					Cliente objCliente = new Cliente();
					objCliente.setEmailCliente(emailUsuario);
					objCliente.setCpfCliente(cpfUsuario);

					ClienteDAO clienteDAO = new ClienteDAO();
					ResultSet rsClienteDAO = clienteDAO.loginCliente(objCliente);

					if (rsClienteDAO.next()) {
						// CHAMAR TELA PARA ABRIR
						
						CrudClienteGUI cliente = new CrudClienteGUI();
						cliente.frameCliente.setVisible(true);
						frameUsuario.dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Email ou CPF inválido!");
					}
					
			

				} catch (SQLException erro) {
					JOptionPane.showMessageDialog(null, "VALIDACAO DE LOGIN: " + erro);
				}
				
			}
		});
		btn_entrar.setFont(new Font("Arial", Font.BOLD, 14));
		btn_entrar.setBounds(123, 288, 136, 37);
		painelLogin.add(btn_entrar);
		
		JLabel labelFundoGradiente = new JLabel("");
		labelFundoGradiente.setIcon(new ImageIcon(LoginUsuarioGUI.class.getResource("/br/com/tokio/images/fundo_login_maior.png")));
		labelFundoGradiente.setBounds(0, 0, 990, 565);
		painelFundo.add(labelFundoGradiente);
		
		
	}

	public JTextField getTxtCPF() {
		return txtCPF;
	}

	public void setTxtCPF(JTextField txtCPF) {
		this.txtCPF = txtCPF;
	}
}
