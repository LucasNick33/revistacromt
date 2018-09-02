package com.lucasnick33.revistacromt.application.irepository;

import java.util.List;

public interface IRepositoryBase<T> {

	public void insert(T entidade);
	
	public void update(T entidade);
	
	public void delete(T entidade);
	
	public T selectPorId(Integer valor);
	
	public List<T> select(Integer offset, Integer limit);
	
}
