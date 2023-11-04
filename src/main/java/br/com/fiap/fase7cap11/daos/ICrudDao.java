package br.com.fiap.fase7cap11.daos;

import java.util.List;

public interface ICrudDao<T> {
	
	List<T> getAll();
	T getById(Long id);
	void save(T t);
	void delete(Long id);
}
