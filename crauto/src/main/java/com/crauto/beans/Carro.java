package com.crauto.beans;

import java.util.Date;

//@XmlRootElement
public class Carro {
	
	private int idCarro;
	
	private int idFabcar;
	
	private String modelo;
	private Date AnoModelo;
	
	public Carro() {
		super();
		
	}

	public Carro(int idCarro, int idFabcar, int idRevisaoProgr, String modelo, Date anoModelo) {
		super();
		this.idCarro = idCarro;
		this.idFabcar = idFabcar;
	
		this.modelo = modelo;
		AnoModelo = anoModelo;
	}

	public int getIdCarro() {
		return idCarro;
	}

	public void setIdCarro(int idCarro) {
		this.idCarro = idCarro;
	}

	public int getIdFabcar() {
		return idFabcar;
	}

	public void setIdFabcar(int idFabcar) {
		this.idFabcar = idFabcar;
	}

	
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Date getAnoModelo() {
		return AnoModelo;
	}

	public void setAnoModelo(Date anoModelo) {
		AnoModelo = anoModelo;
	}
	
	
	
	

}
