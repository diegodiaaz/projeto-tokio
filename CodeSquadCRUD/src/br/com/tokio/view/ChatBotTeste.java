package br.com.tokio.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.com.tokio.model.Chatbot;
import br.com.tokio.repository.ChatbotDAO;

public class ChatBotTeste {

	public JFrame frameChatTest;
	private JTextField textMensagem;
	ChatbotDAO chatbot = new ChatbotDAO();
	Chatbot chatCons = new Chatbot();
	String Nome = null, cpf = null, dtNascimento = null, email = null, genero = null, telefone = null;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatBotTeste window = new ChatBotTeste();
					window.frameChatTest.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChatBotTeste() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameChatTest = new JFrame();
		frameChatTest.setForeground(new Color(0, 153, 102));
		frameChatTest.setFont(new Font("Arial", Font.BOLD, 15));
		frameChatTest.setIconImage(Toolkit.getDefaultToolkit().getImage(ChatBotTest.class.getResource("/br/com/tokio/images/logo_tokio.png")));
		frameChatTest.setTitle("TOKIO MARINE SEGURADORA");
		frameChatTest.setBounds(100, 100, 1000, 600);
		frameChatTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameChatTest.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 102));
		panel.setBounds(0, 0, 984, 561);
		frameChatTest.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel labelCodeSquadImage = new JLabel(""); 
		labelCodeSquadImage.setIcon(new ImageIcon(ChatBotTest.class.getResource("/br/com/tokio/images/CodeSquadLogo.png")));
		labelCodeSquadImage.setBounds(35, 339, 203, 170);
		panel.add(labelCodeSquadImage);
		
		
		JTextArea textAreaChatBot = new JTextArea();
		textAreaChatBot.setFont(new Font("Monospaced", Font.BOLD, 17));
		textAreaChatBot.setBounds(248, 89, 706, 420);
		panel.add(textAreaChatBot);
	
		textMensagem = new JTextField();
		textMensagem.setHorizontalAlignment(SwingConstants.LEFT);
		textMensagem.setToolTipText("");
		textMensagem.setFont(new Font("Arial", Font.PLAIN, 12));
		textMensagem.setBounds(297, 520, 635, 30);
		panel.add(textMensagem);
		textMensagem.setColumns(10);
		
		JButton botaoEnviarMensagem = new JButton();
		botaoEnviarMensagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				


		
			}	
	});
		
		botaoEnviarMensagem.setForeground(new Color(0, 153, 102));
		botaoEnviarMensagem.setBackground(new Color(0, 153, 102));
		botaoEnviarMensagem.setIcon(new ImageIcon(ChatBotTest.class.getResource("/br/com/tokio/images/botao_enviar.png")));
		botaoEnviarMensagem.setBounds(942, 520, 32, 30);
		panel.add(botaoEnviarMensagem);
	}

	
}
