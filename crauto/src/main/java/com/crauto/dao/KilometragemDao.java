package com.crauto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.crauto.beans.Kilometragem;
import com.crauto.db.Conexao;

public class KilometragemDao {
	private Connection conexao;	
	

	public KilometragemDao() {

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

	public Kilometragem getKilometragem(int id) {

		KilometragemDao objKilometragemDao = new KilometragemDao();

		for (Iterator<Kilometragem> iterator = objKilometragemDao.getLista().iterator(); iterator.hasNext();) {
			Kilometragem item = (Kilometragem) iterator.next();
			if (item.getIdKm() == id)
				return item;
		}
		return null;
	}

	public List<Kilometragem> getLista()  {

		List<Kilometragem> lKilometragem = new ArrayList<Kilometragem>();

		try {
			PreparedStatement stmt = this.conexao.prepareStatement("select * from Kilometragem");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Kilometragem KilometragemObj = new Kilometragem();

				KilometragemObj.setIdKm(rs.getInt("idKm"));
				KilometragemObj.setData(rs.getDate("data"));
				KilometragemObj.setIdMeucarro(rs.getInt("idMeucarro"));
			
				
				lKilometragem.add(KilometragemObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lKilometragem;

	}

	public boolean alterar(Kilometragem objKilometragem) {

		boolean alterado = false;

		try {
			PreparedStatement stmt = this.conexao.prepareStatement("update Kilometragem set idKm=?,"+
					"data=?,IdMeucarro=? value(?,?,?)");

							
							
			stmt.setInt(1, objKilometragem.getIdKm());
			stmt.setDate(2, new java.sql.Date(objKilometragem.getData().getTime()));
			stmt.setInt(3, objKilometragem.getIdMeucarro());
			
			stmt.execute();
			stmt.close();
			fechaConexao();
			alterado = true;

		} catch (SQLException e) {
			throw new RuntimeException(e);

		}

		return alterado;

	}

	public boolean excluir(Kilometragem objKilometragem) {
		boolean excluido = false;
		try {
			PreparedStatement stmt = this.conexao.prepareStatement("delete * from  Kilometragem where codigo=?");
			
			stmt.setInt(1, objKilometragem.getIdKm());
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
