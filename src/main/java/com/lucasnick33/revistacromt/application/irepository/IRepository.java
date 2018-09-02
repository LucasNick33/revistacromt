package com.lucasnick33.revistacromt.application.irepository;

public interface IRepository {

	public IConexao getConexao();

	public IUsuarioRepository getUsuarioRepository();

	public IPostagemRepository getPostagemRepository();
	
}
