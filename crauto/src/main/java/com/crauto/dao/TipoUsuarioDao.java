package com.crauto.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.crauto.beans.TipoUsuario;
import com.crauto.db.Conexao;

public class TipoUsuarioDao {
	private Connection conexao;	
	

	public TipoUsuarioDao() {

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

	public TipoUsuario getTipoUsuario(int id) {

		TipoUsuarioDao objTipoUsuarioDao = new TipoUsuarioDao();

		for (Iterator<TipoUsuario> iterator = objTipoUsuarioDao.getLista().iterator(); iterator.hasNext();) {
			TipoUsuario item = (TipoUsuario) iterator.next();
			if (item.getIdTipoUsuario() == id)
				return item;
		}
		return null;
	}

	public List<TipoUsuario> getLista()  {

		List<TipoUsuario> lTipoUsuario = new ArrayList<TipoUsuario>();

		try {
			PreparedStatement stmt = this.conexao.prepareStatement("select * from TipoUsuario");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				TipoUsuario TipoUsuarioObj = new TipoUsuario();

				TipoUsuarioObj.setIdTipoUsuario(rs.getInt("idTipoUsuario"));
				TipoUsuarioObj.setDescricao(rs.getString("Descricao"));
				lTipoUsuario.add(TipoUsuarioObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lTipoUsuario;

	}

	public boolean alterar(TipoUsuario objTipoUsuario) {

		boolean alterado = false;

		try {
			PreparedStatement stmt = this.conexao.prepareStatement("update TipoUsuario set   Descricao=? where idTipoUsuario=? value(?,?)");
			
			
			stmt.setString(1, objTipoUsuario.getDescricao());
			stmt.setInt(2, objTipoUsuario.getIdTipoUsuario());
			stmt.execute();
			stmt.close();
			fechaConexao();
			alterado = true;

		} catch (SQLException e) {
			throw new RuntimeException(e);

		}

		return alterado;

	}

	public boolean excluir(TipoUsuario objTipoUsuario) {
		boolean excluido = false;
		try {
			PreparedStatement stmt = this.conexao.prepareStatement("delete * from  TipoUsuario where idTipoUsuario=?");
			
			stmt.setInt(1, objTipoUsuario.getIdTipoUsuario());
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