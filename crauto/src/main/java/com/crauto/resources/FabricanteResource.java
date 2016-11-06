package com.crauto.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.crauto.beans.Fabricante;
import com.crauto.dao.FabricanteDao;

@Path("fabricantes")
public class FabricanteResource {

	FabricanteDao fabricanteDao = new FabricanteDao();
	private static final String SUCCESS_RESULT = "<result>success</result>";
	private static final String FAILURE_RESULT = "<result>failure</result>";

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Fabricante> getFabricantes() {

		return fabricanteDao.getLista();
	}

	@GET
	@Path("/{fabricanteid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Fabricante getFabricante(@PathParam("fabricanteid") int fabricanteId) {
		return fabricanteDao.getFabricante(fabricanteId);
	}

	@POST
	@Path("/altera")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_FORM_URLENCODED)
	public String alteraFabricante(@FormParam("fabricanteid") int fabricanteId,
			@FormParam("descricao") String descricao, @FormParam("foto") String foto) {

		Fabricante objFabricante = new Fabricante(fabricanteId, descricao, foto);

		boolean resultado = fabricanteDao.alterar(objFabricante);

		if (resultado) {
			return SUCCESS_RESULT;
		}
		return FAILURE_RESULT;
	}

	@PUT
	@Path("/inclui")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_FORM_URLENCODED)
	public String incluiFabricante(
			@FormParam("descricao") String descricao, 
			@FormParam("foto") String foto,
			@Context Response response) {

		Fabricante fabricante = new Fabricante(descricao, foto);

		int result = fabricanteDao.adiciona(fabricante);

		if (result == 1) {
			return SUCCESS_RESULT;
		}
		return FAILURE_RESULT;

	}

	@DELETE
	@Path("/exclui/{fabricanteId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String excluiFabricante(@PathParam("idFabCar") int idFabCar) {
		boolean result = fabricanteDao.exclui(idFabCar);

		if (result) {
			return SUCCESS_RESULT;
		}
		return FAILURE_RESULT;
	}

}
