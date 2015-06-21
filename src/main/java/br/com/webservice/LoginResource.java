package br.com.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriBuilder;

import com.google.gson.Gson;

import br.com.model.ErrorResponse;
import br.com.model.Researcher;
import br.com.service.LoginService;

@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
public class LoginResource {
	private LoginService loginService;

	
	public LoginResource() {
		this.loginService = new LoginService();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addResearcher(Researcher researcher){
		System.out.println(researcher);
		Researcher reasearcherCreated = this.loginService.find(researcher.getEmail());
		if(reasearcherCreated == null){
			this.loginService.insert(researcher);
			return Response.created(UriBuilder.fromPath("/login/{id}").build(researcher)).build();
		}else{
			ErrorResponse error = new ErrorResponse("1", "Account already created");
			return Response.serverError().entity(new Gson().toJson(error)).build();
		}
	}
	
	@Path("/{id}")
	@GET
	public String getResearcher(@PathParam("id") Integer id) {
		return "Login " + id;
	}
}
