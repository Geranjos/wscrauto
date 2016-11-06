package com.crauto.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.crauto.beans.Carro;
import com.crauto.beans.Fabricante;
import com.crauto.dao.CarroDao;
import com.crauto.dao.FabricanteDao;





@Path("carro")
public class CarroResource {
	
	private static final String SUCCESS_RESULT = "<result>success</result>";
	private static final String FAILURE_RESULT = "<result>failure</result>";

	CarroDao carroDao = new CarroDao();
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)

	public List<Carro> getCarros()
	{
			        
			return new CarroDao().getLista();
	    
		
		
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Carro geCarro(@PathParam("id") int id) {
		return carroDao.getCarro(id);
	}

	
	
	
	
}
