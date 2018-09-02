package com.lucasnick33.revistacromt.application.modelos;

public class FiltroUsuario {

	private String nome;
	private String email;
	private Boolean administrador;
	private Integer registroInicial;
	private Integer qtdRegistros;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean isAdministrador() {
		return administrador;
	}

	public void setAdministrador(Boolean administrador) {
		this.administrador = administrador;
	}

	public Integer getRegistroInicial() {
		return registroInicial;
	}

	public void setRegistroInicial(Integer registroInicial) {
		this.registroInicial = registroInicial;
	}

	public Integer getQtdRegistros() {
		return qtdRegistros;
	}

	public void setQtdRegistros(Integer qtdRegistros) {
		this.qtdRegistros = qtdRegistros;
	}

}
