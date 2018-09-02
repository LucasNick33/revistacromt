package com.lucasnick33.revistacromt.domain.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.lucasnick33.revistacromt.domain.enums.TipoPermissao;

@Entity
@Table(name = "permissao")
public class Permissao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	public static final String PROP_ID = "id";
	
	@Column(name = "id_time_line")
	private Integer idTimeLine;
	public static final String PROP_ID_TIME_LINE = "idTimeLine";
	
	@Column(name = "id_usuario")
	private Integer idUsuario;
	public static final String PROP_ID_USUARIO = "idUsuario";
	
	@Column(name = "tipo")
	@Enumerated(EnumType.STRING)
	private TipoPermissao tipo;
	public static final String PROP_TIPO = "tipo";

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdTimeLine() {
		return idTimeLine;
	}

	public void setIdTimeLine(Integer idTimeLine) {
		this.idTimeLine = idTimeLine;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public TipoPermissao getTipo() {
		return tipo;
	}

	public void setTipo(TipoPermissao tipo) {
		this.tipo = tipo;
	}
	
}
