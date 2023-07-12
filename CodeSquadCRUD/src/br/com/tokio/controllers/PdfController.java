package br.com.tokio.controllers;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.swing.JLabel;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import br.com.tokio.model.Carro;
import br.com.tokio.model.Cliente;
import br.com.tokio.model.Seguro;
import br.com.tokio.repository.CarroDAO;
import br.com.tokio.repository.ClienteDAO;
import br.com.tokio.repository.SeguroDAO;

public class PdfController {
	
	public void construirPdf(JLabel cpf, JLabel cdContrato) {
		String cpfCli = cpf.getText(); 
		String codigoContrato = cdContrato.getText();
		
		ClienteDAO daoCli = new ClienteDAO();
		SeguroDAO daoCon = new SeguroDAO();
		CarroDAO daoCar = new CarroDAO();
		
		Cliente cliente = daoCli.selectByCPF(cpfCli);
		Seguro seguro = daoCon.selectByContrato(cpfCli);
		Carro carro = daoCar.selectByContrato(codigoContrato);
		
				
				
		Document contrato = new Document();
		
		try {
			PdfWriter.getInstance(contrato, new FileOutputStream("C:\\Users\\User\\Desktop\\contrato_seguro.pdf"));
			contrato.open();
			
			 // adicionando um parágrafo no documento
			contrato.add(new Paragraph("CODESQUAD®, 2023."));
			contrato.add(new Paragraph("\n"));
			contrato.add(new Paragraph("CONTRATO DO SEGURO AUTOMOTIVO"));
			contrato.add(new Paragraph("\n"));
			contrato.add(new Paragraph("Código do Contrato: " + seguro.getCodigoContrato()));
			contrato.add(new Paragraph("Corretor responsável: " + seguro.getEmailCorretor()));
			contrato.add(new Paragraph("________________________"));
			contrato.add(new Paragraph("\n"));
			contrato.add(new Paragraph("Nome do cliente: " + cliente.getNomeCliente()));
			contrato.add(new Paragraph("CPF: " + cliente.getCpfCliente()));
			contrato.add(new Paragraph("Telefone: " + cliente.getTelefoneCliente()));
			contrato.add(new Paragraph("Data de nascimento: " + cliente.getDataNascimento()));
            contrato.add(new Paragraph("E-mail: " + cliente.getEmailCliente()));
            contrato.add(new Paragraph("\n_________________________\n"));
            contrato.add(new Paragraph("Dados do veículo:"));
            contrato.add(new Paragraph("----------------------------"));
            contrato.add(new Paragraph("Tipo do veículo: " + seguro.getTipoSeguro()));
            contrato.add(new Paragraph("Placa do veículo: " + carro.getPlacaCarro()));
            contrato.add(new Paragraph("Marca: " + carro.getMarcaCarro()));
            contrato.add(new Paragraph("Modelo: " + carro.getModeloCarro()));
            contrato.add(new Paragraph("Ano: " + carro.getAnoCarro()));
            contrato.add(new Paragraph("Uso do veículo: " + carro.getProprietarioCarro()));
            
            contrato.close();
			
			
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
		
	}
	
}
