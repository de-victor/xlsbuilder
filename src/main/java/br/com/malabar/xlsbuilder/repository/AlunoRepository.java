package br.com.malabar.xlsbuilder.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.malabar.xlsbuilder.entity.Aluno;
import br.com.malabar.xlsbuilder.generics.Repository;

public class AlunoRepository implements Repository<Aluno> {

	private List<Aluno> lista;
	
	public AlunoRepository() {
		lista = new ArrayList<Aluno>();
		
		lista.add(new Aluno(new Long(1), "123", "Fulano de tal", "Beltrano de tal", "123654879", "65412387"));
		lista.add(new Aluno(new Long(2), "124", "Belagela Lilis", "Nininho Lureco", "458765", "975875"));
	}
	
	@Override
	public Aluno getById(Long id) {		

		return this.lista
				   .stream()
				   .filter(obj -> obj.getId() == id)
				   .collect(Collectors.toList())
				   .stream()
				   .findFirst()
				   .get();
	}

	@Override
	public List<Aluno> getAll() {
		return this.lista;
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}

}
