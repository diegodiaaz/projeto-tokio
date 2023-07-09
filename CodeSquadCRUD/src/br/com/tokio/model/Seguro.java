package br.com.tokio.model;

public class Seguro {

	private String tipoSeguro, cpfCliente;

	public Seguro(String tipoSeguro, String cpfCliente) {
		this.tipoSeguro = tipoSeguro;

	}

	public Seguro() {
		// CONSTRUTOR VAZIO
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

	public void setTipoSeguro(String tipoSeguro) {
		this.tipoSeguro = tipoSeguro;
	}

}