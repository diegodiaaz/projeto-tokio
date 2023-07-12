package br.com.tokio.model;

public class Chatbot {

	
	String nome, cpf, dtNascimento, email, telefone;

	public Chatbot(String nome, String cpf, String dtNascimento, String email, String telefone) {
		
		this.nome = nome;
		this.cpf = cpf;
		this.dtNascimento = dtNascimento;
		this.email = email;
		this.telefone = telefone;
		
	}
	
	

	public Chatbot() {

		//CONTRUTOR VAZIO
		
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	
	
}