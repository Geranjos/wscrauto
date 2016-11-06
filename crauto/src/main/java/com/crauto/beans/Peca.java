package com.crauto.beans;

import java.util.Date;

public class Peca {

	private int idPeca;
	private String descricao;
	private int durabiliKm;
	private Date durabilidata;
	
	public Peca() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Peca(int idPeca, String descricao, int durabiliKm, Date durabilidata) {
		super();
		this.idPeca = idPeca;
		this.descricao = descricao;
		this.durabiliKm = durabiliKm;
		this.durabilidata = durabilidata;
	}

	public int getIdPeca() {
		return idPeca;
	}

	public void setIdPeca(int idPeca) {
		this.idPeca = idPeca;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getDurabiliKm() {
		return durabiliKm;
	}

	public void setDurabiliKm(int durabiliKm) {
		this.durabiliKm = durabiliKm;
	}

	public Date getDurabilidata() {
		return durabilidata;
	}

	public void setDurabilidata(Date durabilidata) {
		this.durabilidata = durabilidata;
	}
	
	
	
	
}
