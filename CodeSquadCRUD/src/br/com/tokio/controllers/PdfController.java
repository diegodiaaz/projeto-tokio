//package br.com.tokio.controllers;
//
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.pdf.PdfWriter;
//
//import br.com.tokio.model.Cliente;
//import br.com.tokio.repository.ClienteDAO;
//
//public class PdfController {
//	
//	public void construirPdf() {
//		
//		ClienteController clienteC = new ClienteController();
//		String cpfCli = clienteC.getCPF();
//		
//		ClienteDAO daoCli = new ClienteDAO();
//		Cliente cliente = daoCli.selectByCPF(cpfCli);
//		
//				
//				
//		Document contrato = new Document();
//		
//		try {
//			PdfWriter.getInstance(contrato, new FileOutputStream("C:\\Users\\SCCP1910\\Desktop\\Contrato.pdf"));
//			contrato.open();
//			
//			 // adicionando um parágrafo no documento
//			contrato.add(new Paragraph("CODESQUAD®, 2023."));
//			contrato.add(new Paragraph("\n"));
//			contrato.add(new Paragraph("CONTRATO DO SEGURO AUTOMOTIVO"));
//			contrato.add(new Paragraph("________________________"));
//			contrato.add(new Paragraph("\n"));
//			contrato.add(new Paragraph("Nome do cliente: " + cliente.getNomeCliente()));
//			contrato.add(new Paragraph("CPF: " + cliente.getCpfCliente()));
//			contrato.add(new Paragraph("Telefone: " + cliente.getTelefoneCliente()));
//			contrato.add(new Paragraph("Data de nascimento: " + cliente.getDataNascimento()));
//            contrato.add(new Paragraph("E-mail: " + cliente.getEmailCliente()));
//            contrato.add(new Paragraph("\n_________________________\n"));
//            contrato.add(new Paragraph("Dados do veículo:"));
//            contrato.add(new Paragraph("----------------------------"));
//            contrato.add(new Paragraph("Tipo do veículo: "));
//            contrato.add(new Paragraph("Placa do veículo: "));
//            contrato.add(new Paragraph("Marca: "));
//            contrato.add(new Paragraph("Modelo: "));
//            contrato.add(new Paragraph("Ano: "));
//            
//            contrato.close();
//			
//			
//		} catch (FileNotFoundException | DocumentException e) {
//			e.printStackTrace();
//		}
//		
//	}
//	
//}
