package com.crauto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.crauto.beans.Usuario;
import com.crauto.db.Conexao;

public class UsuarioDao {
	
	private Connection conexao;	
		

	public UsuarioDao() {

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

	public Usuario getUsuario(int id) {

		UsuarioDao objUsuarioDao = new UsuarioDao();

		for (Iterator<Usuario> iterator = objUsuarioDao.getLista().iterator(); iterator.hasNext();) {
			Usuario item = (Usuario) iterator.next();
			if (item.getIdUsuario() == id)
				return item;
		}
		return null;
	}

	public List<Usuario> getLista()  {

		List<Usuario> lUsuario = new ArrayList<Usuario>();

		try {
			PreparedStatement stmt = this.conexao.prepareStatement("select * from Usuario");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Usuario UsuarioObj = new Usuario();

				UsuarioObj.setIdUsuario(rs.getInt("idUsuario"));
				UsuarioObj.setIdMeucarro(rs.getInt("idMeucarro"));
				UsuarioObj.setIdTipoUsuario(rs.getInt("idTipoUsuario"));
				UsuarioObj.setNome(rs.getString("nome"));
				UsuarioObj.setEmail(rs.getString("email"));
				UsuarioObj.setFoto(rs.getString("foto"));
				UsuarioObj.setDocumento(rs.getString("documento"));
				UsuarioObj.setTipoPessoa(rs.getInt("tipoPessoa"));
				UsuarioObj.setEndereco(rs.getString("endereco"));
				UsuarioObj.setNumero(rs.getString("numero"));
				UsuarioObj.setBairro(rs.getString("bairro"));
				UsuarioObj.setCidade(rs.getString("cidade"));
				UsuarioObj.setUf(rs.getString("uf"));
				UsuarioObj.setCep(rs.getString("cep"));
				lUsuario.add(UsuarioObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lUsuario;

	}

	public boolean alterar(Usuario objUsuario) {

		boolean alterado = false;

		try {
			PreparedStatement stmt = this.conexao.prepareStatement("update Usuario set idMeucarro?,idTipoUsuario=?, nome=?, email=?,foto=?,documento=?,tipoPessoa=?,endereco=?,numero=?,bairro=?,cidade=?,uf=?,cep=?, where idusuario=? value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

							
							
			
			stmt.setInt(1, objUsuario.getIdMeucarro());
			stmt.setInt(2,objUsuario.getIdTipoUsuario());
	        stmt.setString(3,objUsuario.getNome());
			stmt.setString(4, objUsuario.getEmail());
			stmt.setString(5, objUsuario.getFoto());
			stmt.setString(6, objUsuario.getDocumento());
			stmt.setInt(7, objUsuario.getTipoPessoa());
			stmt.setString(8, objUsuario.getEndereco());
			stmt.setString(9, objUsuario.getBairro());
			stmt.setString(10, objUsuario.getCidade());
			stmt.setString(11, objUsuario.getUf());
			stmt.setString(12, objUsuario.getCep());
			stmt.setInt(13, objUsuario.getIdUsuario());
			
			stmt.execute();
			stmt.close();
			fechaConexao();
			alterado = true;

		} catch (SQLException e) {
			throw new RuntimeException(e);

		}

		return alterado;

	}

	public boolean excluir(Usuario objUsuario) {
		boolean excluido = false;
		try {
			PreparedStatement stmt = this.conexao.prepareStatement("delete * from  Usuario where codigo=?");
			
			stmt.setInt(1, objUsuario.getIdUsuario());
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