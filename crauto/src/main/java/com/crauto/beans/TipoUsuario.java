package com.crauto.beans;

public class TipoUsuario {

	private int idTipoUsuario;
	private String Descricao;
	
	public TipoUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public TipoUsuario(int idTipoUsuario, String descricao) {
		super();
		this.idTipoUsuario = idTipoUsuario;
		Descricao = descricao;
	}


	public int getIdTipoUsuario() {
		return idTipoUsuario;
	}


	public void setIdTipoUsuario(int idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}


	public String getDescricao() {
		return Descricao;
	}


	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	
	
	
	
}
