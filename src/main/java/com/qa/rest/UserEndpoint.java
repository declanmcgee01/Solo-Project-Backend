package com.qa.rest;

import javax.ws.rs.Produces;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.qa.service.UserService;

@Path("/user")
public class UserEndpoint {
	
	@Inject
	private UserService service;
	
	@Path("/getAllUsers")
	@GET
	@Produces({"application/json"})
	public String getAllUsers() {
		return service.getAllUsers();
	}
	
	@Path("/createUser")
	@POST
	@Produces({"application/json"})
	public String createGod(String user) {
		return service.createUser(user);
	}
	
	@Path("/deleteUser/{userID}")
	@DELETE
	@Produces({"application/json"})
	public String deleteUser(@PathParam("userID")Long userID) {
		return service.deleteUser(userID);
	}

}
