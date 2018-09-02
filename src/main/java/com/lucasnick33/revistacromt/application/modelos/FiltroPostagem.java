package com.lucasnick33.revistacromt.application.modelos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FiltroPostagem {

	private Integer idTimeLine;
	private String titulo;
	private List<String> palavrasChave;
	private Date dataInicial;
	private Date dataFinal;
	private String nomeUsuario;
	private Integer registroInicial;
	private Integer qtdRegistros;

	public FiltroPostagem() {
		this.palavrasChave = new ArrayList<String>();
	}
	
	public Integer getIdTimeLine() {
		return idTimeLine;
	}

	public void setIdTimeLine(Integer idTimeLine) {
		this.idTimeLine = idTimeLine;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<String> getPalavrasChave() {
		return palavrasChave;
	}

	public void setPalavrasChave(List<String> palavrasChave) {
		this.palavrasChave = palavrasChave;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
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
