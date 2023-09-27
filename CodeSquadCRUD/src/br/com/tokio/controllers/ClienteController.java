package br.com.tokio.controllers;

import java.util.List;

import br.com.tokio.model.Cliente;
import br.com.tokio.repository.ClienteDAO;
import br.com.tokio.view.InsertClienteGUI;

public class ClienteController {

	private String CPF;
	private Cliente cliente;
	private ClienteDAO clienteDAO;
	private InsertClienteGUI insertCliente;
	
	
	public void insertCliente(Cliente cliente) {
		Cliente infoCliente = new Cliente();
		
		if(infoCliente != null) {			
			clienteDAO.insertCadastroCliente(cliente);
		} else {
			System.out.println("Informações inválidas!");
		}
		
	}
	
	public List<Cliente> selectAllClientes(Cliente cliente) {
		return clienteDAO.selectAll();
	}
	
	public void selectSeguro() {
		Cliente clienteSeguro = new Cliente();
		
		if(clienteSeguro != null) {
			clienteDAO.selectTipoSeguro(CPF);
		}
	}
	
	public void selectCpf() {
		Cliente clienteCpf = new Cliente();
		
		if(clienteCpf != null) {
			clienteDAO.selectByCPF(CPF);
		}
	}
	
	public void updateCliente() {
		clienteDAO.updateCliente(cliente);
	}
	
	
	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	
}
