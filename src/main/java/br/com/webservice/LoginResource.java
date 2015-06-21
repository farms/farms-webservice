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

import br.com.core.OperationException;
import br.com.model.ErrorResponse;
import br.com.model.Researcher;
import br.com.service.LoginService;

import com.google.gson.Gson;

@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
public class LoginResource {
	private LoginService loginService;
	public final static  String ACCOUNT_ALREADY_CREATED = "1";
	public final static  String ACCOUNT_NOT_EXISTS = "2";
	public final static  String PASSWORD_NOT_MATCHES = "3";
	
	public LoginResource() {
		this.loginService = new LoginService();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addResearcher(Researcher researcher){
		System.out.println(researcher);
		try {
			this.loginService.insert(researcher);
			return Response.created(UriBuilder.fromPath("/login/{id}").build(researcher)).build();
		} catch (OperationException e) {
			ErrorResponse error = new ErrorResponse(e.getCode(), e.getMessage());
			return Response.serverError().entity(new Gson().toJson(error)).build();
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response login(Researcher researcher){
		System.out.println(researcher);
		try {
			loginService.login(researcher);
			return Response.ok().build();
		} catch (OperationException e) {
			ErrorResponse error = new ErrorResponse(e.getCode(), e.getMessage());
			return Response.serverError().entity(new Gson().toJson(error)).build();
		}
	}
	
	@Path("/{id}")
	@GET
	public String getResearcher(@PathParam("id") Integer id) {
		return "Login " + id;
	}
}
