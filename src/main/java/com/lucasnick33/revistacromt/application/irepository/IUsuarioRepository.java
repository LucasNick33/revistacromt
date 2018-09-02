package com.lucasnick33.revistacromt.application.irepository;

import java.util.List;

import com.lucasnick33.revistacromt.application.modelos.FiltroUsuario;
import com.lucasnick33.revistacromt.domain.entidades.Usuario;

public interface IUsuarioRepository extends IRepositoryBase<Usuario> {

	public List<Usuario> select(FiltroUsuario filtro);
	
}
