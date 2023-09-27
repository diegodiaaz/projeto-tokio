package br.com.tokio.view;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.com.tokio.repository.ChatbotDAO;

public class ChatbotGUI {

	public Connection conexao;

	
	JFrame frmUsuario;
	private JTextField textMensagem;
	ChatbotDAO chatbot = new ChatbotDAO();
	
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatbotGUI corretor = new ChatbotGUI();
					corretor.frmUsuario.setVisible(true);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ChatbotGUI() {
		initialize();
	}
	

	private void initialize() {
		frmUsuario = new JFrame();
		frmUsuario.setForeground(new Color(0, 153, 102));
		frmUsuario.setFont(new Font("Arial", Font.BOLD, 15));
		frmUsuario.setIconImage(Toolkit.getDefaultToolkit().getImage(ChatbotGUI.class.getResource("/br/com/tokio/images/logo_tokio.png")));
		frmUsuario.setTitle("TOKIO MARINE SEGURADORA");
		frmUsuario.setBounds(100, 100, 1000, 600);
		frmUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUsuario.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 102));
		panel.setBounds(0, 0, 984, 561);
		frmUsuario.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel labelCodeSquadImage = new JLabel(""); 
		labelCodeSquadImage.setIcon(new ImageIcon(ChatbotGUI.class.getResource("/br/com/tokio/images/CodeSquadLogo.png")));
		labelCodeSquadImage.setBounds(35, 339, 203, 170);
		panel.add(labelCodeSquadImage);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(248, 89, 706, 420);
		panel.add(scrollPane);
		
	
		textMensagem = new JTextField();
		textMensagem.setHorizontalAlignment(SwingConstants.LEFT);
		textMensagem.setToolTipText("");
		textMensagem.setFont(new Font("Arial", Font.PLAIN, 12));
		textMensagem.setBounds(297, 520, 635, 30);
		panel.add(textMensagem);
		textMensagem.setColumns(10);
		
		
		JButton botaoAjuda = new JButton("");
		botaoAjuda.setForeground(new Color(0, 153, 102));
		botaoAjuda.setBackground(new Color(0, 153, 102));
		botaoAjuda.setIcon(new ImageIcon(ChatbotGUI.class.getResource("/br/com/tokio/images/botao_ajuda.png")));
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
		botaoAjuda.setBounds(248, 520, 39, 30);
		panel.add(botaoAjuda);
		
		JButton botaoAreaCliente = new JButton("");
		botaoAreaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrudClienteGUI clienteTela = new CrudClienteGUI();
				clienteTela.newScreen(null);
				frmUsuario.dispose();
			}
		});
		
		botaoAreaCliente.setIcon(new ImageIcon(ChatbotGUI.class.getResource("/br/com/tokio/images/botaoCliente.png")));
		botaoAreaCliente.setBounds(35, 184, 183, 30);
		panel.add(botaoAreaCliente);
		
		JButton botaoAreaCorretor = new JButton("");
		botaoAreaCorretor.setIcon(new ImageIcon(ChatbotGUI.class.getResource("/br/com/tokio/images/botaoCorretor.png")));
		botaoAreaCorretor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					LoginCorretorGUI corretor = new LoginCorretorGUI();
	                corretor.newScreen();
	                frmUsuario.dispose();
				} catch (Exception e2) {
                    e2.printStackTrace();
				}
			}
		});
		botaoAreaCorretor.setBounds(35, 242, 183, 30);
		panel.add(botaoAreaCorretor);
		
		JTextArea textAreaChatBot = new JTextArea();
		textAreaChatBot.setFont(new Font("Monospaced", Font.BOLD, 17));
		textAreaChatBot.setBounds(248, 89, 706, 420);
		panel.add(textAreaChatBot);
		
		JButton botaoEnviarMensagem = new JButton();
		botaoEnviarMensagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String text = textMensagem.getText();
				respostaMarina("Você: " + text + "\n");
				conversaChat(text);
				textMensagem.setText("");
		
		}

		public void respostaMarina(String mensagem) {
			textAreaChatBot.append(mensagem);
		}

		private void conversaChat(String mensagem) {
			mensagem = textMensagem.getText();

			String resposta = "Desculpe, não entendi.";
			
			String cpf = null, Nome = null, dtNascimento = null, email = null, genero = null, telefone = null;
		
			// Exemplo simples de resposta com base na mensagem do usuário

			if (mensagem.equalsIgnoreCase("Olá" + "Oi")) {
				resposta = "\nInsira seu CPF.";
				
			} else if (mensagem.equalsIgnoreCase("50020030011")) {
				resposta = "Certo! Insira seu nome: \n";
				
			} else if (mensagem.equalsIgnoreCase("Rafael Forti")) {
				resposta = "Coloque sua data de nascimento: \n";
				
			} else if (mensagem.equalsIgnoreCase("11/01/2005")) {
				resposta = "Insira seu e-mail: \n";
				
			} else if (mensagem.equalsIgnoreCase("rafael@gmail.com")) {
				resposta = "Coloque seu número de telefone: \n";
				
			} else if (mensagem.equalsIgnoreCase("11963284175")) {
				resposta = "Coloque seu gênero: \n";
				
			} else if (mensagem.equalsIgnoreCase("Masculino")) {
				resposta = "Suas informações foram enviadas! Em breve entraremos em contato. ";
			}
			
			String[] dadosBot = {};

			respostaMarina("Chatbot: " + resposta);

		}
	});
		
		botaoEnviarMensagem.setForeground(new Color(0, 153, 102));
		botaoEnviarMensagem.setBackground(new Color(0, 153, 102));
		botaoEnviarMensagem.setIcon(new ImageIcon(ChatbotGUI.class.getResource("/br/com/tokio/images/botao_enviar.png")));
		botaoEnviarMensagem.setBounds(942, 520, 32, 30);
		panel.add(botaoEnviarMensagem);
		
		JLabel labelMarinaIcone = new JLabel("");
		labelMarinaIcone.setIcon(new ImageIcon(ChatbotGUI.class.getResource("/br/com/tokio/images/marinaaaa.png")));
		labelMarinaIcone.setBounds(268, -13, 99, 115);
		panel.add(labelMarinaIcone);
		
		JLabel labelMensagemMarina = new JLabel("Olá, eu sou a Marina e vou te ajudar na cotação e na contratação do seu seguro!");
		labelMensagemMarina.setForeground(Color.WHITE);
		labelMensagemMarina.setFont(new Font("Arial", Font.BOLD, 15));
		labelMensagemMarina.setBounds(350, 11, 624, 59);
		panel.add(labelMensagemMarina);
		
		JLabel labelFundoGradient = new JLabel("");
		labelFundoGradient.setIcon(new ImageIcon(ChatbotGUI.class.getResource("/br/com/tokio/images/fundo_login_maior.png")));
		labelFundoGradient.setBounds(0, 0, 984, 561);
		panel.add(labelFundoGradient);
		
	}

	protected void dispose() {
		// TODO Auto-generated method stub
		
	}
}
