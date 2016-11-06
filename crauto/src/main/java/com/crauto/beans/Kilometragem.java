package com.crauto.beans;
import java.util.Date;

public class Kilometragem {

	public int idKm;
	public Date data;
	public int kilometragem;
	public int idMeucarro;
	
	public Kilometragem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Kilometragem(int idKm, Date data, int kilometragem, int idMeucarro) {
		super();
		this.idKm = idKm;
		this.data = data;
		this.kilometragem = kilometragem;
		this.idMeucarro = idMeucarro;
	}

	public int getIdKm() {
		return idKm;
	}

	public void setIdKm(int idKm) {
		this.idKm = idKm;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getKilometragem() {
		return kilometragem;
	}

	public void setKilometragem(int kilometragem) {
		this.kilometragem = kilometragem;
	}

	public int getIdMeucarro() {
		return idMeucarro;
	}

	public void setIdMeucarro(int idMeucarro) {
		this.idMeucarro = idMeucarro;
	}
	
	
	
	
	
	
}
