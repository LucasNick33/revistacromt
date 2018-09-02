package com.lucasnick33.revistacromt.repository;

import java.util.List;

import com.lucasnick33.revistacromt.application.irepository.IPermissaoRepository;
import com.lucasnick33.revistacromt.domain.entidades.Permissao;

public class PermissaoRepository extends RepositoryBase<Permissao> implements IPermissaoRepository {

	public PermissaoRepository(Conexao con) {
		super(Permissao.class, con);
	}

	public Permissao selectPorId(Integer valor) {
		return super.selectPorId(Permissao.PROP_ID, valor);
	}

	public List<Permissao> select(Integer offset, Integer limit) {
		return super.select(null, null, null, null, null, offset, limit);
	}
	
}
