package com.crauto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.crauto.beans.Orcamento;
import com.crauto.db.Conexao;


public class OrcamentoDao {
	private Connection conexao;

	public OrcamentoDao() {

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

	
	
	public Orcamento getOrcamento(int id) {

		OrcamentoDao objOrcamentoDao = new OrcamentoDao();

		for (Iterator<Orcamento> iterator = objOrcamentoDao.getLista().iterator(); iterator.hasNext();) {
			Orcamento item = (Orcamento) iterator.next();
			if (item.getIdOrcamento() == id)
				return item;
		}
		return null;
	}

	
	
	public List<Orcamento> getLista() {

		List<Orcamento> lOrcamento = new ArrayList<Orcamento>();

		try {
			PreparedStatement stmt = this.conexao.prepareStatement("select * from Orcamento");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Orcamento OrcamentoObj = new Orcamento();

				OrcamentoObj.setIdOrcamento(rs.getInt("idOrcamento"));
				OrcamentoObj.setIdUsuario(rs.getInt("idUsuario"));
				OrcamentoObj.setIdItemOrca(rs.getInt("idItemOrca"));
				OrcamentoObj.setIdMeuCarro(rs.getInt("idMeuCarro"));
				OrcamentoObj.setRevisaoProgramada(rs.getBoolean("revisaoProgramada"));
				OrcamentoObj.setDescricao(rs.getString("descricao"));
				OrcamentoObj.setData(rs.getDate("data"));
				OrcamentoObj.setPrecoTotal(rs.getLong("precoTotal"));
				OrcamentoObj.setCondicaoPagamento(rs.getString("condicaoPagamento"));
				lOrcamento.add(OrcamentoObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lOrcamento;

	}

	public boolean alterar(Orcamento objOrcamento) {

		boolean alterado = false;

		try {
			PreparedStatement stmt = this.conexao
					.prepareStatement("update Orcamento set  idUsuario=?, idItemOrca=?, idMeuCarro=?, revisaoProgramada=?, descricao=?, data=?,precoTotal=?,condicaoPagamento=?,  where idOrcamento=? value(?,?,?,?,?,?,?,?)");

			stmt.setInt(1, objOrcamento.getIdUsuario());
			stmt.setInt(2, objOrcamento.getIdItemOrca());
			stmt.setInt(3, objOrcamento.getIdMeuCarro());
			stmt.setBoolean(4, objOrcamento.isRevisaoProgramada());
			stmt.setString(5, objOrcamento.getDescricao());
			stmt.setDate(6, new java.sql.Date(objOrcamento.getData().getTime()));
		    stmt.setLong(7,objOrcamento.getPrecoTotal());
		    stmt.setString(8,objOrcamento.getCondicaoPagamento());
			stmt.setInt(9, objOrcamento.getIdOrcamento());
			stmt.execute();
			stmt.close();
			fechaConexao();
			alterado = true;

		} catch (SQLException e) {
			throw new RuntimeException(e);

		}

		return alterado;

	}

	public boolean excluir(Orcamento objOrcamento) {
		boolean excluido = false;
		try {
			PreparedStatement stmt = this.conexao.prepareStatement("delete * from  Orcamento where idOrcamento=?");

			stmt.setInt(1, objOrcamento.getIdOrcamento());
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