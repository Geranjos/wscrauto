package com.crauto.beans;

public class Usuario {
private int idUsuario;
private int idMeucarro;
private int idTipoUsuario;
private String nome;
private String email;
private String foto;
private String documento;
private int tipoPessoa;
private String endereco;
private String numero;
private String bairro;
private String cidade;
private String uf;
private String cep;

public Usuario() {
	super();
	// TODO Auto-generated constructor stub
}

public Usuario(int idUsuario, String nome) {
	super();
	this.idUsuario = idUsuario;
	this.nome = nome;
}

public Usuario(int idUsuario, int idMeucarro, int idTipoUsuario, String nome, String email, String foto,
		String documento, int tipoPessoa, String endereco, String numero, String bairro, String cidade, String uf,
		String cep) {
	super();
	this.idUsuario = idUsuario;
	this.idMeucarro = idMeucarro;
	this.idTipoUsuario = idTipoUsuario;
	this.nome = nome;
	this.email = email;
	this.foto = foto;
	this.documento = documento;
	this.tipoPessoa = tipoPessoa;
	this.endereco = endereco;
	this.numero = numero;
	this.bairro = bairro;
	this.cidade = cidade;
	this.uf = uf;
	this.cep = cep;
}

public int getIdUsuario() {
	return idUsuario;
}

public void setIdUsuario(int idUsuario) {
	this.idUsuario = idUsuario;
}

public int getIdMeucarro() {
	return idMeucarro;
}

public void setIdMeucarro(int idMeucarro) {
	this.idMeucarro = idMeucarro;
}

public int getIdTipoUsuario() {
	return idTipoUsuario;
}

public void setIdTipoUsuario(int idTipoUsuario) {
	this.idTipoUsuario = idTipoUsuario;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getFoto() {
	return foto;
}

public void setFoto(String foto) {
	this.foto = foto;
}

public String getDocumento() {
	return documento;
}

public void setDocumento(String documento) {
	this.documento = documento;
}

public int getTipoPessoa() {
	return tipoPessoa;
}

public void setTipoPessoa(int tipoPessoa) {
	this.tipoPessoa = tipoPessoa;
}

public String getEndereco() {
	return endereco;
}

public void setEndereco(String endereco) {
	this.endereco = endereco;
}

public String getNumero() {
	return numero;
}

public void setNumero(String numero) {
	this.numero = numero;
}

public String getBairro() {
	return bairro;
}

public void setBairro(String bairro) {
	this.bairro = bairro;
}

public String getCidade() {
	return cidade;
}

public void setCidade(String cidade) {
	this.cidade = cidade;
}

public String getUf() {
	return uf;
}

public void setUf(String uf) {
	this.uf = uf;
}

public String getCep() {
	return cep;
}

public void setCep(String cep) {
	this.cep = cep;
}





}
