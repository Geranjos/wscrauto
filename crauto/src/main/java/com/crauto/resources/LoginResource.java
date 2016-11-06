package com.crauto.resources;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
 
import com.crauto.model.Seguranca;
import com.crauto.beans.Login;



public class LoginResource {

	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String login(@FormParam("login") String login,
	@FormParam("senha") String senha) {
	 
	return getAllUsersList(login, senha);
	 
	}

	public String getAllUsersList(String login, String senha) {
		String loginListData = null;
		try {
			ArrayList<Login> loginList = null;
			Seguranca seguranca = new Seguranca();
			loginList = seguranca.getAllUsersList();
			for (Login usuario : loginList) {
				if (usuario.getLogin().equals(login)) {
					if (usuario.getSenha().equals(senha)) {
						return "Usuario Logado:" + login;
					}
				}
			}

		} catch (Exception e) {
			System.out.println("Erro");
		}
		return "Usuario inválido";
	}
}