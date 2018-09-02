package com.lucasnick33.revistacromt.application;

import java.util.Arrays;

import com.lucasnick33.revistacromt.application.irepository.IRepository;
import com.lucasnick33.revistacromt.application.modelos.FiltroPostagem;
import com.lucasnick33.revistacromt.application.modelos.FiltroUsuario;
import com.lucasnick33.revistacromt.domain.entidades.Usuario;

public class App 
{
	
	private static IRepository repositorio;
	
	public IRepository getRepositorio() {
		if (repositorio == null) {
			try {
				repositorio = (IRepository) Class.forName("com.lucasnick33.revistacromt.repository.Repository").newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return repositorio;
	}
    
	public static void main(String[] args) {
		App app = new App();
		app.getRepositorio();
		
//		FiltroPostagem filtro = new FiltroPostagem();
//		filtro.setNomeUsuario("%Lucas%");
//		filtro.setPalavrasChave(Arrays.asList(new String[]{"palavra", "chave"}));
//		filtro.setTitulo("postagem");
//		repositorio.getPostagemRepository().select(filtro);
		
//		FiltroUsuario filtro = new FiltroUsuario();
//		filtro.setAdministrador(true);
//		filtro.setNome("%lu%");
//		repositorio.getUsuarioRepository().select(filtro);
		
		Usuario usuario = repositorio.getUsuarioRepository().selectPorId(1);
		System.out.println(usuario.getNome());
		for (Usuario u : repositorio.getUsuarioRepository().select(0, 1000)) {
			System.out.println(u.getNome());
		}
	}
	
}
