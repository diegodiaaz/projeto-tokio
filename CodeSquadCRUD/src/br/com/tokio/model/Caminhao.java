package br.com.tokio.model;

public class Caminhao {

	private int idCaminhao, anoCaminhao, contratoCaminhao;
	private String placaCaminhao, modeloCaminhao, marcaCaminhao, corCaminhao, tipoCombustivelCaminhao,
			cepPernoiteCaminhao, proprietarioCaminhao, porteCaminhao;

	public Caminhao(int idCaminhao, int anoCaminhao, int contratoCaminhao, String placaCaminhao, String modeloCaminhao,
			String marcaCaminhao, String corCaminhao, String tipoCombustivelCaminhao, String cepPernoiteCaminhao,
			String proprietarioCaminhao, String porteCaminhao) {
		this.idCaminhao = idCaminhao;
		this.anoCaminhao = anoCaminhao;
		this.contratoCaminhao = contratoCaminhao;
		this.placaCaminhao = placaCaminhao;
		this.modeloCaminhao = modeloCaminhao;
		this.marcaCaminhao = marcaCaminhao;
		this.corCaminhao = corCaminhao;
		this.tipoCombustivelCaminhao = tipoCombustivelCaminhao;
		this.cepPernoiteCaminhao = cepPernoiteCaminhao;
		this.proprietarioCaminhao = proprietarioCaminhao;
		this.porteCaminhao = porteCaminhao;
	}

	public Caminhao() {
		// CONSTRUTOR VAZIO
	}

	public int getIdCaminhao() {
		return idCaminhao;
	}

	public void setIdCaminhao(int idCaminhao) {
		this.idCaminhao = idCaminhao;
	}

	public int getAnoCaminhao() {
		return anoCaminhao;
	}

	public void setAnoCaminhao(int anoCaminhao) {
		this.anoCaminhao = anoCaminhao;
	}

	public int getContratoCaminhao() {
		return contratoCaminhao;
	}

	public void setContratoCaminhao(int contratoCaminhao) {
		this.contratoCaminhao = contratoCaminhao;
	}

	public String getPlacaCaminhao() {
		return placaCaminhao;
	}

	public void setPlacaCaminhao(String placaCaminhao) {
		this.placaCaminhao = placaCaminhao;
	}

	public String getModeloCaminhao() {
		return modeloCaminhao;
	}

	public void setModeloCaminhao(String modeloCaminhao) {
		this.modeloCaminhao = modeloCaminhao;
	}

	public String getMarcaCaminhao() {
		return marcaCaminhao;
	}

	public void setMarcaCaminhao(String marcaCaminhao) {
		this.marcaCaminhao = marcaCaminhao;
	}

	public String getCorCaminhao() {
		return corCaminhao;
	}

	public void setCorCaminhao(String corCaminhao) {
		this.corCaminhao = corCaminhao;
	}

	public String getTipoCombustivelCaminhao() {
		return tipoCombustivelCaminhao;
	}

	public void setTipoCombustivelCaminhao(String tipoCombustivelCaminhao) {
		this.tipoCombustivelCaminhao = tipoCombustivelCaminhao;
	}

	public String getCepPernoiteCaminhao() {
		return cepPernoiteCaminhao;
	}

	public void setCepPernoiteCaminhao(String cepPernoiteCaminhao) {
		this.cepPernoiteCaminhao = cepPernoiteCaminhao;
	}

	public String getProprietarioCaminhao() {
		return proprietarioCaminhao;
	}

	public void setProprietarioCaminhao(String proprietarioCaminhao) {
		this.proprietarioCaminhao = proprietarioCaminhao;
	}

	public String getPorteCaminhao() {
		return porteCaminhao;
	}

	public void setPorteCaminhao(String porteCaminhao) {
		this.porteCaminhao = porteCaminhao;
	}

}
