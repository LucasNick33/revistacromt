package com.lucasnick33.revistacromt.repository;

import java.util.List;

import com.lucasnick33.revistacromt.application.irepository.IConexao;
import com.lucasnick33.revistacromt.application.irepository.IPostagemRepository;
import com.lucasnick33.revistacromt.application.modelos.FiltroPostagem;
import com.lucasnick33.revistacromt.domain.entidades.Postagem;
import com.lucasnick33.revistacromt.domain.entidades.TimeLine;
import com.lucasnick33.revistacromt.domain.entidades.Usuario;
import com.lucasnick33.revistacromt.repository.util.ConstrutorReplace;
import com.lucasnick33.revistacromt.repository.util.Where;

public class PostagemRepository extends RepositoryBase<Postagem> implements IPostagemRepository {

	public PostagemRepository(IConexao con) {
		super(Postagem.class, con);
	}

	public Postagem selectPorId(Integer id) {
		return super.selectPorId(Postagem.PROP_ID, id);
	}
	
	public List<Postagem> select(Integer offset, Integer limit) {
		return super.select(null, null, null, null, Postagem.PROP_DATA_PUBLICACAO, offset, limit);
	}
	
	public List<Postagem> select(FiltroPostagem filtro) {
		ConstrutorReplace cr = new ConstrutorReplace();
		cr.addClasse(Usuario.class, "Usuario", "U");
		cr.addPropriedade(Usuario.class, Usuario.PROP_ID, "id");
		cr.addPropriedade(Usuario.class, Usuario.PROP_NOME, "nome");
		cr.addClasse(TimeLine.class, "TimeLine", "TL");
		cr.addPropriedade(TimeLine.class, TimeLine.PROP_ID, "id");
		cr.addClasse(Postagem.class, "Postagem", "P");
		cr.addPropriedade(Postagem.class, Postagem.PROP_ID_USUARIO, "idUsuario");
		cr.addPropriedade(Postagem.class, Postagem.PROP_ID_TIME_LINE, "idTimeLine");
		cr.addPropriedade(Postagem.class, Postagem.PROP_DATA_PUBLICACAO, "dataPublicacao");
		cr.addPropriedade(Postagem.class, Postagem.PROP_PALAVRAS_CHAVE, "palavrasChave");
		cr.addPropriedade(Postagem.class, Postagem.PROP_TITULO, "titulo");
		
		String from = "[Postagem] P INNER JOIN [TimeLine] TL ON [P.idTimeLine] = [TL.id]";
		from += join(" INNER JOIN [Usuario] U ON [U.id] = [P.idUsuario]", filtro.getNomeUsuario());
		
		StringBuilder txtWhere = new StringBuilder();
		Where where = new Where();
		txtWhere.append(where.add("[TL.id] = ?", filtro.getIdTimeLine()));
		txtWhere.append(where.add(" AND [U.nome] LIKE ?", filtro.getNomeUsuario()));
		txtWhere.append(where.add(" AND [P.dataPublicacao] >= ?", filtro.getDataInicial()));
		txtWhere.append(where.add(" AND [P.dataPublicacao] <= ?", filtro.getDataFinal()));
		txtWhere.append(where.add(" AND [P.titulo] LIKE ?", filtro.getTitulo()));
		String palavrasChave = where.add("[P.palavrasChave] LIKE ?", filtro.getPalavrasChave(), " OR ");
		txtWhere.append(join(concat(" AND (", palavrasChave, ") "), filtro.getPalavrasChave().toArray()));
		
		String orderBy = "[P.dataPublicacao] DESC";
		
		return super.select(null, cr.replace(from), cr.replace(txtWhere.toString()), null, cr.replace(orderBy), 
				filtro.getRegistroInicial(), filtro.getQtdRegistros(), where.getParametros().toArray());
	}
	
}
