package br.com.malabar.xlsbuilder.generics;

import java.util.List;

public interface Repository<Entity> {
	
	
	Entity getById(Long id);
	
	List<Entity> getAll();
	
	void remove(Long id);
	
}
