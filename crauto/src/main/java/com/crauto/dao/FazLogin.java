package com.crauto.dao;

import java.sql.Connection;
import java.util.ArrayList;

import com.crauto.beans.Login;

import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class FazLogin {

	public ArrayList<Login> getAllUsers(Connection connection) throws Exception {
		
		ArrayList<Login> userList = new ArrayList<Login>();
		
		try {
			
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM LOGIN");
			;
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Login login = new Login();
				login.setLogin(rs.getString("login"));
				login.setSenha(rs.getString("senha"));
				userList.add(login);
			}
			return userList;
		} catch (Exception e) {
			throw e;
		}
	}

}