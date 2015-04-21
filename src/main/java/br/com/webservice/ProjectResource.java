package br.com.webservice;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import br.com.model.Projeto;
import br.com.service.ProjetoService;

@Path("/project")
@Produces(MediaType.APPLICATION_JSON)
public class ProjectResource {

	private ProjetoService projetoService;
	
	public ProjectResource() {
		this.projetoService = new ProjetoService();
	}
	
	
	@GET
	public List<Projeto> getPlain() {
		return projetoService.getAll();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addProject(Projeto projeto){
		System.out.println(projeto);
		projetoService.inserir(projeto);
		return Response.created(UriBuilder.fromPath("/project/{id}").build(projeto)).build();
	}
	
	@Path("/{id}")
	@GET
	public String getProject(@PathParam("id") Integer id) {
		return "Projeto " + id;
	}
}
