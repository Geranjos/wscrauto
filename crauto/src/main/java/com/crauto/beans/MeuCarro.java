package com.crauto.beans;

import java.util.Date;

public class MeuCarro {

	public int idMeuCarro;
	public int idUsuario;
	public int idMinhaRevisao;
	public String foto;
	public Date anoFabricacao;
	public String placa;
	public int renavan;
	public String chassi;
	public boolean vidroEletrico;
	public boolean arcondicionado;
	public boolean travaEletrica;
	public boolean direcaoHidraulica;
	public boolean direcaoHeletrica;
	public boolean sensoresEstacionamento;
	public boolean abs;
	public boolean airbag;
	
	public MeuCarro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MeuCarro(int idMeuCarro, int idUsuario, int idMinhaRevisao, String foto, Date anoFabricacao, String placa,
			int renavan, String chassi, boolean vidroEletrico, boolean arcondicionado, boolean travaEletrica,
			boolean direcaoHidraulica, boolean direcaoHeletrica, boolean sensoresEstacionamento, boolean abs,
			boolean airbag) {
		super();
		this.idMeuCarro = idMeuCarro;
		this.idUsuario = idUsuario;
		this.idMinhaRevisao = idMinhaRevisao;
		this.foto = foto;
		this.anoFabricacao = anoFabricacao;
		this.placa = placa;
		this.renavan = renavan;
		this.chassi = chassi;
		this.vidroEletrico = vidroEletrico;
		this.arcondicionado = arcondicionado;
		this.travaEletrica = travaEletrica;
		this.direcaoHidraulica = direcaoHidraulica;
		this.direcaoHeletrica = direcaoHeletrica;
		this.sensoresEstacionamento = sensoresEstacionamento;
		this.abs = abs;
		this.airbag = airbag;
	}

	public MeuCarro(int idMeuCarro, int idUsuario) {
		super();
		this.idMeuCarro = idMeuCarro;
		this.idUsuario = idUsuario;
	}

	public int getIdMeuCarro() {
		return idMeuCarro;
	}

	public void setIdMeuCarro(int idMeuCarro) {
		this.idMeuCarro = idMeuCarro;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdMinhaRevisao() {
		return idMinhaRevisao;
	}

	public void setIdMinhaRevisao(int idMinhaRevisao) {
		this.idMinhaRevisao = idMinhaRevisao;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Date getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(Date anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getRenavan() {
		return renavan;
	}

	public void setRenavan(int renavan) {
		this.renavan = renavan;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public boolean isVidroEletrico() {
		return vidroEletrico;
	}

	public void setVidroEletrico(boolean vidroEletrico) {
		this.vidroEletrico = vidroEletrico;
	}

	public boolean isArcondicionado() {
		return arcondicionado;
	}

	public void setArcondicionado(boolean arcondicionado) {
		this.arcondicionado = arcondicionado;
	}

	public boolean isTravaEletrica() {
		return travaEletrica;
	}

	public void setTravaEletrica(boolean travaEletrica) {
		this.travaEletrica = travaEletrica;
	}

	public boolean isDirecaoHidraulica() {
		return direcaoHidraulica;
	}

	public void setDirecaoHidraulica(boolean direcaoHidraulica) {
		this.direcaoHidraulica = direcaoHidraulica;
	}

	public boolean isDirecaoHeletrica() {
		return direcaoHeletrica;
	}

	public void setDirecaoHeletrica(boolean direcaoHeletrica) {
		this.direcaoHeletrica = direcaoHeletrica;
	}

	public boolean isSensoresEstacionamento() {
		return sensoresEstacionamento;
	}

	public void setSensoresEstacionamento(boolean sensoresEstacionamento) {
		this.sensoresEstacionamento = sensoresEstacionamento;
	}

	public boolean isAbs() {
		return abs;
	}

	public void setAbs(boolean abs) {
		this.abs = abs;
	}

	public boolean isAirbag() {
		return airbag;
	}

	public void setAirbag(boolean airbag) {
		this.airbag = airbag;
	}
	
	
	
	
	
}
