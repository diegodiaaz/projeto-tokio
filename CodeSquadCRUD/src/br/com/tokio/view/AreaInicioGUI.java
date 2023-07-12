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

public class AreaInicioGUI {

	public Connection conexao;

	
	public JFrame frmUsuario;
	ChatbotDAO chatbot = new ChatbotDAO();
	
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AreaInicioGUI corretor = new AreaInicioGUI();
					corretor.frmUsuario.setVisible(true);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AreaInicioGUI() {
		initialize();
	}
	

	private void initialize() {
		frmUsuario = new JFrame();
		frmUsuario.setForeground(new Color(0, 153, 102));
		frmUsuario.setFont(new Font("Arial", Font.BOLD, 15));
		frmUsuario.setIconImage(Toolkit.getDefaultToolkit().getImage(AreaInicioGUI.class.getResource("/br/com/tokio/images/logo_tokio.png")));
		frmUsuario.setTitle("TOKIO MARINE SEGURADORA");
		frmUsuario.setBounds(100, 100, 1000, 600);
		frmUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUsuario.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 102));
		panel.setBounds(0, 0, 984, 561);
		frmUsuario.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton botaoAjuda = new JButton("");
		botaoAjuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String caminho = "C:\\Users\\SCCP1910\\Desktop\\Documentação - Tokio Marine.pdf";

                File arquivo = new File(caminho);

                try {
                    Desktop.getDesktop().open(arquivo);
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, e, "Erro", JOptionPane.ERROR_MESSAGE);
                }
			}
		});
		
		JButton botaoVoltar = new JButton("");
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmUsuario.dispose();
				InsertClienteGUI insertCliente = new InsertClienteGUI();
				insertCliente.insertCliente.setVisible(true);
				
			}
		});
		botaoVoltar.setIcon(new ImageIcon(AreaInicioGUI.class.getResource("/br/com/tokio/images/botao_voltar.png")));
		botaoVoltar.setBounds(10, 23, 46, 23);
		panel.add(botaoVoltar);
		botaoAjuda.setIcon(new ImageIcon(AreaInicioGUI.class.getResource("/br/com/tokio/images/botao_info.png")));
		botaoAjuda.setForeground(new Color(52, 172, 132));
		botaoAjuda.setBackground(new Color(204, 196, 100));
		botaoAjuda.setBounds(888, 23, 63, 59);
		panel.add(botaoAjuda);
		
		JLabel lblMarina = new JLabel("");
		lblMarina.setIcon(new ImageIcon(AreaInicioGUI.class.getResource("/br/com/tokio/images/marinona.png")));
		lblMarina.setBounds(18, 49, 259, 512);
		panel.add(lblMarina);
		
		JLabel labelCodeSquadImage = new JLabel(""); 
		labelCodeSquadImage.setIcon(new ImageIcon(AreaInicioGUI.class.getResource("/br/com/tokio/images/CodeSquadLogo.png")));
		labelCodeSquadImage.setBounds(808, 382, 203, 170);
		panel.add(labelCodeSquadImage);
		
		JButton botaoAreaCliente = new JButton("");
		botaoAreaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrudClienteGUI clienteTela = new CrudClienteGUI();
				clienteTela.newScreen(null);
				frmUsuario.dispose();
			}
		});
		
		botaoAreaCliente.setIcon(new ImageIcon(AreaInicioGUI.class.getResource("/br/com/tokio/images/botao_cliente.png")));
		botaoAreaCliente.setBounds(355, 152, 183, 30);
		panel.add(botaoAreaCliente);
		
		JButton botaoAreaCorretor = new JButton("");
		botaoAreaCorretor.setIcon(new ImageIcon(AreaInicioGUI.class.getResource("/br/com/tokio/images/BOTAO_CORRETOR.png")));
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
		botaoAreaCorretor.setBounds(355, 273, 183, 30);
		panel.add(botaoAreaCorretor);
		
		JLabel labelMensagemMarina = new JLabel("Olá, você pode entrar como corretor ou cliente!");
		labelMensagemMarina.setForeground(Color.WHITE);
		labelMensagemMarina.setFont(new Font("Tahoma", Font.BOLD, 23));
		labelMensagemMarina.setBounds(197, 23, 624, 59);
		panel.add(labelMensagemMarina);
		
		JLabel labelFundoGradient = new JLabel("");
		labelFundoGradient.setIcon(new ImageIcon(AreaInicioGUI.class.getResource("/br/com/tokio/images/fundo_login_maior.png")));
		labelFundoGradient.setBounds(0, 0, 994, 561);
		panel.add(labelFundoGradient);
		
	}

	protected void dispose() {
		// TODO Auto-generated method stub
		
	}
}
