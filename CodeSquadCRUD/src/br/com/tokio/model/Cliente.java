//Cadastro do usuário.

package br.com.tokio.model;

import java.sql.Date;

public class Cliente {

	private String cpfCliente, nomeCliente, dataNascimento, emailCliente, telefoneCliente, generoCliente;
	private Date data;

	public Cliente(String cpfCliente, String nomeCliente, String dataNascimento, String emailCliente,
			String telefoneCliente, String generoCliente) {
		this.cpfCliente = cpfCliente;
		this.nomeCliente = nomeCliente;
		this.dataNascimento = dataNascimento;
		this.emailCliente = emailCliente;
		this.telefoneCliente = telefoneCliente;
		this.generoCliente = generoCliente;
		this.data = new Date(System.currentTimeMillis());

	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public String getTelefoneCliente() {
		return telefoneCliente;
	}

	public void setTelefoneCliente(String telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}

	public String getGeneroCliente() {
		return generoCliente;
	}

	public void setGeneroCliente(String generoCliente) {
		this.generoCliente = generoCliente;
	}

	public Date getDataCadastro() {
		return data;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.data = dataCadastro;
	}

	public Cliente() {
		// CONSTRUTOR VAZIO
	}

}
