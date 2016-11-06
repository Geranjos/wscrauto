package com.crauto.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.crauto.beans.Carro;
import com.crauto.db.Conexao;

public class CarroDao {
	private Connection conexao;	
	

	public CarroDao() {

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

	public Carro getCarro(int id) {

		CarroDao objCarroDao = new CarroDao();

		for (Iterator<Carro> iterator = objCarroDao.getLista().iterator(); iterator.hasNext();) {
			Carro item = (Carro) iterator.next();
			if (item.getIdCarro() == id)
				return item;
		}
		return null;
	}

	public List<Carro> getLista()  {

		List<Carro> lCarro = new ArrayList<Carro>();

		try {
			PreparedStatement stmt = this.conexao.prepareStatement("SELECT IDCARRO, IDFABCAR,MODELO, ANOMODELO FROM CARRO");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Carro CarroObj = new Carro();

				CarroObj.setIdCarro(rs.getInt("IDCARRO"));
				CarroObj.setIdFabcar(rs.getInt("IDFABCAR"));
				CarroObj.setModelo(rs.getString("MODELO"));
				CarroObj.setAnoModelo(rs.getDate("ANOMODELO"));
				lCarro.add(CarroObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lCarro;

	}

	public boolean alterar(Carro objCarro) {

		boolean alterado = false;

		try {
			PreparedStatement stmt = this.conexao.prepareStatement("update Carro set  idFabCar=?,"+
					"modelo=?,AnoModelo=?, where idCarro=? value(?,?,?,?)");
			
			stmt.setInt(1, objCarro.getIdFabcar());
			stmt.setString(2, objCarro.getModelo());
			stmt.setDate(3, new java.sql.Date(objCarro.getAnoModelo().getTime()));
			stmt.setInt(4, objCarro.getIdCarro());
			stmt.execute();
			stmt.close();
			fechaConexao();
			alterado = true;

		} catch (SQLException e) {
			throw new RuntimeException(e);

		}

		return alterado;

	}

	public boolean excluir(Carro objCarro) {
		boolean excluido = false;
		try {
			PreparedStatement stmt = this.conexao.prepareStatement("delete * from  Carro where idcarro=?");
			
			stmt.setInt(1, objCarro.getIdCarro());
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