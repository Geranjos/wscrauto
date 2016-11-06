package com.crauto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.crauto.beans.RevisaoProgramada;
import com.crauto.db.Conexao;

public class RevisaoProgramadaDao {
	
	private Connection conexao;	
	
	public RevisaoProgramadaDao() {

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

	public RevisaoProgramada getRevisaoProgramada(int id) {

		RevisaoProgramadaDao objRevisaoProgramadaDao = new RevisaoProgramadaDao();

		for (Iterator<RevisaoProgramada> iterator = objRevisaoProgramadaDao.getLista().iterator(); iterator.hasNext();) {
			RevisaoProgramada item = (RevisaoProgramada) iterator.next();
			if (item.getIdRevisaoProgramada() == id)
				return item;
		}
		return null;
	}

	
	
	public List<RevisaoProgramada> getLista()  {

		List<RevisaoProgramada> lRevisaoProgramada = new ArrayList<RevisaoProgramada>();

		try {
			PreparedStatement stmt = this.conexao.prepareStatement("select * fromRevisaoProgramada");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				RevisaoProgramada RevisaoProgramadaObj = new RevisaoProgramada();

				RevisaoProgramadaObj.setIdRevisaoProgramada(rs.getInt("idRevisaoProgramada"));
				RevisaoProgramadaObj.setDescricao(rs.getString("descricao"));
				RevisaoProgramadaObj.setDataProg(rs.getDate("dataProg"));
				RevisaoProgramadaObj.setKmProgr(rs.getInt("kmProg"));
     			lRevisaoProgramada.add(RevisaoProgramadaObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lRevisaoProgramada;

	}

	public boolean alterar(RevisaoProgramada objRevisaoProgramada) {

		boolean alterado = false;

		try {
			PreparedStatement stmt = this.conexao.prepareStatement("updateRevisaoProgramada set  descricao=?,dataProgo=?,"+
					" kmProgr=?,  where idRevisaoProgramada=? value(?,?,?,?)");
			
			stmt.setString(1, objRevisaoProgramada.getDescricao());
			stmt.setDate(2, new java.sql.Date(objRevisaoProgramada.getDataProg().getTime()));
			stmt.setInt(3, objRevisaoProgramada.getKmProgr());
			stmt.setInt(4, objRevisaoProgramada.getIdRevisaoProgramada());
			stmt.execute();
			stmt.close();
			fechaConexao();
			alterado = true;

		} catch (SQLException e) {
			throw new RuntimeException(e);

		}

		return alterado;

	}

	public boolean excluir(RevisaoProgramada objRevisaoProgramada) {
		boolean excluido = false;
		try {
			PreparedStatement stmt = this.conexao.prepareStatement("delete * from RevisaoProgramada where idRevisaoProgramada=?");
			
			stmt.setInt(1, objRevisaoProgramada.getIdRevisaoProgramada());
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