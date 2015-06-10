package br.com.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import br.com.model.Researcher;
import br.com.service.LoginService;
import br.com.service.ProjectService;

@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
public class LoginResource {
	private LoginService loginService = new LoginService();

	
	public LoginResource() {
		this.loginService = new LoginService();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addResearcher(Researcher researcher){
		System.out.println(researcher);
		this.loginService.insert(researcher);
		return Response.created(UriBuilder.fromPath("/login/{id}").build(researcher)).build();
	}
	
	@Path("/{id}")
	@GET
	public String getProject(@PathParam("id") Integer id) {
		return "Login " + id;
	}
}
