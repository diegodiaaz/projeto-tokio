package br.com.tokio.model;

import br.com.tokio.util.CriptografiaUtil;

public class Corretor {
	private String emailCorretor, senhaCorretor;

	public Corretor(String emailCorretor, String senhaCorretor) {
		this.emailCorretor = emailCorretor;
		setSenhaCorretor(senhaCorretor);
	}

	public String getEmailCorretor() {
		return emailCorretor;
	}

	public void setEmailCorretor(String emailCorretor) {
		this.emailCorretor = emailCorretor;
	}

	public String getSenhaCorretor() {
		return senhaCorretor;
	}

	public void setSenhaCorretor(String senhaCorretor) {
		try {
			this.senhaCorretor = CriptografiaUtil.criptografar(senhaCorretor);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Corretor() {
		// CONSTRUTOR VAZIO
	}

}