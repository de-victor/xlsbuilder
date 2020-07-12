package br.com.malabar.xlsbuilder.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import br.com.malabar.xlsbuilder.entity.Aluno;
import br.com.malabar.xlsbuilder.repository.AlunoRepository;
import br.com.malabar.xlsbuilder.utils.XlsMaker;

public class XlsTestService {
	
	private AlunoRepository alunoRepository = new AlunoRepository();
	
	
	public void buildXlsFile() throws Exception {
		File file = new File("tmp.xls");
		List<List<String>> data = loadData(alunoRepository.getAll());
		
		XlsMaker.createWorkbook(file)
		        .createSheet("Relatório", 0)
		        .createHeader(new String[]{"id", "matricula", "nome", "responsavel", "tel1", "tel2"})
		        .fillData(data)
		        .buildAndWriteFile();
		
	}


	private List<List<String>> loadData(List<Aluno> alunos) {
		List<List<String>> lista = new ArrayList<List<String>>();
		
		alunos.forEach(item->{
			List<String> row = new ArrayList<String>();
			row.add(item.getId().toString());
			row.add(item.getMatricula());
			row.add(item.getNome());
			row.add(item.getResponsavel());
			row.add(item.getTelefone1());
			row.add(item.getTelefone2());
			lista.add(row);
		});
		
		
		return lista;
	}

}
