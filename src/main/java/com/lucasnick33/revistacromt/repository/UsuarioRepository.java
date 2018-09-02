package com.lucasnick33.revistacromt.repository;

import java.util.List;

import com.lucasnick33.revistacromt.application.irepository.IConexao;
import com.lucasnick33.revistacromt.application.irepository.IUsuarioRepository;
import com.lucasnick33.revistacromt.application.modelos.FiltroUsuario;
import com.lucasnick33.revistacromt.domain.entidades.Usuario;
import com.lucasnick33.revistacromt.repository.util.ConstrutorReplace;
import com.lucasnick33.revistacromt.repository.util.Where;

public class UsuarioRepository extends RepositoryBase<Usuario> implements IUsuarioRepository {

	public UsuarioRepository(IConexao con) {
		super(Usuario.class, con);
	}

	public Usuario selectPorId(Integer valor) {
		return super.selectPorId(Usuario.PROP_ID, valor);
	}

	public List<Usuario> select(Integer offset, Integer limit) {
		return super.select(null, null, null, null, Usuario.PROP_NOME, offset, limit);
	}

	public List<Usuario> select(FiltroUsuario filtro) {
		ConstrutorReplace cr = new ConstrutorReplace();
		cr.addClasse(Usuario.class, "Usuario", "U");
		cr.addPropriedade(Usuario.class, Usuario.PROP_ADMINISTRADOR, "adm");
		cr.addPropriedade(Usuario.class, Usuario.PROP_NOME, "nome");
		cr.addPropriedade(Usuario.class, Usuario.PROP_EMAIL, "email");
		
		StringBuilder sbWhere = new StringBuilder();
		
		Where where = new Where();
		sbWhere.append(where.add("[U.adm] IS ?", filtro.isAdministrador()));
		sbWhere.append(where.add(" AND [U.nome] LIKE ?", filtro.getNome()));
		sbWhere.append(where.add(" AND [U.email] LIKE ?", filtro.getEmail()));

		return super.select(null, cr.replace("[Usuario] U"), cr.replace(sbWhere.toString()), null, Usuario.PROP_NOME, 
				filtro.getRegistroInicial(), filtro.getQtdRegistros(), where.getParametros().toArray());
	}
	
}
