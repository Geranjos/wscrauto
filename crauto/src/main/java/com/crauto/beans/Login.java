package com.crauto.beans;

public class Login {

	private int idlogin;
	private int idUsuario;
	private String login;
	private String senha;
	
	
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
	public Login( String login, String senha) {
		super();
		this.login = login;
		this.senha = senha;
	}




	public Login(int idlogin, int idUsuario, String login, String senha) {
		super();
		this.idlogin = idlogin;
		this.idUsuario = idUsuario;
		this.login = login;
		this.senha = senha;
	}




	public int getIdlogin() {
		return idlogin;
	}




	public void setIdlogin(int idlogin) {
		this.idlogin = idlogin;
	}




	public int getIdUsuario() {
		return idUsuario;
	}




	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}




	public String getLogin() {
		return login;
	}




	public void setLogin(String login) {
		this.login = login;
	}




	public String getSenha() {
		return senha;
	}




	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
