package com.crauto.beans;

import java.util.Date;

public class MinhaRevisao {

	private int idMinhaRevisao;
	private int idPecaRevisao;
	private int idMeuCarro;
	private int idOrcamento;
	private Date RevisProg;
	
	public MinhaRevisao() {
		super();
	
	}

	public MinhaRevisao(int idMinhaRevisao, int idPecaRevisao, int idMeuCarro, int idOrcamento, Date revisProg) {
		super();
		this.idMinhaRevisao = idMinhaRevisao;
		this.idPecaRevisao = idPecaRevisao;
		this.idMeuCarro = idMeuCarro;
		this.idOrcamento = idOrcamento;
		RevisProg = revisProg;
	}

	public int getIdMinhaRevisao() {
		return idMinhaRevisao;
	}

	public void setIdMinhaRevisao(int idMinhaRevisao) {
		this.idMinhaRevisao = idMinhaRevisao;
	}

	public int getIdPecaRevisao() {
		return idPecaRevisao;
	}

	public void setIdPecaRevisao(int idPecaRevisao) {
		this.idPecaRevisao = idPecaRevisao;
	}

	public int getIdMeuCarro() {
		return idMeuCarro;
	}

	public void setIdMeuCarro(int idMeuCarro) {
		this.idMeuCarro = idMeuCarro;
	}

	public int getIdOrcamento() {
		return idOrcamento;
	}

	public void setIdOrcamento(int idOrcamento) {
		this.idOrcamento = idOrcamento;
	}

	public Date getRevisProg() {
		return RevisProg;
	}

	public void setRevisProg(Date revisProg) {
		RevisProg = revisProg;
	}
	
	
	
	
	
	
}
