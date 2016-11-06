package com.crauto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.crauto.beans.MinhaRevisao;
import com.crauto.db.Conexao;

public class MinhaRevisaoDao {
	
private Connection conexao;	
	

	public MinhaRevisaoDao() {

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

	public MinhaRevisao getMinhaRevisao(int id) {

		MinhaRevisaoDao objMinhaRevisaoDao = new MinhaRevisaoDao();

		for (Iterator<MinhaRevisao> iterator = objMinhaRevisaoDao.getLista().iterator(); iterator.hasNext();) {
			MinhaRevisao item = (MinhaRevisao) iterator.next();
			if (item.getIdMinhaRevisao() == id)
				return item;
		}
		return null;
	}

	
	
	public List<MinhaRevisao> getLista()  {

		List<MinhaRevisao> lMinhaRevisao = new ArrayList<MinhaRevisao>();

		try {
			PreparedStatement stmt = this.conexao.prepareStatement("select * from MinhaRevisao");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				MinhaRevisao MinhaRevisaoObj = new MinhaRevisao();

				MinhaRevisaoObj.setIdMinhaRevisao(rs.getInt("idMinhaRevisao"));
				MinhaRevisaoObj.setIdPecaRevisao(rs.getInt("idPecaRevisao"));
				MinhaRevisaoObj.setIdMeuCarro(rs.getInt("idMeuCarro"));
				MinhaRevisaoObj.setIdOrcamento(rs.getInt("idOrcamento"));
				MinhaRevisaoObj.setRevisProg(rs.getDate("RevisProg"));
				lMinhaRevisao.add(MinhaRevisaoObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lMinhaRevisao;

	}

	public boolean alterar(MinhaRevisao objMinhaRevisao) {

		boolean alterado = false;

		try {
			PreparedStatement stmt = this.conexao.prepareStatement("update MinhaRevisao set  idMinhaRevisao=?,idPecaRevisao=?,"+
					"idMeuCarro=?, RevisProgr=?, where idMinhaRevisao=? value(?,?,?,?,?)");
			
			stmt.setInt(1, objMinhaRevisao.getIdPecaRevisao());
			stmt.setInt(2, objMinhaRevisao.getIdMeuCarro());
			stmt.setInt(3, objMinhaRevisao.getIdOrcamento());
			stmt.setDate(5, new java.sql.Date(objMinhaRevisao.getRevisProg().getTime()));
			stmt.setInt(6, objMinhaRevisao.getIdMinhaRevisao());
			stmt.execute();
			stmt.close();
			fechaConexao();
			alterado = true;

		} catch (SQLException e) {
			throw new RuntimeException(e);

		}

		return alterado;

	}

	public boolean excluir(MinhaRevisao objMinhaRevisao) {
		boolean excluido = false;
		try {
			PreparedStatement stmt = this.conexao.prepareStatement("delete * from  MinhaRevisao where idMinhaRevisao=?");
			
			stmt.setInt(1, objMinhaRevisao.getIdMinhaRevisao());
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