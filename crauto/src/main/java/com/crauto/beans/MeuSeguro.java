package com.crauto.beans;

import java.util.Date;

public class MeuSeguro {
	
	private int idMeuSeguro;
	private int idUsuario;
	private int idMeuCarro;
	private String nomeCorretor;
	private String telefone;
	private Date dataVencimento;
	
	public MeuSeguro() {
		super();
	
	}
	
	

	public MeuSeguro(int idMeuSeguro, int idUsuario, int idMeuCarro, String nomeCorretor, String telefone,
			Date dataVencimento) {
		super();
		this.idMeuSeguro = idMeuSeguro;
		this.idUsuario = idUsuario;
		this.idMeuCarro = idMeuCarro;
		this.nomeCorretor = nomeCorretor;
		this.telefone = telefone;
		this.dataVencimento = dataVencimento;
	}



	public int getIdMeuSeguro() {
		return idMeuSeguro;
	}



	public void setIdMeuSeguro(int idMeuSeguro) {
		this.idMeuSeguro = idMeuSeguro;
	}



	public int getIdUsuario() {
		return idUsuario;
	}



	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}



	public int getIdMeuCarro() {
		return idMeuCarro;
	}



	public void setIdMeuCarro(int idMeuCarro) {
		this.idMeuCarro = idMeuCarro;
	}



	public String getNomeCorretor() {
		return nomeCorretor;
	}



	public void setNomeCorretor(String nomeCorretor) {
		this.nomeCorretor = nomeCorretor;
	}



	public String getTelefone() {
		return telefone;
	}



	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}



	public Date getDataVencimento() {
		return dataVencimento;
	}



	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	
	
	
	
	
}
