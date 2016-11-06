package com.crauto.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.crauto.beans.Fabricante;
import com.crauto.db.Conexao;

public class FabricanteDao {

	private Connection conexao;

	public FabricanteDao() {

		try {
			this.conexao = new Conexao().getConnection();

			System.out.println("conectado....");
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

	public Fabricante getFabricante(int id) {

		FabricanteDao objFabricanteDao = new FabricanteDao();

		for (Iterator<Fabricante> iterator = objFabricanteDao.getLista().iterator(); iterator.hasNext();) {
			Fabricante item = (Fabricante) iterator.next();
			if (item.getIdFabCar() == id)
				return item;
		}
		return null;
	}

	public List<Fabricante> getLista() {

		List<Fabricante> lFabricante = new ArrayList<Fabricante>();

		try {
			PreparedStatement stmt = this.conexao.prepareStatement("SELECT * FROM fabricante");
			ResultSet rs = stmt.executeQuery();
			System.out.println("check point 2");
			while (rs.next()) {
				Fabricante fabricanteObj = new Fabricante();

				fabricanteObj.setIdFabCar(rs.getInt("IDFABCAR"));
				fabricanteObj.setDescricao(rs.getString("DESCRICAO"));
				fabricanteObj.setFoto(rs.getString("FOTO"));
				lFabricante.add(fabricanteObj);

			}

			stmt.close();
			rs.close();
			fechaConexao();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lFabricante;

	}

	public int adiciona(Fabricante ObjFabricante) {

		List<Fabricante> fabricanteLista = getLista();
		boolean existeFabricante = false;

		for (Fabricante fabricante : fabricanteLista) {
			if (fabricante.getDescricao() == ObjFabricante.getDescricao()) {
				existeFabricante = true;
				break;
			}
		}

		if (!existeFabricante) {

			return incluiFabricante(ObjFabricante);
		}
		return 0;
	}

	private int incluiFabricante(Fabricante ObjFabricante) {
		int incluido = 0;
		try {

			PreparedStatement stmt = this.conexao
					.prepareStatement("INSERT INTO  fabricante  DESCRICAO=?, FOTO=? VALUES (?,?)");
			stmt.setString(1, ObjFabricante.getDescricao());
			stmt.setString(2, ObjFabricante.getFoto());
			stmt.execute();
			stmt.close();
			fechaConexao();
			incluido++;
			

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return incluido;
	}
	
	

	public boolean alterar(Fabricante objFabricante) {

		boolean alterado = false;

		try {
			PreparedStatement stmt = this.conexao
					.prepareStatement("update Fabricante set IDFABCAR=?,DESCRICAO=?,FOTO=?, value(?,?,?)");
			stmt.setInt(1, objFabricante.getIdFabCar());
			stmt.setString(2, objFabricante.getDescricao());
			stmt.setString(3, objFabricante.getFoto());
			stmt.execute();
			stmt.close();
			fechaConexao();
			alterado = true;

		} catch (SQLException e) {
			throw new RuntimeException(e);

		}

		return alterado;

	}

	public boolean exclui(int id) {
		boolean excluido = false;
		try {
			PreparedStatement stmt = this.conexao.prepareStatement("delete * from  fabricante where codigo=?");
			stmt.setInt(1, id);
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