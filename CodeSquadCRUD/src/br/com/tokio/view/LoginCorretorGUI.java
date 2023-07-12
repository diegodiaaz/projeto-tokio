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
import javax.swing.border.EtchedBorder;

import br.com.tokio.model.Corretor;
import br.com.tokio.repository.CorretorDAO;
import javax.swing.JPasswordField;

public class LoginCorretorGUI {

	public JFrame frameLoginCorretor;
	private JTextField emailTextField;
	private JPasswordField txtSenha;

	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginCorretorGUI login = new LoginCorretorGUI();
					login.frameLoginCorretor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginCorretorGUI() {
		initialize();
	}

	private void initialize() {
		frameLoginCorretor = new JFrame();
		frameLoginCorretor.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(LoginCorretorGUI.class.getResource("/br/com/tokio/images/logo_tokio.png")));
		frameLoginCorretor.setTitle("TOKIO MARINE SEGURADORA");
		frameLoginCorretor.setBounds(100, 100, 1000, 600);
		frameLoginCorretor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameLoginCorretor.getContentPane().setLayout(null);

		JPanel panel_principal = new JPanel();
		panel_principal.setBackground(new Color(127, 181, 119));
		panel_principal.setBounds(0, 0, 984, 561);
		frameLoginCorretor.getContentPane().add(panel_principal);
		panel_principal.setLayout(null);

		JButton botaoVoltar = new JButton("");
		botaoVoltar.setIcon(new ImageIcon(LoginCorretorGUI.class.getResource("/br/com/tokio/images/botao_voltar.png")));
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameLoginCorretor.dispose();
				AreaInicioGUI corretor = new AreaInicioGUI();
				corretor.frmUsuario.setVisible(true);
			}
		});
		botaoVoltar.setFont(new Font("Arial", Font.BOLD, 12));
		botaoVoltar.setBounds(20, 20, 47, 30);
		panel_principal.add(botaoVoltar);

		JLabel labelMensagemMarina = new JLabel("Bem-vindo à área de login do corretor.");
		labelMensagemMarina.setForeground(new Color(255, 255, 255));
		labelMensagemMarina.setFont(new Font("Arial", Font.BOLD, 18));
		labelMensagemMarina.setBounds(330, 77, 434, 68);
		panel_principal.add(labelMensagemMarina);

		JLabel labelMarinaIcone = new JLabel("");
		labelMarinaIcone.setIcon(new ImageIcon(LoginCorretorGUI.class.getResource("/br/com/tokio/images/marinaaaa.png")));
		labelMarinaIcone.setBounds(458, 10, 105, 93);
		panel_principal.add(labelMarinaIcone);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 153, 102), new Color(0, 153, 51)));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(309, 145, 385, 375);
		panel_principal.add(panel);
		panel.setLayout(null);

		JLabel lbl_msg_login = new JLabel("Faça seu login");
		lbl_msg_login.setForeground(new Color(0, 51, 51));
		lbl_msg_login.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_msg_login.setBounds(123, 40, 152, 43);
		panel.add(lbl_msg_login);

		JLabel lbl_email = new JLabel("Usuário:");
		lbl_email.setForeground(new Color(0, 51, 51));
		lbl_email.setFont(new Font("Arial", Font.BOLD, 14));
		lbl_email.setBounds(45, 93, 105, 43);
		panel.add(lbl_email);

		emailTextField = new JTextField();
		emailTextField.setFont(new Font("Tahoma", Font.BOLD, 14));
		emailTextField.setForeground(new Color(0, 0, 0));
		emailTextField.setBackground(new Color(240, 240, 240));
		emailTextField.setColumns(10);
		emailTextField.setBounds(45, 132, 299, 37);
		panel.add(emailTextField);

		JLabel lbl_senha = new JLabel("Senha:");
		lbl_senha.setForeground(new Color(0, 51, 51));
		lbl_senha.setFont(new Font("Arial", Font.BOLD, 14));
		lbl_senha.setBounds(44, 180, 124, 37);
		panel.add(lbl_senha);

		JButton btn_entrar = new JButton("ENTRAR");
		btn_entrar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
//				String emailCorretor, senhaCorretor;
//				emailCorretor = emailTextField.getText();
//				senhaCorretor = txtSenha.getText();
//
//				try {
//					// VALIDAÇÃO DO LOGIN
//
//					Corretor objCorretor = new Corretor();
//					objCorretor.setEmailCorretor(emailCorretor);
//					objCorretor.setSenhaCorretor(senhaCorretor);
//
//					CorretorDAO CorretorDAO = new CorretorDAO();
//					ResultSet rsCorretorDAO = CorretorDAO.loginCorretor(objCorretor);
//
//					if (rsCorretorDAO.next()) {
//						// CHAMAR TELA PARA ABRIR
						AreaCorretorGUI areaCorretor = new AreaCorretorGUI();
						areaCorretor.frameCorretor.setVisible(true);
						frameLoginCorretor.dispose();
//					} else {
//						// ENVIAR MENSAGEM "LOGIN INCORRETO"
//						JOptionPane.showMessageDialog(null, "Email ou Senha invalido");
//					}
//
//				} catch (SQLException erro) {
//					JOptionPane.showMessageDialog(null, "VALIDACAO DE LOGIN: " + erro);
//				}

			}
		});
		btn_entrar.setFont(new Font("Arial", Font.BOLD, 14));
		btn_entrar.setBounds(123, 288, 136, 37);
		panel.add(btn_entrar);
		
		txtSenha = new JPasswordField();
		txtSenha.setBackground(new Color(240, 240, 240));
		txtSenha.setBounds(45, 214, 299, 37);
		panel.add(txtSenha);

		JLabel labelFundoGradient = new JLabel("");
		labelFundoGradient
				.setIcon(new ImageIcon(LoginCorretorGUI.class.getResource("/br/com/tokio/images/fundo_login_maior.png")));
		labelFundoGradient.setBackground(new Color(240, 240, 240));
		labelFundoGradient.setBounds(0, 0, 984, 561);
		panel_principal.add(labelFundoGradient);
	}

	public void run() {
		new LoginCorretorGUI().setVisible(true);
	}

	public void setVisible(boolean b) {
		// CONSTRUTOR VAZIO

	}
}