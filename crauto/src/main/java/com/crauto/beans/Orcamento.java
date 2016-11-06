package com.crauto.beans;

import java.util.Date;

public class Orcamento {

	public int idOrcamento;
	public int idUsuario;
	public int idItemOrca;
	public int idMeuCarro;
	public boolean revisaoProgramada;
	public String descricao;
	public Date data;
	public long precoTotal;
	public String condicaoPagamento;
	
	public Orcamento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orcamento(int idOrcamento, int idUsuario, int idItemOrca, int idMeuCarro, boolean revisaoProgramada,
			String descricao, Date data, long precoTotal, String condicaoPagamento) {
		super();
		this.idOrcamento = idOrcamento;
		this.idUsuario = idUsuario;
		this.idItemOrca = idItemOrca;
		this.idMeuCarro = idMeuCarro;
		this.revisaoProgramada = revisaoProgramada;
		this.descricao = descricao;
		this.data = data;
		this.precoTotal = precoTotal;
		this.condicaoPagamento = condicaoPagamento;
	}

	public int getIdOrcamento() {
		return idOrcamento;
	}

	public void setIdOrcamento(int idOrcamento) {
		this.idOrcamento = idOrcamento;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdItemOrca() {
		return idItemOrca;
	}

	public void setIdItemOrca(int idItemOrca) {
		this.idItemOrca = idItemOrca;
	}

	public int getIdMeuCarro() {
		return idMeuCarro;
	}

	public void setIdMeuCarro(int idMeuCarro) {
		this.idMeuCarro = idMeuCarro;
	}

	public boolean isRevisaoProgramada() {
		return revisaoProgramada;
	}

	public void setRevisaoProgramada(boolean revisaoProgramada) {
		this.revisaoProgramada = revisaoProgramada;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public long getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(long precoTotal) {
		this.precoTotal = precoTotal;
	}

	public String getCondicaoPagamento() {
		return condicaoPagamento;
	}

	public void setCondicaoPagamento(String condicaoPagamento) {
		this.condicaoPagamento = condicaoPagamento;
	}
	
	
	
}
