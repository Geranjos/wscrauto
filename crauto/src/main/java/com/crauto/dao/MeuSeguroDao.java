package com.crauto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.crauto.beans.MeuSeguro;
import com.crauto.db.Conexao;

public class MeuSeguroDao {
	
private Connection conexao;	
	

	public MeuSeguroDao() {

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

	public MeuSeguro getMeuSeguro(int id) {

		MeuSeguroDao objMeuSeguroDao = new MeuSeguroDao();

		for (Iterator<MeuSeguro> iterator = objMeuSeguroDao.getLista().iterator(); iterator.hasNext();) {
			MeuSeguro item = (MeuSeguro) iterator.next();
			if (item.getIdMeuSeguro() == id)
				return item;
		}
		return null;
	}

	
	
	public List<MeuSeguro> getLista()  {

		List<MeuSeguro> lMeuSeguro = new ArrayList<MeuSeguro>();

		try {
			PreparedStatement stmt = this.conexao.prepareStatement("select * from MeuSeguro");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				MeuSeguro MeuSeguroObj = new MeuSeguro();

				MeuSeguroObj.setIdMeuSeguro(rs.getInt("idMeuSeguro"));
				MeuSeguroObj.setIdUsuario(rs.getInt("idUsuario"));
				MeuSeguroObj.setIdMeuCarro(rs.getInt("idMeuCarro"));
				MeuSeguroObj.setNomeCorretor(rs.getString("nomeCorretor"));
				MeuSeguroObj.setTelefone(rs.getString("telefone"));
				MeuSeguroObj.setDataVencimento(rs.getDate("dataVencimento"));
				lMeuSeguro.add(MeuSeguroObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lMeuSeguro;

	}

	public boolean alterar(MeuSeguro objMeuSeguro) {

		boolean alterado = false;

		try {
			PreparedStatement stmt = this.conexao.prepareStatement("update MeuSeguro set  idUsusuaeio=?,"+
					"idMeuCarro=?, nomeCorretor=?,telefone=?,dataVencimento=?, where idMeuSeguro=? value(?,?,?,?,?,?)");
			
			stmt.setInt(1, objMeuSeguro.getIdUsuario());
			stmt.setInt(2, objMeuSeguro.getIdMeuCarro());
			stmt.setString(3, objMeuSeguro.getNomeCorretor());
			stmt.setString(4, objMeuSeguro.getTelefone());
			stmt.setDate(5, new java.sql.Date(objMeuSeguro.getDataVencimento().getTime()));
			stmt.setInt(6, objMeuSeguro.getIdMeuSeguro());
			stmt.execute();
			stmt.close();
			fechaConexao();
			alterado = true;

		} catch (SQLException e) {
			throw new RuntimeException(e);

		}

		return alterado;

	}

	public boolean excluir(MeuSeguro objMeuSeguro) {
		boolean excluido = false;
		try {
			PreparedStatement stmt = this.conexao.prepareStatement("delete * from  MeuSeguro where idMeuSeguro=?");
			
			stmt.setInt(1, objMeuSeguro.getIdMeuSeguro());
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