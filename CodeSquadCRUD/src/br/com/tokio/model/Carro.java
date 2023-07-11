package br.com.tokio.model;

public class Carro {

	private int anoCarro, codigoContrato;

	private String placaCarro, modeloCarro, marcaCarro, corCarro, tipoCombustivelCarro, cepPernoiteCarro,
			proprietarioCarro;

	public Carro(String placaCarro, int anoCarro, String modeloCarro, String marcaCarro,
			String corCarro, String tipoCombustivelCarro, String cepPernoiteCarro, String proprietarioCarro, int codigoContrato) {

		this.anoCarro = anoCarro;
		this.placaCarro = placaCarro;
		this.modeloCarro = modeloCarro;
		this.marcaCarro = marcaCarro;
		this.corCarro = corCarro;
		this.tipoCombustivelCarro = tipoCombustivelCarro;
		this.cepPernoiteCarro = cepPernoiteCarro;
		this.proprietarioCarro = proprietarioCarro;
		this.codigoContrato = codigoContrato;
	}
	
	public Carro() {
		// TODO Auto-generated constructor stub
	}
	
	public int getCodigoContrato() {
		return codigoContrato;
	}

	public void setCodigoContrato(int codigoContrato) {
		this.codigoContrato = codigoContrato;
	}


	public int getAnoCarro() {
		return anoCarro;
	}

	public void setAnoCarro(int anoCarro) {
		this.anoCarro = anoCarro;
	}

	public String getPlacaCarro() {
		return placaCarro;
	}

	public void setPlacaCarro(String placaCarro) {
		this.placaCarro = placaCarro;
	}

	public String getModeloCarro() {
		return modeloCarro;
	}

	public void setModeloCarro(String modeloCarro) {
		this.modeloCarro = modeloCarro;
	}

	public String getMarcaCarro() {
		return marcaCarro;
	}

	public void setMarcaCarro(String marcaCarro) {
		this.marcaCarro = marcaCarro;
	}

	public String getCorCarro() {
		return corCarro;
	}

	public void setCorCarro(String corCarro) {
		this.corCarro = corCarro;
	}

	public String getTipoCombustivelCarro() {
		return tipoCombustivelCarro;
	}

	public void setTipoCombustivelCarro(String tipoCombustivelCarro) {
		this.tipoCombustivelCarro = tipoCombustivelCarro;
	}

	public String getCepPernoiteCarro() {
		return cepPernoiteCarro;
	}

	public void setCepPernoiteCarro(String cepPernoiteCarro) {
		this.cepPernoiteCarro = cepPernoiteCarro;
	}

	public String getProprietarioCarro() {
		return proprietarioCarro;
	}

	public void setProprietarioCarro(String proprietarioCarro) {
		this.proprietarioCarro = proprietarioCarro;
	}

}
