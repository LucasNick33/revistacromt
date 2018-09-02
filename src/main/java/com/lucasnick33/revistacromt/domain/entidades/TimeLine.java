package com.lucasnick33.revistacromt.domain.entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "time_line")
public class TimeLine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	public static final String PROP_ID = "id";
	
	@Column(name = "nome")
	private String nome;
	public static final String PROP_NOME = "nome";
	
	@Column(name = "posicao")
	private Integer posicao;
	public static final String PROP_POSICAO = "posicao";
	
	@Column(name = "publica")
	private Boolean publica;
	public static final String PROP_PUBLICA = "publica";
	
	@OneToMany(targetEntity = Permissao.class,
			mappedBy = "idTimeLine",
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY)
	private List<Permissao> permissoes;
	
	@OneToMany(targetEntity = Postagem.class,
			mappedBy = "idTimeLine",
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY)
	private List<Postagem> postagens;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Integer getPosicao() {
		return posicao;
	}
	
	public void setPosicao(Integer posicao) {
		this.posicao = posicao;
	}

	public Boolean isPublica() {
		return publica;
	}

	public void setPublica(Boolean publica) {
		this.publica = publica;
	}

	public List<Permissao> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(List<Permissao> permissoes) {
		this.permissoes = permissoes;
	}

	public List<Postagem> getPostagens() {
		return postagens;
	}

	public void setPostagens(List<Postagem> postagens) {
		this.postagens = postagens;
	}
	
}
