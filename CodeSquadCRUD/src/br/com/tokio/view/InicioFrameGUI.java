package br.com.tokio.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class InicioFrameGUI {

	public JFrame frameInicio;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioFrameGUI window = new InicioFrameGUI();
					window.frameInicio.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public InicioFrameGUI() {
		initialize();
	}

	private void initialize() {
		frameInicio = new JFrame();
		frameInicio.setIconImage(Toolkit.getDefaultToolkit().getImage(InicioFrameGUI.class.getResource("/br/com/tokio/images/logo_tokio.png")));
		frameInicio.setTitle("TOKIO MARINE SEGURADORA\r\n");
		frameInicio.setBounds(100, 100, 1000, 600);
		frameInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameInicio.getContentPane().setLayout(null);
		
		JPanel panel_principal = new JPanel();
		panel_principal.setBounds(0, 0, 986, 563);
		frameInicio.getContentPane().add(panel_principal);
		panel_principal.setLayout(null);
		
		JButton botaoComecar = new JButton("Vamos começar?");
		botaoComecar.setBackground(new Color(51, 204, 102));
		botaoComecar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioFrameGUI corretor = new UsuarioFrameGUI();
                corretor.newScreen();
                frameInicio.dispose();
			}
		});
		
		JLabel labelCodeSquadLogo = new JLabel("");
		labelCodeSquadLogo.setIcon(new ImageIcon(InicioFrameGUI.class.getResource("/br/com/tokio/images/CodeSquadLogo.png")));
		labelCodeSquadLogo.setBounds(806, 377, 170, 175);
		panel_principal.add(labelCodeSquadLogo);
		
		JLabel labelTitulo = new JLabel("Seja muito bem-vindo(a) ao nosso CRUD!");
		labelTitulo.setForeground(new Color(255, 255, 255));
		labelTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelTitulo.setBounds(354, 116, 408, 54);
		panel_principal.add(labelTitulo);
		
		JLabel labelSubTitulo = new JLabel("Code Squad - Sementes do Brasil Tech");
		labelSubTitulo.setFont(new Font("Tahoma", Font.BOLD, 26));
		labelSubTitulo.setForeground(new Color(255, 255, 255));
		labelSubTitulo.setBounds(295, 41, 567, 104);
		panel_principal.add(labelSubTitulo);
		botaoComecar.setFont(new Font("Arial", Font.BOLD, 14));
		botaoComecar.setBounds(413, 273, 268, 72);
		panel_principal.add(botaoComecar);
		
		JLabel labelMarinaImagem = new JLabel("");
		labelMarinaImagem.setIcon(new ImageIcon(InicioFrameGUI.class.getResource("/br/com/tokio/images/marinona.png")));
		labelMarinaImagem.setBounds(10, 27, 277, 536);
		panel_principal.add(labelMarinaImagem);
		
		JLabel labelFundoGradient = new JLabel("");
		labelFundoGradient.setIcon(new ImageIcon(InicioFrameGUI.class.getResource("/br/com/tokio/images/fundo_login_maior.png")));
		labelFundoGradient.setBounds(0, 0, 986, 563);
		panel_principal.add(labelFundoGradient);
	}
}
