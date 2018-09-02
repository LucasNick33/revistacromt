package com.lucasnick33.revistacromt.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lucasnick33.revistacromt.application.irepository.IConexao;

public class Conexao implements IConexao {

	private SessionFactory sessionFactory;
	private Session sessao;

	public Conexao() {
		try {
			Configuration cfg = new Configuration().configure("/com/lucasnick33/revistacromt/repository/hibernate.cfg.xml");
			sessionFactory = cfg.buildSessionFactory();
		} catch (HibernateException th) {
			System.err.println("Enitial SessionFactory creation failed" + th);
			throw new ExceptionInInitializerError(th);
		}
	}

	public Session getSession() {
		sessao = sessao == null ? sessionFactory.openSession() : sessao;
		sessao = sessao.isConnected() ? sessao : sessionFactory.openSession();
		return sessao;
	}

}
