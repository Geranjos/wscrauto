package com.crauto.beans;

public class itemOrcamento {

	public int idItemOrcamento;
	public int idOrcamento;
	public int idPecaCarro;
	public int numeroSequencial;
	public String descricao;
	public long valorUnitario;
	public int quantidade;
	public long valor;
	
	public itemOrcamento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public itemOrcamento(int idItemOrcamento, int idOrcamento, int idPecaCarro, int numeroSequencial, String descricao,
			long valorUnitario, int quantidade, long valor) {
		super();
		this.idItemOrcamento = idItemOrcamento;
		this.idOrcamento = idOrcamento;
		this.idPecaCarro = idPecaCarro;
		this.numeroSequencial = numeroSequencial;
		this.descricao = descricao;
		this.valorUnitario = valorUnitario;
		this.quantidade = quantidade;
		this.valor = valor;
	}

	public int getIdItemOrcamento() {
		return idItemOrcamento;
	}

	public void setIdItemOrcamento(int idItemOrcamento) {
		this.idItemOrcamento = idItemOrcamento;
	}

	public int getIdOrcamento() {
		return idOrcamento;
	}

	public void setIdOrcamento(int idOrcamento) {
		this.idOrcamento = idOrcamento;
	}

	public int getIdPecaCarro() {
		return idPecaCarro;
	}

	public void setIdPecaCarro(int idPecaCarro) {
		this.idPecaCarro = idPecaCarro;
	}

	public int getNumeroSequencial() {
		return numeroSequencial;
	}

	public void setNumeroSequencial(int numeroSequencial) {
		this.numeroSequencial = numeroSequencial;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public long getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(long valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public long getValor() {
		return valor;
	}

	public void setValor(long valor) {
		this.valor = valor;
	}
	
	
	
	
}
