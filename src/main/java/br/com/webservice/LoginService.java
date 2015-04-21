package br.com.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import br.com.model.Usuario;

@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
public class LoginService {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addProject(Usuario usuario){
		System.out.println(usuario);
		return Response.created(UriBuilder.fromPath("/login/{id}").build(usuario)).build();
	}
}
