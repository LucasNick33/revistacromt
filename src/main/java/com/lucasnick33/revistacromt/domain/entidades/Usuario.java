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
@Table(name = "usuario")
public class Usuario {
	
	@Id()
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	public static final String PROP_ID = "id";
	
	@Column(name = "nome", nullable = false)
	private String nome;
	public static final String PROP_NOME = "nome";
	
	@Column(name = "email", nullable = false)
	private String email;
	public static final String PROP_EMAIL = "email";
	
	@Column(name = "senha", nullable = false)
	private String senha;
	public static final String PROP_SENHA = "senha";
	
	@Column(name = "administrador", nullable = false)
	private Boolean administrador;
	public static final String PROP_ADMINISTRADOR = "administrador";
	
	@OneToMany(targetEntity = Permissao.class,
			mappedBy = "idUsuario",
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY)
	private List<Permissao> permissoes;
	
	@OneToMany(targetEntity = Postagem.class,
			mappedBy = "idUsuario",
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY)
	private List<Postagem> postagens;
	
	public Usuario() {
		this.administrador = false;
	}
	
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean isAdministrador() {
		return administrador;
	}

	public void setAdministrador(Boolean administrador) {
		this.administrador = administrador;
	}

	public List<Permissao> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(List<Permissao> permissoes) {
		this.permissoes = permissoes;
	}
	
}
