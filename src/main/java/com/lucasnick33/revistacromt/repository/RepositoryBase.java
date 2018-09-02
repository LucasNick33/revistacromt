package com.lucasnick33.revistacromt.repository;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.lucasnick33.revistacromt.application.irepository.IConexao;
import com.lucasnick33.revistacromt.application.irepository.IRepositoryBase;
import com.lucasnick33.revistacromt.repository.util.RepositoryUtils;

import antlr.StringUtils;

public abstract class RepositoryBase<T> extends RepositoryUtils implements IRepositoryBase<T> {

	private IConexao con;
	private Class<T> tipo;

	public RepositoryBase(Class<T> tipo, IConexao con) {
		this.con = con;
		this.tipo = tipo;
	}

	public void insert(T entidade) {
		EntityTransaction transaction = null;
		try {
			transaction = con.getSession().beginTransaction();
			con.getSession().save(entidade);
			transaction.commit();
		} catch (PersistenceException ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw ex;
		}
	}

	public void update(T entidade) {
		EntityTransaction transaction = null;
		try {
			transaction = con.getSession().beginTransaction();
			con.getSession().update(entidade);
			transaction.commit();
		} catch (PersistenceException ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw ex;
		}
	}

	public void delete(T entidade) {
		EntityTransaction transaction = null;
		try {
			transaction = con.getSession().beginTransaction();
			con.getSession().delete(entidade);
			transaction.commit();
		} catch (PersistenceException ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw ex;
		}
	}

	protected T selectPorId(String propriedade, Integer valor) {
		String hql = concat("FROM ", tipo.getSimpleName(), " T WHERE T.", propriedade, " = ?0");
		System.out.println(hql);
		Query query = con.getSession().createQuery(hql);
		query.setParameter(0, valor);
		List resultado = query.getResultList();
		if (resultado == null || resultado.isEmpty()) {
			return null;
		}
		for (Object entidade : resultado) {
			System.out.println(entidade);
		}
		return (T) resultado.get(0);
	}

	protected List<T> select(String select, String from, String where, String groupBy, String orderBy, Integer offset,
			Integer limit, Object... parametros) {
		from = from == null ? tipo.getSimpleName() : from;
		StringBuilder hql = new StringBuilder();
		if (select != null && !select.trim().isEmpty()) {
			hql.append("SELECT ");
			hql.append(select.trim());
			hql.append(" ");
		}
		hql.append("FROM ");
		hql.append(from.trim());
		if (where != null && !where.trim().isEmpty()) {
			where = where.trim();
			if (where.toUpperCase().startsWith("AND")) {
				where = where.substring(3);
			} else if (where.toUpperCase().startsWith("OR")) {
				where = where.substring(2);
			}
			hql.append(" WHERE ");
			hql.append(where.trim());
		}
		if (groupBy != null && !groupBy.trim().isEmpty()) {
			hql.append(" GROUP BY ");
			hql.append(groupBy.trim());
		}
		if (orderBy != null && !orderBy.trim().isEmpty()) {
			hql.append(" ORDER BY ");
			hql.append(orderBy.trim());
		}
		System.out.println(hql);
		Query query = con.getSession().createQuery(hql.toString());
		parametros = parametros == null ? new Object[] {} : parametros;
		for (int i = 0; i < parametros.length; i++) {
			query.setParameter(i, parametros[i]);
		}
		offset = offset == null ? 0 : offset;
		limit = limit == null ? 0 : limit;
		limit = limit > 100 ? 100 : limit;
		query.setFirstResult(offset);
		query.setMaxResults(limit);
		List resultado = query.getResultList();
		if (resultado == null) {
			resultado = new ArrayList<T>();
		}
		for (Object entidade : resultado) {
			System.out.println(entidade);
		}
		return resultado;
	}

}
