package uk.sevensixtwo.backend.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import uk.sevensixtwo.backend.service.projectService;

@Path("/project")
public class projectEndpoint {
	@Inject
	private projectService service;
	
	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public String getAllProjects(){
		return service.listAllProjects();
	}
	
	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public String getProjectByID(@PathParam("id") Long projectID){
		return service.listProjectByID(projectID);
	}
}
