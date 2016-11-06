package com.crauto.model;

import java.sql.Connection;
import java.util.ArrayList;
 
import com.crauto.beans.Login;
import com.crauto.dao.FazLogin;
import com.crauto.db.Conexao;
 
public class Seguranca {

	public ArrayList<Login> getAllUsersList() throws Exception {
		ArrayList<Login> loginList = null;
		try {
			Conexao database = new Conexao();
			Connection connection = database.getConnection();
			FazLogin fazLogin = new FazLogin();
			loginList = fazLogin.getAllUsers(connection);

		} catch (Exception e) {
			throw e;
		}
		return loginList;
	}

}

