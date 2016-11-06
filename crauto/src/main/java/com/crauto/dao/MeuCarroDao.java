package com.crauto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.crauto.beans.MeuCarro;
import com.crauto.db.Conexao;

public class MeuCarroDao {
		
	private Connection conexao;	
		

	public MeuCarroDao() {

		try {
			this.conexao = new Conexao().getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void fechaConexao() {
		try {
			this.conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public MeuCarro getMeuCarro(int id) {

		MeuCarroDao objMeuCarroDao = new MeuCarroDao();

		for (Iterator<MeuCarro> iterator = objMeuCarroDao.getLista().iterator(); iterator.hasNext();) {
			MeuCarro item = (MeuCarro) iterator.next();
			if (item.getIdMeuCarro() == id)
				return item;
		}
		return null;
	}

	public List<MeuCarro> getLista()  {

		List<MeuCarro> lMeuCarro = new ArrayList<MeuCarro>();

		try {
			PreparedStatement stmt = this.conexao.prepareStatement("select * from MeuCarro");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				MeuCarro MeuCarroObj = new MeuCarro();

				MeuCarroObj.setIdMeuCarro(rs.getInt("idMeuCarro"));
				MeuCarroObj.setIdUsuario(rs.getInt("idUsuario"));
				MeuCarroObj.setIdMinhaRevisao(rs.getInt("idMinhaRevisao"));
				MeuCarroObj.setFoto(rs.getString("foto"));
				MeuCarroObj.setAnoFabricacao(rs.getDate("anoFabricacao"));
				MeuCarroObj.setPlaca(rs.getString("palca"));
				MeuCarroObj.setRenavan(rs.getInt("renavan"));
				MeuCarroObj.setChassi(rs.getString("chassi"));
				MeuCarroObj.setVidroEletrico(rs.getBoolean("vidroEletrico"));
				MeuCarroObj.setArcondicionado(rs.getBoolean("arcondicionado"));
				MeuCarroObj.setDirecaoHeletrica(rs.getBoolean("derecaoHidraulica"));
				MeuCarroObj.setSensoresEstacionamento(rs.getBoolean("sensoresEstacionamento"));
				MeuCarroObj.setAbs(rs.getBoolean("abs"));
				MeuCarroObj.setAirbag(rs.getBoolean("airbag"));
				lMeuCarro.add(MeuCarroObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lMeuCarro;

	}

	public boolean alterar(MeuCarro objMeuCarro) {

		boolean alterado = false;

		try {
			PreparedStatement stmt = this.conexao.prepareStatement("update MeuCarro set  idUsuario=?,"+
					"idMinhaRevisao=?,foto=?,anoFabricacao=?,placa=?,renavan=?,chassi=?,vidroEletrico=?,arcondicionado=?"+		
					"travaEletrica=?,direcaoHidraulica=?,direcaoHeletrica=?,sensoresEstacionamento=?"+			
					"abs=?,airba=?, where idMeuCarro=? value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

							
							
			
			stmt.setInt(1, objMeuCarro.getIdUsuario());
			stmt.setInt(2, objMeuCarro.getIdMinhaRevisao());
			stmt.setString(3, objMeuCarro.getFoto());
			stmt.setString(4, objMeuCarro.getPlaca());
			stmt.setDate(5, new java.sql.Date(objMeuCarro.getAnoFabricacao().getTime()));
			stmt.setInt(6, objMeuCarro.getRenavan());
			stmt.setString(7, objMeuCarro.getChassi());
			stmt.setBoolean(8, objMeuCarro.isVidroEletrico());
			stmt.setBoolean(9, objMeuCarro.isArcondicionado());
			stmt.setBoolean(10, objMeuCarro.isTravaEletrica());
			stmt.setBoolean(11, objMeuCarro.isDirecaoHidraulica());
			stmt.setBoolean(12, objMeuCarro.isDirecaoHeletrica());
			stmt.setBoolean(13, objMeuCarro.isSensoresEstacionamento());
			stmt.setBoolean(14, objMeuCarro.isAbs());
			stmt.setBoolean(15, objMeuCarro.isAirbag());
			stmt.setInt(16, objMeuCarro.getIdMeuCarro());
			stmt.execute();
			stmt.close();
			fechaConexao();
			alterado = true;

		} catch (SQLException e) {
			throw new RuntimeException(e);

		}

		return alterado;

	}

	public boolean excluir(MeuCarro objMeuCarro) {
		boolean excluido = false;
		try {
			PreparedStatement stmt = this.conexao.prepareStatement("delete * from  MeuCarro where codigo=?");
			
			stmt.setInt(1, objMeuCarro.getIdMeuCarro());
			stmt.execute();
			stmt.close();
			fechaConexao();
			excluido = true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return excluido;
	}

}