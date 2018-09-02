package com.lucasnick33.revistacromt.domain.enums;

public enum TipoPermissao {
	
	VISUALIZAR(1, "Visualizar"),
	CRIAR(2, "Criar"),
	PUBLICAR(3, "Publicar"),
	APROVAR(4, "Aprovar");
	
	private Integer id;
	private String nome;
	
	private TipoPermissao(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
}
