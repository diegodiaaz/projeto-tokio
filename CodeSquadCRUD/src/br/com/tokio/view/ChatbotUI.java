package br.com.tokio.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import br.com.tokio.connection.ConnectionFactory;
import br.com.tokio.repository.ChatbotDAO;

public class ChatbotUI extends JFrame {

	private Connection conexao;
	private JTextArea chatArea;
	private JTextField inputField;
	private JButton sendButton;
	ChatbotDAO chatbot = new ChatbotDAO();

	public void Chatbot() {
		this.conexao = new ConnectionFactory().conectar();
	}

	public ChatbotUI() {
		setTitle("Chatbot");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		chatArea = new JTextArea();
		chatArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(chatArea);
		add(scrollPane, BorderLayout.CENTER);

		JPanel inputPanel = new JPanel(new BorderLayout());
		inputField = new JTextField();
		sendButton = new JButton("Enviar");
		sendButton.addActionListener(new SendButtonListener());

		inputPanel.add(inputField, BorderLayout.CENTER);
		inputPanel.add(sendButton, BorderLayout.EAST);
		add(inputPanel, BorderLayout.SOUTH);

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private class SendButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String message = inputField.getText();
			appendToChatArea("Você: " + message);
			processMessage(message);
			inputField.setText("");
		}
	}

	public void appendToChatArea(String message) {
		chatArea.append(message + "\n");
	}

	private void processMessage(String message) {
		message = inputField.getText();

		String resposta = "Desculpe, não entendi.";

		// Exemplo simples de resposta com base na mensagem do usuário

		if (message.equalsIgnoreCase("Olá" + "Oi")) {
			resposta = "Olá, qual o seu nome?";
		} else if (message.equalsIgnoreCase(inputField.getText())) {
			chatbot.insertDadosCliente(message);
			resposta = "Eu sou o Chatbot.";
			chatbot.insertMensagem(message);
		} else if (message.equalsIgnoreCase("Tchau")) {
			resposta = "Até mais!";
		}

		appendToChatArea("Chatbot: " + resposta);

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(ChatbotUI::new);
	}
}
