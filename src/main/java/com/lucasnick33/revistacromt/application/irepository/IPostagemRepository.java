package com.lucasnick33.revistacromt.application.irepository;

import java.util.List;

import com.lucasnick33.revistacromt.application.modelos.FiltroPostagem;
import com.lucasnick33.revistacromt.domain.entidades.Postagem;

public interface IPostagemRepository extends IRepositoryBase<Postagem> {

	public List<Postagem> select(FiltroPostagem filtro);
	
}
