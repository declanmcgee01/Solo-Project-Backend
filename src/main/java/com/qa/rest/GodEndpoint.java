package com.qa.rest;

import javax.ws.rs.Produces;
import javax.inject.Inject;
import javax.ws.rs.PathParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import com.qa.service.GodService;

@Path("/god")
public class GodEndpoint {
	
	@Inject
	private GodService service;
	
	@Path("/getAllGods")
	@GET
	@Produces({"application/json"})
	public String getAllGods() {
		return service.getAllGods();
	}
	
	@Path("/createGod")
	@POST
	@Produces({"application/json"})
	public String createGod(String god) {
		return service.createGod(god);
	}
	
	@Path("/deleteGod/{godID}")
	@DELETE
	@Produces({"application/json"})
	public String deleteGod(@PathParam("godID")Long godID) {
		return service.deleteGod(godID);
	}
	
	@Path("updateGod/{godID}")
	@PUT
	@Produces({"application/json"})
	public String updateGod(@PathParam("godID")Long godID, String god) {
		return service.updateGod(godID, god);
	}
	
	@Path("/findGod/{name}")
	@GET
	@Produces({"application/json"})
	public String findGod(@PathParam("name")String name) {
		return service.findGod(name);
	}
	

}
