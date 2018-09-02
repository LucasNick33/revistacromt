package com.lucasnick33.revistacromt.application;

import java.util.List;

import com.lucasnick33.revistacromt.application.irepository.IUsuarioRepository;
import com.lucasnick33.revistacromt.application.modelos.FiltroUsuario;
import com.lucasnick33.revistacromt.domain.entidades.Usuario;

public class UsuarioApp extends App {

	private IUsuarioRepository usuarioRepository;

	public UsuarioApp() {
		this.usuarioRepository = super.getRepositorio().getUsuarioRepository();
	}

	public Usuario get(int id) {
		return usuarioRepository.selectPorId(id);
	}

	public List<Usuario> listar(int offset, int limit) {
		return usuarioRepository.select(offset, limit);
	}

	public List<Usuario> buscar(FiltroUsuario filtro) {
		return usuarioRepository.select(filtro);
	}

	public void inserir(Usuario usuario) {
		usuarioRepository.insert(usuario);
	}

	public void atualizar(Usuario usuario) {
		usuarioRepository.update(usuario);
	}

	public void excluir(int id) {
		Usuario usuario = new Usuario();
		usuario.setId(id);
		usuarioRepository.delete(usuario);
	}

}
