package com.lucasnick33.revistacromt.repository;

import com.lucasnick33.revistacromt.application.irepository.IConexao;
import com.lucasnick33.revistacromt.application.irepository.IPostagemRepository;
import com.lucasnick33.revistacromt.application.irepository.IRepository;
import com.lucasnick33.revistacromt.application.irepository.IUsuarioRepository;

public class Repository implements IRepository {

	private IConexao conexao;
	private IUsuarioRepository usuarioRepository;
	private IPostagemRepository postagemRepository;
	
	public Repository() {
		conexao = new Conexao();
		usuarioRepository = new UsuarioRepository(conexao);
		postagemRepository = new PostagemRepository(conexao);
	}

	public IConexao getConexao() {
		return conexao;
	}

	public IUsuarioRepository getUsuarioRepository() {
		return usuarioRepository;
	}

	public IPostagemRepository getPostagemRepository() {
		return postagemRepository;
	}
	
}
