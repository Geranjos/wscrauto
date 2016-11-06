package com.crauto.beans;

import java.util.Date;

public class RevisaoProgramada {

	
	private int idRevisaoProgramada;
	private String descricao;
	private Date dataProg;
	private int kmProgr;
	
	public RevisaoProgramada() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RevisaoProgramada(int idRevisaoProgramada, String descricao, Date dataProg, int kmProgr) {
		super();
		this.idRevisaoProgramada = idRevisaoProgramada;
		this.descricao = descricao;
		this.dataProg = dataProg;
		this.kmProgr = kmProgr;
	}

	public int getIdRevisaoProgramada() {
		return idRevisaoProgramada;
	}

	public void setIdRevisaoProgramada(int idRevisaoProgramada) {
		this.idRevisaoProgramada = idRevisaoProgramada;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataProg() {
		return dataProg;
	}

	public void setDataProg(Date dataProg) {
		this.dataProg = dataProg;
	}

	public int getKmProgr() {
		return kmProgr;
	}

	public void setKmProgr(int kmProgr) {
		this.kmProgr = kmProgr;
	}
	
	
	
	
	
	
}
