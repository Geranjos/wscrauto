package com.crauto.beans;

public class Fabricante {

	private int idFabCar;
	private String descricao;
	private String foto;
	
	
	public Fabricante() {
		super();
		
	
	}


	public Fabricante(int idFabCar, String descricao, String foto) {
		super();
		this.idFabCar = idFabCar;
		this.descricao = descricao;
		this.foto = foto;
	}


	public Fabricante(String descricao, String foto) {
		super();
		this.descricao = descricao;
		this.foto = foto;
	}


	public int getIdFabCar() {
		return idFabCar;
	}


	public void setIdFabCar(int idFabCar) {
		this.idFabCar = idFabCar;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getFoto() {
		return foto;
	}


	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	
	
	
	
	
	
}
