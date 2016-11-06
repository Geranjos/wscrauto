package com.crauto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.crauto.beans.Peca;
import com.crauto.db.Conexao;

public class PecaDao {
	
	private Connection conexao;	
		

	public PecaDao() {

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

	public Peca getPeca(int id) {

		PecaDao objPecaDao = new PecaDao();

		for (Iterator<Peca> iterator = objPecaDao.getLista().iterator(); iterator.hasNext();) {
			Peca item = (Peca) iterator.next();
			if (item.getIdPeca() == id)
				return item;
		}
		return null;
	}

	public List<Peca> getLista()  {

		List<Peca> lPeca = new ArrayList<Peca>();

		try {
			PreparedStatement stmt = this.conexao.prepareStatement("select * from Peca");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Peca PecaObj = new Peca();

				PecaObj.setIdPeca(rs.getInt("idPeca"));
				PecaObj.setDescricao(rs.getString("descricao"));
				PecaObj.setDurabiliKm(rs.getInt("durabiliKm"));
				PecaObj.setDurabilidata(rs.getDate("durabilidata"));
				
				lPeca.add(PecaObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lPeca;

	}

	public boolean alterar(Peca objPeca) {

		boolean alterado = false;

		try {
			PreparedStatement stmt = this.conexao.prepareStatement("update Peca set idPeca=?,"+
					"descricao=?,durabiliKm=?,durabilidata=? value(?,?,?,?)");

							
							
			stmt.setInt(1, objPeca.getIdPeca());
			stmt.setString(2, objPeca.getDescricao());
			stmt.setInt(3, objPeca.getDurabiliKm());
			stmt.setDate(4, new java.sql.Date(objPeca.getDurabilidata().getTime()));
			
			stmt.execute();
			stmt.close();
			fechaConexao();
			alterado = true;

		} catch (SQLException e) {
			throw new RuntimeException(e);

		}

		return alterado;

	}

	public boolean excluir(Peca objPeca) {
		boolean excluido = false;
		try {
			PreparedStatement stmt = this.conexao.prepareStatement("delete * from  Peca where codigo=?");
			
			stmt.setInt(1, objPeca.getIdPeca());
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