package br.com.tokio.view;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.io.File;
import java.io.IOException;

import br.com.tokio.model.Cliente;

public class UsuarioFrameGUI {

	public Connection conexao;

	
	JFrame frmUsuario;
	private JTextField textMensagem;
	private JTextArea textAreaChatBot;

	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsuarioFrameGUI corretor = new UsuarioFrameGUI();
					corretor.frmUsuario.setVisible(true);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public UsuarioFrameGUI() {
		initialize();
	}
	

	private void initialize() {
		frmUsuario = new JFrame();
		frmUsuario.setForeground(new Color(0, 153, 102));
		frmUsuario.setFont(new Font("Arial", Font.BOLD, 15));
		frmUsuario.setIconImage(Toolkit.getDefaultToolkit().getImage(UsuarioFrameGUI.class.getResource("/br/com/tokio/images/logo_tokio.png")));
		frmUsuario.setTitle("TOKIO MARINE SEGURADORA");
		frmUsuario.setBounds(100, 100, 1000, 600);
		frmUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUsuario.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 102));
		panel.setBounds(0, 0, 984, 561);
		frmUsuario.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		
		textMensagem = new JTextField();
		textMensagem.setHorizontalAlignment(SwingConstants.CENTER);
		textMensagem.setToolTipText("");
		textMensagem.setFont(new Font("Arial", Font.PLAIN, 12));
		textMensagem.setBounds(441, 520, 491, 30);
		panel.add(textMensagem);
		textMensagem.setColumns(10);
		
		
		JButton botaoAjuda = new JButton("");
		botaoAjuda.setForeground(new Color(0, 153, 102));
		botaoAjuda.setBackground(new Color(0, 153, 102));
		botaoAjuda.setIcon(new ImageIcon(UsuarioFrameGUI.class.getResource("/br/com/tokio/images/botao_ajuda.png")));
		botaoAjuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String caminho = "C:/Users/lopes/Downloads/github - pdf.pdf";

				File arquivo = new File(caminho);

				try {
					Desktop.getDesktop().open(arquivo);
				} catch (IOException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, e, "Erro", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		botaoAjuda.setBounds(10, 520, 39, 30);
		panel.add(botaoAjuda);
		
		JButton botaoAreaCliente = new JButton("");
		botaoAreaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginUsuarioGUI usuario = new LoginUsuarioGUI();
				usuario.newScreen();
				frmUsuario.dispose();
			}
		});
		botaoAreaCliente.setIcon(new ImageIcon(UsuarioFrameGUI.class.getResource("/br/com/tokio/images/botao_cliente.png")));
		botaoAreaCliente.setBounds(248, 520, 183, 30);
		panel.add(botaoAreaCliente);
		
		textAreaChatBot = new JTextArea();
		textAreaChatBot.setBounds(252, 85, 680, 424);
		panel.add(textAreaChatBot);
		textAreaChatBot.setColumns(10);
		
		JButton botaoAreaCorretor = new JButton("");
		botaoAreaCorretor.setIcon(new ImageIcon(UsuarioFrameGUI.class.getResource("/br/com/tokio/images/BOTAO_CORRETOR.png")));
		botaoAreaCorretor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					LoginFrameGUI corretor = new LoginFrameGUI();
	                corretor.newScreen();
	                frmUsuario.dispose();
				} catch (Exception e2) {
                    e2.printStackTrace();
				}
			}
		});
		botaoAreaCorretor.setBounds(55, 520, 183, 30);
		panel.add(botaoAreaCorretor);
		
		
		JButton botaoEnviarMensagem = new JButton();
		botaoEnviarMensagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
											
				if(e.getSource() == botaoEnviarMensagem) {

					String text = textMensagem.getText();
					String textRepostaSeguro = textMensagem.getText();
					textAreaChatBot.append("Você --> " + text + "\n");
					textMensagem.setText("");
			
					
					if(text.contains("oi") || text.contains("Oi")) {
						respostaMarina("Informe seu cpf: ");
					} else if(textRepostaSeguro.contains("55522233322")) {
						try {
							inserirChat();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						respostaMarina("Certo! Você escolheu o seguro " + textRepostaSeguro + ".");
					} else {
						respostaMarina("Não entendi, repita por favor");
					} 
					
				}
		
		}
		public void respostaMarina(String s) {
			textAreaChatBot.append("Marina --> " + s + "\n");
		}
		
		public void inserirChat() throws SQLException {
			String sql = "insert into t_tok_cliente (NR_CPF_CLI) values (?)";
			
			Cliente cliente = new Cliente();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			try {
				stmt.setString(1, cliente.getCpfCliente());
				stmt.execute();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	});
		
	
		
		botaoEnviarMensagem.setForeground(new Color(0, 153, 102));
		botaoEnviarMensagem.setBackground(new Color(0, 153, 102));
		botaoEnviarMensagem.setIcon(new ImageIcon(UsuarioFrameGUI.class.getResource("/br/com/tokio/images/botao_enviar.png")));
		botaoEnviarMensagem.setBounds(942, 520, 32, 30);
		panel.add(botaoEnviarMensagem);
		
		JLabel labelMarinaIcone = new JLabel("");
		labelMarinaIcone.setIcon(new ImageIcon(UsuarioFrameGUI.class.getResource("/br/com/tokio/images/marinaaaa.png")));
		labelMarinaIcone.setBounds(268, -13, 99, 115);
		panel.add(labelMarinaIcone);
		
		JLabel labelMensagemMarina = new JLabel("Olá, eu sou a Marina e vou te ajudar na cotação e na contratação do seu seguro!");
		labelMensagemMarina.setForeground(Color.WHITE);
		labelMensagemMarina.setFont(new Font("Arial", Font.BOLD, 15));
		labelMensagemMarina.setBounds(350, 11, 624, 59);
		panel.add(labelMensagemMarina);
		
		JLabel labelFundoGradient = new JLabel("");
		labelFundoGradient.setIcon(new ImageIcon(UsuarioFrameGUI.class.getResource("/br/com/tokio/images/fundo_login_maior.png")));
		labelFundoGradient.setBounds(0, 0, 984, 561);
		panel.add(labelFundoGradient);
	}

	protected void dispose() {
		// TODO Auto-generated method stub
		
	}
}
