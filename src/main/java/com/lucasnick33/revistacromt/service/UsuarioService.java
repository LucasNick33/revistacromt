package com.lucasnick33.revistacromt.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.lucasnick33.revistacromt.application.UsuarioApp;
import com.lucasnick33.revistacromt.application.modelos.FiltroUsuario;
import com.lucasnick33.revistacromt.domain.entidades.Usuario;

@Path("/usuario")
public class UsuarioService {

	private UsuarioApp usuarioApp;
	
	public UsuarioService() {
		this.usuarioApp = new UsuarioApp();
	}
	
	@GET
	@Path("/buscarPorId")
	@Produces({MediaType.APPLICATION_JSON})
	public Usuario buscarPorId(@PathParam("id") int id) {
		return usuarioApp.get(id);
	}
	
	@GET
	@Path("/listar")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Usuario> listar(@PathParam("offset") int offset, @PathParam("limit") int limit) {
		return usuarioApp.listar(offset, limit);
	}
	
	@POST
	@Path("/buscar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public List<Usuario> buscar(FiltroUsuario filtro) {
		return usuarioApp.buscar(filtro);
	}
	
	@PUT
	@Path("/inserir")
	@Consumes({MediaType.APPLICATION_JSON})
	public String inserir(Usuario usuario) {
		usuarioApp.inserir(usuario);
		return "Usuário cadastrado com sucesso!";
	}
	
	@PUT
	@Path("/atualizar")
	@Consumes({MediaType.APPLICATION_JSON})
	public String atualizar(Usuario usuario) {
		usuarioApp.atualizar(usuario);
		return "Usuário atualizado com sucesso!";
	}
	
	@DELETE
	@Path("/atualizar")
	public String excluir(@PathParam("id") int id) {
		usuarioApp.excluir(id);
		return "Usuário excluído com sucesso!";
	}
	
}
