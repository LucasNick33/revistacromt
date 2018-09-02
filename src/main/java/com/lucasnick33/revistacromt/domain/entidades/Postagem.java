package com.lucasnick33.revistacromt.domain.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "postagem")
public class Postagem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	public static final String PROP_ID = "id";
	
	@Column(name = "id_usuario")
	private Integer idUsuario;
	public static final String PROP_ID_USUARIO = "idUsuario";
	
	@Column(name = "id_time_line")
	private Integer idTimeLine;
	public static final String PROP_ID_TIME_LINE = "idTimeLine";
	
	@Column(name = "titulo")
	private String titulo;
	public static final String PROP_TITULO = "titulo";
	
	@Column(name = "data_publicacao")
	private Date dataPublicacao;
	public static final String PROP_DATA_PUBLICACAO = "dataPublicacao";
	
	@Column(name = "palavras_chave")
	private String palavrasChave;
	public static final String PROP_PALAVRAS_CHAVE = "palavrasChave";
	
	@Column(name = "conteudo")
	private String conteudo;
	public static final String PROP_CONTEUDO = "conteudo";
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
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
	
	public Date getDataPublicacao() {
		return dataPublicacao;
	}
	
	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	
	public String getPalavrasChave() {
		return palavrasChave;
	}

	public void setPalavrasChave(String palavrasChave) {
		this.palavrasChave = palavrasChave;
	}

	public String getConteudo() {
		return conteudo;
	}
	
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
}
