package br.com.tokio.model;

public class Moto {
	private int idMoto, anoMoto, contratoMoto;
	private String placaMoto, modeloMoto, marcaMoto, corMoto, tipoCombustivelMoto, cepPernoiteMoto, proprietarioMoto;

	public Moto(int idMoto, int anoMoto, int contratoMoto, String placaMoto, String modeloMoto, String marcaMoto,
			String corMoto, String tipoCombustivelMoto, String cepPernoiteMoto, String proprietarioMoto) {
		this.idMoto = idMoto;
		this.anoMoto = anoMoto;
		this.contratoMoto = contratoMoto;
		this.placaMoto = placaMoto;
		this.modeloMoto = modeloMoto;
		this.marcaMoto = marcaMoto;
		this.corMoto = corMoto;
		this.tipoCombustivelMoto = tipoCombustivelMoto;
		this.cepPernoiteMoto = cepPernoiteMoto;
		this.proprietarioMoto = proprietarioMoto;
	}

	public int getIdMoto() {
		return idMoto;
	}

	public void setIdMoto(int idMoto) {
		this.idMoto = idMoto;
	}

	public int getAnoMoto() {
		return anoMoto;
	}

	public void setAnoMoto(int anoMoto) {
		this.anoMoto = anoMoto;
	}

	public int getContratoMoto() {
		return contratoMoto;
	}

	public void setContratoMoto(int ContratoMoto) {
		this.contratoMoto = ContratoMoto;
	}

	public String getPlacaMoto() {
		return placaMoto;
	}

	public void setPlacaMoto(String placaMoto) {
		this.placaMoto = placaMoto;
	}

	public String getModeloMoto() {
		return modeloMoto;
	}

	public void setModeloMoto(String modeloMoto) {
		this.modeloMoto = modeloMoto;
	}

	public String getMarcaMoto() {
		return marcaMoto;
	}

	public void setMarcaMoto(String marcaMoto) {
		this.marcaMoto = marcaMoto;
	}

	public String getCorMoto() {
		return corMoto;
	}

	public void setCorMoto(String corMoto) {
		this.corMoto = corMoto;
	}

	public String getTipoCombustivelMoto() {
		return tipoCombustivelMoto;
	}

	public void setTipoCombustivelMoto(String tipoCombustivelMoto) {
		this.tipoCombustivelMoto = tipoCombustivelMoto;
	}

	public String getCepPernoiteMoto() {
		return cepPernoiteMoto;
	}

	public void setCepPernoiteMoto(String cepPernoiteMoto) {
		this.cepPernoiteMoto = cepPernoiteMoto;
	}

	public String getProprietarioMoto() {
		return proprietarioMoto;
	}

	public void setProprietarioMoto(String proprietarioMoto) {
		this.proprietarioMoto = proprietarioMoto;
	}

	public Moto() {
		// CONSTRUTOR VAZIO
	}

}