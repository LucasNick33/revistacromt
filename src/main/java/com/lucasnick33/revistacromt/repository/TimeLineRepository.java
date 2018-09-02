package com.lucasnick33.revistacromt.repository;

import java.util.List;

import com.lucasnick33.revistacromt.application.irepository.IConexao;
import com.lucasnick33.revistacromt.application.irepository.ITimeLineRepository;
import com.lucasnick33.revistacromt.domain.entidades.TimeLine;

public class TimeLineRepository extends RepositoryBase<TimeLine> implements ITimeLineRepository {

	public TimeLineRepository(IConexao con) {
		super(TimeLine.class, con);
	}

	public TimeLine selectPorId(Integer valor) {
		return super.selectPorId(TimeLine.PROP_ID, valor);
	}

	public List<TimeLine> select(Integer offset, Integer limit) {
		return super.select(null, null, null, null, TimeLine.PROP_POSICAO, offset, limit);
	}

}
