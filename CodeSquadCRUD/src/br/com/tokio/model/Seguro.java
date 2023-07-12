package br.com.tokio.model;

public class Seguro {

	private String tipoSeguro, cpfCliente, emailCorretor;
	private int codigoContrato;

	public Seguro(String tipoSeguro, String cpfCliente, String emailCorretor) {
		this.tipoSeguro = tipoSeguro;
		this.cpfCliente = cpfCliente;
		this.emailCorretor = emailCorretor;
	}
	
	public Seguro() {
		// CONSTRUTOR VAZIO
	}
	
	public String getEmailCorretor() {
		return emailCorretor;
	}

	public void setEmailCorretor(String emailCorretor) {
		this.emailCorretor = emailCorretor;
	}

	public String getTipoSeguro() {
		return tipoSeguro;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public int getCodigoContrato() {
		return codigoContrato;
	}

	public void setCodigoContrato(int codigoContrato) {
		this.codigoContrato = codigoContrato;
	}

	public void setTipoSeguro(String tipoSeguro) {
		this.tipoSeguro = tipoSeguro;
	}

	

	

}