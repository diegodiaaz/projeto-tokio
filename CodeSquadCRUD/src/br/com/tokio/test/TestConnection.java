package br.com.tokio.test;

import br.com.tokio.model.Carro;
import br.com.tokio.model.Corretor;
import br.com.tokio.model.Seguro;
import br.com.tokio.repository.ClienteDAO;
import br.com.tokio.repository.CorretorDAO;
import br.com.tokio.repository.SeguroDAO;

public class TestConnection {

	public static void main(String[] args) {

		// --------- CLIENTE ----------- //
		ClienteDAO daoCliente = new ClienteDAO();

//		SeguroDAO daoSeguro = new SeguroDAO();
//		Seguro seguro = new Seguro(1, "24452799812", "AUTO", 1);
//		daoSeguro.insertCadastroSeguro(seguro);

		// -------- INSERT CLIENTE-------- TESTADO! //
//			

//		Cliente vinicius = new Cliente("35557777777", "vinicius", "05/11/2001", "vinicius@gmail.com", "11967274444",
//				"masculino");
//		daoCliente.insertCadastroCliente(vinicius);

/*		
		Cliente vitor = new Cliente("50422658925", "vitor", "11/11/2001", "vitor@gmail.com", "11967274422",
				"masculino");
		daoCliente.insertCadastroCliente(vitor);
*/
		
		// -------- DELETE CLIENTE --------- TESTADO! //
//		 daoCliente.deleteCliente("35557777777");

//		 --------SELECTALL CLIENTE-------- TESTADO! //

//		List<Cliente> lista = daoCliente.selectAll();
//
//		for (Cliente usuario : lista) {
//			System.out.println("Nome: " + usuario.getNomeCliente());
//			System.out.println("CPF: " + usuario.getCpfCliente());
//			System.out.println("Data Nascimento: " + usuario.getDataNascimento());
//			System.out.println("Email: " + usuario.getEmailCliente());
//			System.out.println("Telefone: " + usuario.getTelefoneCliente());
//			System.out.println("Gênero: " + usuario.getGeneroCliente());
//			System.out.println("Data de cadastro: " + usuario.getDataCadastro());
//			System.out.println("----------------");
//		}

//		 --------SELECTBYCPF CLIENTE-------- TESTADO! 
//		Cliente cliente = daoCliente.selectByCPF("35557777777");
//		System.out.println("Nome: " + cliente.getNomeCliente());
//		System.out.println("CPF: " + cliente.getCpfCliente());
//		System.out.println("Data Nascimento: " + cliente.getDataNascimento());
//		System.out.println("Email: " + cliente.getEmailCliente());
//		System.out.println("Telefone: " + cliente.getTelefoneCliente());
//		System.out.println("Gênero: " + cliente.getGeneroCliente());
//		System.out.println("Data de cadastro: " + cliente.getDataCadastro());

// 		--------UPDATE CLIENTE TESTADO!!--------
//		 Selecionando o usuário que já existe.
//		Cliente update = daoCliente.selectByCPF("35557777777");
//		update.setEmailCliente("ALTERADO@gmail.com");
//		daoCliente.updateCliente(update);

		// -------CARRO--------
//		CarroDAO daoCarro = new CarroDAO();

		// -----------INSERT CARRO----------------//
//		Carro carro = new Carro("QWX3433", 2020, "LOGAN", "RENAULT", "PRETO", "GASOLINA", "08554300", "Empresarial", 1025);
//		daoCarro.insertCadastroCarro(carro);

		// ----------SELECTBYPLACA CARRO------------/
//
//		Carro carro = daoCarro.selectByPlaca("QWX3433");
//		System.out.println("Placa: " + carro.getPlaca());
//		System.out.println("Ano de Fabricação: " + carro.getAnoCarro());
//		System.out.println("Modelo: " + carro.getModelo());
//		System.out.println("Marca: " + carro.getMarca());
//		System.out.println("Cor: " + carro.getCor());
//		System.out.println("Tipo de Combústivel: " + carro.getTipoCombustivel());
//		System.out.println("Cep PerNoite " + carro.getCepPerNoite());
//		System.out.println("Proprietario: " + carro.getProprietarioCarro());

//		 --------SELECTALL CARRO-------- 
//		List<Carro> lista = daoCarro.selectAllCarro();
//
//		for (Carro carrinho : lista) {
//			System.out.println("Placa: " + carrinho.getPlaca());
//			System.out.println("Ano de Fabricação: " + carrinho.getAnoCarro());
//			System.out.println("Modelo: " + carrinho.getModelo());
//			System.out.println("Marca: " + carrinho.getMarca());
//			System.out.println("Cor: " + carrinho.getCor());
//			System.out.println("Tipo de Combústivel: " + carrinho.getTipoCombustivel());
//			System.out.println("Cep PerNoite " + carrinho.getCepPerNoite());
//			System.out.println("Proprietario: " + carrinho.getProprietarioCarro());
//			System.out.println("-------------------------------------");
//			
//		}
		
		// ---------DELETE CARRO----------//
//		daoCarro.deleteCarro("ABC1234");	

		// ----------UPDATE CARRO----------- //
//		Carro carroUpdate = daoCarro.selectByPlaca("DVB5650");

//		carroUpdate.setCepPerNoite("08554300");

//		daoCarro.updateCarro(carroUpdate);

		// ---------- INSERT CAMINHAO----------- //

//		CaminhaoDAO daoCaminhao = new CaminhaoDAO();	
//		Caminhao caminhao = new Caminhao(1, "BVB0000", 2022, "Volvo FM" , "Elétrico", "08554300", "Volvo", "Prata",
//				"Pessoal", "Grande", 2);

//		daoCaminhao.insertCadastroCaminhao(caminhao);

		// ------SELECTBYPLACA CAMINHAO------ //
//		Caminhao caminhaozao = daoCaminhao.selectByPlaca("BVB0000");
//		System.out.println("Placa: " + caminhaozao.getPlaca());
//		System.out.println("Ano de Fabricação: " + caminhaozao.getAnoCaminhao());
//		System.out.println("Modelo: " + caminhaozao.getModelo());
//		System.out.println("Marca: " + caminhaozao.getMarca());
//		System.out.println("Cor: " + caminhaozao.getCor());
//		System.out.println("Tipo de Combústivel: " + caminhaozao.getTipoCombustivel());
//		System.out.println("Cep PerNoite: " + caminhaozao.getCepPerNoite());
//		System.out.println("Proprietario: " + caminhaozao.getProprietarioCaminhao());
//		System.out.println("Porte: " + caminhaozao.getPorte());

		// ---------- INSERT SEGURO ------------- //
//		SeguroDAO daoSeguro = new SeguroDAO();
//		Seguro seguro = new Seguro("Carro", "35557777777", "mariane@gmail.com");	
//		daoSeguro.insertCadastroSeguro(seguro);

		// ------SELECTALL CAMINHAO------ //

//		List<Caminhao> lista = daoCaminhao.selectAllCaminhao();
//
//		for (Caminhao caminhao : lista) {
//			System.out.println("Placa: " + caminhao.getPlaca());
//			System.out.println("Ano de Fabricação: " + caminhao.getAnoCaminhao());
//			System.out.println("Modelo: " + caminhao.getModelo());
//			System.out.println("Marca: " + caminhao.getMarca());
//			System.out.println("Cor: " + caminhao.getCor());
//			System.out.println("Tipo de Combústivel: " + caminhao.getTipoCombustivel());
//			System.out.println("Cep PerNoite " + caminhao.getCepPerNoite());
//			System.out.println("Proprietario: " + caminhao.getProprietarioCaminhao());
//			System.out.println("Grande: " + caminhao.getPorte());
//			System.out.println("-------------------------------------");
//
//		}

		// ---------DELETE CAMINHAO----------//
//		daoCaminhao.deleteCaminhao("BVB9898");

//		 ----------UPDATE CAMINHAO----------- //
//		Caminhao upCaminhao = daoCaminhao.selectByPlaca("BVB0000");

//		upCaminhao.setCepPerNoite("08554300");

//		daoCaminhao.updateCaminhao(upCaminhao);

		// --------INSERT CORRETOR ----------- //
//		CorretorDAO daoCorretor = new CorretorDAO();
//		Corretor Mariane = new Corretor("mariane@gmail.com", "Mariane", "1234");
//		daoCorretor.insertCorretor(Mariane);

//		CorretorDAO daoCorretor = new CorretorDAO();
//		Corretor lucas = new Corretor("lucas@gmail.com", "lucas", "1234");
//		daoCorretor.insertCorretor(lucas);
//		
//		CorretorDAO daoCorretor = new CorretorDAO();
//		Corretor admin = new Corretor("admin1", "1234");
//		daoCorretor.insertCorretor(admin);

		// ---------- SELECT TIPO SEGURO BY CPFCLIENTE -------- //
//		Cliente cliente = daoCliente.selectByCPF("25567899321");
//		System.out.println("E-mail cliente: " + cliente.getEmail());

		// ----------- INSERT TABELA SEGURO ------------ //
//		SeguroDAO daoSeguro = new SeguroDAO();
//		Seguro seguro = new Seguro();
//		Carro carro = new Carro();
//		Seguro seguroCarro = new Seguro(11, "25567899123", "Carro", 1);
//		daoSeguro.insertCadastroSeguro(seguroCarro);
		
//		daoSeguro.selectCdContrato("23345677898");
//		System.out.println("Codigo contrato: " + carro.getCodigoContrato());
		
//		daoSeguro.selectByContrato("1025");
//		System.out.println("Contrato: " + seguro.getTipoSeguro());

	}
}
